package ACO_p;
import java.util.ArrayList;
import java.util.List;

public class Aco {
	
	
	List<Integer> lista = new  ArrayList<Integer> ();
	List<Integer> posicion = new  ArrayList<Integer> ();
	List<Float> peso = new  ArrayList<Float> ();
	List<Float>  proba=new  ArrayList<Float> ();

	Aco()
	{
		
	}
	public void inicio(Mapa m) {
		lista.add(m.get_inicio());
		
	}
	public void camino(Mapa m) {
		float[][] matrizH = m.get_matrizH();
		float[][] feromona = m.get_feromona();
		
		int contador=lista.size()-1;
		//int cont=0;
		float aux2=0;
		
		 do{
			 
			int tam=lista.size();
			tam=lista.get(tam-1);
			
			//System.out.println("Entra en "+tam);
			for (int i=0;i<7;i++) {
				if(matrizH[tam][i]!=0 ) {
					if(!lista.contains(i)) {
						//System.out.println("El resultado es "+tam);
						//System.out.println("Entro en la posicion " + i);
						//System.out.println("------------" );
						
						posicion.add(i);
						aux2= feromona[tam][i] * (matrizH[tam][i]*matrizH[tam][i]);
						peso.add(aux2);
						
					}
				}	
				
			}
			//System.out.println("Lista de elementos para mMM"+posicion);
			//System.out.println("Elemntos ya en la lista "+lista);
			if(posicion.size()==0) {
				//opcion para quitar bucle
				//System.out.println(" entro al desbloquedaro");
				int aux=0;
				aux=lista.size();
				aux=lista.get(aux-2);
				
				lista.add(aux);
			}else {
				//calcula las probabilidades
				float suma= 0;
				for(int i=0;i<peso.size();i++) {
					
					suma+=peso.get(i);
					//System.out.println("La suma es dentro for" +suma);
					
				}
				//System.out.println("La suma es " +suma);
				
				for(int i=0;i<peso.size();i++) {
					float resultado;
					resultado=peso.get(i)/suma;
					proba.add(resultado);
					//System.out.println("La suma es dentro for" +suma);
					
				}
				//System.out.println("La proba " +proba);
				float eleccion=0;
				float aleatorio=probailidad();
				//System.out.println("La probabilidad es  "+aleatorio);
				for(int i=0;i<peso.size();i++) {
					eleccion+=proba.get(i);
					//System.out.println("eleccion debe ser menor "+eleccion);
					
					if(aleatorio<eleccion) {
						//System.out.println("El numero que se va a ingresar es "+i);
						float a=posicion.get(i);
						//System.out.println("El numero que se va a ingresar es "+a);
						lista.add((int)a);	
						i=7;
					}
					
				}
			}
			//limpiar listas para la siguiente iteracion
			posicion.clear();
			proba.clear();
			peso.clear();
			
			contador=lista.size()-1;
			//System.out.println("bucamos el final " +(lista.size()-1));
			//System.out.println("buscamos el final  " +m.get_final());
			
		}while(lista.get(contador)!= m.get_final());
		
		System.out.println("Recorrido final "+lista);
		sacar_distancia(m);
		lista.clear();
	}
	public void sacar_distancia(Mapa m) {
		float[][] ubicacion = m.get_ubicacion();
		float[][] feromona=m.get_feromona();
		int size=lista.size();
		int aux=0;
		int aux2=0;
		float contador=0;
		float fero=0;
		for(int i=0;i<size-1;i++) {
			aux=lista.get(i);
			aux2=lista.get(i+1);
			contador=contador + ubicacion[aux][aux2];		
			//System.out.println("Ubicacion "+ubicacion[aux][aux2]);	
			}
		System.out.println("Imprimir el contador  "+contador );
		//sacar feromona
		fero=1/contador;
		for(int i=0;i<size-1;i++) {
			aux=lista.get(i);
			aux2=lista.get(i+1);
			 feromona[aux][aux2]=feromona[aux][aux2]+fero;		
			//System.out.println("Ubicacion "+ubicacion[aux][aux2]);	
			}
	}
	public float probailidad() {
		float valor=(float) Math.random();
		return valor;
	}
}
