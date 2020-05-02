package com.vchizhande.webservice.service;

import com.vchizhande.webservice.dto.PaymentsDto;
import com.vchizhande.webservice.model.Payments;

import java.util.Collection;

public interface PaymentsService {

    Collection<Payments> findAllPayments();

    void delete(Long id);

    Payments findById(Long id);

    Payments update(PaymentsDto customerDto);

    Payments create(PaymentsDto customerDto);
}
