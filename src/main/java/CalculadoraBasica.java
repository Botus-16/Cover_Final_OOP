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
        setTitle("Calculadora Básica - Llamada por operacionesMatematicas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panelPrincipal);
        input1.setText("0");
        input2.setText("0");
        digiteLosNumerosATextArea.setText("Digite los números y presione ENTER en el segundo campo.");
        digiteLosNumerosATextArea.setEditable(false);
        input2.addKeyListener(new EnterKeyListener());
        this.pack();
        setVisible(true);
    }
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
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
            if (texto1.trim().isEmpty()) texto1 = "0";
            if (texto2.trim().isEmpty()) texto2 = "0";
            Workshop workshop = new Workshop();
            int num1 = Integer.parseInt(texto1);
            int num2 = Integer.parseInt(texto2);
            double resultado = workshop.sumarDosNumeros(num1, num2);
            digiteLosNumerosATextArea.setText("Suma de: " + num1 + " + " + num2 + "\nResultado: " + resultado);
        } catch (NumberFormatException ex) {
            digiteLosNumerosATextArea.setText("Error: Ingrese solo valores enteros.");
            input1.setText("");
            input2.setText("");
            input1.requestFocusInWindow();
        }
    }
}