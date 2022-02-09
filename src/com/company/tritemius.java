package com.company;

public class tritemius {

    static char[] lAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    //Test
    public static void main(String[] args) {
        System.out.println("Text: " + "applied cryptography" + "--->" + "Encryption: " + linearCode("applied cryptography", 2, 1));

        System.out.println("Ecnryption: " + "bsusrpq tktmspjwhysl" + "--->" + "Decryption: " + linearDecode("bsusrpq tktmspjwhysl", 2, 1));

        System.out.println("Text: " + "some ciphertext" + "--->" + "Encryption: " + polynomialCode("some ciphertext", 1, 2, 1));
        bruteForce(3,5,1, "Pjt ewd Qbmlh kz hxsw ljd!");

    }
    //linear encryption y = x + a*p + b
    public static String linearCode(String plaintext, int a, int b){
        String cipherText = "";
        int code_int = 0;
        for (int i=0; i<plaintext.length(); i++) {
            char letter = plaintext.charAt(i);
            if (letter>=65 && letter<=90){
                letter+=32;
            }
            char new_char;
            if (letter>=97 && letter<=112){
                code_int = (letter - 96) + a*i + b;
                while (code_int>26){code_int = code_int - 26;}
                new_char = lAlphabet[code_int-1];
            }
            else{
                new_char = letter;
            }
            cipherText = cipherText + new_char;
        }
        return cipherText;
    }

    // polynomial encryption y = x + a*p^2 +b*p + c
    public static String polynomialCode(String plaintext, int a, int b, int c){
        String cipherText = "";
        int code_int = 0;
        for (int i=0; i<plaintext.length(); i++) {
            char letter = plaintext.charAt(i);
            if (letter>=65 && letter<=90){
                letter+=32;
            }
            char new_char;
            if (letter>=97 && letter<=112){
                code_int = (letter - 96) + a*i*i + b*i + c;
                while (code_int>26){code_int = code_int - 26;}
                new_char = lAlphabet[code_int-1];
            }
            else {
                new_char = letter;
            }
            cipherText = cipherText + new_char;
        }
        return cipherText;
    }
    // linear decryption
    public static String linearDecode(String chipertext, int a, int b){
        String text = "";
        int code_int = 0;
        for (int i=0; i<chipertext.length(); i++) {
            char letter = chipertext.charAt(i);
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
// polynomial decryption
    public static String polynomDecode(String ciphertext, int a, int b, int c){
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
// bruteForce decryption
    public static void bruteForce(int number_param, int max_param, int min_param, String chipertext){
        if(number_param == 2){
            for( int a = min_param; a<=max_param; a++){
                for(int b = min_param; b<=max_param; b++){
                    System.out.println("A: " + a + ", B: " + b);
                    System.out.println(linearDecode(chipertext, a, b));
                }
            }
        }
        else if(number_param == 3){
            for( int a = min_param; a<=max_param; a++){
                for(int b = min_param; b<=max_param; b++){
                    for(int c = min_param; c<=max_param; c++){
                        System.out.println("A: " + a + ", B: " + b + ", C: " + c);
                        System.out.println(polynomDecode(chipertext, a, b, c));
                    }
                }
            }
        }

    }
}
