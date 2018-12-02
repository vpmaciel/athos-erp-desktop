package erp.funcionario;

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

@SuppressWarnings("serial")
public final class FrameCadastroFuncionario extends JFrame implements Gui {

	private FuncionarioGerenteEventos funcionarioGerenteEventos;
	private GuiGerenteEventos guiGerenteEventos;
	private PanelCadastroFuncionario panelCadastroFuncionario;

	public FrameCadastroFuncionario() {
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

	public FuncionarioGerenteEventos getFuncionarioHandle() {
		return funcionarioGerenteEventos;
	}

	@Override
	public GuiGerenteEventos getGuiGerenteEventos() {
		return guiGerenteEventos;
	}

	public PanelCadastroFuncionario getPanelCadastroFuncionario() {
		return panelCadastroFuncionario;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("FUNCIONÁRIO");
		setIconImage(arquitetura.gui.Imagem.getLogoTipoImage());
		panelCadastroFuncionario = new PanelCadastroFuncionario();
		panelCadastroFuncionario.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroFuncionario);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroFuncionario.isAncestorOf(focused)) {
							panelCadastroFuncionario.scrollRectToVisible(focused.getBounds());
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
		funcionarioGerenteEventos = new FuncionarioGerenteEventos();
		panelCadastroFuncionario.getLabelCentroCusto()
				.addMouseListener(funcionarioGerenteEventos.new MostraFrameCentroCusto());
		addWindowListener(funcionarioGerenteEventos.new Frame());
		panelCadastroFuncionario.getToolBar().getButtonExcluiRegistro()
				.addActionListener(funcionarioGerenteEventos.new ExcluiRegistro());
		panelCadastroFuncionario.getToolBar().getButtonNovoFrame()
				.addActionListener(funcionarioGerenteEventos.new NovoFrame());
		panelCadastroFuncionario.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(funcionarioGerenteEventos.new PesquisaRegistro());
		panelCadastroFuncionario.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(funcionarioGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroFuncionario.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(funcionarioGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroFuncionario.getToolBar().getButtonSalvar()
				.addActionListener(funcionarioGerenteEventos.new Salva());
		panelCadastroFuncionario.getToolBar().getButtonFechar()
				.addActionListener(funcionarioGerenteEventos.new FechaJanela());
		panelCadastroFuncionario.getToolBar().getButtonSair()
				.addActionListener(funcionarioGerenteEventos.new SaidaSistema());
		panelCadastroFuncionario.getToolBar().getButtonAjuda().addActionListener(funcionarioGerenteEventos.new Ajuda());
		panelCadastroFuncionario.getToolBar().getButtonHome().addActionListener(funcionarioGerenteEventos.new Home());

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
		panelCadastroFuncionario.reiniciarBox();
	}
}
