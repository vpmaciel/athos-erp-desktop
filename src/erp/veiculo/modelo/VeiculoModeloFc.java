package erp.veiculo.modelo;

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
public final class VeiculoModeloFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private VeiculoModeloCont veiculoModeloCont;
	private VeiculoModeloPc veiculoModeloPc;

	public VeiculoModeloFc() {
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

	public VeiculoModeloCont getVeiculoModeloCont() {
		return veiculoModeloCont;
	}

	public VeiculoModeloPc getVeiculoModeloPc() {
		return veiculoModeloPc;
	}

	@Override
	public void iniciarControlador() {
		veiculoModeloCont = new VeiculoModeloCont();
		addWindowListener(veiculoModeloCont.new Frame());
		veiculoModeloPc.getToolBar().getExcluirBtn().addActionListener(veiculoModeloCont.new ExcluiRegistro());
		veiculoModeloPc.getToolBar().getNovoBtn().addActionListener(veiculoModeloCont.new NovoFrame());
		veiculoModeloPc.getToolBar().getPesquisarBtn().addActionListener(veiculoModeloCont.new PesquisaRegistro());
		veiculoModeloPc.getToolBar().getImprimirBtn().addActionListener(veiculoModeloCont.new Relatorio());
		veiculoModeloPc.getToolBar().getRelatorioBtn().addActionListener(veiculoModeloCont.new Imprime());
		veiculoModeloPc.getToolBar().getSalvarBtn().addActionListener(veiculoModeloCont.new Salva());
		veiculoModeloPc.getToolBar().getFecharBtn().addActionListener(veiculoModeloCont.new FechaJanela());
		veiculoModeloPc.getToolBar().getSairBtn().addActionListener(veiculoModeloCont.new SaidaSistema());
		veiculoModeloPc.getToolBar().getAjudaBtn().addActionListener(veiculoModeloCont.new Ajuda());
		veiculoModeloPc.getToolBar().getHomeBtn().addActionListener(veiculoModeloCont.new Home());
		veiculoModeloPc.getToolBar().getRegistrosBtn().addActionListener(veiculoModeloCont.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("VEÍCULO - MODELO");
		setIconImage(Imagem.getLogoTipoImage());
		veiculoModeloPc = new VeiculoModeloPc();
		veiculoModeloPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(veiculoModeloPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (veiculoModeloPc.isAncestorOf(focused)) {
							veiculoModeloPc.scrollRectToVisible(focused.getBounds());
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
