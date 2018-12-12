package erp.veiculo.modelo;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.Gui;
import arquitetura.gui.ConfiguracaoGui;

@SuppressWarnings("serial")
public final class VeiculoModeloFp extends JFrame implements Gui {

	private VeiculoModeloPp VeiculoModeloPp;

	public VeiculoModeloFp() {
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

	public VeiculoModeloPp getVeiculoModeloPp() {
		return VeiculoModeloPp;
	}

	@Override
	public void iniciarFocoControlador() {

	}

	@Override
	public void iniciarGui() {
		setIconImage(arquitetura.gui.Imagem.getLogoTipoImage());
		VeiculoModeloPp = new VeiculoModeloPp();
		setContentPane(VeiculoModeloPp);
	}

	@Override
	public void iniciarGuiControlador() {

	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		VeiculoModeloPp.iniciarControlador();
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
	public void limparGui() {

	}

	@Override
	public void reiniciarGui() {

	}
}
