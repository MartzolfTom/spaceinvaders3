package fr.unilim.iut.spaceinvaders3.model;

public class Collision {
    public Sprite sprite;
    public Sprite cible;
    
    public Collision(Sprite sprite, Sprite cible){
        this.sprite = sprite;
        this.cible = cible;
    }
    
    public boolean detecterCollision() {
        return detectionVertical() && detectionHorizontal();
    }

    private boolean detectionHorizontal() {
        return detectionHorizontalGauche() || detectionHorizontalDroite();
    }

    private boolean detectionHorizontalDroite() {
        return est_abscisseGaucheDuSprite_DansLaCible();
    }

    private boolean est_abscisseGaucheDuSprite_DansLaCible() {
        return ( sprite.abscisseLaPlusAGauche() <= cible.abscisseLaPlusADroite() )
                && ( sprite.abscisseLaPlusAGauche() >= cible.abscisseLaPlusAGauche() );
    }

    private boolean detectionHorizontalGauche() {
        return est_abscisseDroiteDuSprite_DansLaCible();
    }

    private boolean est_abscisseDroiteDuSprite_DansLaCible() {
        return ( sprite.abscisseLaPlusADroite() >= cible.abscisseLaPlusAGauche() )
                && ( sprite.abscisseLaPlusADroite() <= cible.abscisseLaPlusADroite() );
    }

    private boolean detectionVertical() {
        return detectionVerticalBas() || detectionVerticalHaut();
    }
    
    private boolean detectionVerticalBas() {
        return est_ordonneeHautDuSprite_DansLaCible();
    }

    private boolean est_ordonneeHautDuSprite_DansLaCible() {
        return ( sprite.ordonneeLaPlusBasse() <= cible.ordonneeLaPlusHaute() ) 
                && ( sprite.ordonneeLaPlusBasse() >= cible.ordonneeLaPlusBasse() );
    }
    
    private boolean detectionVerticalHaut() {
        return est_ordonneeBasDuSprite_DansLaCible();
    }

    private boolean est_ordonneeBasDuSprite_DansLaCible() {
        return ( sprite.ordonneeLaPlusHaute() >= cible.ordonneeLaPlusBasse() )
                && ( sprite.ordonneeLaPlusHaute() <= cible.ordonneeLaPlusHaute() );
    }
}