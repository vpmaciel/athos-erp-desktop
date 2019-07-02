package erp.veiculo;

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
public final class VeiculoFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private VeiculoControl veiculoControl;
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

	public VeiculoControl getVeiculoCont() {
		return veiculoControl;
	}

	public VeiculoPc getVeiculoPc() {
		return veiculoPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		veiculoControl = new VeiculoControl();
		addWindowListener(veiculoControl.new Frame());
		veiculoPc.getLabelCentroCusto().addMouseListener(veiculoControl.new MostraFrame());
		veiculoPc.getLabelVeiculoMarca().addMouseListener(veiculoControl.new MostraFrame());
		veiculoPc.getLabelVeiculoModelo().addMouseListener(veiculoControl.new MostraFrame());
		veiculoPc.getToolBar().getExcluirBtn().addActionListener(veiculoControl.new Exclui());
		veiculoPc.getToolBar().getNovoBtn().addActionListener(veiculoControl.new Novo());
		veiculoPc.getToolBar().getPesquisarBtn().addActionListener(veiculoControl.new Pesquisa());
		veiculoPc.getToolBar().getImprimirBtn().addActionListener(veiculoControl.new Imprime());
		veiculoPc.getToolBar().getRelatorioBtn().addActionListener(veiculoControl.new Relatorio());
		veiculoPc.getToolBar().getSalvarBtn().addActionListener(veiculoControl.new Salva());
		veiculoPc.getToolBar().getFecharBtn().addActionListener(veiculoControl.new FechaJanela());
		veiculoPc.getToolBar().getSairBtn().addActionListener(veiculoControl.new SaidaSistema());
		veiculoPc.getToolBar().getAjudaBtn().addActionListener(veiculoControl.new Ajuda());
		veiculoPc.getToolBar().getHomeBtn().addActionListener(veiculoControl.new Home());
		veiculoPc.getToolBar().getRegistrosBtn().addActionListener(veiculoControl.new Registro());
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
		veiculoPc.reiniciarGui();
	}
}
