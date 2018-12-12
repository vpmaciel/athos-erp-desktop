package erp.cartorio;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.Gui;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class CartorioFp extends JFrame implements Gui {

	private CartorioPp CartorioPp;

	public CartorioFp() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		iniciarLayout();
		iniciarGUI();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGui getGUIConfiguracao() {
		return null;
	}

	public CartorioPp getCartorioPp() {
		return CartorioPp;
	}

	public void habilitarPesquisaRegistroGui() {
	}

	@Override
	public void iniciarFocoControlador() {

	}

	@Override
	public void iniciarGUI() {
		setTitle("CARTÓRIO");
		setIconImage(Imagem.getLogoTipoImage());
		CartorioPp = new CartorioPp();
		setContentPane(CartorioPp);
	}

	@Override
	public void iniciarGUIControlador() {

	}

	@Override
	public void iniciarControlador() {
		CartorioPp.iniciarHandle();
	}

	@Override
	public void iniciarLayout() {
		setLayout(null);
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(800, 600));
		setSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
	}

	@Override
	public void iniciarTabela() {

	}

	@Override
	public void limparGUI() {

	}

	@Override
	public void reiniciarGUI() {

	}
}
