package com.examples.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
public class JavaStreams {

	public static void main(String[] args) {
		List<Person> persons = List.of(
			    new Person(1, "Alex", 100, new Department(1, "HR")),
			    new Person(2, "Brian", 200, new Department(1, "HR")),
			    new Person(3, "Charles", 900, new Department(2, "Finance")),
			    new Person(4, "David", 200, new Department(2, "Finance")),
			    new Person(5, "Edward", 200, new Department(2, "Finance")),
			    new Person(6, "Frank", 800, new Department(3, "ADMIN")),
			    new Person(7, "George", 90, new Department(3, "ADMIN")));
		
		Map<Department, List<Person>> map = persons.stream().collect(Collectors.groupingBy(Person::getDepartment));
		
		/* for (Map.Entry<Department, List<Person>> entry : map.entrySet()) 
	            System.out.println("Key = " + entry.getKey().toString() +
	                             ", Value = " + entry.getValue().toString()); */
		 
		 Map<Department, Person> topEmployees = persons.stream()
		            .collect(Collectors.groupingBy(e -> e.department, 
		                    Collectors.collectingAndThen(
		                            Collectors.maxBy(Comparator.comparingInt(e -> e.salary)), Optional::get
		                                                )
		                                )
		            );
		 
		 for (Map.Entry<Department, Person> entry : topEmployees.entrySet()) 
	            System.out.println("Key = " + entry.getKey().toString() +
	                             ", Value = " + entry.getValue().toString());
		
		 List<Employee> employeeList = new ArrayList<Employee>();
         
		 employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		 employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		 employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		 employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		 employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		 employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		 employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		 employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		 employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		 employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		 employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		 employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		 employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		 employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		 employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		 employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		 employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		 
		 //How many male and female employees are there in the organization?
		 
		 Map<String, Long> noOfMaleAndFemaleEmployees=
				 employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
				          
				 System.out.println(noOfMaleAndFemaleEmployees);
				 
				 employeeList.stream()
		            .map(Employee::getDepartment)
		            .distinct()
		            .forEach(System.out::println);
				 
		Map<String, Double> avgAgeOfMaleAndFemaleEmployees=
						 employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
						          
						 System.out.println(avgAgeOfMaleAndFemaleEmployees);
	}
	
	//https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/

}
