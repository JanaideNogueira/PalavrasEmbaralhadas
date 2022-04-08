package embaralhador;

public class TrocaParComImpar implements Embaralhador {

	@Override
	public String embaralhar(String palavra) {
		int i;
		StringBuilder palavraDeRetorno = new StringBuilder();
		
		for (i = 0; i < (palavra.length() - 1); i+=2) {
			palavraDeRetorno.append(palavra.charAt(i+1));
			palavraDeRetorno.append(palavra.charAt(i));
		}
		
		if (i < palavra.length()) {
			palavraDeRetorno.append(palavra.charAt(i));
		}
		
		return palavraDeRetorno.toString();
	}

}
