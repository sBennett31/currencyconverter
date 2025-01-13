import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Convertercurrency extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton convertbtn, clearbtn;
    private JTextField textField, texfield1;
    private JRadioButton jmtousddbtn, usdtojmdbtn;
    private JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2;
    private ButtonGroup currencyGroup;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Convertercurrency frame = new Convertercurrency();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Convertercurrency() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 455, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        jmtousddbtn = new JRadioButton("JMD to USD");
        jmtousddbtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        jmtousddbtn.setBounds(49, 85, 122, 36);
        contentPane.add(jmtousddbtn);

        usdtojmdbtn = new JRadioButton("USD to JMD");
        usdtojmdbtn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        usdtojmdbtn.setBounds(221, 90, 145, 28);
        contentPane.add(usdtojmdbtn);

        // Group the radio buttons.
        currencyGroup = new ButtonGroup();
        currencyGroup.add(jmtousddbtn);
        currencyGroup.add(usdtojmdbtn);

        convertbtn = new JButton("CONVERT");
        convertbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
        convertbtn.setBounds(49, 208, 317, 45);
        contentPane.add(convertbtn);
        
        clearbtn = new JButton("CLEAR");
        clearbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
        clearbtn.setBounds(49, 260, 317, 45);
        contentPane.add(clearbtn);

        textField = new JTextField();
        textField.setBounds(51, 157, 144, 41);
        contentPane.add(textField);
        textField.setColumns(10);

        texfield1 = new JTextField();
        texfield1.setColumns(10);
        texfield1.setBounds(221, 157, 144, 41);
        contentPane.add(texfield1);

        lblNewLabel = new JLabel("Input");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel.setBounds(73, 127, 75, 20);
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Output");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(252, 132, 45, 13);
        contentPane.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("Currency Converter");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2.setBounds(97, 28, 236, 36);
        contentPane.add(lblNewLabel_2);

        // Add action listeners for buttons.
        convertbtn.addActionListener(e -> convertbtnActionPerformed());
        clearbtn.addActionListener(e -> clearFields());
    }

    private void convertbtnActionPerformed() {
        double jmd, usd;
        if (jmtousddbtn.isSelected()) {
            jmd = Double.parseDouble(textField.getText());
            usd = jmd / 150.00;
            texfield1.setText(String.valueOf(usd));
        }
        if (usdtojmdbtn.isSelected()) {
            usd = Double.parseDouble(textField.getText());
            jmd = usd * 150.00;
            texfield1.setText(String.valueOf(jmd));
        }
    }

    private void clearFields() {
        textField.setText("");
        texfield1.setText("");
        currencyGroup.clearSelection();
    }
}
