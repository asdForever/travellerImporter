package kz.homework.travellerstaticcontentimporter.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CountryDTO implements Serializable {

    private String id;
    private String iso;
    private String iso3;
    private String isoNumeric;
    private String fips;
    private String name;
    private String capital;
    private String area; // in sq km
    private String population;
    private String continent;
    private String tld;
    private String currencyCode;
    private String currencyName;
    private String phone;
    private String postalCodeFormat;
    private String postalCodeRegex;
    private String languages;
    private String geonameId;
    private String neighbours;
    private String equivalentFipsCode;
}
