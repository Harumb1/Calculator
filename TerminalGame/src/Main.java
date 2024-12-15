import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Line 191 https://www.w3schools.com/java/ref_string_split.asp

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame("Calculator!");
        JButton one = new JButton("1");
        JButton plus = new JButton("+");
        JButton two = new JButton("2");
        JButton zero = new JButton("0");
        JButton equal = new JButton("=");
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
        JTextField text = new JTextField();
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
        clear.setBounds(50,250,50,30);
        minus.setBounds(260,150,50,30);
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
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = text.getText(); // Get the current text
                text.setText(currentText + "1");    // Append "1"
            }
        });

        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = text.getText();
                text.setText(currentText + "+"); // Append "+"
            }
        });

        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = text.getText();
                text.setText(currentText + "-"); // Append "-"
            }
        });

        div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = text.getText();
                text.setText(currentText + "÷"); // Append "÷"
            }
        });

        mult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = text.getText();
                text.setText(currentText + "x"); // Append "x"
            }
        });

        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = text.getText();
                text.setText(currentText + "2"); // Append "2"
            }
        });

        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = text.getText();
                text.setText(currentText + "0"); // Append "0"
            }
        });

        three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = text.getText();
                text.setText(currentText + "3"); // Append "3"
            }
        });

        four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = text.getText();
                text.setText(currentText + "4"); // Append "4"
            }
        });

        five.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = text.getText();
                text.setText(currentText + "5"); // Append "5"
            }
        });

        six.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = text.getText();
                text.setText(currentText + "6"); // Append "6"
            }
        });

        seven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = text.getText();
                text.setText(currentText + "7"); // Append "7"
            }
        });

        eight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = text.getText();
                text.setText(currentText + "8"); // Append "8"
            }
        });

        nine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = text.getText();
                text.setText(currentText + "9"); // Append "9"
            }
        });

        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String expression = text.getText();
                    // Evaluate the expression
                    int result = evaluateExpression(expression);
                    // Set the result in the text field
                    text.setText(String.valueOf(result));
                } catch (Exception ex) {
                    text.setText("Error");
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
            }
        });

    }

    // Method to evaluate addition and subtraction expressions
    private static int evaluateExpression(String expression) {
        //https://introcs.cs.princeton.edu/java/11precedence/
        int result = 0;
        String[] tokens = expression.split("(?=[+\\-x÷])|(?<=[+\\-x÷])"); // Split at operators while keeping them

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i].trim();

            if(token.equals("+")){
                continue;
            }else if (token.equals("-")){
                result -= Integer.parseInt(tokens[++i].trim());
            } else {
                // Add the first number or any number after '+'
                result += Integer.parseInt(token);
            }

        }
        return result;
    }
}
