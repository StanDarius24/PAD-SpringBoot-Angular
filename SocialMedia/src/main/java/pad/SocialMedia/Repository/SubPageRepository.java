package pad.SocialMedia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pad.SocialMedia.Model.SubPage;

import java.util.Optional;

@Repository
public interface SubPageRepository extends JpaRepository<SubPage, Long> {

    Optional<SubPage> findByName(String subpageName);

    void deleteById(int id);
}