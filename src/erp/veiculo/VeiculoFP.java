package erp.veiculo;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.GUI;
import arquitetura.gui.ConfiguracaoGUI;

@SuppressWarnings("serial")
public final class VeiculoFP extends JFrame implements GUI {

	private VeiculoPP VeiculoPP;

	public VeiculoFP() {
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

	public VeiculoPP getPanelPesquisaVeiculo() {
		return VeiculoPP;
	}

	@Override
	public void iniciarFocoControlador() {

	}

	@Override
	public void iniciarGUI() {
		setTitle("VEÍCULO");
		setIconImage(arquitetura.gui.Imagem.getLogoTipoImage());
		VeiculoPP = new VeiculoPP();
		setContentPane(VeiculoPP);
	}

	@Override
	public void iniciarGUIControlador() {

	}

	@Override
	public void iniciarControlador() {
		VeiculoPP.iniciarHandle();
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
