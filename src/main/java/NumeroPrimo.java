import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class NumeroPrimo extends JFrame {
    private JTextArea resultados;
    private JPanel panel1;
    private JTextField input;
    public NumeroPrimo() {
        setContentPane(panel1);
        setTitle("Verificador de Números Primos");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultados.setText("Ingrese un número entero para verificar si es primo. \nPresione ENTER para verificar.");
        resultados.setEditable(false);
        input.setText("1");
        input.addKeyListener(new EnterKeyListener());
        this.pack();
        setVisible(true);
    }
    private class EnterKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                ejecutarEsPrimo();
            }
        }
        @Override public void keyTyped(KeyEvent e) {}
        @Override public void keyReleased(KeyEvent e) {}
    }
    private void ejecutarEsPrimo() {
        try {
            String textoInput = input.getText();
            if (textoInput.trim().isEmpty()) {
                resultados.setText("Error: Ingrese un número.");
                input.requestFocusInWindow();
                return;
            }
            int n = Integer.parseInt(textoInput);
            if (n <= 1) {
                resultados.setText("El número " + n + " no es primo por definición \n(debe ser mayor que 1).");
                return;
            }
            Workshop miWorkshop = new Workshop();
            boolean esPrimo = miWorkshop.esPrimo(n);
            String resultadoTexto = esPrimo ?
                    "El número " + n + " es un número PRIMO." :
                    "El número " + n + " NO es primo.";
            resultados.setText(resultadoTexto);
        } catch (NumberFormatException ex) {
            resultados.setText("ERROR: Ingrese solo números enteros válidos.");
            input.setText("");
            input.requestFocusInWindow();
        } catch (Exception ex) {
            resultados.setText("ERROR en la lógica: " + ex.getMessage());
            input.setText("");
            input.requestFocusInWindow();
        }
    }
}
