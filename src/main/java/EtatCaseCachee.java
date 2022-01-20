public class EtatCaseCachee implements EtatCase {

    private Case case_;
    public String visibleValue;

    public EtatCaseCachee(Case uneCase){
        case_ = uneCase;
        visibleValue = "?";
    }

    public void drapeau(){
        this.visibleValue = "D";
        case_.changeEtatDrapeau();
    }
    public void selectionner(){
        this.visibleValue = case_.getValue();
        case_.changeEtatDecouverte();
    }

    public String getVisibleValue(){
        return this.visibleValue;
    }
}
