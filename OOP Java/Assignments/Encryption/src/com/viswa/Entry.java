package com.viswa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.utilities.ConsoleInput;

public class Entry {

	public static void main(String[] args) {
		
		final int ENCRYPTION_KEY = 5; 
		int choice;
		
		
		do {
			System.out.println("Enter choice : ");
			System.out.println("1. Encrypt \n2. Decrypt ");
			
			choice = ConsoleInput.getInt();

			switch (choice) {
			case 1 -> {
				System.out.println("Enter source file path : ");
				String path = ConsoleInput.getString();

				File file = new File(path);

				encryptData(ENCRYPTION_KEY, file);
				break;
			}

			case 2 -> {

				System.out.println("Enter path : ");
				String path = ConsoleInput.getString();

				File file = new File(path);

				decryptData(ENCRYPTION_KEY, file);
				break;

			}
			case 3 -> {
				System.out.println("Exiting...");
				break;
			}

			default -> {
				System.out.println("Enter valid choice!!");
			}
			}
		} while (choice != 3);
	
	
	}
	
	

	public static void decryptData(final int ENCRYPTION_KEY, File file) {
		try(FileInputStream inStream = new FileInputStream(file)) {
			
			byte[] data = inStream.readAllBytes();
			
			for(int iTmp = 0; iTmp < data.length; iTmp++) {
				data[iTmp] -= ENCRYPTION_KEY;
			}
			
			File decryptFile = new File("C:\\!Viswa\\CDAC\\OOP Java\\Encryption\\files\\decrypt.txt");
			
			try(FileOutputStream outStream = new FileOutputStream(decryptFile);)
			{
				outStream.write(data);
				System.out.println("Decrypted!!");		
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void encryptData(final int ENCRYPTION_KEY, File file) {
		try (FileInputStream inStream = new FileInputStream(file))
		{
						
			byte[] data = inStream.readAllBytes();
			
			for(int iTmp = 0; iTmp < data.length; iTmp++) {
				data[iTmp] += ENCRYPTION_KEY;
			}
			
			File encryptFile = new File("C:\\!Viswa\\CDAC\\OOP Java\\Encryption\\files\\enc.txt");
			
			try(FileOutputStream outStream = new FileOutputStream(encryptFile);) 
			{
			
				outStream.write(data);
				System.out.println("Encrypted!!");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
