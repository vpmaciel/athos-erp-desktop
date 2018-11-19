package erp.cartorio;

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
public final class FrameCadastroCartorio extends JFrame implements Gui {

	private CartorioGerenteEventos cartorioGerenteEventos;
	private GuiHandle guiHandle;
	private PanelCadastroCartorio panelCadastroCartorio;

	public FrameCadastroCartorio() {
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

	public CartorioGerenteEventos getCartorioHandle() {
		return cartorioGerenteEventos;
	}

	@Override
	public GuiHandle getGuiGerenteEventos() {
		return guiHandle;
	}

	public PanelCadastroCartorio getPanelCadastroCartorio() {
		return panelCadastroCartorio;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("CARTÓRIO");
		setIconImage(Imagem.getLogoTipoImage());
		panelCadastroCartorio = new PanelCadastroCartorio();
		panelCadastroCartorio.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroCartorio);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroCartorio.isAncestorOf(focused)) {
							panelCadastroCartorio.scrollRectToVisible(focused.getBounds());
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
		cartorioGerenteEventos = new CartorioGerenteEventos();
		addWindowListener(cartorioGerenteEventos.new Frame());
		panelCadastroCartorio.getToolBar().getButtonExcluiRegistro()
				.addActionListener(cartorioGerenteEventos.new ExcluiRegistro());
		panelCadastroCartorio.getToolBar().getButtonNovoFrame().addActionListener(cartorioGerenteEventos.new NovoFrame());
		panelCadastroCartorio.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(cartorioGerenteEventos.new PesquisaRegistro());
		panelCadastroCartorio.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(cartorioGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroCartorio.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(cartorioGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroCartorio.getToolBar().getButtonSalvar().addActionListener(cartorioGerenteEventos.new Salva());
		panelCadastroCartorio.getToolBar().getButtonFechar().addActionListener(cartorioGerenteEventos.new FechaJanela());
		panelCadastroCartorio.getToolBar().getButtonSair().addActionListener(cartorioGerenteEventos.new SaidaSistema());
		panelCadastroCartorio.getToolBar().getButtonAjuda().addActionListener(cartorioGerenteEventos.new Ajuda());
		panelCadastroCartorio.getToolBar().getButtonHome().addActionListener(cartorioGerenteEventos.new Home());

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
