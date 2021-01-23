package com.ait.ex6B2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class ArrayListPeople {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int userOption = 0;
		ArrayList<Person> people = new ArrayList<Person>();
		while (userOption != 7) {
			userOption = userChoice();
			
			if (userOption == 1) {
				add(people);
			} else if (userOption == 2) {
				
				update(people);
				
			} else if (userOption == 3) {
				
				deletePerson(people);
				
			} else if (userOption == 4) {
				
				deleteEveryone(people);
				
			} else if (userOption == 5) {
				
				findPersonByName(people);
			
			} else if (userOption == 6) {
				
				display(people);
			}
		}
	}
		
	static int personThereAlready = 0;
	public static int userChoice() {
		int option = 0;
		System.out.println("What do you want to do?\n1.Add\n2.Update\n3.Delete a person\n4.Delete everyone"
				+ "\n5.Find a person\n6.Display\n7.Exit");
		option = sc.nextInt();
		return option;
	}
	
	public static void add(ArrayList<Person> people) {
		String name = "";
		int age = 0;
		
		System.out.print("Enter the persons name --> ");
		name = sc.next();
		System.out.print("Enter the persons age --> ");
		age = sc.nextInt();
		
		Person person = new Person(name,age);
		people.add(person);
	}
	
	public static int personThereAlready(String name, ArrayList<Person> people) {
		
		for(int i=0; i < people.size();i++) {
			
			System.out.println(String.valueOf(people.get(i)));
			
			if (name.contains(people.get(i).toString())) {
				personThereAlready = i;
			} else {
				personThereAlready = -1;
			}
		}
		
		return personThereAlready;
	}
	
	public static void display(ArrayList<Person> people) {
		
		for (int i=0; i<people.size();i++) {
		
			System.out.println(people.get(i));
		}

		
	}
	
	public static void update(ArrayList<Person> people) {
		
		System.out.print("Enter the persons name you wish to change -->");
		String personNameToBeChanged = sc.next();
		
		if (personThereAlready(personNameToBeChanged, people) == -1) {
			System.out.println(personNameToBeChanged+" is not in the list...");
		} else {
			System.out.print("Enter the new name -->");
			String newName = sc.next();
			System.out.print("\nEnter the new age -->");
			int newAge = sc.nextInt();
			
			Person newPerson = new Person(newName, newAge);
			people.set(personThereAlready,newPerson);
		}
	}
	
	public static void deletePerson(ArrayList<Person> people) {
		System.out.println("The persons list before ");
		display(people);
		System.out.print("Enter the persons name you wish to delete -->");
		String nameToDelete = sc.next();
		if (personThereAlready(nameToDelete, people) != -1) {
			people.remove(personThereAlready);
			System.out.println("The persons list after ");
			display(people);
		} else {
			System.out.println("Could not find that person...");
		}
		
	}
	
	public static void findPersonByName(ArrayList<Person> people) {
		
		System.out.print("Enter the persons name -->");
		
		String personToBeFound = sc.next();
		String prefix = "name=";
		
		for (int i=0;i<people.size();i++) {
			
			String personLooked = people.get(i).toString().split(",")[1];
			System.out.println(personLooked);
			
			if (personToBeFound.equalsIgnoreCase(personLooked)) {
				display(people);
				System.out.println("Person found...");
			} else {
				System.out.println("Did not find the person!");
			}
		}
	}
	
	public static void deleteEveryone(ArrayList<Person> people) {
		
			people.clear();
		
	}
	
}
