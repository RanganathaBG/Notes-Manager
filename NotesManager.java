package task4;

import java.io.*;
import java.util.Scanner;

public class NotesManager {

	private static final String File_Name = "notes.txt";
	
	public static void writeNote(String note) {
		try (FileWriter writer = new FileWriter(File_Name,true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer)){
			bufferedWriter.write(note);
			bufferedWriter.newLine();
			System.out.println("Note added successfully");
		} catch (IOException e) {
			System.out.println("Error Occured: "+e.getMessage());
		}
	}
	
	public static void readNote() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(File_Name))){
			String Line;
			System.out.println("Reading Notes");
			while((Line = bufferedReader.readLine())!=null) {
				System.out.println(Line);
			}
		} catch (IOException e) {
			System.out.println("Error occured while reading: "+e.getMessage());
		}
	}
	
	public static void displayMenu() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Notes Manager");{
				System.out.println("1.Add notes");
				System.out.println("2.Read Notes");
				System.out.println("3.Exit");
				System.out.println("Choose an option: ");
				int choice = scanner.nextInt();
				scanner.nextLine();
				
				switch(choice) {
				case 1: System.out.println("Enter your Note: ");
				String note = scanner.nextLine();
				writeNote(note);
				break;
				
				case 2: readNote();
				break;
				
				case 3: System.out.println("Exiting Notes Manager");
				return;
				
				default:
					System.out.println("Invalid option try again");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		displayMenu();
	}
}
