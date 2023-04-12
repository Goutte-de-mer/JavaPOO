public class InverseString {

    public static String ReverseString(String str){
        String inversedString = "";
        for(int i = str.length()-1; i >= 0; i--){
            inversedString = inversedString + str.charAt(i);
        }
        return inversedString;
    }

    public static void main(String[] args) {

       System.out.println(ReverseString("Eva"));

    }
}

