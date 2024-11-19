package wow.grmr.domain.attraction.service;


import wow.grmr.domain.attraction.domain.Attraction;
import wow.grmr.domain.attraction.presentation.dto.response.AttractionDto;

import java.util.List;

public interface AttractionUtils {

    List<AttractionDto> getRandomAttractions(Integer areaCode);

}
