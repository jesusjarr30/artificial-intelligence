package regresion;


public class SLR {
	private double beta0;
	private double beta1;
	public SLR(){
		beta0=0;
		beta1=0;
	}
	public double cal_B0(double[] x,double[] y) {
		HelpAritmetic arit=new HelpAritmetic();
		double s_x;
		double s_y;
		s_x=arit.sum(x);
		s_y=arit.sum(y);
		beta0=(s_y-beta1*s_x)/x.length;
		return beta0;
	}
	public double cal_B1(double[] x,double[] y) {
		HelpAritmetic arit=new HelpAritmetic();
		double s_x;
		double s_y;
		double s_x2;
		double s_xy;
		
		
		s_x=arit.sum(x);
		s_y=arit.sum(y);
		s_x2=arit.sumx2(x);
		s_xy=arit.sumxy(x, y);
		
		
		beta1=((s_x*s_y)-(x.length*s_xy))/((s_x*s_x)-(x.length*s_x2));
		return beta1;
	}
	public void predict(double aux) {
		System.out.println("ELbeta 0 es "+beta0);
		System.out.println("ELbeta 1 es "+beta1);

		System.out.println("xi es "+aux+"  se espera en   "+(beta0+(beta1*aux)));	
	}

}
