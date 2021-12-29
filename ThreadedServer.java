/* The Date Server Class - Written by Derek Molloy for the EE402 Module
 * See: ee402.eeng.dcu.ie
 */

package assignmentss;

import java.net.*;
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
public class ThreadedServer extends Frame    implements ActionListener ,  WindowListener
{
	public  static canvasd canvas;
	private Panel Main;
	private Panel East;
	private Panel East2;
	private Panel South;
	private Frame Serverframe;
	private static int portNumber = 5050;
	private Panel Main1;
	private Label label1 ;
	private JLabel label;
	private TextArea drone1,drone2,drone3;
	private client client1;
	private client2 client2;
	
	private TextField label2,label3,label4,label5,label6,label7,label8,label9,label10,label12;
	Label label11;
	
	
	private Button incmargin,decmargin;
	private TextField ifdanger, ifdangercl1cl3,ifdangercl2cl3;
	private Button dron1;
	private Scrollbar horizontal,vertical;
	public int x = 0;
	private DateTimeService  theDateService;
	public int setmargin =50;
	
	public ThreadedServer() {
		super("Serverframe");
		Serverframe = new Frame("ROBOT NAVIGATION PROGRAM");
		Panel Main = new Panel(new GridLayout(2,1));
		
		Main.setPreferredSize(new Dimension(100, 100));
		Main.setBackground(Color.BLACK);
		this.add(Main,BorderLayout.NORTH);
		label11 = new Label("ROBOT NAVIGATION PROGRAM");
		label11.setForeground(Color.white);
		Main.add(label11);
		label12 = new TextField("No drones are in danger zone.curent margin=50");
		Main.add(label12); //north part is implemented here
		
		
		
		Panel Main1 = new Panel(new GridLayout(1,1)); //other panels implemented here
		Panel East = new Panel(new GridLayout(8,2));
		Panel East2 = new Panel(new GridLayout(1,1));
		Panel South = new Panel(new GridLayout(1,3));
		East.setPreferredSize(new Dimension(200,10));
		South.setPreferredSize(new Dimension(200,200));
		East.setBackground(Color.RED);
		this.add(East,BorderLayout.WEST);        
		this.add(East2,BorderLayout.EAST);
		this.add(South,BorderLayout.SOUTH);
		
		
		
		
		label2 = new TextField("Client 1 x:position");
		label3 = new TextField("Client 1 y:positon");
		label4 = new TextField("Client 2 x:position");
		label5 = new TextField("Client 2 y:position");
		label6 = new TextField("Client 3 x:positon");  //East part implemented here
		label7 = new TextField("Client 3 y:positon");
	     East.add(label2);
		East.add(label3);
		East.add(label4);    
		East.add(label5);
		East.add(label6);
		East.add(label7);
		
	    drone1 = new TextArea();        //west part implemented here
		drone1.setText("Drone current position"+" previous position "+ "before previous");
		East2.add(drone1);
		
	
		
		
        
        incmargin = new Button("increase safety margin"); //south part implemented
        decmargin = new Button("Decrease safety margin");
        incmargin.addActionListener(this);    
        decmargin.addActionListener(this);
        South.add(incmargin);
        South.add(decmargin);
        
        
        
		 East2.setPreferredSize(new Dimension(200,10));
	     
		 
		
		Main1.setPreferredSize(new Dimension(300, 300));
		
		South.setPreferredSize(new Dimension(5,90));
		Main1.setBackground(Color.BLUE);
		this.add(Main1,BorderLayout.CENTER);
	
		 dron1 = new Button("dron1");
		 dron1 = new Button("dron1");
		 
		  label1 = new Label("Drone x:positon");
		  dron1 = new Button("dron1");
	     // label1.setPreferredSize(new Dimension(200,100));
		//Main1.add(label1);
	    //  label1.setLocation(30, 90);
		//  Main1.add(dron1);
		 
			label1.setPreferredSize(new Dimension(5,5));
		  dron1.setVisible(false);
	      label1.setVisible(false);
	//	this.canvas = new canvas();
	  //  Main1.add(canvas);
		 

			 
		ThreadedServer.canvas = new canvasd(this,250,250,client1);
		 Main1.add(canvas);   	 
	
	 this.pack();
	 this.setVisible(true);
       
	 this.addWindowListener(this);
      server();
		
	}
	public DateTimeService getclient1(DateTimeService x) {
		return x;
		
		
	};
	public DateTimeService getclient2(DateTimeService x) {
		return x;
		
		
	};
	public DateTimeService getclient3(DateTimeService x) {
		return x;
		
	};
	

