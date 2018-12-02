package erp.agenda.evento.tipoevento;

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
public final class FrameCadastroTipoEvento extends JFrame implements Gui {

	private TipoEventoGerenteEventos tipoEventoGerenteEventos;
	private GuiGerenteEventos guiGerenteEventos;
	private PanelCadastroTipoEvento panelCadastroTipoEvento;

	public FrameCadastroTipoEvento() {
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

	public TipoEventoGerenteEventos getTipoEventoGerenteEventos() {
		return tipoEventoGerenteEventos;
	}

	@Override
	public GuiGerenteEventos getGuiGerenteEventos() {
		return guiGerenteEventos;
	}

	public PanelCadastroTipoEvento getPanelCadastroTipoEvento() {
		return panelCadastroTipoEvento;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("TIPO DE EVENTO");
		setIconImage(Imagem.getLogoTipoImage());

		panelCadastroTipoEvento = new PanelCadastroTipoEvento();
		panelCadastroTipoEvento.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroTipoEvento);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroTipoEvento.isAncestorOf(focused)) {
							panelCadastroTipoEvento.scrollRectToVisible(focused.getBounds());
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
		tipoEventoGerenteEventos = new TipoEventoGerenteEventos();
		addWindowListener(tipoEventoGerenteEventos.new Frame());
		panelCadastroTipoEvento.getToolBar().getButtonExcluiRegistro()
				.addActionListener(tipoEventoGerenteEventos.new ExcluiRegistro());
		panelCadastroTipoEvento.getToolBar().getButtonNovoFrame()
				.addActionListener(tipoEventoGerenteEventos.new NovoFrame());
		panelCadastroTipoEvento.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(tipoEventoGerenteEventos.new PesquisaRegistro());
		panelCadastroTipoEvento.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(tipoEventoGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroTipoEvento.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(tipoEventoGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroTipoEvento.getToolBar().getButtonSalvar().addActionListener(tipoEventoGerenteEventos.new Salva());
		panelCadastroTipoEvento.getToolBar().getButtonFechar()
				.addActionListener(tipoEventoGerenteEventos.new FechaJanela());
		panelCadastroTipoEvento.getToolBar().getButtonSair()
				.addActionListener(tipoEventoGerenteEventos.new SaidaSistema());
		panelCadastroTipoEvento.getToolBar().getButtonAjuda().addActionListener(tipoEventoGerenteEventos.new Ajuda());
		panelCadastroTipoEvento.getToolBar().getButtonHome().addActionListener(tipoEventoGerenteEventos.new Home());

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
		panelCadastroTipoEvento.reiniciarBox();
	}
}
