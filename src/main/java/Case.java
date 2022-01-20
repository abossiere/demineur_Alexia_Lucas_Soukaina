public class Case {
    int x;
    int y;
    String value;
    String visibleValue;
    boolean isBomb;
    private EtatCase etat_;

    private EtatCase etatCachee_;
    private EtatCase etatDecouverte_;
    private EtatCase etatDrapeau_;

    public Case(int x, int y,String value, String visibleValue, boolean isBomb) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.visibleValue = visibleValue;
        this.isBomb = isBomb;

        etatCachee_ = new EtatCaseCachee(this);
        etatDecouverte_ = new EtatCaseDecouverte(this);
        etatDrapeau_ = new EtatCaseDrapeau(this);

        etat_ = etatCachee_;
    }

    public void changeEtatDrapeau(){
        etat_ = etatDrapeau_;
        this.visibleValue = this.value;
    }
    public void changeEtatCachee(){
        etat_ = etatCachee_;
    }

    public void changeEtatDecouverte(){
        etat_ = etatDecouverte_;
        this.visibleValue = this.value;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getVisibleValue() {
        return etat_.getVisibleValue();
    }

    public void setVisibleValue(String visibleValue) {
        this.visibleValue = visibleValue;
    }
}