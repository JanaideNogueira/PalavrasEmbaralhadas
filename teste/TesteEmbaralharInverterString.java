import static org.junit.Assert.*;

import org.junit.Test;

import embaralhador.Embaralhador;
import embaralhador.InverterString;

public class TesteEmbaralharInverterString {

	@Test
	public void testEmbaralharArmario() {
		Embaralhador emb = new InverterString();
		assertEquals("ixacaba", emb.embaralhar("abacaxi"));
	}

	@Test
	public void testEmbaralharInconstitucionalissimamente() {
		Embaralhador emb = new InverterString();
		assertEquals("zorra", emb.embaralhar("arroz"));
	}

	@Test
	public void testEmbaralharFeira() {
		Embaralhador emb = new InverterString();
		assertEquals("mevoj", emb.embaralhar("jovem"));
	}
}
