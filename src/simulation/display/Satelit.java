package simulation.display;


import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import simulation.Handler;

public class Satelit extends JFrame implements MouseListener
{
	//for lists
	int ups=0;
	int ind=0;
	
	
	private static final long serialVersionUID = 1L;
	JList text = new JList();
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	private int x;
	private int y;
	private int index=-1;
	
	//DECLARING BUTTON
	private JLabel up;
	private JLabel down;
	private JLabel left;
	private JLabel right;
	private JScrollPane jScrollPane;
	private Handler handler;
	//For looping 
	private boolean mousePressed;
	
	public Satelit(Handler handler)
	{
		
		setUndecorated(true);
		this.handler=handler;
		//DECLARING new Label
		up = new JLabel();
		down = new JLabel();
		left = new JLabel();
		right = new JLabel();
		
		//Set Icon
		up.setIcon(new ImageIcon("./images/up.png"));
	    down.setIcon(new ImageIcon("./images/down.png"));
		left.setIcon(new ImageIcon("./images/left.png"));
		right.setIcon(new ImageIcon("./images/right.png"));
		
	    //// FORMAT LAYOUT + ADDING BUTTON DI LAYOUT
	    setLayout(new FlowLayout());
	    JPanel con = new JPanel(new GridLayout(3,1));

	    con.setOpaque(false);
       
        con.add(new JLabel());
        con.add(up);
        con.add(new JLabel());
        con.add(left); 
        con.add(new JLabel());        
        con.add(right);
        con. add(new JLabel());
        con.add(down);
        con.add(new JLabel());
       
        
        //Set Scrolling Pane
        listModel.addElement("Drone X=" + handler.getWorld().getDrone().getX() + " Y="+handler.getWorld().getDrone().getY());
        text.setModel(listModel);
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportBorder(new LineBorder(Color.RED));
        jScrollPane.getViewport().add(text, null);
        jScrollPane.setPreferredSize(new Dimension(300,150));
		
        //
  
        
       
        add(con);
        add(jScrollPane);
        ////
        
        
        //ADDING BUTTON TO LISTENER
        up.addMouseListener(this);
        down.addMouseListener(this);
        left.addMouseListener(this);
        right.addMouseListener(this);
        
    
	}
	
//ACCESSOR AND MUTTATOR
	
//
	
	
//ACTION LISTENER FOR MOUSE
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}


	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}


	public void mousePressed(final MouseEvent arg0) {
		mousePressed = true;
		
		
        new Thread() {
        	//Continue to run while pressed
            public void run() {
                while (mousePressed) {
                	try {
						Thread.sleep(10);
					} catch (InterruptedException e1) {
						
						e1.printStackTrace();
					}
                	
                	
                	if(up==arg0.getSource()) 
            	 	{
                		
                		up.setIcon(new ImageIcon("./images/upF.png"));
                		
                		handler.getWorld().getDrone().minY();
  
            	 	}
            		if(left==arg0.getSource())
            	 	{

            			left.setIcon(new ImageIcon("./images/leftF.png"));
            
            			handler.getWorld().getDrone().minX();

                	 	}
            		if(right==arg0.getSource())
            	 	{
   
            			right.setIcon(new ImageIcon("./images/rightF.png"));;
            			handler.getWorld().getDrone().addX();
                    	

                	 	}
            		if(down==arg0.getSource())
            	 	{	

            			down.setIcon(new ImageIcon("./images/downF.png"));
            			handler.getWorld().getDrone().addY();
            	
            	 	}
                  	
            		
           		 
            		index=-1;
            		 //SHOWING NOTIFICATION ON LIST 
            		 for(int i=0;i<listModel.size();i++)
            		 {
            			 if(listModel.getElementAt(i).indexOf("Drone X")>=0)
            			 {
            				 index=i;
            			 }

            		 }
                	 
            		 if (index>=0)
            		 {
            			 listModel.setElementAt("Drone X=" + handler.getWorld().getDrone().getX() + " Y="+handler.getWorld().getDrone().getY(),0);
                	 	 
            		 }
            		 
            			
        			 
            		text.setModel(listModel);
            	 	text.ensureIndexIsVisible(ind++);
            	 	 //
                }}
            

        }.start();
       
	}

	public void mouseReleased(MouseEvent arg0) {
		//Stop running
		mousePressed=false;
		
		  new Thread() {
	        	//Continue to run while pressed
	            public void run() {
	                while (!mousePressed) {
	            		up.setIcon(new ImageIcon("./images/up.png"));
	            	    down.setIcon(new ImageIcon("./images/down.png"));
	            		left.setIcon(new ImageIcon("./images/left.png"));
	            		right.setIcon(new ImageIcon("./images/right.png"));
	                }}
	        }.start();
	       

	};
public void modelSet()	
{
	text.setModel(listModel);
}
public void addList(String component)
{
	listModel.addElement(component);
	text.setModel(listModel);
}

public void setList(String component,int i)
{
	listModel.setElementAt(component,i);
	text.setModel(listModel);
}

public int getIndex(String hint)
{
	int index=-1;
	
	 for(int i=1;i<listModel.size();i++)
	 {
		 if(listModel.getElementAt(i).indexOf(hint)>=0)
		 {
			index=i;
		 }
	 }
	 return index;
}


//PREMAIN	
	/*
	public static void main(String[] args) {
		
	
         ReControl main = new ReControl(0,0);
         main.setBounds(10, 10, 470, 165);
         main.setVisible(true);
         main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         main.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
         main.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
         main.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
 }
	*/
	
}
