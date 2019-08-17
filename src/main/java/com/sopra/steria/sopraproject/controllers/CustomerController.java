package com.sopra.steria.sopraproject.controllers;

import com.sopra.steria.sopraproject.entity.Customer;
import com.sopra.steria.sopraproject.repositories.CustomerRepository;
import com.sopra.steria.sopraproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        List<Customer> theCustomers = (List<Customer>) customerService.findAll();
        theModel.addAttribute("customers",theCustomers);
        return "list-customers";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer",theCustomer);
        return "customer-form";
    }
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        customerService.save(theCustomer);
        return "redirect:/customer/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
        Customer theCustomer = customerService.findById(theId).orElse(null);
        theModel.addAttribute("customer",theCustomer);
        return "customer-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int theId,Model theModel) {
        customerService.deleteById(theId);
        return "redirect:/customer/list";
    }
}
