package Parser;

import AST.ASTLeaf;
import AST.ASTree;
import Lexer.*;
import Utils.exception.ParseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

abstract class Element {
    abstract void parse(Lexer lexer, List<ASTree> res) throws ParseException;
    abstract boolean match(Lexer lexer) throws ParseException;
}

class Tree extends Element {
    @Override
    void parse(Lexer lexer, List<ASTree> res) throws ParseException {

    }

    @Override
    boolean match(Lexer lexer) throws ParseException {
        return false;
    }
}

class OrTree extends Element {
    @Override
    void parse(Lexer lexer, List<ASTree> res) throws ParseException {

    }

    @Override
    boolean match(Lexer lexer) throws ParseException {
        return false;
    }
}

class Repeat extends Element {
    @Override
    void parse(Lexer lexer, List<ASTree> res) throws ParseException {

    }

    @Override
    boolean match(Lexer lexer) throws ParseException {
        return false;
    }
}

class AToken extends Element {
    @Override
    void parse(Lexer lexer, List<ASTree> res) throws ParseException {

    }

    @Override
    boolean match(Lexer lexer) throws ParseException {
        return false;
    }
}

class IdToken extends Element {
    @Override
    void parse(Lexer lexer, List<ASTree> res) throws ParseException {

    }

    @Override
    boolean match(Lexer lexer) throws ParseException {
        return false;
    }
}

class NumToken extends Element {
    @Override
    void parse(Lexer lexer, List<ASTree> res) throws ParseException {

    }

    @Override
    boolean match(Lexer lexer) throws ParseException {
        return false;
    }
}

class StrToken extends Element {
    @Override
    void parse(Lexer lexer, List<ASTree> res) throws ParseException {

    }

    @Override
    boolean match(Lexer lexer) throws ParseException {
        return false;
    }
}

class Leaf extends Element {
    @Override
    void parse(Lexer lexer, List<ASTree> res) throws ParseException {

    }

    @Override
    boolean match(Lexer lexer) throws ParseException {
        return false;
    }
}

class Skip extends Element {
    @Override
    void parse(Lexer lexer, List<ASTree> res) throws ParseException {

    }

    @Override
    boolean match(Lexer lexer) throws ParseException {
        return false;
    }
}

class Expr extends Element {
    @Override
    void parse(Lexer lexer, List<ASTree> res) throws ParseException {

    }

    @Override
    boolean match(Lexer lexer) throws ParseException {
        return false;
    }
}

abstract class Factory {}

class Precedence {}

class Operators extends HashMap<String, Precedence> {

}

public class Parser {

    private List<Element> elements;

    /**
     * rule 是创建 Parser 的 factory 方法。
     * 由他创建的 Parser 对象模式为空，
     * 需要按照 文法中终结符或者非终结符 出现的顺序 向模式中 添加相应的终结符或者非终结符
     * @return
     */
    public static Parser rule() {
        return null;
    }

    public static Parser rule(Class<? extends ASTree> clazz) {
        return null;
    }

    public Parser reset() {
        elements = new ArrayList<>();
        return this;
    }

    /**
     * 向文法规则中添加 整形字面量终结符
     * @return
     */
    public Parser number() {
        return this;
    }

    /**
     * 向文法规则中添加终结符：整形字面量
     * @return
     */
    public Parser number(Class<? extends ASTLeaf> clazz) {
        return this;
    }

    /**
     * 向文法规则中添加终结符：标识符
     * @param reversed
     * @return
     */
    public Parser identifier(HashSet<String> reversed) {
        return this;
    }

    public Parser identifier(Class<? extends ASTLeaf> clazz, HashSet<String> reserved) {
//        elements.add(new IdToken(clazz, reserved));
        return this;
    }

    /**
     * 向文法规则中添加终结符：字符串字面量
     * @param clazz
     * @return
     */
    public Parser string(Class<? extends ASTLeaf> clazz) {
        return this;
    }

    /**
     * 向文法中添加与 pat 匹配的非终结符
     * @param pat
     * @return
     */
    public Parser token(String... pat) {
//        elements.add(new Leaf());
        return this;
    }

    /**
     * 向文法规则中添加未包含于抽象语法树的终结符，比如抽象语法树会将括号省略的括号
     * @param pat
     * @return
     */
    public Parser sep(String... pat) {
//        elements.add(new Skip());
        return this;
    }

    /**
     * 向文法中添加非终结符 p
     * @param p 非终结符
     */
    public Parser ast(Parser p) {
        //
        return this;
    }

    /**
     * 向文法中添加若干个由 or 关系链接的非终结符 p
     * @param p
     * @return
     */
    public Parser or(Parser... p) {
        //
        return this;
    }

    /**
     * 向文法中添加可省略的非终结符 p，如果省略，则作为一颗仅有根节点的抽象语法树处理
     * @param p
     * @return
     */
    public Parser maybe(Parser p) {
        //
        return this;
    }

    /**
     * 向文法中添加可省略的非终结符 p
     * @param p
     * @return
     */
    public Parser option(Parser p) {
        //
        return this;
    }

    /**
     * 向文法中添加至少重复出现 0 次的非终结符 p
     * @param p
     * @return
     */
    public Parser repeat(Parser p) {
        //
        return this;
    }

    /**
     * 向文法中添加双目运算表达式
     * @param subexp 因子
     * @param operators 运算符表
     * @return
     */
    public Parser expression(Parser subexp, Operators operators) {
        //
        return this;
    }

    /**
     * 向文法中添加双目运算表达式
     * @param subexp 因子
     * @param operators 运算符表
     * @return
     */
    public Parser expression(Class<? extends ASTree> clazz, Parser subexp,
                             Operators operators) {
        //
        return this;
    }
}
