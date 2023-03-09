package Java.metodi;
public class Metodi {

//	Descrizione: Questo esercizio ha lo scopo di valutare
//	la capacità degli studenti di scrivere e utilizzare 
//	i metodi in java. Si prega di rispondere alle seguenti 
//	domande fornendo la risposta corretta.
	

//	Scrivere la definizione di un metodo in java chiamato
//	"somma" che prende due interi come argomenti e restituisce 
//	la loro somma.
	public static int somma(int n1 , int n2) {
		return n1+n2; //  uso l'operatore somma sui due interi e ritorno il risultato
	}
	
//	Scrivere la definizione di un metodo in java chiamato "media" 
//	che prende un array di numeri interi come argomento e restituisce
//	la loro media come un valore double.
	public static double media (int[] intArray) {
		
		double tot = 0; // inizializzo una variabile "tot" che conterra la somma di tutti gli elementi
		
		for( int n : intArray) { tot+=n;} // sommo tutti gli elemnti dell'array
		
		return tot / intArray.length; //ritorno la media dei valori dell'array
	}
	
	
//	Scrivere la definizione di un metodo in java chiamato "inverti" 
//	che prende una stringa come argomento e restituisce la stringa invertita.
	public static String inverti(String string) {
		// Creo un nuovo oggetto StringBuilder e uso il suo metodo "reverse" 
		//per invertire la stringa. Poi chiamo il metodo toString per riottenere la stringa.
		return new StringBuilder(string).reverse().toString();
	}
	
	
// 	Nel main ci sono le chiamate ai metodi.
	public static void main(String[] args) {
		
//		Scrivere il codice per chiamare il metodo "somma" definito
//		nella domanda 1, passando i valori 5 e 7 come argomenti e 
//		stampando il risultato.
		
		System.out.println(somma(5,7));
		
//		Scrivere il codice per chiamare il metodo "media" definito 
//		nella domanda 3, passando l'array {2, 4, 6, 8, 10} come 
//		argomento e stampando il risultato.
		
		int[] array1 = {2, 4, 6, 8, 10};
		System.out.println(media(array1));
		
		int[] array2 = {3, 4, 6, 8, 10};
		System.out.println(media(array2));
		
//		Scrivere il codice per chiamare il metodo "inverti" definito 
//		nella domanda 5, passando la stringa "ciao" come argomento e 
//		stampando il risultato.
		System.out.println(inverti("Ciao"));
		System.out.println(inverti("a"));
		
	}
}
