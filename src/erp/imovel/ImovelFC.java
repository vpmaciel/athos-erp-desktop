package erp.imovel;

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
public final class ImovelFC extends JFrame implements GUI {

	private ImovelCT imovelCT;
	private ConfiguracaoGUI configuracaoGUI;
	private ImovelPC imovelPC;

	public ImovelFC() {
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

	public ImovelCT getImovelHandle() {
		return imovelCT;
	}

	public ImovelPC getImovelPC() {
		return imovelPC;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("Imóveis");
		setIconImage(Imagem.getLogoTipoImage());
		imovelPC = new ImovelPC();
		imovelPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(imovelPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (imovelPC.isAncestorOf(focused)) {
							imovelPC.scrollRectToVisible(focused.getBounds());
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
		imovelCT = new ImovelCT();
		addWindowListener(imovelCT.new Frame());
		imovelPC.getTB().getExcluirBTN().addActionListener(imovelCT.new Exclui());
		imovelPC.getTB().getNovoBTN().addActionListener(imovelCT.new Novo());
		imovelPC.getTB().getPesquisarBTN().addActionListener(imovelCT.new Pesquisa());
		imovelPC.getTB().getImprimirBTN().addActionListener(imovelCT.new Imprime());
		imovelPC.getTB().getRelatorioBTN().addActionListener(imovelCT.new Relatorio());
		imovelPC.getTB().getSalvarBTN().addActionListener(imovelCT.new Salva());
		imovelPC.getTB().getFecharBTN().addActionListener(imovelCT.new FechaJanela());
		imovelPC.getTB().getSairBTN().addActionListener(imovelCT.new SaidaSistema());
		imovelPC.getTB().getAjudaBTN().addActionListener(imovelCT.new Ajuda());
		imovelPC.getTB().getHomeBTN().addActionListener(imovelCT.new Home());
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
