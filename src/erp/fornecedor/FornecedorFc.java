package erp.fornecedor;

import java.awt.FlowLayout;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import arquitetura.AOP;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class FornecedorFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private FornecedorCont fornecedorCont;
	private FornecedorPc fornecedorPc;

	public FornecedorFc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public FornecedorCont getFornecedorCont() {
		return fornecedorCont;
	}

	public FornecedorPc getFornecedorPc() {
		return fornecedorPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
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
		fornecedorPc.getTB().getRegistrosBtn().addActionListener(fornecedorCont.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
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
		setPreferredSize(AOP.getTamanhoJanela());
		setMinimumSize(AOP.getTamanhoJanela());
		setSize(AOP.getTamanhoJanela());
		setMaximumSize(AOP.getTamanhoJanela());
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
