import java.util.*;

/* An ellipse is a conic section from Mathematics. An ellipse comes in the standard form of x²/a² + y²/b² = 1.
 * However, the graph of the ellipse can change based on the values of x, y, a and b. An ellipse in standard form
 * is horizontal and centered at the origin (0,0). An ellipse can become vertical in the case that y² and x² swap 
 * places in the equation. An ellipse is can be horizontally and/or vertically shifted from the origin, when this 
 * happens the ellipse comes in the form (x-h)²/a² + (y-k)²/b² = 1, with h and k representing the shifts from the
 * x and y axes respectively. The graphs of ellipses have many properties such as the vertices, the foci and the 
 * major and minor axes. This program asks the user whether for the a² and b² values of the ellipse, it also asks 
 * for the h and k values if the user specifies that the ellipse is not centered at the origin. I have created an 
 * ellipse class for this program, it contains two constructors, one for if the ellipse is centered at the origin 
 * and one if it isn't. The program lastly asks if the x² comes for in the equation or not, so as to know whether 
 * or not the ellipse is vertical. Then an ellipse object is instantiated with the x and y values and a boolean 
 * value that is set to true if x² comes first in the equation. The ellipse is instantiated with a different constructor
 * that also sends the h and k values as parameters if the ellipse is shifted from the origin. Once this is done, 
 * the custom toString method of the ellipse class is called which then prints all the relevant information such as 
 * the coordinates of the vertices, foci and the center, the major and minor axes and the equation of ellipse itself 
 * using getter methods. Then the program asks the user if they want to calculate another ellipse, if they say yes, 
 * then this whole process repeats, otherwise the program ends. */

public class Ellipse_Calculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Ellipse ellipse = null; //creates an empty ellipse object
	
		//asks user for input
		System.out.println("Is this Ellipse centered at the origin?\nEnter Yes or No");
		
		while (input.hasNext()) {
			
			int aSquared, bSquared, h, k;
			String underX;
			boolean aUnderX = false;
			
			/* origin is a String that takes input from the keyboard, it asks if the ellipse
			 * is centered at the origin or not, if the answer is yes, then the following executes: */
			
			String origin = input.next();
			
			if(origin.equals("Yes") || origin.equals("yes")) {
				
				//asks user to the denominators under x² and y² which are a² and b²
				
				System.out.println("Enter the value for a²");
				aSquared = input.nextInt();
				
				System.out.println("Enter the value for b²");
				bSquared = input.nextInt();
				
				/* asks user if the denominator under y² is larger than the denominator under x² because
				 * in an ellipse, if the larger denominator is the a² value, and if the denominator under
				 * y² is bigger, that means the ellipse is vertical. */
				
				System.out.println("Is the denominator under y² larger than the denominator under x²?");
				underX = input.next();
				if (underX.equals("No") || underX.equals("no"))
					aUnderX = true;
				
				/* creates an ellipse object using the constructor for centered ellipses, which take the 
				 * values of a², b² and the boolean variable aUnderX as parameters, aUnderX determines 
				 * whether or not the ellipse is vertical or horizontal, if aUnderX is true then it is
				 * horizontal, otherwise the ellipse is vertical */
				
				ellipse = new Ellipse(aSquared, bSquared, aUnderX); 
			}
			
			//if the user answers "no", the ellipse is not centered at the origin the following executes:
			
			if(origin.equals("No") || origin.equals("no")) {
				
				System.out.println("Enter the value for a²");
				aSquared = input.nextInt();
				
				System.out.println("Enter the value under b²");
				bSquared = input.nextInt();
				
				//like the previous if-statement it asks for the values of a² and b², but also asks for h and k
				
				System.out.println("Enter the value for h");
				h = input.nextInt(); //h represents the horizontal shift from the origin in the equation of an ellipse
				
				System.out.println("Enter the value for k");
				k = input.nextInt(); //k represents the vertical shift from the origin in the equation of an ellipse
				
				/* just like in the previous if-statement, it asks again whether or not the value under y² is larger
				 * than the value under x², if the answer is no then aUnderX is set to true, otherwise it's false. 
				 * If aUnderX is true then the ellipse is horizontal, other it's vertical. */
				
				System.out.println("Is the denominator under y² larger than the denominator under x²?");
				underX = input.next();
				if (underX.equals("No") || underX.equals("no"))
					aUnderX = true;
				
				/* now the ellipse is instantaited using the constructor for ellipses shifted from the origin, it sends
				 * a², b² and aUnderX as parameters just like the other constructor, but this constructor also takes the
				 * h and k values as parameters as well. */
				
				ellipse = new Ellipse(aSquared,bSquared,h,k,aUnderX); //creates a shifted ellipse with the given a², b², h and k values
				}
			
			/* now that the ellipse was created, it calculates and returns all the relevant info of the ellipse
			 * which is returned by the toString method, the info that will be printed are the coordinates of the
			 * vertices, foci and center, the major and minor axes, and the equation of the ellipse. */
			
			System.out.println(ellipse.toString()); 
			
			/* now it asks the user if the user wants to calculate another ellipse, if the user answers no
			 * then the program ends, otherwise it starts again from the beginning asking for values so another 
			 * ellipse can be calculated, this will continue until the user decides to stop */
			
			System.out.println("Do you want to go again?\nEnter Yes or No");
			
			//If the user answers no, then the program ends, else it starts again from the beginning to the while loop
			
			String cont = input.next();
			if(cont.equals("No") || cont.equals("no")) {
				input.close();
				break;
			}
			if(cont.equals("Yes") || cont.equals("yes"))
				System.out.println("Is this Ellipse centered at the origin?\nEnter Yes or No");
		} //end of while loop
	} //end of main method
} //end of Ellipse_Calculator class

