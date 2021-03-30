package pad.SocialMedia.Mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pad.SocialMedia.Model.Post;
import pad.SocialMedia.Model.SubPage;
import pad.SocialMedia.Service.SocialMediaService;
import pad.SocialMedia.dto.SocialMediaDto;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SocialMediaMapper {

    @Mapping(target = "numberOfPosts" , expression = "java(mapPosts(subpage.getPosts()))")
    SocialMediaDto mapSocialMediaDto(SubPage subPage);

    default Integer mapPosts(List<Post> number)
    {
        return number.size();
    }


}
