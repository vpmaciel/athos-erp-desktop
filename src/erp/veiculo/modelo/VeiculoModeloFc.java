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
	private VeiculoModeloControl veiculoModeloControl;
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

	public VeiculoModeloControl getVeiculoModeloCont() {
		return veiculoModeloControl;
	}

	public VeiculoModeloPc getVeiculoModeloPc() {
		return veiculoModeloPc;
	}

	@Override
	public void iniciarControlador() {
		veiculoModeloControl = new VeiculoModeloControl();
		addWindowListener(veiculoModeloControl.new Frame());
		veiculoModeloPc.getTB().getExcluirBtn().addActionListener(veiculoModeloControl.new ExcluiRegistro());
		veiculoModeloPc.getTB().getNovoBtn().addActionListener(veiculoModeloControl.new NovoFrame());
		veiculoModeloPc.getTB().getPesquisarBtn().addActionListener(veiculoModeloControl.new PesquisaRegistro());
		veiculoModeloPc.getTB().getImprimirBtn().addActionListener(veiculoModeloControl.new Relatorio());
		veiculoModeloPc.getTB().getRelatorioBtn().addActionListener(veiculoModeloControl.new Imprime());
		veiculoModeloPc.getTB().getSalvarBtn().addActionListener(veiculoModeloControl.new Salva());
		veiculoModeloPc.getTB().getFecharBtn().addActionListener(veiculoModeloControl.new FechaJanela());
		veiculoModeloPc.getTB().getSairBtn().addActionListener(veiculoModeloControl.new SaidaSistema());
		veiculoModeloPc.getTB().getAjudaBtn().addActionListener(veiculoModeloControl.new Ajuda());
		veiculoModeloPc.getTB().getHomeBtn().addActionListener(veiculoModeloControl.new Home());
		veiculoModeloPc.getTB().getRegistrosBtn().addActionListener(veiculoModeloControl.new Registro());
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
