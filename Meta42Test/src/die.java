import java.util.Arrays;
import java.util.Random;

public class die {
	
	//properties of a die
	int[] faces;
	float winPercentage;
	int wins;
	int losses;
	
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
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		if(!(obj instanceof die)) {
			return false;
		}
		
		die d = (die)obj;
		
		Arrays.sort(this.faces);
		Arrays.sort(d.faces);
		
		for(int i = 0; i < d.faces.length; i++) {
			if(d.faces[i] != this.faces[i]) {
				return false;
			}
		}
		
		return true;
	}
}
