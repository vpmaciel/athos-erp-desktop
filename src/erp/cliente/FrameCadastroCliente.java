package erp.cliente;

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
public final class FrameCadastroCliente extends JFrame implements Gui {

	private ClienteGerenteEventos clienteGerenteEventos;
	private GuiHandle guiHandle;
	private PanelCadastroCliente panelCadastroCliente;

	public FrameCadastroCliente() {
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

	public ClienteGerenteEventos getClienteHandle() {
		return clienteGerenteEventos;
	}

	@Override
	public GuiHandle getGuiGerenteEventos() {
		return guiHandle;
	}

	public PanelCadastroCliente getPanelCadastroCliente() {
		return panelCadastroCliente;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("CLIENTE");
		setIconImage(Imagem.getLogoTipoImage());

		panelCadastroCliente = new PanelCadastroCliente();
		panelCadastroCliente.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroCliente);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroCliente.isAncestorOf(focused)) {
							panelCadastroCliente.scrollRectToVisible(focused.getBounds());
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
		clienteGerenteEventos = new ClienteGerenteEventos();
		addWindowListener(clienteGerenteEventos.new Frame());
		panelCadastroCliente.getLabelEmpresa().addMouseListener(clienteGerenteEventos.new MostraFrame());
		panelCadastroCliente.getLabelBanco().addMouseListener(clienteGerenteEventos.new MostraFrame());
		panelCadastroCliente.getToolBar().getButtonExcluiRegistro()
				.addActionListener(clienteGerenteEventos.new ExcluiRegistro());
		panelCadastroCliente.getToolBar().getButtonNovoFrame().addActionListener(clienteGerenteEventos.new NovoFrame());
		panelCadastroCliente.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(clienteGerenteEventos.new PesquisaRegistro());
		panelCadastroCliente.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(clienteGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroCliente.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(clienteGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroCliente.getToolBar().getButtonSalvar().addActionListener(clienteGerenteEventos.new Salva());
		panelCadastroCliente.getToolBar().getButtonFechar().addActionListener(clienteGerenteEventos.new FechaJanela());
		panelCadastroCliente.getToolBar().getButtonSair().addActionListener(clienteGerenteEventos.new SaidaSistema());
		panelCadastroCliente.getToolBar().getButtonAjuda().addActionListener(clienteGerenteEventos.new Ajuda());
		panelCadastroCliente.getToolBar().getButtonHome().addActionListener(clienteGerenteEventos.new Home());
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
		panelCadastroCliente.reiniciarBox();
	}
}
