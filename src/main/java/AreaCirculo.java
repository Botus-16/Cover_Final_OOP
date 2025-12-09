import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class AreaCirculo extends JFrame {
    private JTextArea resultadosTextArea;
    private JPanel panelPrincipal;
    private JTextField radioTextField;
    public AreaCirculo() {
        this.pack();
        setContentPane(panelPrincipal);
        setTitle("Cálculo del Área de un Círculo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultadosTextArea.setText("Ingrese el valor del radio (r) del círculo. \nPresione ENTER para calcular el área (A = πr²).");
        resultadosTextArea.setEditable(false);
        radioTextField.setText("1.0");
        radioTextField.addKeyListener(new EnterKeyListener());
        setVisible(true);
    }
    private class EnterKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                ejecutarCalculoArea();
            }
        }
        @Override public void keyTyped(KeyEvent e) {}
        @Override public void keyReleased(KeyEvent e) {}
    }
    private void ejecutarCalculoArea() {
        try {
            String textoRadio = radioTextField.getText();

            if (textoRadio.trim().isEmpty()) {
                resultadosTextArea.setText("Error: Ingrese un valor para el radio.");
                radioTextField.requestFocusInWindow();
                return;
            }
            double radio = Double.parseDouble(textoRadio);
            if (radio <= 0) {
                throw new IllegalArgumentException("El radio debe ser un valor positivo.");
            }
            Workshop miWorkshop = new Workshop();
            double area = miWorkshop.areaCirculo(radio);
            resultadosTextArea.setText(
                    "Radio (r): " + radio +
                            "\nÁrea (A = πr²): " + String.format("%.4f", area) + " unidades cuadradas." // Formatear a 4 decimales
            );
        } catch (NumberFormatException ex) {
            resultadosTextArea.setText("ERROR: Ingrese solo números válidos (puede usar decimales).");
            radioTextField.setText("");
            radioTextField.requestFocusInWindow();
        } catch (IllegalArgumentException ex) {
            resultadosTextArea.setText("ERROR: " + ex.getMessage());
            radioTextField.requestFocusInWindow();
        } catch (Exception ex) {
            resultadosTextArea.setText("ERROR inesperado: " + ex.getMessage());
            radioTextField.requestFocusInWindow();
        }
    }
}