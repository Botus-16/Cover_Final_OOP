import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuNavegacion extends JFrame {
    private JButton operacionesMatematicasButton;
    private JButton manipulacionArreglosButton;
    private JButton procesamientoCadenasButton;
    private JButton button4;
    private JButton button5;
    private JPanel panelPrincipal;
    public MenuNavegacion() {
        setTitle("Menú de Navegación");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panelPrincipal);
        operacionesMatematicasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operaciones();
            }
        });
        manipulacionArreglosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                arreglos();
            }
        });
        procesamientoCadenasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadenas();
            }
        });
        setVisible(true);
    }
    private void operaciones() {
        OperacionesMatemáticas math = new OperacionesMatemáticas();
        JFrame calculatorFrame = new JFrame("Operaciones matematicas");
        calculatorFrame.setContentPane(math.getPanelPrincipal());
        calculatorFrame.pack();
        calculatorFrame.setLocationRelativeTo(null);
        calculatorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        calculatorFrame.setVisible(true);
    }
    private void arreglos() {
        ManipulacionArreglos arreglos = new ManipulacionArreglos();
        JFrame calculatorFrame = new JFrame("Manipulacion de Arreglos");
        calculatorFrame.setContentPane(arreglos.getPanelPrincipal());
        calculatorFrame.pack();
        calculatorFrame.setLocationRelativeTo(null);
        calculatorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        calculatorFrame.setVisible(true);
    }
    private void cadenas() {
        ProcesamientoCadenas cadenas = new ProcesamientoCadenas();
        JFrame calculatorFrame = new JFrame("Procesamiento de Cadenas");
        calculatorFrame.setContentPane(cadenas.getPanelPrincipal());
        calculatorFrame.pack();
        calculatorFrame.setLocationRelativeTo(null);
        calculatorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        calculatorFrame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuNavegacion::new);
    }
}
