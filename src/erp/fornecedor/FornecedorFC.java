package erp.fornecedor;

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
public final class FornecedorFC extends JFrame implements GUI {

	private FornecedorCT fornecedorCT;
	private ConfiguracaoGUI configuracaoGUI;
	private FornecedorPC fornecedorPC;

	public FornecedorFC() {
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

	public FornecedorCT getFornecedorHandle() {
		return fornecedorCT;
	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public FornecedorPC getFornecedorPC() {
		return fornecedorPC;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("FORNECEDOR");
		setIconImage(Imagem.getLogoTipoImage());
		fornecedorPC = new FornecedorPC();
		fornecedorPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(fornecedorPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (fornecedorPC.isAncestorOf(focused)) {
							fornecedorPC.scrollRectToVisible(focused.getBounds());
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
		fornecedorCT = new FornecedorCT();
		addWindowListener(fornecedorCT.new Frame());
		fornecedorPC.getTB().getExcluirBTN().addActionListener(fornecedorCT.new Exclui());
		fornecedorPC.getTB().getNovoBTN().addActionListener(fornecedorCT.new Novo());
		fornecedorPC.getTB().getPesquisarBTN().addActionListener(fornecedorCT.new Pesquisa());
		fornecedorPC.getTB().getImprimirBTN().addActionListener(fornecedorCT.new Imprime());
		fornecedorPC.getTB().getRelatorioBTN().addActionListener(fornecedorCT.new Relatorio());
		fornecedorPC.getTB().getSalvarBTN().addActionListener(fornecedorCT.new Salva());
		fornecedorPC.getTB().getFecharBTN().addActionListener(fornecedorCT.new FechaJanela());
		fornecedorPC.getTB().getSairBTN().addActionListener(fornecedorCT.new SaidaSistema());
		fornecedorPC.getTB().getAjudaBTN().addActionListener(fornecedorCT.new Ajuda());
		fornecedorPC.getTB().getHomeBTN().addActionListener(fornecedorCT.new Home());
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
