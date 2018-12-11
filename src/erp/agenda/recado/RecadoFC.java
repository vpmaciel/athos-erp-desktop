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
import arquitetura.gui.GUI;
import arquitetura.gui.ConfiguracaoGUI;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class RecadoFC extends JFrame implements GUI {

	private RecadoCT recadoCT;
	private ConfiguracaoGUI guiConfiguracao;
	private RecadoPC pcRecado;

	public RecadoFC() {
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

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return guiConfiguracao;
	}

	public RecadoPC getRecadoPC() {
		return pcRecado;
	}

	public RecadoCT getRecadoHandle() {
		return recadoCT;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("RECADO");
		setIconImage(Imagem.getLogoTipoImage());

		pcRecado = new RecadoPC();

		pcRecado.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pcRecado);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pcRecado.isAncestorOf(focused)) {
							pcRecado.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();
	}

	@Override
	public void iniciarGUIControlador() {
		guiConfiguracao = new ConfiguracaoGUI(this);
	}

	@Override
	public void iniciarControlador() {
		recadoCT = new RecadoCT();
		addWindowListener(recadoCT.new Frame());
		pcRecado.getToolBar().getExcluirBTN().addActionListener(recadoCT.new Exclui());
		pcRecado.getToolBar().getNovoBTN().addActionListener(recadoCT.new Novo());
		pcRecado.getToolBar().getPesquisarBTN().addActionListener(recadoCT.new Pesquisa());
		pcRecado.getToolBar().getImprimirBTN().addActionListener(recadoCT.new Imprime());
		pcRecado.getToolBar().getRelatorioBTN().addActionListener(recadoCT.new Relatorio());
		pcRecado.getToolBar().getSalvarBTN().addActionListener(recadoCT.new Salva());
		pcRecado.getToolBar().getFecharBTN().addActionListener(recadoCT.new FechaJanela());
		pcRecado.getToolBar().getSairBTN().addActionListener(recadoCT.new SaidaSistema());
		pcRecado.getToolBar().getAjudaBTN().addActionListener(recadoCT.new Ajuda());
		pcRecado.getToolBar().getHomeBTN().addActionListener(recadoCT.new Home());

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
		guiConfiguracao.limparGui();
	}

	@Override
	public void reiniciarGUI() {
		pcRecado.reiniciarGUI();
	}
}
