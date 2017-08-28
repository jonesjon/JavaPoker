import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import jogo.Carta;

public class Baralho {
	
	// paus, copas,espada, ouro
	char[] naipes = {(char)'\u2663' , (char)'\u2764' , (char)'\u2660' , (char)'\u2666'};
	               
	String[] valores = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};	
	private ArrayList<Carta> baralho = null;

	public Baralho() {
		this.baralho = new ArrayList<Carta>();
		for(int i = 0; i < 4; i++) {
			
			for(int j = 0; j < 13; j++){
				
				Carta carta = new Carta( this.naipes[i] , this.valores[j]);
				this.baralho.add(carta);
				
			}
			
		}
	}
	
	
	public void embaralhar() {
		ArrayList<Carta> embaralhado = new ArrayList<Carta>();
		
		int quantidade_de_escolhas = 52;
		
		Random random = new Random();
		do {
			int posicaoSelecionada = random.nextInt(quantidade_de_escolhas);
			Carta provisoria = this.baralho.get(posicaoSelecionada);
			embaralhado.add(provisoria);
			this.baralho.remove(posicaoSelecionada);		
			quantidade_de_escolhas--;
		}
		while(quantidade_de_escolhas > 0);
		this.baralho = embaralhado;
	}


	public ArrayList<Carta> getBaralho() {
		return baralho;
	}


	public void setBaralho(ArrayList<Carta> baralho) {
		this.baralho = baralho;
	}
	
	
}
