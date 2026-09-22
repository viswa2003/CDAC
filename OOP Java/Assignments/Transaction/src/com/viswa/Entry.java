package com.viswa;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

import com.utilities.ConsoleInput;

public class Entry {

	public static void main(String[] args) {
		
		ArrayList<Transaction> transactionList = new ArrayList<>();
		
		for(int iTmp = 0; iTmp < 5; iTmp++) {
				
			System.out.println("Enter Id : ");
			int id = ConsoleInput.getInt();
	
			System.out.println("Enter amount : ");
			float amount = ConsoleInput.getFloat();
			
			System.out.println("Enter status(T / F) : ");
			char status = ConsoleInput.getString().charAt(0);
			boolean txStatus = (status == 'T') ? true : false;
			
			System.out.println("Enter arrears(T / F) : ");
			char arrears = ConsoleInput.getString().charAt(0);
			boolean txArrears = (arrears == 'T') ? true : false;
			
			transactionList.add(new Transaction(id, amount, txStatus, txArrears));
		
		}
		
//		Amount greater than 5000
//		========================
		System.out.println("Greater than 5000\n");
//		Consumer<ArrayList<Transaction>> highest = list -> {
//			Iterator<Transaction> iter = list.iterator();
//			
//			while(iter.hasNext()) {
//				Transaction current = iter.next();
//				if(current.getTxAmount() > 5000) {
//					System.out.println(current);
//				}
//				
//			}
//		};
		
		Consumer<ArrayList<Transaction>> highest = list -> {
			list.forEach(transaction -> {
				if(transaction.getTxAmount() > 5000) {
					System.out.println(transaction);
				}
			});
		};
		
		System.out.println("Higher than 5000");
		highest.accept(transactionList);

//		Transaction with false status
//		=============================
		System.out.println("\nTransaction with false status : ");
		
		Consumer<ArrayList<Transaction>> statusFalse = array -> {
			array.forEach(transaction -> {
				if(!transaction.isTxStatus()) {
					System.out.println(transaction);
				}
			});
		};
		
		statusFalse.accept(transactionList);
		
		
//		Generate amount due
//		===================
		
		System.out.println("Amounts due \n");
		Consumer<ArrayList<Transaction>> amountDue = transactions -> {
			transactions.forEach(transaction -> {
				double amount;
				if(transaction.isTxArrears()) {
					amount = (1.18 * transaction.getTxAmount() + 500);				
				}
				else
					amount = transaction.getTxAmount();
				
				System.out.println(transaction + " Amount due : " + amount);
			});
		};
		
		amountDue.accept(transactionList);
		
		
	}

}
