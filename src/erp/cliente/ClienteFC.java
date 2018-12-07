package erp.cliente;

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
public final class ClienteFC extends JFrame implements GUI {

	private ClienteCT clienteCT;
	private ConfiguracaoGUI configuracaoGUI;
	private ClientePC clientePC;

	public ClienteFC() {
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

	public ClienteCT getClienteHandle() {
		return clienteCT;
	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public ClientePC getClientePC() {
		return clientePC;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("CLIENTE");
		setIconImage(Imagem.getLogoTipoImage());

		clientePC = new ClientePC();
		clientePC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(clientePC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (clientePC.isAncestorOf(focused)) {
							clientePC.scrollRectToVisible(focused.getBounds());
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
		clienteCT = new ClienteCT();
		addWindowListener(clienteCT.new Frame());
		clientePC.getLabelEmpresa().addMouseListener(clienteCT.new MostraFrame());
		clientePC.getLabelBanco().addMouseListener(clienteCT.new MostraFrame());
		clientePC.getTB().getExcluirBTN().addActionListener(clienteCT.new Exclui());
		clientePC.getTB().getNovoBTN().addActionListener(clienteCT.new Novo());
		clientePC.getTB().getPesquisarBTN().addActionListener(clienteCT.new Pesquisa());
		clientePC.getTB().getImprimirBTN().addActionListener(clienteCT.new Imprime());
		clientePC.getTB().getRelatorioBTN().addActionListener(clienteCT.new Relatorio());
		clientePC.getTB().getSalvarBTN().addActionListener(clienteCT.new Salva());
		clientePC.getTB().getFecharBTN().addActionListener(clienteCT.new FechaJanela());
		clientePC.getTB().getSairBTN().addActionListener(clienteCT.new SaidaSistema());
		clientePC.getTB().getAjudaBTN().addActionListener(clienteCT.new Ajuda());
		clientePC.getTB().getHomeBTN().addActionListener(clienteCT.new Home());
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
		clientePC.reiniciarGUI();
	}
}
