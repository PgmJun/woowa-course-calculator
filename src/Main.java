import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();

        ExpressionCalculator calculator = new ExpressionCalculator();
        System.out.println(calculator.calculate(value));
    }
}