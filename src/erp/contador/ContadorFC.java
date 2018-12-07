package erp.contador;

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
public final class ContadorFC extends JFrame implements GUI {

	private ContadorCT contadorCT;
	private ConfiguracaoGUI configuracaoGUI;
	private ContadorPC contadorPC;

	public ContadorFC() {
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

	public ContadorCT getContadorHandle() {
		return contadorCT;
	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public ContadorPC getPanelCadastroContador() {
		return contadorPC;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {

		setTitle("CONTADOR");
		setIconImage(Imagem.getLogoTipoImage());
		contadorPC = new ContadorPC();
		contadorPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(contadorPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (contadorPC.isAncestorOf(focused)) {
							contadorPC.scrollRectToVisible(focused.getBounds());
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
		contadorCT = new ContadorCT();
		addWindowListener(contadorCT.new Frame());
		contadorPC.getTB().getExcluirBTN().addActionListener(contadorCT.new Exclui());
		contadorPC.getTB().getNovoBTN().addActionListener(contadorCT.new Novo());
		contadorPC.getTB().getPesquisarBTN().addActionListener(contadorCT.new Pesquisa());
		contadorPC.getTB().getImprimirBTN().addActionListener(contadorCT.new Imprime());
		contadorPC.getTB().getRelatorioBTN().addActionListener(contadorCT.new Relatorio());
		contadorPC.getTB().getSalvarBTN().addActionListener(contadorCT.new Salva());
		contadorPC.getTB().getFecharBTN().addActionListener(contadorCT.new FechaJanela());
		contadorPC.getTB().getSairBTN().addActionListener(contadorCT.new SaidaSistema());
		contadorPC.getTB().getAjudaBTN().addActionListener(contadorCT.new Ajuda());
		contadorPC.getTB().getHomeBTN().addActionListener(contadorCT.new Home());
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
