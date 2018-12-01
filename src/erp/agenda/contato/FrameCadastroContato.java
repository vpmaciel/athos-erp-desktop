package erp.agenda.contato;

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
import arquitetura.gui.GuiHandle;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class FrameCadastroContato extends JFrame implements Gui {

	private ContatoGerenteEventos contatoGerenteEventos;
	private GuiHandle guiHandle;
	private PanelCadastroContato panelCadastroContato;

	public FrameCadastroContato() {
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
	public GuiHandle getGuiGerenteEventos() {
		return guiHandle;
	}

	public PanelCadastroContato getPanelCadastroContato() {
		return panelCadastroContato;
	}

	public ContatoGerenteEventos getContatoHandle() {
		return contatoGerenteEventos;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("CONTATO");
		setIconImage(Imagem.getLogoTipoImage());

		panelCadastroContato = new PanelCadastroContato();

		panelCadastroContato.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroContato);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroContato.isAncestorOf(focused)) {
							panelCadastroContato.scrollRectToVisible(focused.getBounds());
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
		contatoGerenteEventos = new ContatoGerenteEventos();
		addWindowListener(contatoGerenteEventos.new Frame());
		panelCadastroContato.getLabelEmpresa().addMouseListener(contatoGerenteEventos.new MostraFrameContato());
		panelCadastroContato.getToolBar().getButtonExcluiRegistro()
				.addActionListener(contatoGerenteEventos.new ExcluiRegistro());
		panelCadastroContato.getToolBar().getButtonNovoFrame().addActionListener(contatoGerenteEventos.new NovoFrame());
		panelCadastroContato.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(contatoGerenteEventos.new PesquisaRegistro());
		panelCadastroContato.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(contatoGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroContato.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(contatoGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroContato.getToolBar().getButtonSalvar().addActionListener(contatoGerenteEventos.new Salva());
		panelCadastroContato.getToolBar().getButtonFechar().addActionListener(contatoGerenteEventos.new FechaJanela());
		panelCadastroContato.getToolBar().getButtonSair().addActionListener(contatoGerenteEventos.new SaidaSistema());
		panelCadastroContato.getToolBar().getButtonAjuda().addActionListener(contatoGerenteEventos.new Ajuda());
		panelCadastroContato.getToolBar().getButtonHome().addActionListener(contatoGerenteEventos.new Home());

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
		panelCadastroContato.reiniciarBox();
	}
}
