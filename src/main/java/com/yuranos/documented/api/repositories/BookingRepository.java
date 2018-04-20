package com.yuranos.documented.api.repositories;

import com.yuranos.documented.api.model.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update BookingEntity b set b.passengerName = :#{#booking.passengerName},b.passengerSurname = :#{#booking.passengerSurname}," +
            "b.destination = :#{#booking.destination}, b.departureDate = :#{#booking.departureDate} where b.id = :id")
    int update(@Param("id") Integer id, @Param("booking") BookingEntity booking);
}
