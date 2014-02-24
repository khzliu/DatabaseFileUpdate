package com.iie.exception;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyTest extends JFrame implements ActionListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 5211747658346053976L;
private JLabel lblname;
private JTextField txtname;
private JLabel lblage;
private JTextField txtage;
private JLabel lblsex;
private JTextField txtsex;
private JButton btnOK;
private Vector<Vector<String>>data;
private Vector<String> header;
private JPanel pnlleft;
private JPanel pnlright;
private JTable table;
private DefaultTableModel dtm;
public MyTest()
{
init();
}
private void init()
{
Container content=this.getContentPane();
content.setLayout(new GridLayout(1,2));
lblname=new JLabel("id：");
txtname=new JTextField(8);
lblage=new JLabel("名称：");
txtage=new JTextField(8);
lblsex=new JLabel("长度：");
txtsex=new JTextField(8);
btnOK=new JButton("生成");
btnOK.addActionListener(this);

pnlleft=new JPanel();
pnlleft.setLayout(new GridLayout(4,2));
pnlleft.add(lblname);
pnlleft.add(txtname);
pnlleft.add(lblage);
pnlleft.add(txtage);
pnlleft.add(lblsex);
pnlleft.add(txtsex);
pnlleft.add(btnOK);

data=new Vector<Vector<String>>();
header=new Vector<String>();
header.add("id");
header.add("名称");
header.add("长度");
dtm=new DefaultTableModel(data,header);
table=new JTable(dtm);
pnlright=new JPanel();
pnlright.add(table.getTableHeader());
//pnlright.setLayout(new GridLayout(2,1));
pnlright.add(table);

content.add(pnlleft);
content.add(pnlright);


this.setSize(new Dimension(410,200));
this.setLocation(300,300);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
}
public static void main(String[]args)
{
new MyTest();
}
public void actionPerformed(ActionEvent e) {
Vector<String> row=new Vector<String>();
row.add(txtname.getText().trim());
row.add(txtage.getText().trim());
row.add(txtsex.getText().trim());
data.add(row);
dtm.setDataVector(data, header);
}
}
