package pad.SocialMedia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthentificationResponse {
    private String authenticationToken;
    private String refreshToken;
    private Instant expiresAt;
    private String username;;

}
