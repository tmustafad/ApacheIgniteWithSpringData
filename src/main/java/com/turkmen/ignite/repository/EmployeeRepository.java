/**
 * 
 */
package com.turkmen.ignite.repository;

import java.util.List;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

import com.turkmen.ignite.model.Employee;

/**
 * @author TTTDEMIRCI
 *
 */


@RepositoryConfig(cacheName="employeeCache")
public interface EmployeeRepository extends IgniteRepository<Employee, Long> {

	List<Employee> getEmployeeByName(String name);

	Employee getEmployeeById(Long id);
}
