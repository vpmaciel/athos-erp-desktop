package erp.sindicato;

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
public final class SindicatoFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private SindicatoControl sindicatoControl;
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

	public SindicatoControl getSindicatoCont() {
		return sindicatoControl;
	}

	public SindicatoPc getSindicatoPc() {
		return sindicatoPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		sindicatoControl = new SindicatoControl();
		addWindowListener(sindicatoControl.new Frame());
		sindicatoPc.getTB().getExcluirBtn().addActionListener(sindicatoControl.new Exclui());
		sindicatoPc.getTB().getNovoBtn().addActionListener(sindicatoControl.new Novo());
		sindicatoPc.getTB().getPesquisarBtn().addActionListener(sindicatoControl.new Pesquisa());
		sindicatoPc.getTB().getImprimirBtn().addActionListener(sindicatoControl.new Imprime());
		sindicatoPc.getTB().getRelatorioBtn().addActionListener(sindicatoControl.new Relatorio());
		sindicatoPc.getTB().getSalvarBtn().addActionListener(sindicatoControl.new Salva());
		sindicatoPc.getTB().getFecharBtn().addActionListener(sindicatoControl.new FechaJanela());
		sindicatoPc.getTB().getSairBtn().addActionListener(sindicatoControl.new SaidaSistema());
		sindicatoPc.getTB().getAjudaBtn().addActionListener(sindicatoControl.new Ajuda());
		sindicatoPc.getTB().getHomeBtn().addActionListener(sindicatoControl.new Home());
		sindicatoPc.getTB().getRegistrosBtn().addActionListener(sindicatoControl.new Registro());
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

	}
}
