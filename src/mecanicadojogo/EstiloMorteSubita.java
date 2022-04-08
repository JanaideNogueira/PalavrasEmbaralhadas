package mecanicadojogo;

import embaralhador.Embaralhador;
import embaralhador.FabricaEmbaralhadores;
import palavras.BancoDePalavras;

public class EstiloMorteSubita implements MecanicaDoJogo {

    private String palavraGerada;
    BancoDePalavras bancoDePalavras;
    private int pontuacaoFinal;
    private boolean morteSubita;

    @Override
    public void iniciar() {
        System.out.println("Estilo de jogo \"Morte Súbita\"!");
        morteSubita = false;
        bancoDePalavras = new BancoDePalavras();
        bancoDePalavras.carregarPalavras();
        pontuacaoFinal = 0;
    }
    
    @Override
    public String dicas() {
        StringBuilder dicas = new StringBuilder();
        dicas.append("Neste estilo de jogo as palavras geradas estarão embaralhadas,");
        dicas.append("\n e você deverá tentar acertar a palavra gerada. ");
        dicas.append("\n Você terá somente 1 tentativas para acerta cada palavra.");
        dicas.append("\n Em caso de erro o jogo acaba.");
        dicas.append("\n A pontuação é 1 ponto por acerto");
        dicas.append("\n O tipo de embaralhamento é escolhido a cada palavra gerada");
        dicas.append("\nBom jogo.");
        return dicas.toString();
    }
    
    @Override
    public boolean isTerminou() {
        return morteSubita || bancoDePalavras.isNaoHaMaisPalavras();
    }

    @Override
    public boolean verificaSeAcertouPalavraEPontua(String palavra) {
        boolean acertou;
        acertou = palavraGerada.equals(palavra);

        if (acertou) {
            pontuacaoFinal += calcularPontuacao();
        } else {
            morteSubita = true;
        }

        return acertou;
    }

    private int calcularPontuacao() {
        return 1;
    }

    @Override
    public int getPontuacaoFinal() {
        return this.pontuacaoFinal;
    }

    @Override
    public String proximaPalavra() {
        Embaralhador embaralhador;
        palavraGerada = bancoDePalavras.pegaPalavra();
        embaralhador = FabricaEmbaralhadores.criaEmbaralhador();
        return embaralhador.embaralhar(palavraGerada);
    }

    @Override
    public void tentarNovamenteMesmaPalavra() {
     
    }

    @Override
    public boolean numeroDeTentativasPorPalavraEsgotado() {
      
        return true;
    }

}
