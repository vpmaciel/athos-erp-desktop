package erp.veiculomarca;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.Gui;
import arquitetura.gui.GuiGerenteEventos;

@SuppressWarnings("serial")
public final class FPVeiculoMarca extends JFrame implements Gui {

	private PPVeiculoMarca PPVeiculoMarca;

	public FPVeiculoMarca() {
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

	public PPVeiculoMarca getPanelPesquisaVeiculoMarca() {
		return PPVeiculoMarca;
	}

	@Override
	public void iniciarFocusTabListener() {

	}

	@Override
	public void iniciarGui() {
		setTitle("VEÍCULO - MARCA");
		setIconImage(arquitetura.gui.Imagem.getLogoTipoImage());
		PPVeiculoMarca = new PPVeiculoMarca();
		setContentPane(PPVeiculoMarca);
	}

	@Override
	public void iniciarGuiGerenteEventos() {

	}

	@Override
	public void iniciarGerenteEventos() {
		PPVeiculoMarca.iniciarHandle();
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
