package ACO_p;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import java.util.ArrayList;
import java.util.List;
public class GenericAgent extends Agent {

  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
    addBehaviour(new MyGenericBehaviour());
  } 
  private class MyGenericBehaviour extends Behaviour {
    
    Aco aco=new Aco();
		Mapa m= new Mapa();
    int cont=0;
		int cont2=0;
   

    public void action() {
     
      do {
        aco.inicio(m);
        aco.camino(m);
        
        if(cont2==20) {
          m.evaporizar_feromona();
          cont2=0;
        }
        cont++;
        cont2++;
      }while(cont!=600);
      
      //m.imprimir_feromona();
      //m.mejor_camino();
      
      m.imprimir_feromona();
    } 
    
    public boolean done() {
      if (cont==600)
        return true;
      else
	return false;
    }
   
    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}
