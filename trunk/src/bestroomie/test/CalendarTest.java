/**
Author: Lei Zhang
File Creation Date: Apr 8, 2014
Class Description:
*/
package bestroomie.test;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class CalendarTest {
  public static void main(String[] args) {
    JLabel label = new JLabel("Selected Date:");
    final JTextField text = new JTextField(20);
    JButton b = new JButton("popup");
    final JPanel p = new JPanel();
    p.add(label);
    p.add(text);
    p.add(b);
    final JFrame f = new JFrame();
    f.getContentPane().add(p);
    f.pack();
    f.setVisible(true);
    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        text.setText(new DatePicker(p).setPickedDate());
      }
    });
  }
}