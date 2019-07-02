package erp.cartorio;

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
public final class CartorioFc extends JFrame implements Gui {

	private CartorioControl cartorioControl;
	private CartorioPc cartorioPc;
	private ConfiguracaoGui configuracaoGui;

	public CartorioFc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public CartorioControl getCartorioCont() {
		return cartorioControl;
	}

	public CartorioPc getCartorioPc() {
		return cartorioPc;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		cartorioControl = new CartorioControl();
		addWindowListener(cartorioControl.new Frame());
		cartorioPc.getTB().getExcluirBtn().addActionListener(cartorioControl.new Exclui());
		cartorioPc.getTB().getNovoBtn().addActionListener(cartorioControl.new Novo());
		cartorioPc.getTB().getPesquisarBtn().addActionListener(cartorioControl.new Pesquisa());
		cartorioPc.getTB().getImprimirBtn().addActionListener(cartorioControl.new Imprime());
		cartorioPc.getTB().getRelatorioBtn().addActionListener(cartorioControl.new Relatorio());
		cartorioPc.getTB().getSalvarBtn().addActionListener(cartorioControl.new Salva());
		cartorioPc.getTB().getFecharBtn().addActionListener(cartorioControl.new FechaJanela());
		cartorioPc.getTB().getSairBtn().addActionListener(cartorioControl.new SaidaSistema());
		cartorioPc.getTB().getAjudaBtn().addActionListener(cartorioControl.new Ajuda());
		cartorioPc.getTB().getHomeBtn().addActionListener(cartorioControl.new Home());
		cartorioPc.getTB().getRegistrosBtn().addActionListener(cartorioControl.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());
		cartorioPc = new CartorioPc();
		cartorioPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(cartorioPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (cartorioPc.isAncestorOf(focused)) {
							cartorioPc.scrollRectToVisible(focused.getBounds());
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

	}
}
