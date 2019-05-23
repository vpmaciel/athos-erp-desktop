package erp.imovel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class ImovelFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private ImovelCont imovelCont;
	private ImovelPc imovelPc;

	public ImovelFc() {
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

	public ImovelCont getImovelCont() {
		return imovelCont;
	}

	public ImovelPc getImovelPc() {
		return imovelPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
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
		imovelPc.getTB().getRegistrosBtn().addActionListener(imovelCont.new Registro());
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
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
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(800, 600));
		setSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
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
