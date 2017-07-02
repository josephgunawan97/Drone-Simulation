package simulation.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;	
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.Border;

import simulation.Handler;

public class MainFrame {

	private static final Insets insets = new Insets(0, 0, 0, 0);
	private String title;
	private int width, height;
	private Canvas canvas;
	private Satelit control;
	private static JFrame frame =new JFrame();
	private GridBagConstraints constraints = new GridBagConstraints();
	private GridBagLayout gridbag = new GridBagLayout();
	private Handler handler;
	
	public MainFrame(Handler handler,String title, int width, int height) {
		this.title=title;
		this.width=width;
		this.height=height;
		this.handler=handler;
		display();
	}

	private void display() {
	// TODO Auto-generated method stub
		frame.getContentPane().setLayout(gridbag);
		JPanel panel = new JPanel();
		frame.setTitle(title); 
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(50,50);
		frame.setVisible(true);
  
		control = new Satelit(handler);
		control.setBounds(10, 10, 470, 165);
        control.setVisible(true);
        control.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        control.setLocation(880, 510);
        control.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        control.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        control.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(800,500));
		canvas.setFocusable(false);
    
		frame.add(canvas);
		frame.setResizable(false); 
		frame.pack();
  
	}

	public Canvas getCanvas() {
		return canvas;
	}


	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public Satelit getControl() {
		return control;
	}

	public void setControl(Satelit control) {
		this.control = control;
	}
 
	static void add( GridBagConstraints constraints, GridBagLayout layout,
					Component component) {
		Border edge = BorderFactory.createRaisedBevelBorder();
		layout.setConstraints(component, constraints);
		frame.getContentPane().add(component);
		}
}
