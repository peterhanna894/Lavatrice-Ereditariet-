package org.generation.italy;

import java.util.Scanner;
import org.generation.italy.model.Lavatrice;


/**
 * The MainLavatrice class provides a command-line interface to interact with the Lavatrice class.
 * It allows users to perform various operations on the washing machine, such as turning it on/off,
 * opening/closing the door, adding detergent, selecting programs, and starting/stopping the washing process.
 */
public class MainLavatrice {

    public static void main(String[] args) {
        // Create a Scanner object for reading user input
        Scanner sc = new Scanner(System.in);
        String scelta; // Variable to store user choice
        Lavatrice l = new Lavatrice(); // Create a new Lavatrice object
      
        int sceltaProgramma; // Variable to store the selected program index

        // Display the menu and handle user input in a loop until the user chooses to exit
        do {
            System.out.println("Menu Lavatrice");
            System.out.println("(1) Accendi");
            System.out.println("(2) Spegni");
            System.out.println("(3) Apri lo sportello");
            System.out.println("(4) Chiudi lo sportello");
            System.out.println("(5) Aggiungi detersivo");
            System.out.println("(6) Seleziona programma");
            System.out.println("(7) Avvia lavaggio");
            System.out.println("(8) Termina lavaggio");
            System.out.println("(00) Esci");
            scelta = sc.nextLine(); // Read user choice

            // Execute the appropriate action based on the user's choice
            switch (scelta) {
                case "1":
                    // Turn on the washing machine
                    l.accendi();
                    break;
                case "2":
                    // Turn off the washing machine
                    l.spegni();
                    break;
                case "3":
                    // Open the washing machine door
                    l.apriSportello();
                    break;
                case "4":
                    // Close the washing machine door
                    l.chiudiSportello();
                    break;
                case "5":
                    // Add detergent to the washing machine
                    l.aggiungiDetersivo();
                    break;
                case "6":
                    // Select a washing program
                    if (l.getStato() == 1) { // Check if the washing machine is in standby mode
                        System.out.println("Seleziona il programma:");
                        // Display available programs
                        for (int i = 0; i < l.getElencoProgrammi().length; i++) {
                            System.out.print("(" + (i + 1) + ") ");
                            System.out.println(l.getElencoProgrammi()[i].toString());
                        }
                        sceltaProgramma = sc.nextInt(); // Read user input for program selection
                        sc.nextLine(); // Consume the newline character
                        l.selezionaProgramma(sceltaProgramma); // Set the selected program
                    } else if (l.getStato() == 0) { // Check if the washing machine is off
                        System.out.println("Lavatrice spenta.");
                    } else if (l.getStato() == 2) { // Check if a washing cycle is in progress
                        System.out.println("Lavaggio in corso");
                    }
                    break;
                case "7":
                    // Start the washing cycle
                    l.avviaLavaggio();
                    break;
                case "8":
                    // Terminate the washing cycle
                    l.terminaLavaggio();
                    break;
                case "00":
                    // Exit the program
                    System.out.println("Uscita...");
                    break;
                default:
                    // Handle invalid choices
                    System.out.println("Scelta non valida.");
                    break;
            }
        } while (!scelta.equals("00")); // Continue the loop until the user chooses to exit
        sc.close();
    }
}
