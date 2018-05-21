# Apache Ignite With Spring Data
**Apache Ignite** is a memory focused ,distributed database and caching platform. This repository is intended to see and observe the usage of **Spring Data** integration with **Apache Ignite**.

The project is structured with maven. For achieving the interactions between **Ignite** and **Spring Data** the dependency below is added to pom.xml along with other ignite dependencies.

                        ```
			<dependency>
			<groupId>org.apache.ignite</groupId>
			<artifactId>ignite-spring</artifactId>
			<version>2.0.0</version>
			</dependency>
			```


As for the functionality of the code, In the model package , two model classes  one of which is Department and the other one is Employee are created. As you can guess, an employee belongs to a department. 

For these two model classes ,two corresponding apache ignite repositories are created under repository package. It can be observed that thses are basic interfaces and it can get the benefits of Spring Data crud repository functionalities like getting the model objects by name,by id etc. 

For configuring Apache ignite, we have created a spring bean where an ignite node is configured and started. below is the piece of code where the ignite config is achieved. In the code below , two cache is created corresponding the model classes and the ignite node started.

```
@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public Ignite igniteInstance() {
		IgniteConfiguration cfg = new IgniteConfiguration();
		cfg.setIgniteInstanceName("springDataNode");
		cfg.setPeerClassLoadingEnabled(true);

		CacheConfiguration ccfgDog = new CacheConfiguration("departmentCache");
		CacheConfiguration ccfgBreed = new CacheConfiguration("employeeCache");
		
		
		ccfgBreed.setIndexedTypes(Long.class, Employee.class);
		ccfgDog.setIndexedTypes(Long.class, Department.class);
		cfg.setCacheConfiguration(new CacheConfiguration[] { ccfgDog, ccfgBreed });
		return Ignition.start(cfg);
	}
	```
	

For starting the app, the AppStarter class is created in src package and in there spring context is initialized and the necessary beans such as ignite repositories are registered to context and then sample data is put to ignite cache and then it is retrieved .



```
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
	```
	
