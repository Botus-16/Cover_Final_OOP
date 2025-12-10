import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.stream.Stream;

public class ManipulacionArreglos extends JPanel {
    private JTextArea arregloOriginalTextArea;
    private JPanel panelPrincipal;
    private JTextArea arregloResultadoTextArea;
    private JButton ordenarAscButton;
    private JButton invertirButton;
    private JButton eliminarDuplicadosButton;
    private JButton rotarButton;
    private JTextField digitarArregloTextField;
    private JTextField busquedaTextField;
    private JButton buscarMayorButton;
    private JButton promediarButton;
    private JButton buscarMenorButton;
    private JButton sumarButton;

    public ManipulacionArreglos() {
        arregloOriginalTextArea.setText("Digite el conjunto de valores separados por comas");
        ordenarAscButton.addActionListener(e -> ejecutarOperacion("ordenar", false));
        invertirButton.addActionListener(e -> ejecutarOperacion("invertir", false));
        eliminarDuplicadosButton.addActionListener(e -> ejecutarOperacion("duplicados", false));
        rotarButton.addActionListener(e -> ejecutarOperacion("rotar", false));
        sumarButton.addActionListener(e -> ejecutarOperacion("sumar", true));
        promediarButton.addActionListener(e -> ejecutarOperacion("promediar", true));
        buscarMayorButton.addActionListener(e -> ejecutarOperacion("mayor", true));
        buscarMenorButton.addActionListener(e -> ejecutarOperacion("menor", true));
        busquedaTextField.addKeyListener(new BusquedaKeyListener());
        digitarArregloTextField.addKeyListener(new ReemplazoKeyListener());
    }
    private class BusquedaKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                ejecutarOperacion("buscar", true);
            }
        }
        @Override public void keyTyped(KeyEvent e) {}
        @Override public void keyReleased(KeyEvent e) {}
    }
    private class ReemplazoKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                reemplazarArregloPrincipal();
            }
        }
        @Override public void keyTyped(KeyEvent e) {}
        @Override public void keyReleased(KeyEvent e) {}
    }
    private void reemplazarArregloPrincipal() {
        String nuevoArregloTexto = digitarArregloTextField.getText();
        arregloOriginalTextArea.setText(nuevoArregloTexto);
        arregloResultadoTextArea.setText("Arreglo principal actualizado:\n" + nuevoArregloTexto);
        digitarArregloTextField.setText("");
        arregloOriginalTextArea.requestFocusInWindow();
    }
    private int[] parseArrayInput(String input) throws NumberFormatException {
        String cleanInput = input.replaceAll("[\\s,;]+", " ").trim();
        if (cleanInput.isEmpty()) {
            return new int[0];
        }
        return Stream.of(cleanInput.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    private void ejecutarOperacion(String operacion, boolean esResultadoUnico) {
        try {
            int[] arregloOriginal = parseArrayInput(arregloOriginalTextArea.getText());
            Workshop workshop = new Workshop();
            Object resultado = null;
            if (arregloOriginal.length == 0 && !operacion.equals("rotar")) {
                arregloResultadoTextArea.setText("Error: El arreglo de entrada está vacío.");
                return;
            }
            switch (operacion) {
                case "ordenar":
                    resultado = workshop.ordenarArreglo(arregloOriginal);
                    break;
                case "invertir":
                    resultado = workshop.invertirArreglo(arregloOriginal);
                    break;
                case "duplicados":
                    resultado = workshop.eliminarDuplicados(arregloOriginal);
                    break;
                case "rotar":
                    String textoPosiciones = busquedaTextField.getText();
                    if (textoPosiciones.trim().isEmpty()) {
                        throw new IllegalArgumentException("Debe ingresar el número de posiciones de rotación en el campo de búsqueda.");
                    }
                    int posiciones = Integer.parseInt(textoPosiciones);
                    resultado = workshop.rotarArreglo(arregloOriginal, posiciones);
                    break;
                case "sumar":
                    resultado = workshop.sumaElementos(arregloOriginal);
                    break;
                case "promediar":
                    resultado = workshop.promedioElementos(arregloOriginal);
                    break;
                case "mayor":
                    resultado = workshop.encontrarElementoMayor(arregloOriginal);
                    break;
                case "menor":
                    resultado = workshop.encontrarElementoMenor(arregloOriginal);
                    break;
                case "buscar":
                    String textoBusqueda = busquedaTextField.getText();
                    if (textoBusqueda.trim().isEmpty()) {
                        throw new IllegalArgumentException("Debe ingresar un valor para buscar.");
                    }
                    int valorBuscado = Integer.parseInt(textoBusqueda);
                    boolean encontrado = workshop.buscarElemento(arregloOriginal, valorBuscado);
                    if (!encontrado) {
                        resultado = "El valor " + valorBuscado + " NO se encontró en el arreglo.";
                    } else {
                        resultado = "El valor " + valorBuscado + " SÍ se encontró en el arreglo.";
                    }
                    break;
                default:
                    resultado = "Operación no implementada.";
            }
            if (resultado == null) {
                arregloResultadoTextArea.setText("ERROR INTERNO: Resultado de operación nulo.");
                return;
            }
            if (esResultadoUnico) {
                if (operacion.equals("buscar")) {
                    arregloResultadoTextArea.setText(resultado.toString());
                } else {
                    arregloResultadoTextArea.setText("Resultado de " + operacion + ":\n" + resultado.toString());
                }
            } else {
                arregloResultadoTextArea.setText("Arreglo " + operacion + ":\n" + Arrays.toString((int[]) resultado));
            }
        } catch (NumberFormatException ex) {
            arregloResultadoTextArea.setText("ERROR: La entrada no es un número válido (Revisa el arreglo o el campo de rotación/búsqueda).");
        } catch (Exception ex) {
            arregloResultadoTextArea.setText("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}