package org.generation.italy.model;

public class Programma {

	protected String nome;
	protected int durata;
	public Programma(String nome, int durata) {
		super();
		this.nome = nome;
		this.durata = durata;
	}
	public Programma() {
		super();
		this.nome = null;
		this.durata = 0;
	}
	@Override
	public String toString() {
		return "Programma [nome=" + nome + ", durata=" + durata + "]";
	}
	
}
