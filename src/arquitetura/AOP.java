package arquitetura;

import java.awt.Cursor;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;

import erp.usuario.Usuario;

public class AOP {

	private static AOP instancia;
	private static Usuario usuario;
	private static Locale locale;

	static {
		Locale.setDefault(new Locale("pt", "BR"));
		locale = new Locale("pt", "BR");
	}

	public static synchronized AOP getInstancia() {
		return instancia == null ? new AOP() : instancia;
	}

	public static Locale getLocale() {
		return new Locale("pt", "BR");
	}

	public static String getNomeSistema() {
		return "ATHOS";
	}

	public static Usuario getUsuario() {
		return AOP.usuario;
	}

	public static String getUsuarioFormatado() {
		if (AOP.usuario == null) {
			return " - [ ]";
		}
		return " - [ " + AOP.usuario + " ]";
	}

	public static void setUsuario(Usuario usuario) {
		AOP.usuario = usuario;
	}
	
	public static Cursor getNovaJanelaCursor() {
		return Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
	}

	public static Format getNumeroFormatado() {
		return NumberFormat.getNumberInstance(AOP.locale);	
	}
}
