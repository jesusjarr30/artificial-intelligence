package PSO_p;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class GenericAgent extends Agent {

  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
    addBehaviour(new MyGenericBehaviour());
  } 
  private class MyGenericBehaviour extends Behaviour {

    int opc=0;
		DataSet d= new DataSet();
		Population p =new Population();
		PSO alg= new PSO();
    int aux=0;

    public void action() {
      do {
        alg.EvaluateFitness(p,d);
        
        alg.EvaluatePBest(p);
        alg.EvaluateGBest(p);
        //p.imprime();
        p.imprimir_gf();
        alg.calVelocity(p);
        alg.UpdatePosition(p);
        
        opc++;
        
        //alg.calVelocity();
      }while(opc!=120);


          aux=10;
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