	public void client1location(String text, int xposition ,int yposition) {
		
		label2.setText("Client 1 " +text+ " xpositon "+ xposition  );
		label3.setText("Client 1 "+text+ " ypositon "+ yposition );
	    label1.setVisible(true);
	    
		};
		
public void client2location(String text, int xposition ,int yposition) {
			
			label4.setText("Client 2 " +text+ " xpositon "+ xposition  );
			label5.setText("Client 2 " +text+ " ypositon "+ yposition );
		    label1.setVisible(true);
		    
			};
    public void client3location(String text, int xposition ,int yposition) {
				
				label4.setText("Client 2 " +text+ " xpositon "+ xposition  );
				label5.setText("Client 2 " +text+ " ypositon "+ yposition );
			    label1.setVisible(true);
			    
				};
	
			
   public void collision(double cl1,double cl2,double cl3) {
			       
				if ((cl1 < setmargin)||(cl2 < setmargin)||(cl3 < setmargin)) {
				
				label12.setText("Danger clients are in collision zone");
				label12.setBackground(Color.RED);
				
			}
				else {
					label12.setText("clients are not in collision zone. currentMargin:"+setmargin);
					label12.setBackground(Color.WHITE);
				}
			
			     };

							     
public void	objectwarning(DateTimeService x){
	 
		
	};

	public static  DateTimeService  xx(DateTimeService c) {
		 				 		  
		 return c;
		 
	 };

	 public void setNumberCircles(int number){
         number = this.x;         
 }
	 public void client1lastposition() {
		 
	 };
	 public void clientslastposition(int h1,int h2,int h3,int v1,int v2,int v3) {
	   drone1.setText("last position"+ "x: "+h1+ "y:v1" +v1+
	  "previous position "+"x: "+h2+ "y:v1" +v2+
	  "before previous"+"x: "+h3+ "y: " +v3); 
	 };
	 public void client3lastposition() {};
	 
	 public void updatelocationvalue(int xvalue,int yvalue) {
		 vertical.setValue(yvalue);
		 horizontal.setValue(xvalue);
		 int x = horizontal.getValue();
		 int y = vertical.getValue();
		 label11.setText("Scroll Value = " + x);
		 label12.setText("Scroll Value = " + y);
	 };
	 
	public void server() {
		boolean listening = true;
        ServerSocket serverSocket = null;
        
        // Set up the Server Socket
        try 
        {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("New Server has started listening on port: " + portNumber );
        } 
        catch (IOException e) 
        {
            System.out.println("Cannot listen on port: " + portNumber + ", Exception: " + e);
            System.exit(1);
        }
        
        // Server is now listening for connections or would not get to this point
        while (listening) // almost infinite loop - loop once for each client request
        {
            Socket clientSocket = null;
            try{
            	System.out.println("**. Listening for a connection...");
                clientSocket = serverSocket.accept();
                System.out.println("00. <- Accepted socket connection from a client: ");
                System.out.println("    <- with address: " + clientSocket.getInetAddress().toString());
                System.out.println("    <- and port number: " + clientSocket.getPort());
            } 
            catch (IOException e){
                System.out.println("XX. Accept failed: " + portNumber + e);
                listening = false;   // end the loop - stop listening for further client requests
            }	
            
            ThreadeddConnectionHandler con = new ThreadeddConnectionHandler(clientSocket);
            con.start(); 
            System.out.println("02. -- Finished communicating with client:" + clientSocket.getInetAddress().toString());
        }
        // Server is no longer listening for client connections - time to shut down.
        try 
        {
            System.out.println("04. -- Closing down the server socket gracefully.");
            serverSocket.close();
        } 
        catch (IOException e) 
        {
            System.err.println("XX. Could not close server socket. " + e.getMessage());
        }
    }
	
	public static void main(String args[]) {
	new ThreadedServer();	
	
}
	public void setmargin(int x) {
		label12.setText("No drones are in danger zone.curent margin="+x);
	};
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == incmargin) {
		
			System.out.println("asdadas");
			
			x = setmargin + 5;
			setmargin = x;
			setmargin(x);
		};
        if(e.getSource() == decmargin) {
			
        	x = setmargin - 5;
			setmargin = x;
			setmargin(x);
		};
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}

