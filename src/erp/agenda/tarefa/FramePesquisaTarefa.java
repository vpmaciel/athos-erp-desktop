package erp.agenda.tarefa;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import erp.aop.gui.Gui;
import erp.aop.gui.GuiHandle;
import erp.aop.gui.Imagem;

@SuppressWarnings("serial")
public final class FramePesquisaTarefa extends JFrame implements Gui {

	private PanelPesquisaTarefa PanelPesquisaTarefa;

	public FramePesquisaTarefa() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		iniciarLayout();
		iniciarGui();
		iniciarGerenteEventos();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public GuiHandle getGuiGerenteEventos() {
		return null;
	}

	public PanelPesquisaTarefa getPanelPesquisaTarefa() {
		return PanelPesquisaTarefa;
	}

	@Override
	public void iniciarFocusTabListener() {

	}

	@Override
	public void iniciarGui() {
		setTitle("TAREFA");
		setIconImage(Imagem.getLogoTipoImage());
		PanelPesquisaTarefa = new PanelPesquisaTarefa();
		setContentPane(PanelPesquisaTarefa);
	}

	@Override
	public void iniciarGuiGerenteEventos() {

	}

	@Override
	public void iniciarGerenteEventos() {
		PanelPesquisaTarefa.iniciarHandle();
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
	public void iniciarTable() {

	}

	@Override
	public void limparGui() {

	}

	@Override
	public void reiniciarBox() {

	}
}
