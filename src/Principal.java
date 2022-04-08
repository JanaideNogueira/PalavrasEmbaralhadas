import java.util.Scanner;

import mecanicadojogo.FabricaMecanicaDoJogo;
import mecanicadojogo.MecanicaDoJogo;

public class Principal {

    public static void main(String[] args) {
        FabricaMecanicaDoJogo fabricaJogo;
        MecanicaDoJogo jogo;
        String palavra;

        fabricaJogo = new FabricaMecanicaDoJogo();

        System.out.println("Inicio do jogo de palavras embaralhadas do TWS!");
        
        System.out.println("Escolha um dos estilos de jogo:");
        System.out.println("\t1) Estilo padrão; (*)");
        System.out.println("\t2) Morte súbita:");
        System.out.println();
        System.out.println("\t(*) opção padrão");
        System.out.println();

        System.out.print("Digite o estilo escolhido: ");
        
        int escolha = leInteiroDoTeclado();
        jogo = fabricaJogo.criaEstiloDeJogo(escolha - 1);
        System.out.println();
        jogo.iniciar();

        System.out.println();
        System.out.println("Dicas e Informações: ");
        System.out.println(jogo.dicas());
        System.out.println();
        
        while (!jogo.isTerminou()) {
            System.out.println("Descubra que palavra é esta: " + jogo.proximaPalavra());
            System.out.print("Digite aqui a \"palavra correta\" ou -1 para sair do jogo: ");
            palavra = lePalavraDoTeclado();

            if (palavra.equals("-1")) {
                // sair
                break;
            }

            if (jogo.verificaSeAcertouPalavraEPontua(palavra)) {
                System.out.println("Parabéns, você acertou!!!!!");
                System.out.println("Próxima palavra!!!!!");
            } else {
                System.out.println("Você errou!!!!!");

                if (!jogo.numeroDeTentativasPorPalavraEsgotado()) {
                    System.out.println();
                    System.out.print("Deseja tentar a mesma palavra novamente? (digite \"s\" ou \"sim\" para tentar): ");
                    palavra = lePalavraDoTeclado();

                    if (palavra.equals("s") || palavra.equals("sim")) {
                        System.out.println("Tente novamente!");
                        jogo.tentarNovamenteMesmaPalavra();
                    }
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Você fez " + jogo.getPontuacaoFinal() + " pontos!");
        System.out.println("Fim do jogo!");
    }

    public static String lePalavraDoTeclado() {
        String palavra;
        Scanner in = new Scanner(System.in, "UTF-8");
        palavra = in.nextLine();
        return palavra;
    }
    
    public static int leInteiroDoTeclado() {
        int inteiro;
        Scanner in = new Scanner(System.in);
        inteiro = in.nextInt();
        return inteiro;
    }    
}
