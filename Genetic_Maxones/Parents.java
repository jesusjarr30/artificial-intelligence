package Genetic_Maxones;

public class Parents {

	private int [] num_ones; 
	private float [] porcentaje;

	public Parents() {
		porcentaje=new float[100];
		num_ones=new int[100];

		//this.fitnees=0;
	}
	public void set_parent(int posicion,int unos) {
		//System.out.println("debe tener "+  unos);
		//System.out.println(posicion);
		num_ones[posicion]=unos;
	}
	public void set_parent(int [] a) {
		num_ones=a;
	}
	public void calcular_ratio() {
		int suma=0;
		for(int i=0;i<num_ones.length;i++) {
			suma+=num_ones[i];
			
		}
		System.out.println("La cantidad maxima de unos es "+suma);
		
		for(int i=0;i<num_ones.length;i++) {
			porcentaje[i]=(float) num_ones[i] / (float) suma;
		}
	}
	public int selection_Parent() {
		
		float desicion=(float)(Math.random()*1);
		float aux=0;
		for(int i=0;i<porcentaje.length;i++) {
			aux+=porcentaje[i];
			if(aux>=desicion) {
				if(i==0) {
					//System.out.println("ewel auxiliar es es "+aux);
					//System.out.println("El desicion es "+desicion);
					//System.out.println("El return es "+(i));
					return i;
				}
				else {
					//System.out.println("El auxiliar es "+aux);
					//System.out.println("El desicion es "+desicion);
					//System.out.println("El return es h"+(i-1));
					return i-1;
				}	
			}
		}
		//System.out.println("auxilia es " +aux);
		return 99;
		
	}
	public void show(DataSet a) {
		for (int i=0;i<porcentaje.length;i++) {
			System.out.println("El gen es :"+a.get_data(i));
			System.out.println("num ones   "+num_ones[i]);
			System.out.println("porcentaje   "+porcentaje[i]);
			
			
		}
	}

}
