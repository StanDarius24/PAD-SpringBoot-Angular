package pad.SocialMedia.Mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pad.SocialMedia.Model.Post;
import pad.SocialMedia.Model.SubPage;
import pad.SocialMedia.dto.SocialMediaDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubpageMapper {

    @Mapping(target = "number", expression = "java(mapPosts(subPage.getPosts()))")
    SocialMediaDto mapSocialMediaDto(SubPage subPage);

    default Integer mapPosts(List<Post> number)
    {
        return number.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    SubPage mapSubpage(SocialMediaDto socialMediaDto);
}
