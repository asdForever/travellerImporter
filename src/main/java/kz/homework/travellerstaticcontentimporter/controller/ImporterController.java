package kz.homework.travellerstaticcontentimporter.controller;

import kz.homework.travellerstaticcontentimporter.service.CityService;
import kz.homework.travellerstaticcontentimporter.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImporterController {

    private final CityService cityService;
    private final CountryService countryService;

    @Autowired
    public ImporterController(CityService cityService, CountryService countryService) {
        this.cityService = cityService;
        this.countryService = countryService;
    }

    @GetMapping("/cities")
    public void addCities() {
        cityService.importCities();
    }

    @GetMapping("/countries")
    public void addCountries() {
        countryService.importCountries();
    }
}
