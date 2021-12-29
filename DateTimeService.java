/* The Date Time Service Class - Written by Derek Molloy for the EE402 Module
 * See: ee402.eeng.dcu.ie
 */

package assignmentss;

import java.util.Calendar;

import java.util.Date;
import java.io.Serializable;
public class DateTimeService implements Serializable
{
 
   private String name;
   public int horizontalposition;
   public int verticalposition;
   public String dronenumb;
   public int speed =10;
   public int height;
   
   //constructor creates the Calendar object, could use the constructor:
   //   Calendar(TimeZone zone, Locale aLocale) to explicitly specify 
   //	  the time zone and locale
   public DateTimeService(int horizontal,String namez,int vertical ,String dronenumb ,int height)
   { 
	 
	 this.horizontalposition = horizontal;
	 this.verticalposition = vertical;
	 this.name = namez;
	 this.dronenumb = dronenumb;
	 this.height = height;
     this.speed = speed;	
	 
   }
  
   //method returns date/time as a formatted String object
   public int getvertical()
   {
	return this.verticalposition;	
   }	
   public int gethorizontal()
   {
	   
	return horizontalposition;
   }
   
   public String getdronenumb() {
	   
	   return dronenumb;
   };
   public String  getdronename()
   {
	  String name = this.name;
	return name;
   }
   public int getspeed()
   {
	return this.speed;	
   }
   public int getheight() {
	   return this.height;
   };
   public void increasespeed() {
	   
	   this.speed = speed +10;
   };
public void decreasespeed() {
	   
	   this.speed = speed -10;
   };
   public static void main(String args[]) 
   {
	   
	   
   }
}
