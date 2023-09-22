package com.example;

public class Jogo {

    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();
    protected Monte monte = new Monte();

    public Jogo(){
        monte.embaralhar();
    }

    public Carta distribuirCartaParaJogador(Jogador jogador){
        if(jogador.parou()){
            return null;
        }

        var carta = monte.virar();
        jogador.receberCarta(carta);

        return carta;
    }

    public boolean acabou(){
        var jogadoresPararam = jogador.parou() && computador.parou();
        var jogadoresEstouraram = jogador.getPontos() > 21 && computador.getPontos() > 21;

        return jogadoresPararam || jogadoresEstouraram;
    }

    public String resultado(){
        var jogadorEstourou = jogador.getPontos() > 21;
        var computadorEstourou = computador.getPontos() > 21;
        var jogadorTemMaisPontos = jogador.getPontos() > computador.getPontos();
        var pontosSaoIguais = jogador.getPontos() == computador.getPontos();

        var jogadorGanhou = !jogadorEstourou && (jogadorTemMaisPontos || computadorEstourou);
        
        var emaptou = pontosSaoIguais || (jogadorEstourou && computadorEstourou);

        if(jogadorGanhou){
            return "Você Ganhou!";
        }
        if(emaptou){
            return "Empatou";
        }
        return "Você Perdeu";

    }
    
}
