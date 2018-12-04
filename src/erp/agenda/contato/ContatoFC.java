package erp.agenda.contato;

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
public final class ContatoFC extends JFrame implements GUI {

	private ContatoCT contatoCT;
	private GUIConfiguracao gUIConfiguracao;
	private ContatoPC contatoPC;

	public ContatoFC() {
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

	@Override
	public GUIConfiguracao getGUIConfiguracao() {
		return gUIConfiguracao;
	}

	public ContatoPC getPanelCadastroContato() {
		return contatoPC;
	}

	public ContatoCT getContatoHandle() {
		return contatoCT;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("CONTATO");
		setIconImage(Imagem.getLogoTipoImage());

		contatoPC = new ContatoPC();

		contatoPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(contatoPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (contatoPC.isAncestorOf(focused)) {
							contatoPC.scrollRectToVisible(focused.getBounds());
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
		contatoCT = new ContatoCT();
		addWindowListener(contatoCT.new Frame());
		contatoPC.getLabelEmpresa().addMouseListener(contatoCT.new MostraFrameContato());
		contatoPC.getToolBar().getButtonExcluiRegistro()
				.addActionListener(contatoCT.new ExcluiRegistro());
		contatoPC.getToolBar().getButtonNovoFrame().addActionListener(contatoCT.new NovoFrame());
		contatoPC.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(contatoCT.new PesquisaRegistro());
		contatoPC.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(contatoCT.new ImprimiUnicoRegistro());
		contatoPC.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(contatoCT.new ImprimiTodosRegistros());
		contatoPC.getToolBar().getButtonSalvar().addActionListener(contatoCT.new Salva());
		contatoPC.getToolBar().getButtonFechar().addActionListener(contatoCT.new FechaJanela());
		contatoPC.getToolBar().getButtonSair().addActionListener(contatoCT.new SaidaSistema());
		contatoPC.getToolBar().getButtonAjuda().addActionListener(contatoCT.new Ajuda());
		contatoPC.getToolBar().getButtonHome().addActionListener(contatoCT.new Home());

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
		gUIConfiguracao.limparGui();
	}

	@Override
	public void reiniciarGUI() {
		contatoPC.reiniciarGUI();
	}
}
