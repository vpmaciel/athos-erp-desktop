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
public final class FuncionarioFC extends JFrame implements GUI {

	private FuncionarioCT funcionarioCT;
	private ConfiguracaoGUI configuracaoGUI;
	private FuncionarioPC funcionarioPC;

	public FuncionarioFC() {
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

	public FuncionarioCT getFuncionarioHandle() {
		return funcionarioCT;
	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public FuncionarioPC getFuncionarioPC() {
		return funcionarioPC;
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
		funcionarioPC = new FuncionarioPC();
		funcionarioPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(funcionarioPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (funcionarioPC.isAncestorOf(focused)) {
							funcionarioPC.scrollRectToVisible(focused.getBounds());
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
		funcionarioCT = new FuncionarioCT();
		funcionarioPC.getLabelCentroCusto().addMouseListener(funcionarioCT.new MostraFrame());
		addWindowListener(funcionarioCT.new Frame());
		funcionarioPC.getTB().getExcluirBTN().addActionListener(funcionarioCT.new Exclui());
		funcionarioPC.getTB().getNovoBTN().addActionListener(funcionarioCT.new Novo());
		funcionarioPC.getTB().getPesquisarBTN().addActionListener(funcionarioCT.new Pesquisa());
		funcionarioPC.getTB().getImprimirBTN().addActionListener(funcionarioCT.new Imprime());
		funcionarioPC.getTB().getRelatorioBTN().addActionListener(funcionarioCT.new Relatorio());
		funcionarioPC.getTB().getSalvarBTN().addActionListener(funcionarioCT.new Salva());
		funcionarioPC.getTB().getFecharBTN().addActionListener(funcionarioCT.new FechaJanela());
		funcionarioPC.getTB().getSairBTN().addActionListener(funcionarioCT.new SaidaSistema());
		funcionarioPC.getTB().getAjudaBTN().addActionListener(funcionarioCT.new Ajuda());
		funcionarioPC.getTB().getHomeBTN().addActionListener(funcionarioCT.new Home());

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
		funcionarioPC.reiniciarGUI();
	}
}
