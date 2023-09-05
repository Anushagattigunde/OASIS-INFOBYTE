package labprograms;


import java.util.Scanner;
import java.util.ArrayList;

class Reservation {
    private int pnr; 
    private String trainNumber;
    private String trainName;
    private String classType;
    private String dateOfJourney;
    private String from;
    private String to;

    public Reservation(int pnr, String trainNumber, String classType, String dateOfJourney, String from, String to) {
        this.pnr = pnr;
        this.trainNumber = trainNumber;
        this.trainName = fetchTrainName(trainNumber);
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.from = from;
        this.to = to;
    }

    
    private String fetchTrainName(String trainNumber) {
        return "Train Name"; 
    }
    public int getPNR() {
    	
        return pnr;
    }

    @Override
    public String toString() {
        return "PNR: " + pnr + "\n" +
               "Train Number: " + trainNumber + "\n" +
               "Train Name: " + trainName + "\n" +
               "Class Type: " + classType + "\n" +
               "Date of Journey: " + dateOfJourney + "\n" +
               "From: " + from + "\n" +
               "To: " + to;
    }
}

public class Main {
    private static ArrayList<Reservation> reservations = new ArrayList<>();
    private static int pnrCounter = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Reservation");
            System.out.println("2. Cancellation");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    makeReservation(scanner);
                    break;
                case 2:
                    cancelReservation(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void makeReservation(Scanner scanner) {
        // Collect reservation details from the user
        System.out.print("Enter Train Number: ");
        String trainNumber = scanner.nextLine();

        System.out.print("Enter Class Type: ");
        String classType = scanner.nextLine();

        System.out.print("Enter Date of Journey: ");
        String dateOfJourney = scanner.nextLine();

        System.out.print("Enter From: ");
        String from = scanner.nextLine();

        System.out.print("Enter To: ");
        String to = scanner.nextLine();
        
        int pnr = generatePNR();
        Reservation reservation = new Reservation(pnr, trainNumber, classType, dateOfJourney, from, to);

        // Display PNR
        System.out.println("Reservation successful. PNR: " + pnr);

        // Add the reservation to the list
        reservations.add(reservation);
    }

    private static int generatePNR() {
        return ++pnrCounter;
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.print("Enter PNR Number: ");
        int pnrToCancel = scanner.nextInt();

        // Find and remove the reservation with the given PNR
        boolean found = false;
        for (Reservation reservation : reservations) {
            if (reservation.getPNR() == pnrToCancel) {
                reservations.remove(reservation);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Reservation with PNR " + pnrToCancel + " cancelled successfully.");
        } else {
            System.out.println("Reservation with PNR " + pnrToCancel + " not found.");
        }
    }
}
