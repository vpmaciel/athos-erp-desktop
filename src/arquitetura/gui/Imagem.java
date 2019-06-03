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
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/help_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getDeletar() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/delete_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getEditar() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/edit_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getExclui() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/delete_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getFechar() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/close_window_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getHome() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/home_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getImprime() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/print_32px.png"));
		return imageIcon;
	}

	public static Image getLogoTipoImage() {
		caminhoImagem = recursos.getResource("arquitetura/gui/logo.png");
		iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
		return iconeTitulo;
	}

	public static ImageIcon getLogoTipoImageIcon() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/logo.png"));
		return imageIcon;
	}

	public static ImageIcon getLogoTelaInicialImageIcon() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/inicial.png"));
		return imageIcon;
	}

	public static ImageIcon getNovo() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/add_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getpesquisar() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/search_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getRegistros() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/database_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getRelatorio() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/pdf_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getSair() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/shutdown_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getSalva() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/save_32px.png"));
		return imageIcon;
	}

	public static ImageIcon getSobre() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/info_32px.png"));
		return imageIcon;
	}	
}
