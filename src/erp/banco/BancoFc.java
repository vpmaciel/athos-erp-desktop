package erp.banco;

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
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class BancoFc extends JFrame implements Gui {

	private BancoCont bancoCont;
	private ConfiguracaoGui configuracaoGui;
	private BancoPc bancoPc;

	public BancoFc() {
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

	public void desabilitarGui() {
	}

	public BancoCont getBancoHandle() {
		return bancoCont;
	}

	@Override
	public ConfiguracaoGui getGUIConfiguracao() {
		return configuracaoGui;
	}

	public BancoPc getBancoPc() {
		return bancoPc;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("BANCO");
		setIconImage(Imagem.getLogoTipoImage());
		bancoPc = new BancoPc();
		bancoPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(bancoPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (bancoPc.isAncestorOf(focused)) {
							bancoPc.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();
	}

	@Override
	public void iniciarGUIControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarControlador() {
		bancoCont = new BancoCont();
		addWindowListener(bancoCont.new Frame());
		bancoPc.getTB().getExcluirBtn().addActionListener(bancoCont.new Exclui());
		bancoPc.getTB().getNovoBtn().addActionListener(bancoCont.new Novo());
		bancoPc.getTB().getPesquisarBtn().addActionListener(bancoCont.new Pesquisa());
		bancoPc.getTB().getImprimirBtn().addActionListener(bancoCont.new Imprime());
		bancoPc.getTB().getRelatorioBtn().addActionListener(bancoCont.new Relatorio());
		bancoPc.getTB().getSalvarBtn().addActionListener(bancoCont.new Salva());
		bancoPc.getTB().getFecharBtn().addActionListener(bancoCont.new FechaJanela());
		bancoPc.getTB().getSairBtn().addActionListener(bancoCont.new SaidaSistema());
		bancoPc.getTB().getAjudaBtn().addActionListener(bancoCont.new Ajuda());
		bancoPc.getTB().getHomeBtn().addActionListener(bancoCont.new Home());
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
		bancoPc.limparGUI();
	}

	@Override
	public void reiniciarGUI() {
		bancoPc.reiniciarGUI();
	}

	public boolean validarCamposCadastro() {
		return bancoPc.validarCamposCadastro();
	}
}
