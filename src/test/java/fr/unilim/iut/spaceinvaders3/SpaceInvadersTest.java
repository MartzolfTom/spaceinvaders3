package fr.unilim.iut.spaceinvaders3;

import static org.junit.Assert.fail;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;


public class SpaceInvadersTest {

	
    private SpaceInvaders spaceinvaders;

    @Before
    public void initialisation() {
	    spaceinvaders = new SpaceInvaders(15, 10);
    }
   @Test
   public void test_AuDebut_JeuSpaceInvaderEstVide() {
	    assertEquals("" + 
	    "...............\n" + 
	    "...............\n" +
	    "...............\n" + 
	    "...............\n" + 
	    "...............\n" + 
	    "...............\n" + 
	    "...............\n" + 
	    "...............\n" + 
	    "...............\n" + 
	    "...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
        }

 

   @Test
	public void test_unNouveauVaisseauEstCorrectementPositionneDansEspaceJeu() {
		spaceinvaders.positionnerUnNouveauVaisseau(7,9);
		assertEquals("" + 
		"...............\n" + 
		"...............\n" +
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		".......V.......\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}
   	
   @Test
	public void test_UnNouveauVaisseauPositionneHorsEspaceJeu_DoitLeverUneException() {
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(15,9);
			fail("Position trop à droite : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(-1,9);
			fail("Position trop à gauche : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(14,10);
			fail("Position trop en bas : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(14,-1);
			fail("Position trop à haut : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
			
	}
   
   @Test
  	public void test_VaisseauAvance_DeplacerVaisseauVersLaDroite() {
  		
  		spaceinvaders.positionnerUnNouveauVaisseau(7,9);

  		spaceinvaders.deplacerVaisseauVersLaDroite();
  		
  		assertEquals("" + 
  		"...............\n" + 
  		"...............\n" +
  		"...............\n" + 
  		"...............\n" + 
  		"...............\n" + 
  		"...............\n" + 
  		"...............\n" + 
  		"...............\n" + 
  		"...............\n" + 
  		"........V......\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
  	}
   
	@Test
	public void test_VaisseauImmobile_DeplacerVaisseauVersLaDroite() {
		
		spaceinvaders.positionnerUnNouveauVaisseau(14,9);

		spaceinvaders.deplacerVaisseauVersLaDroite();
		
		assertEquals("" + 
		"...............\n" + 
		"...............\n" +
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"..............V\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}
}