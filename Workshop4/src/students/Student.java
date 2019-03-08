package students;

public class Student {
	private String firstName;
	private String lastName;
	private double grade;
	private String department;
	
	public Student(String firstName, String lastName, double grade, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.department = department;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public double getGrade() {
		return grade;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%s\t%.2f\t%s", firstName, lastName, grade, department);
	}
	
	@Override
	public boolean equals(Object object) {
		// check self-assignment
		if (this == object) {
			return true;
		}
		
		// check if object is an instance of Student
		if (!(object instanceof Student)) {
			return false;
		}
		
		// cast object to Student so that we can compare data members
		Student other = (Student) object;
		
		// compare the data members and return accordingly
		if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (!department.equals(other.department)) {
			return false;
		}
		if (grade != other.grade) {
			return false;
		}
		
		return true;
	}
}
