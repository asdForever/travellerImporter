package kz.homework.travellerstaticcontentimporter.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CityDTO implements Serializable {

    private String geonameid;
    private String name;
    private String asciiname;
    private String alternatenames;
    private String latitude;
    private String longitude;
    private String featureClass;
    private String featureCode;
    private String countryCode;
    private String cc2;
    private String admin1Code;
    private String admin2Code;
    private String admin3Code;
    private String admin4Code;
    private String population;
    private String elevation;
    private String dem;
    private String timezone;
    private String modificationDate;
}
