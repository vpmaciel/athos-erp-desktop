package erp.empresa;

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
public final class FrameCadastroEmpresa extends JFrame implements Gui {

	private EmpresaGerenteEventos empresaGerenteEventos;
	private GuiHandle guiHandle;
	private PanelCadastroEmpresa panelCadastroEmpresa;

	public FrameCadastroEmpresa() {
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

	public EmpresaGerenteEventos getEmpresaHandle() {
		return empresaGerenteEventos;
	}

	@Override
	public GuiHandle getGuiGerenteEventos() {
		return guiHandle;
	}

	public PanelCadastroEmpresa getPanelCadastroEmpresa() {
		return panelCadastroEmpresa;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("EMPRESA");
		setIconImage(Imagem.getLogoTipoImage());
		panelCadastroEmpresa = new PanelCadastroEmpresa();
		panelCadastroEmpresa.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroEmpresa);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroEmpresa.isAncestorOf(focused)) {
							panelCadastroEmpresa.scrollRectToVisible(focused.getBounds());
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
		empresaGerenteEventos = new EmpresaGerenteEventos();
		addWindowListener(empresaGerenteEventos.new Frame());
		panelCadastroEmpresa.getToolBar().getButtonExcluiRegistro()
				.addActionListener(empresaGerenteEventos.new ExcluiRegistro());
		panelCadastroEmpresa.getToolBar().getButtonNovoFrame().addActionListener(empresaGerenteEventos.new NovoFrame());
		panelCadastroEmpresa.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(empresaGerenteEventos.new PesquisaRegistro());
		panelCadastroEmpresa.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(empresaGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroEmpresa.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(empresaGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroEmpresa.getToolBar().getButtonSalvar().addActionListener(empresaGerenteEventos.new Salva());
		panelCadastroEmpresa.getToolBar().getButtonFechar().addActionListener(empresaGerenteEventos.new FechaJanela());
		panelCadastroEmpresa.getToolBar().getButtonSair().addActionListener(empresaGerenteEventos.new SaidaSistema());
		panelCadastroEmpresa.getToolBar().getButtonAjuda().addActionListener(empresaGerenteEventos.new Ajuda());
		panelCadastroEmpresa.getToolBar().getButtonHome().addActionListener(empresaGerenteEventos.new Home());
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
