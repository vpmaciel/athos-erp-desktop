package erp.agenda.evento;

import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import erp.aop.gui.FocusTabListener;
import erp.aop.gui.Gui;
import erp.aop.gui.GuiHandle;
import erp.aop.gui.Imagem;

@SuppressWarnings("serial")
public final class FrameCadastroEvento extends JFrame implements Gui {

	private EventoGerenteEventos eventoGerenteEventos;
	private GuiHandle guiHandle;
	private PanelCadastroEvento panelCadastroEvento;

	public FrameCadastroEvento() {
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

	public EventoGerenteEventos getEventoGerenteEventos() {
		return eventoGerenteEventos;
	}

	@Override
	public GuiHandle getGuiGerenteEventos() {
		return guiHandle;
	}

	public PanelCadastroEvento getPanelCadastroEvento() {
		return panelCadastroEvento;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("AGENDA");
		setIconImage(Imagem.getLogoTipoImage());

		panelCadastroEvento = new PanelCadastroEvento();
		panelCadastroEvento.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroEvento);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroEvento.isAncestorOf(focused)) {
							panelCadastroEvento.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();
	}

	@Override
	public void iniciarGuiGerenteEventos() {
		guiHandle = new GuiHandle(this);
	}

	@Override
	public void iniciarGerenteEventos() {
		eventoGerenteEventos = new EventoGerenteEventos();
		addWindowListener(eventoGerenteEventos.new Frame());
		panelCadastroEvento.getLabelEmpresa().addMouseListener(eventoGerenteEventos.new MostraFrameEmpresa());
		panelCadastroEvento.getToolBar().getButtonExcluiRegistro().addActionListener(eventoGerenteEventos.new ExcluiRegistro());
		panelCadastroEvento.getToolBar().getButtonNovoFrame().addActionListener(eventoGerenteEventos.new NovoFrame());
		panelCadastroEvento.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(eventoGerenteEventos.new PesquisaRegistro());
		panelCadastroEvento.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(eventoGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroEvento.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(eventoGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroEvento.getToolBar().getButtonSalvar().addActionListener(eventoGerenteEventos.new Salva());
		panelCadastroEvento.getToolBar().getButtonFechar().addActionListener(eventoGerenteEventos.new FechaJanela());
		panelCadastroEvento.getToolBar().getButtonSair().addActionListener(eventoGerenteEventos.new SaidaSistema());
		panelCadastroEvento.getToolBar().getButtonAjuda().addActionListener(eventoGerenteEventos.new Ajuda());
		panelCadastroEvento.getToolBar().getButtonHome().addActionListener(eventoGerenteEventos.new Home());

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
		guiHandle.limparGui();
	}

	@Override
	public void reiniciarBox() {
		panelCadastroEvento.reiniciarBox();
	}
}
