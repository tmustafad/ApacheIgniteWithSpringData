/**
 * 
 */
package com.turkmen.ignite.configuration;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.turkmen.ignite.model.Department;
import com.turkmen.ignite.model.Employee;
 
/**
 * @author TTTDEMIRCI
 *
 */
@Configuration
@EnableIgniteRepositories
public class AppConfig {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public Ignite igniteInstance() {
		IgniteConfiguration cfg = new IgniteConfiguration();
		cfg.setIgniteInstanceName("springDataNode");
		cfg.setPeerClassLoadingEnabled(true);

		CacheConfiguration ccfgemp = new CacheConfiguration("departmentCache");
		CacheConfiguration ccfgdept = new CacheConfiguration("employeeCache");
		
		
		ccfgemp.setIndexedTypes(Long.class, Employee.class);
		ccfgdept.setIndexedTypes(Long.class, Department.class);
		cfg.setCacheConfiguration(new CacheConfiguration[] { ccfgemp, ccfgdept });
		return Ignition.start(cfg);
	}

}
