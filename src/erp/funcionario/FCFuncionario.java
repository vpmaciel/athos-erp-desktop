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
import arquitetura.gui.GUI;
import arquitetura.gui.GUIConfiguracao;

@SuppressWarnings("serial")
public final class FCFuncionario extends JFrame implements GUI {

	private FuncionarioControlador funcionarioControlador;
	private GUIConfiguracao gUIConfiguracao;
	private PCFuncionario pCFuncionario;

	public FCFuncionario() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		iniciarLayout();
		iniciarGUI();
		iniciarFocoControlador();
		iniciarGUIControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public FuncionarioControlador getFuncionarioHandle() {
		return funcionarioControlador;
	}

	@Override
	public GUIConfiguracao getGUIConfiguracao() {
		return gUIConfiguracao;
	}

	public PCFuncionario getPanelCadastroFuncionario() {
		return pCFuncionario;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("FUNCIONÁRIO");
		setIconImage(arquitetura.gui.Imagem.getLogoTipoImage());
		pCFuncionario = new PCFuncionario();
		pCFuncionario.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pCFuncionario);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pCFuncionario.isAncestorOf(focused)) {
							pCFuncionario.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();
	}

	@Override
	public void iniciarGUIControlador() {
		gUIConfiguracao = new GUIConfiguracao(this);
	}

	@Override
	public void iniciarControlador() {
		funcionarioControlador = new FuncionarioControlador();
		pCFuncionario.getLabelCentroCusto()
				.addMouseListener(funcionarioControlador.new MostraFrameCentroCusto());
		addWindowListener(funcionarioControlador.new Frame());
		pCFuncionario.getToolBar().getButtonExcluiRegistro()
				.addActionListener(funcionarioControlador.new ExcluiRegistro());
		pCFuncionario.getToolBar().getButtonNovoFrame()
				.addActionListener(funcionarioControlador.new NovoFrame());
		pCFuncionario.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(funcionarioControlador.new PesquisaRegistro());
		pCFuncionario.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(funcionarioControlador.new ImprimiUnicoRegistro());
		pCFuncionario.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(funcionarioControlador.new ImprimiTodosRegistros());
		pCFuncionario.getToolBar().getButtonSalvar()
				.addActionListener(funcionarioControlador.new Salva());
		pCFuncionario.getToolBar().getButtonFechar()
				.addActionListener(funcionarioControlador.new FechaJanela());
		pCFuncionario.getToolBar().getButtonSair()
				.addActionListener(funcionarioControlador.new SaidaSistema());
		pCFuncionario.getToolBar().getButtonAjuda().addActionListener(funcionarioControlador.new Ajuda());
		pCFuncionario.getToolBar().getButtonHome().addActionListener(funcionarioControlador.new Home());

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
		gUIConfiguracao.limparGui();
	}

	@Override
	public void reiniciarGUI() {
		pCFuncionario.reiniciarGUI();
	}
}
