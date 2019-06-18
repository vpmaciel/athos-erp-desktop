package erp.agenda.contato;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.Sis;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.Gui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class ContatoFp extends JFrame implements Gui {

	private ContatoPp ContatoPp;

	public ContatoFp() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
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

	public ContatoPp getContatoPp() {
		return ContatoPp;
	}

	@Override
	public void iniciarControlador() {
		ContatoPp.iniciarCont();
	}

	@Override
	public void iniciarFocoControlador() {

	}

	@Override
	public void iniciarGui() {
		setTitle("CONTATO");
		setIconImage(Imagem.getLogoTipoImage());
		ContatoPp = new ContatoPp();
		setContentPane(ContatoPp);
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
