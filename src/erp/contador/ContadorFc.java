package erp.contador;

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
public final class ContadorFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private ContadorControl contadorControl;
	private ContadorPc contadorPc;

	public ContadorFc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public ContadorControl getContadorCont() {
		return contadorControl;
	}

	public ContadorPc getContadorPc() {
		return contadorPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		contadorControl = new ContadorControl();
		addWindowListener(contadorControl.new Frame());
		contadorPc.getTB().getExcluirBtn().addActionListener(contadorControl.new Exclui());
		contadorPc.getTB().getNovoBtn().addActionListener(contadorControl.new Novo());
		contadorPc.getTB().getPesquisarBtn().addActionListener(contadorControl.new Pesquisa());
		contadorPc.getTB().getImprimirBtn().addActionListener(contadorControl.new Imprime());
		contadorPc.getTB().getRelatorioBtn().addActionListener(contadorControl.new Relatorio());
		contadorPc.getTB().getSalvarBtn().addActionListener(contadorControl.new Salva());
		contadorPc.getTB().getFecharBtn().addActionListener(contadorControl.new FechaJanela());
		contadorPc.getTB().getSairBtn().addActionListener(contadorControl.new SaidaSistema());
		contadorPc.getTB().getAjudaBtn().addActionListener(contadorControl.new Ajuda());
		contadorPc.getTB().getHomeBtn().addActionListener(contadorControl.new Home());
		contadorPc.getTB().getRegistrosBtn().addActionListener(contadorControl.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
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

	}
}
