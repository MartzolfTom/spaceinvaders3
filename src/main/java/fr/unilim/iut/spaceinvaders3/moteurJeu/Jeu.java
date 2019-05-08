package fr.unilim.iut.spaceinvaders3.moteurJeu;

public interface Jeu {

	/**
	 * methode qui contient l'evolution du jeu en fonction de la commande
	 * 
	 * @param commandeUser
	 *            commande utilisateur
	 */
	public void evoluer(Commande commandeUser);
	
	/**
	 * @return true si et seulement si le jeu est fini
	 */
	public boolean etreFini();
}
