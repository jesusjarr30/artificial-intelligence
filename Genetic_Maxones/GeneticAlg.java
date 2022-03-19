package Genetic_Maxones;

public class GeneticAlg {
	private int popSize;
	private float crossoverRate;
	private float mutRate;
	private float elitism;
	
	public GeneticAlg(int s,float c,float m, float e) {
		this.popSize=s;
		this.crossoverRate=c;
		this.mutRate=m;
		this.elitism=e;
	}
	public int evaluatePopulation(String[] aux) {
		char cad[];
		int cont=0;
		for(int i=0;i<popSize;i++) {
			//System.out.println(aux[i]);
			cad  = aux[i].toCharArray();
			for(int x=0;x<cad.length;x++) {
				if(cad[x]=='1') {
					cont++;
				}
				if(cont==10) {
					System.out.println("La respuesa esta en el registro "+i);
					return 10;
				}
			}
			cont=0;
		}
		return 0;
	}
	public void selectPartens(DataSet a,Parents p) {
		//p.set_hola("HOLa como estas");
		//p.showhola();
		String[] generation=a.get_data();
		int [] gen=new int[100];
		String aux="";
		char cad[];
		int count=0;
		for (int i=0;i<generation.length;i++) {
			aux = generation[i];
			cad=aux.toCharArray();
			for(int x=0;x<aux.length();x++) {
				if(cad[x]=='1') {
					count++;
				}
			}
			//System.out.println("salio");
			//System.out.println(count);
			
			p.set_parent(i, count);
			gen[i]=count;
			count=0;	
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
				secondParent= generation[p.selection_Parent()];
				aux=crossover2(generation[i],secondParent);
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
		char[] cad3=new char[10];
		char[] cad4=new char[10];
		int intAletorio=(int)(Math.random()*8+2);
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
			int cont=0;
			int cont2=0;
		for(int i=0;i<a.length();i++) {

			if(cad3[i]=='1') {
				cont++;	
			}
			if(cad4[i]=='1') {
				cont2++;
			}
			
		}
		des1=String.valueOf(cad3);
		des2=String.valueOf(cad4);
		//System.out.println("el crossover es "+des1);
		//System.out.println("el crossover es "+des2);
		if(cont>cont2) {
			return des1;
		}
		else {
			return des2;
		}
	}
	public void mutate(DataSet a) {
		char[] cad=new char[10];
		String des1="";
		String[] generation=a.get_data();
		String[] newGeneration= new String [100];
		for (int i=0;i<generation.length;i++) {
			if(mutRate>(float)(Math.random()*1)) {
				int intAletorio=(int)(Math.random()*10);
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
