package erp.funcionario;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.GUI;
import arquitetura.gui.ConfiguracaoGUI;

@SuppressWarnings("serial")
public final class FuncionarioFP extends JFrame implements GUI {

	private FuncionarioPP FuncionarioPP;

	public FuncionarioFP() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		iniciarLayout();
		iniciarGUI();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return null;
	}

	public FuncionarioPP getFuncionarioPP() {
		return FuncionarioPP;
	}

	@Override
	public void iniciarFocoControlador() {

	}

	@Override
	public void iniciarGUI() {
		setTitle("FUNCIONÁRIO");
		setIconImage(arquitetura.gui.Imagem.getLogoTipoImage());
		FuncionarioPP = new FuncionarioPP();
		setContentPane(FuncionarioPP);
	}

	@Override
	public void iniciarGUIControlador() {

	}

	@Override
	public void iniciarControlador() {
		FuncionarioPP.iniciarHandle();
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
	public void iniciarTabela() {

	}

	@Override
	public void limparGUI() {

	}

	@Override
	public void reiniciarGUI() {

	}
}
