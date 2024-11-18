package wow.grmr.domain.attraction.service;


import wow.grmr.domain.attraction.domain.Attraction;

import java.util.List;

public interface AttractionUtils {

    List<Attraction> getRandomAttractions(Integer areaCode);

}
