package com.ptheohar.example.runner;

import com.ptheohar.example.config.GeographyConfiguration;
import com.ptheohar.example.config.PhoneBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RoadRunner implements ApplicationRunner {
  private static Logger logger = LoggerFactory.getLogger(RoadRunner.class);

  private final PhoneBook phoneBook;
  private final GeographyConfiguration geographyConfiguration;

  public RoadRunner(PhoneBook phoneBook, GeographyConfiguration geographyConfiguration) {
    this.phoneBook = phoneBook;
    this.geographyConfiguration = geographyConfiguration;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("\n\n------------ PhoneBook ------------------\n");
    phoneBook.getContacts().forEach((iter)
        -> stringBuilder.append(iter.getName()).append(" --> ").append(iter.getNumber()).append("\n"));


    stringBuilder.append("\n\n------------ Continents & Countries ------------------\n");
    geographyConfiguration.getContinents().forEach((key, value)
        -> stringBuilder.append(key).append(" --> ").append(value).append("\n"));

    stringBuilder.append("\n------------ Countries & Cities ----------------------\n");
    geographyConfiguration.getCountries().forEach((key, value)
        -> stringBuilder.append(key).append(" --> ").append(value).append("\n"));

    logger.info(stringBuilder.toString());
  }

}
