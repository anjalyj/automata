import java.util.Arrays;

public class DFA {
    private String state;
    private String[] alphabetSet;
    private TransitionFunction transitionFunction;
    private String initialState;
    private String[] finalState;

    public DFA(String state, String[] alphabetSet, TransitionFunction transitionFunction, String initialState, String[] finalState) {
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
        return Arrays.asList(finalState).contains(currentState);

    }

    private boolean isValidInput(String[] inputString) {
        for (String alphabet : inputString) {
            if(!Arrays.asList(alphabetSet).contains(alphabet))
                return false;
        }
        return true;
    }
}
