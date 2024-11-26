package wow.grmr.domain.attraction.service;

import wow.grmr.domain.attraction.presentation.dto.response.AttractionDto;
import wow.grmr.domain.user.presentation.dto.response.LoginResponse;
import wow.grmr.global.common.Area;

import java.util.List;

public interface AttractionUtils {

    List<AttractionDto> getRandomAttractions(Integer areaCode, LoginResponse loginResponse);
}
