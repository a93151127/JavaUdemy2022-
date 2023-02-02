package recursive;

import java.util.Scanner;

public class PalindromeMain {
    public static void main(String[] args) {
        System.out.println("enter word");
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();

        System.out.println(word + " is palindrome ? " +
                isPalindromeGreater(word,0, word.length()-1));
    }

    private static boolean isPalindrome(String word){
        //判斷只剩一個字串的時候為true
        if(word.length() <= 1){
            return true;
        }
        //判斷第一個字元和最後一個字元是否相同
        if(word.charAt(0) == word.charAt(word.length() - 1)){
            return isPalindrome(word.substring(1, word.length()-1));
        }else{
            return false;
        }
    }

    private static boolean isPalindromeGreater(String word, int low, int high){
        if(low >= high){
            return true;
        }else if(word.charAt(low) != word.charAt(high)){
            return false;
        }else{
            return isPalindromeGreater(word, low + 1, high - 1);
        }
    }
}
