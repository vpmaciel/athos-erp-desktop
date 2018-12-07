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
public final class VeiculoModeloFC extends JFrame implements GUI {

	private VeiculoModeloCT veiculoModeloCT;
	private ConfiguracaoGUI configuracaoGUI;
	private VeiculoModeloPC veiculoModeloPC;

	public VeiculoModeloFC() {
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

	public VeiculoModeloPC getPanelCadastroVeiculoModelo() {
		return veiculoModeloPC;
	}

	public VeiculoModeloCT getVeiculoModeloHandle() {
		return veiculoModeloCT;
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
		veiculoModeloPC = new VeiculoModeloPC();
		veiculoModeloPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(veiculoModeloPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (veiculoModeloPC.isAncestorOf(focused)) {
							veiculoModeloPC.scrollRectToVisible(focused.getBounds());
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
		veiculoModeloCT = new VeiculoModeloCT();
		addWindowListener(veiculoModeloCT.new Frame());
		veiculoModeloPC.getToolBar().getExcluirBTN()
				.addActionListener(veiculoModeloCT.new ExcluiRegistro());
		veiculoModeloPC.getToolBar().getNovoBTN()
				.addActionListener(veiculoModeloCT.new NovoFrame());
		veiculoModeloPC.getToolBar().getPesquisarBTN()
				.addActionListener(veiculoModeloCT.new PesquisaRegistro());
		veiculoModeloPC.getToolBar().getImprimirBTN()
				.addActionListener(veiculoModeloCT.new ImprimiUnicoRegistro());
		veiculoModeloPC.getToolBar().getRelatorioBTN()
				.addActionListener(veiculoModeloCT.new ImprimiTodosRegistros());
		veiculoModeloPC.getToolBar().getSalvarBTN()
				.addActionListener(veiculoModeloCT.new Salva());
		veiculoModeloPC.getToolBar().getFecharBTN()
				.addActionListener(veiculoModeloCT.new FechaJanela());
		veiculoModeloPC.getToolBar().getSairBTN()
				.addActionListener(veiculoModeloCT.new SaidaSistema());
		veiculoModeloPC.getToolBar().getAjudaBTN()
				.addActionListener(veiculoModeloCT.new Ajuda());
		veiculoModeloPC.getToolBar().getHomeBTN()
				.addActionListener(veiculoModeloCT.new Home());
	}

	@Override
	public void iniciarLayout() {
		setLayout(null);
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(800, 600));
		setSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
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
