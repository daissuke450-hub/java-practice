package bean;

public class Student {

	private int studentId;
	private String name;
	private int grade;
	private String className;

	public Student() {
	}

	public Student(String name, int grade, String className) {
		this.name = name;
		this.grade = grade;
		this.className = className;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
