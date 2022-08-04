import java.util.Random;

public class Population {

	private Particle[] town;//population
	private Particle[] velocity;//velocity
	private Particle[] personalB;//persoal best
	private Particle globalB;//global best
	private double[] fitnessV;//fitnnes values
	
	
	//initialize the population
	Population(int size){
		town= new Particle[size];
		velocity=new Particle[size];
		personalB=new Particle[size];
		globalB=new Particle(0);
		fitnessV=new double[size];
		Random rand_val=new Random();
		double random_number=rand_val.nextDouble(1);
		for(int i=0; i<town.length;i++) {
			personalB[i]=new Particle();
			town[i]=new Particle();
			velocity[i]=new Particle(0);
			random_number=rand_val.nextDouble(1);//ramdon number for each particule
			setFirstVelocity(random_number,i);//inicial velocy
			fitnessV[i]=999999999;
		}
		conVT();//add the velocity to the particule
		setFitnees();
		selectBestFitnees();
		setBestParticalPosition();
		//selectPersonalBest();
		//System.out.println("la velocidad es "+random_number);
	}
	
	public void selectPersonalBest() {
		for(int i=0;i<town.length;i++) {
			
			if(fitnessV[i]>town[i].fitness()) {
				
				//that means tha the current posion is the best in his life so we add to the record
				personalB[i].set_value(0, town[i].getValue(0));
				personalB[i].set_value(1, town[i].getValue(1));
				personalB[i].set_value(2, town[i].getValue(2));
				fitnessV[i]=town[i].fitness();
			}
			
		}
		
	}

	public void setBestParticalPosition() {
		for(int i=0;i<town.length;i++) {
			personalB[i].set_value(0, town[i].getValue(0));
			personalB[i].set_value(1, town[i].getValue(1));
			personalB[i].set_value(2, town[i].getValue(2));
		}
		
	}

	public void conVT() {
		//add the velocity to the position
		
		for(int i=0;i<town.length;i++) {
			town[i].set_value(0,  (town[i].getValue(0)+  velocity[i].getValue(0)));//we add the velocy to the current position
			town[i].set_value(1,  (town[i].getValue(1)+  velocity[i].getValue(1)));//we add the velocy to the current position
			town[i].set_value(2,  (town[i].getValue(2)+  velocity[i].getValue(2)));//we add the velocy to the current position
			
		}	
	}
	private void setFirstVelocity(double random_number, int index) {
		double aux=0;
		for(int i=0;i<3;i++) {
			
			aux=town[index].getValue(i) * random_number;
			velocity[index].set_value(i, aux);
			
			town[index].set_value(i,(aux+town[index].getValue(i)) );
			
		}
	}

	public void setFitnees() {
		//evaluate all the partiples and set the fitnnes int the fitnessArray
		for(int i=0;i<fitnessV.length;i++) {

			fitnessV[i]=town[i].fitness();
		}
		selectBestFitnees();
		
	}
	private void selectBestFitnees() {
		
		//only for the fisrt run
		double fitness=99999999;
		int index=0;
		for(int i=0;i<town.length;i++)
			{
				if(fitness>fitnessV[i]) {//cheack who is the best fitness
					index=i;
					fitness=fitnessV[i];
				}
			}
		//put the global best in the gbest
		globalB.set_value(0, town[index].getValue(0));   
		globalB.set_value(1, town[index].getValue(1));   
		globalB.set_value(2, town[index].getValue(2));   
		
		
	}
	public void selectFitenessGobla() {
		//lokking for the new fitness global best
		double fitnesObjet=globalB.fitness();
		
		for(int i=0;i<town.length;i++) {
			if(fitnesObjet>=town[i].fitness()) {
				//System.out.println("entra con "+fitnesObjet +" y menor que "+town[i].fitness());
				globalB.set_value(0, town[i].getValue(0));   
				globalB.set_value(1, town[i].getValue(1));   
				globalB.set_value(2, town[i].getValue(2));  
				fitnesObjet=town[i].fitness();
			}
		}
		
	}

	public void calculateVelocity(double w,double c1,double c2) {
		double newVelocity=0;
		Random r=new Random();
		double randomV=r.nextDouble(1);
		for(int i=0;i<town.length;i++) {
			//System.out.println("primero intento");
			//velocity[i].printParticle();
			for(int x=0;x<3;x++) {
				newVelocity=(w* velocity[i].getValue(x)) + c1* randomV * (personalB[i].getValue(x)-town[i].getValue(x)) +c2*randomV *(globalB.getValue(x)-town[i].getValue(x));
				velocity[i].set_value(x, newVelocity);//udpate the velocity
			}
			//System.out.println("Salida");
			//velocity[i].printParticle();
		}
	}

	public double getFitnessG() {
		return globalB.fitness();
	}
	
	//only print methods
	public void printVelocity() {
		//print all the popultation
		for(int i=0;i<velocity.length;i++) {
			System.out.print("velocity "+i);
			velocity[i].printParticle();
			
		}
	
	}
	public void printPopulation() {
		//print all the popultation
		for(int i=0;i<town.length;i++) {
			System.out.print("Particle "+i);
			town[i].printParticle();
			System.out.println("The fitnnes value is "+ String.format("%.2f", town[i].fitness()));
			
		}
	}
	public void printGlobalB() {
		System.out.println("The gBest "+String.format("%.2f",globalB.getValue(0))+", "+String.format("%.2f",globalB.getValue(1))+", "+String.format("%.2f",globalB.getValue(2)));
		System.out.println("The fitnnes value is "+ String.format("%.2f", globalB.fitness()));
	}
}