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
public final class ContatoFc extends JFrame implements GUI {

	private ContatoCont contatoCont;
	private ConfiguracaoGUI configuracaoGUI;
	private ContatoPc contatoPc;

	public ContatoFc() {
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

	public ContatoPc getContatoPc() {
		return contatoPc;
	}

	public ContatoCont getContatoHandle() {
		return contatoCont;
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

		contatoPc = new ContatoPc();

		contatoPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(contatoPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (contatoPc.isAncestorOf(focused)) {
							contatoPc.scrollRectToVisible(focused.getBounds());
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
		contatoCont = new ContatoCont();
		addWindowListener(contatoCont.new Frame());
		contatoPc.getLabelEmpresa().addMouseListener(contatoCont.new MostraEmpresaFC());
		contatoPc.getToolBar().getExcluirBTN().addActionListener(contatoCont.new Exclui());
		contatoPc.getToolBar().getNovoBTN().addActionListener(contatoCont.new Novo());
		contatoPc.getToolBar().getPesquisarBTN().addActionListener(contatoCont.new Pesquisa());
		contatoPc.getToolBar().getImprimirBTN().addActionListener(contatoCont.new Imprime());
		contatoPc.getToolBar().getRelatorioBTN().addActionListener(contatoCont.new Relatorio());
		contatoPc.getToolBar().getSalvarBTN().addActionListener(contatoCont.new Salva());
		contatoPc.getToolBar().getFecharBTN().addActionListener(contatoCont.new FechaJanela());
		contatoPc.getToolBar().getSairBTN().addActionListener(contatoCont.new SaidaSistema());
		contatoPc.getToolBar().getAjudaBTN().addActionListener(contatoCont.new Ajuda());
		contatoPc.getToolBar().getHomeBTN().addActionListener(contatoCont.new Home());

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
		contatoPc.reiniciarGUI();
	}
}
