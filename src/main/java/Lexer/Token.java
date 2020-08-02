package Lexer;

import Utils.exception.StoneException;

public abstract class Token {
    /// end of file
    public static final Token EOF = new Token(-1) {};
    /// end of line
    public static final String EOL = "\\n";

    private int lineNumber;
    protected Token(int line) {
        lineNumber = line;
    }

    public int getLineNumber() { return lineNumber; }
    /// 是否是标识符
    /// 标识符：变量名，函数名或者类名，运算符，括号，标点符号，保留字
    public boolean isIdentifier() { return false; }
    /// 是否是整形字面量
    /// 整形字面量：1234
    public boolean isNumber() { return false; }
    /// 是否是字符串字面量
    /// 字符串字面量："xxx"
    public boolean isString() { return false; }

    public int getNumber() {
        throw new StoneException("not number token");
    }

    public String getText() {
        return "";
    }

}
