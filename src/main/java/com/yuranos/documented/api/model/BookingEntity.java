package com.yuranos.documented.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode(of = {"id", "location"})
@Table(name = "bookings")
@Entity
public class BookingEntity {
    final static long serialVersionUID = -6256672443057020739L;
    @NotNull
    @DecimalMax("100.0")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(min = 3, max = 25)
    private String location;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private DateTime departureDate;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private DateTime arrivalDate;
    @NotNull
    @Size(min = 3, max = 25)
    private String passengerName;
    @NotNull
    @Size(min = 3, max = 25)
    private String passengerSurname;
    @NotNull
    @DecimalMin("12.0")
    @DecimalMax("100.0")
    private Double age;
}



