package com.sopra.steria.sopraproject.repositories;

import com.sopra.steria.sopraproject.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {

    List<Customer> findAllByMonth(String month);
//    List<Customer> findAllOrderByLastName();
}