/* Below is the class that defines the ellipse object, there are many data fields, there are 4 ints for the a, b, h and k
 * values of a ellipse. The c value is stored in a double because the c value is obtained by finding the root of the sums
 * of a² and b², which is more often than not, not a perfect square and thus resulting in a long decimal value. After that
 * there are boolean values for whether or not the ellipse is centered at the origin, and if the x² comes first in the 
 * equation, these are useful for knowing which form of the equation to use as there is a field for the equation of the 
 * ellipse which can be obtained with a getter method, similarly there are fields for coordinates of the vertices, foci, 
 * and center, and fields for the major and minor axes of the ellipse. All these values can also be obtained with getter 
 * methods, though some of them are assigned their values within the constructors rather than in their respective getter
 * methods. There are two constructors, the first is simply called with the a², b² and aUnderX values if the ellipse is
 * centered at the origin, otherwise its shifted, and in that case the second constructor is called with the same values and two
 * addition values, h and k which represent the horizontal and vertical shifts respectively. Lastly, there is a custom toString
 * method which returns a String containing all the relevant information obtained after all the properties of the ellipse
 * have been computed in the constructor(s). */ 


class Ellipse { 
	private int majorAxis; //int that stores the value of the major axis of an ellipse
	private int minorAxis; //int that stores the value of the minor axis of an ellipse
	private int a, b; //ints that store the a and b values of an ellipse
	private int h = 0, k = 0; //ints that store the h and k values of an ellipse, h and k are 0 when the ellipse is shifted
	private double c; //double for the c value, because c is often a double because its the root of the difference of a² and b²
	private boolean aUnderX; //boolean to check if a is under x or not, if it is then its vertical
	private boolean isCentered; //boolean to check if the ellipse is centered at the origin
	private String equation; //holds the final equation of the ellipse
	private String center; //holds a String containing the coordinates of the center of the ellipse
	private String vertices; //holds a String containing the vertices of the ellipse
	private String foci; //holds a String containing the coordinates of the foci of the ellipse
	
	
	//constructor for an ellipse centered at the origin
	public Ellipse(int aSquared, int bSquared, boolean aUnderX) { //takes in the values of the 2 denominators
	
		//the denominators of x² and y² in an ellipse are a² and b², their roots are appropriately being assigned to the a and b fields
		a = (int) Math.sqrt(aSquared); 
		b = (int) Math.sqrt(bSquared);
		
		/* an ellipse has 2 diameters, one is longer than the other, the longer is called the major axis, and is found by
		 * multiplying 2 to the value of a. The shorter diameter is called the minor ellipse and is calculated by multiplying
		 * 2 to the b value of the ellipse. Thus 2*a and 2*b are being assigned to the fields that hold the values of the major
		 * and minor axes of the ellipse */
		
		majorAxis = (int) (2 * a);
		minorAxis = (int) (2 * b);
		
		this.aUnderX = aUnderX; //assigns the value of the boolean aUnderX to the aUnderX field of the ellipse

		//finding c which is the distance from the center to the foci
		//the equation is c² = a² - b²
		c = Math.sqrt((aSquared-bSquared));
		
		center = "(0,0)"; //since this is a centered ellipse, the center is (0,0)
		
		isCentered = true; //assigns true to isCentered because the ellipse is centered
		
		/* The following if-statement checks if aUnderX is true, then the ellipse is horizontal, so an equation is built and assigned 
		 * to the string that holds the equation, the equation is in the form: x²/a² + y²/b² = 1. If aUnderX is false, then the ellipse 
		 * is vertical and it means the value of a² is under y² as opposed to x², that means the equation comes in the form: y²/a² + x²/b² = 1. */
		
		if (this.aUnderX == true) 
			equation = "x²/" + aSquared + " + y²/" + bSquared + " = 1"; 
		
		//this executes if aUnderX is false
		else equation = "y²/" + aSquared + " + x²/" + bSquared + " = 1";
		
	} //end of constructor
	
	
	/* this is the constructor for an ellipse not centered at the origin, this constructor does the same as the previous constructor
	 * except that it also takes two new values as parameters, h and k, h and k represent the horizontal and vertical shifts from
	 * the origin, in the constructor they are assigned to the private h and k fields of this ellipse class. Aside from this difference
	 * the constructor does everything else the previous constructor does. Though there is a slight difference when building the equation
	 * because in a shifted ellipse, the form of the equation of the ellipse is in the form (x-h)²/a² + (y-k)²/b² which is also taken care
	 * of in the constructor. */
	
