package erp.sindicato;

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
public final class SindicatoFc extends JFrame implements Gui {

	private SindicatoCont sindicatoCont;
	private ConfiguracaoGui configuracaoGui;
	private SindicatoPc sindicatoPc;

	public SindicatoFc() {
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
	public ConfiguracaoGui getGUIConfiguracao() {
		return configuracaoGui;
	}

	public SindicatoPc getSindicatoPc() {
		return sindicatoPc;
	}

	public SindicatoCont getSindicatoHandle() {
		return sindicatoCont;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("SINDICATO");
		setIconImage(Imagem.getLogoTipoImage());
		sindicatoPc = new SindicatoPc();
		sindicatoPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(sindicatoPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (sindicatoPc.isAncestorOf(focused)) {
							sindicatoPc.scrollRectToVisible(focused.getBounds());
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
		sindicatoCont = new SindicatoCont();
		addWindowListener(sindicatoCont.new Frame());
		sindicatoPc.getTB().getExcluirBTN().addActionListener(sindicatoCont.new Exclui());
		sindicatoPc.getTB().getNovoBTN().addActionListener(sindicatoCont.new Novo());
		sindicatoPc.getTB().getPesquisarBTN().addActionListener(sindicatoCont.new Pesquisa());
		sindicatoPc.getTB().getImprimirBTN().addActionListener(sindicatoCont.new Imprime());
		sindicatoPc.getTB().getRelatorioBTN().addActionListener(sindicatoCont.new Relatorio());
		sindicatoPc.getTB().getSalvarBTN().addActionListener(sindicatoCont.new Salva());
		sindicatoPc.getTB().getFecharBTN().addActionListener(sindicatoCont.new FechaJanela());
		sindicatoPc.getTB().getSairBTN().addActionListener(sindicatoCont.new SaidaSistema());
		sindicatoPc.getTB().getAjudaBTN().addActionListener(sindicatoCont.new Ajuda());
		sindicatoPc.getTB().getHomeBTN().addActionListener(sindicatoCont.new Home());
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
		configuracaoGui.limparGui();
	}

	@Override
	public void reiniciarGUI() {

	}
}
