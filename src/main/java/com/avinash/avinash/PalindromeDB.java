package com.avinash.avinash;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PalindromeDB {
    @Id
    private String input;
    private String palindrome;

    public PalindromeDB() {

    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setPalindrome(String palindrome) {
        this.palindrome = palindrome;
    }

    public PalindromeDB(String input, String palindrome) {
        this.input = input;
        this.palindrome = palindrome;
    }

    public String getInput() {
        return input;
    }

    public String getPalindrome() {
        return palindrome;
    }
}