	public Ellipse(int aSquared, int bSquared, int h, int k, boolean aUnderX) {
		
		a = (int) Math.sqrt(aSquared);
		b = (int) Math.sqrt(bSquared);
		
		c = Math.sqrt((aSquared-bSquared));
		
		this.h = h; //for a horizontal shift, in the equation, x is subtracted by h
		this.k = k; //for a vertical shift, in the equation, y is subtracted by k
		
		majorAxis = (int) (2 * a); //major axis of an ellipse is calculated by multiplying a by 2
		minorAxis = (int) (2 * b); //minor axis of an ellipse is calculated by multiplying b by 2
		
		this.aUnderX = aUnderX;
		
		isCentered = false; //since the ellipse is shifted, it is not centered at the origin, this isCentered is set to false
		
		/* coordinates of the center as it is shifted from the origin, the horizontal and vertical translations are subtracted 
		 * from the x and y values just like in the equation, x and y are originally both 0. Coordinates of the center are in 
		 * the form (h,k) */
		
		center = "(" + (0 - h) + "," +  (0 - k) + ")";
		
		/* The following if-statement checks if aUnderX is true, then the ellipse is horizontal, so an equation is built and assigned 
		 * to the string that holds the equation, the equation is in the form: (x-h)²/a² + (y-k)²/b² = 1. If aUnderX is false, then the 
		 * ellipse is vertical and it means the value of a² is under y² as opposed to x², that means the equation comes in the form: 
		 * (y-k)²/a² + (x-h)²/b² = 1. */
		
		if (aUnderX == true)
			equation = "(x - " + h + ")²/" + aSquared + " + (y - " + k + ")²/" + bSquared + " = 1";
		
		else equation = "(y - " + k + ")²/" + aSquared + " + (x - " + h + ")²/" + bSquared + " = 1";
		
	}
	
