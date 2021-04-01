package pad.SocialMedia.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pad.SocialMedia.Exceptions.MailSenderException;
import pad.SocialMedia.Exceptions.SocialMediaException;
import pad.SocialMedia.Mapper.SubpageMapper;
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
    private final SubpageMapper subpageMapper;
    @Transactional
    public SocialMediaDto save(SocialMediaDto socialMediaDto)
    {

        SubPage save = subPageRepository.save(subpageMapper.mapSubpage(socialMediaDto));
       socialMediaDto.setId(save.getId());

       return socialMediaDto;

    }




    @Transactional
    public List<SocialMediaDto> getAll() {

        return
        subPageRepository.findAll()
                .stream()
                .map(subpageMapper::mapSocialMediaDto)
                .collect(toList());
    }

    public SocialMediaDto getSocialMediaDto(Long id) {
        SubPage subpage = subPageRepository.findById(id)
                .orElseThrow(() -> new SocialMediaException("No subreddit found with ID - " + id));
        return subpageMapper.mapSocialMediaDto(subpage);
    }


}
