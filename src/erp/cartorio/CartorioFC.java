package erp.cartorio;

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
public final class CartorioFC extends JFrame implements GUI {

	private CartorioCT cartorioCT;
	private ConfiguracaoGUI configuracaoGUI;
	private CartorioPC cartorioPC;

	public CartorioFC() {
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

	public CartorioCT getCartorioHandle() {
		return cartorioCT;
	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public CartorioPC getCartorioPC() {
		return cartorioPC;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("CARTÓRIO");
		setIconImage(Imagem.getLogoTipoImage());
		cartorioPC = new CartorioPC();
		cartorioPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(cartorioPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (cartorioPC.isAncestorOf(focused)) {
							cartorioPC.scrollRectToVisible(focused.getBounds());
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
		cartorioCT = new CartorioCT();
		addWindowListener(cartorioCT.new Frame());
		cartorioPC.getTB().getExcluirBTN().addActionListener(cartorioCT.new Exclui());
		cartorioPC.getTB().getNovoBTN().addActionListener(cartorioCT.new Novo());
		cartorioPC.getTB().getPesquisarBTN().addActionListener(cartorioCT.new Pesquisa());
		cartorioPC.getTB().getImprimirBTN().addActionListener(cartorioCT.new Imprime());
		cartorioPC.getTB().getRelatorioBTN().addActionListener(cartorioCT.new Relatorio());
		cartorioPC.getTB().getSalvarBTN().addActionListener(cartorioCT.new Salva());
		cartorioPC.getTB().getFecharBTN().addActionListener(cartorioCT.new FechaJanela());
		cartorioPC.getTB().getSairBTN().addActionListener(cartorioCT.new SaidaSistema());
		cartorioPC.getTB().getAjudaBTN().addActionListener(cartorioCT.new Ajuda());
		cartorioPC.getTB().getHomeBTN().addActionListener(cartorioCT.new Home());

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
