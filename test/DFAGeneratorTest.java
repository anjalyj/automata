import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;


public class DFAGeneratorTest {
    @Test
    public void shouldReturnADFA() throws Exception {
        DFAGenerator dfaGenerator = new DFAGenerator();
        DFA dfa = dfaGenerator.createDFA();
        assertTrue(dfa.isAccepted("000"));
        assertFalse(dfa.isAccepted("0000"));
    }
}