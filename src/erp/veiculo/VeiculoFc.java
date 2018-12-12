package erp.veiculo;

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
public final class VeiculoFc extends JFrame implements Gui {

	private VeiculoCont veiculoCont;
	private ConfiguracaoGui configuracaoGui;
	private VeiculoPc veiculoPc;

	public VeiculoFc() {
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

	public VeiculoPc getVeiculoPc() {
		return veiculoPc;
	}

	public VeiculoCont getVeiculoGerenteEventos() {
		return veiculoCont;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
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
	public void iniciarGuiControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		veiculoCont = new VeiculoCont();
		addWindowListener(veiculoCont.new Frame());
		veiculoPc.getToolBar().getExcluirBtn().addActionListener(veiculoCont.new Exclui());
		veiculoPc.getToolBar().getNovoBtn().addActionListener(veiculoCont.new Novo());
		veiculoPc.getToolBar().getPesquisarBtn().addActionListener(veiculoCont.new Pesquisa());
		veiculoPc.getToolBar().getImprimirBtn().addActionListener(veiculoCont.new Imprime());
		veiculoPc.getToolBar().getRelatorioBtn().addActionListener(veiculoCont.new Relatorio());
		veiculoPc.getToolBar().getSalvarBtn().addActionListener(veiculoCont.new Salva());
		veiculoPc.getToolBar().getFecharBtn().addActionListener(veiculoCont.new FechaJanela());
		veiculoPc.getToolBar().getSairBtn().addActionListener(veiculoCont.new SaidaSistema());
		veiculoPc.getToolBar().getAjudaBtn().addActionListener(veiculoCont.new Ajuda());
		veiculoPc.getToolBar().getHomeBtn().addActionListener(veiculoCont.new Home());
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
	public void limparGui() {
		configuracaoGui.limparGui();
	}

	@Override
	public void reiniciarGui() {

	}
}
