package calculator;


import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.ToIntBiFunction;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> {
        if (y == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return x / y;
    });

    private String symbol;
    private ToIntBiFunction<Integer, Integer> expression;
    private static final Map<String, Operator> map = Map.of(
            "+", Operator.PLUS,
            "-", Operator.MINUS,
            "*", Operator.MULTIPLY,
            "/", Operator.DIVIDE
    );

    Operator(String symbol, ToIntBiFunction<Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static int calculate(String operator, int x, int y) {
        return map.get(operator).expression.applyAsInt(x, y);
    }

}
