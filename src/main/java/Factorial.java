import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class Factorial extends JFrame {
    private JTextArea resultados;
    private JPanel panel1;
    private JTextField input;
    public Factorial() {
        setContentPane(panel1);
        setTitle("Cálculo de Factorial (N!)");
        this.pack();
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultados.setText("Ingrese un número entero no negativo (N) para calcular N! \nPresione ENTER para calcular.");
        resultados.setEditable(false);
        input.setText("0"); // Valor por defecto
        input.addKeyListener(new EnterKeyListener());
        setVisible(true);
    }
    private class EnterKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                calcularFactorial();
            }
        }
        @Override public void keyTyped(KeyEvent e) {}
        @Override public void keyReleased(KeyEvent e) {}
    }
    private void calcularFactorial() {
        try {
            String textoInput = input.getText();
            if (textoInput.trim().isEmpty()) {
                resultados.setText("Error: Ingrese un número.");
                input.requestFocusInWindow();
                return;
            }
            int n = Integer.parseInt(textoInput);
            Workshop miWorkshop = new Workshop();
            int resultado = miWorkshop.factorial(n);
            if (resultado < 0) {
                resultados.setText("El factorial de " + n + " (N!) es demasiado grande");
            } else {
                resultados.setText("El factorial de " + n + " (N!) es:\n" + resultado);
            }
        } catch (NumberFormatException ex) {
            resultados.setText("ERROR: Ingrese solo números enteros válidos.");
            input.setText("");
            input.requestFocusInWindow();
        } catch (IllegalArgumentException ex) {
            resultados.setText("ERROR: " + ex.getMessage());
            input.setText("");
            input.requestFocusInWindow();
        }
    }
}
