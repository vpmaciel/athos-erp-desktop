package erp.agenda.tarefa;

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
public final class FrameCadastroTarefa extends JFrame implements Gui {

	private TarefaGerenteEventos tarefaGerenteEventos;
	private GuiHandle guiHandle;
	private PanelCadastroTarefa panelCadastroTarefa;

	public FrameCadastroTarefa() {
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

	@Override
	public GuiHandle getGuiGerenteEventos() {
		return guiHandle;
	}

	public PanelCadastroTarefa getPanelCadastroTarefa() {
		return panelCadastroTarefa;
	}

	public TarefaGerenteEventos getTarefaHandle() {
		return tarefaGerenteEventos;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("TAREFA");
		setIconImage(Imagem.getLogoTipoImage());
		panelCadastroTarefa = new PanelCadastroTarefa();
		panelCadastroTarefa.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroTarefa);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroTarefa.isAncestorOf(focused)) {
							panelCadastroTarefa.scrollRectToVisible(focused.getBounds());
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
		tarefaGerenteEventos = new TarefaGerenteEventos();
		addWindowListener(tarefaGerenteEventos.new Frame());
		panelCadastroTarefa.getLabelEmpresa().addMouseListener(tarefaGerenteEventos.new MostraFrameEmpresa());
		panelCadastroTarefa.getToolBar().getButtonExcluiRegistro().addActionListener(tarefaGerenteEventos.new ExcluiRegistro());
		panelCadastroTarefa.getToolBar().getButtonNovoFrame().addActionListener(tarefaGerenteEventos.new NovoFrameTarefa());
		panelCadastroTarefa.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(tarefaGerenteEventos.new PesquisaRegistro());
		panelCadastroTarefa.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(tarefaGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroTarefa.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(tarefaGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroTarefa.getToolBar().getButtonSalvar().addActionListener(tarefaGerenteEventos.new Salva());
		panelCadastroTarefa.getToolBar().getButtonFechar().addActionListener(tarefaGerenteEventos.new FechaJanela());
		panelCadastroTarefa.getToolBar().getButtonSair().addActionListener(tarefaGerenteEventos.new SaidaSistema());
		panelCadastroTarefa.getToolBar().getButtonAjuda().addActionListener(tarefaGerenteEventos.new Ajuda());
		panelCadastroTarefa.getToolBar().getButtonHome().addActionListener(tarefaGerenteEventos.new Home());

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
		panelCadastroTarefa.reiniciarBox();
	}
}
