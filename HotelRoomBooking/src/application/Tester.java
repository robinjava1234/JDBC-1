package application;
import java.util.Scanner;
//import org.apache.logging.log4j.core.Logger;

import resources.AppConfig;
//import resources.LogConfig;

public class Tester {
	
	public static void main(String[] args) {

		
		addDetails();
		updateDetails();

	}
	 
/* To add a new customer details into the database*/	

	public static void addDetails() {		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter CustomerId :");
			Integer customerId = sc.nextInt();
			System.out.println("Enter CustomerName :");
			String customerName = sc.next();
			System.out.println("Enter RoomNo :");
			Integer roomNo = sc.nextInt();
			System.out.println("Enter TotalBillAmount :");
			Double totalBillAmount = sc.nextDouble();
			System.out.println("Enter ContactNo :");
			Long contactNo = sc.nextLong();
			
			Booking booking = new Booking();
			booking.setCustomerId(customerId);
			booking.setCustomerName(customerName);
			booking.setRoomNo(roomNo);
			booking.setTotalBillAmount(totalBillAmount);
			booking.setContactNo(contactNo);
			DataProvider d1 = new DataProvider();
			//d1.addBooking(booking);
			String bookingId = d1.addBooking(booking);
			System.out.println();
			System.out.print(AppConfig.PROPERTIES
					.getProperty("UserInterface.INSERT_SUCCESS"));
			System.out.print("   :   ");
			System.out.println(bookingId);
			
			

		} catch (Exception e) {

			System.out
					.println(AppConfig.PROPERTIES.getProperty("DataProvider.TECHNICAL_ERROR"));
		}
		System.out.println("\n\n");
	}

	
/* To get the details of all the orders that was made in the London branch  */
	
	

/* To update the room number of the mentioned customer id*/	

	public static void updateDetails() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please update the details");
			System.out.print("Enter the customer Id: ");
			Integer cusId = sc.nextInt();
			System.out.print("\nEnter the room no :");
			Integer Roomno = sc.nextInt();

			Integer i = new DataProvider().updateRoomNo(cusId , Roomno);
			System.out.println();
			if (i == 1) {
				System.out.print(AppConfig.PROPERTIES
						.getProperty("UserInterface.UPDATE_SUCCESS"));
			} else {
		
				throw new Exception("UserInterface.UPDATE_FAILURE");
			}

		} catch (Exception e) {
			System.out
					.println(AppConfig.PROPERTIES.getProperty("UserInterface.NO_DETAILS"));
		}
		System.out.println("\n\n");
	}

//To delete the record of with the orderId: 1004	

	
}
