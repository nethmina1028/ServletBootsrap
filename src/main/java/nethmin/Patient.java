package nethmin;

public class Patient {
   
	int id;
	String name;
	String email;
	int age;
	String city;
	String gender;
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", city=" + city
				+ ", gender=" + gender + "]";
	}
	public Patient(String name, String email, int age, String city, String gender) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.city = city;
		this.gender = gender;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(int id, String name, String email, int age, String city, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.city = city;
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
