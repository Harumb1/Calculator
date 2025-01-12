import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    static double num1 = 0;
    static double num2 = 0;
    static double result = 0;
    static char operator;
    static JTextField text = new JTextField();
    static JButton equal = new JButton("=");
    static String line = "";

    public static void main(String[] args) {
        num1 = 0;
        num2 = 0;
        result = 0;

        JFrame f = new JFrame("Calculator!");
        JButton one = new JButton("1");
        JButton plus = new JButton("+");
        JButton two = new JButton("2");
        JButton zero = new JButton("0");
        equal = new JButton("=");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton clear = new JButton("C");
        JButton minus = new JButton("-");
        JButton mult = new JButton("x");
        JButton div = new JButton("÷");

        text = new JTextField();
        text.setBounds(50, 50, 200, 30); //textfield

        equal.setBounds(190, 250, 50, 30);
        plus.setBounds(260, 100, 50, 30);
        zero.setBounds(120, 250, 50, 30);
        one.setBounds(50, 100, 50, 30);
        two.setBounds(120, 100, 50, 30);
        three.setBounds(190, 100, 50, 30);
        four.setBounds(50, 150, 50, 30);
        five.setBounds(120, 150, 50, 30);
        six.setBounds(190, 150, 50, 30);
        seven.setBounds(50, 200, 50, 30);
        eight.setBounds(120, 200, 50, 30);
        nine.setBounds(190, 200, 50, 30);
        clear.setBounds(50, 250, 50, 30);
        minus.setBounds(260, 150, 50, 30);
        mult.setBounds(260, 200, 50, 30);
        div.setBounds(260, 250, 50, 30);

        f.add(minus);
        f.add(text);
        f.add(one);
        f.add(two);
        f.add(three);
        f.add(four);
        f.add(five);
        f.add(six);
        f.add(seven);
        f.add(eight);
        f.add(nine);
        f.add(zero);
        f.add(clear);
        f.add(plus);
        f.add(equal);
        f.add(div);
        f.add(mult);

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Add ActionListeners for the number buttons
        // All ActionListeners have lambda expressions added "->"
        one.addActionListener(e -> {
            String currentText = text.getText();
            text.setText(currentText + "1");
            line += "1";
        });

        plus.addActionListener(e -> {
            String currentText = text.getText();
            num1 = Double.parseDouble(currentText); // Store the first number
            operator = '+'; // Store the operator
            text.setText(""); // Clear the display
            line += " + ";
        });

        minus.addActionListener(e -> {
            String currentText = text.getText();
            num1 = Double.parseDouble(currentText);
            operator = '-';
            text.setText("");
            line += " - ";
        });

        div.addActionListener(e -> {
            String currentText = text.getText();
            num1 = Double.parseDouble(currentText);
            operator = '/';
            text.setText("");
            line += " / ";
        });

        mult.addActionListener(e -> {
            String currentText = text.getText();
            num1 = Double.parseDouble(currentText);
            operator = '*';
            text.setText("");
            line += " * ";
        });

        // Add ActionListeners for other number buttons
        two.addActionListener(e -> {
            String currentText = text.getText();
            text.setText(currentText + "2");
            line += "2";
        });

        zero.addActionListener(e -> {
            String currentText = text.getText();
            text.setText(currentText + "0");
            line += "0";
        });

        three.addActionListener(e -> {
            String currentText = text.getText();
            text.setText(currentText + "3");
            line += "3";
        });

        four.addActionListener(e -> {
            String currentText = text.getText();
            text.setText(currentText + "4");
            line += "4";
        });

        five.addActionListener(e -> {
            String currentText = text.getText();
            text.setText(currentText + "5");
            line += "5";
        });

        six.addActionListener(e -> {
            String currentText = text.getText();
            text.setText(currentText + "6");
            line += "6";
        });

        seven.addActionListener(e -> {
            String currentText = text.getText();
            text.setText(currentText + "7");
            line += "7";
        });

        eight.addActionListener(e -> {
            String currentText = text.getText();
            text.setText(currentText + "8");
            line += "8";
        });

        nine.addActionListener(e -> {
            String currentText = text.getText();
            text.setText(currentText + "9");
            line += "9";
        });

        clear.addActionListener(e ->{
            text.setText("");
            line = "";
        });

        equal.addActionListener(e -> {
            num2 = Double.parseDouble(text.getText()); // Get the second number
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    //if num2 is "0" return error - you can't divide by zero
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        text.setText("Error"); // Handle division by zero
                        return;
                    }
                    break;
                default:
                    return;
            }

            num1 = result; // Store result for chained calculations
            try {
                FileWriter myWriter = new FileWriter("C:\\Users\\alexs\\OneDrive\\TerminalGame\\src\\history.txt", true);
                myWriter.append(line).append(" = ").append(String.valueOf(result)).append("\n");
                myWriter.close();
                System.out.println("File updated.");
            } catch (IOException exception) {
                System.out.println("Error!");
                exception.printStackTrace();
            }
            text.setText(line = String.valueOf(result)); // Show result
        });
    }
}
