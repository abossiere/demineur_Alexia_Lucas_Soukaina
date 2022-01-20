public class EtatCaseDrapeau implements EtatCase {

    private Case case_;
    public String visibleValue;

    public EtatCaseDrapeau(Case uneCase){
        case_ = uneCase;
        visibleValue = "D";
    }

    public void drapeau(){
        this.visibleValue = "?";
        case_.changeEtatCachee();
    }
    public void selectionner(){
        this.visibleValue = case_.getValue();
        case_.changeEtatDecouverte();
    }

    public String getVisibleValue(){
        return case_.getValue();
    }
}
