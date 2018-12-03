package erp.cartorio;

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
public final class FCCartorio extends JFrame implements Gui {

	private CartorioControlador cartorioControlador;
	private GuiGerenteEventos guiGerenteEventos;
	private PCCartorio pCCartorio;

	public FCCartorio() {
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

	public CartorioControlador getCartorioHandle() {
		return cartorioControlador;
	}

	@Override
	public GuiGerenteEventos getGuiGerenteEventos() {
		return guiGerenteEventos;
	}

	public PCCartorio getPanelCadastroCartorio() {
		return pCCartorio;
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
		pCCartorio = new PCCartorio();
		pCCartorio.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pCCartorio);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pCCartorio.isAncestorOf(focused)) {
							pCCartorio.scrollRectToVisible(focused.getBounds());
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
		cartorioControlador = new CartorioControlador();
		addWindowListener(cartorioControlador.new Frame());
		pCCartorio.getToolBar().getButtonExcluiRegistro()
				.addActionListener(cartorioControlador.new ExcluiRegistro());
		pCCartorio.getToolBar().getButtonNovoFrame()
				.addActionListener(cartorioControlador.new NovoFrame());
		pCCartorio.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(cartorioControlador.new PesquisaRegistro());
		pCCartorio.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(cartorioControlador.new ImprimiUnicoRegistro());
		pCCartorio.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(cartorioControlador.new ImprimiTodosRegistros());
		pCCartorio.getToolBar().getButtonSalvar().addActionListener(cartorioControlador.new Salva());
		pCCartorio.getToolBar().getButtonFechar()
				.addActionListener(cartorioControlador.new FechaJanela());
		pCCartorio.getToolBar().getButtonSair().addActionListener(cartorioControlador.new SaidaSistema());
		pCCartorio.getToolBar().getButtonAjuda().addActionListener(cartorioControlador.new Ajuda());
		pCCartorio.getToolBar().getButtonHome().addActionListener(cartorioControlador.new Home());

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
