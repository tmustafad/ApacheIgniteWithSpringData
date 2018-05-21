/**
 * 
 */
package com.turkmen.ignite.repository;

import java.util.List;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.Query;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

import com.turkmen.ignite.model.Department;

/**
 * @author TTTDEMIRCI
 *
 */


@RepositoryConfig(cacheName="departmentCache")
public interface DepartmentRepository extends IgniteRepository<Department,Long> {

	List<Department> getDepartmentByName(String name);

	
	@Query("SELECT id from Department where id = ?")
	Department getDepartmentById(Long id);
}
