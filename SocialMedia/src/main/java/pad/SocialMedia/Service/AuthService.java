package pad.SocialMedia.Service;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pad.SocialMedia.Exceptions.TokenException;
import pad.SocialMedia.Model.NotificationEmail;
import pad.SocialMedia.Model.User;
import pad.SocialMedia.Model.VerificationToken;
import pad.SocialMedia.Repository.UserRepository;
import pad.SocialMedia.Repository.VerificationTokenRepository;
import pad.SocialMedia.Security.JWTProvider;
import pad.SocialMedia.dto.AuthentificationResponse;
import pad.SocialMedia.dto.LoginRequest;
import pad.SocialMedia.dto.RegisterRequest;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {


    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository verificationTokenRepository;
    private final UserRepository userRepository;
    private final MailServices mailService;
    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;

    @Transactional
    public void signup(RegisterRequest registerRequest)
    {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false);
        userRepository.save(user);

        String token =  generateVerificationToken(user);
        mailService.sendMail(new NotificationEmail("Please Click here to activate your account ",
                user.getEmail(),"http://localhost:8080/auth/accountVerification/" + token));
    }

    private String generateVerificationToken(User user) {
        String Token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(Token);
        verificationToken.setUser(user);
        verificationTokenRepository.save(verificationToken);
        return Token;
    }

    public void verifyAccount(String token) {
       Optional <VerificationToken> vertkn = verificationTokenRepository.findByToken(token); // Returneaza Optional o smecherie
                                                        // sa fentam Null-ul (Exemplu Pdss Burger xD)

       fetchUser(vertkn.orElseThrow(() -> new TokenException("Invalid token")));
    }

    private void fetchUser(VerificationToken verificationToken) {
        String name = verificationToken.getUser().getUsername();
        User user = userRepository.findByUsername(name).orElseThrow(() -> new TokenException("User inexistent"));
        user.setEnabled(true);
        userRepository.save(user);

    }

    public AuthentificationResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
       String token = jwtProvider.generateToken(authentication);

       return new AuthentificationResponse(loginRequest.getUsername(),token);
    }
}
