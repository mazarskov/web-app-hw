package ee.eek.guess.handlers;

import java.util.Map;

import ee.eek.guess.data.PlayerData;

import java.util.HashMap;
public class DataHandler {

    public static Map<Integer, PlayerData> map = new HashMap<Integer, PlayerData>();

    public void addToMap(Integer key, PlayerData data) {
        map.put(key, data);
    }

    public Integer checkSize() {
        return map.size();
    }

    public Integer printOut(Integer key) {
        PlayerData value = map.get(key);
        return value.getNumber();
    }
    public void clearMap() {
       map.clear();
    }
    public boolean checkKey(Integer key) {
        return map.containsKey(key);
    }
    public boolean checkGameStatus(Integer key) {
        PlayerData value = map.get(key);
        return value.isFinised();
    }
    public PlayerData endGame(Integer key) {
        PlayerData value = map.get(key);
        value.setFinised(true);
        return value;
    }
}
