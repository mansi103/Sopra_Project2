package com.sopra.steria.sopraproject.utils;

import com.sopra.steria.sopraproject.entity.Customer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvUtils {
    public static void customersToCsv(PrintWriter writer, List<Customer> customers) throws IOException {

        try (
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("id", "first_name", "last_name", "email","month"));
        ) {
            for (Customer customer : customers) {
                List<String> data = Arrays.asList(
                        String.valueOf(customer.getId()),
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getEmail(),
                        customer.getMonth()
                );

                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
        } catch (Exception e) {
            System.out.println("Writing CSV error!");
            e.printStackTrace();
        }
    }

    public static List<Customer> parseCsvFile(InputStream is) {
        BufferedReader fileReader = null;
        CSVParser csvParser = null;

        List<Customer> customers = new ArrayList<Customer>();

        try {
            fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Customer customer = new Customer(
                        csvRecord.get("FirstName"),
                        csvRecord.get("LastName"),
                        csvRecord.get("email"),
                        csvRecord.get("month")
                );

                customers.add(customer);
            }

        } catch (Exception e) {
            System.out.println("Reading CSV Error!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                csvParser.close();
            } catch (IOException e) {
                System.out.println("Closing fileReader/csvParser Error!");
                e.printStackTrace();
            }
        }

        return customers;
    }
}
