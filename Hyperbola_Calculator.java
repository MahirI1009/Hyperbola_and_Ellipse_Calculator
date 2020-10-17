import java.util.Scanner;

/* A hyperbola is a conic section from Mathematics. A hyperbola comes in the standard form of x²/a² - y²/b² = 1.
 * However, the graph of the hyperbola can change based on the values of x, y, a and b. A hyperbola in standard form
 * is horizontal and centered at the origin (0,0). A hyperbola can become vertical in the case that y² and x² swap 
 * places in the equation. A hyperbola is can be horizontally and/or vertically shifted from the origin, when this 
 * happens the hyperbola comes in the form (x-h)²/a² - (y-k)²/b² = 1, with h and k representing the shifts from the
 * x and y axes respectively. The graphs of hyperbolas have many properties such as the vertices, the foci and the 
 * asymptotes. This program asks the user whether for the a² and b² values of the hyperbola, it also asks for the 
 * h and k values if the user specifies that the hyperbola is not centered at the origin. I have created a hyperbola
 * class for this program, it contains two constructors, one for if the hyperbola is centered at the origin and one if
 * it isn't. The program lastly asks if the x² comes for in the equation or not, so as to know whether or not the 
 * hyperbola is vertical or not. Then a hyperbola object is instantiated with the x and y values and a boolean value
 * that is set to true if x² comes first in the equation. The hyperbola is instantiated with a different constructor
 * that also sends the h and k values as parameters if the hyperbola is shifted from the origin. Once this is done, 
 * the custom toString method of the hyperbola class is called which then prints all the relevant information such as the
 * coordinates of the vertices, foci and the center, as well the equation of the asymptotes and the equation of the 
 * hyperbola itself using getter methods. Then the program asks the user if they want to calculate another hyperbola,
 * if they say yes, then this whole process repeats, otherwise the program ends. */

public class Hyperbola_Calculator {

	public static void main(String[] args) {
		
		//Scanner for input from the keyboard
		Scanner input = new Scanner(System.in);
		
		Hyperbola hyperbola = null; //creates an empty hyperbola
		
		//asks user for input
		System.out.println("Is this Hyperbola centered at the origin?\nEnter Yes or No");
		
		while (input.hasNext()) {
			
			int aSquared, bSquared; //these two ints will hold the a² and b² values of the hyperbola
			boolean xFirst;
			
			/* origin is a String that takes input from the keyboard, it asks if the hyperbola
			 * is centered at the origin or not, if the answer is yes, then the following executes: */
			
			String origin = input.next();
			
			/* String opens is a string that will hold a String that will be input by the user, the following
			 * if-statements contain that will prompt the user to do so. It will ask if x² comes first or not
			 * so as to know whether the hyperbola is horizontal or not. The user will answer with "yes" or 
			 * "no" and based on this answer the boolean variable xFirst will be set to true or false. */
			
			String opens;
			
			if(origin.equals("Yes") || origin.equals("yes")) {
				
				//before recieving the values of a² and b², the program asks whether or not x² comes first int the equation
				System.out.println("Does x² come first?");
				
				/* opens is just a String to hold the answer to the question, that being yes or no,
				 * in the case that the answer is yes, then the boolean variable "xFirst" declared 
				 * immediately after the String opens is set to true, otherwise it is set to false.
				 * Then the constructor is called with the aSuared, ySquared and boolean variable 
				 * xFirst assent as parameters. */
				
				/* the reason for the xFirst variable is that in the Hyperbola class there is a data
				 * field for the equation of the hyperbola, if y² comes first it will create the eq-
				 * uation in the appropriate format. y² being first is also important as then whether
				 * or not the hyperbola is vertical will be known. */
				
				opens = input.next();
				if (opens.equals("Yes") || opens.equals("yes"))
					xFirst = true;
				
				/* This else statement executes if the user enters no when asked if x² comes first in the equation.
				 * This means that y² comes first instead and that a² is under y² as opposed to x² and thus asks 
				 * for the value under y² first which would be a². */
				
				else xFirst = false;
				
				System.out.println("Enter the value for a²");
			    aSquared = input.nextInt();
				
				System.out.println("Enter the value for b²");
				bSquared = input.nextInt();
				
				//instantiates a hyperbola centered at the origin with the given a², b² and xFirst values using the appropriate constructor
				hyperbola = new Hyperbola(aSquared, bSquared, xFirst); 
				
			}
			 
			/* If the user answers "no", meaning that the hyperbola is shifted, the following code does the same as if
			 * the user answered "yes", except that now it also asks for the h and k values so that the vertical and
			 * horizontal shifts can be taken into account. Just like previous if statement, it also asks if x² comes
			 * first or not. */

			if(origin.equals("No") || origin.equals("no")) {
				
				System.out.println("Does x² come first?");
				
				opens = input.next(); //opens does the same as in the previous if statement
				
				int h, k; //h and k represent the horizontal and vertical shifts respectively in the equation of the hyperbola
				
				//if the user answers yes, then x² comes first and the following if-statement executes:
				if (opens.equals("Yes") || opens.equals("yes")) 
					xFirst = true;
				
				//if the user answers no, then y² comes first and the following else-statment executes:
				else xFirst = false;
				
				//after the value is assigned to xFirst the user will be asked to input the a², b², h and k values
				
				System.out.println("Enter the value for a²");
				aSquared = input.nextInt();
				
				System.out.println("Enter the value for b²");
				bSquared = input.nextInt();
				
				System.out.println("Enter the value for h");
				h = input.nextInt();
				
				System.out.println("Enter the value for k");
				k = input.nextInt();
				
				
				/* now a hyperbola is instantiated using the constructor for hyperbolas that are
				 * shifted from the origin, it is like the previous constructor except that it 
				 * also sends the h and k values as parameters */
				
				hyperbola = new Hyperbola(aSquared, bSquared, h, k, xFirst); 
			}
			
			//after the constructor is called and the hyperbola object is instantiated, the following executes:
			
			/*the custom toString method is called which returns a String containing all the relevant info which
			 * includes coordinates of the vertices, foci and center, as well the equations of the asymptotes and
			 * the hyperbola itself */
			
			System.out.println(hyperbola.toString()); 
			
			/* now it asks the user if the user wants to calculate another hyperbola, if the user answers no
			 * then the program ends, otherwise it starts again from the beginning asking for values so another 
			 * hyperbola can be calculated, this will continue until the user decides to stop */
			
			System.out.println("\nDo you want to calculate another hyperbola?\nEnter Yes or No");
			
			// If the user answers no, then the program ends, else it starts again from the beginning to the while loop
	
			String cont = input.next();
			if(cont.equals("No") || cont.equals("no"))  {
				input.close();
				break;
			}
			if(cont.equals("Yes") || cont.equals("yes"))
				System.out.println("Is this Hyperbola centered at the origin?\nEnter Yes or No");
			
		} //end of while loop
	} //end of main method
} //end of Hyper_Calculator class

