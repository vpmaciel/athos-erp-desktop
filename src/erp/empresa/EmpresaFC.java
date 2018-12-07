package erp.empresa;

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
public final class EmpresaFC extends JFrame implements GUI {

	private EmpresaCT empresaCT;
	private ConfiguracaoGUI configuracaoGUI;
	private EmpresaPC empresaPC;

	public EmpresaFC() {
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

	public EmpresaCT getEmpresaHandle() {
		return empresaCT;
	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public EmpresaPC getEmpresaPC() {
		return empresaPC;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("EMPRESA");
		setIconImage(Imagem.getLogoTipoImage());
		empresaPC = new EmpresaPC();
		empresaPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(empresaPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (empresaPC.isAncestorOf(focused)) {
							empresaPC.scrollRectToVisible(focused.getBounds());
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
		empresaCT = new EmpresaCT();
		addWindowListener(empresaCT.new Frame());
		empresaPC.getTB().getExcluirBTN().addActionListener(empresaCT.new Exclui());
		empresaPC.getTB().getNovoBTN().addActionListener(empresaCT.new NovoFrame());
		empresaPC.getTB().getPesquisarBTN().addActionListener(empresaCT.new Pesquisa());
		empresaPC.getTB().getImprimirBTN().addActionListener(empresaCT.new Imprime());
		empresaPC.getTB().getRelatorioBTN().addActionListener(empresaCT.new Relatorio());
		empresaPC.getTB().getSalvarBTN().addActionListener(empresaCT.new Salva());
		empresaPC.getTB().getFecharBTN().addActionListener(empresaCT.new FechaJanela());
		empresaPC.getTB().getSairBTN().addActionListener(empresaCT.new SaidaSistema());
		empresaPC.getTB().getAjudaBTN().addActionListener(empresaCT.new Ajuda());
		empresaPC.getTB().getHomeBTN().addActionListener(empresaCT.new Home());
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
