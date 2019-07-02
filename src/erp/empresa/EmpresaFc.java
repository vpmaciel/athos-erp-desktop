package erp.empresa;

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
public final class EmpresaFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private EmpresaControl empresaControl;
	private EmpresaPc empresaPc;

	public EmpresaFc() {
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

	public EmpresaControl getEmpresaCont() {
		return empresaControl;
	}

	public EmpresaPc getEmpresaPc() {
		return empresaPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		empresaControl = new EmpresaControl();
		addWindowListener(empresaControl.new Frame());
		empresaPc.getTB().getExcluirBtn().addActionListener(empresaControl.new Exclui());
		empresaPc.getTB().getNovoBtn().addActionListener(empresaControl.new NovoFrame());
		empresaPc.getTB().getPesquisarBtn().addActionListener(empresaControl.new Pesquisa());
		empresaPc.getTB().getImprimirBtn().addActionListener(empresaControl.new Imprime());
		empresaPc.getTB().getRelatorioBtn().addActionListener(empresaControl.new Relatorio());
		empresaPc.getTB().getSalvarBtn().addActionListener(empresaControl.new Salva());
		empresaPc.getTB().getFecharBtn().addActionListener(empresaControl.new FechaJanela());
		empresaPc.getTB().getSairBtn().addActionListener(empresaControl.new SaidaSistema());
		empresaPc.getTB().getAjudaBtn().addActionListener(empresaControl.new Ajuda());
		empresaPc.getTB().getHomeBtn().addActionListener(empresaControl.new Home());
		empresaPc.getTB().getRegistrosBtn().addActionListener(empresaControl.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		setIconImage(Imagem.getLogoTipoImage());
		empresaPc = new EmpresaPc();
		empresaPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(empresaPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (empresaPc.isAncestorOf(focused)) {
							empresaPc.scrollRectToVisible(focused.getBounds());
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
