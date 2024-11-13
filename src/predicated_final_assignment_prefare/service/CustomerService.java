package predicated_final_assignment_prefare.service;

import predicated_final_assignment_prefare.model.Customer;

import java.util.List;

public class CustomerService {
    private List<Customer> customers;

    public Customer createCustomer(){
        Customer newCustomer = new Customer("test", 100, 0, false, false);
        customers.add(newCustomer);
        return newCustomer;
    }
}
