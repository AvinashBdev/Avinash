package com.avinash.avinash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@SpringBootApplication
@RestController
public class AvinashApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvinashApplication.class, args);
    }

    @Autowired
    PalindromeRepository palindromeRepository;

    @GetMapping("/longestpalindrome")
    public String longestPalindrome(@RequestParam(value = "input") String input) {
        Optional<PalindromeDB> palindromeDB = palindromeRepository.findById(input);
        PalindromeDB palindrome = null;
        if (palindromeDB.isPresent()) {
            palindrome = palindromeDB.get();
            return palindrome.getPalindrome();
        } else {
            String value = getLongestPalindrome(input);
            palindrome = new PalindromeDB(input, value);
            palindromeRepository.save(palindrome);
            return palindrome.getPalindrome();
        }
    }


    String getLongestPalindrome(String input) {
        if (input == null) {
            return "Invalid Input";
        }
        int n = input.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int max = 1;
        int left = 0;
        int right = 0;
        if (n < 2) {
            return input;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int k = i + l - 1;
                try {
                    if (((i + 1 > k - 1) || dp[i + 1][k - 1]) && input.charAt(i) == input.charAt(k)) {
                        dp[i][k] = true;
                        if (max < (k - i + 1)) {
                            max = k - i + 1;
                            left = i;
                            right = k;
                        }
                    }
                } catch (Exception ignored) {
                }
            }
        }
        return input.substring(left, right + 1);
    }

    private BinaryReversal binaryReversal = new BinaryReversal();

    @GetMapping("/binaryreversal")
    public int binaryReversal(@RequestParam(value = "input") int input) {
        return binaryReversal.reverseBinary(input);
    }

}
