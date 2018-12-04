package erp.login;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.FocusTabListener;
import arquitetura.gui.GUI;
import arquitetura.gui.GUIConfiguracao;
import arquitetura.gui.TamanhoUpperCase;
import arquitetura.util.SpringUtilities;

@SuppressWarnings("serial")
public final class PLogin extends JPanel implements GUI {

	private JButton buttonEntrar;
	private JPasswordField textFieldSenha;
	private GUIConfiguracao gUIConfiguracao;
	private JLabel labelNome;
	private JLabel labelSenha;
	private JLabel labelEntrar;
	private JTextField textFieldNome;

	public PLogin() {
		iniciarLayout();
		iniciarGUI();
		iniciarFocoControlador();
		iniciarGUIControlador();
		buttonEntrar.setPreferredSize(new Dimension(740, 25));
		buttonEntrar.setMinimumSize(new Dimension(740, 25));
		buttonEntrar.setSize(new Dimension(740, 25));
		buttonEntrar.setMaximumSize(new Dimension(740, 25));
	}

	public void atualizarLabel() {
	}

	@Override
	public void atualizarTable() {
	}

	public JButton getButtonEntrar() {
		return buttonEntrar;
	}

	@Override
	public GUIConfiguracao getGUIConfiguracao() {
		return gUIConfiguracao;
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public JPasswordField getTextFieldSenha() {
		return textFieldSenha;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {

		labelNome = new JLabel("USUÁRIO");
		add(labelNome);

		textFieldNome = new JTextField(25);
		textFieldNome.setDocument(new TamanhoUpperCase(10));
		textFieldNome.setText("ADMIN");
		textFieldNome.requestFocus();
		add(textFieldNome);

		labelSenha = new JLabel("SENHA");
		add(labelSenha);

		textFieldSenha = new JPasswordField(25);
		textFieldSenha.setDocument(new TamanhoUpperCase(10));
		textFieldSenha.setText("123");
		add(textFieldSenha);

		labelEntrar = new JLabel("ENTRAR");
		add(labelEntrar);

		buttonEntrar = new JButton("ENTRAR");
		add(buttonEntrar);

		SpringUtilities.makeCompactGrid(this, 6, 1, // rows, cols
				5, 5, // initX, initY
				5, 5); // xPad, yPad
		setOpaque(true); // content panes must be opaque
	}

	@Override
	public void iniciarGUIControlador() {
		gUIConfiguracao = new GUIConfiguracao(this);
	}

	@Override
	public void iniciarControlador() {

	}

	@Override
	public void iniciarLayout() {
		setLayout(new SpringLayout());
	}

	@Override
	public void iniciarTabela() {

	}

	@Override
	public void limparGUI() {

	}

	@Override
	public void reiniciarGUI() {

	}

	public boolean validarCamposCadastro() {

		if (getTextFieldNome().getText().length() == 0 || new String(getTextFieldSenha().getPassword()).length() == 0) {
			System.exit(0);
		}

		return true;
	}
}
