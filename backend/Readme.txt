pom.xml
	-Spring Boot parent tag 
	-dependecies
		- spring-boot-starter-web // Basic spring 
		- spring-boot-starter-data-jpa //Connect with db & CRUD & DB Annotation 
		- mysql-connector-java 
	
	Spring APP -(Obj)-> JPA Hibernate -(Que)-> MySQL Conenctor -> DB

	- check username and db exists in mysql 

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
					- model
					- repository //Interface fully abstract
					- service
				- resource
					- application.properties
			-test
