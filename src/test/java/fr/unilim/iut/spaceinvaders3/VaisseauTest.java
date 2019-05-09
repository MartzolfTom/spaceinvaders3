package fr.unilim.iut.spaceinvaders3;

import org.junit.Test;

import fr.unilim.iut.spaceinvaders3.model.Dimension;
import fr.unilim.iut.spaceinvaders3.model.Position;
import fr.unilim.iut.spaceinvaders3.model.Vaisseau;
import fr.unilim.iut.spaceinvaders3.utils.MissileException;

public class VaisseauTest {

	  @Test(expected = MissileException.class)
		public void test_LongueurMissileSuperieureALongueurVaisseau_UneExceptionEstLevee() throws Exception {
			Vaisseau vaisseau = new Vaisseau(new Dimension(5,2),new Position(5,9), 1);
			vaisseau.tirerUnMissile(new Dimension(7,2),1);
		}
	    
}
