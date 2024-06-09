package org.generation.italy.model;

/**
 * The Lavatrice class represents a washing machine with various functionalities.
 * It includes methods to manage the state of the washing machine, such as turning
 * it on/off, opening/closing the door, adding detergent, selecting programs, and
 * starting/stopping the washing process.
 */
public class Lavatrice {

    // Private instance variables
    private boolean sportelloChiuso; // Indicates if the door is closed
    private int stato; // Represents the state of the washing machine (0: off, 1: standby, 2: washing)
    private boolean detersivoPresente; // Indicates if detergent is present
    
    // Array of washing programs
    private Programma[] elencoProgrammi = new Programma[] {
        new Lavaggio("Cotone", 120, 90),
        new Lavaggio("Jeans", 60, 30),
        new Lavaggio("Delicati", 45, 30),
        new Operazione("Centrifuga", 20, false),
        new Operazione("Risciaquo", 30, true),
        new Operazione("Scarico acqua", 10, false)
    };
    
    private int programmaCorrente; // Index of the current selected program

    /**
     * Constructor for creating a new Lavatrice object with default settings.
     */
    public Lavatrice() {
        super();
        sportelloChiuso = false; // Initially, the door is open
        stato = 0; // Initially, the washing machine is off
        detersivoPresente = false; // Initially, no detergent is present
        programmaCorrente = 0; // No program selected initially
    }

    /**
     * Turns on the washing machine and sets it to standby mode.
     */
    public void accendi() {
        if (stato == 0) {
            stato = 1; // Change state to standby
            System.out.println("Hai acceso la lavatrice ");
            System.out.println("Modalità: Stand by ");
        } else if (stato == 2) {
            System.out.println("Lavaggio in corso, e la lavatrice è già accesa");
        } else if (stato == 1) {
            System.out.println("La lavatrice è gia accesa in modalità Stand by");
        }
    }

    /**
     * Turns off the washing machine, if not currently washing.
     */
    public void spegni() {
        if (stato == 1) {
            stato = 0; // Change state to off
            sportelloChiuso = false; // Open the door
            detersivoPresente = false; // Remove detergent
            programmaCorrente = 0; // Reset the program
            System.out.println("Hai spento la lavatrice ");
        } else if (stato == 2) {
            System.out.println("Lavaggio in corso, termina prima il lavaggio");
        } else if (stato == 0) {
            System.out.println("La lavatrice è gia spenta");
        }
    }

    /**
     * Opens the washing machine door if possible.
     */
    public void apriSportello() {
        if (stato == 1 && sportelloChiuso) {
            sportelloChiuso = false; // Open the door
            System.out.println("Hai aperto lo sportello ");
        } else if (stato == 0) {
            System.out.println("Lavatrice spenta");
        } else if (stato == 2) {
            System.out.println("Lavaggio in corso impossibile aprire lo sportello, termina prima il lavaggio");
        } else if (stato == 1 && !sportelloChiuso) {
            System.out.println("Sportello gia aperto ");
        }
    }

    /**
     * Closes the washing machine door if possible.
     */
    public void chiudiSportello() {
        if ((stato == 1 || stato == 2) && sportelloChiuso) {
            System.out.println("Sportello già chiuso ");
        } else if (stato == 0) {
            System.out.println("Lavatrice spenta");
        } else if (stato == 1 && !sportelloChiuso) {
            sportelloChiuso = true; // Close the door
            System.out.println("Hai chiuso lo sportello ");
        }
    }

    /**
     * Adds detergent to the washing machine if possible.
     */
    public void aggiungiDetersivo() {
        if (stato == 1) {
            detersivoPresente = true; // Add detergent
            System.out.println("Hai aggiunto il detersivo ");
        } else if (stato == 2) {
            System.out.println("Lavaggio in corso, termina prima il lavaggio");
        } else if (stato == 0) {
            System.out.println("Lavatrice spenta accendila per poter aggiungere il detersivo");
        }
    }

    /**
     * Selects a washing program by its index.
     * @param programma The index of the program to be selected.
     */
    public void selezionaProgramma(int programma) {
        for (int i = 0; i < elencoProgrammi.length; i++) {
            if (i == programma - 1) {
                programmaCorrente = programma; // Set the current program
            }
        }
    }

    /**
     * Starts the washing cycle if all conditions are met.
     */
    public void avviaLavaggio() {
        if (stato == 1 && !detersivoPresente && sportelloChiuso) {
            System.out.println("Deterivo non presente.. Aggiungilo..");
        } else if (stato == 1 && detersivoPresente && !sportelloChiuso) {
            System.out.println("Sportello aperto.. Chiudilo..");
        } else if (stato == 1 && !detersivoPresente && !sportelloChiuso) {
            System.out.println("Deterivo non presente.. Aggiungilo..");
            System.out.println("Sportello aperto.. Chiudilo..");
        } else if (stato == 1 && detersivoPresente && sportelloChiuso && programmaCorrente != 0) {
            stato = 2; // Change state to washing
            System.out.println("Programma " + elencoProgrammi[programmaCorrente - 1].nome + " in corso. "
                    + "Durata prevista: " + elencoProgrammi[programmaCorrente - 1].durata + " minuti.");
        } else if (stato == 2) {
            System.out.println("Lavaggio già in corso");
        } else if (stato == 0) {
            System.out.println("Lavatrice già spenta");
        }
        if (programmaCorrente == 0 && stato == 1) {
            System.out.println("Non hai selezionato nessun programma");
        }
    }

    /**
     * Terminates the washing cycle if in progress.
     */
    public void terminaLavaggio() {
        if (stato == 1) {
            System.out.println("Nessun lavaggio in corso");
        } else if (stato == 2) {
            stato = 1; // Change state to standby
            System.out.println("Hai terminato il lavaggio");
        } else if (stato == 0) {
            System.out.println("Lavatrice già spenta");
        }
    }

    // Getter methods to access private variables

    public boolean isSportelloChiuso() {
        return sportelloChiuso;
    }

    public int getStato() {
        return stato;
    }

    public boolean isDetersivoPresente() {
        return detersivoPresente;
    }

    public Programma[] getElencoProgrammi() {
        return elencoProgrammi;
    }
}
