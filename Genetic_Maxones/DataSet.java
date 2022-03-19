package Genetic_Maxones;

public class DataSet {
	private String[] generation;
		
	public DataSet(int valor) {
		generation=new String[valor];
		String aux="";
		int intAletorio=(int)(Math.random()*1);
		for (int i=0;i<100;i++) {
			
			for(int x=0;x<10;x++) {
				intAletorio=(int)(Math.random()*2);
				if(intAletorio==1) {
					aux+="1";
				}
				else {
					aux+="0";
				}
			}
			generation[i]=aux;
			aux="";
		}
	}
	public void show() {
		for(int i=0;i<100;i++) {
			System.out.println(generation[i]);
		}
	}
	public int get_lenght() {
		return generation.length;
	}
	public String get_data(int posicion) {
		return generation[posicion];
	}
	public String[] get_data() {
		return generation;
	}
	public void set_data(String[] a) {
		generation=a;
	}
}

