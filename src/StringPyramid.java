import java.util.Scanner;

public class StringPyramid {

    public static void Pyramid(int rows){
        String star = "* ", space = "  ";

        for (int i = 1; i <= rows; i++){
            System.out.println(space.repeat(rows - i) + star.repeat(2 * i - 1));
        }
    }
    public static void main(String[] args) {

        System.out.println("Combien de lignes ?");
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        Pyramid(rows);
    }

}

