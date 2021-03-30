package pad.SocialMedia.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pad.SocialMedia.Mapper.SocialMediaMapper;
import pad.SocialMedia.Model.SubPage;
import pad.SocialMedia.Repository.SubPageRepository;
import pad.SocialMedia.dto.SocialMediaDto;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class SocialMediaService {

    private final SubPageRepository subPageRepository;
    @Transactional
    public SocialMediaDto save(SocialMediaDto socialMediaDto)
    {
       SubPage subPage = mapSocialMediaDto(socialMediaDto);

       SubPage save = subPageRepository.save(subPage);
       socialMediaDto.setId(save.getId());

       return socialMediaDto;

    }


    private SubPage mapSocialMediaDto(SocialMediaDto socialMediaDto) {

         return SubPage.builder()
                .name(
                        socialMediaDto.getSocialName())
                .description(
                        socialMediaDto.getDescription())
                .build();
    }

    @Transactional
    public List<SocialMediaDto> getAll() {

        return
        subPageRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    private SocialMediaDto mapToDto(SubPage subPage) {
    return SocialMediaDto.builder()
            .socialName(subPage.getName())
            .description(subPage.getDescription())
            .id(subPage.getId())
            .number(subPage.getPosts().size())
            .build();
    }
}
