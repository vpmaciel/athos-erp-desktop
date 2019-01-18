package erp.funcionario;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.Gui;

@SuppressWarnings("serial")
public final class FuncionarioFp extends JFrame implements Gui {

	private FuncionarioPp FuncionarioPp;

	public FuncionarioFp() {
		iniciarLayout();
		iniciarGui();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return null;
	}

	public FuncionarioPp getFuncionarioPp() {
		return FuncionarioPp;
	}

	@Override
	public void iniciarFocoControlador() {

	}

	@Override
	public void iniciarGui() {
		setIconImage(arquitetura.gui.Imagem.getLogoTipoImage());
		FuncionarioPp = new FuncionarioPp();
		setContentPane(FuncionarioPp);
	}

	@Override
	public void iniciarGuiControlador() {

	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		FuncionarioPp.iniciarControlador();
	}

	@Override
	public void iniciarLayout() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(800, 600));
		setSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
	}

	@Override
	public void iniciarTabela() {

	}

	@Override
	public void limparGui() {

	}

	@Override
	public void reiniciarGui() {

	}
}
