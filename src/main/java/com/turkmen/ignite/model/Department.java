/**
 * 
 */
package com.turkmen.ignite.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * @author TTTDEMIRCI
 *
 */
public class Department {
	
	@QuerySqlField(index=true)
	private Long id;
	
	@QuerySqlField(index=true)
	private String name;

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
	
	
	

}
