public class ExpressionCalculator {
    public int calculate(String value) {
        int sum = 0;
        if (value.isBlank()) {
            return sum;
        }

        Expression expression = getExpression(value);
        for (String splittedNumber : expression.splitExpression()) {
            try {
                sum += Integer.parseInt(splittedNumber);
            } catch (NumberFormatException exception) {
                throw new RuntimeException();
            }
        }
        return sum;
    }

    private static Expression getExpression(String value) {
        // '\n' 으로 split이 불가능해서 n으로 replace
        value = value.replace("\\n", "n");
        String[] customSeparatorAndExpression = value.split("n");

        return Expression.from(customSeparatorAndExpression);
    }
}
