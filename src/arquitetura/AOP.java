package arquitetura;

import java.util.Locale;

import erp.usuario.Usuario;

public class AOP {

	private static AOP instancia;
	private static Usuario usuario;
	
	static {
		Locale.setDefault(new Locale("pt", "BR"));
	}

	public static synchronized AOP getInstancia() {
		return instancia == null ? new AOP() : instancia;
	}

	public static Usuario getUsuario() {
		return AOP.usuario;
	}
	
	public static Locale getLocale() {
		return new Locale("pt", "BR");
	}

	public static void setUsuario(Usuario usuario) {
		AOP.usuario = usuario;
	}

	public static String getNomeSistema() {
		return "ATHOS";
	}
}	
