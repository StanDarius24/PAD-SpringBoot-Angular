package pad.SocialMedia.Security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pad.SocialMedia.Exceptions.MailSenderException;



import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

import java.time.Instant;


import static io.jsonwebtoken.Jwts.parserBuilder;
import static java.util.Date.from;

@Service
public class JWTProvider {

    private KeyStore keyStore;


    @PostConstruct
    public void init() {
        try {
            keyStore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream = getClass().getResourceAsStream("/springblog.jks");
            keyStore.load(resourceAsStream, "secret".toCharArray());
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
            throw new MailSenderException("Exception occurred while loading keystore", e);
        }

    }


    public String generateToken(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .setIssuedAt(from(Instant.now()))
                .signWith(getPrivateKey())
                .compact();
    }


    private PrivateKey getPrivateKey() {
        try {
            return (PrivateKey) keyStore.getKey("springblog", "secret".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new MailSenderException("Exception occured while retrieving public key from keystore", e);
        }
    }

    public boolean validateToken(String jwt) {
        parserBuilder().setSigningKey(getPublickey()).build();
        return true;
    }

    private PublicKey getPublickey() {
        try {
            return keyStore.getCertificate("springblog").getPublicKey();
        } catch (KeyStoreException e) {
            throw new MailSenderException("Exception occured while " +
                    "retrieving public key from keystore", e);
        }
    }

    public String getUsernameFromJwt(String token) {
        Claims claims = parserBuilder()
                .setSigningKey(getPublickey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }




}
