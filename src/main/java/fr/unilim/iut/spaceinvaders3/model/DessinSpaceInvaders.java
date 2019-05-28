package fr.unilim.iut.spaceinvaders3.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import fr.unilim.iut.spaceinvaders3.moteurJeu.DessinJeu;

public class DessinSpaceInvaders implements DessinJeu {

	   private SpaceInvaders jeu;

	   public DessinSpaceInvaders(SpaceInvaders spaceInvaders) {
		   this.jeu = spaceInvaders;
	   }
 
	   @Override
	   public void dessiner(BufferedImage im) {
		   if (this.jeu.aUnVaisseau()) {
			   Vaisseau vaisseau = this.jeu.recupererVaisseau();
			   this.dessinerUnVaisseau(vaisseau, im);
		   }
		   if (this.jeu.aUnMissile()) {
			   Missile missile = this.jeu.recupererUnMissile();
			   this.dessinerUnMissile(missile, im);
		   }
		   
		   if (this.jeu.aUnEnvahisseur()) {
			   Envahisseur envahisseur = this.jeu.recupererUnEnvahisseur();
			   this.dessinerUnEnvahisseur(envahisseur, im);
		   }
		   if(!this.jeu.aUnVaisseau()) {
			   this.dessinerMessageFin(im," Partie finie", Color.black);
		   }
	   }

	   private void dessinerMessageFin(BufferedImage im, String messageFin, Color c) {
		   Graphics2D crayon = (Graphics2D) im.getGraphics();

		   crayon.setColor(c);
		   	crayon.drawString(messageFin, Constante.ESPACEJEU_LONGUEUR /2,Constante.ESPACEJEU_HAUTEUR /2);
		
	}

	private void dessinerUnVaisseau(Vaisseau vaisseau, BufferedImage im) {
		   Graphics2D crayon = (Graphics2D) im.getGraphics();

		   crayon.setColor(Color.gray);
		   	crayon.fillRect(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusBasse(), vaisseau.longueur(), vaisseau.hauteur());

	   }
	   
	   private void dessinerUnMissile(Missile missile, BufferedImage im) {
		   Graphics2D crayon = (Graphics2D) im.getGraphics();

		   crayon.setColor(Color.blue);
		   	crayon.fillRect(missile.abscisseLaPlusAGauche(), missile.ordonneeLaPlusBasse(), missile.longueur(), missile.hauteur());

	   }
	   
	   private void dessinerUnEnvahisseur(Envahisseur envahisseur, BufferedImage im) {
		   Graphics2D crayon = (Graphics2D) im.getGraphics();

		   crayon.setColor(Color.pink);
		   	crayon.fillRect(envahisseur.abscisseLaPlusAGauche(), envahisseur.ordonneeLaPlusBasse(), envahisseur.longueur(), envahisseur.hauteur());

	   }

 }