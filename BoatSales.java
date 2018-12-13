/*This is a boat sales list, it calculates the cost of a listing of boats
	 *By Ethan O'Neill
	 *	12/12/2018 
	 */

    import java.text.*;
	import java.util.*;
	
public class BoatSales {
	//inputs data
	static String iString;
	static String iBoatType;
	static String iAccesType;
	static int iQty;
	static int AccessNum;

	static char inputAgain = 'Y';
	static Scanner myScanner;
	static NumberFormat nf;
	static double cBoatAmt;
	static double iPrepAmt;
	static double cAccessAmt;
	static double Per;
	
	//Ready for Calculations
	static double MarkUp;
	static double cSub;
	static double Tax;
	static double Total;
	//Read for Outputs
	static String oTotal;
	static String oTax;
	static String oSub;
	static String oMarkUp;
	static String oPrep;
	static String oBoatAmt;
	
public static void main(String[] args) {
		
		//call init
			init();
		//Self Note: Make sure to loop wiht 'Y'
			while (inputAgain=='Y') {
			//call input
			input();
			
			//call calculations
			calcs();
			
			//call output
			output();
			//Prompt for next receipt
			System.out.print("Would you like to Enter another receipt? Y or N: ");
			inputAgain = myScanner.next().toUpperCase().charAt(0);
			}
		
		System.out.println("Program Terminated, Have a good day, come back again!");
		
	}

public static void init() {
	//set scanner to the Console
	myScanner = new Scanner(System.in);
	
	//to allow spaces in strings
	myScanner.useDelimiter(System.getProperty("line.separator"));
	
	//set formatter to use U.S. currency format for $$
	nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
}
public static void input() {
	
	
	try {
	System.out.println("--- Enter Boat cost: ");
	iString = myScanner.next();
	cBoatAmt = Double.parseDouble(iString);
		}
	catch (Exception e) {
		System.out.println("Boat Amount NOT VALID, DEFAULT 25,000");
		cBoatAmt = 25000.00;
	}
	if (cBoatAmt <2500.00 || cBoatAmt > 150000.00) {
		//Boat Cost needs to be between $2,5000-150,000$
		
		cBoatAmt = 25000.00; 
		//Presetting Cost to $25000
		System.out.println(" Price needs to between $25,000.00 -$150,000.00, DEFAULT 25,000");
	}
	
	
	
	
	try {
	System.out.println("Enter Prep cost: ");
	iString = myScanner.next();
	iPrepAmt = Double.parseDouble(iString);
		}
	catch (Exception e) {
		System.out.println("Prep Cost NOT VALID, DEFAULT to 5,000");
		iPrepAmt = 5000.00;
	}
	if (iPrepAmt < 100.00 || iPrepAmt > 9999.99) {
		iPrepAmt = 5000.00;
		System.out.println("Prep Cost Choice NOT VALID, DEFAULT 100");
	}
	
	
	
	
	try {
	System.out.println("--- Enter Quanity '1 to 25' ");
	iString = myScanner.next();
	iQty = Integer.parseInt(iString);
	}
	catch (Exception e) {
		System.out.println("Quantity NOT VALID, choosing DEFAULT to '1' ");
		iQty = 1;
	}
	
	if (iQty < 1 || iQty > 25) {
		System.out.println("Choice NOT VALID, choosing DEFAULT '1' ");
		iQty = 1;
	}

	System.out.println("--- Enter Boat type  'B' - 'P'-  'S' - 'C'  :  ");
	iString = myScanner.next().toUpperCase();
	switch(iString) {
	case "B":
		iBoatType = "Bass";
		Per = 0.33;
		break;
	case "P":
		iBoatType = "Pontoon";
		Per = 0.25;
		break;
	case "S":
		iBoatType  = "Ski";
		Per = 0.425;
		break;
	case "C":
		iBoatType  = "Canoe";
		Per = 0.20;
		break;
	default:
		System.out.println("Boat Type is NOT VALID, DEFAULT to 'S' ");
		iBoatType  = "Ski";
		Per = 0.425;
		break;
	}
	try {
	System.out.println("--- Enter Boat Accesories Choices: ///  1 = electronics, 2  = ski package, 3 =  fishing package  :  ");
	iString = myScanner.next();
	AccessNum = Integer.parseInt(iString);
	}
	catch (Exception e) {
		System.out.println("Accessory is NOT VALID,  DEFAULT to  '1' ");
		AccessNum = 1;
		iAccesType = "Electronics";
		cAccessAmt = 5415.30	;
	}
	
	
	//Case Structure and Validation for Accesories Type
	try {
	switch (AccessNum) {
	case 1:
		cAccessAmt = 5415.30	;
		iAccesType = "Electronics";
		
		break;
	case 2:
		cAccessAmt = 3980.00;
		iAccesType = "Ski Package";
		
		break;
	case 3:
		cAccessAmt = 345.45;
		iAccesType = "Fishing Package";
		
		break;
	default:
		System.out.println("Choice is NOT VALID,  DEFAULT to'1' ");
		AccessNum = 1;
		cAccessAmt = 5415.30;
		iAccesType = "Electronics";
		
		break; //Getting/kicking out of the Case Structure
	}
		}
	catch (Exception e) {
		System.out.println("Choice is NOT VALID,  DEFAULT to '1' ");
		AccessNum = 1;
		iAccesType = "Electronics";
		 cAccessAmt = 5415.30	;
	}
		
}
public static void calcs() {
	
	
	//Calculations for Boat
	MarkUp = Per * cBoatAmt;
	cSub =    iPrepAmt+ cAccessAmt+ MarkUp + cBoatAmt * iQty;
	Tax = cSub * 0.06;
	Total = cSub + Tax;
	
}
public static void output() {
	//Rounding to .00
	MarkUp = Math.round(MarkUp);
	Tax = Math.round(Tax);
	
	
	
	
	
	// just decimal placements to 2 places
	oTotal = nf.format(Total);
	oTax = nf.format(Tax);
	oSub = nf.format(cSub); 
	oMarkUp = nf.format(MarkUp);
	oPrep = nf.format(iPrepAmt); 
	oBoatAmt = nf.format(cBoatAmt);

	
	
	
	
	
	
	//Print to UI!!!
	System.out.println("Boat Type is : " + iBoatType);
	System.out.println("Accesory is : " + iAccesType);
	System.out.println("Quantity is: " + iQty);
	System.out.println("Boat Cost is : " + oBoatAmt);
	System.out.println("Accesories Cost: " + String.format(Locale.US,"%.2f", cAccessAmt)) ;
	System.out.println("Prep Cost: " + oPrep);
	System.out.println("Mark Up Amount is: " + oMarkUp);
	System.out.println("Subtotal is : " + oSub);
	System.out.println("Tax is : " + oTax);
	System.out.println("Grand Total Amount is : " + oTotal);
	
 }

}
