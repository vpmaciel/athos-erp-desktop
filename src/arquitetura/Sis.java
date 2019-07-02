package arquitetura;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import arquitetura.gui.Msg;
import erp.usuario.Usuario;

public class Sis {

	private static Sis instancia;
	private static Usuario usuario;
	private static Locale locale = new Locale("pt", "BR");
	private static final String separador = System.getProperty("file.separator");
	private static String caminhoRaiz = "C:" + separador + "opt";
	private static String caminhoApp = caminhoRaiz + separador + "athos" + separador;
	private static String caminhoAppDados = caminhoApp + "dados" + separador;
	private static final String caminhoDiretorioLog = caminhoApp + "logs";
	private static final String caminhoDiretorioVideos = caminhoApp + "videos";
	private static final String caminhoDiretorioOds = caminhoAppDados + "ods" + separador;
	private static final String caminhoDiretorioDadosPdf = caminhoAppDados + "pdf" + separador;
	private static final String caminhoDiretorioDadosJson = caminhoAppDados + "json" + separador;
	private static final String caminhoDiretorioDadosXml = caminhoAppDados + "xml" + separador;
	private static final String caminhoDiretorioDadosCsv = caminhoAppDados + "csv" + separador;
	private static final String caminhoDiretorioDadosTxt = caminhoAppDados + "txt" + separador;

	static {
		Locale.setDefault(new Locale("pt", "BR"));
		criarDiretorios();
	}

	public static synchronized Sis getInstancia() {
		return instancia == null ? new Sis() : instancia;
	}

	public static Border getBordaPainel() {
		return BorderFactory.createLineBorder(Color.BLACK, 2);
	}

	public static String getNomeHost() {
		try {
			return InetAddress.getLocalHost().getCanonicalHostName();
		} catch (UnknownHostException e) {
			return null; 
		}
	}
	public static void abrirDiretorio(String URL) {
        String text, text2;
        text = System.getProperty("os.name");
        text = text.toLowerCase();
        text2 = URL;

        if (text.contains("linux") && !text2.equals("")) {
            try {
                Runtime.getRuntime().exec("konkeror " + URL); // Seu gerenciador de arquivos: konkeror (KDE), dolphin, nautilus (gnome) e etc
            } catch (IOException ex) {
                System.out.println("Gerenciador de arquivos não instalado.");
            }
        } else if (text.contains("windows") && !text2.equals("")) {
            try {
                Runtime.getRuntime().exec("explorer.exe " + URL); // A url, que no caso é C:/
            } catch (IOException ex) {
                System.out.println("Desculpe, falha na execução dessa função!");
            }
        }
       
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

	public static String getCaminhoDiretorioOds() {
		return caminhoDiretorioOds;
	}

	public static String getCaminhoDadosCsv() {
		return caminhoDiretorioDadosCsv;
	}
	
	public static String getCaminhoDadosTxt() {
		return caminhoDiretorioDadosTxt;
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
		return Sis.usuario;
	}

	public static String getUsuarioFormatado() {
		if (Sis.usuario == null) {
			return " - [ ]";
		}
		return " - [ " + Sis.usuario + " ]";
	}

	public static void setUsuario(Usuario usuario) {
		Sis.usuario = usuario;
	}

	public static Cursor getNovaJanelaCursor() {
		return Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
	}

	public static Format getNumeroFormatado() {
		
		return NumberFormat.getNumberInstance(Sis.locale);
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
			arquivo = new File(caminhoDiretorioOds);
			arquivo.mkdir();
			arquivo = new File(caminhoDiretorioDadosCsv);
			arquivo.mkdir();
			arquivo = new File(caminhoDiretorioDadosJson);
			arquivo.mkdir();
			arquivo = new File(caminhoDiretorioDadosPdf);
			arquivo.mkdir();
			arquivo = new File(caminhoDiretorioDadosTxt);
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