/* Below is the class that defines the Hyperbola object, there are many data fields, there are 4 ints for the a, b, h and k
 * values of a hyperbola. The c value is stored in a double because the c value is obtained by finding the root of the sums
 * of a² and b², which is more often than not, not a perfect square and thus resulting in a long decimal value. After that
 * there are boolean values for whether or not the hyperbola is centered at the origin, and if the x² comes first in the 
 * equation, these are useful for knowing which form of the equation to use as there is a filed for the equation of the 
 * hyperbola which can be obtained with a getter method, similarly there are fields for coordinated of the vertices, foci, 
 * and center, and lastly a field for the equation of the asymptotes. All these values can also be obtained with getter 
 * methods, though some of them are assigned their values within the constructors rather than in their respective getter
 * merhods. There are two constructors, the first is simply called with the a², b² and xFirst values if the hypebola is
 * centered at the origin, otherwise its shifted, and in that the second constructor is called with the same values and two
 * addition values h and k which represent the horizontal and vertical shifts respectively. Lastly, there is a custom toString
 * method which returns a String containing all the relevant information obtained after all the properties of the hyperbola
 * have been determined. */ 



class Hyperbola { 
	private int a, b; //ints for the a and b values of a hyperbola
	private int h = 0, k = 0; //ints that store the h and k values of a hyperbola, h and k are 0 when the hyperbola isn't shifted
	private double c; //double for the c value because c will often be a root 
	private boolean xFirst; //boolean to check if x² is first or not, if it the hyperbola is horizontal
	private boolean isCentered; //boolean to check if the hyperbola is centered at the origin
	private String equation; //holds the final equation of the hyperbola
	private String center; //holds a String containing the coordinates of the center of the hyperbola
	private String vertices; //holds a String containing the vertices of the hyperbola
	private String foci; //holds a String containing the coordinates of the foci of the hyperbola
	private String asymptotes; 
	
	
	//constructor for an hyperbola centered at the origin
	
