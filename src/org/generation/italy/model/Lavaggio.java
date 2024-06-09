package org.generation.italy.model;

public class Lavaggio extends Programma {

	private int temperatura;

	public Lavaggio(String nome, int durata, int temperatura) {
		super(nome, durata);
		this.temperatura = temperatura;
	}

	@Override
	public String toString() {
		return "Programma [nome=" + nome + ", durata=" + durata + " minuti, Lavaggio [temperatura=" + temperatura + " gradi]";
	}
	
}
