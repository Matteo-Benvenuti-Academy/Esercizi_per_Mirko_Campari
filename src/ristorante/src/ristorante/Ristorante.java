package Java.ristorante.src.ristorante;

import java.util.ArrayList;

public class Ristorante {
	
	private ArrayList<Pietanza> listaPietanze; ;
	private double  contoAperto = 0;
	
	public Ristorante() {
		this.listaPietanze = new ArrayList<Pietanza>();
	}
	
	public Ristorante(ArrayList<Pietanza> listaPietanze) {
		this.listaPietanze = listaPietanze;
	}
	
	public Pietanza ordina(int index,double budget) {
		if (index < listaPietanze.size() && this.listaPietanze.get(index).getPrezzo()<=budget) {
			Pietanza pietanza = this.listaPietanze.get(index);	
			System.out.println("Hai ordinato"+ pietanza.getNome());
			this.contoAperto +=  pietanza.getPrezzo();
			return pietanza;
		}
		return null;
	}
	
	public void visualizza(int index) {
		System.out.println(listaPietanze.get(index).getIngredienti());
	}
	
	public void aggiungiPietanza(Pietanza pietanza) {
		this.listaPietanze.add(pietanza);
	}

	public void rimuoviPietanza(int index) {
		this.listaPietanze.remove(index);
	}

	public void modificaNome(int index,String nome) {
		this.listaPietanze.get(index).setName(nome);
	}
	
	
	public double getContoAperto() {
		return contoAperto;
	}

	public ArrayList<Pietanza> getListaPietanze(){
		return listaPietanze;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		for(int i=0 ; i<this.listaPietanze.size();i++) {
			result.append((i+1)+") "+listaPietanze.get(i)+"\n");
		}
		return result.toString();
	}
	
}
