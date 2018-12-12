package erp.veiculo.marca;

import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import arquitetura.gui.FocusTabListener;
import arquitetura.gui.GUI;
import arquitetura.gui.ConfiguracaoGUI;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class VeiculoMarcaFc extends JFrame implements GUI {

	private VeiculoMarcaCont veiculoMarcaCont;
	private ConfiguracaoGUI configuracaoGUI;
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
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
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
		FocusTabListener focusTabListener = new FocusTabListener(this);
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
		configuracaoGUI = new ConfiguracaoGUI(this);
	}

	@Override
	public void iniciarControlador() {
		veiculoMarcaCont = new VeiculoMarcaCont();
		addWindowListener(veiculoMarcaCont.new Frame());
		veiculoMarcaPc.getToolBar().getExcluirBTN()
				.addActionListener(veiculoMarcaCont.new ExcluiRegistro());
		veiculoMarcaPc.getToolBar().getNovoBTN()
				.addActionListener(veiculoMarcaCont.new NovoFrame());
		veiculoMarcaPc.getToolBar().getPesquisarBTN()
				.addActionListener(veiculoMarcaCont.new PesquisaRegistro());
		veiculoMarcaPc.getToolBar().getImprimirBTN()
				.addActionListener(veiculoMarcaCont.new ImprimiUnicoRegistro());
		veiculoMarcaPc.getToolBar().getRelatorioBTN()
				.addActionListener(veiculoMarcaCont.new ImprimiTodosRegistros());
		veiculoMarcaPc.getToolBar().getSalvarBTN()
				.addActionListener(veiculoMarcaCont.new Salva());
		veiculoMarcaPc.getToolBar().getFecharBTN()
				.addActionListener(veiculoMarcaCont.new FechaJanela());
		veiculoMarcaPc.getToolBar().getSairBTN()
				.addActionListener(veiculoMarcaCont.new SaidaSistema());
		veiculoMarcaPc.getToolBar().getAjudaBTN()
				.addActionListener(veiculoMarcaCont.new Ajuda());
		veiculoMarcaPc.getToolBar().getHomeBTN().addActionListener(veiculoMarcaCont.new Home());
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
		configuracaoGUI.limparGui();
	}

	@Override
	public void reiniciarGUI() {

	}
}
