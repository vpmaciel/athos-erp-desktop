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
import arquitetura.gui.GUI;
import arquitetura.gui.ConfiguracaoGUI;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class TipoEventoFC extends JFrame implements GUI {

	private TipoEventoCT tipoEventoCT;
	private ConfiguracaoGUI configuracaoGUI;
	private TipoEventoPC tipoEventoPC;

	public TipoEventoFC() {
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

	public TipoEventoCT getTipoEventoGerenteEventos() {
		return tipoEventoCT;
	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public TipoEventoPC getTipoEventoPC() {
		return tipoEventoPC;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("TIPO DE EVENTO");
		setIconImage(Imagem.getLogoTipoImage());

		tipoEventoPC = new TipoEventoPC();
		tipoEventoPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(tipoEventoPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (tipoEventoPC.isAncestorOf(focused)) {
							tipoEventoPC.scrollRectToVisible(focused.getBounds());
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
		tipoEventoCT = new TipoEventoCT();
		addWindowListener(tipoEventoCT.new Frame());
		tipoEventoPC.getToolBar().getExcluirBTN().addActionListener(tipoEventoCT.new Exclui());
		tipoEventoPC.getToolBar().getNovoBTN().addActionListener(tipoEventoCT.new Novo());
		tipoEventoPC.getToolBar().getPesquisarBTN().addActionListener(tipoEventoCT.new Pesquisa());
		tipoEventoPC.getToolBar().getImprimirBTN().addActionListener(tipoEventoCT.new Imprime());
		tipoEventoPC.getToolBar().getRelatorioBTN().addActionListener(tipoEventoCT.new Relatorio());
		tipoEventoPC.getToolBar().getSalvarBTN().addActionListener(tipoEventoCT.new Salva());
		tipoEventoPC.getToolBar().getFecharBTN().addActionListener(tipoEventoCT.new FechaJanela());
		tipoEventoPC.getToolBar().getSairBTN().addActionListener(tipoEventoCT.new SaidaSistema());
		tipoEventoPC.getToolBar().getAjudaBTN().addActionListener(tipoEventoCT.new Ajuda());
		tipoEventoPC.getToolBar().getHomeBTN().addActionListener(tipoEventoCT.new Home());

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
		tipoEventoPC.reiniciarGUI();
	}
}
