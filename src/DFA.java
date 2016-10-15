import java.util.Arrays;
import java.util.List;

public class DFA {
    private List<String> state;
    private List<String> alphabetSet;
    private TransitionFunction transitionFunction;
    private String initialState;
    private List<String> finalState;

    public DFA(List<String> state, List<String> alphabetSet, TransitionFunction transitionFunction, String initialState, List<String> finalState) {
        this.state = state;
        this.alphabetSet = alphabetSet;
        this.transitionFunction = transitionFunction;
        this.initialState = initialState;
        this.finalState = finalState;
    }

    public boolean isAccepted(String inputString) {
        String[] givenString = inputString.split("");
        if(!isValidInput(givenString)){
            return false;
        }
        String currentState = initialState;
        for (String alphabet : givenString) {
            currentState = transitionFunction.getNextState(currentState,alphabet);
        }
        return finalState.contains(currentState);

    }

    private boolean isValidInput(String[] inputString) {
        for (String alphabet : inputString) {
            if(!alphabetSet.contains(alphabet))
                return false;
        }
        return true;
    }
}
