package lee.newscriber.dto.source;

import lee.newscriber.domain.Source;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class SourceListResponse {
    private List<SourceElement> sources;

    public static SourceListResponse from(List<Source> sources) {
        return null;
    }
}
