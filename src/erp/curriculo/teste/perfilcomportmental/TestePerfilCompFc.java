package erp.curriculo.teste.perfilcomportmental;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class TestePerfilCompFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private TestePerfilCompCont testePerfilCompCont;
	private TestePerfilCompPc testePerfilCompPc;

	public TestePerfilCompFc() {
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

	public TestePerfilCompCont getTestePerfilCompCont() {
		return testePerfilCompCont;
	}

	public TestePerfilCompPc getTestePerfilCompPc() {
		return testePerfilCompPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		testePerfilCompCont = new TestePerfilCompCont();
		addWindowListener(testePerfilCompCont.new Frame());
		testePerfilCompPc.getLabelFuncionario().addMouseListener(testePerfilCompCont.new MostraFrame());
		testePerfilCompPc.getTB().getExcluirBtn().addActionListener(testePerfilCompCont.new Exclui());
		testePerfilCompPc.getTB().getNovoBtn().addActionListener(testePerfilCompCont.new Novo());
		testePerfilCompPc.getTB().getPesquisarBtn().addActionListener(testePerfilCompCont.new Pesquisa());
		testePerfilCompPc.getTB().getImprimirBtn().addActionListener(testePerfilCompCont.new Imprime());
		testePerfilCompPc.getTB().getRelatorioBtn().addActionListener(testePerfilCompCont.new Relatorio());
		testePerfilCompPc.getTB().getSalvarBtn().addActionListener(testePerfilCompCont.new Salva());
		testePerfilCompPc.getTB().getFecharBtn().addActionListener(testePerfilCompCont.new FechaJanela());
		testePerfilCompPc.getTB().getSairBtn().addActionListener(testePerfilCompCont.new SaidaSistema());
		testePerfilCompPc.getTB().getAjudaBtn().addActionListener(testePerfilCompCont.new Ajuda());
		testePerfilCompPc.getTB().getHomeBtn().addActionListener(testePerfilCompCont.new Home());
		testePerfilCompPc.getTB().getRegistrosBtn().addActionListener(testePerfilCompCont.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		testePerfilCompPc = new TestePerfilCompPc();
		testePerfilCompPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(testePerfilCompPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (testePerfilCompPc.isAncestorOf(focused)) {
							testePerfilCompPc.scrollRectToVisible(focused.getBounds());
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
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(800, 600));
		setSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
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
		testePerfilCompPc.reiniciarGui();
	}
}
