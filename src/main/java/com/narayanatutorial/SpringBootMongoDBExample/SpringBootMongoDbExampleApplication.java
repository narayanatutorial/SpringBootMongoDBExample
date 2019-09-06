package com.narayanatutorial.SpringBootMongoDBExample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@ComponentScan("com.narayanatutorial")
@SpringBootApplication
public class SpringBootMongoDbExampleApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootMongoDbExampleApplication.class, args);
	}

	
	@Bean
    CommandLineRunner init(EmployeeRepository employeeRepository) {

        return args -> {

//            Employee obj = domainRepository.findOne(7L);
//            System.out.println(obj);

        	Employee obj2 = employeeRepository.findByName("narayana");
            System.out.println("ObjectId:"+obj2.get_id()+" name:"+obj2.getName()+" city:"+obj2.getCity());

            long n = employeeRepository.updateCity("narayana", "mumbai");
            System.out.println("Number of records updated : " + n);

        };
}
}
