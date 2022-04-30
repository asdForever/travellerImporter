package kz.homework.travellerstaticcontentimporter.service;

import kz.homework.travellerstaticcontentimporter.controller.MessageSender;
import kz.homework.travellerstaticcontentimporter.dto.CountryDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public record CountryService(FileReaderService fileReaderService, CountryConverterService countryConverterService, MessageSender messageSender) {

    public void importCountries() {
        final List<CountryDTO> countries = getAllCountries();
        sendCountriesToMQ(countries);
    }

    private List<CountryDTO> getAllCountries() {
        final List<CountryDTO> result = new ArrayList<>();

        final List<String> countriesStringList = fileReaderService.getLinesFromFile("countries.txt");
        for (String country : countriesStringList) {
            final CountryDTO countryDTO = countryConverterService.convert(country);
            result.add(countryDTO);
        }

        return result;
    }

    private void sendCountriesToMQ(final List<CountryDTO> countries) {
        countries.forEach(messageSender::broadcastCountry);
    }
}
