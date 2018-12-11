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
public final class VeiculoFc extends JFrame implements GUI {

	private VeiculoCont veiculoCont;
	private ConfiguracaoGUI configuracaoGUI;
	private VeiculoPc veiculoPc;

	public VeiculoFc() {
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

	public VeiculoPc getPanelCadastroVeiculo() {
		return veiculoPc;
	}

	public VeiculoCont getVeiculoGerenteEventos() {
		return veiculoCont;
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
		veiculoPc = new VeiculoPc();
		veiculoPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(veiculoPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (veiculoPc.isAncestorOf(focused)) {
							veiculoPc.scrollRectToVisible(focused.getBounds());
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
		veiculoCont = new VeiculoCont();
		addWindowListener(veiculoCont.new Frame());
		veiculoPc.getToolBar().getExcluirBTN().addActionListener(veiculoCont.new Exclui());
		veiculoPc.getToolBar().getNovoBTN().addActionListener(veiculoCont.new Novo());
		veiculoPc.getToolBar().getPesquisarBTN().addActionListener(veiculoCont.new Pesquisa());
		veiculoPc.getToolBar().getImprimirBTN().addActionListener(veiculoCont.new Imprime());
		veiculoPc.getToolBar().getRelatorioBTN().addActionListener(veiculoCont.new Relatorio());
		veiculoPc.getToolBar().getSalvarBTN().addActionListener(veiculoCont.new Salva());
		veiculoPc.getToolBar().getFecharBTN().addActionListener(veiculoCont.new FechaJanela());
		veiculoPc.getToolBar().getSairBTN().addActionListener(veiculoCont.new SaidaSistema());
		veiculoPc.getToolBar().getAjudaBTN().addActionListener(veiculoCont.new Ajuda());
		veiculoPc.getToolBar().getHomeBTN().addActionListener(veiculoCont.new Home());
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
