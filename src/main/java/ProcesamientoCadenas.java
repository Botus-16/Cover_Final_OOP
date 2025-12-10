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

    public ProcesamientoCadenas() {
        inputCadena.setText("Ejemplo de Cadena de Texto.");
        resultadosTextArea.setEditable(false);
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
        @Override public void keyTyped(KeyEvent e) {}
        @Override public void keyReleased(KeyEvent e) {}
    }
    private class CorreoKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                ejecutarOperacion("validar correo", true);
            }
        }
        @Override public void keyTyped(KeyEvent e) {}
        @Override public void keyReleased(KeyEvent e) {}
    }
    private void ejecutarOperacion(String operacion, boolean esResultadoUnico) {
        try {
            // La cadena de entrada principal siempre es la fuente de datos (excepto para validar correo)
            String cadenaOriginal = inputCadena.getText();
            Workshop workshop = new Workshop();
            Object resultado = null;
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
                    if (subcadenaABuscar.isEmpty() || subcadenaABuscar.equals("1. Ingrese subcadena a buscar")) {
                        throw new IllegalArgumentException("Debe ingresar la subcadena a buscar primero.");
                    }
                    int posicion = workshop.buscarSubcadena(cadenaOriginal, subcadenaABuscar);
                    if (posicion == -1) {
                        // Si no se encuentra, limpiamos el estado.
                        subcadenaBuscadaParaReemplazo = null;
                        resultado = "La subcadena '" + subcadenaABuscar + "' NO se encontró. Intente de nuevo.";
                        buscarReemplazarTextField.setText("1. Ingrese subcadena a buscar");
                    } else {
                        // 🌟 Almacenar la subcadena y preparar la UI para la Etapa 2
                        subcadenaBuscadaParaReemplazo = subcadenaABuscar;
                        buscarReemplazarTextField.setText(""); // Limpiar el campo
                        resultado = "Subcadena almacenada ('" + subcadenaABuscar + "') en índice " + posicion + ".\n" +
                                "Ahora ingrese el texto de reemplazo en el mismo campo y presione REEMPLAZAR.";
                    }
                    break;
                case "reemplazar":
                    if (subcadenaBuscadaParaReemplazo == null) {
                        throw new IllegalArgumentException("ERROR: Primero debe buscar y almacenar una subcadena (presione ENTER en el campo).");
                    }

                    String subcadenaAReemplazar = subcadenaBuscadaParaReemplazo;
                    String reemplazoTexto = buscarReemplazarTextField.getText();

                    // Llamar al Workshop para ejecutar el reemplazo
                    String cadenaNueva = workshop.reemplazarSubcadena(cadenaOriginal, subcadenaAReemplazar, reemplazoTexto);

                    // 🌟 Actualizar el JTextArea principal (inputCadena) con el resultado
                    inputCadena.setText(cadenaNueva);

                    // Limpiar el estado y preparar la UI para la siguiente búsqueda
                    subcadenaBuscadaParaReemplazo = null;
                    buscarReemplazarTextField.setText("1. Ingrese subcadena a buscar");

                    resultado = "Reemplazo exitoso:\nSe reemplazó '" + subcadenaAReemplazar + "' por '" + reemplazoTexto + "'.\n";
                    break;
                case "validar_correo":
                    String correo = validarCorreoTextField.getText();
                    boolean esValido = workshop.validarCorreoElectronico(correo);
                    resultado = esValido ?
                            "El correo es VÁLIDO." :
                            "El correo es INVÁLIDO.";
                    break;

                default:
                    resultado = "Operación no implementada.";
            }

            // --- Mostrar Resultado ---
            if (resultado == null) {
                resultadosTextArea.setText("ERROR INTERNO: Resultado de operación nulo.");
                return;
            }

            if (esResultadoUnico) {
                resultadosTextArea.setText("Resultado de " + operacion + ":\n" + resultado.toString());
            } else {
                resultadosTextArea.setText("Resultado de " + operacion + ":\n" + resultado.toString());
            }

        } catch (NumberFormatException ex) {
            resultadosTextArea.setText("ERROR: La entrada no es un número válido.");
        } catch (Exception ex) {
            resultadosTextArea.setText("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}