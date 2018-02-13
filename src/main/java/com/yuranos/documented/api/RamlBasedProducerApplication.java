package com.yuranos.documented.api;

import lombok.val;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@SpringBootApplication
public class RamlBasedProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RamlBasedProducerApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		val modelMapper = new ModelMapper();
        val toLocalDateTime = new AbstractConverter<Date, LocalDateTime>() {
            protected LocalDateTime convert(Date date) {
                return Optional.ofNullable(date)
                        .map(dt -> LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())).orElse(null);
            }
        };
        Converter<LocalDateTime, Date> toDate = new AbstractConverter<LocalDateTime, Date>() {
            protected Date convert(LocalDateTime localDateTime) {
                return Optional.ofNullable(localDateTime)
                        .map(ldt -> Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant())).orElse(null);
            }
        };
        modelMapper.addConverter(toLocalDateTime);
        modelMapper.addConverter(toDate);
        return modelMapper;
	}
}
