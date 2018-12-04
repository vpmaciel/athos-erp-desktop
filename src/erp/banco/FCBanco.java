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
import arquitetura.gui.GUIConfiguracao;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class FCBanco extends JFrame implements GUI {

	private BancoControlador bancoControlador;
	private GUIConfiguracao gUIConfiguracao;
	private PCBanco pCBanco;

	public FCBanco() {
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

	public BancoControlador getBancoHandle() {
		return bancoControlador;
	}

	@Override
	public GUIConfiguracao getGUIConfiguracao() {
		return gUIConfiguracao;
	}

	public PCBanco getPanelCadastroBanco() {
		return pCBanco;
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
		pCBanco = new PCBanco();
		pCBanco.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pCBanco);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pCBanco.isAncestorOf(focused)) {
							pCBanco.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();
	}

	@Override
	public void iniciarGUIControlador() {
		gUIConfiguracao = new GUIConfiguracao(this);
	}

	@Override
	public void iniciarControlador() {
		bancoControlador = new BancoControlador();
		addWindowListener(bancoControlador.new Frame());
		pCBanco.getToolBar().getButtonExcluiRegistro()
				.addActionListener(bancoControlador.new ExcluiRegistro());
		pCBanco.getToolBar().getButtonNovoFrame().addActionListener(bancoControlador.new NovoFrame());
		pCBanco.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(bancoControlador.new PesquisaRegistro());
		pCBanco.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(bancoControlador.new ImprimiUnicoRegistro());
		pCBanco.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(bancoControlador.new ImprimiTodosRegistros());
		pCBanco.getToolBar().getButtonSalvar().addActionListener(bancoControlador.new Salva());
		pCBanco.getToolBar().getButtonFechar().addActionListener(bancoControlador.new FechaJanela());
		pCBanco.getToolBar().getButtonSair().addActionListener(bancoControlador.new SaidaSistema());
		pCBanco.getToolBar().getButtonAjuda().addActionListener(bancoControlador.new Ajuda());
		pCBanco.getToolBar().getButtonHome().addActionListener(bancoControlador.new Home());
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
		pCBanco.limparGUI();
	}

	@Override
	public void reiniciarGUI() {
		pCBanco.reiniciarGUI();
	}

	public boolean validarCamposCadastro() {
		return pCBanco.validarCamposCadastro();
	}
}
