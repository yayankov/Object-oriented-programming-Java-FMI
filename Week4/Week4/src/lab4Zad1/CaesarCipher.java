package lab4Zad1;

public class CaesarCipher {
    private static final int SHIFT_LENGTH = 3;
    private static final int ALPHABET_LENGTH = 26;

    private static char[] alphabet( ){
        char[] alphabet = new char[ALPHABET_LENGTH];
        char iter = 'A';
        for(int i = 0; i < ALPHABET_LENGTH; i++)
            alphabet[i] = iter++;

        return alphabet;
    }

    public static void encrypt(String value){
        char[] alphabet = alphabet( );
        char[] resultString = value.toCharArray();
        int index;

        for(int i = 0; i < resultString.length; i++){
            index = (resultString[i] - 'A' + SHIFT_LENGTH)
                    % ALPHABET_LENGTH;
            resultString[i] = alphabet[index];
        }

        String result = new String(resultString);
        System.out.println(result);
    }

    public static void decrypt(String value){
        char[] alphabet = alphabet( );
        char[] resultString = value.toCharArray();
        int index;

        for(int i = 0; i < resultString.length; i++){
            index = ((resultString[i] - 'A') - SHIFT_LENGTH
                    + ALPHABET_LENGTH ) % ALPHABET_LENGTH;
            resultString[i] = alphabet[index];
        }

        String result = new String(resultString);
        System.out.println(result);
    }

}
