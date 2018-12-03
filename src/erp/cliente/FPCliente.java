package erp.cliente;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.Gui;
import arquitetura.gui.GuiGerenteEventos;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class FPCliente extends JFrame implements Gui {

	private PPCliente PPCliente;

	public FPCliente() {
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

	public PPCliente getPanelPesquisaCliente() {
		return PPCliente;
	}

	@Override
	public void iniciarFocusTabListener() {

	}

	@Override
	public void iniciarGui() {
		setTitle("CLIENTE");
		setIconImage(Imagem.getLogoTipoImage());
		PPCliente = new PPCliente();
		setContentPane(PPCliente);
	}

	@Override
	public void iniciarGuiGerenteEventos() {

	}

	@Override
	public void iniciarGerenteEventos() {
		PPCliente.iniciarHandle();
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
