import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Conversiones extends JPanel {
    private JTextArea traduccionDecimalTextArea;
    private JPanel panelPrincipal;
    private JTextArea traduccionHexacimalTextArea;
    private JButton aBinarioButton;
    private JButton aHexadecimalButton;
    private JTextField input;

    public Conversiones() {
        traduccionDecimalTextArea.setEditable(false);
        traduccionHexacimalTextArea.setEditable(false);
        input.setText("10");
        aBinarioButton.addActionListener(e -> ejecutarOperacion("binario"));
        aHexadecimalButton.addActionListener(e -> ejecutarOperacion("hexadecimal"));
        input.addKeyListener(new ConversionKeyListener());
    }
    private class ConversionKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                ejecutarOperacion("binario");
            }
        }
        @Override public void keyTyped(KeyEvent e) {}
        @Override public void keyReleased(KeyEvent e) {}
    }
    private void ejecutarOperacion(String operacion) {
        try {
            String textoInput = input.getText().trim();
            if (textoInput.isEmpty()) {
                throw new IllegalArgumentException("Debe ingresar un número entero para realizar la conversión.");
            }
            int numero = Integer.parseInt(textoInput);
            Workshop workshop = new Workshop();
            switch (operacion) {
                case "binario":
                    String binario = workshop.convertirABinario(numero);
                    traduccionDecimalTextArea.setText(
                            "BINARIO:\n" + binario
                    );
                    traduccionHexacimalTextArea.setText("");
                    break;
                case "hexadecimal":
                    String hexadecimal = workshop.convertirAHexadecimal(numero);
                    traduccionHexacimalTextArea.setText(
                            "HEXADECIMAL:\n" + hexadecimal.toUpperCase());
                    traduccionDecimalTextArea.setText("");
                    break;

                default:
                    traduccionDecimalTextArea.setText("Operación no implementada.");
            }
        }
            catch (Exception ex) {
            String errorMsg = "ERROR : \n Solo se aceptan valores enteros";
            traduccionDecimalTextArea.setText(errorMsg);
            traduccionHexacimalTextArea.setText(errorMsg);
        }
    }
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}