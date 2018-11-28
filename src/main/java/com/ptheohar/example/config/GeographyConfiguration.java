package com.ptheohar.example.config;

import com.ptheohar.example.model.CityHint;
import com.ptheohar.example.model.Continent;
import com.ptheohar.example.model.Country;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Set;

@Data
@Configuration
@ConfigurationProperties("geography")
public class GeographyConfiguration {

  private Map<Continent, Set<Country>> continents;
  private Map<Country, Set<CityHint>> countries;

}
