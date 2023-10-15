package week10.LinkedListStudent;

public class Course {

	//data fields
	private String code;
	private String description;
	

	Course(){}
	//constructor
		public Course(String code, String description) {
			this.code = code;
			this.description = description;
		}
		
	//Getters and setters
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public void setCourse(String course, String description) {
		this.code = code;
		this.description = description;
	}
	
	public String getCourse() {
		return code + "\t" + description + "\t";
	}
	
	public void viewCourseInfo() {
		System.out.println("Code\t\t:" + code);
		System.out.println("Description\t:" + description);
	}
	
	public String showCourseInfo() {
		return "Code\t\t:" + code + "\nDescription\t:" + description;
	}

	
}
