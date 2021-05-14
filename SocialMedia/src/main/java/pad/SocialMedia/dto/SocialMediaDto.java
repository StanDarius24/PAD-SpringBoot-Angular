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
    private Integer number;
    private Long id;
    private String name;
    private String description;
    private String date;
}
