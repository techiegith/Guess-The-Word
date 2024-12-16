package com.gamexpress.guess_the_word.guess_the_word.utils;


import com.gamexpress.guess_the_word.guess_the_word.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.module.Configuration;

@Component
public class GameUtils {

    @Autowired
    ConfigurableApplicationContext applicationContext;
    private int MAX_TRIES = 5;

    public int reduceTry(){
        MAX_TRIES = MAX_TRIES -1;
        return MAX_TRIES;
    }
    public int getTriesRemaining(){

        return MAX_TRIES;
    }

    public void resetTries(){

        MAX_TRIES = 5;
    }

    public GameService reload(){

        GameService gameService = applicationContext.getBean(GameService.class);
        return gameService;

//        its give a new game service object here so this should
//        be the functionally of this service method.



    }
}
