package com.sopra.steria.sopraproject.service;

import com.sopra.steria.sopraproject.entity.Customer;
import com.sopra.steria.sopraproject.repositories.CustomerRepository;
import com.sopra.steria.sopraproject.utils.CsvUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class FileService {
//    @Autowired
//    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    // Store File Data to Database
    public void store(MultipartFile file){
        try {
            List<Customer> lstCustomers = CsvUtils.parseCsvFile(file.getInputStream());
            // Save Customers to DataBase
            /*
             * for(Customer c:lstCustomers) { customerService.saveCustomer(c); }
             */
            lstCustomers.forEach(c->customerRepository.save(c));

        } catch (IOException e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
    }

    // Load Data to Excel File
    public void loadFile(PrintWriter writer) {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();

        try {
            CsvUtils.customersToCsv(writer, customers);
        } catch (IOException e) {}
    }

}
