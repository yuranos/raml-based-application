package com.yuranos.documented.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.Wither;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@EqualsAndHashCode(of = {"id", "destination"})
@Getter
@Setter
@Table(name = "bookings")
@Entity
public class BookingEntity {
    final static long serialVersionUID = -6256672443057020739L;
    @DecimalMax("100.0")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(min = 3, max = 50)
    private String destination;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private LocalDateTime departureDate;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private LocalDateTime arrivalDate;
    @NotNull
    @Size(min = 3, max = 25)
    private String passengerName;
    @NotNull
    @Size(min = 3, max = 25)
    private String passengerSurname;
    @NotNull
    @DecimalMin("12")
    @DecimalMax("100")
    private Integer age;
}



