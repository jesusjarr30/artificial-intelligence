
public class Main {

	public static void main(String[] args) {
		//ecuation to solve f(x)
		
		int numVaribles=3;
		int poulatipoSize=100;
		float Wmax=(float) 0.9;
		float Wmin=(float) 0.4;
		int c1=2,c2=2;
		int maxIteration=200;
		Population p=new Population(poulatipoSize);
		int opc=0;
		
		
		while(opc!=maxIteration) {
		System.out.println("Generacion es"+opc);
		p.calculateVelocity(Wmin, c1, c2);
		p.conVT();
		p.selectFitenessGobla();
		p.selectPersonalBest();
		opc++;
		
		}
		//System.out.println("---------------------------------------");
		p.printPopulation();
		//p.printVelocity();
		 
		System.out.println("\n\nThe answer to the problem is -----");
		p.printGlobalB();
		System.out.println("---------------------------------------");
		//p.printVelocity();
		
	}
}
