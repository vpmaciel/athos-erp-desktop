package erp.cliente;

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
public final class ClienteFc extends JFrame implements Gui {

	private ClienteControl clienteControl;
	private ClientePc clientePc;
	private ConfiguracaoGui configuracaoGui;

	public ClienteFc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public ClienteControl getClienteCont() {
		return clienteControl;
	}

	public ClientePc getClientePc() {
		return clientePc;
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		clienteControl = new ClienteControl();
		addWindowListener(clienteControl.new Frame());
		clientePc.getLabelEmpresa().addMouseListener(clienteControl.new MostraFrame());
		clientePc.getLabelBanco().addMouseListener(clienteControl.new MostraFrame());
		clientePc.getTB().getExcluirBtn().addActionListener(clienteControl.new Exclui());
		clientePc.getTB().getNovoBtn().addActionListener(clienteControl.new Novo());
		clientePc.getTB().getPesquisarBtn().addActionListener(clienteControl.new Pesquisa());
		clientePc.getTB().getImprimirBtn().addActionListener(clienteControl.new Imprime());
		clientePc.getTB().getRelatorioBtn().addActionListener(clienteControl.new Relatorio());
		clientePc.getTB().getSalvarBtn().addActionListener(clienteControl.new Salva());
		clientePc.getTB().getFecharBtn().addActionListener(clienteControl.new FechaJanela());
		clientePc.getTB().getSairBtn().addActionListener(clienteControl.new SaidaSistema());
		clientePc.getTB().getAjudaBtn().addActionListener(clienteControl.new Ajuda());
		clientePc.getTB().getHomeBtn().addActionListener(clienteControl.new Home());
		clientePc.getTB().getRegistrosBtn().addActionListener(clienteControl.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());

		clientePc = new ClientePc();
		clientePc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(clientePc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (clientePc.isAncestorOf(focused)) {
							clientePc.scrollRectToVisible(focused.getBounds());
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
		clientePc.reiniciarGui();
	}
}
