package org.codingwallah.emproject.services;
import java.util.List;

import org.codingwallah.emproject.entity.EmployeeEntity;
import org.codingwallah.emproject.model.Employee;
import org.codingwallah.emproject.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSerivceImpl implements EmployeeSerivce{

@Autowired
private EmployeeRepository employeeRepository;



@Override
public String createEmployee(Employee employee) {
    EmployeeEntity employeeEntity = new EmployeeEntity();
    BeanUtils.copyProperties(employee, employeeEntity);

    employeeRepository.save(employeeEntity);
    return "Saved Successfully";
}


@Override
public List<EmployeeEntity> readEmployees() {
return employeeRepository.findAll();
}

@Override
public boolean deleteEmployee(Long id) {
    if(!employeeRepository.existsById(id)){
        return false;
    }else{
employeeRepository.deleteById(id);
}

    return true;
}

@Override
public String updateEmployee(Long id, Employee employee) {
    EmployeeEntity exestingEmployee = employeeRepository.findById(id).get();
    
    exestingEmployee.setEmail(employee.getEmail());
    exestingEmployee.setName(employee.getName());
    exestingEmployee.setPhone(employee.getPhone());

    employeeRepository.save(exestingEmployee);
    
    return "Update Succesfully";
}


@Override
public EmployeeEntity readEmployee(Long id) {
    return employeeRepository.findById(id)
     .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
           
}




}
