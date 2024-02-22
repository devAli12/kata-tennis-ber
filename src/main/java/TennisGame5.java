import java.util.HashMap;
import java.util.Map;

public class TennisGame5 implements TennisGame {
    
    private final String player1;
    private final String player2;
    private int player1Score;
    private int player2Score;

    public TennisGame5(String player1Name, String player2Name) {
        this.player1 = player1Name;
        this.player2 = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score++;
        else if (playerName.equals("player2"))
            player2Score++;
        else
            throw new IllegalArgumentException("Invalid player name.");
    }

    @Override
    public String getScore() {
        int p1 = player1Score;
        int p2 = player2Score;

        while (p1 > 4 || p2 > 4) {
            p1--;
            p2--;
        }

        Map<Map.Entry,String> dictionary  = new HashMap<Map.Entry, String>();
        initializeDictionary(dictionary);
        var entry = Map.entry(p1, p2);
       return getValueFromDictionaryByEntry(dictionary,entry);
    }


    private String getValueFromDictionaryByEntry(Map<Map.Entry, String> dictionary,Map.Entry entry){
        if (dictionary.containsKey(entry)) {
            return dictionary.get(entry);
        } else {
            throw new IllegalArgumentException("Invalid score.");
        }
    }

    private void initializeDictionary(Map<Map.Entry, String> dictionary){
        dictionary.put(Map.entry(0, 0), "Love-All");
        dictionary.put(Map.entry(0, 1), "Love-Fifteen");
        dictionary.put(Map.entry(0, 2), "Love-Thirty");
        dictionary.put(Map.entry(0, 3), "Love-Forty");
        dictionary.put(Map.entry(0, 4), "Win for player2");
        dictionary.put(Map.entry(1, 0), "Fifteen-Love");
        dictionary.put(Map.entry(1, 1), "Fifteen-All");
        dictionary.put(Map.entry(1, 2), "Fifteen-Thirty");
        dictionary.put(Map.entry(1, 3), "Fifteen-Forty");
        dictionary.put(Map.entry(1, 4), "Win for player2");
        dictionary.put(Map.entry(2, 0), "Thirty-Love");
        dictionary.put(Map.entry(2, 1), "Thirty-Fifteen");
        dictionary.put(Map.entry(2, 2), "Thirty-All");
        dictionary.put(Map.entry(2, 3), "Thirty-Forty");
        dictionary.put(Map.entry(2, 4), "Win for player2");
        dictionary.put(Map.entry(3, 0), "Forty-Love");
        dictionary.put(Map.entry(3, 1), "Forty-Fifteen");
        dictionary.put(Map.entry(3, 2), "Forty-Thirty");
        dictionary.put(Map.entry(3, 3), "Deuce");
        dictionary.put(Map.entry(3, 4), "Advantage player2");
        dictionary.put(Map.entry(4, 0), "Win for player1");
        dictionary.put(Map.entry(4, 1), "Win for player1");
        dictionary.put(Map.entry(4, 2), "Win for player1");
        dictionary.put(Map.entry(4, 3), "Advantage player1");
        dictionary.put(Map.entry(4, 4), "Deuce");

    }
}
