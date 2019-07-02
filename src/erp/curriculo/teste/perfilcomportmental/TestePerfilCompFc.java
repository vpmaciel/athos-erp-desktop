package erp.curriculo.teste.perfilcomportmental;

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
public final class TestePerfilCompFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private TestePerfilCompControl testePerfilCompControl;
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

	public TestePerfilCompControl getTestePerfilCompCont() {
		return testePerfilCompControl;
	}

	public TestePerfilCompPc getTestePerfilCompPc() {
		return testePerfilCompPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		testePerfilCompControl = new TestePerfilCompControl();
		addWindowListener(testePerfilCompControl.new Frame());
		testePerfilCompPc.getLabelFuncionario().addMouseListener(testePerfilCompControl.new MostraFrame());
		testePerfilCompPc.getTB().getExcluirBtn().addActionListener(testePerfilCompControl.new Exclui());
		testePerfilCompPc.getTB().getNovoBtn().addActionListener(testePerfilCompControl.new Novo());
		testePerfilCompPc.getTB().getPesquisarBtn().addActionListener(testePerfilCompControl.new Pesquisa());
		testePerfilCompPc.getTB().getImprimirBtn().addActionListener(testePerfilCompControl.new Imprime());
		testePerfilCompPc.getTB().getRelatorioBtn().addActionListener(testePerfilCompControl.new Relatorio());
		testePerfilCompPc.getTB().getSalvarBtn().addActionListener(testePerfilCompControl.new Salva());
		testePerfilCompPc.getTB().getFecharBtn().addActionListener(testePerfilCompControl.new FechaJanela());
		testePerfilCompPc.getTB().getSairBtn().addActionListener(testePerfilCompControl.new SaidaSistema());
		testePerfilCompPc.getTB().getAjudaBtn().addActionListener(testePerfilCompControl.new Ajuda());
		testePerfilCompPc.getTB().getHomeBtn().addActionListener(testePerfilCompControl.new Home());
		testePerfilCompPc.getTB().getRegistrosBtn().addActionListener(testePerfilCompControl.new Registro());
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
		testePerfilCompPc.reiniciarGui();
	}
}
