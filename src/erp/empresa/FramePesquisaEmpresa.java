package erp.empresa;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import erp.aop.gui.Gui;
import erp.aop.gui.GuiHandle;
import erp.aop.gui.Imagem;

@SuppressWarnings("serial")
public final class FramePesquisaEmpresa extends JFrame implements Gui {

	private PanelPesquisaEmpresa PanelPesquisaEmpresa;

	public FramePesquisaEmpresa() {
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

	public PanelPesquisaEmpresa getPanelPesquisaEmpresa() {
		return PanelPesquisaEmpresa;
	}

	@Override
	public void iniciarFocusTabListener() {

	}

	@Override
	public void iniciarGui() {
		setTitle("EMPRESA");
		setIconImage(Imagem.getLogoTipoImage());
		PanelPesquisaEmpresa = new PanelPesquisaEmpresa();
		setContentPane(PanelPesquisaEmpresa);
	}

	@Override
	public void iniciarGuiGerenteEventos() {

	}

	@Override
	public void iniciarGerenteEventos() {
		PanelPesquisaEmpresa.iniciarHandle();
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
