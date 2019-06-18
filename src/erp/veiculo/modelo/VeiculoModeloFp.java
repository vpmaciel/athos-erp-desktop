package erp.veiculo.modelo;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.Sis;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.Gui;

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
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		VeiculoModeloPp.iniciarControlador();
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
	public void iniciarLayout() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setMinimumSize(Sis.getTamanhoJanela());
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
