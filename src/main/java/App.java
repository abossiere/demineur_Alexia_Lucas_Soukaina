public class App {
    public static void main(String[] args) {
        System.out.println("\033[2;30m" + "BLACK COLORED" + "\033[1;33m" + " NORMAL");

        Builder plateauBuilder = new PlateauBuilder();
        Director director = new Director(plateauBuilder);
        Plateau plateau = director.makeMoyenPlateau();
        InterfaceUtilisateur iu = new InterfaceUtilisateur(plateau);
        iu.menu();
    }
}
