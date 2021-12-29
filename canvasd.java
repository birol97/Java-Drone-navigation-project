package assignmentss;
import java.awt.Color;
import java.lang.Math;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
public class canvasd extends Canvas implements MouseListener{
	 int width, height;
	 ThreadedServer giu;
	 client clients;
	 int x =0;
	 String dronenamex = "";
	 int client1horizontal =-500;
	 int client1vertical =-500;
	 int client1height;
	 String client1name;
	 String dronenameclient1 ="";
	 int client2horizontal =-50;
	 int client2vertical =-50;
	 int client2height;
	 String client2name;
	 String dronenameclient2 ="";
	 int client3horizontal =-200;
	 int client3vertical =-200;
	 int client3height;
	 String client3name;
	 
	 String dronenameclient3 ="";
	 int mouseclickedx=0;
	 int mouseclickedy=0;
	 String clientnumb = "";
	 Vector<Integer> client1positons = new Vector<Integer>();
	 Vector<DateTimeService> client2positons = new Vector<DateTimeService>();
	 Vector<DateTimeService> client3positons = new Vector<DateTimeService>();
	 public canvasd(ThreadedServer giuu,int width, int height,client xxd) {
	 this.setSize(width,height);
     this.width = width;
     this.height = height;
  //   this.update();
     this.giu = giuu;
     this.addMouseListener(this);
     this.clients = xxd;
		
	}

public void receiveobject(DateTimeService x) {
	
	switch (x.dronenumb) {
	case "1":
	this.giu.getclient1(x);
	break;
	case "2":
		this.giu.getclient1(x);
		break;
	case "3":
		this.giu.getclient1(x);
		break;
}}
public void safety(DateTimeService x) {
	
	
	
};
public void receiveobjectattributes(int horizontal,int vertical ,String dronenumb,int height) {	
	 client1positons.add(horizontal);
	 client1positons.add(vertical);
   
	 if(client1positons.size() == 8)
	 {
		 int	h1;
		 h1	 =	      client1positons.elementAt(0);
		 int v1 =     client1positons.elementAt(1);
		 int h2 =     client1positons.elementAt(2);
		 int v2 =     client1positons.elementAt(3);
		 int h3 =     client1positons.elementAt(4);
		 int v3 =     client1positons.elementAt(5);
		 this.giu.clientslastposition(h1,v1,h2,v2,h3,v3); 
         this.repaint();
		 
		 	client1positons.remove(1);
		 	client1positons.remove(2);
		 	
		 }	
	 
	
		this.clientnumb = dronenumb;
		switch (dronenumb) {
		
		
		case "1":
		this.client1horizontal = horizontal;
		this.client1vertical = vertical;
		this.client1name = dronenumb;
		this.client1height = height;
		
		
		break;

		case "2":
		 
		 this.client2horizontal = horizontal;
		 this.client2vertical = vertical;
		 this.client2name = dronenumb;
		 this.client2height = height;
		
		break;
		
		case "3":
			 
	     this.client3horizontal = horizontal;
		 this.client3vertical = vertical;
		 this.client3name = dronenumb;
		 this.client3height = height;
			
			break;
			
		}
		repaint();
		addlfabel(dronenumb, horizontal, vertical, dronenumb);
		
		collisiondetection(client1horizontal,client1vertical,client2horizontal,
				client2vertical,client3horizontal,client3horizontal);
}
//	
	
