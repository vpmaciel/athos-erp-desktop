package erp.centrocusto;

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
public final class CentroCustoFc extends JFrame implements Gui {

	private CentroCustoCont centroCustoCont;
	private ConfiguracaoGui configuracaoGui;
	private CentroCustoPc centroCustoPc;

	public CentroCustoFc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {
	}

	public void desabilitarGui() {
	}

	public CentroCustoCont getCentroCustoHandle() {
		return centroCustoCont;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public CentroCustoPc getCentroCustoPc() {
		return centroCustoPc;
	}

	public CentroCustoPc getPanelCentroCustoCadastro() {
		return centroCustoPc;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());
		centroCustoPc = new CentroCustoPc();
		centroCustoPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(centroCustoPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (centroCustoPc.isAncestorOf(focused)) {
							centroCustoPc.scrollRectToVisible(focused.getBounds());
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
		centroCustoCont = new CentroCustoCont();
		addWindowListener(centroCustoCont.new Frame());
		centroCustoPc.getTB().getExcluirBtn().addActionListener(centroCustoCont.new Exclui());
		centroCustoPc.getTB().getNovoBtn().addActionListener(centroCustoCont.new Novo());
		centroCustoPc.getTB().getPesquisarBtn().addActionListener(centroCustoCont.new Pesquisa());
		centroCustoPc.getTB().getImprimirBtn().addActionListener(centroCustoCont.new Imprime());
		centroCustoPc.getTB().getRelatorioBtn().addActionListener(centroCustoCont.new Relatorio());
		centroCustoPc.getTB().getSalvarBtn().addActionListener(centroCustoCont.new Salva());
		centroCustoPc.getTB().getFecharBtn().addActionListener(centroCustoCont.new FechaJanela());
		centroCustoPc.getTB().getSairBtn().addActionListener(centroCustoCont.new SaidaSistema());
		centroCustoPc.getTB().getAjudaBtn().addActionListener(centroCustoCont.new Ajuda());
		centroCustoPc.getTB().getHomeBtn().addActionListener(centroCustoCont.new Home());
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
	public void limparGui() {
		centroCustoPc.limparGui();
	}

	@Override
	public void reiniciarGui() {
	}

	public boolean validarCamposCadastro() {
		return centroCustoPc.validarCamposCadastro();
	}
}
