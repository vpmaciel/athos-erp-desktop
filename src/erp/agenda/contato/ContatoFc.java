package erp.agenda.contato;

import java.awt.FlowLayout;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import arquitetura.Sis;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class ContatoFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private ContatoCont contatoCont;
	private ContatoPc contatoPc;

	public ContatoFc() {
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

	public ContatoCont getContatoCont() {
		return contatoCont;
	}

	public ContatoPc getContatoPc() {
		return contatoPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		contatoCont = new ContatoCont();
		addWindowListener(contatoCont.new Frame());
		contatoPc.getLabelEmpresa().addMouseListener(contatoCont.new MostraFc());
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
		contatoPc.getToolBar().getRegistrosBtn().addActionListener(contatoCont.new Registro());
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
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		add(scrollPane);
		setContentPane(scrollPane);
		pack();
	}

	@Override
	public void iniciarGuiControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarLayout() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setPreferredSize(Sis.getTamanhoJanela());
		setMinimumSize(Sis.getTamanhoJanela());
		setSize(Sis.getTamanhoJanela());
		setMaximumSize(Sis.getTamanhoJanela());
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
