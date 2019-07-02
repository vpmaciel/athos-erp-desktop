package erp.imovel;

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
public final class ImovelFc extends JFrame implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private ImovelControl imovelControl;
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

	public ImovelControl getImovelCont() {
		return imovelControl;
	}

	public ImovelPc getImovelPc() {
		return imovelPc;
	}

	@Override
	public void iniciarControlador() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		imovelControl = new ImovelControl();
		addWindowListener(imovelControl.new Frame());
		imovelPc.getTB().getExcluirBtn().addActionListener(imovelControl.new Exclui());
		imovelPc.getTB().getNovoBtn().addActionListener(imovelControl.new Novo());
		imovelPc.getTB().getPesquisarBtn().addActionListener(imovelControl.new Pesquisa());
		imovelPc.getTB().getImprimirBtn().addActionListener(imovelControl.new Imprime());
		imovelPc.getTB().getRelatorioBtn().addActionListener(imovelControl.new Relatorio());
		imovelPc.getTB().getSalvarBtn().addActionListener(imovelControl.new Salva());
		imovelPc.getTB().getFecharBtn().addActionListener(imovelControl.new FechaJanela());
		imovelPc.getTB().getSairBtn().addActionListener(imovelControl.new SaidaSistema());
		imovelPc.getTB().getAjudaBtn().addActionListener(imovelControl.new Ajuda());
		imovelPc.getTB().getHomeBtn().addActionListener(imovelControl.new Home());
		imovelPc.getTB().getRegistrosBtn().addActionListener(imovelControl.new Registro());
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
