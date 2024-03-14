package ee.eek.guess.controllers;

import org.springframework.web.bind.annotation.RestController;
import ee.eek.guess.data.GameData;
import ee.eek.guess.data.PlayerData;
import ee.eek.guess.handlers.GameHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class GameController {

    private final GameHandler gameHandler = new GameHandler();

    @GetMapping("/help")
    public String getMethodName() {
        return "Go to /game to play!";
    }

    @PostMapping("/game")
    public GameData postMethodName(@RequestBody PlayerData playerData) {
        return gameHandler.starGame(playerData);
    }

    @GetMapping("/game/{game_id}/guess/{guessNumber}")
    public String guess(@PathVariable Integer game_id, @PathVariable Integer guessNumber) {
        return gameHandler.guessing(game_id, guessNumber);
    }
}
