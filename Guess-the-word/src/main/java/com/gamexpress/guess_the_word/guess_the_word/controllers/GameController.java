package com.gamexpress.guess_the_word.guess_the_word.controllers;

import com.gamexpress.guess_the_word.guess_the_word.service.GameService;
import com.gamexpress.guess_the_word.guess_the_word.utils.GameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameUtils gameUtils;
    @GetMapping("/")
    public String redirectToGameHome() {
        return "redirect:/game-home";
    }
    // Game Home Page
    @GetMapping("/game-home")
    public String showGameHomePage(@RequestParam(value = "guessedChar", required = false) String guessedChar, Model model) {

        System.out.println("Captured guessed word is: " + guessedChar);

        String[] randomWords = gameService.getRandomWords();
        model.addAttribute("randomWords", randomWords);

        String randomWord = gameService.toString();

        // Process Guessed Character
        if (guessedChar != null) {
            if (guessedChar.length() != 1) {
                model.addAttribute("errorMessage", "Enter exactly one character!");
            } else {
                boolean isGuessCorrect = gameService.addGuess(guessedChar.charAt(0));
                randomWord = gameService.toString();

                if (!isGuessCorrect) {
                    gameUtils.reduceTry();
                }

                // Check if the word is completely guessed
                if (randomWord.replace(" ", "").equals(gameService.getRandomlyChoosenWord())) {
                    model.addAttribute("gameStatus", "You Won!");
                    model.addAttribute("isGameWon", true); // For Visual representation
                }
            }
        }

        // Update Model Attributes
        System.out.println("Number of tries remaining: " + gameUtils.getTriesRemaining());
        model.addAttribute("wordToDisplay", randomWord);
        model.addAttribute("triesLeft", gameUtils.getTriesRemaining());
        model.addAttribute("errorMessage", null); // Default to null to clear old errors

        return "game-home-page";
    }

    // Reload Game and Reset State
    @GetMapping("/reload")
    public String reloadGame() {
        gameService = gameUtils.reload(); // Reset the game state
        gameUtils.resetTries(); // Reset tries count
        return "redirect:/game-home";
    }
}
