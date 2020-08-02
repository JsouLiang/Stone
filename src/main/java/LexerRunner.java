import Lexer.*;
import Utils.exception.ParseException;
import stone.CodeDialog;

public class LexerRunner {
    public static void main(String[] args) throws ParseException {
        Lexer l = new Lexer(new CodeDialog());
        while (true) {
            Token t = l.read();
            System.out.println("=> " + t.getText());
        }
    }
}
