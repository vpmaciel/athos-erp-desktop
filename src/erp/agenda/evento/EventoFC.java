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
public final class EventoFC extends JFrame implements GUI {

	private EventoCT eventoCT;
	private ConfiguracaoGUI configuracaoGUI;
	private EventoPC eventoPC;

	public EventoFC() {
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

	public EventoCT getEventoGerenteEventos() {
		return eventoCT;
	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public EventoPC getEventoPC() {
		return eventoPC;
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

		eventoPC = new EventoPC();
		eventoPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(eventoPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (eventoPC.isAncestorOf(focused)) {
							eventoPC.scrollRectToVisible(focused.getBounds());
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
		eventoCT = new EventoCT();
		addWindowListener(eventoCT.new Frame());
		eventoPC.getToolBar().getExcluirBTN().addActionListener(eventoCT.new Exclui());
		eventoPC.getToolBar().getNovoBTN().addActionListener(eventoCT.new Novo());
		eventoPC.getToolBar().getPesquisarBTN().addActionListener(eventoCT.new Pesquisa());
		eventoPC.getToolBar().getImprimirBTN().addActionListener(eventoCT.new Imprime());
		eventoPC.getToolBar().getRelatorioBTN().addActionListener(eventoCT.new Relatorio());
		eventoPC.getToolBar().getSalvarBTN().addActionListener(eventoCT.new Salva());
		eventoPC.getToolBar().getFecharBTN().addActionListener(eventoCT.new FechaJanela());
		eventoPC.getToolBar().getSairBTN().addActionListener(eventoCT.new SaidaSistema());
		eventoPC.getToolBar().getAjudaBTN().addActionListener(eventoCT.new Ajuda());
		eventoPC.getToolBar().getHomeBTN().addActionListener(eventoCT.new Home());

	}

	@Override
	public void iniciarLayout() {
		setLayout(null);
		setPreferredSize(new Dimension(800, 420));
		setMinimumSize(new Dimension(800, 420));
		setSize(new Dimension(800, 420));
		setMaximumSize(new Dimension(800, 420));
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
		eventoPC.reiniciarGUI();
	}
}
