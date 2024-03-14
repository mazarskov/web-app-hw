package ee.eek.guess.handlers;

import org.springframework.stereotype.Service;
import ee.eek.guess.data.GameData;
import ee.eek.guess.data.PlayerData;
import java.util.Random;

@Service
public class GameHandler {
        
    static PlayerData playerData = new PlayerData();
    static GameData gameData = new GameData();
    public static DataHandler data = new DataHandler();
    
    public static Integer getPlayerNum() {
        
        return playerData.getNumber();
    }

    public static Integer generateId() {
        Random rand = new Random();
        Integer id = rand.nextInt(10) + 1;
        return id;
    }

    public static PlayerData assignNumber(PlayerData input) {
        playerData.setNumber(input.getNumber());
        return playerData;
    }

    public GameData starGame(PlayerData input) {
        if (input.getNumber() > 100 || input.getNumber() < 1) {
            gameData.setGameStatus("Number should be 0<x<100 to start the game!");
            gameData.setId(null);
            return gameData;
        } else {
            Integer id = generateId();
            gameData.setId(id);
            gameData.setGameStatus("Game started!");
            assignNumber(input);
            data.clearMap();
            data.addToMap(id, playerData);
            System.out.println("Size of Hashmap: " + data.checkSize() + " (If more than 1 thats a problem)");
            System.out.println("Game started with id: " + gameData.getId());
            System.out.println("Players number is: " + playerData.getNumber());
            return gameData;
        }
        
    }

    public Integer getNumberFromId(Integer id) {
        return data.printOut(id);
    }

    public String guessing(Integer id, Integer guessNumber) {
        if (validateGame(id) == false) {
            return "Invalid id!";
        } else if (checkGameStatus(id) == true){
            return "Game ended!";
        } else {
            Integer num = getNumberFromId(id);
            if (num > guessNumber) {
                return "Higher!";
            } else if (num < guessNumber) {
                return "Lower!";
            } else if (num.equals(guessNumber)) {
                endGame(id);
                return "Congrats!";
            } else {
                return "error";
            }
        }
    }

    public boolean validateGame(Integer id) {
        return data.checkKey(id);
    }

    public boolean checkGameStatus(Integer id) {
        return data.checkGameStatus(id);
    }

    public void endGame(Integer id) {
        data.endGame(id);
    }
}
