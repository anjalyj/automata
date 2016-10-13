import org.junit.Test;

import static org.junit.Assert.*;

public class DFATest {
    @Test
    public void returnsTrueIfDFAAcceptsTheLanguage() throws Exception {
        String states = "q1,q2,q3";


        TransitionFunction transitionFunction = new TransitionFunction();
        transitionFunction.setTransition("q1", "1", "q2");
        transitionFunction.setTransition("q1", "0", "q1");
        transitionFunction.setTransition("q2", "1", "q3");
        transitionFunction.setTransition("q2", "0", "q2");
        transitionFunction.setTransition("q3", "1", "q3");
        transitionFunction.setTransition("q3", "0", "q3");

        String[] alphabetSet = new String[2];
        alphabetSet[0] = "0";
        alphabetSet[1] = "1";
        String initialState = "q1";
        String[] finalState = new String[1];
        finalState[0] = "q2";


        DFA dfa = new DFA(states, alphabetSet, transitionFunction, initialState, finalState);
        assertTrue(dfa.isAccepted("100"));

    }
    @Test
    public void returnsFalseIfDFADoesntAcceptsTheLanguage() throws Exception {
        String states = "q1,q2,q3";


        TransitionFunction transitionFunction = new TransitionFunction();
        transitionFunction.setTransition("q1", "1", "q2");
        transitionFunction.setTransition("q1", "0", "q1");
        transitionFunction.setTransition("q2", "1", "q3");
        transitionFunction.setTransition("q2", "0", "q2");
        transitionFunction.setTransition("q3", "1", "q3");
        transitionFunction.setTransition("q3", "0", "q3");

        String[] alphabetSet = new String[2];
        alphabetSet[0] = "0";
        alphabetSet[1] = "1";
        String initialState = "q1";
        String[] finalState = new String[1];
        finalState[0] = "q2";


        DFA dfa = new DFA(states, alphabetSet, transitionFunction, initialState, finalState);
        assertFalse(dfa.isAccepted("1001"));

    }
}