package pad.SocialMedia.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pad.SocialMedia.Service.UserDetailsServiceImplementation;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JWTProvider provider;
    @Autowired
    private UserDetailsServiceImplementation userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String s= getJtwRequest(httpServletRequest);

        // https://docs.spring.io/spring-security-saml/docs/2.0.0.M5/api/org/springframework/security/saml/util/StringUtils.html

        if(StringUtils.hasText(s) && provider.validateToken(s)) {
            String Username = provider.getUsernameFromJwt(s);
            // now we need to load the user from database

            UserDetails userDetails = userDetailsService.loadUserByUsername(Username);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails,null,userDetails.getAuthorities()
            );

            authenticationToken.setDetails(new WebAuthenticationDetailsSource()
            .buildDetails(httpServletRequest));

        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    private String getJtwRequest(HttpServletRequest httpServletRequest) {
        String bearer =  httpServletRequest.getHeader("Authorization");
        if(StringUtils.hasText(bearer) && bearer.startsWith("Bearer "))
        {
            return bearer.substring(7);
        }
        return bearer;
    }
}
