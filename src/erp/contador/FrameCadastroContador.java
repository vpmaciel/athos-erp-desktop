package erp.contador;

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
public final class FrameCadastroContador extends JFrame implements Gui {

	private ContadorGerenteEventos contadorGerenteEventos;
	private GuiHandle guiHandle;
	private PanelCadastroContador panelCadastroContador;

	public FrameCadastroContador() {
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

	public ContadorGerenteEventos getContadorHandle() {
		return contadorGerenteEventos;
	}

	@Override
	public GuiHandle getGuiGerenteEventos() {
		return guiHandle;
	}

	public PanelCadastroContador getPanelCadastroContador() {
		return panelCadastroContador;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {

		setTitle("CONTADOR");
		setIconImage(Imagem.getLogoTipoImage());
		panelCadastroContador = new PanelCadastroContador();
		panelCadastroContador.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroContador);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroContador.isAncestorOf(focused)) {
							panelCadastroContador.scrollRectToVisible(focused.getBounds());
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
		contadorGerenteEventos = new ContadorGerenteEventos();
		addWindowListener(contadorGerenteEventos.new Frame());
		panelCadastroContador.getToolBar().getButtonExcluiRegistro()
				.addActionListener(contadorGerenteEventos.new ExcluiRegistro());
		panelCadastroContador.getToolBar().getButtonNovoFrame().addActionListener(contadorGerenteEventos.new NovoFrame());
		panelCadastroContador.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(contadorGerenteEventos.new PesquisaRegistro());
		panelCadastroContador.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(contadorGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroContador.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(contadorGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroContador.getToolBar().getButtonSalvar().addActionListener(contadorGerenteEventos.new Salva());
		panelCadastroContador.getToolBar().getButtonFechar().addActionListener(contadorGerenteEventos.new FechaJanela());
		panelCadastroContador.getToolBar().getButtonSair().addActionListener(contadorGerenteEventos.new SaidaSistema());
		panelCadastroContador.getToolBar().getButtonAjuda().addActionListener(contadorGerenteEventos.new Ajuda());
		panelCadastroContador.getToolBar().getButtonHome().addActionListener(contadorGerenteEventos.new Home());
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
