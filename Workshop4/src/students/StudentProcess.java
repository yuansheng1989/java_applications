package students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentProcess {
	static Student[] students = {
			new Student("Jack", "Smith", 50.0, "IT"),
			new Student("Aaron", "Johnson", 76.0, "IT"),
			new Student("Maaria", "White", 35.8, "Business"),
			new Student("John", "White", 47.0, "Media"),
			new Student("Laney", "White", 62.0, "IT"),
			new Student("Jack", "Jones", 32.9, "Business"),
			new Student("Wesley", "Jones", 42.89, "Media")
	};
	
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>(Arrays.asList(students));
		
		System.out.println("Task 1:\n");
		System.out.println("Complete Student list:");
		// use method reference:
		/*
		 * or use lambda expression:
		 * studentList.forEach(element->System.out.println(element));
		 */
		studentList.forEach(System.out::println);
		System.out.print("\n\n");
		
		System.out.println("Task 2:\n");
		System.out.println("Students who got 50.0-100.0 sorted by grade:");
		// use Stream to filter and sort
		Stream<Student> studentStream = studentList.stream()
												   .sorted(Comparator.comparing(Student::getGrade))
												   .filter(student->student.getGrade()>=50.0&&student.getGrade()<=100.0);
		studentStream.forEach(System.out::println);
		System.out.print("\n\n");
		
		System.out.println("Task 3:\n");
		System.out.println("First Student who got 50.0-100.0:");
		Optional<Student> studentFirst = studentList.stream()
													.filter(student->student.getGrade()>=50.0&&student.getGrade()<=100.0)
													.findFirst();
		System.out.println(studentFirst.get());
		System.out.print("\n\n");
		
		System.out.println("Task 4:\n");
		System.out.println("Students in ascending order by last name then first:");
		Comparator<Student> firstNameOrder = (s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName());
		Comparator<Student> lastNameOrder = (s1, s2) -> s1.getLastName().compareTo(s2.getLastName());
		studentList.stream()
				   .sorted(lastNameOrder.thenComparing(firstNameOrder))
				   .forEach(System.out::println);
		System.out.print("\n");
		System.out.println("Students in descending order by last name then first:");
		studentList.stream()
				   .sorted(lastNameOrder.reversed().thenComparing(firstNameOrder.reversed()))
				   .forEach(System.out::println);
		System.out.print("\n\n");
		
		System.out.println("Task 5:\n");
		System.out.println("Unique Student last names:");
		studentList.stream()
				   .map(Student::getLastName)
				   .distinct()
				   .sorted()
				   .forEach(System.out::println);
		System.out.print("\n\n");
		
		System.out.println("Task 6:\n");
		System.out.println("Student names in order by last name then first name:");
		studentList.stream()
				   .sorted(lastNameOrder.thenComparing(firstNameOrder))
				   .map(Student::getName)
				   .forEach(System.out::println);
		System.out.print("\n\n");
		
		System.out.println("Task 7:\n");
		System.out.println("Students by department:");
		// Group students by department
		Map<String, List<Student>> studentsByDept = studentList.stream()
															   .collect(Collectors.groupingBy(Student::getDepartment));
		studentsByDept.forEach((k, v) -> {
			System.out.println(k);
			v.forEach(e -> System.out.println(" " + e));
		});
		System.out.print("\n\n");
		
		System.out.println("Task 8:\n");
		System.out.println("Count of Students by department:");
		// Count students grouped by department, where the department names are sorted
		Map<String, Long> countByDept = studentList.stream()
												   .collect(Collectors.groupingBy(Student::getDepartment, TreeMap::new, Collectors.counting()));
		countByDept.forEach((k, v) -> System.out.printf("%s has %s Student(s)\n", k, v));
		System.out.print("\n\n");
		
		System.out.println("Task 9:\n");
		double gradeSum = studentList.stream().mapToDouble(Student::getGrade).sum();
		System.out.printf("Sum of Students' grades: %.2f", gradeSum);
		System.out.print("\n\n");
		
		System.out.println("Task 10:\n");
		OptionalDouble gradeAverage = studentList.stream().mapToDouble(Student::getGrade).average();
		System.out.printf("Average of Students' grades: %.2f", gradeAverage.getAsDouble());
	}
}
