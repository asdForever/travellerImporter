package kz.homework.travellerstaticcontentimporter.service;

import kz.homework.travellerstaticcontentimporter.controller.MessageSender;
import kz.homework.travellerstaticcontentimporter.dto.CityDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public record CityService(FileReaderService fileReaderService, CityConverterService cityConverterService, MessageSender messageSender) {

    public void importCities() {
        final List<CityDTO> countries = getAllCountries();
        sendCountriesToMQ(countries);
    }

    private List<CityDTO> getAllCountries() {
        final List<CityDTO> result = new ArrayList<>();

        final List<String> citiesStringList = fileReaderService.getLinesFromFile("cities15000.txt");
        for (String city : citiesStringList) {
            final CityDTO cityDTO = cityConverterService.convert(city);
            result.add(cityDTO);
        }

        return result;
    }

    private void sendCountriesToMQ(final List<CityDTO> countries) {
        countries.forEach(messageSender::broadcastCity);
    }
}
