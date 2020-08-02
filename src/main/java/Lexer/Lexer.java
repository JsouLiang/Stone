package Lexer;

import Utils.exception.ParseException;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    static final String NumberLiteral = "[0-9]+";
    /// 标识符
    /// 标识符不能以数字开头: [A-Z_a-z][A-Z_a-z0-9]*
    //  ==, >=, <=, &&
    // \|\| 匹配 || 因为 | 是正则表达式的元字符, 所以需要\ 转移
    // Java 语言的字符串字面量中，反斜杠与双引号必须分 别以 \\ 与 \" 的形式转义。
    // 在 Java 中正则表达式中则需要有两个反斜杠\\ 才能被解析为其他语言中的转义作用。
    // java 中两个\\ 表示一条反斜杠，所以\d -> \\d
    // 表示一个普通的反斜杠是 \\\\
    static final String Identifier = "[A-Z_a-z][A-Z_a-z0-9]*|<=|==|>=|&&|\\|\\||\\p{Punct}";

    // \" -> \\\\\" -> \\\\ 表示第一个\ , 最后一个\ 表示转移"
    // \\ -> \\\\\\\
    // \n -> \\\\n
    // 除了" 之外任意一个字符
    static final String StringLiteral = "\"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\"";

    /// 空字符串，0 个或 0 个以上的空字符
    static final String EmptyCharacters = "\\s*";

    // 以// 开头的注释
    static final String Comment = "//.*";


    // ((pat1)|(pat2)|(pat3)?
    // EmptyCharacters((Comment)|(NumberLiteral)|(StringLiteral)|Identifier)?
//    public static String regexPat = EmptyCharacters + "((" + Comment + ")|(" + NumberLiteral + ")|(" + StringLiteral + ")|" + Identifier + ")?";
    public static String regexPat
            = "\\s*((//.*)|([0-9]+)|(\"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\")"
            + "|[A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&|\\|\\||\\p{Punct})?";
    private Pattern pattern = Pattern.compile(regexPat);

    private ArrayList<Token> queue = new ArrayList<Token>();

    private boolean hasMore;

    private LineNumberReader reader;

    public Lexer(Reader r) {
        hasMore = true;
        reader = new LineNumberReader(r);
    }

    /**
     * read 方法从源代码头部开始注意获取单词，
     * 调用 read 时返回一个新的单词
     * @return 新单词
     */
    public Token read() throws ParseException {
        if (fillQueue(0)) {
            return queue.remove(0);
        }
        return Token.EOF;
    }

    /**
     *
     * @param i
     * @return
     * @throws ParseException
     */
    public Token peek(int i) throws ParseException {
        if (fillQueue(i)) {
            return queue.get(i);
        }
        return Token.EOF;
    }

    private boolean fillQueue(int i) throws ParseException {
        while (i >= queue.size()) {
            if (hasMore) {
                readLine();
            } else {
                return false;
            }
        }
        return true;
    }

    void readLine() throws ParseException {
        String line;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new ParseException(e);
        }
        if (line == null) {
            hasMore = false;
            return;
        }
        int lineNo = reader.getLineNumber();
        Matcher matcher = pattern.matcher(line);
        matcher.useTransparentBounds(true).useAnchoringBounds(false);
        int pos = 0;
        int endPos = line.length();
        while (pos < endPos) {
            matcher.region(pos, endPos);
            if (matcher.lookingAt()) {
                addToken(lineNo, matcher);
                pos = matcher.end();
            }
            else
                throw new ParseException("bad token at line " + lineNo);
        }
        queue.add(new IdToken(lineNo, Token.EOL));
    }

    void addToken(int lineNumber, Matcher matcher) {
        String m = matcher.group(1);
        if (m != null) {
            if (matcher.group(2) == null) {
                Token token;
                if (matcher.group(3) != null) {
                    token = new NumberToken(lineNumber, Integer.parseInt(m));
                } else if (matcher.group(4) != null) {
                    token = new StringToken(lineNumber, toStringLiteral(m));
                } else {
                    token = new IdToken(lineNumber, m);
                }
                queue.add(token);
            }
        }
    }

    private String toStringLiteral(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int len = s.length() - 1;
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (c == '\\' && i + 1 < len) {
                int c2 = s.charAt(i + 1);
                if (c2 == '"' || c2 == '\\') {
                    c = s.charAt(++i);
                } else if (c2 == 'n') {
                    i++;
                    c = '\n';
                }
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

}
