package mecanicadojogo;

public class FabricaMecanicaDoJogo {

    public MecanicaDoJogo criaEstiloDeJogo(int estilo) {
        switch (estilo) {
            case 0:
                return new EstiloPadrao();
            case 1:
                return new EstiloMorteSubita();
            default:
                return new EstiloPadrao();
        }
    }
}
