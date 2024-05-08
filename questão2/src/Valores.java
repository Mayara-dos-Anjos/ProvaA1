import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Valores extends JFrame{
    private JTextField[] camposTexto;
    private JButton btnOrdemCrescente;
    private JButton btnOrdemDecrescente;
    private JButton btnMaiorEntreDois;
    private JTextArea areaTextoResultado;

    public Valores() {
        setTitle("Ordenação de Números");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());
    
    JPanel painelEntrada = new JPanel(new GridLayout(3, 2));
        camposTexto = new JTextField[3];
        for (int i = 0; i < 3; i++) {
            JLabel lblNumero = new JLabel("Número " + (i + 1) + ":");
            camposTexto[i] = new JTextField(10);
            painelEntrada.add(lblNumero);
            painelEntrada.add(camposTexto[i]);
        }

        JPanel painelBotoes = new JPanel(new GridLayout(1, 3));
        btnOrdemCrescente = new JButton("Ordem crescente");
        btnOrdemDecrescente = new JButton("Ordem decrescente");
        btnMaiorEntreDois = new JButton("Maior número entre os outros dois");

        btnOrdemCrescente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarNumeros(0);
            }
        });
        btnOrdemDecrescente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarNumeros(1);
            }
        });
        btnMaiorEntreDois.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarNumeros(2);
            }
        });
        painelBotoes.add(btnOrdemCrescente);
        painelBotoes.add(btnOrdemDecrescente);
        painelBotoes.add(btnMaiorEntreDois);

 
        areaTextoResultado = new JTextArea();
        areaTextoResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTextoResultado);

        add(painelEntrada, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void ordenarNumeros(int opcao) {
        double[] numeros = new double[3];
        for (int i = 0; i < 3; i++) {
            try {
                numeros[i] = Double.parseDouble(camposTexto[i].getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Digite apenas números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        switch (opcao) {
            case 0:
                Arrays.sort(numeros);
                break;
            case 1:
                Arrays.sort(numeros);
                for (int i = 0; i < numeros.length / 2; i++) {
                    double temp = numeros[i];
                    numeros[i] = numeros[numeros.length - 1 - i];
                    numeros[numeros.length - 1 - i] = temp;
                }
                break;
            case 2:
                Arrays.sort(numeros);
                double maiorNumero = numeros[2];
                numeros[2] = numeros[1];
                numeros[1] = maiorNumero;
                break;
            default:
                JOptionPane.showMessageDialog(this, "Opção inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
        }
        areaTextoResultado.setText("Números ordenados:\n");
        for (double numero : numeros) {
            areaTextoResultado.append(String.valueOf(numero) + "\n");
    }
}
public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new Valores().setVisible(true);
        }
    });
}
}

