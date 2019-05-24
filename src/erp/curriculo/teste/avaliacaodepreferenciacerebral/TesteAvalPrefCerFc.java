package erp.curriculo.teste.avaliacaodepreferenciacerebral;

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
public final class TesteAvalPrefCerFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private TesteAvalPrefCerCont testeAvalPrefCerCont;
	private TesteAvalPrefCerPc testeAvalPrefCerPc;

	public TesteAvalPrefCerFc() {
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

	public TesteAvalPrefCerCont getTesteAvalPrefCerCont() {
		return testeAvalPrefCerCont;
	}

	public TesteAvalPrefCerPc getTesteAvalPrefCerPc() {
		return testeAvalPrefCerPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		testeAvalPrefCerCont = new TesteAvalPrefCerCont();
		addWindowListener(testeAvalPrefCerCont.new Frame());
		testeAvalPrefCerPc.getLabelFuncionario().addMouseListener(testeAvalPrefCerCont.new MostraFrame());
		testeAvalPrefCerPc.getTB().getExcluirBtn().addActionListener(testeAvalPrefCerCont.new Exclui());
		testeAvalPrefCerPc.getTB().getNovoBtn().addActionListener(testeAvalPrefCerCont.new Novo());
		testeAvalPrefCerPc.getTB().getPesquisarBtn().addActionListener(testeAvalPrefCerCont.new Pesquisa());
		testeAvalPrefCerPc.getTB().getImprimirBtn().addActionListener(testeAvalPrefCerCont.new Imprime());
		testeAvalPrefCerPc.getTB().getRelatorioBtn().addActionListener(testeAvalPrefCerCont.new Relatorio());
		testeAvalPrefCerPc.getTB().getSalvarBtn().addActionListener(testeAvalPrefCerCont.new Salva());
		testeAvalPrefCerPc.getTB().getFecharBtn().addActionListener(testeAvalPrefCerCont.new FechaJanela());
		testeAvalPrefCerPc.getTB().getSairBtn().addActionListener(testeAvalPrefCerCont.new SaidaSistema());
		testeAvalPrefCerPc.getTB().getAjudaBtn().addActionListener(testeAvalPrefCerCont.new Ajuda());
		testeAvalPrefCerPc.getTB().getHomeBtn().addActionListener(testeAvalPrefCerCont.new Home());
		testeAvalPrefCerPc.getTB().getRegistrosBtn().addActionListener(testeAvalPrefCerCont.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		testeAvalPrefCerPc = new TesteAvalPrefCerPc();
		testeAvalPrefCerPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(testeAvalPrefCerPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (testeAvalPrefCerPc.isAncestorOf(focused)) {
							testeAvalPrefCerPc.scrollRectToVisible(focused.getBounds());
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
		configuracaoGui.limparGui();
	}

	@Override
	public void reiniciarGui() {
		testeAvalPrefCerPc.reiniciarGui();
	}
}
