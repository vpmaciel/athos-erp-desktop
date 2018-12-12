package erp.veiculo.marca;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.Gui;
import arquitetura.gui.ConfiguracaoGui;

@SuppressWarnings("serial")
public final class VeiculoMarcaFp extends JFrame implements Gui {

	private VeiculoMarcaPp VeiculoMarcaPp;

	public VeiculoMarcaFp() {
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

	public VeiculoMarcaPp getVeiculoMarcaPp() {
		return VeiculoMarcaPp;
	}

	@Override
	public void iniciarFocoControlador() {

	}

	@Override
	public void iniciarGui() {
		setIconImage(arquitetura.gui.Imagem.getLogoTipoImage());
		VeiculoMarcaPp = new VeiculoMarcaPp();
		setContentPane(VeiculoMarcaPp);
	}

	@Override
	public void iniciarGuiControlador() {

	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		VeiculoMarcaPp.iniciarControlador();
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
