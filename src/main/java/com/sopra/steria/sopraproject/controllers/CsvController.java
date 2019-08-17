package com.sopra.steria.sopraproject.controllers;

import com.sopra.steria.sopraproject.entity.Customer;
import com.sopra.steria.sopraproject.repositories.CustomerRepository;
import com.sopra.steria.sopraproject.service.CustomerService;
import com.sopra.steria.sopraproject.utils.WriteDataToCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/csv")
public class CsvController {
//    @Autowired
//    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    //	@GetMapping("/download/{id}")
//    public void downloadCSV(HttpServletRequest request,HttpServletResponse response, @PathVariable(value="id") String id) throws IOException {
//        response.setContentType("text/csv");
//        String fileName = id+".csv";
//        System.out.println("hello");
////        String j = request.getParameter("text1");
////        System.out.println(j);
//        response.setHeader("Content-Disposition", "attachment; file="+fileName);
//
//        List<Customer> customers = (List<Customer>) customerService.getCustom();
//        WriteDataToCSV.writeObjectToCSV(response.getWriter(), customers);
//    }
//
    @PostMapping("/download")
    public void downloadCSV(HttpServletResponse response, @RequestParam("text1") String value) throws IOException {
        response.setContentType("text/csv");
        System.out.println("hello");
        System.out.println(value);
        String filename="mansi_"+value+".csv";
        String s = "attachment; filename="+filename;
        response.setHeader("Content-Disposition",s);
        List<Customer> customers = customerRepository.findAllByMonth(value);
        WriteDataToCSV.writeObjectToCSV(response.getWriter(), customers); }
}
