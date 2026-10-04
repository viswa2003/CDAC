package assignment_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentQueueManagement {
	
	ArrayList<Integer> queue = new ArrayList<>(Arrays.asList(105,112,108,101,115));
	
	public void addStudent(int id) {
		queue.add(id);
	}
	
	public void submit() {
		int id = queue.get(0);
		queue.remove(0);
		System.out.println("Student " + id + " submitted.");
	}
	
	public void search(int id) {
		if(queue.contains(id))
			System.out.println(id + " waiting in queue.");
		else {
			System.out.println(id + " not in queue.");
		}
	}
	
	public void display() {
		System.out.println("Queue : " + queue);
	}
	
	public void count() {
		System.out.println("Count : " + queue.size());
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StudentQueueManagement queue = new StudentQueueManagement();
		
		int choice;
		
		do {
            System.out.println("1. Add Student");
            System.out.println("2. Submit Assignment");
            System.out.println("3. Search Student");
            System.out.println("4. Display Queue");
            System.out.println("5. Count Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    queue.addStudent(id);
                    break;

                case 2:
                    queue.submit();
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    id = sc.nextInt();
                    queue.search(id);
                    break;

                case 4:
                    queue.display();
                    break;

                case 5:
                    queue.count();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
		
		
	}
	
	
}
