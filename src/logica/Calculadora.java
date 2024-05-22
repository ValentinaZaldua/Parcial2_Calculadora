package logica;

public class Calculadora {
	private int opcion1;
	private int opcion2;
	private String cal;
	
	public final static String SUM = "+"; 
	public final static String RES = "-"; 
	public final static String MUL = "*"; 
	public final static String DIV = "/";
	public final static String IGU = "=";
	public final static String BOR = "C";

	public Calculadora() {
		this.opcion1 = 0;
		this.opcion2 = 0;
		this.cal = "";
	}
	
	public int getOp1() {
		return opcion1;
	}

	public void setOp1(int op1) {
		this.opcion1 = op1;
	}

	public int getOp2() {
		return opcion2;
	}

	public void setOp2(int op2) {
		this.opcion2 = op2;
	}

	public String getOp() {
		return cal;
	}

	public void setOp(String op) {
		this.cal = op;
	}

	public int calcular() {
		int resultado = 0;
		if(this.cal.equals(Calculadora.SUM)) {
			resultado = this.opcion1 + this.opcion2;
		}else if(this.cal.equals(Calculadora.RES)) {
			resultado = this.opcion1 - this.opcion2;
		}else if(this.cal.equals(Calculadora.MUL)) {
			resultado = this.opcion1 * this.opcion2;
		}else if(this.cal.equals(Calculadora.DIV)) {
			resultado = (int)(this.opcion1 / this.opcion2);			
		}
		this.opcion1 = resultado;
		return resultado;
	}
}
