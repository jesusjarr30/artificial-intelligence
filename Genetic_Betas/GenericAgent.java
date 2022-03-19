package Genetic_Betas;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class GenericAgent extends Agent {

  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
    addBehaviour(new MyGenericBehaviour());
  } 
  private class MyGenericBehaviour extends Behaviour {
    DataSet a =new DataSet(100);
      GeneticAlg g=new GeneticAlg(100,.20f,.20f,10.0f);
      Parents p=new Parents();
      
      int generation=0;
      Boolean fin=true;
      int aux=0;
      int cont=0;
   

    public void action() {
      
      g.set_solucion(255);
      while(aux!=10) {
        g.selectPartens(a, p);
        //p.show(a);
        g.crossover(a, p);
        g.mutate(a);
        aux=g.evaluatePopulation(a.get_data());
        generation++;	
      }
      System.out.println("Generacion N "+generation);
      
      g.set_solucion(255);
      a.set_buscar(1);
      aux=0;
      generation=0;
      while(aux!=10) {
        g.selectPartens(a, p);
        g.crossover(a, p);
        g.mutate(a);
        aux=g.evaluatePopulation(a.get_data());
        generation++;	
      }
      a.show();
      System.out.println("---------------------");
      a.show2();
      System.out.println("Generacion N "+generation);
      //System.out.println("elvalor de auxx es "+aux);

      
    } 
    
    public boolean done() {
      if (aux==10)
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
