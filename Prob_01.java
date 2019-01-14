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
import java.util.EventListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class SampleFrame extends JFrame {


	private JLabel label;
	private JTextField ta;
	private JPanel jPanel1;
	private SamplePanel jPanel2 ;
	private int value;


	public SampleFrame(){
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

		ta = new JTextField(10);		
		ta.setBounds(50, 70, 150, 30);
		ta.setText("");

		jPanel1.add(ta);

		jPanel2 = new SamplePanel();
		jPanel2.setText("");
		this.getContentPane().add(jPanel2, BorderLayout.CENTER);
		jPanel2.setPreferredSize(new java.awt.Dimension(255, 266));

		ta.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				button1Apasat(evt);
			}
		});


		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}


	private void button1Apasat(ActionEvent evt){
		jPanel2.setText(ta.getText());
		jPanel2.repaint();
		try {
		File outputFile = new File("out02.txt");
		FileOutputStream fos = new FileOutputStream(outputFile);
		BufferedWriter bufout = new BufferedWriter(new OutputStreamWriter(fos));
		bufout.write(ta.getText());
		bufout.close();
		fos.close();
		}
		catch(IOException e){
			System.out .println("Eroare: " + e.toString    ());
		}
	}


}
class SamplePanel extends JPanel {

	private String s;

	public void  setText(String s) {
		this.s = s;
	}

	public void paint(Graphics g) {
		super.paint(g);


		Graphics2D g2 = (Graphics2D) g;
		Random rand = new Random();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		Font font = new Font("Serif", Font.PLAIN, 70);
		g2.setFont(font);
		
		if(s.equals("")==false)
			g2.drawString("" + s.charAt(s.length()-1), rand.nextInt(this.getHeight()) + 1, rand.nextInt(this.getWidth()) + 1);
	}

}

class Prob_01 {

	public static void main(String[] args) {

		SampleFrame app = new SampleFrame();

		app.setVisible(true);
	}
}
