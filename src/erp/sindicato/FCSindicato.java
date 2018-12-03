package erp.sindicato;

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
public final class FCSindicato extends JFrame implements Gui {

	private SindicatoControlador sindicatoControlador;
	private GuiGerenteEventos guiGerenteEventos;
	private PCSindicato pCSindicato;

	public FCSindicato() {
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

	public PCSindicato getPanelCadastroSindicato() {
		return pCSindicato;
	}

	public SindicatoControlador getSindicatoHandle() {
		return sindicatoControlador;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("SINDICATO");
		setIconImage(Imagem.getLogoTipoImage());
		pCSindicato = new PCSindicato();
		pCSindicato.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pCSindicato);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pCSindicato.isAncestorOf(focused)) {
							pCSindicato.scrollRectToVisible(focused.getBounds());
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
		sindicatoControlador = new SindicatoControlador();
		addWindowListener(sindicatoControlador.new Frame());
		pCSindicato.getToolBar().getButtonExcluiRegistro()
				.addActionListener(sindicatoControlador.new ExcluiRegistro());
		pCSindicato.getToolBar().getButtonNovoFrame()
				.addActionListener(sindicatoControlador.new NovoFrame());
		pCSindicato.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(sindicatoControlador.new PesquisaRegistro());
		pCSindicato.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(sindicatoControlador.new ImprimiUnicoRegistro());
		pCSindicato.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(sindicatoControlador.new ImprimiTodosRegistros());
		pCSindicato.getToolBar().getButtonSalvar().addActionListener(sindicatoControlador.new Salva());
		pCSindicato.getToolBar().getButtonFechar()
				.addActionListener(sindicatoControlador.new FechaJanela());
		pCSindicato.getToolBar().getButtonSair()
				.addActionListener(sindicatoControlador.new SaidaSistema());
		pCSindicato.getToolBar().getButtonAjuda().addActionListener(sindicatoControlador.new Ajuda());
		pCSindicato.getToolBar().getButtonHome().addActionListener(sindicatoControlador.new Home());
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
