package repository;

import model.Customer;
import model.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
    void insertCustomer(Customer customer) throws SQLException;

    Customer selectCustomer(int id);

    List<Customer> selectAllCustomer();

    boolean deleteCustomer(int id) throws SQLException;

    boolean updateCustomer(Customer customer) throws SQLException;

    List<CustomerType> selectCustomerType();

    List<Customer> findByStatusDelete(String statusDelete);
}