	//getter methods
	
	//returns the final equation after all the calculation in the constructor(s)
	public String getEquation() {return equation;} 
	
	//returns the major axis after all the calculation in the constructor(s)
	public int getMajorAxis() {return majorAxis;}
	
	//returns the minor axis after all the calculation in the constructor(s)
	public int getMinorAxis() {return minorAxis;}
	
	//returns whether or not the ellipse is centered at the origin, true if it is centered, false if isn't 
	public boolean isCentered() {return isCentered;}
	
	//returns the value of aUnderX, if aUnderX is true then a² is under x² or (x-h)² and it's horizontal
	public boolean isHorizontal() {return aUnderX;}
	
	//returns the value of aUnderX, if aUnderX is false then a² is under y² or (y-k)² then it's vertical
	public boolean isVertical() {
		if (aUnderX == false) return true;
		else return false;
	}
	
	//returns the coordinates of the center which are in the form (0,0) if the ellipse is centered and (h,k) if not
	public String getCenter() {return center;}
	
	//returns the vertices of the ellipse which are the coordinates of the endpoints of the major axis
	public String getVertices() {
		//in a horizontal ellipse, the coordinates are (h +/- a, k)
		if (aUnderX == true) {
			vertices = "(" + (0 - h + a) + "," +  (0 - k) + ")";
			vertices += ",(" + (0 - h - a) + "," +  (0 - k) + ")";
			return vertices;
		}
		/* in a vertical ellipse, the coordinates are (h, k +/- a), in this program, a is still stored in b
		 * even though technically it should be a, hence why the value is being subtracted/added by b */
		
		else {
			vertices = "(" + (0 - h) + "," +  (0 - k + a) + ")";
			vertices += "(" + (0 - h) + "," +  (0 - k - a) + ")";
			return vertices;
		}
	}
	
	
	/* the coordinates are obtained similarly as the vertices, except a and b are replaced by c
	 * depending on whether or not it is a horizontal or vertical eclipse, the foci is (h +/- c, k)
	 * if it is horizontal and (h, k +/- c) if it is vertical */
	
	public String getFoci() {
		//foci if horizontal
		if (aUnderX == true) {
			foci = "(" + (0 - h + c) + "," +  (0 - k) + ")";
			foci += ",(" + (0 - h - c) + "," +  (0 - k) + ")";
			return foci;
		}
		//foci if vertical
		else {
			foci = "(" + (0 - h) + "," +  (0 - k + c) + ")";
			foci += "(" + (0 - h) + "," +  (0 - k - c) + ")";
			return foci;
		}
	}
	
	
	/* toString method which returns the equation, center, foci, vertices, major and minor axes, a, b and c values, 
	 * whether or not it's centered at the origin, or if it's vertical or horizontal ellipse and the specifics of
	 * how many units it is shifted if it is shifted.*/
	
	public String toString() {
		String ellipse = "The equation of the ellipse is: " + equation
			+ "\nThe coordinates of the center are: " + getCenter() 
			+ "\nThe coordinates of the foci are: " + getFoci()
			+ "\nThe coordinates of the vertices are: " + getVertices()
			+ "\nThe major axis is: " + majorAxis
			+ "\nThe minor axis is: " + minorAxis
			+ "\nThe a, b and c values are: a = " + a + ", b = " + b + ", c = " + c;
		
		if (aUnderX == true)
			ellipse += "\nThis is a vertical ellipse";
		else ellipse += "\nThis is a horizontal ellipse";
		
		if (isCentered == false) 
			if(h < 0)
				ellipse += "\nThe ellipse has a horizontal shift of " + (h * -1) + " units to the right";
			else ellipse += "\nThe ellipse has a horizontal shift of " + h + " units to the left";
			if(k < 0)
				ellipse += "\nThe ellipse has a vertical shift of " + (k * -1) + " units up";
			else ellipse += "\nThe ellipse has a vertical shift of " + k + " units down";
		
		return ellipse;
	}
} //end of the ellipse class, and of this project