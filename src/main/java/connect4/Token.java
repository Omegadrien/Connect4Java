package connect4;

public class Token {

    private String value;

    public Token() {
        value = " ";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (value != "X" && value != "O") {
            throw new RuntimeException();
        }
        this.value = value;
    }
}
