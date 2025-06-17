import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.lang.Math;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class FinalLabProject {

    // Custom Colors yippee!!
    Color customBlack = new Color(41,41,14);
    Color customGrey = new Color(87, 94, 102);
    Color customWhite = new Color(178, 189, 194);
    Color customRed = new Color(230,0,40);
    Color customLightRed = new Color(255, 97, 97);

    // Strings for Button Values
     String[] buttonValues = {
        "+/-", "^", "%", "÷", "AC",
        "7", "8", "9", "×", "C",
        "4", "5", "6", "-", "Del",
        "1", "2", "3", "+", "?",
        ".", "0", "√", "="
    };

    // String arrays for Identification
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"+/-", "^", "%"};
    String[] rightmostSymbols = {"AC", "C", "Del", "?"};

    JFrame frame = new JFrame("Calculator");
    JLabel displayJLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    //A+B, A-B, A*B, A/B...
    String A = "0";
    String operator = null;
    String B = null; 

    FinalLabProject() {

        // Frame
        frame.setSize(480, 720);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        // Calculator Label
        displayJLabel.setBackground(customBlack);
        displayJLabel.setForeground(Color.white);
        displayJLabel.setFont(new Font("Arial", Font.PLAIN,100));
        displayJLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayJLabel.setText("0");
        displayJLabel.setOpaque(true);

        // Calculator Display
        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayJLabel);
        frame.add(displayJLabel, BorderLayout.NORTH);

        // Button Panel
        buttonPanel.setLayout(new GridLayout(5, 5));
        buttonPanel.setBackground(customBlack);
        frame.add(buttonPanel);

        // Labeling Buttons accordingly
        for (int i = 0; i < buttonValues.length; i++) {
            JButton button = new JButton();
            String buttonValue = buttonValues[i];
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setText(buttonValue);
            button.setFocusable(false);
            button.setBorder(new LineBorder(customBlack));

            if (Arrays.asList(topSymbols).contains(buttonValue)) {
                    button.setBackground(customWhite);
                    button.setForeground(customBlack);
            } else if (Arrays.asList(rightSymbols).contains(buttonValue)) {
                    button.setBackground(customLightRed);
                    button.setForeground(customBlack);
            } else if (Arrays.asList(rightmostSymbols).contains(buttonValue)){
                button.setBackground(customRed);
                button.setForeground(Color.white);
            } else {
                button.setBackground(customGrey);
                button.setForeground(Color.white);
            }
            buttonPanel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    String buttonValue = button.getText();

                    if (Arrays.asList(rightSymbols).contains(buttonValue)) {
                        if (buttonValue == "=") {
                            if (A != null) {
                                B = displayJLabel.getText();
                                double numA = Double.parseDouble(A);
                                double numB = Double.parseDouble(B);

                                switch (operator) {
                                    case "+":
                                        displayJLabel.setText(removeZeroDecimal(numA+numB));
                                        break;
                                    case "-":
                                        displayJLabel.setText(removeZeroDecimal(numA-numB));
                                        break;
                                    case "×":
                                        displayJLabel.setText(removeZeroDecimal(numA*numB));
                                        break;
                                    case "÷":
                                        displayJLabel.setText(removeZeroDecimal(numA/numB));
                                        break;
                                }
                                clearAll();
                            }
                        }
                        else if ("+-×÷".contains(buttonValue)) {
                            if (operator == null) {
                                A = displayJLabel.getText();
                                displayJLabel.setText("0");
                                B = "0";
                            }
                            operator = buttonValue;
                        }
                    }
                    else if (Arrays.asList(topSymbols).contains(buttonValue)) {
                        double numDisplay = Double.parseDouble(displayJLabel.getText());
                        switch (buttonValue) {
                            case "+/-":
                                numDisplay *= -1;
                                break;
                            case "%":
                                numDisplay /= 100;
                                break;
                            case "^":
                                if (operator != null && A != null) {
                                    double base = Double.parseDouble(A);
                                    double exp = Double.parseDouble(displayJLabel.getText());
                                    numDisplay = Math.pow(base, exp);
                                } else {
                                    return;
                                }
                                break;
                    }
                    displayJLabel.setText(removeZeroDecimal(numDisplay));
                }
                    else if (Arrays.asList(rightmostSymbols).contains(buttonValue)) {
                        if (buttonValue == "AC") {
                            clearAll();
                            displayJLabel.setText("0");
                        }
                        if (buttonValue == "C") {
                            displayJLabel.setText("0");
                        }
                        if (buttonValue == "Del") {
                            String textLength = displayJLabel.getText();
                            if (textLength.length() > 1) {
                                displayJLabel.setText(textLength.substring(0, textLength.length() - 1));
                            } else {
                                displayJLabel.setText("0");
                            }
                        }
                        if (buttonValue == "?") {
                            System.out.println("My purpose is to fix the button layout...");
                        }
                    }
                    else { // Digits, Square Root, or Decimal Point
                        if (buttonValue == ".") {
                            if(!displayJLabel.getText().contains(buttonValue)) {
                                displayJLabel.setText(displayJLabel.getText() + buttonValue);
                            }
                        }
                        else if (buttonValue == "√") {
                            double numDisplay = Double.parseDouble(displayJLabel.getText());
                            numDisplay = Math.sqrt(numDisplay);
                            displayJLabel.setText(removeZeroDecimal(numDisplay));
                        }
                        else if ("0123456789".contains(buttonValue)) {
                            if (displayJLabel.getText() == "0") {
                                displayJLabel.setText(buttonValue);
                            }
                            else {
                                displayJLabel.setText(displayJLabel.getText() + buttonValue);;
                            }
                        }
                    }
                }
            });
        }
        frame.setVisible(true);
    }

    // For clearing
    void clearAll() {
        A = "0";
        operator = null;
        B = null;
    }
    // Removes decimals if the output is a whole number
    String removeZeroDecimal(double numDisplay) {
        if (numDisplay % 1 == 0) {
            return Integer.toString((int) numDisplay); 
        }
        return Double.toString(numDisplay);
    }

    public static void main(String[] args) {
        new FinalLabProject();
    }
}
