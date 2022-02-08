package com.company;

public class caesar {

    //Test
    public static void main(String[] args) {
        String plaintext = "Hello";
        int key = 3;

        String ciphertext = code(plaintext, key);
        System.out.println("Encryption: " + plaintext + " ---> " + ciphertext);

        String decoded = decode(ciphertext, key);
        System.out.println("Decryption: " + ciphertext + " ---> " + decoded);
    }

    //convert letters as integers
    public static char shift(char letter, int shift){
        if(letter>='a' && letter <='z'){
            letter += shift;
            while(letter > 'z'){
                letter -= 26;
            }
        }
        return letter;
    }

    //encryption
    public static String code(String plaintext, int key){
        String ciphertext = "";
        plaintext = plaintext.toLowerCase();
        for(int i=0; i<plaintext.length(); i++){
            char next = plaintext.charAt(i);
            ciphertext = ciphertext + shift(next, key);
        }
        return ciphertext;
    }

    //decryption
    public static  String decode(String ciphertext, int key){
        String decoded = "";
        ciphertext = ciphertext.toLowerCase();
        for(int i=0; i<ciphertext.length(); i++){
            char next = ciphertext.charAt(i);
            decoded = decoded + shift(next, 26-key);
        }
        return decoded;
    }
}
