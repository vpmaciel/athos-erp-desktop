package erp.centrocusto;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.Sis;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.Gui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class CentroCustoFp extends JFrame implements Gui {

	private CentroCustoPp CentroCustoPp;

	public CentroCustoFp() {
		iniciarLayout();
		iniciarGui();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public CentroCustoPp getCentroCustoPp() {
		return CentroCustoPp;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return null;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		CentroCustoPp.iniciarControlador();
	}

	@Override
	public void iniciarFocoControlador() {

	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());
		CentroCustoPp = new CentroCustoPp();
		setContentPane(CentroCustoPp);
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
