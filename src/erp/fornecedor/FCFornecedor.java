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
import arquitetura.gui.GuiGerenteEventos;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class FCFornecedor extends JFrame implements Gui {

	private FornecedorControlador fornecedorControlador;
	private GuiGerenteEventos guiGerenteEventos;
	private PCFornecedor pCFornecedor;

	public FCFornecedor() {
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

	public FornecedorControlador getFornecedorHandle() {
		return fornecedorControlador;
	}

	@Override
	public GuiGerenteEventos getGuiGerenteEventos() {
		return guiGerenteEventos;
	}

	public PCFornecedor getPanelCadastroFornecedor() {
		return pCFornecedor;
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
		pCFornecedor = new PCFornecedor();
		pCFornecedor.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pCFornecedor);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pCFornecedor.isAncestorOf(focused)) {
							pCFornecedor.scrollRectToVisible(focused.getBounds());
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
		fornecedorControlador = new FornecedorControlador();
		addWindowListener(fornecedorControlador.new Frame());
		pCFornecedor.getToolBar().getButtonExcluiRegistro()
				.addActionListener(fornecedorControlador.new ExcluiRegistro());
		pCFornecedor.getToolBar().getButtonNovoFrame()
				.addActionListener(fornecedorControlador.new NovoFrame());
		pCFornecedor.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(fornecedorControlador.new PesquisaRegistro());
		pCFornecedor.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(fornecedorControlador.new ImprimiUnicoRegistro());
		pCFornecedor.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(fornecedorControlador.new ImprimiTodosRegistros());
		pCFornecedor.getToolBar().getButtonSalvar().addActionListener(fornecedorControlador.new Salva());
		pCFornecedor.getToolBar().getButtonFechar()
				.addActionListener(fornecedorControlador.new FechaJanela());
		pCFornecedor.getToolBar().getButtonSair()
				.addActionListener(fornecedorControlador.new SaidaSistema());
		pCFornecedor.getToolBar().getButtonAjuda().addActionListener(fornecedorControlador.new Ajuda());
		pCFornecedor.getToolBar().getButtonHome().addActionListener(fornecedorControlador.new Home());
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

	}
}
