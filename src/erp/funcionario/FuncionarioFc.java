package erp.funcionario;

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

@SuppressWarnings("serial")
public final class FuncionarioFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private FuncionarioPc curriculoPc;
	private FuncionarioControl funcionarioControl;

	public FuncionarioFc() {
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

	public FuncionarioControl getFuncionarioCont() {
		return funcionarioControl;
	}

	public FuncionarioPc getFuncionarioPc() {
		return curriculoPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		funcionarioControl = new FuncionarioControl();
		curriculoPc.getLabelCentroCusto().addMouseListener(funcionarioControl.new MostraFrame());
		addWindowListener(funcionarioControl.new Frame());
		curriculoPc.getTB().getExcluirBtn().addActionListener(funcionarioControl.new Exclui());
		curriculoPc.getTB().getNovoBtn().addActionListener(funcionarioControl.new Novo());
		curriculoPc.getTB().getPesquisarBtn().addActionListener(funcionarioControl.new Pesquisa());
		curriculoPc.getTB().getImprimirBtn().addActionListener(funcionarioControl.new Imprime());
		curriculoPc.getTB().getRelatorioBtn().addActionListener(funcionarioControl.new Relatorio());
		curriculoPc.getTB().getSalvarBtn().addActionListener(funcionarioControl.new Salva());
		curriculoPc.getTB().getFecharBtn().addActionListener(funcionarioControl.new FechaJanela());
		curriculoPc.getTB().getSairBtn().addActionListener(funcionarioControl.new SaidaSistema());
		curriculoPc.getTB().getAjudaBtn().addActionListener(funcionarioControl.new Ajuda());
		curriculoPc.getTB().getHomeBtn().addActionListener(funcionarioControl.new Home());
		curriculoPc.getTB().getRegistrosBtn().addActionListener(funcionarioControl.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(arquitetura.gui.Imagem.getLogoTipoImage());
		curriculoPc = new FuncionarioPc();
		curriculoPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(curriculoPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (curriculoPc.isAncestorOf(focused)) {
							curriculoPc.scrollRectToVisible(focused.getBounds());
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
		curriculoPc.reiniciarGui();
	}
}
