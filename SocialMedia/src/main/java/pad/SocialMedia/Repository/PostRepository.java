package pad.SocialMedia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pad.SocialMedia.Model.Post;
import pad.SocialMedia.Model.SubPage;
import pad.SocialMedia.Model.User;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(SubPage subpage);

    List<Post> findByUser(User user);
}