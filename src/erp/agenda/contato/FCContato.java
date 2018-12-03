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
import arquitetura.gui.GuiGerenteEventos;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class FCContato extends JFrame implements Gui {

	private ContatoControlador contatoControlador;
	private GuiGerenteEventos guiGerenteEventos;
	private PCContato pCContato;

	public FCContato() {
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

	public PCContato getPanelCadastroContato() {
		return pCContato;
	}

	public ContatoControlador getContatoHandle() {
		return contatoControlador;
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

		pCContato = new PCContato();

		pCContato.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pCContato);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pCContato.isAncestorOf(focused)) {
							pCContato.scrollRectToVisible(focused.getBounds());
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
		contatoControlador = new ContatoControlador();
		addWindowListener(contatoControlador.new Frame());
		pCContato.getLabelEmpresa().addMouseListener(contatoControlador.new MostraFrameContato());
		pCContato.getToolBar().getButtonExcluiRegistro()
				.addActionListener(contatoControlador.new ExcluiRegistro());
		pCContato.getToolBar().getButtonNovoFrame().addActionListener(contatoControlador.new NovoFrame());
		pCContato.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(contatoControlador.new PesquisaRegistro());
		pCContato.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(contatoControlador.new ImprimiUnicoRegistro());
		pCContato.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(contatoControlador.new ImprimiTodosRegistros());
		pCContato.getToolBar().getButtonSalvar().addActionListener(contatoControlador.new Salva());
		pCContato.getToolBar().getButtonFechar().addActionListener(contatoControlador.new FechaJanela());
		pCContato.getToolBar().getButtonSair().addActionListener(contatoControlador.new SaidaSistema());
		pCContato.getToolBar().getButtonAjuda().addActionListener(contatoControlador.new Ajuda());
		pCContato.getToolBar().getButtonHome().addActionListener(contatoControlador.new Home());

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
		pCContato.reiniciarBox();
	}
}
