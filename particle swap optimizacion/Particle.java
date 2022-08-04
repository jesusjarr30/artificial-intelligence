import java.util.Random;

public class Particle {

	//for this proble we need the numbers
	private double[] values;//x1,x2,x3
	
	Particle(){

		Random rand_val=new Random();
		values= new double[3];
		for(int i=0;i<values.length;i++) {
			values[i]= rand_val.nextDouble(5);
		}
	}
	Particle(int vel){
		values= new double[3];
	}
	public void printParticle() {
		System.out.println(" x1: "+String.format("%.2f",values[0])+", x2: "+String.format("%.2f",values[1])+", x3:"+String.format("%.2f",values[2]));
	}

	public double getValue(int index) {
		return values[index];
	}
	public void set_value(int index,double aux) {
		values[index]=aux;
	}
	public double fitness() {
		double fit=0;
		//Formula 10 * (x1-1)^2 + 20 * (x2 - 2)^2 +30 * (x3 - 3)^2 
		fit=(10 * Math.pow((values[0] - 1),2)) + (20 * Math.pow((values[1] - 2),2)) +(30 *Math.pow((values[2] - 3),2));
		return fit;
	}
	
}
