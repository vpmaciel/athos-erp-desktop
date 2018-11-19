package erp.agenda.compromisso;

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
public final class FrameCadastroCompromisso extends JFrame implements Gui {

	private CompromissoGerenteEventos compromissoGerenteEventos;
	private GuiHandle guiHandle;
	private PanelCadastroCompromisso panelCadastroCompromisso;

	public FrameCadastroCompromisso() {
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

	public CompromissoGerenteEventos getCompromissoHandle() {
		return compromissoGerenteEventos;
	}

	@Override
	public GuiHandle getGuiGerenteEventos() {
		return guiHandle;
	}

	public PanelCadastroCompromisso getPanelCadastroCompromisso() {
		return panelCadastroCompromisso;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("COMPROMISSO");
		setIconImage(Imagem.getLogoTipoImage());

		panelCadastroCompromisso = new PanelCadastroCompromisso();

		panelCadastroCompromisso.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroCompromisso);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroCompromisso.isAncestorOf(focused)) {
							panelCadastroCompromisso.scrollRectToVisible(focused.getBounds());
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
		compromissoGerenteEventos = new CompromissoGerenteEventos();
		addWindowListener(compromissoGerenteEventos.new Frame());
		panelCadastroCompromisso.getLabelEmpresa().addMouseListener(compromissoGerenteEventos.new MostraFrameCompromisso());
		panelCadastroCompromisso.getToolBar().getButtonExcluiRegistro()
				.addActionListener(compromissoGerenteEventos.new ExcluiRegistro());
		panelCadastroCompromisso.getToolBar().getButtonNovoFrame().addActionListener(compromissoGerenteEventos.new NovoFrame());
		panelCadastroCompromisso.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(compromissoGerenteEventos.new PesquisaRegistro());
		panelCadastroCompromisso.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(compromissoGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroCompromisso.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(compromissoGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroCompromisso.getToolBar().getButtonSalvar().addActionListener(compromissoGerenteEventos.new Salva());
		panelCadastroCompromisso.getToolBar().getButtonFechar().addActionListener(compromissoGerenteEventos.new FechaJanela());
		panelCadastroCompromisso.getToolBar().getButtonSair().addActionListener(compromissoGerenteEventos.new SaidaSistema());
		panelCadastroCompromisso.getToolBar().getButtonAjuda().addActionListener(compromissoGerenteEventos.new Ajuda());
		panelCadastroCompromisso.getToolBar().getButtonHome().addActionListener(compromissoGerenteEventos.new Home());

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
		panelCadastroCompromisso.reiniciarBox();
	}
}
