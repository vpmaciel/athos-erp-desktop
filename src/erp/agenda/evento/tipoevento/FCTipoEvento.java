package erp.agenda.evento.tipoevento;

import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import arquitetura.gui.FocusTabListener;
import arquitetura.gui.Gui;
import arquitetura.gui.GuiGerenteEventos;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class FCTipoEvento extends JFrame implements Gui {

	private TipoEventoControlador tipoEventoControlador;
	private GuiGerenteEventos guiGerenteEventos;
	private PCTipoEvento pCTipoEvento;

	public FCTipoEvento() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		iniciarLayout();
		iniciarGui();
		iniciarFocusTabListener();
		iniciarGuiGerenteEventos();
		iniciarGerenteEventos();
	}

	@Override
	public void atualizarTable() {

	}

	public TipoEventoControlador getTipoEventoGerenteEventos() {
		return tipoEventoControlador;
	}

	@Override
	public GuiGerenteEventos getGuiGerenteEventos() {
		return guiGerenteEventos;
	}

	public PCTipoEvento getPanelCadastroTipoEvento() {
		return pCTipoEvento;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("TIPO DE EVENTO");
		setIconImage(Imagem.getLogoTipoImage());

		pCTipoEvento = new PCTipoEvento();
		pCTipoEvento.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pCTipoEvento);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pCTipoEvento.isAncestorOf(focused)) {
							pCTipoEvento.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();
	}

	@Override
	public void iniciarGuiGerenteEventos() {
		guiGerenteEventos = new GuiGerenteEventos(this);
	}

	@Override
	public void iniciarGerenteEventos() {
		tipoEventoControlador = new TipoEventoControlador();
		addWindowListener(tipoEventoControlador.new Frame());
		pCTipoEvento.getToolBar().getButtonExcluiRegistro()
				.addActionListener(tipoEventoControlador.new ExcluiRegistro());
		pCTipoEvento.getToolBar().getButtonNovoFrame()
				.addActionListener(tipoEventoControlador.new NovoFrame());
		pCTipoEvento.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(tipoEventoControlador.new PesquisaRegistro());
		pCTipoEvento.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(tipoEventoControlador.new ImprimiUnicoRegistro());
		pCTipoEvento.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(tipoEventoControlador.new ImprimiTodosRegistros());
		pCTipoEvento.getToolBar().getButtonSalvar().addActionListener(tipoEventoControlador.new Salva());
		pCTipoEvento.getToolBar().getButtonFechar()
				.addActionListener(tipoEventoControlador.new FechaJanela());
		pCTipoEvento.getToolBar().getButtonSair()
				.addActionListener(tipoEventoControlador.new SaidaSistema());
		pCTipoEvento.getToolBar().getButtonAjuda().addActionListener(tipoEventoControlador.new Ajuda());
		pCTipoEvento.getToolBar().getButtonHome().addActionListener(tipoEventoControlador.new Home());

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
		guiGerenteEventos.limparGui();
	}

	@Override
	public void reiniciarBox() {
		pCTipoEvento.reiniciarBox();
	}
}
