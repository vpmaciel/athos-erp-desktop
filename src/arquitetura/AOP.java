package arquitetura;

import java.util.Locale;
import java.util.ResourceBundle;

import erp.usuario.Usuario;

public class AOP {

	private static AOP instancia;
	private static ResourceBundle resourceBundle;
	private static Usuario usuario;

	static {
		resourceBundle = ResourceBundle.getBundle("arquitetura/propriedade/rotulos", Locale.getDefault());
	}

	public static synchronized AOP getInstancia() {
		return instancia == null ? new AOP() : instancia;
	}

	public static synchronized String getMessage(String string) {
		return resourceBundle.getString(string);
	}

	public static Usuario getUsuario() {
		return AOP.usuario;
	}

	public static void setUsuario(Usuario usuario) {
		AOP.usuario = usuario;
	}

	public static String getNomeSistema() {
		return "ATHOS - SISTEMA DE GESTÃO EMPRESARIAL";
	}
}	
