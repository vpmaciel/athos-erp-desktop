package erp.veiculo.marca;

import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class VeiculoMarcaFc extends JFrame implements Gui {

	private VeiculoMarcaCont veiculoMarcaCont;
	private ConfiguracaoGui configuracaoGui;
	private VeiculoMarcaPc veiculoMarcaPc;

	public VeiculoMarcaFc() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		iniciarLayout();
		iniciarGUI();
		iniciarFocoControlador();
		iniciarGUIControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGui getGUIConfiguracao() {
		return configuracaoGui;
	}

	public VeiculoMarcaPc getVeiculoMarcaPc() {
		return veiculoMarcaPc;
	}

	public VeiculoMarcaCont getVeiculoMarcaHandle() {
		return veiculoMarcaCont;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("VEÍCULO - MARCA");
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

		add(scrollPane);
		setContentPane(scrollPane);
		pack();

	}

	@Override
	public void iniciarGUIControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarControlador() {
		veiculoMarcaCont = new VeiculoMarcaCont();
		addWindowListener(veiculoMarcaCont.new Frame());
		veiculoMarcaPc.getToolBar().getExcluirBtn()
				.addActionListener(veiculoMarcaCont.new ExcluiRegistro());
		veiculoMarcaPc.getToolBar().getNovoBtn()
				.addActionListener(veiculoMarcaCont.new NovoFrame());
		veiculoMarcaPc.getToolBar().getPesquisarBtn()
				.addActionListener(veiculoMarcaCont.new PesquisaRegistro());
		veiculoMarcaPc.getToolBar().getImprimirBtn()
				.addActionListener(veiculoMarcaCont.new ImprimiUnicoRegistro());
		veiculoMarcaPc.getToolBar().getRelatorioBtn()
				.addActionListener(veiculoMarcaCont.new ImprimiTodosRegistros());
		veiculoMarcaPc.getToolBar().getSalvarBtn()
				.addActionListener(veiculoMarcaCont.new Salva());
		veiculoMarcaPc.getToolBar().getFecharBtn()
				.addActionListener(veiculoMarcaCont.new FechaJanela());
		veiculoMarcaPc.getToolBar().getSairBtn()
				.addActionListener(veiculoMarcaCont.new SaidaSistema());
		veiculoMarcaPc.getToolBar().getAjudaBtn()
				.addActionListener(veiculoMarcaCont.new Ajuda());
		veiculoMarcaPc.getToolBar().getHomeBtn().addActionListener(veiculoMarcaCont.new Home());
	}

	@Override
	public void iniciarLayout() {
		setLayout(null);
		setPreferredSize(new Dimension(800, 420));
		setMinimumSize(new Dimension(800, 420));
		setSize(new Dimension(800, 420));
		setMaximumSize(new Dimension(800, 420));
	}

	@Override
	public void iniciarTabela() {
	}

	@Override
	public void limparGUI() {
		configuracaoGui.limparGui();
	}

	@Override
	public void reiniciarGUI() {

	}
}