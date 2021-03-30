package pad.SocialMedia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SocialMediaDto {
    private String socialName;
    private String description;
    private Integer number;
    private Long id;

}
