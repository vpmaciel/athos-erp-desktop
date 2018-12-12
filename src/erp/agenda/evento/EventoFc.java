package erp.agenda.evento;

import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import arquitetura.gui.FocusTabListener;
import arquitetura.gui.GUI;
import arquitetura.gui.ConfiguracaoGUI;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class EventoFc extends JFrame implements GUI {

	private EventoCont eventoCont;
	private ConfiguracaoGUI configuracaoGUI;
	private EventoPc eventoPc;

	public EventoFc() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		iniciarLayout();
		iniciarGUI();
		iniciarFocoControlador();
		iniciarGUIControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public EventoCont getEventoGerenteEventos() {
		return eventoCont;
	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public EventoPc getEventoPc() {
		return eventoPc;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("EVENTO");
		setIconImage(Imagem.getLogoTipoImage());

		eventoPc = new EventoPc();
		eventoPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(eventoPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (eventoPc.isAncestorOf(focused)) {
							eventoPc.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();
	}

	@Override
	public void iniciarGUIControlador() {
		configuracaoGUI = new ConfiguracaoGUI(this);
	}

	@Override
	public void iniciarControlador() {
		eventoCont = new EventoCont();
		addWindowListener(eventoCont.new Frame());
		eventoPc.getToolBar().getExcluirBTN().addActionListener(eventoCont.new Exclui());
		eventoPc.getToolBar().getNovoBTN().addActionListener(eventoCont.new Novo());
		eventoPc.getToolBar().getPesquisarBTN().addActionListener(eventoCont.new Pesquisa());
		eventoPc.getToolBar().getImprimirBTN().addActionListener(eventoCont.new Imprime());
		eventoPc.getToolBar().getRelatorioBTN().addActionListener(eventoCont.new Relatorio());
		eventoPc.getToolBar().getSalvarBTN().addActionListener(eventoCont.new Salva());
		eventoPc.getToolBar().getFecharBTN().addActionListener(eventoCont.new FechaJanela());
		eventoPc.getToolBar().getSairBTN().addActionListener(eventoCont.new SaidaSistema());
		eventoPc.getToolBar().getAjudaBTN().addActionListener(eventoCont.new Ajuda());
		eventoPc.getToolBar().getHomeBTN().addActionListener(eventoCont.new Home());

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
	public void iniciarTabela() {
	}

	@Override
	public void limparGUI() {
		configuracaoGUI.limparGui();
	}

	@Override
	public void reiniciarGUI() {
		eventoPc.reiniciarGUI();
	}
}
