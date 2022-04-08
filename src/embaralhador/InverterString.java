package embaralhador;

public class InverterString implements Embaralhador {

	@Override
	public String embaralhar(String palavra) {
		StringBuilder palavraDeRetorno = new StringBuilder();
		
		for (int i = palavra.length() - 1; i >= 0; i--) {
			palavraDeRetorno.append(palavra.charAt(i));
		}
		
		return palavraDeRetorno.toString();
	}

}
