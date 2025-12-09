import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperacionesMatemáticas extends JFrame{
    private JButton calculadoraBásicaSumaDeButton;
    private JButton calculadoraDeFactorialButton;
    private JButton verificadorDeNúmerosPrimosButton;
    private JButton calculadorDeSignosZodiacalesButton;
    private JButton calculadoraDeÁreaDeButton;
    private JButton generadorDeSerieDeButton;
    private JPanel panelPrincipal;
    public OperacionesMatemáticas() {
        calculadoraBásicaSumaDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirCalculadoraBasica();
            }
        });
        calculadoraDeFactorialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirFactorial();
            }
        });
        verificadorDeNúmerosPrimosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirNumeroPrimo();
            }
        });
        calculadorDeSignosZodiacalesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirZodiaco();
            }
        });
        calculadoraDeÁreaDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirAreaCirculo();
            }
        });
        generadorDeSerieDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirSerieFibonacci();
            }
        });
    }

    private void abrirCalculadoraBasica() {
        CalculadoraBasica calculadora = new CalculadoraBasica();
        calculadora.setVisible(true);
    }
    private void abrirFactorial() {
        Factorial factorialApp = new Factorial();
        factorialApp.setVisible(true);
    }
    private void abrirNumeroPrimo() {
        NumeroPrimo primoApp = new NumeroPrimo();
        primoApp.setVisible(true);
    }
    private void abrirZodiaco() {
        Zodiaco zodiacoApp = new Zodiaco();
        zodiacoApp.setVisible(true);
    }
    private void abrirAreaCirculo() {
        AreaCirculo areaApp = new AreaCirculo();
        areaApp.setVisible(true);
    }
    private void abrirSerieFibonacci() {
        SerieFibonacci serieApp = new SerieFibonacci();
        serieApp.setVisible(true);
    }
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
