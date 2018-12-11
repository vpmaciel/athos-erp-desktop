package erp.centrocusto;

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
public final class CentroCustoFC extends JFrame implements GUI {

	private CentroCustoCT centroCustoCT;
	private ConfiguracaoGUI configuracaoGUI;
	private CentroCustoPC centroCustoPC;

	public CentroCustoFC() {
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

	public void desabilitarGui() {
	}

	public CentroCustoCT getCentroCustoHandle() {
		return centroCustoCT;
	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public CentroCustoPC getCentroCustoPC() {
		return centroCustoPC;
	}

	public CentroCustoPC getPanelCentroCustoCadastro() {
		return centroCustoPC;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("CENTRO DE CUSTO");
		setIconImage(Imagem.getLogoTipoImage());
		centroCustoPC = new CentroCustoPC();
		centroCustoPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(centroCustoPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (centroCustoPC.isAncestorOf(focused)) {
							centroCustoPC.scrollRectToVisible(focused.getBounds());
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
		centroCustoCT = new CentroCustoCT();
		addWindowListener(centroCustoCT.new Frame());
		centroCustoPC.getTB().getExcluirBTN().addActionListener(centroCustoCT.new Exclui());
		centroCustoPC.getTB().getNovoBTN().addActionListener(centroCustoCT.new Novo());
		centroCustoPC.getTB().getPesquisarBTN().addActionListener(centroCustoCT.new Pesquisa());
		centroCustoPC.getTB().getImprimirBTN().addActionListener(centroCustoCT.new Imprime());
		centroCustoPC.getTB().getRelatorioBTN().addActionListener(centroCustoCT.new Relatorio());
		centroCustoPC.getTB().getSalvarBTN().addActionListener(centroCustoCT.new Salva());
		centroCustoPC.getTB().getFecharBTN().addActionListener(centroCustoCT.new FechaJanela());
		centroCustoPC.getTB().getSairBTN().addActionListener(centroCustoCT.new SaidaSistema());
		centroCustoPC.getTB().getAjudaBTN().addActionListener(centroCustoCT.new Ajuda());
		centroCustoPC.getTB().getHomeBTN().addActionListener(centroCustoCT.new Home());
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
		centroCustoPC.limparGUI();
	}

	@Override
	public void reiniciarGUI() {
	}

	public boolean validarCamposCadastro() {
		return centroCustoPC.validarCamposCadastro();
	}
}
