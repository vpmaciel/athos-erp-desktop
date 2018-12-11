package erp.banco;

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
public final class BancoFC extends JFrame implements GUI {

	private BancoCT bancoCT;
	private ConfiguracaoGUI configuracaoGUI;
	private BancoPC bancoPC;

	public BancoFC() {
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

	public BancoCT getBancoHandle() {
		return bancoCT;
	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public BancoPC getBancoPC() {
		return bancoPC;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("BANCO");
		setIconImage(Imagem.getLogoTipoImage());
		bancoPC = new BancoPC();
		bancoPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(bancoPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (bancoPC.isAncestorOf(focused)) {
							bancoPC.scrollRectToVisible(focused.getBounds());
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
		bancoCT = new BancoCT();
		addWindowListener(bancoCT.new Frame());
		bancoPC.getTB().getExcluirBTN().addActionListener(bancoCT.new Exclui());
		bancoPC.getTB().getNovoBTN().addActionListener(bancoCT.new Novo());
		bancoPC.getTB().getPesquisarBTN().addActionListener(bancoCT.new Pesquisa());
		bancoPC.getTB().getImprimirBTN().addActionListener(bancoCT.new Imprime());
		bancoPC.getTB().getRelatorioBTN().addActionListener(bancoCT.new Relatorio());
		bancoPC.getTB().getSalvarBTN().addActionListener(bancoCT.new Salva());
		bancoPC.getTB().getFecharBTN().addActionListener(bancoCT.new FechaJanela());
		bancoPC.getTB().getSairBTN().addActionListener(bancoCT.new SaidaSistema());
		bancoPC.getTB().getAjudaBTN().addActionListener(bancoCT.new Ajuda());
		bancoPC.getTB().getHomeBTN().addActionListener(bancoCT.new Home());
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
		bancoPC.limparGUI();
	}

	@Override
	public void reiniciarGUI() {
		bancoPC.reiniciarGUI();
	}

	public boolean validarCamposCadastro() {
		return bancoPC.validarCamposCadastro();
	}
}
