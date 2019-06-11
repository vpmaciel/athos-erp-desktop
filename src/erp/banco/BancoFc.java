package erp.banco;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class BancoFc extends JFrame implements Gui {

	private BancoCont bancoCont;
	private BancoPc bancoPc;
	private ConfiguracaoGui configuracaoGui;

	public BancoFc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {
	}

	public void desabilitarGui() {
	}

	public BancoCont getBancoCont() {
		return bancoCont;
	}

	public BancoPc getBancoPc() {
		return bancoPc;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		bancoCont = new BancoCont();
		addWindowListener(bancoCont.new Frame());
		bancoPc.getTB().getExcluirBtn().addActionListener(bancoCont.new Exclui());
		bancoPc.getTB().getNovoBtn().addActionListener(bancoCont.new Novo());
		bancoPc.getTB().getPesquisarBtn().addActionListener(bancoCont.new Pesquisa());
		bancoPc.getTB().getImprimirBtn().addActionListener(bancoCont.new Imprime());
		bancoPc.getTB().getRelatorioBtn().addActionListener(bancoCont.new Relatorio());
		bancoPc.getTB().getSalvarBtn().addActionListener(bancoCont.new Salva());
		bancoPc.getTB().getFecharBtn().addActionListener(bancoCont.new FechaJanela());
		bancoPc.getTB().getSairBtn().addActionListener(bancoCont.new SaidaSistema());
		bancoPc.getTB().getAjudaBtn().addActionListener(bancoCont.new Ajuda());
		bancoPc.getTB().getHomeBtn().addActionListener(bancoCont.new Home());
		bancoPc.getTB().getRegistrosBtn().addActionListener(bancoCont.new Registro());
		bancoPc.getTB().getPlanilhaBtn().addActionListener(bancoCont.new Planilha());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());
		bancoPc = new BancoPc();
		bancoPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(bancoPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (bancoPc.isAncestorOf(focused)) {
							bancoPc.scrollRectToVisible(focused.getBounds());
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
		bancoPc.limparGui();
	}

	@Override
	public void reiniciarGui() {
		bancoPc.reiniciarGui();
	}

	public boolean validarGui() {
		return bancoPc.validarGui();
	}
}