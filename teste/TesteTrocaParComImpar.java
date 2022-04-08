import static org.junit.Assert.*;

import org.junit.Test;

import embaralhador.Embaralhador;
import embaralhador.InverterString;
import embaralhador.TrocaParComImpar;

public class TesteTrocaParComImpar {

	@Test
	public void testEmbaralharArmario() {
		Embaralhador emb = new TrocaParComImpar();
		assertEquals("raamir", emb.embaralhar("armario"));
	}

	@Test
	public void testEmbaralharInconstitucionalissimamente() {
		Embaralhador emb = new TrocaParComImpar();
		assertEquals("niocsnituticnolasiisamemtn", emb.embaralhar("inconstitucionalissimamente"));
	}

	@Test
	public void testEmbaralharFeira() {
		Embaralhador emb = new TrocaParComImpar();
		assertEquals("efri", emb.embaralhar("feira"));
	}

}
