package zad1;

import java.util.Arrays;

public class CipherGenerator {

    public Result countDistinct(Cipherable cipher, int seed){
        int numberOfUnique = 0;
        char[] originalResult = cipher.getSecretChars(seed);

        if (originalResult == null){
            return new Result(null, 0);
        }

        char[] copy = new char[originalResult.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = originalResult[i];
        }

        Arrays.sort(copy);

        for (int i = 0; i < copy.length - 1; i++) {
            if (copy[i] != copy[i+1]){
                numberOfUnique++;
            }
        }

        if (copy[copy.length - 1] != copy[copy.length - 2])
            numberOfUnique++;

        return new Result(originalResult, numberOfUnique);
    }
}
