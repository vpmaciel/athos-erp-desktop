package erp.agenda.recado;

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
public final class FrameCadastroRecado extends JFrame implements Gui {

	private RecadoGerenteEventos recadoGerenteEventos;
	private GuiGerenteEventos guiGerenteEventos;
	private PanelCadastroRecado panelCadastroRecado;

	public FrameCadastroRecado() {
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
	public GuiGerenteEventos getGuiGerenteEventos() {
		return guiGerenteEventos;
	}

	public PanelCadastroRecado getPanelCadastroRecado() {
		return panelCadastroRecado;
	}

	public RecadoGerenteEventos getRecadoHandle() {
		return recadoGerenteEventos;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("RECADO");
		setIconImage(Imagem.getLogoTipoImage());

		panelCadastroRecado = new PanelCadastroRecado();

		panelCadastroRecado.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroRecado);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroRecado.isAncestorOf(focused)) {
							panelCadastroRecado.scrollRectToVisible(focused.getBounds());
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
		recadoGerenteEventos = new RecadoGerenteEventos();
		addWindowListener(recadoGerenteEventos.new Frame());
		panelCadastroRecado.getLabelEmpresa().addMouseListener(recadoGerenteEventos.new MostraFrameRecado());
		panelCadastroRecado.getToolBar().getButtonExcluiRegistro()
				.addActionListener(recadoGerenteEventos.new ExcluiRegistro());
		panelCadastroRecado.getToolBar().getButtonNovoFrame().addActionListener(recadoGerenteEventos.new NovoFrame());
		panelCadastroRecado.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(recadoGerenteEventos.new PesquisaRegistro());
		panelCadastroRecado.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(recadoGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroRecado.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(recadoGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroRecado.getToolBar().getButtonSalvar().addActionListener(recadoGerenteEventos.new Salva());
		panelCadastroRecado.getToolBar().getButtonFechar().addActionListener(recadoGerenteEventos.new FechaJanela());
		panelCadastroRecado.getToolBar().getButtonSair().addActionListener(recadoGerenteEventos.new SaidaSistema());
		panelCadastroRecado.getToolBar().getButtonAjuda().addActionListener(recadoGerenteEventos.new Ajuda());
		panelCadastroRecado.getToolBar().getButtonHome().addActionListener(recadoGerenteEventos.new Home());

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
		panelCadastroRecado.reiniciarBox();
	}
}
