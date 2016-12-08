package Swingtest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Radomcolor extends JFrame implements ActionListener,ChangeListener {
	colorradom c = new colorradom();
	JButton jb = new JButton("change color");
	JSlider[] js = {
			new JSlider(JSlider.HORIZONTAL,0,255,0),
			new JSlider(JSlider.HORIZONTAL,0,255,0),
			new JSlider(JSlider.HORIZONTAL,0,255,0)
	};
	JLabel[] jl={
		new JLabel("红:"),new JLabel("绿:"),new JLabel("蓝:")	
	};
	JTextField[] jtf={
		new JTextField("0"),new JTextField("0"),new JTextField("0")	
	};
	public Radomcolor(){
		this.setLayout(null);
		this.setBounds(200, 200, 400, 400);
		c.setBounds(130, 120, 120,120);
		for(int i=0; i < 3; i++){
			jl[i].setBounds(10, 10+40*i, 20, 20);
			js[i].setBounds(35, 10+40*i, 260, 20);
			js[i].addChangeListener(this);
			jtf[i].setBounds(300, 10+40*i, 50, 20);
			jtf[i].setEditable(false);
			this.add(jtf[i]);
			this.add(js[i]);
			this.add(jl[i]);
		}
		this.setTitle("随机产生颜色");
		
		jb.setBounds(110, 280, 160, 30);
		jb.setContentAreaFilled(false);
		jb.addActionListener(this);
		this.add(c);
		this.add(jb);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Radomcolor();
	}
	public void actionPerformed(ActionEvent e) {
		this.repaint();
	}
	public void stateChanged(ChangeEvent ev) {
		String str1;String str2;String str3;
		if((JSlider)ev.getSource() == js[0]){
		str1=""+js[0].getValue();
		jtf[0].setText(str1);
		}
		
		if((JSlider)ev.getSource() == js[1]){
			str2=""+js[1].getValue();
			jtf[1].setText(str2);
			}
		if((JSlider)ev.getSource() == js[2]){
			str3=""+js[2].getValue();
			jtf[2].setText(str3);
			}
	}

}
class colorradom extends JPanel{
	int red;int green;int blue;
	public void paint(Graphics g){
		 red = (int) (Math.random() * 255);
         green = (int) (Math.random() * 255);
         blue = (int) (Math.random() * 255);
        Color c = new Color(red, green, blue);
        g.setColor(c);
        g.fillOval(10, 10, 100, 100);
        
	}
}