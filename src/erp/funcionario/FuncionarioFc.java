package erp.funcionario;

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

@SuppressWarnings("serial")
public final class FuncionarioFc extends JFrame implements Gui {

	private FuncionarioCont funcionarioCont;
	private ConfiguracaoGui configuracaoGui;
	private FuncionarioPc funcionarioPc;

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

	public FuncionarioCont getFuncionarioHandle() {
		return funcionarioCont;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public FuncionarioPc getFuncionarioPc() {
		return funcionarioPc;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(arquitetura.gui.Imagem.getLogoTipoImage());
		funcionarioPc = new FuncionarioPc();
		funcionarioPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(funcionarioPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (funcionarioPc.isAncestorOf(focused)) {
							funcionarioPc.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();
	}

	@Override
	public void iniciarGuiControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		funcionarioCont = new FuncionarioCont();
		funcionarioPc.getLabelCentroCusto().addMouseListener(funcionarioCont.new MostraFrame());
		addWindowListener(funcionarioCont.new Frame());
		funcionarioPc.getTB().getExcluirBtn().addActionListener(funcionarioCont.new Exclui());
		funcionarioPc.getTB().getNovoBtn().addActionListener(funcionarioCont.new Novo());
		funcionarioPc.getTB().getPesquisarBtn().addActionListener(funcionarioCont.new Pesquisa());
		funcionarioPc.getTB().getImprimirBtn().addActionListener(funcionarioCont.new Imprime());
		funcionarioPc.getTB().getRelatorioBtn().addActionListener(funcionarioCont.new Relatorio());
		funcionarioPc.getTB().getSalvarBtn().addActionListener(funcionarioCont.new Salva());
		funcionarioPc.getTB().getFecharBtn().addActionListener(funcionarioCont.new FechaJanela());
		funcionarioPc.getTB().getSairBtn().addActionListener(funcionarioCont.new SaidaSistema());
		funcionarioPc.getTB().getAjudaBtn().addActionListener(funcionarioCont.new Ajuda());
		funcionarioPc.getTB().getHomeBtn().addActionListener(funcionarioCont.new Home());

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
	public void limparGui() {
		configuracaoGui.limparGui();
	}

	@Override
	public void reiniciarGui() {
		funcionarioPc.reiniciarGui();
	}
}
