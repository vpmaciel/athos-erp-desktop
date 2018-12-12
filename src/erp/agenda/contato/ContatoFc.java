package erp.agenda.contato;

import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class ContatoFc extends JFrame implements Gui {

	private ContatoCont contatoCont;
	private ConfiguracaoGui configuracaoGui;
	private ContatoPc contatoPc;

	public ContatoFc() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
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
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
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
	public void iniciarGuiControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarControlador() {
		contatoCont = new ContatoCont();
		addWindowListener(contatoCont.new Frame());
		contatoPc.getLabelEmpresa().addMouseListener(contatoCont.new MostraEmpresaFC());
		contatoPc.getToolBar().getExcluirBtn().addActionListener(contatoCont.new Exclui());
		contatoPc.getToolBar().getNovoBtn().addActionListener(contatoCont.new Novo());
		contatoPc.getToolBar().getPesquisarBtn().addActionListener(contatoCont.new Pesquisa());
		contatoPc.getToolBar().getImprimirBtn().addActionListener(contatoCont.new Imprime());
		contatoPc.getToolBar().getRelatorioBtn().addActionListener(contatoCont.new Relatorio());
		contatoPc.getToolBar().getSalvarBtn().addActionListener(contatoCont.new Salva());
		contatoPc.getToolBar().getFecharBtn().addActionListener(contatoCont.new FechaJanela());
		contatoPc.getToolBar().getSairBtn().addActionListener(contatoCont.new SaidaSistema());
		contatoPc.getToolBar().getAjudaBtn().addActionListener(contatoCont.new Ajuda());
		contatoPc.getToolBar().getHomeBtn().addActionListener(contatoCont.new Home());

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
	public void limparGui() {
		configuracaoGui.limparGui();
	}

	@Override
	public void reiniciarGui() {
		contatoPc.reiniciarGui();
	}
}
