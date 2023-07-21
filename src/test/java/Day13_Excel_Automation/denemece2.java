package Day13_Excel_Automation;

import java.util.Arrays;

public class denemece2 {

    public static void main(String[] args) {


        String str = "Java";

//        1. yol StringBuilder
//
//        StringBuilder sb = new StringBuilder(str).reverse();
//        str = sb.toString();
//        System.out.println(str);

        //2. Yol ForLoop
        String reversed = "";
//        for (int i = str.length()-1; i >= 0; i--) {
//            reversed += str.charAt(i);
//        }
//        System.out.println(reversed);

        //3. Yol Split method

        String[] str2 = str.split("");
        System.out.println(Arrays.toString(str2));
        for (int i = str2.length-1; i >=0 ; i--) {
            reversed+= str2[i];
        }
        System.out.println(reversed);
    }
}
