
package fr.unilim.iut.spaceinvaders3;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

import fr.unilim.iut.spaceinvaders3.model.Collision;
import fr.unilim.iut.spaceinvaders3.model.Dimension;
import fr.unilim.iut.spaceinvaders3.model.Direction;
import fr.unilim.iut.spaceinvaders3.model.Envahisseur;
import fr.unilim.iut.spaceinvaders3.model.Missile;
import fr.unilim.iut.spaceinvaders3.model.Position;

public class CollisionTest {
	@Test
	public void test_CollisionNormaleEnBasAGaucheAvecEnvahisseurDeplacementDroite() {
		Envahisseur envahisseur = new Envahisseur(new Dimension(3,3), new Position(5, 2), 1);
		Missile missile = new Missile(new Dimension(2, 3), new Position(5, 10), 1);
		
		Collision collision = new Collision(missile, envahisseur);
		
		for (int i = 0; i < 8; i++) {
			collision.sprite.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		}
		collision.cible.deplacerHorizontalementVers(Direction.DROITE);
		
		assertTrue(collision.detecterCollision());
	}
	
	@Test
	public void test_CollisionLimiteEnBasAGaucheAvecEnvahisseurDeplacementDroite() {
		Envahisseur envahisseur = new Envahisseur(new Dimension(3,3), new Position(5, 2), 1);
		Missile missile = new Missile(new Dimension(2, 3), new Position(5, 10), 1);
		
		Collision collision = new Collision(missile, envahisseur);
		
		for (int i = 0; i < 6; i++) {
			collision.sprite.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		}
		collision.cible.deplacerVerticalementVers(Direction.DROITE);
		
		assertTrue(collision.detecterCollision());
	}
	
	@Test
	public void test_CollisionNormalEnBasADroiteAvecEnvahisseurDeplacementDroite() {
		Envahisseur envahisseur = new Envahisseur(new Dimension(3,3), new Position(5, 2), 1);
		Missile missile = new Missile(new Dimension(2, 3), new Position(7, 10), 1);
		
		Collision collision = new Collision(missile, envahisseur);
		
		for (int i = 0; i < 8; i++) {
			collision.sprite.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		}
		collision.cible.deplacerHorizontalementVers(Direction.DROITE);
		
		assertTrue(collision.detecterCollision());
	}
	
	@Test
	public void test_CollisionLimiteEnBasADroiteAvecEnvahisseurDeplacementDroite() {
		Envahisseur envahisseur = new Envahisseur(new Dimension(3,3), new Position(5, 2), 1);
		Missile missile = new Missile(new Dimension(2, 3), new Position(7, 10), 1);
		
		Collision collision = new Collision(missile, envahisseur);
		
		for (int i = 0; i < 6; i++) {
			collision.sprite.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		}
		collision.cible.deplacerHorizontalementVers(Direction.DROITE);
		
		assertTrue(collision.detecterCollision());
	}
	
	@Test
	public void test_CollisionNormaleEnHautAGaucheAvecEnvahisseurDeplacementDroite() {
		Envahisseur envahisseur = new Envahisseur(new Dimension(3,3), new Position(5, 2), 1);
		Missile missile = new Missile(new Dimension(2, 3), new Position(5, 10), 1);

		Collision collision = new Collision(missile, envahisseur);
		
		for (int i = 0; i < 9; i++) {
			collision.sprite.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		}
		collision.cible.deplacerHorizontalementVers(Direction.DROITE);
		
		assertTrue(collision.detecterCollision());
	}
	
	@Test
	public void  test_CollisionLimiteEnHautAGaucheAvecEnvahisseurDeplacementDroite() {
		Envahisseur envahisseur = new Envahisseur(new Dimension(3,3), new Position(5, 2), 1);
		Missile missile = new Missile(new Dimension(2, 3), new Position(5, 10), 1);

		Collision collision = new Collision(missile, envahisseur);
		
		for (int i = 0; i < 10; i++) {
			collision.sprite.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		}
		collision.cible.deplacerHorizontalementVers(Direction.DROITE);
		
		assertTrue(collision.detecterCollision());
	}	
	
	@Test
	public void test_CollisionNormaleEnHautADroiteAvecEnvahisseurDeplacementDroite() {
		Envahisseur envahisseur = new Envahisseur(new Dimension(3,3), new Position(5, 2), 1);
		Missile missile = new Missile(new Dimension(2, 3), new Position(7, 10), 1);
		
		Collision collision = new Collision(missile, envahisseur);		
		
		for (int i = 0; i < 9; i++) {
			collision.sprite.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		}
		collision.cible.deplacerHorizontalementVers(Direction.DROITE);

		assertTrue(collision.detecterCollision());
	}
	
	@Test
	public void test_CollisisionLimiteEnHautADroiteAvecEnvahisseurDeplacementDroite() {
		Envahisseur envahisseur = new Envahisseur(new Dimension(3,3), new Position(5, 2), 1);
		Missile missile = new Missile(new Dimension(2, 3), new Position(7, 10), 1);
		
		Collision collision = new Collision(missile, envahisseur);		
		
		for (int i = 0; i < 10; i++) {
			collision.sprite.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		}
		collision.cible.deplacerHorizontalementVers(Direction.DROITE);

		assertTrue(collision.detecterCollision());
	}
	
	
	
