import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class dieProblem {
	//List of die(faces and winning percentage) with winning percentages over 50%
	static ArrayList<die> winnerList = new ArrayList<>();
	//creates standardDie and yourDie
	final static int[] standardFaces = {1,2,3,4,5,6};
	static die standardDie = new die(standardFaces);
	static die yourDie = new die();
	
	//mainMethod 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to create your own die. Enter 2 for random example dice: ");
		int choice = sc.nextInt();

		if (choice ==1) {
			createDieandCheck21();
		}
		else if(choice == 2) {
			theGame();

			//prints winnerList
			for(int i = 0; i < winnerList.size(); i++) {
				int[] temp = winnerList.get(i).faces;
				Arrays.sort(temp);
				
				//want to implement sorting the sorted arrays after learning more about comparator and maps
				System.out.println(winnerList.get(i).toString());
			}
			
			sc.close();
		}
	}
	//Helper Methods***************************************************************************
	public static void createDieandCheck21() {
		Scanner sc = new Scanner(System.in);
		int[] yourFaces = new int[6];

		int facesSum = 0;
		//reads in and populates array of die facs that add to 21
		while(facesSum != 21) {
			System.out.println("Enter 6 numbers that add to 21: ");
			for(int i = 0; i < 6; i++) {
				yourFaces[i] = sc.nextInt();
				facesSum+=yourFaces[i];
			}
			if(facesSum != 21) {
				System.out.println("That doesn't equal 21 dipshit.");
			}
		}
		//adds your faces to yourDie object
		yourDie.addFaces(yourFaces);
		sc.close();

		if(validDie(yourDie) == true) {
			System.out.println("Valid");
			System.out.println(Arrays.toString(yourDie.faces));
			System.out.println("Win percentage: "+ (float)(yourDie.wins)/(yourDie.wins+yourDie.losses));
		}
		else {
			System.out.println("Nope");
			System.out.println(Arrays.toString(yourDie.faces));
			System.out.println("Win percentage: "+ yourDie.winPercentage);
		}
	}
	//checks to see if yourDie wins > 50% of time-----------------------------------------------
	public static boolean validDie(die dieIn) {

		int timesRolled = 1000000;

		for(int i = 0; i < timesRolled; i++) {
			int standardRoll = standardDie.roll();
			int yourRoll = dieIn.roll();

			if(yourRoll > standardRoll) {
				dieIn.wins++;
			}
			else if(yourRoll < standardRoll) {
				dieIn.losses++;
			}
		}

		if(dieIn.wins > dieIn.losses) {
			return true;
		}
		else {
			return false;
		}
	}

	//randomly creates dice and checks if they win > 50% of time-------------------------------
	public static void theGame() {
		int numDice = 1000;
		int numRolls = 1000;

		//generates numDice dice with randomized faces that add to 21
		for(int i = 0; i < numDice; i++) {

			die randomDie = new die(genNumbers(6,21));

			//rolls randomized die numRolls times and compares to standard
			for(int j = 0; j < numRolls; j++) {
				int randomRoll = randomDie.roll();
				int standardRoll = standardDie.roll();
				//counts wins and losses
				if(randomRoll > standardRoll) {
					randomDie.wins++;
				}
				else if(randomRoll < standardRoll) {
					randomDie.losses++;
				}
			}
			//Creates die object, adds to winnerList
			if(randomDie.wins > randomDie.losses) {
				winnerList.add(randomDie);
			}
		}
	}

	//generates n random numbers that add to a fixed number sum sum
	public static int[] genNumbers(int n, int sum){
		int[] nums = new int[n];
		int upperbound = Long.valueOf(Math.round(sum*1.0/n)).intValue();
		int offset = Long.valueOf(Math.round(0.5*upperbound)).intValue();

		int cursum = 0;
		Random random = new Random(new Random().nextInt());
		for(int i=0 ; i < n ; i++){
			int rand = random.nextInt(upperbound) + offset;
			if( cursum + rand > sum || i == n - 1) {
				rand = sum - cursum;
			}
			cursum += rand;
			nums[i]=rand;
			if(cursum == sum){
				break;
			}
		}
		return nums;
	}
	
}
