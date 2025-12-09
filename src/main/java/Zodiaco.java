import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class Zodiaco extends JFrame {
    private JTextArea resultadoTextArea;
    private JPanel panelPrincipal;
    private JTextField inputDia;
    private JTextField inputMes;
    public Zodiaco() {
        setContentPane(panelPrincipal);
        setTitle("Calculador de Signo Zodiacal");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultadoTextArea.setText("Ingrese su día y mes de nacimiento. \nPresione ENTER en el campo del mes.");
        resultadoTextArea.setEditable(false);
        inputDia.setText("1");
        inputMes.setText("1");
        inputMes.addKeyListener(new EnterKeyListener());
        setVisible(true);
    }
    private class EnterKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                ejecutarCalculoZodiacal();
            }
        }
        @Override public void keyTyped(KeyEvent e) {}
        @Override public void keyReleased(KeyEvent e) {}
    }
    private void ejecutarCalculoZodiacal() {
        try {
            String textoDia = inputDia.getText();
            String textoMes = inputMes.getText();
            int dia = Integer.parseInt(textoDia);
            int mes = Integer.parseInt(textoMes);
            if (mes < 1 || mes > 12 || dia < 1 || dia > 31) {
                throw new IllegalArgumentException("Día o Mes fuera de rango válido (1-31, 1-12).");
            }
            Workshop miWorkshop = new Workshop();
            String signo = miWorkshop.zoodiac(dia, mes);
            resultadoTextArea.setText("Fecha: " + dia + "/" + mes + "\nSu signo zodiacal es: " + signo + " 🌟");
        } catch (NumberFormatException ex) {
            resultadoTextArea.setText("ERROR: Ingrese solo números enteros para el día y el mes.");
            inputDia.setText("");
            inputMes.setText("");
            inputDia.requestFocusInWindow();
        } catch (IllegalArgumentException ex) {
            resultadoTextArea.setText("ERROR: " + ex.getMessage());
            inputDia.requestFocusInWindow();
        } catch (Exception ex) {
            resultadoTextArea.setText("⚠️ ERROR inesperado: " + ex.getMessage());
            inputDia.requestFocusInWindow();
        }
    }
}