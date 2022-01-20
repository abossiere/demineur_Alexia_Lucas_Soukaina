package EtatsCase;

public class EtatCaseDrapeau implements EtatCase {

    private SimCase sim_;

    public EtatCaseDrapeau(SimCase sim){
        sim_ = sim;
    }

    public void drapeau(){
        // enleve le drapeau
        sim_.changeEtatCachee();
    }
    public void selectionner(){
        // découvrir la case
        sim_.changeEtatDecouverte();
    }
}
