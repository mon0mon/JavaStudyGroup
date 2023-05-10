package bj_2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String rawString = br.readLine();

        int result = CountCroatianAlphabet(rawString);
        System.out.println(result);
    }

    public static int CountCroatianAlphabet(String inputStr) {
        int startIndex = 0,
            endIndex = startIndex + 3 > inputStr.length() ?
                inputStr.length() : startIndex + 3,
            count = 0;
        String word;

        while (startIndex != endIndex) {
            word = inputStr.substring(startIndex, endIndex);

            switch (endIndex - startIndex) {
                case 1:
                    if (IsCroatian(word)) {
                        ++count;
                    }
                    startIndex += 1;
                    endIndex =
                            startIndex + 3 > inputStr.length() ?
                                    inputStr.length() : startIndex + 3;
                    break;
                case 2:
                    if (IsCroatian(word)) {
                        startIndex += 2;
                        endIndex =
                                startIndex + 3 > inputStr.length() ?
                                        inputStr.length() : startIndex + 3;
                        ++count;
                        break;
                    }
                    endIndex -= 1;
                    break;
                case 3:
                    if (IsCroatian(word)) {
                        startIndex += 3;
                        endIndex =
                            startIndex + 3 > inputStr.length() ?
                                inputStr.length() : startIndex + 3;
                        ++count;
                        break;
                    }
                    endIndex -= 1;
                    break;
            }
        }
        return count;
    }

    public static boolean IsCroatian(String word) {
        String[] singleWordPatterns = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "r", "s", "t", "u", "v", "z"};
        String[] twoWordPatterns = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};
        String threeWordPattern = "dz=";

        if (word.length() == 1) {
            for (String pattern : singleWordPatterns) {
                if (word.equals(pattern)) {
                    return true;
                }
            }
        } else if (word.length() == 2) {
            for (String pattern : twoWordPatterns) {
                if (word.equals(pattern)) {
                    return true;
                }
            }
        } else if (word.length() == 3){
            return word.equals(threeWordPattern);
        }

        return false;
    }
}
