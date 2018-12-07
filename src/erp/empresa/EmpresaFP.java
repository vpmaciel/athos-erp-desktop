package erp.empresa;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.GUI;
import arquitetura.gui.ConfiguracaoGUI;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class EmpresaFP extends JFrame implements GUI {

	private EmpresaPP EmpresaPP;

	public EmpresaFP() {
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

	public EmpresaPP getEmpresaPP() {
		return EmpresaPP;
	}

	@Override
	public void iniciarFocoControlador() {

	}

	@Override
	public void iniciarGUI() {
		setTitle("EMPRESA");
		setIconImage(Imagem.getLogoTipoImage());
		EmpresaPP = new EmpresaPP();
		setContentPane(EmpresaPP);
	}

	@Override
	public void iniciarGUIControlador() {

	}

	@Override
	public void iniciarControlador() {
		EmpresaPP.iniciarHandle();
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
