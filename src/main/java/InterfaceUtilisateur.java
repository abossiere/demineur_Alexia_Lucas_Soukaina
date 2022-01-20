import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class InterfaceUtilisateur {

    private Jeu jeu;
    private Plateau plateau;
    private int casesLibresRestantes;

    public InterfaceUtilisateur(Plateau plateau) {
        this.jeu = new Jeu(plateau);
        this.plateau = plateau;
        this.casesLibresRestantes= plateau.line * plateau.column - 5;
    }

    public void menu(){
        System.out.println("-------DEMINEUR-------");
        System.out.println("Que voulez-vous faire?");
        System.out.println("1- Jouer");
        System.out.println("2- Quitter");
        Scanner scannerMenu = new Scanner(System.in);
        int choixMenu = scannerMenu.nextInt();
        if(choixMenu == 1){
            optionGrandeur();
        }
        if(choixMenu == 2){
            System.exit(0);
        }
        else{
            System.err.println("Entrée invalide, veuillez séléctionner une réponse valide");
            menu();
        }

    }

    public void optionGrandeur(){
        System.out.println("-----OPTIONS GRANDEUR-------");
        System.out.println("Niveaux de difficultés");
        System.out.println("1-Difficile");
        System.out.println("2-Moyen");
        System.out.println("3-Facile");
        Scanner scannerGrandeur = new Scanner(System.in);
        int choixGrandeur = scannerGrandeur.nextInt();
        if(choixGrandeur == 1){
            System.err.println("Vous avez choisi le mode Difficile !");
            Builder plateauBuilder = new PlateauBuilder();
            Director director = new Director(plateauBuilder);
            Plateau plateau = director.makeGrandPlateau();
            InterfaceUtilisateur iu = new InterfaceUtilisateur(plateau);
            iu.start();
        }
        if(choixGrandeur == 2){
            System.err.println("Vous avez choisi le mode Moyen !");
            Builder plateauBuilder = new PlateauBuilder();
            Director director = new Director(plateauBuilder);
            Plateau plateau = director.makeMoyenPlateau();
            InterfaceUtilisateur iu = new InterfaceUtilisateur(plateau);
            iu.start();
        }
        if(choixGrandeur == 3){
            System.err.println("Vous avez choisi le mode Facile !");
            Builder plateauBuilder = new PlateauBuilder();
            Director director = new Director(plateauBuilder);
            Plateau plateau = director.makePetitPlateau();
            InterfaceUtilisateur iu = new InterfaceUtilisateur(plateau);
            iu.start();
        }
        else{ // si on insère une chaine ça crash
            System.out.println("Entrée invalide, veuillez séléctionner une réponse valide");
            optionGrandeur();
        }
    }

    public void start(){
        jeu.genererJeu();
        Case[][] cases = jeu.getCases();
        List<String> lettres = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I");
        boolean finJeu = false;
        while(!finJeu){
            jeu.afficherJeu();
            System.out.println("Veuillez écrire les coordonnées de la case souhaité (ex : A1 ou C5) Si vous voulez poser un drapeau, ajouter un 'D' a la fin (ex: A1D ou C5D)");
            try {
                Scanner scannerJeu = new Scanner(System.in);
                String action = scannerJeu.next().toUpperCase();
                String[] actionSplit = action.split("");
                Case caseCourante = cases[lettres.indexOf(actionSplit[0])][Integer.parseInt(actionSplit[1])-1];
                if (actionSplit.length == 3){
                    if(actionSplit[2].equals("D")) {
                        if (caseCourante.getVisibleValue().equals("?")) {
                            caseCourante.setVisibleValue("D");
                        }
                    }
                }
                if (actionSplit.length == 2) {
                    if (caseCourante.getVisibleValue().equals("?") || caseCourante.getVisibleValue().equals("D")) {
                        caseCourante.setVisibleValue(caseCourante.getValue());
                        if (caseCourante.isBomb()) {
                            System.err.println("BOOM ! Dommage, vous avez perdu !");
                            jeu.afficherJeuTerminer();
                            finJeu = true;
                        }
                        else{
                            casesLibresRestantes--;
                        }
                    }
                }

                if(casesLibresRestantes == 0){
                    System.err.println("Félicitation ! vous avez gagné !");
                    jeu.afficherJeuTerminer();
                    finJeu = true;
                }
            }
            catch(Exception e){
                System.err.println("Entrée invalide, veuillez utilisé le format souhaité");
            }

        }
        // relancer le menu
        menu();
    }

//    public void start() {
//
//        terrain.genererTerrain();
//        System.out.print("Combien de mines voulez-vous sur le terrain ? : ");
//        int nbMines = scanner.nextInt();
//        terrain.genererMines(nbMines);
//        casesLibresRestantes -= nbMines;
//        while (true) {
//            terrain.afficherTerrain();
//            System.out.println("Jouez votre coup (mode -> 0 = découvrir la case, 1 = mettre/enlever un drapeau, puis les coordonnées x (colonne) et y (ligne)) : ");
//            try {
//                int mode = scanner.nextInt();
//                int x = scanner.nextInt();
//                int y = scanner.nextInt();
//
//                if (mode == 0) {
//                   int resultat = terrain.ouvrirCase(x-1,y-1);
//                   if (resultat == 1) {
//                       casesLibresRestantes--;
//                       if (casesLibresRestantes == 0) {
//                            terrain.afficherTerrain();
//                            System.out.println("Félicitations, vous avez gagné la partie !");
//                            break;
//                       }
//                   } else if (resultat == -1) {
//                        terrain.afficherTerrain();
//                        System.out.println("Félicitations, vous avez perdu !");
//                        break;
//                   }
//                } else if (mode == 1) {
//                    if (!terrain.estOuverte(x-1,y-1)) {
//                        terrain.mettreDrapeau(x-1,y-1);
//                    }
//                }
//
//            } catch (Exception e) {
//                System.out.println("Entrée invalide, veuillez jouez un coup valide");
//            }
//        }
//    }
}
