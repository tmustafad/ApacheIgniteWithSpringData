# Apache Ignite With Spring Data
**Apache Ignite** is a memory focused ,distributed database and caching platform. This repository is intended to see and observe the usage of **Spring Data** integration with **Apache Ignite**.

The project is structured with maven. For achieving the interactions between **Ignite** and **Spring Data** the dependency below is added to pom.xml.

  ```<dependency>
			<groupId>org.apache.ignite</groupId>
			<artifactId>ignite-spring</artifactId>
			<version>2.0.0</version>
		</dependency>```
		
    After this dependency is added ,we have the ability to use special **IgniteRepository** interface which is extending Spring Data **CrudRepository** . 
    ###### As it can be seen in the package structure, every model class has its own ignite repository.
    
    
