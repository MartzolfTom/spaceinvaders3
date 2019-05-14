package fr.unilim.iut.spaceinvaders3.model;

import fr.unilim.iut.spaceinvaders3.moteurJeu.Commande;
import fr.unilim.iut.spaceinvaders3.moteurJeu.Jeu;
import fr.unilim.iut.spaceinvaders3.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders3.utils.HorsEspaceJeuException;
import fr.unilim.iut.spaceinvaders3.utils.MissileException;

public class SpaceInvaders implements Jeu {

	private static final char MARQUE_FIN_LIGNE = '\n';
	int longueur;
	int hauteur;
	Vaisseau vaisseau;
	Missile missile;
	Envahisseur envahisseur;
	boolean arriveAuMurGauche = false;

	public SpaceInvaders(int longueur, int hauteur) {
		this.longueur = longueur;
		this.hauteur = hauteur;
	}

	public void initialiserJeu() {
		Position positionVaisseau = new Position(this.longueur / 2, this.hauteur - 1);
		Dimension dimensionVaisseau = new Dimension(Constante.VAISSEAU_LONGUEUR, Constante.VAISSEAU_HAUTEUR);
		Position positionEnvahisseur = new Position(this.longueur / 2, 80);
		Dimension dimensionEnvahisseur = new Dimension(Constante.ENVAHISSEUR_LONGUEUR, Constante.ENVAHISSEUR_HAUTEUR);
		positionnerUnNouveauVaisseau(dimensionVaisseau, positionVaisseau, Constante.VAISSEAU_VITESSE);
		positionnerUnNouveauEnvahisseur(dimensionEnvahisseur, positionEnvahisseur, Constante.ENVAHISSEUR_VITESSE);

	}

