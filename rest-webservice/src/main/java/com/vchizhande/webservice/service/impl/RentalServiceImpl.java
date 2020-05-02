package com.vchizhande.webservice.service.impl;

import com.vchizhande.webservice.dto.RentalDto;
import com.vchizhande.webservice.exception.RecordNotFoundException;
import com.vchizhande.webservice.model.Customer;
import com.vchizhande.webservice.model.Rental;
import com.vchizhande.webservice.model.User;
import com.vchizhande.webservice.model.Vehicle;
import com.vchizhande.webservice.repository.RentalRepository;
import com.vchizhande.webservice.service.CustomerService;
import com.vchizhande.webservice.service.RentalService;
import com.vchizhande.webservice.service.UserService;
import com.vchizhande.webservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @Autowired
    private VehicleService vehicleService;

    @Override
    public Rental findById(Long rentalId) {
        return rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RecordNotFoundException("Rental with id " + rentalId + " not found"));
    }

    @Override
    public Rental create(RentalDto rentalDto) {
        Rental rental = rentalDto.toRental();
        Customer customer = customerService.findById(rentalDto.getCustomerId());
        User user = userService.findById(rentalDto.getUserId());
        Vehicle vehicle = vehicleService.findById(rentalDto.getVehicleId());
        rental.setCustomer(customer);
        rental.setUser(user);
        rental.setVehicle(vehicle);
        return rentalRepository.save(rental);
    }

    @Override
    public Rental update(RentalDto rentalDto) {
        Rental rental = findById(rentalDto.getId());
        Customer customer = customerService.findById(rentalDto.getCustomerId());
        User user = userService.findById(rentalDto.getUserId());
        Vehicle vehicle = vehicleService.findById(rentalDto.getVehicleId());
        rental.setCurrentMileage(rentalDto.getCurrentMileage());
        rental.setPenaltyFee(rentalDto.getPenaltyFee());
        rental.setRentDate(rentalDto.getRentDate());
        rental.setRentEndDate(rentalDto.getRentEndDate());
        rental.setRentFee(rentalDto.getRentFee());
        rental.setReturnDate(rentalDto.getReturnDate());
        rental.setCustomer(customer);
        rental.setUser(user);
        rental.setVehicle(vehicle);
        return rentalRepository.save(rental);
    }

    @Override
    public void delete(Long id) {
        rentalRepository.deleteById(id);
    }

    @Override
    public Collection<Rental> findAllRentals() {
        return rentalRepository.findAll();
    }
}
