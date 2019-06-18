package erp.cartorio;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.Sis;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.Gui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class CartorioFp extends JFrame implements Gui {

	private CartorioPp CartorioPp;

	public CartorioFp() {
		iniciarLayout();
		iniciarGui();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public CartorioPp getCartorioPp() {
		return CartorioPp;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return null;
	}

	public void habilitarPesquisaRegistroGui() {
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		CartorioPp.iniciarControlador();
	}

	@Override
	public void iniciarFocoControlador() {

	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());
		CartorioPp = new CartorioPp();
		setContentPane(CartorioPp);
	}

	@Override
	public void iniciarGuiControlador() {

	}

	@Override
	public void iniciarLayout() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setMinimumSize(Sis.getTamanhoJanela());
	}

	@Override
	public void iniciarTabela() {

	}

	@Override
	public void limparGui() {

	}

	@Override
	public void reiniciarGui() {

	}
}