	public Hyperbola(int aSquared, int bSquared, boolean xFirst) { //takes in the values of the 2 denominators
		this.xFirst = xFirst;
		
		/* the denominators of x² and y² in a hyperbola are a² and b², so the square root of them are 
		 * assigned to the a and b fields */
		this.a = (int) Math.sqrt(aSquared); 
		this.b = (int) Math.sqrt(bSquared);
		
		/*finding c which is the distance from the center to the foci, the equation is c² = a²  + b² 
		 * thus c is the square root of the sum of a² and b² */
		c = Math.sqrt((aSquared+bSquared));
		
		center = "(0,0)"; //since this is a centered hyperbola, the center is (0,0)
		
		isCentered = true; //assigns true to isCentered because the hyperbola is not shifted 
		
		//the following if-else statement is to build the equation of the hyperbola with the a² and b² values
		
		//if xFirst is true, the hyperbola is horizontal, and the following executes:
		if (xFirst == true)
			//String for the final equation of the hyperbola which is in the form x²/a² - y²/b² = 1
			equation = "x²/" + aSquared + " - y²/" + bSquared + " = 1"; 
		
		//this executes if xFirst is false:
		else 
			/* does the same as the previous if statement, but since xFirst is false, the hyperbola is vertical
			 * so the form of the equation for a vertical hyperbola is assigned to the private "equation" field 
			 * instead. */
			
			//String for the final equation of the hyperbola which is in the form y²/a² - x²/b² = 1
			equation = "y²/" + aSquared + " - x²/" + bSquared + " = 1"; 
	}
	
	
	/* this is the constructor for a hyperbola that is not centered at the origin, it does the same as the previous 
	 * constructor except that it has 2 new parameters h and k for the vertical and horizontal shifts from the center*/

	public Hyperbola(int aSquared, int bSquared, int h, int k, boolean xFirst) {
		this.a = (int) Math.sqrt(aSquared);
		this.b = (int) Math.sqrt(bSquared);
		this.h = h; //for h, in the equation, x is subtracted by h which represents the horizontal shift
		this.k = k; //for k, in the equation, y is subtracted by k which represented the vertical shift		
		this.xFirst = xFirst;
		
		c = Math.sqrt((aSquared+bSquared));
		
		center = "(" + (0-h) + "," +  (0-k) + ")"; //the coordinates of the center are in the form (h,k)
		
		isCentered = false; //since the hyperbola is shifted, it is not centered at the origin, thus isCentered is set to false
		
		//the following if-else statement is to build the equation of the hyperbola with the a², b², h and k values
		
		if (xFirst == true) {
			
			/* String for the final equation of the hyperbola which is in the form (x-h)²/a² - (y-k)²/b² = 1,
			 * the reason for all the if statements is that in the case x or y is being added by a positive 
			 * number, then mathematically what is really happening is that they are being subtracted by a
			 * negative, when a number is subtracted by a negative, it is equivalent to adding as the two negatives
			 * cancel out, thus the if statements check if the h and k values are negatives to take this into
			 * consideration and put the equation in its appropriate final form. */
			
			if (h < 0 && k < 0)
				equation = "(x - " + (h * -1) + ")²/" + a + " - (y - " + (k * -1) + ")²/" + b + " = 1";
			
			else if (h < 0 && k > 0)
				equation = "(x - " + (h * -1) + ")²/" + a + " - (y + " + k + ")²/" + b + " = 1";
			
			else if (k < 0 && h > 0)
				equation = "(x + " + h + ")²/" + a + " - (y - " + (k * -1) + ")²/" + b + " = 1";
			
			else equation = "(x + " + h + ")²/" + a + " - (y + " + k + ")²/" + b + " = 1";
		}
		
		/* Just like in the previous constructor, this else statement executes if xFirst is false, which means the
		 * hyperbola is vertical, thus this does the same as the if statement except that it puts the equation in the
		 * proper form for a vertical hyperbola which is (y-k)²/a² - (x-h)²/b² = 1 */
		
		else {
			
			if (k < 0 && h < 0)
				equation = "(y - " + (k * -1) + ")²/" + a + " - (x - " + (h * -1) + ")²/" + b + " = 1";
			
			else if (k < 0 && h > 0)
				equation = "(y - " + (k * -1) + ")²/" + a + " - (x + " + h + ")²/" + b + " = 1";
			
			else if (h < 0 && k > 0)
				equation = "(y + " + k + ")²/" + a + " - (x - " + (h * -1) + ")²/" + b + " = 1";
			
			else equation = "(y + " + k + ")²/" + a + " - (x + " + h + ")²/" + b + " = 1";
		}
	}
	
	//getter methods
	
	//returns whether or not the hyperbola is centered at the origin 
	public boolean isCentered() {return isCentered;}
	
	//returns true if a² is under x², which would mean the hyperbola is horizontal
	public boolean isHorizontal() {return xFirst;}
	
	//returns true if a² is under y², which would mean the hyperbola is vertical
	public boolean isVertical() {
		if (xFirst == false) return true;
		else return false;
	}
	
	//returns the coordinates of the center
	public String getCenter() {return center;}
	
