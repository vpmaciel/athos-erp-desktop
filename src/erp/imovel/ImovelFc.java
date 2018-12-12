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
public final class ImovelFc extends JFrame implements GUI {

	private ImovelCont imovelCont;
	private ConfiguracaoGUI configuracaoGUI;
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
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
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
		FocusTabListener focusTabListener = new FocusTabListener(this);
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
		configuracaoGUI = new ConfiguracaoGUI(this);
	}

	@Override
	public void iniciarControlador() {
		imovelCont = new ImovelCont();
		addWindowListener(imovelCont.new Frame());
		imovelPc.getTB().getExcluirBTN().addActionListener(imovelCont.new Exclui());
		imovelPc.getTB().getNovoBTN().addActionListener(imovelCont.new Novo());
		imovelPc.getTB().getPesquisarBTN().addActionListener(imovelCont.new Pesquisa());
		imovelPc.getTB().getImprimirBTN().addActionListener(imovelCont.new Imprime());
		imovelPc.getTB().getRelatorioBTN().addActionListener(imovelCont.new Relatorio());
		imovelPc.getTB().getSalvarBTN().addActionListener(imovelCont.new Salva());
		imovelPc.getTB().getFecharBTN().addActionListener(imovelCont.new FechaJanela());
		imovelPc.getTB().getSairBTN().addActionListener(imovelCont.new SaidaSistema());
		imovelPc.getTB().getAjudaBTN().addActionListener(imovelCont.new Ajuda());
		imovelPc.getTB().getHomeBTN().addActionListener(imovelCont.new Home());
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
		configuracaoGUI.limparGui();
	}

	@Override
	public void reiniciarGUI() {

	}
}
