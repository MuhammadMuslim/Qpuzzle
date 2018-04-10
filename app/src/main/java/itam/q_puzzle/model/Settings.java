package itam.q_puzzle.model;

/**
 * Created by M. ROMADLONI on 20-06-2016.
 */
public class Settings {

    String param;
    int valInt = 0;
    String valString = "";

    // constructor
    public Settings() {

    }

    public Settings(String param, int valInt) {
        this.param = param;
        this.valInt = valInt;
    }

    public Settings(String param, String valString) {
        this.param = param;
        this.valString = valString;
    }

    public Settings(String param, int valInt, String valString) {
        this.param = param;
        this.valInt = valInt;
        this.valString = valString;
    }

    // setters
    public void setParam(String param) {
        this.param = param;
    }

    public void setValInt(int valInt) {
        this.valInt = valInt;
    }

    // getters
    public String getParam() {
        return this.param;
    }

    public int getValInt() {
        return this.valInt;
    }

    public String getValString() {
        return valString;
    }

    public void setValString(String valString) {
        this.valString = valString;
    }
}
