package erp.usuario;

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
public final class UsuarioFc extends JFrame implements Gui {

	private UsuarioCont usuarioCont;
	private ConfiguracaoGui configuracaoGui;
	private UsuarioPc usuarioPc;

	public UsuarioFc() {
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

	@Override
	public ConfiguracaoGui getGUIConfiguracao() {
		return configuracaoGui;
	}

	public UsuarioPc getUsuarioPc() {
		return usuarioPc;
	}

	public UsuarioPc getPanelUsuario() {
		return usuarioPc;
	}

	public UsuarioCont getUsuarioHandle() {
		return usuarioCont;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		final FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("USUÁRIO");
		setIconImage(Imagem.getLogoTipoImage());
		usuarioPc = new UsuarioPc();
		usuarioPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(usuarioPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (usuarioPc.isAncestorOf(focused)) {
							usuarioPc.scrollRectToVisible(focused.getBounds());
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
		usuarioCont = new UsuarioCont();
		addWindowListener(usuarioCont.new Frame());
		usuarioPc.getTB().getExcluirBTN().addActionListener(usuarioCont.new Exclui());
		usuarioPc.getTB().getNovoBTN().addActionListener(usuarioCont.new Novo());
		usuarioPc.getTB().getPesquisarBTN().addActionListener(usuarioCont.new Pesquisa());
		usuarioPc.getTB().getImprimirBTN().addActionListener(usuarioCont.new Imprime());
		usuarioPc.getTB().getRelatorioBTN().addActionListener(usuarioCont.new Relatorio());
		usuarioPc.getTB().getSalvarBTN().addActionListener(usuarioCont.new Salva());
		usuarioPc.getTB().getFecharBTN().addActionListener(usuarioCont.new FechaJanela());
		usuarioPc.getTB().getSairBTN().addActionListener(usuarioCont.new SaidaSistema());
		usuarioPc.getTB().getAjudaBTN().addActionListener(usuarioCont.new Ajuda());
		usuarioPc.getTB().getHomeBTN().addActionListener(usuarioCont.new Home());
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
		usuarioPc.limparGUI();
	}

	@Override
	public void reiniciarGUI() {

	}

	public boolean validarCamposCadastro() {
		return usuarioPc.validarCamposCadastro();
	}
}
