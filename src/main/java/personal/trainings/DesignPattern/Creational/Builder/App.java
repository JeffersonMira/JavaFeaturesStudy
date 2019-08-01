package personal.trainings.DesignPattern.Creational.Builder;

import personal.trainings.DesignPattern.Creational.Builder.Person.Builder;

public class App {
	public static void main(String[] args) {
		Person p = new Builder("John", "j@blogspot.com").setAddress("Fools Str").build();
		
		System.out.println(p);
	}
}
