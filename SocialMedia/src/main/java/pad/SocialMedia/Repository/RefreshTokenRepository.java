package pad.SocialMedia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pad.SocialMedia.Model.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    void deleteByToken(String token);
}
