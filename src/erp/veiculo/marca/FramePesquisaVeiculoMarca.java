package erp.veiculo.marca;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.Gui;
import arquitetura.gui.GuiGerenteEventos;

@SuppressWarnings("serial")
public final class FramePesquisaVeiculoMarca extends JFrame implements Gui {

	private PanelPesquisaVeiculoMarca PanelPesquisaVeiculoMarca;

	public FramePesquisaVeiculoMarca() {
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

	public PanelPesquisaVeiculoMarca getPanelPesquisaVeiculoMarca() {
		return PanelPesquisaVeiculoMarca;
	}

	@Override
	public void iniciarFocusTabListener() {

	}

	@Override
	public void iniciarGui() {
		setTitle("VEÍCULO - MARCA");
		setIconImage(arquitetura.gui.Imagem.getLogoTipoImage());
		PanelPesquisaVeiculoMarca = new PanelPesquisaVeiculoMarca();
		setContentPane(PanelPesquisaVeiculoMarca);
	}

	@Override
	public void iniciarGuiGerenteEventos() {

	}

	@Override
	public void iniciarGerenteEventos() {
		PanelPesquisaVeiculoMarca.iniciarHandle();
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
