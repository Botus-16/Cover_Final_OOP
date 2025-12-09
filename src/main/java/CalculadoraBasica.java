import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class CalculadoraBasica extends JFrame {

    private JTextArea digiteLosNumerosATextArea;
    private JTextField input1;
    private JTextField input2;
    private JPanel panelPrincipal;

    public CalculadoraBasica() {
        panelPrincipal = new JPanel(new FlowLayout());
        input1 = new JTextField(10);
        input2 = new JTextField(10);
        digiteLosNumerosATextArea = new JTextArea(2, 25);
        digiteLosNumerosATextArea.setText("Digite los números y presione ENTER en el segundo campo.");
        digiteLosNumerosATextArea.setEditable(false);

        // Montaje del JFrame
        setTitle("Calculadora Básica - Llamada por operacionesMatematicas");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelPrincipal.add(new JScrollPane(digiteLosNumerosATextArea));
        panelPrincipal.add(new JLabel("Número 1:"));
        panelPrincipal.add(input1);
        panelPrincipal.add(new JLabel("Número 2:"));
        panelPrincipal.add(input2);
        this.add(panelPrincipal);

        input2.addKeyListener(new EnterKeyListener());
        setVisible(true);
    }

    // ... (Clase EnterKeyListener omitida por brevedad, es la misma) ...
    private class EnterKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                ejecutarSuma();
            }
        }
        @Override public void keyTyped(KeyEvent e) {}
        @Override public void keyReleased(KeyEvent e) {}
    }


    private void ejecutarSuma() {
        try {
            String texto1 = input1.getText();
            String texto2 = input2.getText();
            Workshop workshop = new Workshop();
            int num1 = Integer.parseInt(texto1);
            int num2 = Integer.parseInt(texto2);
            double resultado = workshop.sumarDosNumeros(num1, num2);

            // Mostrar el resultado
            digiteLosNumerosATextArea.setText("Suma de: " + num1 + " + " + num2 + "\nResultado: " + resultado);

        } catch (NumberFormatException ex) {
            digiteLosNumerosATextArea.setText("Error: Ingrese números válidos.");
        }
    }

    // --- Ya no se necesita el método sumarDosNumeros aquí ---

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraBasica());
    }
}