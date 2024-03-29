package com.ecommerce.OrderAandNotificationsManagement.service;

import com.ecommerce.OrderAandNotificationsManagement.dto.CustomerDTO;
import com.ecommerce.OrderAandNotificationsManagement.entity.Account;
import com.ecommerce.OrderAandNotificationsManagement.entity.Customer;
import com.ecommerce.OrderAandNotificationsManagement.repository.AccountRepository;
import com.ecommerce.OrderAandNotificationsManagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;

    public Customer addCustomer(CustomerDTO customerDTO){
        String email = customerDTO.getEmail();
        String name = customerDTO.getName();
        String phoneNumber = customerDTO.getPhoneNumber();
        Customer customer = new Customer(null,name,email,phoneNumber,null,null,null);
        return customerRepository.save(customer);
    }

    public Customer addAccountUsingCustomerId(Integer id, Account account){
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
            Account newAccount  = accountRepository.save(account);
            customer.get().setAccount(newAccount);
            return customerRepository.save(customer.get());
        }
        return null;
    }

    public Customer getCustomerById(Integer id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }


}
