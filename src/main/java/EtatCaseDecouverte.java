public class EtatCaseDecouverte implements EtatCase {

    private Case case_;

    public EtatCaseDecouverte(Case uneCase){
        case_ = uneCase;
    }

    public void drapeau(){
        // ne rien faire
    }
    public void selectionner(){
        // ne rien faire
    }

    public String getVisibleValue(){
        return null;
    }
}
