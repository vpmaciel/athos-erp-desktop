package arquitetura;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.io.File;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import arquitetura.gui.Msg;
import erp.usuario.Usuario;

public class AOP {

	private static AOP instancia;
	private static Usuario usuario;
	private static Locale locale = new Locale("pt", "BR");
	private static final String separador = System.getProperty("file.separator");
	private static String caminhoRaiz = "C:" + separador + "opt";
	private static String caminhoApp = caminhoRaiz + separador + "athos" + separador;
	private static String caminhoAppDados = caminhoApp + "dados" + separador;
	private static final String caminhoDiretorioLog = caminhoApp + "logs";
	private static final String caminhoDiretorioVideos = caminhoApp + "videos";
	private static final String caminhoDiretorioPlanilhas = caminhoApp + "planilhas";
	private static final String caminhoDiretorioDadosPdf = caminhoAppDados + "pdf" + separador;
	private static final String caminhoDiretorioDadosJson = caminhoAppDados + "json" + separador;
	private static final String caminhoDiretorioDadosXml = caminhoAppDados + "xml" + separador;
	private static final String caminhoDiretorioDadosCsv = caminhoAppDados + "csv" + separador;

	static {
		Locale.setDefault(new Locale("pt", "BR"));
		criarDiretorios();
	}

	public static synchronized AOP getInstancia() {
		return instancia == null ? new AOP() : instancia;
	}

	public static Border getBordaPainel() {
		return BorderFactory.createLineBorder(Color.BLACK, 2);
	}

	public static Dimension getTamanhoJanela() {
		return new Dimension(900, 660);
	}

	public static Locale getLocale() {
		return new Locale("pt", "BR");
	}

	public static String getSeparador() {
		return separador;
	}

	public static String getCaminhoDiretoriolog() {
		return caminhoDiretorioLog;
	}

	public static String getCaminhoDiretoriovideos() {
		return caminhoDiretorioVideos;
	}

	public static String getCaminhoDiretorioPlanilhas() {
		return caminhoDiretorioPlanilhas;
	}

	public static String getCaminhoDadosCsv() {
		return caminhoDiretorioDadosCsv;
	}

	public static String getCaminhoDadosJson() {
		return caminhoDiretorioDadosJson;
	}

	public static String getCaminhoDadosPdf() {
		return caminhoDiretorioDadosPdf;
	}

	public static String getCaminhoDadosXml() {
		return caminhoDiretorioDadosXml;
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

	public static void criarDiretorios() {
		try {
			File arquivo = new File(caminhoRaiz);
			arquivo.mkdir();
			arquivo = new File(caminhoApp);
			arquivo.mkdir();
			arquivo = new File(caminhoAppDados);
			arquivo.mkdir();
			arquivo = new File(caminhoDiretorioLog);
			arquivo.mkdir();
			arquivo = new File(caminhoDiretorioPlanilhas);
			arquivo.mkdir();
			arquivo = new File(caminhoDiretorioDadosCsv);
			arquivo.mkdir();
			arquivo = new File(caminhoDiretorioDadosJson);
			arquivo.mkdir();
			arquivo = new File(caminhoDiretorioDadosPdf);
			arquivo.mkdir();
			arquivo = new File(caminhoDiretorioDadosXml);
			arquivo.mkdir();
			arquivo = new File(caminhoDiretorioVideos);
			arquivo.mkdir();
		} catch (Exception exception) {
			exception.printStackTrace();
			Msg.erroCriarPasta();
		}
	}
}
