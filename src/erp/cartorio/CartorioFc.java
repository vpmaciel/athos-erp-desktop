package erp.cartorio;

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
public final class CartorioFc extends JFrame implements Gui {

	private CartorioCont cartorioCont;
	private ConfiguracaoGui configuracaoGui;
	private CartorioPc cartorioPc;

	public CartorioFc() {
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

	public CartorioCont getCartorioHandle() {
		return cartorioCont;
	}

	@Override
	public ConfiguracaoGui getGUIConfiguracao() {
		return configuracaoGui;
	}

	public CartorioPc getCartorioPc() {
		return cartorioPc;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("CARTÓRIO");
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

		add(scrollPane);
		setContentPane(scrollPane);
		pack();

	}

	@Override
	public void iniciarGUIControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarControlador() {
		cartorioCont = new CartorioCont();
		addWindowListener(cartorioCont.new Frame());
		cartorioPc.getTB().getExcluirBtn().addActionListener(cartorioCont.new Exclui());
		cartorioPc.getTB().getNovoBtn().addActionListener(cartorioCont.new Novo());
		cartorioPc.getTB().getPesquisarBtn().addActionListener(cartorioCont.new Pesquisa());
		cartorioPc.getTB().getImprimirBtn().addActionListener(cartorioCont.new Imprime());
		cartorioPc.getTB().getRelatorioBtn().addActionListener(cartorioCont.new Relatorio());
		cartorioPc.getTB().getSalvarBtn().addActionListener(cartorioCont.new Salva());
		cartorioPc.getTB().getFecharBtn().addActionListener(cartorioCont.new FechaJanela());
		cartorioPc.getTB().getSairBtn().addActionListener(cartorioCont.new SaidaSistema());
		cartorioPc.getTB().getAjudaBtn().addActionListener(cartorioCont.new Ajuda());
		cartorioPc.getTB().getHomeBtn().addActionListener(cartorioCont.new Home());

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
		configuracaoGui.limparGui();
	}

	@Override
	public void reiniciarGUI() {

	}
}
