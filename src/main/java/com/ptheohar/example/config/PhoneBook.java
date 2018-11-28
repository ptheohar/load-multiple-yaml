package com.ptheohar.example.config;

import com.ptheohar.example.model.Contact;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties("phonebook")
public class PhoneBook {

  private List<Contact> contacts;

}
