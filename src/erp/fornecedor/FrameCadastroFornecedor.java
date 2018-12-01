package erp.fornecedor;

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
import arquitetura.gui.GuiHandle;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class FrameCadastroFornecedor extends JFrame implements Gui {

	private FornecedorGerenteEventos fornecedorGerenteEventos;
	private GuiHandle guiHandle;
	private PanelCadastroFornecedor panelCadastroFornecedor;

	public FrameCadastroFornecedor() {
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

	public FornecedorGerenteEventos getFornecedorHandle() {
		return fornecedorGerenteEventos;
	}

	@Override
	public GuiHandle getGuiGerenteEventos() {
		return guiHandle;
	}

	public PanelCadastroFornecedor getPanelCadastroFornecedor() {
		return panelCadastroFornecedor;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("FORNECEDOR");
		setIconImage(Imagem.getLogoTipoImage());
		panelCadastroFornecedor = new PanelCadastroFornecedor();
		panelCadastroFornecedor.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroFornecedor);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroFornecedor.isAncestorOf(focused)) {
							panelCadastroFornecedor.scrollRectToVisible(focused.getBounds());
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
		fornecedorGerenteEventos = new FornecedorGerenteEventos();
		addWindowListener(fornecedorGerenteEventos.new Frame());
		panelCadastroFornecedor.getToolBar().getButtonExcluiRegistro()
				.addActionListener(fornecedorGerenteEventos.new ExcluiRegistro());
		panelCadastroFornecedor.getToolBar().getButtonNovoFrame()
				.addActionListener(fornecedorGerenteEventos.new NovoFrame());
		panelCadastroFornecedor.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(fornecedorGerenteEventos.new PesquisaRegistro());
		panelCadastroFornecedor.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(fornecedorGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroFornecedor.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(fornecedorGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroFornecedor.getToolBar().getButtonSalvar().addActionListener(fornecedorGerenteEventos.new Salva());
		panelCadastroFornecedor.getToolBar().getButtonFechar()
				.addActionListener(fornecedorGerenteEventos.new FechaJanela());
		panelCadastroFornecedor.getToolBar().getButtonSair()
				.addActionListener(fornecedorGerenteEventos.new SaidaSistema());
		panelCadastroFornecedor.getToolBar().getButtonAjuda().addActionListener(fornecedorGerenteEventos.new Ajuda());
		panelCadastroFornecedor.getToolBar().getButtonHome().addActionListener(fornecedorGerenteEventos.new Home());
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

	}
}
