package erp.veiculomodelo;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.Gui;
import arquitetura.gui.GuiGerenteEventos;

@SuppressWarnings("serial")
public final class FPVeiculoModelo extends JFrame implements Gui {

	private PPVeiculoModelo PPVeiculoModelo;

	public FPVeiculoModelo() {
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

	public PPVeiculoModelo getPanelPesquisaVeiculoModelo() {
		return PPVeiculoModelo;
	}

	@Override
	public void iniciarFocusTabListener() {

	}

	@Override
	public void iniciarGui() {
		setTitle("VEÍCULO - MODELO");
		setIconImage(arquitetura.gui.Imagem.getLogoTipoImage());
		PPVeiculoModelo = new PPVeiculoModelo();
		setContentPane(PPVeiculoModelo);
	}

	@Override
	public void iniciarGuiGerenteEventos() {

	}

	@Override
	public void iniciarGerenteEventos() {
		PPVeiculoModelo.iniciarHandle();
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
