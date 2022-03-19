package regresion;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class GenericAgent extends Agent {

  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
    addBehaviour(new MyGenericBehaviour());
  } 
  private class MyGenericBehaviour extends Behaviour {

    int cont=0;
    DataSet a;
    

    public void action() {
      DataSet a = new DataSet();
      SLR s =new SLR();
      s.cal_B1(a.get_x(),a.get_y());
      s.cal_B0(a.get_x(),a.get_y());

      s.predict(23);

        cont=1;
    } 
    
    public boolean done() {
      if (cont == 1)
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
