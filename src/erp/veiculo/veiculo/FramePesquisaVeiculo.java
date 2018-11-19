package erp.veiculo.veiculo;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import erp.aop.gui.Gui;
import erp.aop.gui.GuiHandle;

@SuppressWarnings("serial")
public final class FramePesquisaVeiculo extends JFrame implements Gui {

	private PanelPesquisaVeiculo PanelPesquisaVeiculo;

	public FramePesquisaVeiculo() {
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

	public PanelPesquisaVeiculo getPanelPesquisaVeiculo() {
		return PanelPesquisaVeiculo;
	}

	@Override
	public void iniciarFocusTabListener() {

	}

	@Override
	public void iniciarGui() {
		setTitle("VEÍCULO");
		setIconImage(erp.aop.gui.Imagem.getLogoTipoImage());
		PanelPesquisaVeiculo = new PanelPesquisaVeiculo();
		setContentPane(PanelPesquisaVeiculo);
	}

	@Override
	public void iniciarGuiGerenteEventos() {

	}

	@Override
	public void iniciarGerenteEventos() {
		PanelPesquisaVeiculo.iniciarHandle();
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
