import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DFAData {
    private String name;
    private String type;
    private Tuple tuple;
    private List<String> passCases;
    private List<String> failCases;


    public DFAData(String name,String type,Tuple tuple,List<String> passCases,
                   List<String> failCases) {
        this.name = name;
        this.type = type;
        this.tuple = tuple;
        this.passCases = passCases;
        this.failCases = failCases;
    }

    public DFA createDFA() {

        HashMap<String, HashMap<String, String>> delta = tuple.getDelta();
        List<String> alphabets = tuple.getAlphabets();
        List<String> states = tuple.getStates();
        TransitionFunction transitionFunction = new TransitionFunction();

        for (String state : states) {
            for (String alphabet : alphabets) {
                transitionFunction.setTransition(state,alphabet,delta.get(state).get(alphabet));
            }
        }

        DFA dfa = new DFA(tuple.getStates(), tuple.getAlphabets(), transitionFunction, tuple.getStartState(), tuple.getfinalStates());

        return dfa;
    }
}
