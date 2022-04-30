package kz.homework.travellerstaticcontentimporter;

import kz.homework.travellerstaticcontentimporter.service.CityService;
import kz.homework.travellerstaticcontentimporter.service.CountryService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TravellerStaticContentImporterApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravellerStaticContentImporterApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(CountryService countryService, CityService cityService) {
        return args -> {
            countryService.importCountries();
            cityService.importCities();
        };
    }
}
