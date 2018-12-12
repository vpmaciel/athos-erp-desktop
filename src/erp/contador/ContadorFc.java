package erp.contador;

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
public final class ContadorFc extends JFrame implements Gui {

	private ContadorCont contadorCont;
	private ConfiguracaoGui configuracaoGui;
	private ContadorPc contadorPc;

	public ContadorFc() {
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

	public ContadorCont getContadorHandle() {
		return contadorCont;
	}

	@Override
	public ConfiguracaoGui getGUIConfiguracao() {
		return configuracaoGui;
	}

	public ContadorPc getContadorPc() {
		return contadorPc;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGUI() {

		setTitle("CONTADOR");
		setIconImage(Imagem.getLogoTipoImage());
		contadorPc = new ContadorPc();
		contadorPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(contadorPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (contadorPc.isAncestorOf(focused)) {
							contadorPc.scrollRectToVisible(focused.getBounds());
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
		contadorCont = new ContadorCont();
		addWindowListener(contadorCont.new Frame());
		contadorPc.getTB().getExcluirBTN().addActionListener(contadorCont.new Exclui());
		contadorPc.getTB().getNovoBTN().addActionListener(contadorCont.new Novo());
		contadorPc.getTB().getPesquisarBTN().addActionListener(contadorCont.new Pesquisa());
		contadorPc.getTB().getImprimirBTN().addActionListener(contadorCont.new Imprime());
		contadorPc.getTB().getRelatorioBTN().addActionListener(contadorCont.new Relatorio());
		contadorPc.getTB().getSalvarBTN().addActionListener(contadorCont.new Salva());
		contadorPc.getTB().getFecharBTN().addActionListener(contadorCont.new FechaJanela());
		contadorPc.getTB().getSairBTN().addActionListener(contadorCont.new SaidaSistema());
		contadorPc.getTB().getAjudaBTN().addActionListener(contadorCont.new Ajuda());
		contadorPc.getTB().getHomeBTN().addActionListener(contadorCont.new Home());
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
