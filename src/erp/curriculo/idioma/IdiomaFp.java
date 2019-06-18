package erp.curriculo.idioma;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.Sis;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.Gui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class IdiomaFp extends JFrame implements Gui {

	private IdiomaPp idiomaPp;

	public IdiomaFp() {
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

	public IdiomaPp getIdiomaPp() {
		return idiomaPp;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		idiomaPp.iniciarControlador();
	}

	@Override
	public void iniciarFocoControlador() {

	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());
		idiomaPp = new IdiomaPp();
		setContentPane(idiomaPp);
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
