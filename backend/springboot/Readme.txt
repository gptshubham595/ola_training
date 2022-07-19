pom.xml
	-Spring Boot parent tag 
	-dependecies
		- spring-boot-starter-web // Basic spring 
		- spring-boot-starter-data-jpa //Connect with db & CRUD & DB Annotation 
		- mysql-connector-java 
	
	Spring APP -(Obj)-> JPA Hibernate -(Que)-> MySQL Conenctor -> DB

	- check username and db exists in mysql 
	- https://spring.io/guides/gs/accessing-data-mysql/
	- application.properties in resources
		server.port = 3200
		spring.jpa.hibernate.ddl-auto=update
		spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/springblog	
		spring.datasource.username=test
		spring.datasource.password=tester
		spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
		spring.jpa.show-sql: true

	- Create Directory structure (Package name in lower)
		- src
			- main
				- java
					- controller	
					- model 		 // Model Contains Box classes like Users  
					- repository     //Interface fully abstract https://docs.spring.io/spring-data/jpa/docs/1.4.2.RELEASE/reference/html/jpa.repositories.html
					- service
				- resource
					- application.properties
			-test 
	
	-Sample CRUD application
		- application	
			- @SpringBootApplication
			- SpringApplication.run(BlogApplication.class, args);
 
		- Controller
			- UserController
				- @RestController
				- @PostMapping for signup taking data as post request

		- Model
			- SignupResponse
				- Framing response flags and msg
			- User
				- Created private variables and getter, setter 
				- We use @Id above get function of any private variable to make it primary // (; We need one primary key for SQL

		- Repository
			- UserRepository
				- Its a Interface so no definition, extends JpaRepository<User,Long>  //Class file and primary key type 
				- returns NULL or obj file
				- findBy is default added by variable names
				
		- Service
			- Business Logic
			- UserService
				- @Service
				- @Autowired userRepo userRepoObj;	
				- Register function
					- save userInfo
					- check the results of userRepoObj is null or not

	- Annotations
		- @SpringBootApplication //Start
		- @Entity // to create table 
		- @Table(name="userInfo") // to name the table with different name other than  the  model class file  
		- @Service // Autowire will only work if @Service tag is applied
		- @Autowired //Use instead of Obj obj = new Obj();
		- @GetMapping // To use GET Request handling
		- @PostMapping(@Request) 
		- @Id // primary
