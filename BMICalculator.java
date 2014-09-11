import java.util.Scanner;

public class BMICalculator {
	public static void main(String args[]) {
		int userChoice; 
		String userName;
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Welcome to Tamyres' BMI Calculator!");
		System.out.println("What is your name?");
		userName = kb.nextLine();
		
		do {
			System.out.println();
			System.out.println("Press 1 for BMI calculation in metric system.");
			System.out.println("Press 2 for BMI calculation in imperial system.");
			System.out.println("Press 0 to exit program.");
			System.out.println();
			
			userChoice = kb.nextInt();
			switch(userChoice) {
			case 1:
				metricCalculation(userName);
				break;
			case 2:
				imperialCalculation(userName);
				break;
			case 0:
				System.out.println(userName + ", thank you for using Tamyres' BMI Calculator!");
				System.out.println("Program exiting...");
				break;
			default:
				System.out.println(userName + ", that is not a valid option! Please try again.");
			}
		} while (userChoice != 0);
	}
	
	public static void metricCalculation(String userName) {
		double height; 
		double weight;
		double BMIvalue;
		boolean validValue;
		Scanner kb = new Scanner(System.in);
		
		do {
			System.out.println(userName + ", what is your height in meters? (minimum: 0.5, maximum: 3)");
			height = kb.nextDouble();
			if (height >= 0.5 && height <= 3.0) {
				validValue = true;
			}
			else {
				System.out.println("Your height needs to be between 0.5 and 3 meters! Please try again.");
				validValue = false;
			}
		} while (!validValue);
		
		do {
			System.out.println("What is your weight in kilograms? (minimum: 10, maximum: 300)");
			weight = kb.nextDouble();
			if (weight >= 10.0 && weight <= 300.0) {
				validValue = true;
			}
			else {
				System.out.println("Your weight needs to be between 10 and 300 kilograms! Please try again.");
				validValue = false;
			}
		} while (!validValue);

		//BMIvalue = weight/ (height*height);
		calculateBMIvalue(weight, height);
		displayBMIClassification(userName, BMIvalue);
	}
	
	public static void imperialCalculation(String userName) {
		double height; 
		double weight;
		double BMIvalue;
		boolean validValue;
		Scanner kb = new Scanner(System.in);
		
		do {
			System.out.println(userName + ", what is your height in inches? (minimum: 20, maximum: 120)");
			height = kb.nextDouble();
			if (height >= 20.0 && height <= 120.0) {
				validValue = true;
			}
			else {
				System.out.println("Your height needs to be between 20 and 120 inches! Please try again.");
				validValue = false;
			}
		} while (!validValue);
		
		do {
			System.out.println("What is your weight in pounds? (minimum: 22, maximum: 660)");
			weight = kb.nextDouble();
			if (weight >= 22.0 && weight <= 660.0) {
				validValue = true;
			}
			else {
				System.out.println("Your weight needs to be between 22 and 660 pounds! Please try again.");
				validValue = false;
			}
		} while (!validValue);

		BMIvalue = calculateBMIvalue(weight * 703, height);
		displayBMIClassification(userName, BMIvalue);
	}

	public static double calculateBMIvalue(double weight, double height) {
		double BMIvalue;
		BMIvalue = weight/ (height*height);
		return BMIvalue;
	}
	
	public static void displayBMIClassification(String userName, double BMIvalue) {
		System.out.printf("%s, your BMI is: %.2f. ", userName, BMIvalue);
		
		if (BMIvalue <= 18.4) {
			System.out.println("You are underweight and have risk of developing problems such as nutritional deficiency and osteoporosis");
		}
		else if (BMIvalue >= 18.5 && BMIvalue < 22.9) {
			System.out.println("You are on a normal weight range and have low Risk (healthy range).");
		}
		else if (BMIvalue >= 23.0 && BMIvalue < 27.4) {
			System.out.println("You are overweight and have moderate risk of developing heart disease, high blood pressure, stroke, diabetes.");
		}
		else if (BMIvalue >= 27.5) {
			System.out.println("You are obese and have high risk of developing heart disease, high blood pressure, stroke, diabetes");
		}	
	}
}
