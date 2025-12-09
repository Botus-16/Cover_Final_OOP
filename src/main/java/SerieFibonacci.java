import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import java.util.Arrays;

public class SerieFibonacci extends JFrame {
    private JTextArea resultadosTextArea;
    private JPanel panelPrincipal;
    private JTextField maximoTextField;
    public SerieFibonacci() {
        setContentPane(panelPrincipal);
        setTitle("Generador de Serie de Fibonacci");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultadosTextArea.setText("Ingrese el número de términos (N) que desea generar de la serie de Fibonacci.\nPresione ENTER para calcular.");
        resultadosTextArea.setEditable(false);
        maximoTextField.setText("10"); // Valor por defecto
        maximoTextField.addKeyListener(new EnterKeyListener());
        this.pack();
        setVisible(true);
    }
    private class EnterKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                ejecutarGeneracionFibonacci();
            }
        }
        @Override public void keyTyped(KeyEvent e) {}
        @Override public void keyReleased(KeyEvent e) {}
    }

    private void ejecutarGeneracionFibonacci() {
        try {
            String textoMaximo = maximoTextField.getText();
            if (textoMaximo.trim().isEmpty()) {
                resultadosTextArea.setText("Error: Ingrese un valor para el número de términos.");
                maximoTextField.requestFocusInWindow();
                return;
            }
            int nTerminos = Integer.parseInt(textoMaximo);
            if (nTerminos < 0) {
                throw new IllegalArgumentException("El número de términos (N) debe ser no negativo.");
            }
            Workshop miWorkshop = new Workshop();
                    String serieResultado = Arrays.toString(miWorkshop.serieFibonacci(nTerminos));
            resultadosTextArea.setText(
                    "Serie de Fibonacci hasta " + nTerminos + " términos:\n" +
                            serieResultado
            );
        } catch (NumberFormatException ex) {
            resultadosTextArea.setText("ERROR: Ingrese solo números enteros válidos.");
            maximoTextField.setText("");
            maximoTextField.requestFocusInWindow();
        } catch (IllegalArgumentException ex) {
            resultadosTextArea.setText("ERROR: " + ex.getMessage());
            maximoTextField.requestFocusInWindow();
        } catch (Exception ex) {
            resultadosTextArea.setText("ERROR inesperado: " + ex.getMessage());
            maximoTextField.requestFocusInWindow();
        }
    }
}