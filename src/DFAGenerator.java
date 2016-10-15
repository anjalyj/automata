


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;

public class DFAGenerator {

    public DFAData  parse() throws FileNotFoundException {
        JsonParser jsonParser = new JsonParser();
        String jsonInput = "{"+
                "'name':'odd number of zeroes',"+
                "'type' : 'dfa',"+
                "'tuple' :{" +
                "'states' : ['q1','q2'],"+
                "'alphabets' : ['1','0'],"+
                "'delta' : {" +
                "'q1': {'0' : 'q2','1' : 'q1'},"+
                "'q2': {'0' : 'q1','1' : 'q2'}" +
                "},"+
                "'startState' : 'q1',"+
                "'finalStates' : ['q2']" +
                "},"+
                "'passCases' : ['0','000','00000','10','101010','010101'],"+
                "'failCases' : ['00','0000','1001','1010','001100']"+
                "}";

        JsonElement dfaElement = jsonParser.parse(jsonInput);
        Gson gson = new Gson();
        DFAData dfaData = gson.fromJson(dfaElement, DFAData.class);

        return dfaData;
    }

    public DFA createDFA() throws FileNotFoundException {
        DFAData dfaData = parse();
        DFA dfa = dfaData.createDFA();
        return dfa;
    }

}
