package mecanicadojogo;

public interface MecanicaDoJogo {
	public void iniciar();
        public String dicas();
	public boolean isTerminou();
	public boolean verificaSeAcertouPalavraEPontua(String palavra);
	public int getPontuacaoFinal();
	public String proximaPalavra();
	public void tentarNovamenteMesmaPalavra();
	public boolean numeroDeTentativasPorPalavraEsgotado();
}
