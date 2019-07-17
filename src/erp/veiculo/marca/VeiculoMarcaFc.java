package erp.veiculo.marca;

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
public final class VeiculoMarcaFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private VeiculoMarcaControl veiculoMarcaControl;
	private VeiculoMarcaPc veiculoMarcaPc;

	public VeiculoMarcaFc() {
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

	public VeiculoMarcaControl getVeiculoMarcaCont() {
		return veiculoMarcaControl;
	}

	public VeiculoMarcaPc getVeiculoMarcaPc() {
		return veiculoMarcaPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		veiculoMarcaControl = new VeiculoMarcaControl();
		addWindowListener(veiculoMarcaControl.new Frame());
		veiculoMarcaPc.getTB().getExcluirBtn().addActionListener(veiculoMarcaControl.new ExcluiRegistro());
		veiculoMarcaPc.getTB().getNovoBtn().addActionListener(veiculoMarcaControl.new NovoFrame());
		veiculoMarcaPc.getTB().getPesquisarBtn().addActionListener(veiculoMarcaControl.new PesquisaRegistro());
		veiculoMarcaPc.getTB().getImprimirBtn().addActionListener(veiculoMarcaControl.new Relatorio());
		veiculoMarcaPc.getTB().getRelatorioBtn().addActionListener(veiculoMarcaControl.new Imprime());
		veiculoMarcaPc.getTB().getSalvarBtn().addActionListener(veiculoMarcaControl.new Salva());
		veiculoMarcaPc.getTB().getFecharBtn().addActionListener(veiculoMarcaControl.new FechaJanela());
		veiculoMarcaPc.getTB().getSairBtn().addActionListener(veiculoMarcaControl.new SaidaSistema());
		veiculoMarcaPc.getTB().getAjudaBtn().addActionListener(veiculoMarcaControl.new Ajuda());
		veiculoMarcaPc.getTB().getHomeBtn().addActionListener(veiculoMarcaControl.new Home());
		veiculoMarcaPc.getTB().getRegistrosBtn().addActionListener(veiculoMarcaControl.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());
		veiculoMarcaPc = new VeiculoMarcaPc();
		veiculoMarcaPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(veiculoMarcaPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (veiculoMarcaPc.isAncestorOf(focused)) {
							veiculoMarcaPc.scrollRectToVisible(focused.getBounds());
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
