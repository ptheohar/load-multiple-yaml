package com.ptheohar.example;

import com.ptheohar.example.config.GeographyConfiguration;
import com.ptheohar.example.config.PhoneBook;
import com.ptheohar.example.config.YamlConfiguration;
import com.ptheohar.example.model.Continent;
import com.ptheohar.example.model.Country;
import com.ptheohar.example.runner.RoadRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {YamlConfiguration.class, LoadMultipleYamlApplicationTests.TestConfiguration.class})
public class LoadMultipleYamlApplicationTests {

  @Autowired
  private PhoneBook phoneBook;

  @Autowired
  private GeographyConfiguration geographyConfiguration;

  @Test
  public void should_populate_phonebook_properties() {
    assert phoneBook.getContacts().get(0).getName().equals("Home");
    assert phoneBook.getContacts().get(0).getNumber().equals("+301234567890");

    assert phoneBook.getContacts().get(1).getName().equals("Office");
    assert phoneBook.getContacts().get(1).getNumber().equals("+301234543210");
  }

  @Test
  public void should_populate_geography_properties() {
    assert geographyConfiguration.getContinents().get(Continent.AMERICA) != null;
    assert geographyConfiguration.getContinents().get(Continent.EUROPE) != null;

    assert geographyConfiguration.getCountries().get(Country.USA).size() == 4;
    assert geographyConfiguration.getCountries().get(Country.ITALY).size() == 3;
    assert geographyConfiguration.getCountries().get(Country.SPAIN).size() == 2;
    assert geographyConfiguration.getCountries().get(Country.GERMANY).size() == 1;
  }

  @EnableConfigurationProperties(value = {GeographyConfiguration.class, PhoneBook.class})
  public static class TestConfiguration {
    // nothing
  }

}
