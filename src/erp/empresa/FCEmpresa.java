package erp.empresa;

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
import arquitetura.gui.GUIConfiguracao;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class FCEmpresa extends JFrame implements GUI {

	private EmpresaControlador empresaControlador;
	private GUIConfiguracao gUIConfiguracao;
	private PCEmpresa pCEmpresa;

	public FCEmpresa() {
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

	public EmpresaControlador getEmpresaHandle() {
		return empresaControlador;
	}

	@Override
	public GUIConfiguracao getGUIConfiguracao() {
		return gUIConfiguracao;
	}

	public PCEmpresa getPanelCadastroEmpresa() {
		return pCEmpresa;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("EMPRESA");
		setIconImage(Imagem.getLogoTipoImage());
		pCEmpresa = new PCEmpresa();
		pCEmpresa.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pCEmpresa);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pCEmpresa.isAncestorOf(focused)) {
							pCEmpresa.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();
	}

	@Override
	public void iniciarGUIControlador() {
		gUIConfiguracao = new GUIConfiguracao(this);
	}

	@Override
	public void iniciarControlador() {
		empresaControlador = new EmpresaControlador();
		addWindowListener(empresaControlador.new Frame());
		pCEmpresa.getToolBar().getButtonExcluiRegistro()
				.addActionListener(empresaControlador.new ExcluiRegistro());
		pCEmpresa.getToolBar().getButtonNovoFrame().addActionListener(empresaControlador.new NovoFrame());
		pCEmpresa.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(empresaControlador.new PesquisaRegistro());
		pCEmpresa.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(empresaControlador.new ImprimiUnicoRegistro());
		pCEmpresa.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(empresaControlador.new ImprimiTodosRegistros());
		pCEmpresa.getToolBar().getButtonSalvar().addActionListener(empresaControlador.new Salva());
		pCEmpresa.getToolBar().getButtonFechar().addActionListener(empresaControlador.new FechaJanela());
		pCEmpresa.getToolBar().getButtonSair().addActionListener(empresaControlador.new SaidaSistema());
		pCEmpresa.getToolBar().getButtonAjuda().addActionListener(empresaControlador.new Ajuda());
		pCEmpresa.getToolBar().getButtonHome().addActionListener(empresaControlador.new Home());
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
		gUIConfiguracao.limparGui();
	}

	@Override
	public void reiniciarGUI() {

	}
}