	@Test
	public void test_CollisionNormaleEnBasAGaucheAvecEnvahisseurDeplacementGauche() {
		Envahisseur envahisseur = new Envahisseur(new Dimension(3,3), new Position(7, 2), 1);
		Missile missile = new Missile(new Dimension(2, 3), new Position(5, 10), 1);
		
		Collision collision = new Collision(missile, envahisseur);
		
		for (int i = 0; i < 8; i++) {
			collision.sprite.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		}
		collision.cible.deplacerHorizontalementVers(Direction.GAUCHE);
		
		assertTrue(collision.detecterCollision());
	}
	
	@Test
	public void test_CollisionLimiteEnBasAGaucheAvecEnvahisseurDeplacementGauche() {
		Envahisseur envahisseur = new Envahisseur(new Dimension(3,3), new Position(7, 2), 1);
		Missile missile = new Missile(new Dimension(2, 3), new Position(5, 10), 1);
		
		Collision collision = new Collision(missile, envahisseur);
		
		for (int i = 0; i < 6; i++) {
			collision.sprite.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		}
		collision.cible.deplacerHorizontalementVers(Direction.GAUCHE);
		
		assertTrue(collision.detecterCollision());
	}
	
	@Test
	public void test_CollisionNormalEnBasADroiteAvecEnvahisseurDeplacementGauche() {
		Envahisseur envahisseur = new Envahisseur(new Dimension(3,3), new Position(7, 2), 1);
		Missile missile = new Missile(new Dimension(2, 3), new Position(7, 10), 1);
		
		Collision collision = new Collision(missile, envahisseur);
		
		for (int i = 0; i < 8; i++) {
			collision.sprite.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		}
		collision.cible.deplacerHorizontalementVers(Direction.GAUCHE);
		
		assertTrue(collision.detecterCollision());
	}
	
	@Test
	public void test_CollisionLimiteEnBasADroiteAvecEnvahisseurDeplacementGauche() {
		Envahisseur envahisseur = new Envahisseur(new Dimension(3,3), new Position(7, 2), 1);
		Missile missile = new Missile(new Dimension(2, 3), new Position(7, 10), 1);
		
		Collision collision = new Collision(missile, envahisseur);
		
		for (int i = 0; i < 6; i++) {
			collision.sprite.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		}
		collision.cible.deplacerHorizontalementVers(Direction.GAUCHE);
		
		assertTrue(collision.detecterCollision());
	}
	
	@Test
	public void test_CollisionNormaleEnHautAGaucheAvecEnvahisseurDeplacementGauche() {
		Envahisseur envahisseur = new Envahisseur(new Dimension(3,3), new Position(7, 2), 1);
		Missile missile = new Missile(new Dimension(2, 3), new Position(5, 10), 1);

		Collision collision = new Collision(missile, envahisseur);
		
		for (int i = 0; i < 9; i++) {
			collision.sprite.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		}
		collision.cible.deplacerHorizontalementVers(Direction.GAUCHE);
		
		assertTrue(collision.detecterCollision());
	}
	
	@Test
	public void  test_CollisionLimiteEnHautAGaucheAvecEnvahisseurDeplacementGauche() {
		Envahisseur envahisseur = new Envahisseur(new Dimension(3,3), new Position(7, 2), 1);
		Missile missile = new Missile(new Dimension(2, 3), new Position(5, 10), 1);

		Collision collision = new Collision(missile, envahisseur);
		
		for (int i = 0; i < 10; i++) {
			collision.sprite.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		}
		collision.cible.deplacerHorizontalementVers(Direction.GAUCHE);
		
		assertTrue(collision.detecterCollision());
	}	
	
	@Test
	public void test_CollisionNormaleEnHautADroiteAvecEnvahisseurDeplacementGauche() {
		Envahisseur envahisseur = new Envahisseur(new Dimension(3,3), new Position(7, 2), 1);
		Missile missile = new Missile(new Dimension(2, 3), new Position(7, 10), 1);
		
		Collision collision = new Collision(missile, envahisseur);		
		
		for (int i = 0; i < 9; i++) {
			collision.sprite.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		}
		collision.cible.deplacerHorizontalementVers(Direction.GAUCHE);

		assertTrue(collision.detecterCollision());
	}

	@Test
	public void test_ColiisionLimiteEnHautADroiteAvecEnvahisseurDeplacementaGauche() {
		Envahisseur envahisseur = new Envahisseur(new Dimension(3,3), new Position(7, 2), 1);
		Missile missile = new Missile(new Dimension(2, 3), new Position(7, 10), 1);
		
		Collision collision = new Collision(missile, envahisseur);		
		
		for (int i = 0; i < 10; i++) {
			collision.sprite.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		}
		collision.cible.deplacerHorizontalementVers(Direction.GAUCHE);

		assertTrue(collision.detecterCollision());
	}
}
