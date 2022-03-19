package regresion;

public class HelpAritmetic {
	public HelpAritmetic() {
		
	}
	public double sum(double[] aux) {
		double resp=0;
		for(int i=0;i<aux.length;i++) {
			resp+=aux[i];
		}
		return resp;
	}
	public double sumx2(double[] aux) {
		double resp=0;
		for(int i=0;i<aux.length;i++) {
			resp+=(aux[i]*aux[i]);
		}
		return resp;
	}
	public double sumxy(double[] x, double[] y) {
		double resp=0;
		for(int i=0;i<x.length;i++) {
			resp+=(x[i]*y[i]);
		}
		return resp;
	}
}