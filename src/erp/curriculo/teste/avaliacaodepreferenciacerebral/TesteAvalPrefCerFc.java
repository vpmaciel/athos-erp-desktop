package erp.curriculo.teste.avaliacaodepreferenciacerebral;

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
public final class TesteAvalPrefCerFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private TesteAvalPrefCerControl testeAvalPrefCerControl;
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

	public TesteAvalPrefCerControl getTesteAvalPrefCerCont() {
		return testeAvalPrefCerControl;
	}

	public TesteAvalPrefCerPc getTesteAvalPrefCerPc() {
		return testeAvalPrefCerPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		testeAvalPrefCerControl = new TesteAvalPrefCerControl();
		addWindowListener(testeAvalPrefCerControl.new Frame());
		testeAvalPrefCerPc.getLabelFuncionario().addMouseListener(testeAvalPrefCerControl.new MostraFrame());
		testeAvalPrefCerPc.getTB().getExcluirBtn().addActionListener(testeAvalPrefCerControl.new Exclui());
		testeAvalPrefCerPc.getTB().getNovoBtn().addActionListener(testeAvalPrefCerControl.new Novo());
		testeAvalPrefCerPc.getTB().getPesquisarBtn().addActionListener(testeAvalPrefCerControl.new Pesquisa());
		testeAvalPrefCerPc.getTB().getImprimirBtn().addActionListener(testeAvalPrefCerControl.new Imprime());
		testeAvalPrefCerPc.getTB().getRelatorioBtn().addActionListener(testeAvalPrefCerControl.new Relatorio());
		testeAvalPrefCerPc.getTB().getSalvarBtn().addActionListener(testeAvalPrefCerControl.new Salva());
		testeAvalPrefCerPc.getTB().getFecharBtn().addActionListener(testeAvalPrefCerControl.new FechaJanela());
		testeAvalPrefCerPc.getTB().getSairBtn().addActionListener(testeAvalPrefCerControl.new SaidaSistema());
		testeAvalPrefCerPc.getTB().getAjudaBtn().addActionListener(testeAvalPrefCerControl.new Ajuda());
		testeAvalPrefCerPc.getTB().getHomeBtn().addActionListener(testeAvalPrefCerControl.new Home());
		testeAvalPrefCerPc.getTB().getRegistrosBtn().addActionListener(testeAvalPrefCerControl.new Registro());
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
		testeAvalPrefCerPc.reiniciarGui();
	}
}
