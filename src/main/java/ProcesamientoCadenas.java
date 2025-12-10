import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ProcesamientoCadenas extends JPanel {
    private JTextArea inputCadena;             // Área de texto principal (cadena a operar)
    private JPanel panelPrincipal;
    private JButton mayusculasButton;
    private JButton minusculasButton;
    private JButton invertirButton;
    private JTextArea resultadosTextArea;
    private JButton caracteresButton;
    private JButton palabrasButton;
    private JButton reemplazarButton;
    private JTextField buscarReemplazarTextField;
    private JTextField validarCorreoTextField;
    private String subcadenaBuscadaParaReemplazo = null;
    Object resultado = null;
    public ProcesamientoCadenas() {
        inputCadena.setText("Digite un texto para iniciar el programa");
        buscarReemplazarTextField.setText("");
        mayusculasButton.addActionListener(e -> ejecutarOperacion("mayusculas", false));
        minusculasButton.addActionListener(e -> ejecutarOperacion("minusculas", false));
        invertirButton.addActionListener(e -> ejecutarOperacion("invertir", false));
        caracteresButton.addActionListener(e -> ejecutarOperacion("contar caracteres", true));
        palabrasButton.addActionListener(e -> ejecutarOperacion("contar palabras", true));
        reemplazarButton.addActionListener(e -> ejecutarOperacion("reemplazar", false));
        validarCorreoTextField.addKeyListener(new CorreoKeyListener());
        buscarReemplazarTextField.addKeyListener(new BusquedaKeyListener());
    }
    private class BusquedaKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                ejecutarOperacion("buscar", true);
            }
        }
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
    private class CorreoKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                ejecutarOperacion("validar correo", true);
            }
        }
        @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
    private void ejecutarOperacion(String operacion, boolean esResultadoUnico) {
        try {
            String cadenaOriginal = inputCadena.getText();
            Workshop workshop = new Workshop();
            switch (operacion) {
                case "mayusculas":
                    resultado = workshop.convertirAMayusculas(cadenaOriginal);
                    break;
                case "minusculas":
                    resultado = workshop.convertirAMinusculas(cadenaOriginal);
                    break;
                case "invertir":
                    resultado = workshop.invertirCadena(cadenaOriginal);
                    break;
                case "contar caracteres":
                    resultado = workshop.contarCaracteres(cadenaOriginal);
                    break;
                case "contar palabras":
                    resultado = workshop.contarPalabras(cadenaOriginal);
                    break;
                case "buscar":
                    String subcadenaABuscar = buscarReemplazarTextField.getText().trim();
                    if (subcadenaABuscar.isEmpty()) {
                        throw new IllegalArgumentException("Debe ingresar la subcadena a buscar primero.");
                    }
                    int posicion = workshop.buscarSubcadena(cadenaOriginal, subcadenaABuscar);
                    if (posicion == -1) {
                        subcadenaBuscadaParaReemplazo = null;
                        resultado = "La subcadena '" + subcadenaABuscar + "' NO se encontró. Intente de nuevo.";
                    } else {
                        subcadenaBuscadaParaReemplazo = subcadenaABuscar;
                        buscarReemplazarTextField.setText("");
                        resultado = "Subcadena almacenada ('" + subcadenaABuscar + "') en índice " + posicion + ".";
                    }
                    break;
                case "reemplazar":
                    if (subcadenaBuscadaParaReemplazo == null) {
                        throw new IllegalArgumentException("Primero debe encontrar una subcadena\n(presione ENTER en el campo).");
                    }
                    String subcadenaAReemplazar = subcadenaBuscadaParaReemplazo;
                    String reemplazoTexto = buscarReemplazarTextField.getText();
                    String cadenaNueva = workshop.reemplazarSubcadena(cadenaOriginal, subcadenaAReemplazar, reemplazoTexto);
                    inputCadena.setText(cadenaNueva);
                    subcadenaBuscadaParaReemplazo = null;
                    resultado = "Reemplazo exitoso:Se reemplazó '" + subcadenaAReemplazar + "' por '" + reemplazoTexto + "'.\n";
                    break;
                case "validar correo":
                    String correo = validarCorreoTextField.getText();
                    boolean esValido = workshop.validarCorreoElectronico(correo);
                    resultado = esValido ?
                            "El correo es VÁLIDO." :
                            "El correo es INVÁLIDO.";
            }
        }
        catch (Exception ex) {
            resultado = "ERROR: " + ex.getMessage();
        }
        finally {
            resultadosTextArea.setText("Resultado de " + operacion + ":\n" +resultado);
        }
    }
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}