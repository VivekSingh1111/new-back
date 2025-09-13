package org.codingwallah.emproject.services;

import java.util.List;

import org.codingwallah.emproject.entity.EmployeeEntity;
import org.codingwallah.emproject.model.Employee;

public interface EmployeeSerivce {
    String createEmployee(Employee employee);
   List<EmployeeEntity> readEmployees();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id, Employee employee);
    EmployeeEntity readEmployee(Long id);

}
