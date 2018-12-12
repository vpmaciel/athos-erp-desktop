package arquitetura.gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;

public class Imagem {

	private static ImageIcon imageIcon;
	private static ClassLoader recursos;
	private static URL caminhoImagem;
	private static Image iconeTitulo;

	static {
		recursos = Imagem.class.getClassLoader();
	}

	public static ImageIcon getAjudar() {
		imageIcon = new ImageIcon(recursos.getResource("toolbarButtonGraphics/general/Help24.gif"));
		return imageIcon;
	}

	public static ImageIcon getDeletar() {
		imageIcon = new ImageIcon(recursos.getResource("toolbarButtonGraphics/general/Delete24.gif"));
		return imageIcon;
	}

	public static ImageIcon getEditar() {
		imageIcon = new ImageIcon(recursos.getResource("toolbarButtonGraphics/general/Edit24.gif"));
		return imageIcon;
	}

	public static ImageIcon getExcluiRegistro() {
		imageIcon = new ImageIcon(recursos.getResource("toolbarButtonGraphics/general/Delete24.gif"));
		return imageIcon;
	}

	public static ImageIcon getFechar() {
		imageIcon = new ImageIcon(recursos.getResource("toolbarButtonGraphics/media/Stop24.gif"));
		return imageIcon;
	}

	public static ImageIcon getHome() {
		imageIcon = new ImageIcon(recursos.getResource("toolbarButtonGraphics/navigation/Up24.gif"));
		return imageIcon;
	}

	public static ImageIcon getImprimir() {
		imageIcon = new ImageIcon(recursos.getResource("toolbarButtonGraphics/general/Print24.gif"));
		return imageIcon;
	}

	public static ImageIcon getImprimiRegistro() {
		imageIcon = new ImageIcon(recursos.getResource("toolbarButtonGraphics/general/Print24.gif"));
		return imageIcon;
	}

	public static ImageIcon getImprimiRelatorio() {
		imageIcon = new ImageIcon(recursos.getResource("toolbarButtonGraphics/development/J2EEServer24.gif"));
		return imageIcon;
	}

	public static ImageIcon getInserir() {
		imageIcon = new ImageIcon(recursos.getResource("toolbarButtonGraphics/general/Add24.gif"));
		return imageIcon;
	}

	public static Image getLogoTipoImage() {

		caminhoImagem = recursos.getResource("arquitetura/gui/logo.png");
		iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
		return iconeTitulo;
	}

	public static ImageIcon getLogoTipoImageIcon() {
		imageIcon = new ImageIcon(recursos.getResource("arquitetura/gui/phoenix.png"));
		return imageIcon;
	}

	public static ImageIcon getNovoFrame() {
		imageIcon = new ImageIcon(recursos.getResource("toolbarButtonGraphics/general/New24.gif"));
		return imageIcon;
	}

	public static ImageIcon getpesquisarRegistro() {
		imageIcon = new ImageIcon(recursos.getResource("toolbarButtonGraphics/general/Find24.gif"));
		return imageIcon;
	}

	public static ImageIcon getSair() {
		imageIcon = new ImageIcon(recursos.getResource("toolbarButtonGraphics/general/Stop24.gif"));
		return imageIcon;
	}

	public static ImageIcon getSalva() {
		imageIcon = new ImageIcon(recursos.getResource("toolbarButtonGraphics/general/Save24.gif"));
		return imageIcon;
	}

	public static ImageIcon getSobre() {
		imageIcon = new ImageIcon(recursos.getResource("toolbarButtonGraphics/general/About24.gif"));
		return imageIcon;
	}

	public static ImageIcon getSplash() {
		imageIcon = new ImageIcon(recursos.getResource("erp/imagens/splash.png"));
		return imageIcon;
	}

	public static ImageIcon getUltimo() {
		imageIcon = new ImageIcon(recursos.getResource("toolbarButtonGraphics/media/StepForward24.gif"));
		return imageIcon;
	}

	public static ImageIcon getVisualizarImpressao() {
		imageIcon = new ImageIcon(recursos.getResource("toolbarButtonGraphics/general/PrintPreview24.gif"));
		return imageIcon;
	}
}
