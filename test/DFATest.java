import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DFATest {
    @Test
    public void returnsTrueIfDFAAcceptsTheLanguage() throws Exception {
        List<String> states = new ArrayList<String>();
        states.add("q1");
        states.add("q2");
        states.add("q3");

        TransitionFunction transitionFunction = new TransitionFunction();
        transitionFunction.setTransition("q1", "1", "q2");
        transitionFunction.setTransition("q1", "0", "q1");
        transitionFunction.setTransition("q2", "1", "q3");
        transitionFunction.setTransition("q2", "0", "q2");
        transitionFunction.setTransition("q3", "1", "q3");
        transitionFunction.setTransition("q3", "0", "q3");

        List<String> alphabetSet = new ArrayList<String>();
        alphabetSet.add("0");
        alphabetSet.add("1");

        String initialState = "q1";

        List<String> finalState = new ArrayList<String>();
        finalState.add("q2");


        DFA dfa = new DFA(states, alphabetSet, transitionFunction, initialState, finalState);
        assertTrue(dfa.isAccepted("100"));

    }
    @Test
    public void returnsFalseIfDFADoesntAcceptsTheLanguage() throws Exception {
        List<String> states = new ArrayList<String>();
        states.add("q1");
        states.add("q2");
        states.add("q3");

        TransitionFunction transitionFunction = new TransitionFunction();
        transitionFunction.setTransition("q1", "1", "q2");
        transitionFunction.setTransition("q1", "0", "q1");
        transitionFunction.setTransition("q2", "1", "q3");
        transitionFunction.setTransition("q2", "0", "q2");
        transitionFunction.setTransition("q3", "1", "q3");
        transitionFunction.setTransition("q3", "0", "q3");

        List<String> alphabetSet = new ArrayList<String>();
        alphabetSet.add("0");
        alphabetSet.add("1");

        String initialState = "q1";

        List<String> finalState = new ArrayList<String>();
        finalState.add("q2");


        DFA dfa = new DFA(states, alphabetSet, transitionFunction, initialState, finalState);
        assertFalse(dfa.isAccepted("1001"));

    }
}