	//**///
	public void paint(Graphics g) {

	      g.setColor(Color.red);
		  g.drawOval(client1horizontal,client1vertical,60,60); 
          g.drawString(dronenameclient1+"height:"+client1height,client1horizontal+10,client1vertical-10);
        
		  g.setColor(Color.white);		  
		  g.drawOval(client2horizontal,client2vertical,60,60); 
          g.drawString(dronenameclient3+client3height,client3horizontal,client3vertical);
          
          g.setColor(Color.black);		  
		  g.drawOval(client3horizontal,client3vertical,60,60); 
          g.drawString(dronenameclient2+client2height,client2horizontal,client2vertical);
          
          
          
        	 
        	  if(client1positons.size() == 6) {
        	    g.setColor(Color.green);
          g.drawOval(client1positons.elementAt(0),client1positons.elementAt(1),30,30);
                g.setColor(Color.yellow);
          g.drawOval(client1positons.elementAt(2),client1positons.elementAt(3),20,20);
                g.setColor(Color.yellow);
       	  g.drawOval(client1positons.elementAt(4),client1positons.elementAt(5),15,15);
            
        	  }
	
	   int z =60;
	   for(int i=60;i <=600;i= i+z)
		   
		   g.drawLine(width*10,i,0,i);
	
     	 
	}
	
    
public void addlfabel(String dronename,int vertical,int horizontal,String dronenumb) {
	
 
	
	switch (dronenumb) {
	case "1":
    this.giu.client1location(dronename, vertical, horizontal); 

    break;
    case "2":
	this.giu.client2location(dronename, vertical, horizontal);
	break;
	case "3":
	this.giu.client2location(dronename, vertical, horizontal); 
	break;
	}
}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
int x = e.getX();
int y = e.getY();
this.mouseclickedx = x;
this.mouseclickedy = y;

System.out.println(x);
System.out.println(y);
  objectpositions(x,y);

}
public void objectpositions(int x,int y) {
	System.out.println(x);
	System.out.println(y);
	System.out.println(client2horizontal);
	System.out.println(client2vertical);
	int c2xdifference = x - client2horizontal;
	int c2ydifference = y - client2vertical;
	int c1xdifference = x - client1horizontal;
	int c1ydifference = y - client1vertical;
	int c3xdifference = x - client3horizontal;
	int c3ydifference = y - client3vertical;
	int c2doublex = c2xdifference*c2xdifference;
	int c2doubley = c2ydifference*c2ydifference;
	int c1doublex = c1xdifference*c1xdifference;
	int c1doubley = c1ydifference*c1ydifference;
	int c3doublex = c3xdifference*c3xdifference;
	int c3doubley = c3ydifference*c3ydifference;
	
	dronenameclient2="";
	dronenameclient1="";
	dronenameclient3="";
	
	if(Math.sqrt(c2doublex+c2doubley) < 30)	{
	dronenameclient2="client2";
	dronenameclient1="";
	dronenameclient3="";
	}
	
	if(Math.sqrt(c1doublex+c1doubley) < 30)	{
	dronenameclient2="";
	dronenameclient1="client1";
	dronenameclient3="";
	}
	if(Math.sqrt(c3doublex+c3doubley) < 30)	{
		dronenameclient2="";
		dronenameclient1="";
		dronenameclient3="client3";
		}
	
		
		

    repaint();

};
public void collisiondetection(int client1horizontal,int client1vertical,
		int client2horizontal,int client2vertical,int client3horizontal,int 
		client3vertical)
{
	int xdifference;
	int ydifference;
	if(client1horizontal > client1horizontal)
    xdifference = client1horizontal - client2horizontal;
	else
	xdifference = client2horizontal -client1horizontal;
	if(client1vertical > client2vertical)
	ydifference = client1vertical - client2vertical;
	else
	ydifference = client2vertical - client1vertical;
	
	int ysquare = ydifference*ydifference;
	int xsquare = xdifference*xdifference;
	double distancecl1andcl2 = Math.sqrt(xsquare+ysquare) + 15;
	//this.giu.collision(distancecl1andcl2);
	
	int x2difference;
	int y2difference;
	if(client1horizontal > client3horizontal)
    x2difference = client1horizontal - client3horizontal;
	else
	x2difference = client3horizontal -client1horizontal;
	if(client1vertical > client3vertical)
	y2difference = client1vertical - client3vertical;
	else
	y2difference = client3vertical - client1vertical;
	
	int y2square = y2difference*y2difference;
	int x2square = x2difference*x2difference;
	double distancecl1andcl3 = Math.sqrt(x2square+y2square) + 15;
	//this.giu.collision1(distancecl1andcl3);
	int x3difference;
	int y3difference;
	if(client2vertical > client3vertical)
    x3difference = client2horizontal - client3horizontal;
	else
	x3difference = client3horizontal -client2horizontal;
	if(client2vertical > client3vertical)
	y3difference = client2vertical - client3vertical;
	else
	y3difference = client3vertical - client2vertical;
	
	int y3square = y3difference*y3difference;
	int x3square = x3difference*x3difference;
	double distancecl2andcl3 = Math.sqrt(x3square+y3square) + 15;
	this.giu.collision(distancecl2andcl3,distancecl1andcl2,distancecl1andcl3);
	
	
};

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

};
