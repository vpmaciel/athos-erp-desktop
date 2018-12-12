package erp.fornecedor;

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
public final class FornecedorFc extends JFrame implements Gui {

	private FornecedorCont fornecedorCont;
	private ConfiguracaoGui configuracaoGui;
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
	public ConfiguracaoGui getGUIConfiguracao() {
		return configuracaoGui;
	}

	public FornecedorPc getFornecedorPc() {
		return fornecedorPc;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
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
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarControlador() {
		fornecedorCont = new FornecedorCont();
		addWindowListener(fornecedorCont.new Frame());
		fornecedorPc.getTB().getExcluirBtn().addActionListener(fornecedorCont.new Exclui());
		fornecedorPc.getTB().getNovoBtn().addActionListener(fornecedorCont.new Novo());
		fornecedorPc.getTB().getPesquisarBtn().addActionListener(fornecedorCont.new Pesquisa());
		fornecedorPc.getTB().getImprimirBtn().addActionListener(fornecedorCont.new Imprime());
		fornecedorPc.getTB().getRelatorioBtn().addActionListener(fornecedorCont.new Relatorio());
		fornecedorPc.getTB().getSalvarBtn().addActionListener(fornecedorCont.new Salva());
		fornecedorPc.getTB().getFecharBtn().addActionListener(fornecedorCont.new FechaJanela());
		fornecedorPc.getTB().getSairBtn().addActionListener(fornecedorCont.new SaidaSistema());
		fornecedorPc.getTB().getAjudaBtn().addActionListener(fornecedorCont.new Ajuda());
		fornecedorPc.getTB().getHomeBtn().addActionListener(fornecedorCont.new Home());
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
