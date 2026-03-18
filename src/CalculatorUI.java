import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorUI extends JFrame implements ActionListener {

    JTextField display;

    public CalculatorUI() {
        setTitle("Calculator");
        setSize(300, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 18));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // Buttons panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
                "1", "2", "3", "+",
                "4", "5", "6", "-",
                "7", "8", "9", "*",
                "/", "0", "%", "=",
                "OFF"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 14));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    String num1 = "", num2 = "", operator = "";

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]")) {
            display.setText(display.getText() + cmd);
        }
        else if (cmd.matches("[+\\-*/%]")) {
            num1 = display.getText();
            operator = cmd;
            display.setText("");
        }
        else if (cmd.equals("=")) {
            num2 = display.getText();
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);
            double result = 0;

            switch (operator) {
                case "+": result = n1 + n2; break;
                case "-": result = n1 - n2; break;
                case "*": result = n1 * n2; break;
                case "/": result = n1 / n2; break;
                case "%": result = n1 % n2; break;
            }

            display.setText(String.valueOf(result));
        }
        else if (cmd.equals("OFF")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new CalculatorUI();
    }
}