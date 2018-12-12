package erp.veiculo.modelo;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.GUI;
import arquitetura.gui.ConfiguracaoGUI;

@SuppressWarnings("serial")
public final class VeiculoModeloFp extends JFrame implements GUI {

	private VeiculoModeloPp VeiculoModeloPp;

	public VeiculoModeloFp() {
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

	public VeiculoModeloPp getVeiculoModeloPp() {
		return VeiculoModeloPp;
	}

	@Override
	public void iniciarFocoControlador() {

	}

	@Override
	public void iniciarGUI() {
		setTitle("VEÍCULO - MODELO");
		setIconImage(arquitetura.gui.Imagem.getLogoTipoImage());
		VeiculoModeloPp = new VeiculoModeloPp();
		setContentPane(VeiculoModeloPp);
	}

	@Override
	public void iniciarGUIControlador() {

	}

	@Override
	public void iniciarControlador() {
		VeiculoModeloPp.iniciarHandle();
	}

	@Override
	public void iniciarLayout() {
		setLayout(null);
		setPreferredSize(new Dimension(800, 420));
		setMinimumSize(new Dimension(800, 420));
		setSize(new Dimension(800, 420));
		setMaximumSize(new Dimension(800, 420));
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
