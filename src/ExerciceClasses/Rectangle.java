package ExerciceClasses;

public class Rectangle {

    static int hauteur;
    static int largeur;

    public Rectangle(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void display(){
        String star = "# ";
        for (int i = 0; i < hauteur; i++){
            System.out.println(star.repeat(largeur));
        }
    }

    public static void main(String[] args){
        new Rectangle(3,5).display();
    }

}

