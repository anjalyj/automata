import java.util.HashMap;
import java.util.Map;

public class TransitionFunction {
    Map<String,Map<String,String>> transitions = new HashMap<String, Map<String, String>>();

    public void setTransition(String presentState, String character, String nextState) {
        transitions.putIfAbsent(presentState,new HashMap<String, String>());
        transitions.get(presentState).put(character,nextState);
    }

    public String getNextState(String presentState, String character) {
        if(!transitions.containsKey(presentState))
            return null;
        return transitions.get(presentState).get(character);
    }
}
