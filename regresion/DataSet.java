package regresion;

public class DataSet {
	private double[] x=new double[9];
	private double[] y=new double[9];
	
	public DataSet() {
		//instanciamos para x
		/*x[0]=23;
		x[1]=26;
		x[2]=30;
		x[3]=34;
		x[4]=43;
		x[5]=48;
		x[6]=52;
		x[7]=57;
		x[8]=58;*/
		x[0]=1;
		x[1]=2;
		x[2]=3;
		x[3]=4;
		x[4]=5;
		x[5]=6;
		x[6]=7;
		x[7]=8;
		x[8]=9;

		//ingresamos datos para y 
		y[0]=2;
		y[1]=4;
		y[2]=6;
		y[3]=8;
		y[4]=10;
		y[5]=12;
		y[6]=14;
		y[7]=16;
		y[8]=18;
	}
	public double[] get_x() {
		return x;
	}
	public double[] get_y() {
		return y;
	}
}
