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
public final class FrameCadastroSindicato extends JFrame implements Gui {

	private SindicatoGerenteEventos sindicatoGerenteEventos;
	private GuiGerenteEventos guiGerenteEventos;
	private PanelCadastroSindicato panelCadastroSindicato;

	public FrameCadastroSindicato() {
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

	public PanelCadastroSindicato getPanelCadastroSindicato() {
		return panelCadastroSindicato;
	}

	public SindicatoGerenteEventos getSindicatoHandle() {
		return sindicatoGerenteEventos;
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
		panelCadastroSindicato = new PanelCadastroSindicato();
		panelCadastroSindicato.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroSindicato);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroSindicato.isAncestorOf(focused)) {
							panelCadastroSindicato.scrollRectToVisible(focused.getBounds());
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
		sindicatoGerenteEventos = new SindicatoGerenteEventos();
		addWindowListener(sindicatoGerenteEventos.new Frame());
		panelCadastroSindicato.getToolBar().getButtonExcluiRegistro()
				.addActionListener(sindicatoGerenteEventos.new ExcluiRegistro());
		panelCadastroSindicato.getToolBar().getButtonNovoFrame()
				.addActionListener(sindicatoGerenteEventos.new NovoFrame());
		panelCadastroSindicato.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(sindicatoGerenteEventos.new PesquisaRegistro());
		panelCadastroSindicato.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(sindicatoGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroSindicato.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(sindicatoGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroSindicato.getToolBar().getButtonSalvar().addActionListener(sindicatoGerenteEventos.new Salva());
		panelCadastroSindicato.getToolBar().getButtonFechar()
				.addActionListener(sindicatoGerenteEventos.new FechaJanela());
		panelCadastroSindicato.getToolBar().getButtonSair()
				.addActionListener(sindicatoGerenteEventos.new SaidaSistema());
		panelCadastroSindicato.getToolBar().getButtonAjuda().addActionListener(sindicatoGerenteEventos.new Ajuda());
		panelCadastroSindicato.getToolBar().getButtonHome().addActionListener(sindicatoGerenteEventos.new Home());
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
