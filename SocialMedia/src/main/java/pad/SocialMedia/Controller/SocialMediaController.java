package pad.SocialMedia.Controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pad.SocialMedia.Service.SocialMediaService;
import pad.SocialMedia.dto.SocialMediaDto;

import java.util.List;

@RestController
@RequestMapping("/SocialMedia")
@AllArgsConstructor
@Slf4j
@CrossOrigin()
public class SocialMediaController {

    private final SocialMediaService socialMediaService;

    @PostMapping
    public ResponseEntity<SocialMediaDto> createSocialMedia(@RequestBody SocialMediaDto socialMediaDto) {
        return
                ResponseEntity.status(HttpStatus.CREATED).body(
                        socialMediaService.save(socialMediaDto));
    }

    @GetMapping
    public ResponseEntity<List<SocialMediaDto>> getAllSocialMedia() {
        return
                ResponseEntity
                        .status(HttpStatus.OK)
                        .body(socialMediaService
                                .getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocialMediaDto> getSocialMedia(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(socialMediaService.getSocialMediaDto(id));
    }

}
