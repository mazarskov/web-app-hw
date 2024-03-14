package ee.eek.guess.data;

import lombok.Data;

@Data
public class GameData {
    Integer id;
    String gameStatus = "Game started!";
}
