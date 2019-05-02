package erp.veiculo.marca;

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
public final class VeiculoMarcaFc extends JFrame implements Gui {

	private VeiculoMarcaCont veiculoMarcaCont;
	private ConfiguracaoGui configuracaoGui;
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

	public VeiculoMarcaPc getVeiculoMarcaPc() {
		return veiculoMarcaPc;
	}

	public VeiculoMarcaCont getVeiculoMarcaCont() {
		return veiculoMarcaCont;
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
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		veiculoMarcaCont = new VeiculoMarcaCont();
		addWindowListener(veiculoMarcaCont.new Frame());
		veiculoMarcaPc.getToolBar().getExcluirBtn().addActionListener(veiculoMarcaCont.new ExcluiRegistro());
		veiculoMarcaPc.getToolBar().getNovoBtn().addActionListener(veiculoMarcaCont.new NovoFrame());
		veiculoMarcaPc.getToolBar().getPesquisarBtn().addActionListener(veiculoMarcaCont.new PesquisaRegistro());
		veiculoMarcaPc.getToolBar().getImprimirBtn().addActionListener(veiculoMarcaCont.new Relatorio());
		veiculoMarcaPc.getToolBar().getRelatorioBtn().addActionListener(veiculoMarcaCont.new Imprime());
		veiculoMarcaPc.getToolBar().getSalvarBtn().addActionListener(veiculoMarcaCont.new Salva());
		veiculoMarcaPc.getToolBar().getFecharBtn().addActionListener(veiculoMarcaCont.new FechaJanela());
		veiculoMarcaPc.getToolBar().getSairBtn().addActionListener(veiculoMarcaCont.new SaidaSistema());
		veiculoMarcaPc.getToolBar().getAjudaBtn().addActionListener(veiculoMarcaCont.new Ajuda());
		veiculoMarcaPc.getToolBar().getHomeBtn().addActionListener(veiculoMarcaCont.new Home());
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
