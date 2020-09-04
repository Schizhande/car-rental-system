package com.vchizhande.webservice.service.impl;

import com.vchizhande.webservice.dto.DashBoardDTO;
import com.vchizhande.webservice.repository.CustomerRepository;
import com.vchizhande.webservice.repository.PaymentRepository;
import com.vchizhande.webservice.repository.RentalRepository;
import com.vchizhande.webservice.repository.UserRepository;
import com.vchizhande.webservice.service.DashBoardService;
import org.springframework.stereotype.Service;

@Service
public class DashBoardServiceImpl implements DashBoardService {

    private final UserRepository userRepository;

    private final RentalRepository rentalRepository;

    private final PaymentRepository paymentRepository;

    private final CustomerRepository customerRepository;

    public DashBoardServiceImpl(UserRepository userRepository,
                                RentalRepository rentalRepository,
                                PaymentRepository paymentRepository,
                                CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.rentalRepository = rentalRepository;
        this.paymentRepository = paymentRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public DashBoardDTO getDashBoardCards() {
        DashBoardDTO dashBoardDTO = new DashBoardDTO();
        long totalUsers = userRepository.count();
        long totalRentals = rentalRepository.count();
        long totalCustomers = customerRepository.count();
        long totalAmount = paymentRepository.sumAmount();
        dashBoardDTO.setTotalCustomers(totalCustomers);
        dashBoardDTO.setTotalRentals(totalRentals);
        dashBoardDTO.setTotalUsers(totalUsers);
        dashBoardDTO.setTotalEarnings(totalAmount);
        return dashBoardDTO;
    }
}
