import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingInterfaz extends JFrame implements ItemListener {
    JComboBox<String> colorChoice; // Lista desplegable para seleccionar el color
    Color selectedColor; // Color seleccionado
    JPanel colorPanel; // Panel para mostrar el color seleccionado

    public SwingInterfaz() {
        super("SwingInterfaz"); // Título de la ventana

        // Crear la lista desplegable con las opciones de colores
        colorChoice = new JComboBox<>(new String[] {"Rojo", "Verde", "Azul"});
        colorChoice.addItemListener(this); // Agregar un Listener de eventos para detectar cambios en la selección
        add(colorChoice, BorderLayout.NORTH); // Agregar la lista desplegable a la ventana

        // Crear el panel para mostrar el color seleccionado
        colorPanel = new JPanel();
        selectedColor = Color.red; // Establecer el color inicial en rojo
        colorPanel.setBackground(selectedColor); // Establecer el fondo del panel con el color seleccionado
        add(colorPanel, BorderLayout.CENTER); // Agregar el panel a la ventana

        setSize(200, 200); // Establecer el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establecer la operación de cierre de la ventana
        setVisible(true); // Mostrar la ventana
    }

    public void itemStateChanged(ItemEvent e) {
        String color = (String) colorChoice.getSelectedItem(); // Obtener el color seleccionado de la lista desplegable
        switch (color) {
            case "Rojo" ->  // Si se seleccionó "Rojo"
                    selectedColor = Color.red; // Establecer el color seleccionado en rojo
            case "Verde" ->  // Si se seleccionó "Verde"
                    selectedColor = Color.green; // Establecer el color seleccionado en verde
            case "Azul" ->  // Si se seleccionó "Azul"
                    selectedColor = Color.blue; // Establecer el color seleccionado en azul
        }
        colorPanel.setBackground(selectedColor); // Actualizar el fondo del panel con el nuevo color seleccionado
    }

    public static void main(String[] args) {
        new SwingInterfaz(); // Crear una instancia de la aplicación SwingInterfaz
    }
}