	//returns the vertices of the hyperbola which are the coordinates of the distance of a from the center
	public String getVertices() {
		//in a horizontal hyperbola, the coordinates are (h +/- a, k)
		if (xFirst == true) {
			vertices = "(" + (0 - h + a) + "," +  (0-k) + ")";
			vertices += ",(" + (0 - h - a) + "," +  (0-k) + ")";
			return vertices;
		}
		/*in a vertical hyperbola, the coordinates are (h, k +/- a), in this program, a is still stored in b
		even though technically it should be a, hence why the value is being subtracted/added by b*/
		else {
			vertices = "(" +(0-h) + "," +  (0 - k + a) + ")";
			vertices += "(" + (0-h) + "," +  (0 - k - a) + ")";
			return vertices;
		}
	}
	
	
	/*the coordinates are obtained similarly as the vertices, except a and b are replaced by c
	depending on whether or not it is a horizontal or vertical eclipse, the foci is (h +/- c, k)
	if it is horizontal and (h, k +/- c) if it is vertical */
	public String getFoci() {
		//foci if horizontal
		if (xFirst == true) {
			foci = "(" + (0 - h + c) + "," + (0-k) + ")";
			foci += ",(" + (0 - h - c) + "," + (0-k) + ")";
			return foci;
		}
		//foci if vertical
		else {
			foci = "(" + (0-h) + "," +  (0 - k + c) + ")";
			foci += "(" + (0-h) + "," +  (0 - k - c) + ")";
			return foci;
		}
	}
	
	/* this method returns the asymbotes in point-slope formula, it is in the form "y = ±(b/a)x" for a hyperbola
	 * centered at the origin, and in the form "y-k = ±(b/a)(x-h)", in a vertical hyperbola, the value of m (which
	 * is the slope, in the standard formula it is the "b/a" value) is flipped, and m is a/b instead of b/a, the if
	 * statements take this into consideration and build the String containing the asymptotes accordingly. */
	
	public String getAsymptotes() {
		if (isCentered == true && xFirst == true) 
			asymptotes = ("y = ±(" + b + "/" + a + ")x");
		
		else if (isCentered == true && xFirst == false) 
			asymptotes = ("y = ±(" + a + "/" + b + ")x");
		
		else if (isCentered == false && xFirst == true && h < 0 && k < 0) 
			asymptotes = ("y+" + k + " = ±(" + b + "/" + a + ")(x+" + h + ")");
		
		else if (isCentered == false && xFirst == true && h < 0 && k > 0) 
			asymptotes = ("y+" + k + " = ±(" + b + "/" + a + ")(x" + h + ")");
		
		else if (isCentered == false && xFirst == true && h > 0 && k < 0) 
			asymptotes = ("y" + k + " = ±(" + b + "/" + a + ")(x+" + h + ")");
		
		else 
			asymptotes = ("y" + k + " = ±(" + a + "/" + b + ")(x" + h + ")");
	
		return asymptotes;
	}
	
	//returns the final equation after all the computation in the constructor(s)
		public String getEquation() {return equation;} 
	
	/*toString method which returns the equation, coordinates of the center, foci, vertices, the a, b and c values, 
	 * whether or not it's centered at the origin, or if it's vertical or horizontal hyperbola and the specifics of
	 * how many units it is shifted, if it is shifted.*/
		
	public String toString() {
		String hyperbola = "The equation of the hyperbola is: " + equation
			+ "\nThe coordinates of the center are: " + getCenter() 
			+ "\nThe coordinates of the foci are: " + getFoci()
			+ "\nThe coordinates of the vertices are: " + getVertices()
			+ "\nThe asymptotes are: " + getAsymptotes() 
			+ "\nThe a, b and c values are: a = " + a + ", b = " + b + ", c = " + c;
		
		if (xFirst == true)
			hyperbola += "\nThis hyperbola opens up and down";
		else hyperbola += "\nThis hyperbola opens left and right";
		
		/*this if statement is particularly for the horizontal and vertical shifts, it is multiplied by -1 if it is 
		 * less than 0 so it prints as a positive number, as it should "it is shifted h units to the right" as opposed
		 * to "it is shifted -h units to the right" */
		if (isCentered == false) 
			if(h < 0)
				hyperbola += "\nThe hyperbola has a horizontal shift of " + (h * -1) + " units to the right";
			else hyperbola += "\nThe hyperbola has a horizontal shift of " + h + " units to the left";
			if(k < 0)
				hyperbola += "\nThe hyperbola has a vertical shift of " + (k * -1) + " units up";
			else hyperbola += "\nThe hyperbola has a vertical shift of " + k + " units down";
		
		return hyperbola;
	}
} //end of the Hyperbola class, and end of this project.
