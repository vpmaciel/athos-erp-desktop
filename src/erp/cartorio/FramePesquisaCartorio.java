package erp.cartorio;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.Gui;
import arquitetura.gui.GuiHandle;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class FramePesquisaCartorio extends JFrame implements Gui {

	private PanelPesquisaCartorio PanelPesquisaCartorio;

	public FramePesquisaCartorio() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		iniciarLayout();
		iniciarGui();
		iniciarGerenteEventos();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public GuiHandle getGuiGerenteEventos() {
		return null;
	}

	public PanelPesquisaCartorio getPanelPesquisaCartorio() {
		return PanelPesquisaCartorio;
	}

	public void habilitarPesquisaRegistroGui() {
	}

	@Override
	public void iniciarFocusTabListener() {

	}

	@Override
	public void iniciarGui() {
		setTitle("CARTÓRIO");
		setIconImage(Imagem.getLogoTipoImage());
		PanelPesquisaCartorio = new PanelPesquisaCartorio();
		setContentPane(PanelPesquisaCartorio);
	}

	@Override
	public void iniciarGuiGerenteEventos() {

	}

	@Override
	public void iniciarGerenteEventos() {
		PanelPesquisaCartorio.iniciarHandle();
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
	public void iniciarTable() {

	}

	@Override
	public void limparGui() {

	}

	@Override
	public void reiniciarBox() {

	}
}
