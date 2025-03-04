package fractions;

import java.util.ArrayList;
import java.util.List;

/**
 * Zet een string om naar een expression.
 */
public class Parser {

    private String line;

    public Expression parse(String line) {
        this.line = line + ".";
        this.pos = -1;
        next();
        return sequence();
    }

    private int pos;

    private void next() {
        pos++;
        while (line.charAt(pos) == ' ') {
            pos++;
        }
    }

    private boolean isEndOfSequence() {
        char ch = line.charAt(pos);
        return ch == '}' || ch == ')' || ch == '.';
    }

    private Expression sequence() {
        Expression result = fraction();
        if (isEndOfSequence()) {
            return result;
        } else {
            List<Expression> list = new ArrayList<>();
            list.add(result);
            list.add(fraction());
            while (!isEndOfSequence()) {
                list.add(fraction());
            }
            return new Sequence(list);
        }
    }

    private Expression fraction() {
        Expression result = basic();
        if (line.charAt(pos) == '/') {
            next();
            return new Fraction(result, basic());
        } else {
            return result;
        }
    }

    private Expression basic() {
        if (line.charAt(pos) == '{') {
            next();
            Expression result = sequence();
            next(); // slaat de '}' over
            return result;
        } else if (line.charAt(pos) == '(') {
            next();
            Expression result = sequence();      //  = new Parenthesised(sequence());
            next(); // slaat de ')' over
            return result;
        } else {
            return simple();
        }
    }

    private boolean isEndOfSimple() {
        char ch = line.charAt(pos);
        return ch == ' ' || ch == '/' || isEndOfSequence();
    }

    private Expression simple() {
        int start = pos;
        while (!isEndOfSimple()) {
            pos++;
        }
        Expression result = new Simple(line.substring(start, pos));
        while (line.charAt(pos) == ' ') {
            pos++;
        }
        return result;
    }
}
