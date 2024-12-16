package com.gamexpress.guess_the_word.guess_the_word.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope("prototype")
public class GameService {

//    make an array , for creating the blank space
    private String randomlyChoosenWord = null;
    private String[] randomWords = {"spring", "system", "linkedln", "hello", "world", "docker","python","java"};



    private char[] allCharactersOfTheWord;
    private boolean isGameWon = false; // Track if the game is won
    Random random = new Random();

//we need to fill it with blanks so to do  i will be doing i'll be taking another array a character array to which is going to
//    represent is character of the randomly choosen .
//create the constratore.

    public String[] getRandomWords() {
        return randomWords;
    }

    public GameService() {

        randomlyChoosenWord = randomWords[random.nextInt(randomWords.length)];
        System.out.println("Randomly choosen word is : " + randomlyChoosenWord);
        allCharactersOfTheWord = new char[randomlyChoosenWord.length()];
    }

    //method, Generate a string representation of the current word with blanks
    @Override
    public String toString(){
        String ret = "";

        for(char c: allCharactersOfTheWord){
            if(c == '\u0000'){
                ret = ret + "_";
            }
            else{
                ret = ret + c;
            }
            ret = ret + ' ';
        }
        return ret;
    }

//    Validate user input
    public String validateInput(String guessedChar) {
        if(guessedChar == null || guessedChar.trim().isEmpty()) {
            return "Please Enter a Character!";
        }
        if(guessedChar.length() > 1 ){
            return "Only one character is allowed!";
        }
        return null;
    }

    // Process the guess
    //we have to check if the guessedchar (o) present inside the randomlychoosenword(hello)
    public boolean addGuess(char guessedChar) {
        boolean isGuessCorrect = false;

        for(int i =0;  i< randomlyChoosenWord.length(); i++){
            if(guessedChar == randomlyChoosenWord.charAt(i)){
                allCharactersOfTheWord[i] = guessedChar;
                isGuessCorrect = true;
            }
        }

//        Check if all letter are guessed
        isGameWon = isWordFullyGuesses();
        return isGuessCorrect;
    }

//    Check if the entire word is guesses
    private boolean isWordFullyGuesses(){
        for(char c : allCharactersOfTheWord){
            if(c == '\u0000'){
                return false; //Word is not yet guessed
            }
        }
        return  true;
    }
    public boolean isGameWon(){
        return isGameWon;
    }

    public String getRandomlyChoosenWord() {

        return randomlyChoosenWord;
    }
}

//['\u0000',null,null,null,null-- this is default value of the character]
