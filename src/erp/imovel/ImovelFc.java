package erp.imovel;

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
public final class ImovelFc extends JFrame implements Gui {

	private ImovelCont imovelCont;
	private ConfiguracaoGui configuracaoGui;
	private ImovelPc imovelPc;

	public ImovelFc() {
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

	public ImovelCont getImovelHandle() {
		return imovelCont;
	}

	public ImovelPc getImovelPc() {
		return imovelPc;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("Imóveis");
		setIconImage(Imagem.getLogoTipoImage());
		imovelPc = new ImovelPc();
		imovelPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(imovelPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (imovelPc.isAncestorOf(focused)) {
							imovelPc.scrollRectToVisible(focused.getBounds());
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
		imovelCont = new ImovelCont();
		addWindowListener(imovelCont.new Frame());
		imovelPc.getTB().getExcluirBtn().addActionListener(imovelCont.new Exclui());
		imovelPc.getTB().getNovoBtn().addActionListener(imovelCont.new Novo());
		imovelPc.getTB().getPesquisarBtn().addActionListener(imovelCont.new Pesquisa());
		imovelPc.getTB().getImprimirBtn().addActionListener(imovelCont.new Imprime());
		imovelPc.getTB().getRelatorioBtn().addActionListener(imovelCont.new Relatorio());
		imovelPc.getTB().getSalvarBtn().addActionListener(imovelCont.new Salva());
		imovelPc.getTB().getFecharBtn().addActionListener(imovelCont.new FechaJanela());
		imovelPc.getTB().getSairBtn().addActionListener(imovelCont.new SaidaSistema());
		imovelPc.getTB().getAjudaBtn().addActionListener(imovelCont.new Ajuda());
		imovelPc.getTB().getHomeBtn().addActionListener(imovelCont.new Home());
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