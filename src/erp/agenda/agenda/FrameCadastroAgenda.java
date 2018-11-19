package erp.agenda.agenda;

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
public final class FrameCadastroAgenda extends JFrame implements Gui {

	private AgendaGerenteEventos agendaGerenteEventos;
	private GuiHandle guiHandle;
	private PanelCadastroAgenda panelCadastroAgenda;

	public FrameCadastroAgenda() {
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

	public AgendaGerenteEventos getAgendaHandle() {
		return agendaGerenteEventos;
	}

	@Override
	public GuiHandle getGuiGerenteEventos() {
		return guiHandle;
	}

	public PanelCadastroAgenda getPanelCadastroAgenda() {
		return panelCadastroAgenda;
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

		panelCadastroAgenda = new PanelCadastroAgenda();
		panelCadastroAgenda.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroAgenda);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroAgenda.isAncestorOf(focused)) {
							panelCadastroAgenda.scrollRectToVisible(focused.getBounds());
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
		agendaGerenteEventos = new AgendaGerenteEventos();
		addWindowListener(agendaGerenteEventos.new Frame());
		panelCadastroAgenda.getLabelEmpresa().addMouseListener(agendaGerenteEventos.new MostraFrameEmpresa());
		panelCadastroAgenda.getToolBar().getButtonExcluiRegistro().addActionListener(agendaGerenteEventos.new ExcluiRegistro());
		panelCadastroAgenda.getToolBar().getButtonNovoFrame().addActionListener(agendaGerenteEventos.new NovoFrame());
		panelCadastroAgenda.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(agendaGerenteEventos.new PesquisaRegistro());
		panelCadastroAgenda.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(agendaGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroAgenda.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(agendaGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroAgenda.getToolBar().getButtonSalvar().addActionListener(agendaGerenteEventos.new Salva());
		panelCadastroAgenda.getToolBar().getButtonFechar().addActionListener(agendaGerenteEventos.new FechaJanela());
		panelCadastroAgenda.getToolBar().getButtonSair().addActionListener(agendaGerenteEventos.new SaidaSistema());
		panelCadastroAgenda.getToolBar().getButtonAjuda().addActionListener(agendaGerenteEventos.new Ajuda());
		panelCadastroAgenda.getToolBar().getButtonHome().addActionListener(agendaGerenteEventos.new Home());

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
		panelCadastroAgenda.reiniciarBox();
	}
}
