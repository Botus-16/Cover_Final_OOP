import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuNavegacion extends JFrame {
    private JButton operacionesMatematicasButton;
    private JButton button2;
    private JButton button3;
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
        setVisible(true);
    }

    private void operaciones() {
        // Asumiendo que tu clase Calculadora está disponible
        operacionesMatemáticas math = new operacionesMatemáticas();
        JFrame calculatorFrame = new JFrame("Operaciones matematicas");
        calculatorFrame.setContentPane(math.getPanelPrincipal());
        calculatorFrame.pack();
        calculatorFrame.setLocationRelativeTo(null);
        calculatorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        calculatorFrame.setVisible(true);
    }

    public static void main(String[] args) {
        // La creación de la GUI debe hacerse en el Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new MenuNavegacion());
    }
}
