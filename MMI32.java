//Do the Modular Multiplicative Inverse of a impar >>
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MMI32 {
    public static void main(String[] args) {
        new MMIFRAME().setVisible(true);
    }
}
class MMIFRAME extends JFrame {
    private JPanel panelFrame;
    private JLabel panelLBL;
    private JTextField mmiTxt;
    private JButton genMMI;
    public MMIFRAME() {
        super();
        super.setTitle("MMI32");
        super.setSize(600, 90);
        super.setLayout(new FlowLayout());
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPanel();
        getRootPane().setDefaultButton(genMMI);
        this.add(this.panelFrame);
    }
    private void setPanel() {
        this.panelFrame = new JPanel(new FlowLayout());
        this.panelFrame.setPreferredSize(new Dimension(600, 90));
        this.panelFrame.setBackground(Color.black);
        this.panelFrame.setFocusable(true);
        this.setLbl();
        this.setButton();
        this.panelFrame.add(this.panelLBL);
        this.panelFrame.add(this.mmiTxt);
        this.panelFrame.add(this.genMMI);
    }
    private void setLbl(){
        this.panelLBL = new JLabel("Type a number to gen the MMI: ");
        this.panelLBL.setForeground(Color.white);
        this.panelLBL.setPreferredSize(new Dimension(175, 25));
    }
    private void setButton(){
        this.genMMI = new JButton("gen");
        this.genMMI.setPreferredSize(new Dimension(90, 27));
        this.mmiTxt = new JTextField();
        this.mmiTxt.setPreferredSize(new Dimension(295, 25));
        this.genMMI.addActionListener(event -> {
            try {
                int parseInt = (mmiGenerator(Integer.parseInt(mmiTxt.getText())) == 0) ? 0 : mmiGenerator(Integer.parseInt(mmiTxt.getText()));
                if (parseInt == 0){
                    JOptionPane.showMessageDialog(null, "Digite um inteiro primo!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "MMI: " + parseInt);
                }
            } catch (NumberFormatException excpt) {
                JOptionPane.showMessageDialog(null, "Apenas numerais de até 10 dígitos permitidos!");
            }
        });
    }
    private int mmiGenerator(int integer){
        if ((integer & 1) == 0) {return 0;}
        int inv = integer;
        int tmp = integer * inv;
        do {inv *= tmp;} while ((tmp *= tmp) != 1);
        integer = inv;
        return integer;
    }
}