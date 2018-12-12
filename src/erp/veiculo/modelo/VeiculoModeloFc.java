package erp.veiculo.modelo;

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
public final class VeiculoModeloFc extends JFrame implements GUI {

	private VeiculoModeloCont veiculoModeloCont;
	private ConfiguracaoGUI configuracaoGUI;
	private VeiculoModeloPc veiculoModeloPc;

	public VeiculoModeloFc() {
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

	public VeiculoModeloPc getVeiculoModeloPc() {
		return veiculoModeloPc;
	}

	public VeiculoModeloCont getVeiculoModeloHandle() {
		return veiculoModeloCont;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
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
		veiculoModeloCont = new VeiculoModeloCont();
		addWindowListener(veiculoModeloCont.new Frame());
		veiculoModeloPc.getToolBar().getExcluirBTN()
				.addActionListener(veiculoModeloCont.new ExcluiRegistro());
		veiculoModeloPc.getToolBar().getNovoBTN()
				.addActionListener(veiculoModeloCont.new NovoFrame());
		veiculoModeloPc.getToolBar().getPesquisarBTN()
				.addActionListener(veiculoModeloCont.new PesquisaRegistro());
		veiculoModeloPc.getToolBar().getImprimirBTN()
				.addActionListener(veiculoModeloCont.new ImprimiUnicoRegistro());
		veiculoModeloPc.getToolBar().getRelatorioBTN()
				.addActionListener(veiculoModeloCont.new ImprimiTodosRegistros());
		veiculoModeloPc.getToolBar().getSalvarBTN()
				.addActionListener(veiculoModeloCont.new Salva());
		veiculoModeloPc.getToolBar().getFecharBTN()
				.addActionListener(veiculoModeloCont.new FechaJanela());
		veiculoModeloPc.getToolBar().getSairBTN()
				.addActionListener(veiculoModeloCont.new SaidaSistema());
		veiculoModeloPc.getToolBar().getAjudaBTN()
				.addActionListener(veiculoModeloCont.new Ajuda());
		veiculoModeloPc.getToolBar().getHomeBTN()
				.addActionListener(veiculoModeloCont.new Home());
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
