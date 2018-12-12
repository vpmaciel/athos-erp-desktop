package erp.agenda.evento.tipoevento;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.Gui;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class TipoEventoFp extends JFrame implements Gui {

	private TipoEventoPp TipoEventoPp;

	public TipoEventoFp() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		iniciarLayout();
		iniciarGUI();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGui getGUIConfiguracao() {
		return null;
	}

	public TipoEventoPp getTipoEventoPp() {
		return TipoEventoPp;
	}

	@Override
	public void iniciarFocoControlador() {

	}

	@Override
	public void iniciarGUI() {
		setTitle("TIPO DE EVENTO");
		setIconImage(Imagem.getLogoTipoImage());
		TipoEventoPp = new TipoEventoPp();
		setContentPane(TipoEventoPp);
	}

	@Override
	public void iniciarGUIControlador() {

	}

	@Override
	public void iniciarControlador() {
		TipoEventoPp.iniciarHandle();
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
