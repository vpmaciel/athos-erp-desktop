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
public final class FCRecado extends JFrame implements Gui {

	private RecadoControlador recadoControlador;
	private GuiGerenteEventos guiGerenteEventos;
	private PCRecado pCRecado;

	public FCRecado() {
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

	public PCRecado getPanelCadastroRecado() {
		return pCRecado;
	}

	public RecadoControlador getRecadoHandle() {
		return recadoControlador;
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

		pCRecado = new PCRecado();

		pCRecado.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pCRecado);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pCRecado.isAncestorOf(focused)) {
							pCRecado.scrollRectToVisible(focused.getBounds());
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
		recadoControlador = new RecadoControlador();
		addWindowListener(recadoControlador.new Frame());
		pCRecado.getLabelEmpresa().addMouseListener(recadoControlador.new MostraFrameRecado());
		pCRecado.getToolBar().getButtonExcluiRegistro()
				.addActionListener(recadoControlador.new ExcluiRegistro());
		pCRecado.getToolBar().getButtonNovoFrame().addActionListener(recadoControlador.new NovoFrame());
		pCRecado.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(recadoControlador.new PesquisaRegistro());
		pCRecado.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(recadoControlador.new ImprimiUnicoRegistro());
		pCRecado.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(recadoControlador.new ImprimiTodosRegistros());
		pCRecado.getToolBar().getButtonSalvar().addActionListener(recadoControlador.new Salva());
		pCRecado.getToolBar().getButtonFechar().addActionListener(recadoControlador.new FechaJanela());
		pCRecado.getToolBar().getButtonSair().addActionListener(recadoControlador.new SaidaSistema());
		pCRecado.getToolBar().getButtonAjuda().addActionListener(recadoControlador.new Ajuda());
		pCRecado.getToolBar().getButtonHome().addActionListener(recadoControlador.new Home());

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
		pCRecado.reiniciarBox();
	}
}
