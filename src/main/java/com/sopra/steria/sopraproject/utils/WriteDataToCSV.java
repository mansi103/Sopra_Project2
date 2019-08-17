package com.sopra.steria.sopraproject.utils;

import com.sopra.steria.sopraproject.entity.Customer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class WriteDataToCSV {
    public static void writeObjectToCSV(PrintWriter writer, List<Customer> customers) {
        try (
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID", "FirstName", "LastName","email"));
        ) {
            for (Customer customer : customers) {
                List<String> data = Arrays.asList(
                        (""+customer.getId()),
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getEmail()
                );

                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
        } catch (Exception e) {
            System.out.println("Writing CSV error!");
            e.printStackTrace();
        }
    }
}
