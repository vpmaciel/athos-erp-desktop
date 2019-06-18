package erp.usuario;

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
public final class UsuarioFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private UsuarioCont usuarioCont;
	private UsuarioPc usuarioPc;

	public UsuarioFc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public void desabilitarGui() {

	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public UsuarioPc getPanelUsuario() {
		return usuarioPc;
	}

	public UsuarioCont getUsuarioCont() {
		return usuarioCont;
	}

	public UsuarioPc getUsuarioPc() {
		return usuarioPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		usuarioCont = new UsuarioCont();
		addWindowListener(usuarioCont.new Frame());
		usuarioPc.getTB().getExcluirBtn().addActionListener(usuarioCont.new Exclui());
		usuarioPc.getTB().getNovoBtn().addActionListener(usuarioCont.new Novo());
		usuarioPc.getTB().getPesquisarBtn().addActionListener(usuarioCont.new Pesquisa());
		usuarioPc.getTB().getImprimirBtn().addActionListener(usuarioCont.new Imprime());
		usuarioPc.getTB().getRelatorioBtn().addActionListener(usuarioCont.new Relatorio());
		usuarioPc.getTB().getSalvarBtn().addActionListener(usuarioCont.new Salva());
		usuarioPc.getTB().getFecharBtn().addActionListener(usuarioCont.new FechaJanela());
		usuarioPc.getTB().getSairBtn().addActionListener(usuarioCont.new SaidaSistema());
		usuarioPc.getTB().getAjudaBtn().addActionListener(usuarioCont.new Ajuda());
		usuarioPc.getTB().getHomeBtn().addActionListener(usuarioCont.new Home());
		usuarioPc.getTB().getRegistrosBtn().addActionListener(usuarioCont.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		final FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
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
		usuarioPc.limparGui();
	}

	@Override
	public void reiniciarGui() {

	}

	public boolean validarGui() {
		return usuarioPc.validarGui();
	}
}
