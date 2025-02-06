import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public  class Main{
    static JFrame f = new JFrame("Calculator!");

    static double num1 = 0;
    static double num2 = 0;
    static double result = 0;
    static char operator;
    static double squrtres;
    static JTextField text = new JTextField();

    static String line = "";

    static JButton one = new JButton("1");
    static JButton two = new JButton("2");
    static JButton three = new JButton("3");
    static JButton four = new JButton("4");
    static JButton five = new JButton("5");
    static JButton six = new JButton("6");
    static JButton seven = new JButton("7");
    static JButton eight = new JButton("8");
    static JButton nine = new JButton("9");
    static JButton zero = new JButton("0");
    static JButton clear = new JButton("C");
    static JButton minus = new JButton("-");
    static JButton mult = new JButton("x");
    static JButton div = new JButton("÷");
    static JButton plus = new JButton("+");
    static JButton equal = new JButton("=");
    static JButton squrt = new JButton("√");

    public static void main(String[] args) {


        num1 = 0;
        num2 = 0;
        result = 0;

        text = new JTextField();
        text.setBounds(40, 40, 261, 30); //textfield

        equal.setBounds(180, 240, 50, 30);
        plus.setBounds(250, 90, 50, 30);
        zero.setBounds(110, 240, 50, 30);
        one.setBounds(40, 90, 50, 30);
        two.setBounds(110, 90, 50, 30);
        three.setBounds(180, 90, 50, 30);
        four.setBounds(40, 140, 50, 30);
        five.setBounds(110, 140, 50, 30);
        six.setBounds(180, 140, 50, 30);
        seven.setBounds(40, 190, 50, 30);
        eight.setBounds(110, 190, 50, 30);
        nine.setBounds(180, 190, 50, 30);
        clear.setBounds(40, 240, 50, 30);
        minus.setBounds(250, 140, 50, 30);
        mult.setBounds(250, 190, 50, 30);
        div.setBounds(250, 240, 50, 30);
        squrt.setBounds(40, 290, 50, 30);

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
        f.add(squrt);
        f.setResizable(false);

        f.setSize(350, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Add ActionListeners for the number buttons
        // All ActionListeners have lambda expressions added "->"
        f.requestFocus();
        handleActionListners();
        handleKeyBinds();
        handleKeyBindsOp();
        handleKeyBindsOp();


    }
    static void handleActionListners(){
        one.addActionListener( _ -> {
            handleNumber("1");
        });

        plus.addActionListener(_ -> {
            handleOperator('+');
        });

        minus.addActionListener(_ -> {
            handleOperator('-');
        });

        div.addActionListener(_ -> {
            handleOperator('/');
        });

        mult.addActionListener(_ -> {
            handleOperator('*');
        });

        // Add ActionListeners for other number buttons
        two.addActionListener(_ -> {
            handleNumber("2");
        });

        zero.addActionListener(_ -> {
            handleNumber("0");
        });

        three.addActionListener(_ -> {
            handleNumber("3");
        });

        four.addActionListener(_ -> {
            handleNumber("4");
        });

        five.addActionListener(_ -> {
            handleNumber("5");
        });

        six.addActionListener(_ -> {
            handleNumber("6");
        });

        seven.addActionListener(_ -> {
            handleNumber("7");
        });

        eight.addActionListener(_ -> {
            handleNumber("8");
        });

        nine.addActionListener(_ -> {
            handleNumber("9");
        });

        clear.addActionListener(_ -> {
            text.setText("");
            line = "";
        });
        equal.addActionListener(_ -> {
            handleEqual();
        });

        squrt.addActionListener(_ ->{
            String currentText = text.getText();
                text.setText(String.valueOf(Math.sqrt(Double.parseDouble(currentText))));
                squrtres = Math.sqrt(Double.parseDouble(currentText));
                try {
                    FileWriter myWriter = new FileWriter("C:\\Users\\alexs\\OneDrive\\Desktop\\history.txt", true);
                    myWriter.append("squrt(").append(currentText).append(")").append(" = ");
                    myWriter.append(String.valueOf(squrtres)).append("\n");
                    myWriter.close();
                    System.out.println("File updated.");
                } catch (IOException exception) {
                    System.out.println("Error!");
                    exception.printStackTrace();
                }


        });

    }
    static void handleKeyBinds(){
        f.requestFocus();

        equal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke((char) KeyEvent.VK_EQUALS), "Equal");
        equal.getActionMap().put("Equal", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleEqual();
            }
        });

        equal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "pressButton");
        equal.getActionMap().put("pressButton", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleEqual();
            }
        });

        one.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke((char) KeyEvent.VK_1 ), "One");
        one.getActionMap().put("One", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleNumber("1");
            }
        });

        two.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke((char) KeyEvent.VK_2 ), "Two");
        two.getActionMap().put("Two", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleNumber("2");
            }
        });

        three.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke((char) KeyEvent.VK_3 ), "Three");
        three.getActionMap().put("Three", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleNumber("3");
            }
        });

        four.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke((char) KeyEvent.VK_4 ), "Four");
        four.getActionMap().put("Four", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleNumber("4");
            }
        });

        five.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke((char) KeyEvent.VK_5 ), "Five");
        five.getActionMap().put("Five", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleNumber("5");
            }
        });

        six.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke((char) KeyEvent.VK_6 ), "Six");
        six.getActionMap().put("Six", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleNumber("6");
            }
        });

        seven.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke((char) KeyEvent.VK_7 ), "Seven");
        seven.getActionMap().put("Seven", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleNumber("7");
            }
        });

        eight.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke((char) KeyEvent.VK_8 ), "Eight");
        eight.getActionMap().put("Eight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleNumber("8");
            }
        });

        nine.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke((char) KeyEvent.VK_9 ), "Nine");
        nine.getActionMap().put("Nine", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleNumber("9");
            }
        });

        zero.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke((char) KeyEvent.VK_0 ), "Zero");
        zero.getActionMap().put("Zero", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleNumber("0");
            }
        });


    }

    static void handleKeyBindsOp(){

        f.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                System.out.println("Key Pressed: " + evt.getKeyCode());
            }
        });


        f.requestFocus();

        plus.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("shift EQUALS"), "PLUS");
        plus.getActionMap().put("PlUS", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleOperator('+');
            }
        });



        plus.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(107, 0), "PLUS");  // 107 is VK_ADD
        plus.getActionMap().put("PLUS", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleOperator('+');
            }
        });

        minus.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke((char) KeyEvent.VK_MINUS), "MINUS");
        minus.getActionMap().put("MINUS", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleOperator('-');
            }
        });

        div.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(111, 0), "DIVIDE");
        div.getActionMap().put("DIVIDE", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleOperator('/');
            }
        });

        mult.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(106, 0), "MULTIPLY");
        mult.getActionMap().put("MULTIPLY", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleOperator('*');
            }
        });
    }

    static void handleNumber(String number) {
        String currentText = text.getText();
        text.setText(currentText + number);
        line += number;
    }

    static void handleOperator(char op) {
        String currentText = text.getText();
        num1 = Double.parseDouble(currentText);
        operator = op;
        text.setText("");
        line += " " + op + " ";

    }

    static void handleEqual() {
        num2 = Double.parseDouble(text.getText());
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
            FileWriter myWriter = new FileWriter("C:\\Users\\alexs\\OneDrive\\Desktop\\history.txt", true);
            myWriter.append(line).append(" = ").append(String.valueOf(result)).append("\n");
            myWriter.close();
            System.out.println("File updated.");
        } catch (IOException exception) {
            System.out.println("Error!");
            exception.printStackTrace();
        }



        text.setText(line = String.valueOf(result)); // Show result

    }
    
}
