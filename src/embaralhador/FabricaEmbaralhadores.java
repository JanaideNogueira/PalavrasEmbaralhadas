package embaralhador;

import java.util.Random;

public class FabricaEmbaralhadores {
	
	private static final float NUMERO_EMBARALHADORES_IMPLEMENTADOS = 2f;
	
	public static Embaralhador criaEmbaralhador(){
		Embaralhador embaralhador;
		
                
		int embaralhadorAleatorio = (int)Math.round((NUMERO_EMBARALHADORES_IMPLEMENTADOS - 1.0) * Math.random()); 
		
		switch (embaralhadorAleatorio) {
			case 0:
				embaralhador = new InverterString();
				break;
			case 1:
				embaralhador = new TrocaParComImpar();
				break;
			default:
				embaralhador = new InverterString();
				break;
		}
		
		return embaralhador;
	}
}
