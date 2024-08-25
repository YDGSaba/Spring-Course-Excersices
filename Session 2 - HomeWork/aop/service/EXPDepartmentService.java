package ir.freeland.spring.aop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ir.freeland.spring.aop.model.Department;
import ir.freeland.spring.aop.model.Employee;

/**
 * Department Service
 *
 */
@Service
public class EXPDepartmentService {

    private List<Department> departments = new ArrayList<>();

    public List<Department> getAllDepartments() {
        System.out.println("Method getAllDepartments() called");
        return departments;
    }

    public Department getDepartmentById(Long departmentId) {
        System.out.println("Method getDepartmentById() called");
        for (Department department : departments) {
            if (department.getId().equals(departmentId)) {
                return department;
            } else {
                throw new NullPointerException("Department ID not found");
            }
        }
        return null;
    }

    public void addDepartment(Department department) {
        System.out.println("Method addDepartment() called");
        departments.add(department);
    }

    public void updateDepartment(Department departmentDetails) {
        System.out.println("Method updateDepartment() called");
        for (Department department : departments) {
            if (department.getId().equals(departmentDetails.getId())) {
                departments.remove(department);
                departments.add(departmentDetails);
            }
        }
    }

    public void deleteDepartment(Long departmentId) {
        System.out.println("Method deleteDepartment() called");
        departments.removeIf(department -> department.getId().equals(departmentId));
    }
    
    public void addEmployeeToDepartment(Long departmentId, Employee employee) {
        System.out.println("Method addEmployeeToDepartment() called");
        Department department = getDepartmentById(departmentId);
        if (department != null) {
            department.addEmployee(employee);
        }
    }

    public void removeEmployeeFromDepartment(Long departmentId, Long employeeId) {
        System.out.println("Method removeEmployeeFromDepartment() called");
        Department department = getDepartmentById(departmentId);
        if (department.getEmployees() != null) {
            department.getEmployees().removeIf(employee -> 
                employee.getId() != null && employee.getId().equals(employeeId)
            );
        }

    }
}
