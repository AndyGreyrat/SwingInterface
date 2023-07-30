import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Clase SwingCalculadora que Usa herencia de la clase de Swing JFrame e implementa ActionListener
public class SwingCalculadora extends JFrame implements ActionListener {
    // variables para los componentes de la calculadora
    private final JTextField display;
    private double result = 0;
    private String operator = "=";
    private boolean calculating = true;

    // Constructor
    public SwingCalculadora() {
        // Establecer título y tamaño del marco
        setTitle("SwingCalculadora");
        setSize(300, 300);

        // Crear campo de texto de visualización
        display = new JTextField("0", 12);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // Crear panel para botones
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        // Agregar botones al panel
        String[] buttons = {"1", "2", "3", "/", "4", "5", "6", "*", "7", "8", "9", "-", "0", ".", "=", "+"};
        for (String button : buttons) {
            addButton(panel, button);
        }

        // Agregar panel al marco
        add(panel, BorderLayout.CENTER);

        // Agregar botones adicionales
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 2));
        addButton(panel2, "C");
        addButton(panel2, "CE");
        add(panel2, BorderLayout.SOUTH);
    }

    // Método para agregar un botón al panel
    private void addButton(Container c, String text) {
        JButton button = new JButton(text);
        button.addActionListener(this);
        c.add(button);
    }

    // Método para manejar eventos de acción
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("C")) {
            result = 0;
            operator = "=";
            calculating = true;
            display.setText("0");
            return;
        }

        if (command.equals("CE")) {
            display.setText("0");
            return;
        }

        if ("0123456789.".contains(command)) {
            if (calculating) {
                display.setText(command);
                calculating = false;
            } else {
                if (command.equals(".") && display.getText().contains(".")) {
                    return;
                }
                display.setText(display.getText() + command);
            }
            return;
        }

        if (!calculating) {
            double x = Double.parseDouble(display.getText());
            calculate(x);
            calculating = true;
        }

        operator = command;
    }

    // Método para realizar cálculos
    private void calculate(double n) {
        switch (operator) {
            case "+" -> result += n;
            case "-" -> result -= n;
            case "*" -> result *= n;
            case "/" -> result /= n;
            case "=" -> result = n;
        }

        display.setText("" + result);
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SwingCalculadora calc = new SwingCalculadora();
                calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                calc.setVisible(true);
            }
        });
    }
}
