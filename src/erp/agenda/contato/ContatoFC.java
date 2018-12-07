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
import arquitetura.gui.GUI;
import arquitetura.gui.ConfiguracaoGUI;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class ContatoFC extends JFrame implements GUI {

	private ContatoCT contatoCT;
	private ConfiguracaoGUI configuracaoGUI;
	private ContatoPC contatoPC;

	public ContatoFC() {
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
		return configuracaoGUI;
	}

	public ContatoPC getPanelCadastroContato() {
		return contatoPC;
	}

	public ContatoCT getContatoHandle() {
		return contatoCT;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("CONTATO");
		setIconImage(Imagem.getLogoTipoImage());

		contatoPC = new ContatoPC();

		contatoPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(contatoPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (contatoPC.isAncestorOf(focused)) {
							contatoPC.scrollRectToVisible(focused.getBounds());
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
		contatoCT = new ContatoCT();
		addWindowListener(contatoCT.new Frame());
		contatoPC.getLabelEmpresa().addMouseListener(contatoCT.new MostraEmpresaFC());
		contatoPC.getToolBar().getExcluirBTN().addActionListener(contatoCT.new Exclui());
		contatoPC.getToolBar().getNovoBTN().addActionListener(contatoCT.new Novo());
		contatoPC.getToolBar().getPesquisarBTN().addActionListener(contatoCT.new Pesquisa());
		contatoPC.getToolBar().getImprimirBTN().addActionListener(contatoCT.new Imprime());
		contatoPC.getToolBar().getRelatorioBTN().addActionListener(contatoCT.new Relatorio());
		contatoPC.getToolBar().getSalvarBTN().addActionListener(contatoCT.new Salva());
		contatoPC.getToolBar().getFecharBTN().addActionListener(contatoCT.new FechaJanela());
		contatoPC.getToolBar().getSairBTN().addActionListener(contatoCT.new SaidaSistema());
		contatoPC.getToolBar().getAjudaBTN().addActionListener(contatoCT.new Ajuda());
		contatoPC.getToolBar().getHomeBTN().addActionListener(contatoCT.new Home());

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
		contatoPC.reiniciarGUI();
	}
}
