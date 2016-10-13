import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;


public class TransitionFunctionTest {
    @Test
    public void shouldReturnTheNextState() throws Exception {
        TransitionFunction transitionFunction = new TransitionFunction();
        transitionFunction.setTransition("q1", "1", "q2");
        transitionFunction.setTransition("q1", "0", "q1");
        transitionFunction.setTransition("q2", "1", "q3");
        transitionFunction.setTransition("q2", "0", "q2");
        transitionFunction.setTransition("q3", "1", "q3");
        transitionFunction.setTransition("q3", "0", "q3");

        assertEquals("q2",transitionFunction.getNextState("q1","1"));
        assertEquals("q1",transitionFunction.getNextState("q1","0"));
        assertEquals("q3",transitionFunction.getNextState("q2","1"));
        assertEquals("q2",transitionFunction.getNextState("q2","0"));
        assertEquals("q3",transitionFunction.getNextState("q3","1"));
        assertEquals("q3",transitionFunction.getNextState("q3","0"));

    }
}