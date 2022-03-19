package Genetic_Maxones;

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
    int aux=0;

    public void action() {
          g.selectPartens(a, p);
          g.crossover(a, p);
          g.mutate(a);
          aux=g.evaluatePopulation(a.get_data());
          generation++;	
          System.out.println("Generacion "+generation);
          //p.show(a);
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
