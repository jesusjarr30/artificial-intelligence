package Genetic_Betas;


public class GeneticAlg {
	private int popSize;
	private float crossoverRate;
	private float mutRate;
	private float elitism;
	private int solucion;
	
	public GeneticAlg(int s,float c,float m, float e) {
		this.popSize=s;
		this.crossoverRate=c;
		this.mutRate=m;
		this.elitism=e;
		this.solucion=0;
	}
	public void set_solucion(int a) {
		solucion=a;
	}
	public int evaluatePopulation(String[] aux) {
		int conversor;
		for(int i=0;i<popSize;i++) {
			//System.out.println(aux[i]);
			conversor=Integer.parseInt(aux[i], 2);
			if(conversor==solucion) {
				System.out.println("La solucion es  "+conversor+" que se encuntra en "+i);
				
				return 10;
			}
		}
		return 0;
	}
	public void selectPartens(DataSet a,Parents p) {
		//p.set_hola("HOLa como estas");
		//p.showhola();
		String[] generation=a.get_data();
		int [] gen=new int[100];
		int aux=0;
		for (int i=0;i<generation.length;i++) {
			aux=Integer.parseInt(generation[i], 2);
			//System.out.println("El nummero decimal es "+aux);
			//System.out.println("El nummero binario es  es "+generation[i]);
			
			//System.out.println("salio");
			aux=aux-solucion;
			if(aux<0) {
				aux=aux*-1;
			}
			//System.out.println("Diferencia es "+aux);
			p.set_parent(i, aux);
			//gen[i]=aux;
			aux=0;	
		}
		p.calcular_ratio();
	}
	public void crossover(DataSet a,Parents p) {
		String[] generation=a.get_data();
		String[] newGeneration= new String [100];
		String secondParent="";
		String aux="";
		for(int i=0;i<generation.length;i++) {
			if(crossoverRate>(float)(Math.random()*1)) {
				//System.out.println("EL resulado es "+generation[1]);
				secondParent= generation[p.selection_Parent()];
				//System.out.println("EL a es "+generation[i]);
				//System.out.println("EL b es "+secondParent);
				aux=crossover2(generation[i],secondParent);
				//System.out.println("despues "+secondParent);	
				newGeneration[i]=aux;
			}
			else {
				newGeneration[i]=generation[i];
			}
		}
		a.set_data(newGeneration);
		
	}
	public String crossover2(String a, String b) {
		//System.out.println("EL a es "+a);
		//System.out.println("EL b es "+b);
		String des1="";
		String des2="";
		char[] cad;
		char[] cad2;
		char[] cad3=new char[8];
		char[] cad4=new char[8];
		int intAletorio=(int)(Math.random()*6+2);
		int aux,aux2;
		cad  = a.toCharArray();
		cad2 =b.toCharArray();
		for(int i=0;i<a.length();i++) {
			if(i<intAletorio) {
				cad3[i]=cad[i];
			}
			else {
				cad3[i]=cad2[i];
			}
			if(i>=intAletorio) {
				cad4[i]=cad[i];
			}
			
		}
		for (int i=0;i<intAletorio;i++) {
			cad4[i]=cad2[i];
		}
		
		des1=String.valueOf(cad3);
		des2=String.valueOf(cad4);
		aux=Integer.parseInt(des1, 2)-solucion;
		aux2=Integer.parseInt(des2, 2)-solucion;
		if(aux<0) {
			aux=aux*-1;
		}
		if(aux2<0) {
			aux2=aux2*-1;
		}
		
		//System.out.println("el crossover es "+des1);
		//System.out.println("el crossover es "+des2);
		if(aux<aux2) {
			return des1;
		}
		else {
			return des2;
		}
		
	}
	public void mutate(DataSet a) {
		char[] cad=new char[8];
		String des1="";
		String[] generation=a.get_data();
		String[] newGeneration= new String [100];
		for (int i=0;i<generation.length;i++) {
			if(mutRate>(float)(Math.random()*1)) {
				int intAletorio=(int)(Math.random()*8);
				int intAletorio2=(int)(Math.random()*2);
				//System.out.println("Despues 1e   "+intAletorio);
				//System.out.println("Despues 2e   "+intAletorio2);
				
				cad=generation[i].toCharArray();
				cad[intAletorio]= (char)(intAletorio2 + '0');
				newGeneration[i]=String.valueOf(cad);
				//System.out.println("Despues de mutar sucede"+newGeneration[i]);
				
				}
			else {
				newGeneration[i]=generation[i];
				}
		    }
		a.set_data(newGeneration);
		}
}
