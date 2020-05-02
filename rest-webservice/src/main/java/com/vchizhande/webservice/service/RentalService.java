package com.vchizhande.webservice.service;

import com.vchizhande.webservice.dto.RentalDto;
import com.vchizhande.webservice.model.Rental;

import java.util.Collection;

public interface RentalService {
    Rental findById(Long rentalId);

    Rental update(RentalDto rentalDto);

    Rental create(RentalDto rentalDto);

    void delete(Long id);

    Collection<Rental> findAllRentals();
}
