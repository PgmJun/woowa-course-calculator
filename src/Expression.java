import java.util.StringJoiner;
import java.util.regex.Pattern;

public class Expression {
    private String[] separators;
    private String expression;

    public Expression(String[] separators, String expression) {
        this.separators = separators;
        this.expression = expression;
    }

    public static Expression from(String[] customSeparatorAndExpression) {
        String[] separators = new String[]{",", ":"};
        String expression = "";
        if (customSeparatorAndExpression.length == 2) {
            String customSeparatorIndicator = customSeparatorAndExpression[0];
            if (Pattern.matches("\\/\\/.+", customSeparatorIndicator)) {
                separators = new String[]{String.valueOf(customSeparatorIndicator.charAt(2))};
                expression = customSeparatorAndExpression[1];
            } else {
                throw new RuntimeException();
            }
        } // Custom 구분자가 존재하지 않는 경우
        else if (customSeparatorAndExpression.length == 1) {
            expression = customSeparatorAndExpression[0];
        }

        return new Expression(separators, expression);
    }

    public String[] splitExpression() {
        return expression.split(getSeparatorRegex());
    }

    public String getSeparatorRegex() {
        StringJoiner regex = new StringJoiner("", "[", "]");
        for (String separator : separators) {
            regex.add(separator);
        }

        return regex.toString();
    }
}
