package erp.login;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.Sis;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.util.SpringUtilities;

@SuppressWarnings("serial")
public final class LoginPc extends JPanel implements Gui {

	private JButton buttonEntrar;
	private ConfiguracaoGui configuracaoGui;
	private JTextField fieldNome;
	private JPasswordField fieldSenha;

	public LoginPc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
		buttonEntrar.setPreferredSize(new Dimension(740, 30));
		buttonEntrar.setMinimumSize(new Dimension(740, 30));
		buttonEntrar.setSize(new Dimension(740, 30));
		buttonEntrar.setMaximumSize(new Dimension(740, 30));
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
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public JTextField getTextFieldNome() {
		return fieldNome;
	}

	public JPasswordField getTextFieldSenha() {
		return fieldSenha;
	}

	@Override
	public void iniciarControlador() {

	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {

		add(new JLabel("USUÁRIO"));

		fieldNome = new JTextField(25);
		fieldNome.setDocument(new EntradaMaiuscula(10));
		fieldNome.setText("ADMIN");
		fieldNome.requestFocus();
		add(fieldNome);

		add(new JLabel("SENHA"));

		fieldSenha = new JPasswordField(25);
		fieldSenha.setDocument(new EntradaMaiuscula(10));
		fieldSenha.setText("123");
		add(fieldSenha);

		add(new JLabel("ENTRAR"));

		buttonEntrar = new JButton("ENTRAR");
		add(buttonEntrar);

		SpringUtilities.makeCompactGrid(this, 6, 1, // rows, cols
				5, 5, // initX, initY
				5, 5); // xPad, yPad
		setOpaque(true); // content panes must be opaque
	}

	@Override
	public void iniciarGuiControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarLayout() {
		setBorder(Sis.getBordaPainel());
		setLayout(new SpringLayout());
	}

	@Override
	public void iniciarTabela() {

	}

	@Override
	public void limparGui() {

	}

	@Override
	public void reiniciarGui() {

	}

	public boolean validarGui() {

		if (getTextFieldNome().getText().length() == 0 || new String(getTextFieldSenha().getPassword()).length() == 0) {
			System.exit(0);
		}

		return true;
	}
}
