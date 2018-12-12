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
public final class CentroCustoFc extends JFrame implements GUI {

	private CentroCustoCont centroCustoCont;
	private ConfiguracaoGUI configuracaoGUI;
	private CentroCustoPc centroCustoPc;

	public CentroCustoFc() {
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

	public CentroCustoCont getCentroCustoHandle() {
		return centroCustoCont;
	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
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
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("CENTRO DE CUSTO");
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
	public void iniciarGUIControlador() {
		configuracaoGUI = new ConfiguracaoGUI(this);
	}

	@Override
	public void iniciarControlador() {
		centroCustoCont = new CentroCustoCont();
		addWindowListener(centroCustoCont.new Frame());
		centroCustoPc.getTB().getExcluirBTN().addActionListener(centroCustoCont.new Exclui());
		centroCustoPc.getTB().getNovoBTN().addActionListener(centroCustoCont.new Novo());
		centroCustoPc.getTB().getPesquisarBTN().addActionListener(centroCustoCont.new Pesquisa());
		centroCustoPc.getTB().getImprimirBTN().addActionListener(centroCustoCont.new Imprime());
		centroCustoPc.getTB().getRelatorioBTN().addActionListener(centroCustoCont.new Relatorio());
		centroCustoPc.getTB().getSalvarBTN().addActionListener(centroCustoCont.new Salva());
		centroCustoPc.getTB().getFecharBTN().addActionListener(centroCustoCont.new FechaJanela());
		centroCustoPc.getTB().getSairBTN().addActionListener(centroCustoCont.new SaidaSistema());
		centroCustoPc.getTB().getAjudaBTN().addActionListener(centroCustoCont.new Ajuda());
		centroCustoPc.getTB().getHomeBTN().addActionListener(centroCustoCont.new Home());
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
		centroCustoPc.limparGUI();
	}

	@Override
	public void reiniciarGUI() {
	}

	public boolean validarCamposCadastro() {
		return centroCustoPc.validarCamposCadastro();
	}
}
