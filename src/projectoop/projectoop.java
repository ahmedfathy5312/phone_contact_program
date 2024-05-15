package projectoop;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class projectoop extends JFrame implements ActionListener{
    JButton button1,button2,button3;//الازرار 
    JLabel label1,label2,label3,label4,label5;
    JTextField text1,text2,text3;
    JPanel panel1,panel2,panel3,panel4,panel5;
    JTable tabel1;
    DefaultTableModel model=new DefaultTableModel(new Object [][] {},new String []{"Name","Email","Phone"});
    JScrollPane scroll1;
    ImageIcon icon;
    public projectoop()
    {
        this.setTitle("My Contacts");//ده العنوان 
        this.setSize(800, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//لايقاف التشغيل من علامةx 
        this.setLayout(new GridLayout(1, 2));
        icon=new ImageIcon("1.PNG");
        Font F1=new Font("Arial", 4, 25);
        Font F2=new Font("Times new Roman", 1, 50);
        button1=new JButton("Add");
        button2=new JButton("Clear");
        button3=new JButton("Delete");
        button1.setFont(F1);
        button2.setFont(F1);
        button3.setFont(F1);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        label1=new JLabel("Name");
        label2=new JLabel("Email");
        label3=new JLabel("Phone");
        label1.setFont(F1);
        label2.setFont(F1);
        label3.setFont(F1);
        label4=new JLabel(icon);
        label5=new JLabel("My Contact");
        label5.setFont(F2);
        text1=new JTextField(10);
        text2=new JTextField(10);
        text3=new JTextField(10);
        text1.setFont(F1);
        text2.setFont(F1);
        text3.setFont(F1);
        panel1=new JPanel(new GridLayout(4, 2));
        panel1.setBackground(Color.cyan);
        panel2=new JPanel(new BorderLayout());
        panel2.setBackground(Color.cyan);
        panel3=new JPanel();
        panel4=new JPanel();
        panel5=new JPanel();
        panel3.setBackground(Color.cyan);
        panel4.setBackground(Color.cyan);
        tabel1=new JTable();
        tabel1.setBackground(Color.black);
        tabel1.setForeground(Color.white);
        scroll1=new JScrollPane();
        tabel1.setModel(model);
        tabel1.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabel1.getColumnModel().getColumn(1).setPreferredWidth(10);
        tabel1.getColumnModel().getColumn(2).setPreferredWidth(10);
        tabel1.getColumnModel().getColumn(0).setResizable(false);
        tabel1.getColumnModel().getColumn(1).setResizable(false);
        tabel1.getColumnModel().getColumn(2).setResizable(false);
        scroll1.setViewportView(tabel1);
        scroll1.setBackground(Color.black);
        panel1.add(label1);
        panel1.add(text1);
         panel1.add(label2);
        panel1.add(text2);
         panel1.add(label3);
        panel1.add(text3);
        panel3.add(button1);
        panel4.add(button2);
         panel1.add(panel3);
        panel1.add(panel4);
        panel5.add(label4);
        panel5.add(label5);
        panel2.add(panel5,BorderLayout.NORTH);
        panel2.add(button3,BorderLayout.SOUTH);
        panel2.add(scroll1,BorderLayout.CENTER);
        this.add(panel1);
        this.add(panel2);
        //this.setResizable(false);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        projectoop jv=new projectoop();
    }
    public void actionPerformed(ActionEvent e) {
  if(e.getSource()==button1)
  {
      try{
          if(text1.getText().length()>0 && text2.getText().length()>0  && text3.getText().length()>0 )
              {
                  String s1=text1.getText();
                  String s2=text2.getText();
                  String s3=text3.getText();
                  if(!(s2.contains("@")))
                      throw new Exception("invalid Email");
                  if(!(s3.startsWith("010")||s3.startsWith("011")||s3.startsWith("012")||s3.startsWith("015")))
                      throw new Exception("invalid phone number");
                  if(!(s3.length()==11))
                      throw new Exception("length of phone number is invalid");
          model.addRow(new Object[]{text1.getText(),text2.getText(),text3.getText()});
      text1.setText(null);
      text2.setText(null);
      text3.setText(null);
          }
          else
                throw new Exception("please enter data");
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, ex.toString());
      }
  }
  if(e.getSource()==button2)
  {
      text1.setText(null);
      text2.setText(null);
      text3.setText(null);
  }
  if(e.getSource()==button3)
  {
      try{
      int rownumber=tabel1.getSelectedRow();
         model.removeRow(rownumber);
      }catch(Exception ex)
      {
           JOptionPane.showMessageDialog(null, "please select row ");
      }
  }
    }  
}
