package EtatsCase;

public class SimCase {
    private EtatCase etatCachee_;
    private EtatCase etatDecouverte_;
    private EtatCase etatDrapeau_;

    private EtatCase etat_;

    public SimCase(){
        etatCachee_ = new EtatCaseCachee(this);
        etatDecouverte_ = new EtatCaseDecouverte(this);
        etatDrapeau_ = new EtatCaseDrapeau(this);

        etat_ = etatCachee_;
    }

    public void changeEtatDrapeau(){
        etat_ = etatDrapeau_;
        // on met un drapeau sur la case
        // .....
    }
    public void changeEtatCachee(){
        etat_ = etatCachee_;
        // on re-cache la case avec un ?
        // .....
    }

    public void changeEtatDecouverte(){
        etat_ = etatDecouverte_;
        // on affiche la valeur de la case
        // si c'est une bombe byebye
        // .....
    }
}
