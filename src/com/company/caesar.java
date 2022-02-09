package com.company;

public class caesar {

    //Test
    public static void main(String[] args) {

        String ciphertext = code("Bonus vir semper tiro", 10);
        System.out.println("Encryption: " + "Bonus vir semper tiro" + " ---> " + ciphertext);

        String decoded = decode("Lyxec fsb cowzob dsby", 10);
        System.out.println("Decryption: " + ciphertext + " ---> " + decoded);

        bruteForce("Aol wbywvzl vm vby spclz pz av il ohwwf");
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

    public static void bruteForce(String ciphertext){
        String decoded = "";
        for (int i =0; i<=20; i++){
            System.out.println("Key: " + i);
            System.out.println(decode(ciphertext, i));
        }
    }
}
