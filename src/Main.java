import java.util.ArrayList;
import java.util.Scanner;

import jogo.Carta;
import jogo.Jogo;

public class Main {

	public static void main(String[] args) {
		System.out.println("\nIniciando o jogo\n");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o número de jogadores e tecle enter:");
		int qtdDePlayers = Integer.parseInt(input.nextLine());
		
		ArrayList<Jogador> jogadores = null;
		
		jogadores = criaPlayers(input, qtdDePlayers, jogadores);
		
		System.out.println("Qtd de players: " + jogadores.size());
		
		Baralho baralho = new Baralho();
		baralho.embaralhar();
		
		
		// iniciando a rodada
		ArrayList<Carta> baralhoDeJogo = baralho.getBaralho();
	
		
		distribui2Cartas(jogadores, baralhoDeJogo);	
		
		apresenta2CartasDosJogadores(jogadores);
		
		System.out.println("Sobraram " + baralhoDeJogo.size() + " cartas");
		
		int qntsVaoJogar = 0;
		
		qntsVaoJogar = decideSeSaiOuContinua(input , jogadores , qntsVaoJogar);
		System.out.println("Jogadores que continuam na rodada: " + qntsVaoJogar);
		
		if(qntsVaoJogar >= 2) {
			//segue o jogo
			apresenta3CartasNaMesa(baralhoDeJogo);
			
		}else {
			// por enquanto nada (futuramente começa outra rodada)
			System.out.println("Para continuar a" + 
							"rodada precisam pelo menos de 2 jogadores");
		}
		
		
	}

	private static void apresenta3CartasNaMesa(ArrayList<Carta> baralhoDeJogo) {
		Carta carta1NaMesa , carta2NaMesa , carta3NaMesa;
		carta1NaMesa = baralhoDeJogo.get(0);
		baralhoDeJogo.remove(0);
		carta2NaMesa = baralhoDeJogo.get(0);
		baralhoDeJogo.remove(0);
		carta3NaMesa = baralhoDeJogo.get(0);
		baralhoDeJogo.remove(0);
		System.out.println("\n\n");
		System.out.println(carta1NaMesa.toString());
		System.out.println(carta2NaMesa.toString());
		System.out.println(carta3NaMesa.toString());
	}

	private static void apresenta2CartasDosJogadores(ArrayList<Jogador> jogadores) {
		for(int i= 0 ; i < jogadores.size() ; i++) {
			System.out.println("---------------");
			System.out.println("Nome:" + jogadores.get(i).getNome());
			System.out.println("Carta1:" + jogadores.get(i).getCartaUm());
			System.out.println("Carta2:" + jogadores.get(i).getCartaDois());
			System.out.println("---------------");
		}
	}

	private static void distribui2Cartas(ArrayList<Jogador> jogadores, ArrayList<Carta> baralhoDeJogo) {
		for(int i = 0 ; i < jogadores.size() ; i++) {
			
			Carta carta1, carta2;
			
			carta1 = baralhoDeJogo.get(0);
			baralhoDeJogo.remove(0);
			carta2 = baralhoDeJogo.get(0);
			baralhoDeJogo.remove(0);
			
			
			jogadores.get(i).setCartaUm(carta1);
			jogadores.get(i).setCartaDois(carta2);
		}
	}

	private static ArrayList<Jogador> criaPlayers(Scanner input, int qtdDePlayers, ArrayList<Jogador> jogadores) {
		jogadores = new ArrayList<Jogador>();
		for(int i = 1 ; i <= qtdDePlayers ; i++) {
			System.out.println("Digite o nome do jogador:" + i);
			String nome = input.nextLine();
			Jogador jogador = new Jogador(nome);
			jogadores.add(jogador);
		}
		return jogadores;
	}
	
	public static int decideSeSaiOuContinua(Scanner input , 
											 ArrayList<Jogador> jogadores , 
											 int qntsVaoJogar) {
		for(int i = 0 ; i < jogadores.size() ; i++) {
			Jogador jogadorAtual = jogadores.get(i);
			
			System.out.println("Continua no jogo " + jogadorAtual.getNome()+ " ?");
			System.out.println("1 - MESA\n2 - CORRE");
			int resposta = input.nextInt();
			
			boolean decisao = false;
			if (resposta == 1) {
				// o jogador decidiu continuar jogando
				decisao = true;
				qntsVaoJogar++;
			}else {
				// não vai jogar
				decisao = false;
			}
			jogadorAtual.setDecisao(decisao);
			System.out.println(jogadorAtual.getNome() + " respondeu " + jogadorAtual.getDecisao());
		}
		return qntsVaoJogar;
	}

}
