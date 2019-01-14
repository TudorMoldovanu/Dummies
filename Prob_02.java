import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Prob02Frame  extends JFrame implements  Runnable  {


	private JLabel label;
	private JTextField ta;
	private JPanel jPanel1;
	private Prob02Panel jPanel2;
	private JComboBox jComboBox4;
	private JComboBox jComboBox3;
	private JComboBox jComboBox2;
	private JComboBox jComboBox1;
	private long createdMillis = System.currentTimeMillis();



	public Prob02Frame(){
		super();
		initUI();	
	}


	private void initUI() {

		setLayout(new BorderLayout());

		setSize(new Dimension(400, 250));

		setTitle("Prob_01");

		jPanel1 = new JPanel();
		this.getContentPane().add(jPanel1, BorderLayout.WEST);
		jPanel1.setPreferredSize(new java.awt.Dimension(148, 266));

		jComboBox1 = new JComboBox();
		jComboBox1.addItem(new ComboItem("0","0"));
		jComboBox1.addItem(new ComboItem("1","1"));
		jPanel1.add(jComboBox1);
		jComboBox1.setPreferredSize(new java.awt.Dimension(100, 25));
		jComboBox1.setEnabled(true);


		jComboBox2 = new JComboBox();
		jComboBox2.addItem(new ComboItem("0","0"));
		jComboBox2.addItem(new ComboItem("1","1"));
		jPanel1.add(jComboBox2);
		jComboBox2.setPreferredSize(new java.awt.Dimension(100, 25));
		jComboBox2.setEnabled(true);


		jComboBox3 = new JComboBox();
		jComboBox3.addItem(new ComboItem("0","0"));
		jComboBox3.addItem(new ComboItem("1","1"));
		jPanel1.add(jComboBox3);
		jComboBox3.setPreferredSize(new java.awt.Dimension(100, 25));

		jComboBox4 = new JComboBox();
		jComboBox4.addItem(new ComboItem("0","0"));
		jComboBox4.addItem(new ComboItem("1","1"));
		jPanel1.add(jComboBox4);
		jComboBox4.setPreferredSize(new java.awt.Dimension(100, 25));
		
		label = new JLabel("");
		label.setBounds(100, 200, 150, 30);
		jPanel1.add(label);


		jPanel2 = new Prob02Panel();
		jPanel2.setText("nigga");
		this.getContentPane().add(jPanel2, BorderLayout.CENTER);
		jPanel2.setPreferredSize(new java.awt.Dimension(255, 266));

		jComboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				combo1Apasat(evt); 
			}
		});
		jComboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				combo2Apasat(evt); 
			}
		});
		jComboBox3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				combo3Apasat(evt); 
			}
		});
		jComboBox4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				combo4Apasat(evt); 
			}
		});


		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}


	private void combo1Apasat(ActionEvent evt){
		Object item = jComboBox1.getSelectedItem();
		String value = ((ComboItem)item).getValue();
		jPanel2.setVal1(value);
		jPanel2.repaint();
	}
	private void combo2Apasat(ActionEvent evt){
		Object item = jComboBox2.getSelectedItem();
		String value = ((ComboItem)item).getValue();
		jPanel2.setVal2(value);
		jPanel2.repaint();
	}
	private void combo3Apasat(ActionEvent evt){
		Object item = jComboBox3.getSelectedItem();
		String value = ((ComboItem)item).getValue();
		jPanel2.setVal3(value);
		jPanel2.repaint();
	}
	private void combo4Apasat(ActionEvent evt){
		Object item = jComboBox4.getSelectedItem();
		String value = ((ComboItem)item).getValue();
		jPanel2.setVal4(value);
		jPanel2.repaint();
	}
	@Override
	public  void  run()  {
		int count = 0; 
		for(;;)
		try  {
			Thread.sleep(1000);
			count++;
			label.setText("Secunde de la rulare: " + Integer.toString(count));
		}  catch  (InterruptedException  e)  {
			e.printStackTrace();
		}

	}


}
class Prob02Panel extends JPanel {

	private static final int RECT_X = 10;
	private static final int RECT_Y = RECT_X;
	private static final int RECT_WIDTH = 20;
	private static final int RECT_HEIGHT = RECT_WIDTH;
	String val1 = "0";
	String val2 = "0";
	String val3 = "0";
	String val4 = "0";

	public void setVal1(String s) {
		this.val1 = s;
	}
	public void setVal2(String s) {
		this.val2 = s;
	}
	public void setVal3(String s) {
		this.val3 = s;
	}
	public void setVal4(String s) {
		this.val4 = s;
	}


	private String s;

	public void  setText(String s) {
		this.s = s;
	}

	public void paint(Graphics g) {
		super.paint(g);


		if(val1.equals("0"))
			g.setColor(Color.GRAY);
		else
			g.setColor(Color.RED);
		g.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
		if(val2.equals("0"))
			g.setColor(Color.GRAY);
		else
			g.setColor(Color.RED);
		g.drawRect(RECT_X, RECT_Y+25, RECT_WIDTH, RECT_HEIGHT);
		if(val3.equals("0"))
			g.setColor(Color.GRAY);
		else
			g.setColor(Color.RED);
		g.drawRect(RECT_X, RECT_Y+55, RECT_WIDTH, RECT_HEIGHT);
		if(val4.equals("0"))
			g.setColor(Color.GRAY);
		else
			g.setColor(Color.RED);
		g.drawRect(RECT_X, RECT_Y+80, RECT_WIDTH, RECT_HEIGHT);
	}

}

class ComboItem
{
	private String key;
	private String value;

	public ComboItem(String key, String value)
	{
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString()
	{
		return key;
	}

	public String getKey()
	{
		return key;
	}

	public String getValue()
	{
		return value;
	}
}

class Prob_02 {

	public static void main(String[] args) {

		Prob02Frame app = new Prob02Frame();
		Prob02Frame app02 = new Prob02Frame();
		Thread  t1  =  new  Thread(app);
		t1.start();
		
		Thread  t2  =  new  Thread(app02);
		t2.start();

		app.setVisible(true);
		app02.setVisible(true);
	}
}