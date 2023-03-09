package Java.ristorante.src.ristorante;

import java.util.ArrayList;
import java.util.Arrays;

public class Pietanza {

	private String nome;
	private double prezzo;
	private ArrayList<String> ingredienti = new ArrayList<String>();

	public Pietanza(String nome, double prezzo, String[] ingredienti) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.ingredienti = new ArrayList<>(Arrays.asList(ingredienti));
	}

	public ArrayList<String> getIngredienti() {
		return this.ingredienti;
	}

	public String getNome() {
		return nome;
	}

	public double getPrezzo() {
		return prezzo;
	}
	
	public void setName(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome + " | " + prezzo;
	}

}
