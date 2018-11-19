package erp.veiculo.modelo;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import erp.aop.gui.Gui;
import erp.aop.gui.GuiHandle;

@SuppressWarnings("serial")
public final class FramePesquisaVeiculoModelo extends JFrame implements Gui {

	private PanelPesquisaVeiculoModelo PanelPesquisaVeiculoModelo;

	public FramePesquisaVeiculoModelo() {
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

	public PanelPesquisaVeiculoModelo getPanelPesquisaVeiculoModelo() {
		return PanelPesquisaVeiculoModelo;
	}

	@Override
	public void iniciarFocusTabListener() {

	}

	@Override
	public void iniciarGui() {
		setTitle("VEÍCULO - MODELO");
		setIconImage(erp.aop.gui.Imagem.getLogoTipoImage());
		PanelPesquisaVeiculoModelo = new PanelPesquisaVeiculoModelo();
		setContentPane(PanelPesquisaVeiculoModelo);
	}

	@Override
	public void iniciarGuiGerenteEventos() {

	}

	@Override
	public void iniciarGerenteEventos() {
		PanelPesquisaVeiculoModelo.iniciarHandle();
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
