package erp.curriculo.experienciaprofissional;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.Sis;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.Gui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class ExperienciaProfissionalFp extends JFrame implements Gui {

	private ExperienciaProfissionalPp experienciaProfissionalPp;

	public ExperienciaProfissionalFp() {
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

	public ExperienciaProfissionalPp getExperienciaProfissionalPp() {
		return experienciaProfissionalPp;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		experienciaProfissionalPp.iniciarControlador();
	}

	@Override
	public void iniciarFocoControlador() {

	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());
		experienciaProfissionalPp = new ExperienciaProfissionalPp();
		setContentPane(experienciaProfissionalPp);
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
