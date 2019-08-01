package personal.trainings.DesignPattern.Creational.Builder;

public class Person {

	private String name;
	private String email;
	private String address;
	private int age;
	
	public Person(Builder builder) {
		this.name = builder.name;
		this.email = builder.email;
		this.address = builder.address;
		this.age = builder.age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", address=" + address + ", age=" + age + "]";
	}

	public static class Builder{
		//mandatory fields
		private final String name;
		private final String email;
		
		//not mandatory
		private String address;
		private int age;
		
		//setting the mandatory fields
		public Builder(String name, String email) {
			super();
			this.name = name;
			this.email = email;
		}
		
		public Builder setAddress(String address) {
			this.address = address;
			return this;
		}
		
		public Builder setAge(int Age) {
			this.age = Age;
			return this;
		}
		
		public Person build() {
			return new Person(this);
		}
		
	}
}
