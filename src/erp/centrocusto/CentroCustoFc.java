package erp.centrocusto;

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
public final class CentroCustoFc extends JFrame implements Gui {

	private CentroCustoControl centroCustoControl;
	private CentroCustoPc centroCustoPc;
	private ConfiguracaoGui configuracaoGui;

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

	public CentroCustoControl getCentroCustoCont() {
		return centroCustoControl;
	}

	public CentroCustoPc getCentroCustoPc() {
		return centroCustoPc;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public CentroCustoPc getPanelCentroCustoCadastro() {
		return centroCustoPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		centroCustoControl = new CentroCustoControl();
		addWindowListener(centroCustoControl.new Frame());
		centroCustoPc.getTB().getExcluirBtn().addActionListener(centroCustoControl.new Exclui());
		centroCustoPc.getTB().getNovoBtn().addActionListener(centroCustoControl.new Novo());
		centroCustoPc.getTB().getPesquisarBtn().addActionListener(centroCustoControl.new Pesquisa());
		centroCustoPc.getTB().getImprimirBtn().addActionListener(centroCustoControl.new Imprime());
		centroCustoPc.getTB().getRelatorioBtn().addActionListener(centroCustoControl.new Relatorio());
		centroCustoPc.getTB().getSalvarBtn().addActionListener(centroCustoControl.new Salva());
		centroCustoPc.getTB().getFecharBtn().addActionListener(centroCustoControl.new FechaJanela());
		centroCustoPc.getTB().getSairBtn().addActionListener(centroCustoControl.new SaidaSistema());
		centroCustoPc.getTB().getAjudaBtn().addActionListener(centroCustoControl.new Ajuda());
		centroCustoPc.getTB().getHomeBtn().addActionListener(centroCustoControl.new Home());
		centroCustoPc.getTB().getRegistrosBtn().addActionListener(centroCustoControl.new Registro());
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
		centroCustoPc.limparGui();
	}

	@Override
	public void reiniciarGui() {
	}

	public boolean validarGui() {
		return centroCustoPc.validarGui();
	}
}
