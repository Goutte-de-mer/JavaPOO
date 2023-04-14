package ExerciceClasses;

public class Carre extends Rectangle{

    public Carre(int hauteur, int largeur) {
        super(hauteur, largeur);
    }

    public static void calculateSurface(){
        int surface;
        surface = largeur * hauteur;
        System.out.println("La surface est de " + surface+ "#");
    }

    public static void main(String[] args){
        new Carre(3,3).display();
        calculateSurface();
    }

}
