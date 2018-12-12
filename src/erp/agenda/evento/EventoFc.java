package erp.agenda.evento;

import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class EventoFc extends JFrame implements Gui {

	private EventoCont eventoCont;
	private ConfiguracaoGui configuracaoGui;
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
	public ConfiguracaoGui getGUIConfiguracao() {
		return configuracaoGui;
	}

	public EventoPc getEventoPc() {
		return eventoPc;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
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
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarControlador() {
		eventoCont = new EventoCont();
		addWindowListener(eventoCont.new Frame());
		eventoPc.getToolBar().getExcluirBtn().addActionListener(eventoCont.new Exclui());
		eventoPc.getToolBar().getNovoBtn().addActionListener(eventoCont.new Novo());
		eventoPc.getToolBar().getPesquisarBtn().addActionListener(eventoCont.new Pesquisa());
		eventoPc.getToolBar().getImprimirBtn().addActionListener(eventoCont.new Imprime());
		eventoPc.getToolBar().getRelatorioBtn().addActionListener(eventoCont.new Relatorio());
		eventoPc.getToolBar().getSalvarBtn().addActionListener(eventoCont.new Salva());
		eventoPc.getToolBar().getFecharBtn().addActionListener(eventoCont.new FechaJanela());
		eventoPc.getToolBar().getSairBtn().addActionListener(eventoCont.new SaidaSistema());
		eventoPc.getToolBar().getAjudaBtn().addActionListener(eventoCont.new Ajuda());
		eventoPc.getToolBar().getHomeBtn().addActionListener(eventoCont.new Home());

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
		configuracaoGui.limparGui();
	}

	@Override
	public void reiniciarGUI() {
		eventoPc.reiniciarGUI();
	}
}
