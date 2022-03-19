package Genetic_Betas;

public class DataSet {
	private String[] generationB0;
	private String[] generationB1;
	private int buscar;//si  es cero busca B si es 1 busca B1
		
	public DataSet(int valor) {
		generationB0=new String[valor];
		generationB1=new String[valor];
		String aux="";
		int intAletorio;
		for (int i=0;i<100;i++) {
			
			for(int x=0;x<8;x++) {
				intAletorio=(int)(Math.random()*2);
				if(intAletorio==1) {
					aux+="1";
				}
				else {
					aux+="0";
				}
			}
			generationB0[i]=aux;
			generationB1[i]=aux;
			aux="";
		}
		buscar=0;
	}
	public void show() {
		for(int i=0;i<100;i++) {
			System.out.println("El numero es "+generationB0[i]+"  "+i);
		}
	}
	public void show2() {
		for(int i=0;i<100;i++) {
			System.out.println("El numero es "+generationB1[i]+"  "+i);
		}
	}
	public int get_lenght() {
		if(buscar==0) {
			return generationB0.length;
		}
		else {
			return generationB1.length;
		}
		
	}
	public String get_data(int posicion) {
		if(buscar==0) {
			return generationB0[posicion];
		}
		else {
			return generationB1[posicion];
		}
		
	}
	public String[] get_data() {
		if(buscar==0) {
			return generationB0;
		}
		else {
			return generationB1;
		}
		
	}
	public void set_data(String[] a) {
		if(buscar==0) {
			
			generationB0=a;
		}
		else {
			generationB1=a;
		}
		
	}
	public void set_buscar(int a) {
			buscar=a;
		
		
	}
	
}
