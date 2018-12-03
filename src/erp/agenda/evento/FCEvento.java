package erp.agenda.evento;

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
public final class FCEvento extends JFrame implements Gui {

	private EventoControlador eventoControlador;
	private GuiGerenteEventos guiGerenteEventos;
	private PCEvento pCEvento;

	public FCEvento() {
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

	public EventoControlador getEventoGerenteEventos() {
		return eventoControlador;
	}

	@Override
	public GuiGerenteEventos getGuiGerenteEventos() {
		return guiGerenteEventos;
	}

	public PCEvento getPanelCadastroEvento() {
		return pCEvento;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("EVENTO");
		setIconImage(Imagem.getLogoTipoImage());

		pCEvento = new PCEvento();
		pCEvento.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pCEvento);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pCEvento.isAncestorOf(focused)) {
							pCEvento.scrollRectToVisible(focused.getBounds());
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
		eventoControlador = new EventoControlador();
		addWindowListener(eventoControlador.new Frame());
		pCEvento.getLabelTipoEvento().addMouseListener(eventoControlador.new MostraFrameEmpresa());
		pCEvento.getToolBar().getButtonExcluiRegistro()
				.addActionListener(eventoControlador.new ExcluiRegistro());
		pCEvento.getToolBar().getButtonNovoFrame().addActionListener(eventoControlador.new NovoFrame());
		pCEvento.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(eventoControlador.new PesquisaRegistro());
		pCEvento.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(eventoControlador.new ImprimiUnicoRegistro());
		pCEvento.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(eventoControlador.new ImprimiTodosRegistros());
		pCEvento.getToolBar().getButtonSalvar().addActionListener(eventoControlador.new Salva());
		pCEvento.getToolBar().getButtonFechar().addActionListener(eventoControlador.new FechaJanela());
		pCEvento.getToolBar().getButtonSair().addActionListener(eventoControlador.new SaidaSistema());
		pCEvento.getToolBar().getButtonAjuda().addActionListener(eventoControlador.new Ajuda());
		pCEvento.getToolBar().getButtonHome().addActionListener(eventoControlador.new Home());

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
		pCEvento.reiniciarBox();
	}
}
