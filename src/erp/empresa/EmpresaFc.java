package erp.empresa;

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
public final class EmpresaFc extends JFrame implements Gui {

	private EmpresaCont empresaCont;
	private ConfiguracaoGui configuracaoGui;
	private EmpresaPc empresaPc;

	public EmpresaFc() {
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

	public EmpresaCont getEmpresaHandle() {
		return empresaCont;
	}

	@Override
	public ConfiguracaoGui getGUIConfiguracao() {
		return configuracaoGui;
	}

	public EmpresaPc getEmpresaPc() {
		return empresaPc;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("EMPRESA");
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
		empresaCont = new EmpresaCont();
		addWindowListener(empresaCont.new Frame());
		empresaPc.getTB().getExcluirBTN().addActionListener(empresaCont.new Exclui());
		empresaPc.getTB().getNovoBTN().addActionListener(empresaCont.new NovoFrame());
		empresaPc.getTB().getPesquisarBTN().addActionListener(empresaCont.new Pesquisa());
		empresaPc.getTB().getImprimirBTN().addActionListener(empresaCont.new Imprime());
		empresaPc.getTB().getRelatorioBTN().addActionListener(empresaCont.new Relatorio());
		empresaPc.getTB().getSalvarBTN().addActionListener(empresaCont.new Salva());
		empresaPc.getTB().getFecharBTN().addActionListener(empresaCont.new FechaJanela());
		empresaPc.getTB().getSairBTN().addActionListener(empresaCont.new SaidaSistema());
		empresaPc.getTB().getAjudaBTN().addActionListener(empresaCont.new Ajuda());
		empresaPc.getTB().getHomeBTN().addActionListener(empresaCont.new Home());
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
