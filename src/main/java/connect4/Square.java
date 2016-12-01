package connect4;

public class Square {

    private String value;

    public Square() {
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
