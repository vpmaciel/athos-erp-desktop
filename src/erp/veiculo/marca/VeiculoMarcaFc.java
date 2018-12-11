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
public final class VeiculoMarcaFC extends JFrame implements GUI {

	private VeiculoMarcaCT veiculoMarcaCT;
	private ConfiguracaoGUI configuracaoGUI;
	private VeiculoMarcaPC veiculoMarcaPC;

	public VeiculoMarcaFC() {
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

	public VeiculoMarcaPC getPanelCadastroVeiculoMarca() {
		return veiculoMarcaPC;
	}

	public VeiculoMarcaCT getVeiculoMarcaHandle() {
		return veiculoMarcaCT;
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
		veiculoMarcaPC = new VeiculoMarcaPC();
		veiculoMarcaPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(veiculoMarcaPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (veiculoMarcaPC.isAncestorOf(focused)) {
							veiculoMarcaPC.scrollRectToVisible(focused.getBounds());
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
		veiculoMarcaCT = new VeiculoMarcaCT();
		addWindowListener(veiculoMarcaCT.new Frame());
		veiculoMarcaPC.getToolBar().getExcluirBTN()
				.addActionListener(veiculoMarcaCT.new ExcluiRegistro());
		veiculoMarcaPC.getToolBar().getNovoBTN()
				.addActionListener(veiculoMarcaCT.new NovoFrame());
		veiculoMarcaPC.getToolBar().getPesquisarBTN()
				.addActionListener(veiculoMarcaCT.new PesquisaRegistro());
		veiculoMarcaPC.getToolBar().getImprimirBTN()
				.addActionListener(veiculoMarcaCT.new ImprimiUnicoRegistro());
		veiculoMarcaPC.getToolBar().getRelatorioBTN()
				.addActionListener(veiculoMarcaCT.new ImprimiTodosRegistros());
		veiculoMarcaPC.getToolBar().getSalvarBTN()
				.addActionListener(veiculoMarcaCT.new Salva());
		veiculoMarcaPC.getToolBar().getFecharBTN()
				.addActionListener(veiculoMarcaCT.new FechaJanela());
		veiculoMarcaPC.getToolBar().getSairBTN()
				.addActionListener(veiculoMarcaCT.new SaidaSistema());
		veiculoMarcaPC.getToolBar().getAjudaBTN()
				.addActionListener(veiculoMarcaCT.new Ajuda());
		veiculoMarcaPC.getToolBar().getHomeBTN().addActionListener(veiculoMarcaCT.new Home());
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
