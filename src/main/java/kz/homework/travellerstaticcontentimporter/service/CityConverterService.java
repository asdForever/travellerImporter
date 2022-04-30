package kz.homework.travellerstaticcontentimporter.service;

import kz.homework.travellerstaticcontentimporter.dto.CityDTO;
import kz.homework.travellerstaticcontentimporter.dto.CountryDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CityConverterService implements Converter<String, CityDTO> {

    @Override
    public CityDTO convert(String source) {

        final List<String> fields = Arrays.stream(source.split("\\t")).toList();
        final CityDTO.CityDTOBuilder builder = CityDTO.builder()
                .geonameid(fields.get(0))
                .name(fields.get(1))
                .asciiname(fields.get(2))
                .alternatenames(fields.get(3))
                .latitude(fields.get(4))
                .longitude(fields.get(5))
                .featureClass(fields.get(6))
                .featureCode(fields.get(7))
                .countryCode(fields.get(8))
                .cc2(fields.get(9))
                .admin1Code(fields.get(10))
                .admin2Code(fields.get(11))
                .admin3Code(fields.get(12))
                .admin4Code(fields.get(13))
                .population(fields.get(14))
                .elevation(fields.get(15));

        if (fields.size() > 16) {
            builder.dem(fields.get(16));
        }
        if (fields.size() > 17) {
            builder.timezone(fields.get(17));
        }
        if (fields.size() > 18) {
            builder.modificationDate(fields.get(18));
        }

        return builder.build();
    }
}
