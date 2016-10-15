import java.util.HashMap;
import java.util.List;

public class Tuple {

    private final List<String> states;
    private final List<String> alphabets;
    private final HashMap<String, HashMap<String, String>> delta;
    private final String startState;
    private final List<String> finalStates;

    public Tuple(List<String> states,List<String> alphabets, HashMap<String,HashMap<String,String>>delta,
                 String startState, List<String> finalStates) {
        this.states = states;
        this.alphabets = alphabets;
        this.delta = delta;
        this.startState = startState;
        this.finalStates = finalStates;
    }

    public HashMap<String, HashMap<String, String>> getDelta() {
        return delta;
    }

    public List<String> getAlphabets() {
        return alphabets;
    }

    public List<String> getStates() {
        return states;
    }

    public String getStartState() {
        return startState;
    }

    public List<String> getfinalStates() {
        return finalStates;
    }
}
