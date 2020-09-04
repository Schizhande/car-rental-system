package com.vchizhande.webservice.service.impl;

import com.vchizhande.webservice.dto.PaymentsDto;
import com.vchizhande.webservice.exception.RecordNotFoundException;
import com.vchizhande.webservice.model.Customer;
import com.vchizhande.webservice.model.Payments;
import com.vchizhande.webservice.model.Rental;
import com.vchizhande.webservice.model.User;
import com.vchizhande.webservice.repository.PaymentRepository;
import com.vchizhande.webservice.service.CustomerService;
import com.vchizhande.webservice.service.PaymentsService;
import com.vchizhande.webservice.service.RentalService;
import com.vchizhande.webservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RentalService rentalService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    @Override
    public Collection<Payments> findAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public Payments findById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Payments with id " + id + " not found"));
    }

    @Override
    public Payments create(PaymentsDto paymentDto) {
        Payments payment = paymentDto.toPayments();
        Rental rental = rentalService.findById(paymentDto.getRentalId());
//        User user = userService.findById(paymentDto.getUserId());
        Customer customer = customerService.findById(paymentDto.getCustomerId());
        payment.setRental(rental);
        payment.setCustomer(customer);
        payment.setReference("Ref-" + rental.getId() + "" + customer.getId());
//        payment.setUser(user);
        return paymentRepository.save(payment);
    }

    @Override
    public Payments update(PaymentsDto paymentDto) {
        Payments payment = findById(paymentDto.getId());
        Rental rental = rentalService.findById(paymentDto.getRentalId());
//        User user = userService.findById(paymentDto.getUserId());
        Customer customer = customerService.findById(paymentDto.getCustomerId());
        payment.setAmount(paymentDto.getAmount());
        payment.setCurrency(paymentDto.getCurrency());
        payment.setReference(paymentDto.getReference());
        payment.setPaymentMethod(paymentDto.getPaymentMethod());
        payment.setRental(rental);
        payment.setCustomer(customer);
//        payment.setUser(user);
        return paymentRepository.save(payment);
    }
}
