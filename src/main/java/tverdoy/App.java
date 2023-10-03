package tverdoy;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        System.out.println(calc(input));
    }

    public static String calc(String input) {
        SyntaxTree syntaxTree;

        try {
            syntaxTree = SyntaxTree.parse(input);
            if (syntaxTree.getFirstArgument() > 10 || syntaxTree.getSecondArgument() > 10) {
                throw new Exception();
            }

            Calculator calculator = new Calculator(syntaxTree);
            return calculator.calculateToString();
        } catch (Exception e) {
            return "throws Exception";
        }
    }
}
