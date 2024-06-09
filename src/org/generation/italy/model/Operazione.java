package org.generation.italy.model;

public class Operazione extends Programma {
	
	private boolean presenzaAcqua;

	public Operazione(String nome, int durata, boolean presenzaAcqua) {
		super(nome, durata);
		this.presenzaAcqua = presenzaAcqua;
	}

	@Override
	public String toString() {
		return "Programma [nome=" + nome + ", durata=" + durata + " minuti, Operazione [presenzaAcqua=" + presenzaAcqua + "]";
	}
	
}
