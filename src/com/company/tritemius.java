package com.company;

public class tritemius {

    static char[] lAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    //Test
    public static void main(String[] args) {
        System.out.println("Text: " + "applied cryptography" + "--->" + "Encryption: " + linear_code("applied cryptography", 2, 1));

        System.out.println("Ecnryption: " + "bsusrpq tktmspjwhysl" + "--->" + "Decryption: " + linear_decode("bsusrpq tktmspjwhysl", 2, 1));

        System.out.println("Text: " + "some ciphertext" + "--->" + "Encryption: " + polynom_code("some ciphertext", 1, 2, 1));
        bruteForce(3,5,1, "Pjt ewd Qbmlh kz hxsw ljd!");

    }
        //lineal encryption y = x + a*p + b
    public static String linear_code(String plaintext, int a, int b){
        String cipherText = "";
        int code_int = 0;
        for (int i=0; i<plaintext.length(); i++) {
            char letter = plaintext.charAt(i);
            if (letter>=65 && letter<=90){
                letter+=32;
            }
            char new_char;
            if (letter == 32){
                new_char = ' ';
            }
            else{
                code_int = (letter - 96) + a*i + b;
                while (code_int>26){code_int = code_int - 26;}
                new_char = lAlphabet[code_int-1];
            }
            cipherText = cipherText + new_char;
        }
        return cipherText;
    }
    // polynom encryption y = x + a*p^2 +b*p + c

    public static String polynom_code(String plaintext, int a, int b, int c){
        String cipherText = "";
        int code_int = 0;
        for (int i=0; i<plaintext.length(); i++) {
            char letter = plaintext.charAt(i);
            if (letter>=65 && letter<=90){
                letter+=32;
            }
            char new_char;
            if (letter == 32){
                new_char = ' ';
            }
            else{
                code_int = (letter - 96) + a*i*i + b*i + c;
                while (code_int>26){code_int = code_int - 26;}
                new_char = lAlphabet[code_int-1];
            }
            cipherText = cipherText + new_char;
        }
        return cipherText;
    }
    public static String linear_decode(String chipertext, int a, int b){
        String text = "";
        int code_int = 0;
        for (int i=0; i<chipertext.length(); i++) {
            char letter = chipertext.charAt(i);
            //only lower-case letters
            if (letter>=65 && letter<=90){
                letter+=32;
            }
            char new_char;
            if (letter>=97 && letter<=112){
                code_int = (letter - 96);
                while ((a*i + b)>=code_int){code_int = code_int + 26;}
                code_int = code_int - a*i - b;
                new_char = lAlphabet[code_int-1];
            }
            else {
                new_char = letter;
            }
            text = text + new_char;
        }
        return text;
    }

    public static String polynom_decode(String ciphertext, int a, int b, int c){
        String text = "";
        int code_int = 0;
        for (int i=0; i<ciphertext.length(); i++) {
            char letter = ciphertext.charAt(i);
            if (letter>=65 && letter<=90){
                letter+=32;
            }
            char new_char;
            if (letter>=97 && letter<=112){
                code_int = (letter - 96);
                while ((a*i*i + b*i + c)>=code_int){code_int = code_int + 26;}
                    code_int = code_int - a*i*i - b*i - c;
                    new_char = lAlphabet[code_int-1];
                }
            else {
                new_char = letter;
            }
                text = text + new_char;
        }
        return text;

    }

    public static void bruteForce(int number_param, int max_param, int min_param, String chipertext){
        if(number_param == 2){
            for( int a = min_param; a<=max_param; a++){
                for(int b = min_param; b<=max_param; b++){
                    System.out.println("A: " + a + ", B: " + b);
                    System.out.println(linear_decode(chipertext, a, b));
                }
            }
        }
        else if(number_param == 3){
            for( int a = min_param; a<=max_param; a++){
                for(int b = min_param; b<=max_param; b++){
                    for(int c = min_param; c<=max_param; c++){
                        System.out.println("A: " + a + ", B: " + b + ", C: " + c);
                        System.out.println(polynom_decode(chipertext, a, b, c));
                    }
                }
            }
        }

    }
}
