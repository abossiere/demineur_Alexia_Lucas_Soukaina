package EtatsCase;

public class EtatCaseCachee implements EtatCase {

    private SimCase sim_;

    public EtatCaseCachee(SimCase sim){
        sim_ = sim;
    }

    public void drapeau(){
        // mettre un drapeau
        sim_.changeEtatDrapeau();
    }
    public void selectionner(){
        // découvrir la case
        sim_.changeEtatDecouverte();
    }
}
