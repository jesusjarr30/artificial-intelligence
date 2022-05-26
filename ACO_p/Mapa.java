package ACO_p;

public class Mapa {
	
	private float[][]ubicacion;
	private float [][]feromona;
	private float [][]matrizH;
	
	private int inicio;
	private int finall;
			
	Mapa(){
		this.ubicacion=new float[7][7];
		this.feromona=new float[7][7];
		this.matrizH=new float[7][7];
		this.inicio=0;
		this.finall=6;
		
		iniciaizar_mapa();
		inicializar_matrizH();
		inicializar_feromona();
	
		
	}
	private void inicializar_feromona() {
		for(int i=0;i<7;i++) {
			for (int x=0;x<7;x++) {
				feromona[i][x]=1;
			}
		}
	}

	private void inicializar_matrizH() {
		//agregar la matrizz H
		for (int i=0;i<7;i++) {
			for (int x=0;x<7;x++) {
				if(ubicacion[i][x]>0) {
					matrizH[i][x]=1/ubicacion[i][x];
				}
			}
		}
		
	}
	private void iniciaizar_mapa() {
		ubicacion[0][1]=5;
		ubicacion[0][2]=5;
		ubicacion[1][0]=5;
		ubicacion[1][2]=1;
		ubicacion[1][4]=6;
		ubicacion[1][6]=3;
		ubicacion[2][0]=5;
		ubicacion[2][1]=1;
		ubicacion[2][3]=2;
		ubicacion[3][2]=2;
		ubicacion[3][6]=3;
		ubicacion[4][5]=2;
		ubicacion[4][1]=6;
		ubicacion[4][6]=1;
		ubicacion[5][4]=2;
		//ubicacion[5][6]=3;
		ubicacion[6][1]=3;
		ubicacion[6][3]=3;
		ubicacion[6][4]=1;
		//ubicacion[6][5]=3;
	}
	
	public float[][] get_ubicacion() {
		return ubicacion;
		
	}
	public float[][] get_feromona(){
		return feromona;
	}
	public float[][] get_matrizH(){
		return matrizH;
	}
	public void imprimir_ubicaciones() {
		for (int i=0;i<7;i++) {
			for(int x=0;x<7;x++) {
				System.out.print(ubicacion[i][x]+"  ");
			}
			System.out.print("\n");
		
		}
	}
	public void imprimir_matrizH() {
		
		for (int i=0;i<7;i++) {
			for(int x=0;x<7;x++) {
				System.out.print(matrizH[i][x]+"  ");
			}
			System.out.print("\n");
		
		}
	}
public void imprimir_feromona() {
		
		for (int i=0;i<7;i++) {
			for(int x=0;x<7;x++) {
				System.out.print(feromona[i][x]+"  ");
			}
			System.out.print("\n");
		}
	}

public void evaporizar_feromona() {
	
	for (int i=0;i<7;i++) {
		for(int x=0;x<7;x++) {
			System.out.print("  ");
			feromona[i][x]=(float)(1-0.5)*feromona[i][x];
		}
		
	}
}
	public int get_inicio() {
		return inicio;
	}
	public int get_final() {
		return finall;
	}
	public void mejor_camino() {
		float mejor=0;
		int inicio=0;
		
			for(int i=0;i<7;i++) {
				mejor=feromona[0][i];
				if(feromona[0][i]>mejor) {
					mejor=feromona[0][i];
				}
			}
	}
}
