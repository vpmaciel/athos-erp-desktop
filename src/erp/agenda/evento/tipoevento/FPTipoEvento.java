package erp.agenda.evento.tipoevento;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import arquitetura.gui.GUI;
import arquitetura.gui.GUIConfiguracao;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class FPTipoEvento extends JFrame implements GUI {

	private PPTipoEvento PPTipoEvento;

	public FPTipoEvento() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		iniciarLayout();
		iniciarGUI();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public GUIConfiguracao getGUIConfiguracao() {
		return null;
	}

	public PPTipoEvento getPanelPesquisaTipoEvento() {
		return PPTipoEvento;
	}

	@Override
	public void iniciarFocoControlador() {

	}

	@Override
	public void iniciarGUI() {
		setTitle("TIPO DE EVENTO");
		setIconImage(Imagem.getLogoTipoImage());
		PPTipoEvento = new PPTipoEvento();
		setContentPane(PPTipoEvento);
	}

	@Override
	public void iniciarGUIControlador() {

	}

	@Override
	public void iniciarControlador() {
		PPTipoEvento.iniciarHandle();
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
