package wow.grmr.domain.attraction.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import wow.grmr.domain.attraction.domain.Attraction;

import java.math.BigDecimal;
import java.util.List;


@Getter
@AllArgsConstructor
public class AttractionDto {

    private Integer no;
    private String title;
    private Integer contentTypeId;
    private Integer areaCode;
    private String firstImage1;
    private BigDecimal latitude;
    private BigDecimal  longitude;
    private String addr1;
}
