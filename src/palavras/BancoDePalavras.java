import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class BancoDePalavras {

    private static final String NOME_ARQUIVO = "lista-de-palavras.txt";

    private List<String> palavras;

    public void carregarPalavras() {
        palavras = new ArrayList<>();

        try {
            leArquivo();
        } catch (FileNotFoundException e) {
            carregaPalavrasPadrao();
            criaArquivo();
        } catch (IOException e) {
            System.err.println("Erro no carregamento das palavras!");
            e.printStackTrace();
        }
    }

    public String pegaPalavra() {
        int indice;

        indice = (int) ((double) (palavras.size() - 1) * Math.random());
        return palavras.remove(indice);
    }

    public boolean isNaoHaMaisPalavras() {
        return (palavras.size() <= 0);
    }

    private void leArquivo() throws IOException {
        File arquivo;
        BufferedReader br = null;
        String palavra;

        try {
            arquivo = new File(NOME_ARQUIVO);
            br = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "UTF8"));
            palavra = br.readLine();
            while (palavra != null && !palavra.isEmpty()) {
                palavras.add(palavra);
                palavra = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo " + NOME_ARQUIVO + ", não encontrado");
            throw e;
        } catch (IOException e) {
            System.err.println("Erro na leitura do arquivo " + NOME_ARQUIVO);
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    private void criaArquivo() {
        FileOutputStream fos;
        OutputStreamWriter osw;

        try {
            fos = new FileOutputStream(NOME_ARQUIVO);
            osw = new OutputStreamWriter(fos, Charset.forName("UTF-8"));

            for (String palavra : palavras) {
                osw.write(palavra + "\n");
            }

            osw.flush();
            osw.close();
        } catch (IOException e) {
            System.err.println("Erro na criação do arquivo padrão: " + NOME_ARQUIVO + ", erro: " + e);
            e.printStackTrace();
        }
        System.out.println("Arquivo " + NOME_ARQUIVO + " criado com sucesso!");
    }

    private void carregaPalavrasPadrao() {
        palavras.add("refrigerador");
        palavras.add("abacate");
        palavras.add("java");
        palavras.add("garrafa");
        palavras.add("rua");
        palavras.add("empresa");
        palavras.add("inconstitucionalissimamente");
        palavras.add("informal");
        palavras.add("beterraba");
        palavras.add("feira");

        System.out.println("Lista de palavras padrão carregadas com sucesso!");
    }
}
