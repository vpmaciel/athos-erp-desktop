package erp.veiculo;

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
public final class VeiculoFC extends JFrame implements GUI {

	private VeiculoCT veiculoCT;
	private ConfiguracaoGUI configuracaoGUI;
	private VeiculoPC veiculoPC;

	public VeiculoFC() {
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

	public VeiculoPC getPanelCadastroVeiculo() {
		return veiculoPC;
	}

	public VeiculoCT getVeiculoGerenteEventos() {
		return veiculoCT;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("VEÍCULO");
		setIconImage(Imagem.getLogoTipoImage());
		veiculoPC = new VeiculoPC();
		veiculoPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(veiculoPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (veiculoPC.isAncestorOf(focused)) {
							veiculoPC.scrollRectToVisible(focused.getBounds());
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
		veiculoCT = new VeiculoCT();
		addWindowListener(veiculoCT.new Frame());
		veiculoPC.getToolBar().getExcluirBTN().addActionListener(veiculoCT.new Exclui());
		veiculoPC.getToolBar().getNovoBTN().addActionListener(veiculoCT.new Novo());
		veiculoPC.getToolBar().getPesquisarBTN().addActionListener(veiculoCT.new Pesquisa());
		veiculoPC.getToolBar().getImprimirBTN().addActionListener(veiculoCT.new Imprime());
		veiculoPC.getToolBar().getRelatorioBTN().addActionListener(veiculoCT.new Relatorio());
		veiculoPC.getToolBar().getSalvarBTN().addActionListener(veiculoCT.new Salva());
		veiculoPC.getToolBar().getFecharBTN().addActionListener(veiculoCT.new FechaJanela());
		veiculoPC.getToolBar().getSairBTN().addActionListener(veiculoCT.new SaidaSistema());
		veiculoPC.getToolBar().getAjudaBTN().addActionListener(veiculoCT.new Ajuda());
		veiculoPC.getToolBar().getHomeBTN().addActionListener(veiculoCT.new Home());
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
