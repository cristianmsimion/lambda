package cristi.main;

import java.util.Random;

/**
 * Created by cristian on 26.11.2017.
 */
@FunctionalInterface
public interface GenerateKeygen {

    String acceptedLetters = "ABCabc";
    String acceptedNumbers = "123456789";


    String generate(String userName);

    default GenerateKeygen generateKey() {
        GenerateKeygen g = f -> {
            String concat = acceptedLetters.concat(acceptedNumbers).concat(f);
            String keygen = new String();
            Random r = new Random();
            for (int i = 1; i < 10; i++) {
                char[] chars = concat.toCharArray();
                keygen = keygen.concat(String.valueOf(chars[r.nextInt(concat.length())]));
            }
            return keygen;
        };

        return g;
    }
}
