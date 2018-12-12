package erp.funcionario;

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

@SuppressWarnings("serial")
public final class FuncionarioFc extends JFrame implements GUI {

	private FuncionarioCont funcionarioCont;
	private ConfiguracaoGUI configuracaoGUI;
	private FuncionarioPc funcionarioPc;

	public FuncionarioFc() {
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

	public FuncionarioCont getFuncionarioHandle() {
		return funcionarioCont;
	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public FuncionarioPc getFuncionarioPc() {
		return funcionarioPc;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("FUNCIONÁRIO");
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
	public void iniciarGUIControlador() {
		configuracaoGUI = new ConfiguracaoGUI(this);
	}

	@Override
	public void iniciarControlador() {
		funcionarioCont = new FuncionarioCont();
		funcionarioPc.getLabelCentroCusto().addMouseListener(funcionarioCont.new MostraFrame());
		addWindowListener(funcionarioCont.new Frame());
		funcionarioPc.getTB().getExcluirBTN().addActionListener(funcionarioCont.new Exclui());
		funcionarioPc.getTB().getNovoBTN().addActionListener(funcionarioCont.new Novo());
		funcionarioPc.getTB().getPesquisarBTN().addActionListener(funcionarioCont.new Pesquisa());
		funcionarioPc.getTB().getImprimirBTN().addActionListener(funcionarioCont.new Imprime());
		funcionarioPc.getTB().getRelatorioBTN().addActionListener(funcionarioCont.new Relatorio());
		funcionarioPc.getTB().getSalvarBTN().addActionListener(funcionarioCont.new Salva());
		funcionarioPc.getTB().getFecharBTN().addActionListener(funcionarioCont.new FechaJanela());
		funcionarioPc.getTB().getSairBTN().addActionListener(funcionarioCont.new SaidaSistema());
		funcionarioPc.getTB().getAjudaBTN().addActionListener(funcionarioCont.new Ajuda());
		funcionarioPc.getTB().getHomeBTN().addActionListener(funcionarioCont.new Home());

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
		funcionarioPc.reiniciarGUI();
	}
}
