package entities.animals;

import entities.people.Person;

public class DogSimple {
	//---------------------------------- data definition
	private String name;
	private String breed;
	private Person owner;
	private String sound;
	private static Person vet;
	public static final String SPECIES;
	static {
		SPECIES = "Canis lupus";
		// initialize static vars, run db access if necessary
		setVet(new Person());
		getVet().setInfo("Dr. Doggie", 45, true);
	}
	//--------------------------------- gets and sets
	// allow access, run data rules
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.printf("Updating Dog name from %s to %s\n", 
				(this.name == null ? "null" : this.name) , name);
		this.name = name;
		System.out.println("Updating completed.");
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public static Person getVet() {
		return vet;
	}
	public static void setVet(Person vet) {
		DogSimple.vet = vet;
	}
	//---------------------------------- processes
	public void jump() {					  // must be in this Dog class
		System.out.println("I'm jumping...");
		System.out.println("(" + this.getName() + " likes jumping.)");
	}
	public static void jumpStatic(DogSimple dog){   // can be in any class
		System.out.println("I'm jumping...");
		System.out.println("(" + dog.getName() + " likes jumping.)");
	}
	public void bark() {
		System.out.println(this.getSound());
	}
	public void bark(int numberOfTimes) {
		for (int i = 1; i <= numberOfTimes; i++) {
			this.bark();
		}
	}
	//---------------------------------- testing
	public static void main(String[] args) {
		// datatype ref = new datatype();
		DogSimple spike = new DogSimple();
		System.out.println(spike.getName());
		spike.setName("Spike");   		// convenience method
		spike.setName(new String());		// create empty string
		spike.setName(new String("Spike the Dog"));  // overloaded constructor
		spike.jump();	  // call instance method
		DogSimple.jumpStatic(spike);  // call static method
		
		// work on the owner
		spike.setOwner(new Person());
		spike.getOwner().setInfo("John", 22, false);
		spike.getOwner().printInfo();
		// show vet
		DogSimple.getVet().printInfo();
		spike.setSound("bark");
		spike.bark();
		spike.bark(4);
		System.out.println("A dog is of species " + DogSimple.SPECIES);
	}



}
