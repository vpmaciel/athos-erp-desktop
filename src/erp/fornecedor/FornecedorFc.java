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
public final class FornecedorFc extends JFrame implements GUI {

	private FornecedorCont fornecedorCont;
	private ConfiguracaoGUI configuracaoGUI;
	private FornecedorPc fornecedorPc;

	public FornecedorFc() {
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

	public FornecedorCont getFornecedorHandle() {
		return fornecedorCont;
	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public FornecedorPc getFornecedorPc() {
		return fornecedorPc;
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
		fornecedorPc = new FornecedorPc();
		fornecedorPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(fornecedorPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (fornecedorPc.isAncestorOf(focused)) {
							fornecedorPc.scrollRectToVisible(focused.getBounds());
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
		fornecedorCont = new FornecedorCont();
		addWindowListener(fornecedorCont.new Frame());
		fornecedorPc.getTB().getExcluirBTN().addActionListener(fornecedorCont.new Exclui());
		fornecedorPc.getTB().getNovoBTN().addActionListener(fornecedorCont.new Novo());
		fornecedorPc.getTB().getPesquisarBTN().addActionListener(fornecedorCont.new Pesquisa());
		fornecedorPc.getTB().getImprimirBTN().addActionListener(fornecedorCont.new Imprime());
		fornecedorPc.getTB().getRelatorioBTN().addActionListener(fornecedorCont.new Relatorio());
		fornecedorPc.getTB().getSalvarBTN().addActionListener(fornecedorCont.new Salva());
		fornecedorPc.getTB().getFecharBTN().addActionListener(fornecedorCont.new FechaJanela());
		fornecedorPc.getTB().getSairBTN().addActionListener(fornecedorCont.new SaidaSistema());
		fornecedorPc.getTB().getAjudaBTN().addActionListener(fornecedorCont.new Ajuda());
		fornecedorPc.getTB().getHomeBTN().addActionListener(fornecedorCont.new Home());
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
		configuracaoGUI.limparGui();
	}

	@Override
	public void reiniciarGUI() {

	}
}
