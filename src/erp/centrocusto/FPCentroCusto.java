package erp.centrocusto;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.Gui;
import arquitetura.gui.GuiGerenteEventos;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class FPCentroCusto extends JFrame implements Gui {

	private PPCentroCusto PPCentroCusto;

	public FPCentroCusto() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		iniciarLayout();
		iniciarGui();
		iniciarGerenteEventos();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public GuiGerenteEventos getGuiGerenteEventos() {
		return null;
	}

	public PPCentroCusto getPanelPesquisaCentroCusto() {
		return PPCentroCusto;
	}

	@Override
	public void iniciarFocusTabListener() {

	}

	@Override
	public void iniciarGui() {
		setTitle("CENTRO DE CUSTO");
		setIconImage(Imagem.getLogoTipoImage());
		PPCentroCusto = new PPCentroCusto();
		setContentPane(PPCentroCusto);
	}

	@Override
	public void iniciarGuiGerenteEventos() {

	}

	@Override
	public void iniciarGerenteEventos() {
		PPCentroCusto.iniciarHandle();
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
