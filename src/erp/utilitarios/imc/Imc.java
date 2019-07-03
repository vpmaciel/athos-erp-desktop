package erp.utilitarios.imc;

public class Imc {

	private double altura = 1.0;
	private double peso = 0.0;
	private String sexo;

	public Imc() {
		
	}
	
	public double getAltura() {
		return altura;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
