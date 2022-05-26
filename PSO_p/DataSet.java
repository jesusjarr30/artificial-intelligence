package PSO_p;

public class DataSet {
    private int[] x = {23, 26, 30, 34, 43, 48, 52, 57, 58}; //publicidad
    private int[] y = {651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518}; //ventas
    private int[] z = {1, 2, 3, 4, 5, 6, 7, 8, 9}; //año
    
    DataSet(){
    	
    }
    public double GetSum(double[] particlePos){
        double sum = 0.0, aux = 0.0;
        for(int i = 0; i < 9; i++){
            aux = y[i] - (particlePos[0] + (particlePos[1] * x[i]) + (particlePos[2] * z[i]));
            sum += aux * aux;
        }
        return sum;
    }
    public double Benetton(){
        double sum = 0.0, aux = 0.0, aux2 = 0.0;
        for(int i = 0; i < 9; i++){
            aux = y[i] - (323 + (14 * x[i]) + (47 * z[i]));
            sum += aux * aux;
        }
        aux = (1.0/9.0) * sum;
        return aux;
    }
    public void Prueba(){
        double sum = 0.0, aux = 0.0, aux2 = 0.0;
        for(int i = 0; i < 9; i++){
            aux = y[i] - (323 + (14 * x[i]) + (47 * z[i]));
            sum += aux * aux;
        }
        
        aux = (1.0/9.0) * sum;
        System.out.println("Double antes: " + aux);
        aux = Math.round(aux);
        System.out.println("Double despues: " + aux);
    }

	
    
}
