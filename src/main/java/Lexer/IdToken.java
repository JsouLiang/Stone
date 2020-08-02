package Lexer;

public class IdToken extends Token {
    private String text;
    IdToken(int line, String id) {
        super(line);
        this.text = id;
    }

    @Override
    public boolean isIdentifier() {
        return true;
    }

    @Override
    public String getText() {
        return text;
    }
}
