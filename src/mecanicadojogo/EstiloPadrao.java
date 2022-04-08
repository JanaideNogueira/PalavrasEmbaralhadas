package mecanicadojogo;

import embaralhador.Embaralhador;
import embaralhador.FabricaEmbaralhadores;
import palavras.BancoDePalavras;

public class EstiloPadrao implements MecanicaDoJogo {

    private String palavraGerada;
    private boolean tentarNovamente = false;
    private static final int MAXIMO_TENTATIVAS_POR_PALAVRAS = 3;
    private int numeroTentativasPorPalavra;
    private Embaralhador embaralhador;
    BancoDePalavras bancoDePalavras;
    private int pontuacaoFinal;

    @Override
    public void iniciar() {
        System.out.println("Estilo de jogo \"Estilo Padrão\"!");
        embaralhador = FabricaEmbaralhadores.criaEmbaralhador();
        tentarNovamente = false;
        numeroTentativasPorPalavra = 0;
        bancoDePalavras = new BancoDePalavras();
        bancoDePalavras.carregarPalavras();
        pontuacaoFinal = 0;
    }

    @Override
    public String dicas() {
        StringBuilder dicas = new StringBuilder();
        dicas.append("Neste estilo de jogo as palavras geradas estarão embaralhadas,");
        dicas.append("\n e você deverá tentar acertar a palavra gerada. ");
        dicas.append("\n Caso erre, você terá até 3 tentativas para acerta cada palavra");
        dicas.append("\n A pontuação varia de acordo com o número de tentativas que você");
        dicas.append("\n necessitou para acertar a palavra:");
        dicas.append("\n \t- 1 tentativa - 3 pontos");
        dicas.append("\n \t- 2 tentativa - 2 pontos");
        dicas.append("\n \t- 3 tentativa - 1 pontos");
        dicas.append("\n O tipo de embaralhamento é escolhido no inicio e se mantém");
        dicas.append("\n  o mesmo até o final.");
        dicas.append("\nBom jogo.");
        return dicas.toString();
    }
    
    
    @Override
    public boolean isTerminou() {
        return (!tentarNovamente && bancoDePalavras.isNaoHaMaisPalavras()) || (tentarNovamente && numeroDeTentativasPorPalavraEsgotado() && bancoDePalavras.isNaoHaMaisPalavras());
    }

    @Override
    public boolean verificaSeAcertouPalavraEPontua(String palavra) {
        boolean acertou;
        acertou = palavraGerada.equals(palavra);
        numeroTentativasPorPalavra++;

        if (acertou) {
            pontuacaoFinal += calcularPontuacao();
            tentarNovamente = false;
        }

        return acertou;
    }
    
    private int calcularPontuacao() {
        return (4 - numeroTentativasPorPalavra);
    }

    @Override
    public int getPontuacaoFinal() {
        return this.pontuacaoFinal;
    }

    @Override
    public String proximaPalavra() {
        if (tentarNovamente == false || this.numeroDeTentativasPorPalavraEsgotado()) {
            numeroTentativasPorPalavra = 0;
            palavraGerada = bancoDePalavras.pegaPalavra();
        }
        return embaralhador.embaralhar(palavraGerada);
    }

    @Override
    public void tentarNovamenteMesmaPalavra() {
        tentarNovamente = true;
    }

    @Override
    public boolean numeroDeTentativasPorPalavraEsgotado() {
        return this.numeroTentativasPorPalavra >= MAXIMO_TENTATIVAS_POR_PALAVRAS;
    }
}
