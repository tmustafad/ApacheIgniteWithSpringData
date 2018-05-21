/**
 * 
 */
package com.turkmen.ignite.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * @author TTTDEMIRCI
 *
 */
public class Employee {

	
	@QuerySqlField(index=true)
	private Long id;
	
	@QuerySqlField(index=true)
	private String name;
	
	@QuerySqlField(index=true)
	private Long departmentId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}


}
