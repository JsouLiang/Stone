package Parser;
import AST.*;
import Lexer.Token;

import java.util.HashSet;

import static Parser.Parser.rule;

public class BasicParser {
    HashSet<String> reversed = new HashSet<>();
    Operators operators = new Operators();
    Parser expr0 = rule();
    Parser primary = rule(PrimaryExpr.class)
            .or(rule().sep("(").ast(expr0).sep(")"),
                rule().number(NumberLiteral.class),
                rule().identifier(Name.class, reversed),
                rule().string(StringLiteral.class));
    // factor = - primary | primary
    Parser factor = rule().or(
      rule(NegativeExpr.class).sep("-").ast(primary), primary
    );

    Parser expr = expr0.expression(BinaryExpr.class, factor, operators);

    Parser statement0 = rule();

    Parser block = rule(BlockStmnt.class)
            .sep("{").option(statement0)
            .repeat(rule().sep(";", Token.EOL).option(statement0))
            .sep("}");

    Parser simple = rule(PrimaryExpr.class).ast(expr);

    Parser statement = statement0.or(
      rule(IfStatement.class).sep("if").ast(expr).ast(block).option(rule().sep("else").ast(block)),
      rule(WhileStatement.class).sep("while").ast(expr).ast(block), simple
    );

}
