package erp.sindicato;

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
public final class SindicatoFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private SindicatoCont sindicatoCont;
	private SindicatoPc sindicatoPc;

	public SindicatoFc() {
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

	public SindicatoCont getSindicatoCont() {
		return sindicatoCont;
	}

	public SindicatoPc getSindicatoPc() {
		return sindicatoPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		sindicatoCont = new SindicatoCont();
		addWindowListener(sindicatoCont.new Frame());
		sindicatoPc.getTB().getExcluirBtn().addActionListener(sindicatoCont.new Exclui());
		sindicatoPc.getTB().getNovoBtn().addActionListener(sindicatoCont.new Novo());
		sindicatoPc.getTB().getPesquisarBtn().addActionListener(sindicatoCont.new Pesquisa());
		sindicatoPc.getTB().getImprimirBtn().addActionListener(sindicatoCont.new Imprime());
		sindicatoPc.getTB().getRelatorioBtn().addActionListener(sindicatoCont.new Relatorio());
		sindicatoPc.getTB().getSalvarBtn().addActionListener(sindicatoCont.new Salva());
		sindicatoPc.getTB().getFecharBtn().addActionListener(sindicatoCont.new FechaJanela());
		sindicatoPc.getTB().getSairBtn().addActionListener(sindicatoCont.new SaidaSistema());
		sindicatoPc.getTB().getAjudaBtn().addActionListener(sindicatoCont.new Ajuda());
		sindicatoPc.getTB().getHomeBtn().addActionListener(sindicatoCont.new Home());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());
		sindicatoPc = new SindicatoPc();
		sindicatoPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(sindicatoPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (sindicatoPc.isAncestorOf(focused)) {
							sindicatoPc.scrollRectToVisible(focused.getBounds());
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

	}
}
