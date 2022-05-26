package PSO_p;

import java.util.Random;

public class Population {
	
	//iniciados en 10
	private double[][] particulas;
	
	
    private double[][] posPBest; //Position of PersonalBest of each Particle
    private double[] fitnessPBest; //Fitness of PersonalBest of each Particle
    private double[] fitness;
    
    private double[][] velocity;
    private double[] posGBest; //Position of GlobalBest
    //private double fitnessGBest;//Fitness of GlobalBest

    private double global; 
    Population(){
    	this.particulas=new double[15][3];
    	this.posPBest=new double[15][3];
    	this.fitness=new double[15];
    	this.posGBest=new double[3];
    	//this.fitnessGBest=-99999999;
    	this.velocity=new double[15][3];
    	this.global=999999999;
    	this.fitnessPBest=new double[15];
    	
    	inicializar();
    	
    }
    private void inicializar() {
    	Random r = new Random();
    	double numR;
    	for(int i=0;i<15;i++) {
    		
    		for(int x=0;x<3;x++) {
    			particulas[i][x]=(double) r.nextInt(250)+1; 	
    		}
    		numR=aleatorio();
			velocity[i][0]=particulas[i][0]*numR;
			velocity[i][1]=particulas[i][1]*numR;
			velocity[i][2]=particulas[i][2]*numR;
			fitnessPBest[i]=999999999;
    	}
    	   
    }
    public void insertar(double a) {
    	particulas[0][0]=a;
    }
    public void imprime() {
    	for(int i=0;i<15;i++) {	
    			System.out.println("particula "+i+" tiene datos en "+particulas[i][0]+","+particulas[i][1]+","+particulas[i][2]+" Fitenees "+fitness[i]);	
    	}
    }
   /* public void imprime_fitenesGBest() {
    	System.out.println("el global es "+fitnessGBest);
    }*/
    public double[][] get_particulas() {
    	return particulas;
    }
    public double[] get_fitness() {
    	return fitness;
    }
   public double[] get_posGBest() {
	   return posGBest;
   }
   public double[] get_fitnessPBest() {
	   return fitnessPBest;
   }
   public double[][] get_posPBest() {
	   return posPBest;
   }
   public double get_global() {
	   return global;
	   
   }
   public void set_global(double a) {
	   global=a;
   }
  /*public double get_fitnessGBest() {
	   return fitnessGBest;
   }*/
    public void imprimir_fitnes() {
    	for(int x=0 ;x<15;x++) {
    		System.out.println("El fitenes de la paticula "+ x +" es:"+fitness[x]);
    	}
    }
    public void imprimir_gf() {
    	System.out.println("El fitnes global es "+ global);
    	System.out.println("El fitnes global es "+ posGBest[0]+"  "+posGBest[1]+"  "+posGBest[2]);
    	
    }
    public double[][] get_velocity() {
    	return velocity;
    }
    private double aleatorio() {
    	double x=(double)Math.random();
		String cad=String.valueOf(x);
		cad = cad.substring(0,3);
		x = Double.parseDouble(cad);
		return x;
    }
    public void impirmir_posPBest() {
    	for(int x=0 ;x<15;x++) {
    	System.out.println("La mejor particula "+x+" es "+posPBest[x][0]+" "+posPBest[x][1]+"  "+posPBest[x][2]);
    	}
    }

    		
    		
}
