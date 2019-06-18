package erp.curriculo.habilidade;

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
public final class HabilidadeFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private HabilidadeCont habilidadeCont;
	private HabilidadePc habilidadePc;

	public HabilidadeFc() {
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

	public HabilidadeCont getHabilidadeCont() {
		return habilidadeCont;
	}

	public HabilidadePc getHabilidadePc() {
		return habilidadePc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		habilidadeCont = new HabilidadeCont();
		addWindowListener(habilidadeCont.new Frame());
		habilidadePc.getLabelFuncionario().addMouseListener(habilidadeCont.new MostraFrame());
		habilidadePc.getTB().getExcluirBtn().addActionListener(habilidadeCont.new Exclui());
		habilidadePc.getTB().getNovoBtn().addActionListener(habilidadeCont.new Novo());
		habilidadePc.getTB().getPesquisarBtn().addActionListener(habilidadeCont.new Pesquisa());
		habilidadePc.getTB().getImprimirBtn().addActionListener(habilidadeCont.new Imprime());
		habilidadePc.getTB().getRelatorioBtn().addActionListener(habilidadeCont.new Relatorio());
		habilidadePc.getTB().getSalvarBtn().addActionListener(habilidadeCont.new Salva());
		habilidadePc.getTB().getFecharBtn().addActionListener(habilidadeCont.new FechaJanela());
		habilidadePc.getTB().getSairBtn().addActionListener(habilidadeCont.new SaidaSistema());
		habilidadePc.getTB().getAjudaBtn().addActionListener(habilidadeCont.new Ajuda());
		habilidadePc.getTB().getHomeBtn().addActionListener(habilidadeCont.new Home());
		habilidadePc.getTB().getRegistrosBtn().addActionListener(habilidadeCont.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		habilidadePc = new HabilidadePc();
		habilidadePc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(habilidadePc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (habilidadePc.isAncestorOf(focused)) {
							habilidadePc.scrollRectToVisible(focused.getBounds());
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
		habilidadePc.reiniciarGui();
	}
}
