package erp.funcionario;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.Gui;
import arquitetura.gui.GuiGerenteEventos;

@SuppressWarnings("serial")
public final class FPFuncionario extends JFrame implements Gui {

	private PPFuncionario PPFuncionario;

	public FPFuncionario() {
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

	public PPFuncionario getPanelPesquisaFuncionario() {
		return PPFuncionario;
	}

	@Override
	public void iniciarFocusTabListener() {

	}

	@Override
	public void iniciarGui() {
		setTitle("FUNCIONÁRIO");
		setIconImage(arquitetura.gui.Imagem.getLogoTipoImage());
		PPFuncionario = new PPFuncionario();
		setContentPane(PPFuncionario);
	}

	@Override
	public void iniciarGuiGerenteEventos() {

	}

	@Override
	public void iniciarGerenteEventos() {
		PPFuncionario.iniciarHandle();
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
