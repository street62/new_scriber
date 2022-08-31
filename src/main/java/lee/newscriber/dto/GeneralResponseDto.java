package lee.newscriber.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GeneralResponseDto {
    private int statusCode;
    private String message;
}
