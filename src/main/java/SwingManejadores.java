import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingManejadores extends JFrame implements ActionListener {
    JTextField xField, yField, resultField; // Campos de texto para ingresar los valores de X,Y para mostrar el resultado

    public SwingManejadores() {
        super("SwingManejadores"); // Título de la ventana

        // Crear un panel para contener los campos de texto y sus etiquetas
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("X:")); // Etiqueta para el campo X
        xField = new JTextField(5); // Campo de texto para ingresar el valor de X
        inputPanel.add(xField);
        inputPanel.add(new JLabel("Y:")); // Etiqueta para el campo Y
        yField = new JTextField(5); // Campo de texto para ingresar el valor de Y
        inputPanel.add(yField);
        inputPanel.add(new JLabel("RESULTADO:")); // Etiqueta para el campo RESULTADO
        resultField = new JTextField(5);
        resultField.setEditable(false); // Establecer el campo RESULTADO como no editable
        inputPanel.add(resultField);
        add(inputPanel, BorderLayout.NORTH); // Agregar el panel de entrada a la ventana

        // Crear un panel para contener los botones de operaciones
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("+"); // Botón para sumar X e Y
        addButton.addActionListener(this); // Agregar un escucha de eventos al botón
        buttonPanel.add(addButton);
        JButton subtractButton = new JButton("-"); // Botón para restar Y a X
        subtractButton.addActionListener(this); // Agregar un escucha de eventos al botón
        buttonPanel.add(subtractButton);
        JButton multiplyButton = new JButton("*"); // Botón para multiplicar X por Y
        multiplyButton.addActionListener(this); // Agregar un escucha de eventos al botón
        buttonPanel.add(multiplyButton);
        JButton divideButton = new JButton("/"); // Botón para dividir X entre Y
        divideButton.addActionListener(this); // Agregar un escucha de eventos al botón
        buttonPanel.add(divideButton);

        JButton sqrtXButton = new JButton("Raiz X"); // Botón para calcular la raíz cuadrada de X
        sqrtXButton.addActionListener(this); // Agregar un escucha de eventos al botón
        buttonPanel.add(sqrtXButton);
        JButton sqrtYButton = new JButton("Raiz Y"); // Botón para calcular la raíz cuadrada de Y
        sqrtYButton.addActionListener(this); // Agregar un escucha de eventos al botón
        buttonPanel.add(sqrtYButton);
        JButton xPowYButton = new JButton("X^Y"); // Botón para elevar X a la potencia de Y
        xPowYButton.addActionListener(this); // Agregar un escucha de eventos al botón
        buttonPanel.add(xPowYButton);
        JButton yPowXButton = new JButton("Y^X"); // Botón para elevar Y a la potencia de X
        yPowXButton.addActionListener(this); // Agregar un escucha de eventos al botón
        buttonPanel.add(yPowXButton);
        JButton xModYButton = new JButton("X mod Y"); // Botón para calcular el módulo de X dividido por Y
        xModYButton.addActionListener(this); // Agregar un escucha de eventos al botón
        buttonPanel.add(xModYButton);

        add(buttonPanel, BorderLayout.CENTER); // Agregar el panel de botones a la ventana

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        double x = Double.parseDouble(xField.getText());
        double y = Double.parseDouble(yField.getText());
        double result = switch (command) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> x / y;
            case "Raiz X" -> Math.sqrt(x);
            case "Raiz Y" -> Math.sqrt(y);
            case "X^Y" -> Math.pow(x, y);
            case "Y^X" -> Math.pow(y, x);
            case "X mod Y" -> x % y;
            default -> 0;
        };

        resultField.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        // Crear una instancia de la aplicación SwingManejadores
        SwingUtilities.invokeLater(SwingManejadores::new);
    }
}
