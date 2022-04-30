package kz.homework.travellerstaticcontentimporter.service;

import kz.homework.travellerstaticcontentimporter.dto.CountryDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryConverterService implements Converter<String, CountryDTO> {

    @Override
    public CountryDTO convert(String source) {

        final List<String> fields = Arrays.stream(source.split("\\t")).toList();
        final CountryDTO.CountryDTOBuilder builder = CountryDTO.builder()
                .iso(fields.get(0))
                .iso3(fields.get(1))
                .isoNumeric(fields.get(2))
                .fips(fields.get(3))
                .name(fields.get(4))
                .capital(fields.get(5))
                .area(fields.get(6))
                .population(fields.get(7))
                .continent(fields.get(8))
                .tld(fields.get(9))
                .currencyCode(fields.get(10))
                .currencyName(fields.get(11))
                .phone(fields.get(12))
                .postalCodeFormat(fields.get(13))
                .postalCodeRegex(fields.get(14))
                .languages(fields.get(15));

        if (fields.size() > 16) {
            builder.geonameId(fields.get(16));
        }
        if (fields.size() > 17) {
            builder.neighbours(fields.get(17));
        }
        if (fields.size() > 18) {
            builder.equivalentFipsCode(fields.get(18));
        }

        return builder.build();
    }
}
