/* The Client Class - Written by Derek Molloy for the EE402 Module
 * See: ee402.eeng.dcu.ie
 * 
 * 
 */

package assignmentss;
import java.net.*;
import java.io.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
public class client3 extends Frame implements  ActionListener{
                                                   //gui members implemented
	private static int portNumber = 5050;
    private Socket socket = null;
    private ObjectOutputStream os = null;
    private ObjectInputStream is = null;
    private DateTimeService x;
    private Frame xx;
    private Panel panel1,panel2,panel3;
    private Button b_up,b_down,b_east,b_west,b_speedup,b_speedown;
    private int verticalmovement;   //default starting position
    private int horizontalmovement; //default starting position
    private Label label1,label2,label3;
    private TextArea location,speed,server;
    private Calendar calendar;
    
    
	// the constructor expects the IP address of the server - the port is fixed
   
    public client3(String serverIP) {
       super("sdasdsa");                   //panels implemented here
	   xx = new Frame("dfdsfsd");
	   panel1 = new Panel(new GridLayout(2,2));
	   this.add(panel1,BorderLayout.NORTH);
	   panel2 = new Panel(new GridLayout(3,3));
	   this.add(panel2,BorderLayout.CENTER);
	   panel3 = new Panel(new GridLayout(2,3));
	   this.add(panel3,BorderLayout.SOUTH);
	   
	   
	                                 //panel1
	   
	   b_up = new Button("Go upwards");
	   b_up.addActionListener(this);
	   panel1.add(b_up);
	   b_down = new Button("Go downwards");
	   b_down.addActionListener(this);
	   panel1.add(b_down);
	   b_east = new Button("Go east");
	   b_east.addActionListener(this);
	   panel1.add(b_east);
	   b_west = new Button("Go west");
	   b_west.addActionListener(this);
	   panel1.add(b_west);

	   b_speedup = new Button("speed up");
	   b_speedown = new Button("speed down");
	   panel2.add(b_speedup);
	   panel2.add(b_speedown);
	   label1 = new Label("Location info");
	   label2 = new Label("Speed info");
	   label3 = new Label("Server info");
	   location = new TextArea();
	   speed = new TextArea();
	   server = new TextArea();
	   panel3.add(label1);
	   panel3.add(label2);
	   panel3.add(label3);
	   panel3.add(location);
	   panel3.add(speed);
	   panel3.add(server);
	    	if (!connectToServer(serverIP)) {
	    		System.out.println("XX. Failed to open socket connection to: " + serverIP);            
	    	}
	    	
	    	 this.setVisible(true);	
	    	    	
	    }

    private boolean connectToServer(String serverIP) {
    	try { // open a new socket to the server 
    		this.socket = new Socket(serverIP,portNumber);
    		this.os = new ObjectOutputStream(this.socket.getOutputStream());
    		this.is = new ObjectInputStream(this.socket.getInputStream());
    		System.out.println("00. -> Connected to Server:" + this.socket.getInetAddress() 
    				+ " on port: " + this.socket.getPort());
    		System.out.println("    -> from local address: " + this.socket.getLocalAddress() 
    				+ " and port: " + this.socket.getLocalPort());
    	} 
        catch (Exception e) {
        	System.out.println("XX. Failed to Connect to the Server at port: " + portNumber);
        	System.out.println("    Exception: " + e.toString());	
        	return false;
        }
		return true;
    }
    
    private void  sendobject(DateTimeService client1) {
    	//String theDateCommand = "GetDate", theDateAndTime;
    	System.out.println("01. -> Sending Command ( DateTimeService  ) to the server...");
        this.moveclient(client1); //objected passed through moveclient function
    	try{                       //for updating object
    	DateTimeService	yq = (DateTimeService) receive();
    		System.out.println("05. <- The Server responded with: " );
    		System.out.println("    <- " + yq);
    		sendobject(yq);
    	}
    	catch (Exception e){
    		System.out.println("XX. There was an invalid object sent back from the server");
    	}
    	System.out.println("06. -- Disconnected from Server.");
    	
    }
    private DateTimeService firstmoveclient1(DateTimeService x) {
    	verticalmovement =  x.verticalposition;
    	horizontalmovement= x.horizontalposition;
    	return x;
    }
    
    private DateTimeService moveclient(DateTimeService x) {
  	     
    	  x.verticalposition = verticalmovement;
		  x.horizontalposition = horizontalmovement;
		  
			 
	  
	   try {
			Thread.sleep(10000);
		 setdroneinformation();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	   send(x);
	  
	  return x;
};

private  DateTimeService  looptheconnection(DateTimeService y) {
	
    
    sendobject(y);
    	
    return y;
    	
    };

    
     private void send(Object o) {
    	
		try {
		    System.out.println("02. -> Sending an object..."+ o);
		   
		    os.writeObject(o);
		    os.flush();
		   
		} 
	    catch (Exception e) {
		    System.out.println("XX. Exception Occurred on Sending:" +  e.toString());
		}
	
    }
  public void setdroneinformation() { //updates location label everytime when object is sent
	   
	  this.calendar = Calendar.getInstance();
	  Date d = this.calendar.getTime();
	  location.setText("Last time information sent: "+ d.toString() );
  };
  
	  
  

    // method to receive a generic object.
  private Object receive() 
  {
  	
		Object o = null;
		try {
			
			System.out.println("03. -- About to receive an object...");
		    o = is.readObject();
		    System.out.println("04. <- Object received...");
		   
		   
	//	     send(o); instead of directly sending the receive object object sent 
		    //through other function to update the parameter
		} 
		
	    catch (Exception e) {
		    System.out.println("XX. Exception Occurred on Receiving:" + e.toString());
		}
		return o;
	
  }
 public client2 xx(client2 x) {
	 
	 return x;
 };
    
   
  
     public static void main(String args[]) 
    {
    	 
    	System.out.println("**. Java Client Application - EE402 OOP Module, DCU");
    	if(args.length==3){
    		
    		
    		client3 theApp = new client3(args[0]);
    		DateTimeService xxx  = new DateTimeService(50,args[1],50,args[2],20);
    	//	String ipaddress = args[0];
    	//  String dronenumb = args[2]; //dronenumb works like as an client number;         
    		 theApp.firstmoveclient1(xxx);
    		theApp.send(xxx);			    
    			   theApp.sendobject(xxx);
    			  
		}
			
		
    	else
    	{
    		System.out.println("Error: you must provide the address of the server");
    		System.out.println("Usage is:  java Client x.x.x.x  (e.g. java Client 192.168.7.2)");
    		System.out.println("      or:  java Client hostname (e.g. java Client localhost)");
    	}    
    	System.out.println("**. End of Application.");
    	
    	
    };
 
    
    
 private void up() {
        int x = 5;
    	verticalmovement = verticalmovement + x;
    	
    };
 private void down() {
    	int x = -5;
    	verticalmovement = verticalmovement + x;
    	    	
    	    };
 private void east() {
    	int x = -5;
     	horizontalmovement = horizontalmovement + x;
    	    	    	
    	    	    };
 private void west() {
	    int x = 5;
     	horizontalmovement = horizontalmovement + x;
    	    	    	    	
    	    	    	    };

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b_up) {
			
			up();
			System.out.println("go up!");
			
		};
		// TODO Auto-generated method stub
        if(e.getSource() == b_down) {
			
			down();
			System.out.println("go down!");
			
		};
		if(e.getSource() == b_east) {
				
			east();
			System.out.println("go down!");
				
			};
	    if(e.getSource() == b_west) {
					
			west();
			System.out.println("go down!");
					
				};
	}	
}