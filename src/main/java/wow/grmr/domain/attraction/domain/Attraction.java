package wow.grmr.domain.attraction.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "attractions")
@NoArgsConstructor(access = PROTECTED)
public class Attraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;
    private String title;
    private Integer contentTypeId;
    private Integer areaCode;
    private String firstImage1;
    private String firstImage2;
    private Integer mapLevel;
    private BigDecimal latitude;
    private BigDecimal  longitude;
    private String addr1;

    @Builder
    public Attraction(Integer no,
                      String title,
                      Integer contentTypeId,
                      Integer areaCode,
                      String firstImage1,
                      String firstImage2,
                      Integer mapLevel,
                      BigDecimal latitude,
                      BigDecimal longitude,
                      String addr1) {
        this.no = no;
        this.title = title;
        this.contentTypeId = contentTypeId;
        this.areaCode = areaCode;
        this.firstImage1 = firstImage1;
        this.firstImage2 = firstImage2;
        this.mapLevel = mapLevel;
        this.latitude = latitude;
        this.longitude = longitude;
        this.addr1 = addr1;
    }
}



