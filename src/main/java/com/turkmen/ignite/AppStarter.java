/**
 * 
 */
package com.turkmen.ignite;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.turkmen.ignite.model.Department;
import com.turkmen.ignite.model.Employee;
import com.turkmen.ignite.repository.DepartmentRepository;
import com.turkmen.ignite.repository.EmployeeRepository;

/**
 * @author TTTDEMIRCI
 *
 */
public class AppStarter {

	private static final Logger logger=LoggerFactory.getLogger(AppStarter.class);
	private static AnnotationConfigApplicationContext ctx;

	private static EmployeeRepository employeeRepository;

	private static DepartmentRepository departmentRepository;

	public static void main(String[] args) {

		ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppStarter.class);
		ctx.refresh();
		
		employeeRepository = ctx.getBean(EmployeeRepository.class);
		departmentRepository = ctx.getBean(DepartmentRepository.class);

		logger.info("ctx refreshed and repositories are captured....");
		Department it = new Department();
		it.setId(Long.valueOf(1));
		it.setName("IT");

		departmentRepository.save(it);
		System.out.println("Add one department in the repository!");

		List<Department> getAllDepartments = departmentRepository.getDepartmentByName("IT");
		for (Department dept : getAllDepartments) {
			System.out.println("Department:" + dept);
		}

		Employee turkmen = new Employee();
		turkmen.setName("Turkmen");
		turkmen.setId(Long.valueOf(1));
		turkmen.setDepartmentId(Long.valueOf(1));

		employeeRepository.save(turkmen);
		System.out.println("Employee turkmen saved into the cache!");

		List<Employee> employees = employeeRepository.getEmployeeByName("Turkmen");
		for (Employee employee : employees) {
			System.out.println("Employe:" + employee);
		}
	}

}
