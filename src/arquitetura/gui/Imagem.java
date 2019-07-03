package arquitetura.gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;

public class Imagem {

	private static URL caminhoImagem;
	private static Image iconeTitulo;
	private static ImageIcon imageIcon;
	private static ClassLoader recursos;

	static {
		recursos = Imagem.class.getClassLoader();
	}

	public static ImageIcon getAjudar() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/help_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getAnalise() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/brain_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getCsv() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/csv_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getDeletar() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/delete_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getEditar() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/edit_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getExclui() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/delete_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getExportar() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/export_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getFechar() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/close_window_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getGrafico() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/combo_chart_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getHome() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/home_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getImportar() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/import_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getImprime() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/print_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getJson() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/json_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getLogoTelaInicialImageIcon() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/inicial.png"));
		return imageIcon;
	}

	public static Image getLogoTipoImage() {
		caminhoImagem = recursos.getResource("arquitetura/gui/imagem/logo.png");
		iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
		return iconeTitulo;
	}

	public static ImageIcon getLogoTipoImageIcon() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/logo.png"));
		return imageIcon;
	}

	public static ImageIcon getNegocios() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/business_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getNovo() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/add_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getPesquisar() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/search_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getPlanilha() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/google_sheets_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getRegistros() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/database_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getRelatorio() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/pdf_2_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getSair() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/shutdown_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getSalva() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/save_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getSobre() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/info_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getTxt() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/txt_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getXml() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/imagem/xml_2_32px.png"));
		return imageIcon;
	}
}
