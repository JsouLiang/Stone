package Lexer;

public class NumberToken extends Token {
    private int value;
    NumberToken(int line, int value) {
        super(line);
        this.value = value;
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public int getNumber() {
        return value;
    }

    @Override
    public String getText() {
        return Integer.toString(value);
    }
}