	public String recupererEspaceJeuDansChaineASCII() {
		StringBuilder espaceDeJeu = new StringBuilder();
		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < longueur; x++) {
				espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
			}
			espaceDeJeu.append(MARQUE_FIN_LIGNE);
		}
		return espaceDeJeu.toString();
	}

	private char recupererMarqueDeLaPosition(int x, int y) {
		char marque;
		if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
			marque = Constante.MARQUE_VAISSEAU;
		else if (this.aUnMissileQuiOccupeLaPosition(x, y))
			marque = Constante.MARQUE_MISSILE;
		else if (this.aUnEnvahisseurQuiOccupeLaPosition(x, y))
			marque = Constante.MARQUE_ENVAHISSEUR;
		else
			marque = Constante.MARQUE_VIDE;
		return marque;
	}

	private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
		return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
	}

	public boolean aUnVaisseau() {
		return vaisseau != null;
	}

	private boolean aUnMissileQuiOccupeLaPosition(int x, int y) {
		return this.aUnMissile() && missile.occupeLaPosition(x, y);
	}

	public boolean aUnMissile() {
		return missile != null;
	}

	private boolean aUnEnvahisseurQuiOccupeLaPosition(int x, int y) {
		return this.aUnEnvahisseur() && envahisseur.occupeLaPosition(x, y);
	}

	public boolean aUnEnvahisseur() {
		return envahisseur != null;
	}

	public Vaisseau recupererVaisseau() {
		return this.vaisseau;
	}

	public Missile recupererUnMissile() {
		return this.missile;
	}

	public Envahisseur recupererUnEnvahisseur() {
		return this.envahisseur;
	}

	public void positionnerUnNouveauVaisseau(Dimension dimension, Position position, int vitesse) {

		int x = position.abscisse();
		int y = position.ordonnee();

		if (!estDansEspaceJeu(x, y))
			throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");

		int longueurVaisseau = dimension.longueur();
		int hauteurVaisseau = dimension.hauteur();

		if (!estDansEspaceJeu(x + longueurVaisseau - 1, y))
			throw new DebordementEspaceJeuException(
					"Le vaisseau déborde de l'espace jeu vers la droite à cause de sa longueur");
		if (!estDansEspaceJeu(x, y - hauteurVaisseau + 1))
			throw new DebordementEspaceJeuException(
					"Le vaisseau déborde de l'espace jeu vers le bas à cause de sa hauteur");

		vaisseau = new Vaisseau(dimension, position, vitesse);

	}

	public void positionnerUnNouveauEnvahisseur(Dimension dimension, Position position, int vitesse) {

		int x = position.abscisse();
		int y = position.ordonnee();

		if (!estDansEspaceJeu(x, y))
			throw new HorsEspaceJeuException("La position de l'envahisseur est en dehors de l'espace jeu");

		int longueurEnvahisseur = dimension.longueur();
		int hauteurEnvahisseur = dimension.hauteur();

		if (!estDansEspaceJeu(x + longueurEnvahisseur - 1, y))
			throw new DebordementEspaceJeuException(
					"L'envahisseur déborde de l'espace jeu vers la droite à cause de sa longueur");
		if (!estDansEspaceJeu(x, y - hauteurEnvahisseur + 1))
			throw new DebordementEspaceJeuException(
					"L'envahisseur déborde de l'espace jeu vers le bas à cause de sa hauteur");

		envahisseur = new Envahisseur(dimension, position, vitesse);

	}

	private boolean estDansEspaceJeu(int x, int y) {
		return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
	}

	public void deplacerVaisseauVersLaDroite() {
		if (vaisseau.abscisseLaPlusADroite() < (longueur - 1)) {
			vaisseau.deplacerHorizontalementVers(Direction.DROITE);
			if (!estDansEspaceJeu(vaisseau.abscisseLaPlusADroite(), vaisseau.ordonneeLaPlusHaute())) {
				vaisseau.positionner(longueur - vaisseau.dimension.longueur(), vaisseau.ordonneeLaPlusHaute());
			}
		}
	}

	public void deplacerVaisseauVersLaGauche() {
		if (0 < vaisseau.abscisseLaPlusAGauche())
			vaisseau.deplacerHorizontalementVers(Direction.GAUCHE);
		if (!estDansEspaceJeu(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusHaute())) {
			vaisseau.positionner(0, vaisseau.ordonneeLaPlusHaute());
		}
	}

	@Override
	public void evoluer(Commande commandeUser) {

		if (commandeUser.gauche) {
			deplacerVaisseauVersLaGauche();
		}

		if (commandeUser.droite) {
			deplacerVaisseauVersLaDroite();
		}

		if (commandeUser.tir) {
			if (commandeUser.tir && !this.aUnMissile()) {
				tirerUnMissile(new Dimension(Constante.MISSILE_LONGUEUR, Constante.MISSILE_HAUTEUR),
						Constante.MISSILE_VITESSE);
			}
		}
		if (this.aUnMissile()) {
			this.deplacerMissile();
		}

		if (this.aUnEnvahisseur()) {
			this.deplacerEnvahisseur();
		}

	}

	@Override
	public boolean etreFini() {
		// TODO Auto-generated method stub
		return false;
	}

	public void tirerUnMissile(Dimension dimensionMissile, int vitesseMissile) {

		if ((vaisseau.hauteur() + dimensionMissile.hauteur()) > this.hauteur)
			throw new MissileException(
					"Pas assez de hauteur libre entre le vaisseau et le haut de l'espace jeu pour tirer le missile");

		this.missile = this.vaisseau.tirerUnMissile(dimensionMissile, vitesseMissile);
	}

	public void deplacerMissile() {
		if (0 < missile.ordonneeLaPlusBasse()) {
			missile.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		} else {
			missile = null;
		}
	}

	public void deplacerEnvahisseur() {
		if (this.aUnEnvahisseur()) {
			if (arriveAuMurGauche) {
				if (envahisseur.abscisseLaPlusAGauche() <= 0) {
					arriveAuMurGauche = false;
				} else {
					deplacerEnvahisseurVersLaGauche();
				}
			}
			if (!arriveAuMurGauche) {
				if (envahisseur.abscisseLaPlusADroite() >= Constante.ESPACEJEU_LONGUEUR - 1) {
					arriveAuMurGauche = true;
				} else {
					deplacerEnvahisseurVersLaDroite();
				}
			}
		}
	}

	public void deplacerEnvahisseurVersLaDroite() {
		if (envahisseur.abscisseLaPlusADroite() < (longueur - 1)) {
			envahisseur.deplacerHorizontalementVers(Direction.DROITE);
			if (!estDansEspaceJeu(envahisseur.abscisseLaPlusADroite(), envahisseur.ordonneeLaPlusHaute())) {
				envahisseur.positionner(longueur - envahisseur.dimension.longueur(), envahisseur.ordonneeLaPlusHaute());
			}
		}
	}

	public void deplacerEnvahisseurVersLaGauche() {
		if (0 < envahisseur.abscisseLaPlusAGauche())
			envahisseur.deplacerHorizontalementVers(Direction.GAUCHE);
		if (!estDansEspaceJeu(envahisseur.abscisseLaPlusAGauche(), envahisseur.ordonneeLaPlusHaute())) {
			envahisseur.positionner(0, envahisseur.ordonneeLaPlusHaute());
		}
	}

}
