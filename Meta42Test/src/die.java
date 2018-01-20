import java.util.Arrays;
import java.util.Random;

public class die {
	
	//properties of a die
	int[] faces;
	float winPercentage;
	static int wins;
	static int losses;
	
	//standard constructors
	
	public die(int[] facesIn) {
		faces = facesIn;
		wins = 0;
		losses = 0;
		winPercentage = (float)100*wins/(wins+losses);
	}
	public die() {
		faces = null;
		wins = 0;
		losses = 0;
		winPercentage = (float)100*wins/(wins+losses);
	}
//**********************************************************************************************
	//updates win percentage
	public void addWinPercentage(float winPercentageIn){
		this.winPercentage = winPercentageIn;
	}
	
	public void addFaces(int[] facesIn) {
		this.faces = facesIn;
	}
	
	//returns int that represents face up side of rolled die
	public int roll() {
		Random rand = new Random();
		Integer roll = this.faces[rand.nextInt(faces.length)];
		return roll;
	}
	
	@Override
	public String toString() {
		return "Faces: " + Arrays.toString(faces) + " Win percentage: " + winPercentage;
	}
}
