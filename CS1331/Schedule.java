import java.util.Scanner;
/**
 *@Schedule
 *Takes in Course Info and Displays formatted Schedule with GPA
 */

public class Schedule {
    public static void main(String args[]){
	
	//Variables -
	//gpa and hours for calculating Weighted GPA
	//dataIn containing values to be input
	//dataOut to store the input
	//schedule to display a Formatted Course Schedule
	//scan to read the values the user enters
	
	double gpa = 0;
	String[] dataIn = new String[]{ "Name", "Building", "Room",
					"Hours", "Grade" };
	String[][] dataOut = new String[4][5];
	Scanner scan = new Scanner(System.in);
	String schedule = String.format("| %-10s | %-10s | %-10s | %-10s | %-10s | \n",
					"Course", dataIn[1], dataIn[2],
					dataIn[3], dataIn[4]);
	double hours = 0;
	
	//Taking in the 5 input values 4 times each
	for (int i = 0; i < 4; i++) {
	    int num = i+1;
	    for (int j = 0; j < 5; j++) {
		System.out.print("Enter Course " + num + " " +
				   dataIn[j] + " : ");
		dataOut[i][j] = scan.nextLine();
		schedule = schedule + String.format("| %10s ",
						    dataOut[i][j]);
	    }
	    System.out.print("\n");
	    schedule = schedule + "|\n";
	    
	    //Calculating GPA
	    hours= hours+Double.parseDouble(dataOut[i][3]);
	    gpa = gpa + Double.parseDouble(dataOut[i][3])
		*Double.parseDouble(dataOut[i][4]);
	}

	gpa=gpa/hours;
	
	//Display the formatted String schedule
	System.out.println(schedule);
	
	//Display GPA with 2 decimal point accuracy	
	System.out.printf("Calculated GPA : %1.2f%n", gpa);
}
}


