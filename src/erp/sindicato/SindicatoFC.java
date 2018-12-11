package erp.sindicato;

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
public final class SindicatoFC extends JFrame implements GUI {

	private SindicatoCT sindicatoCT;
	private ConfiguracaoGUI configuracaoGUI;
	private SindicatoPC sindicatoPC;

	public SindicatoFC() {
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
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public SindicatoPC getSindicatoPC() {
		return sindicatoPC;
	}

	public SindicatoCT getSindicatoHandle() {
		return sindicatoCT;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("SINDICATO");
		setIconImage(Imagem.getLogoTipoImage());
		sindicatoPC = new SindicatoPC();
		sindicatoPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(sindicatoPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (sindicatoPC.isAncestorOf(focused)) {
							sindicatoPC.scrollRectToVisible(focused.getBounds());
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
		sindicatoCT = new SindicatoCT();
		addWindowListener(sindicatoCT.new Frame());
		sindicatoPC.getTB().getExcluirBTN().addActionListener(sindicatoCT.new Exclui());
		sindicatoPC.getTB().getNovoBTN().addActionListener(sindicatoCT.new Novo());
		sindicatoPC.getTB().getPesquisarBTN().addActionListener(sindicatoCT.new Pesquisa());
		sindicatoPC.getTB().getImprimirBTN().addActionListener(sindicatoCT.new Imprime());
		sindicatoPC.getTB().getRelatorioBTN().addActionListener(sindicatoCT.new Relatorio());
		sindicatoPC.getTB().getSalvarBTN().addActionListener(sindicatoCT.new Salva());
		sindicatoPC.getTB().getFecharBTN().addActionListener(sindicatoCT.new FechaJanela());
		sindicatoPC.getTB().getSairBTN().addActionListener(sindicatoCT.new SaidaSistema());
		sindicatoPC.getTB().getAjudaBTN().addActionListener(sindicatoCT.new Ajuda());
		sindicatoPC.getTB().getHomeBTN().addActionListener(sindicatoCT.new Home());
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
		configuracaoGUI.limparGui();
	}

	@Override
	public void reiniciarGUI() {

	}
}
