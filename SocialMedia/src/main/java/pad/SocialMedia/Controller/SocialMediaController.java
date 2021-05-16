package pad.SocialMedia.Controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pad.SocialMedia.Service.SocialMediaService;
import pad.SocialMedia.dto.SocialMediaDto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping("/SocialMedia")
@AllArgsConstructor
@Slf4j
@CrossOrigin()
public class SocialMediaController {

    private final SocialMediaService socialMediaService;

    @PostMapping
    public ResponseEntity<SocialMediaDto> createSocialMedia(@RequestBody SocialMediaDto socialMediaDto) {
        System.out.println(socialMediaDto);

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

    @GetMapping("/nrt/{name}")
    public ResponseEntity<List<SocialMediaDto>> getAllSocialMediaName(@PathVariable String name) {

        System.out.println(socialMediaService
                .getAll()
                .stream()
                .filter( u -> u.getUserName().equals(name))
                .collect(Collectors.toList()));
        return
                ResponseEntity
                        .status(HttpStatus.OK)
                        .body(socialMediaService
                                .getAll()
                                .stream()
                                .filter( u -> u.getUserName().equals(name))
                                .collect(Collectors.toList())
                        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocialMediaDto> getSocialMedia(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(socialMediaService.getSocialMediaDto(id));
    }


    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteSocialMedia(@PathVariable Long id)
    {
        socialMediaService.deleteSocialMedia(id);
        return "Deleted succesfully";
    }


}
