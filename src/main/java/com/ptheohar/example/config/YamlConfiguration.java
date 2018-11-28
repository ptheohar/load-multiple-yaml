package com.ptheohar.example.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
public class YamlConfiguration {

  public static final String LOCATION_YML = "classpath:*.yml";

  @Bean
  public static PropertySourcesPlaceholderConfigurer properties(ResourcePatternResolver resourcePatternResolver) throws Exception {
    Resource[] resources = resourcePatternResolver.getResources(LOCATION_YML);

    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
    YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
    yaml.setResources(resources);
    propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
    return propertySourcesPlaceholderConfigurer;
  }

}
