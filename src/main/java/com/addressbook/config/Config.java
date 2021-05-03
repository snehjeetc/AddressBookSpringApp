package com.addressbook.config;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.addressbook.model.Person;

@Configuration
public class Config {
	@Bean
	public ModelMapper getMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
		  .setFieldMatchingEnabled(true)
		  .setFieldAccessLevel( org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
		return modelMapper;
	}
	
	@Bean
	public List<Person> getContactList(){
		return new ArrayList<>();
	}
}
