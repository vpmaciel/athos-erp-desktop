package arquitetura.registro;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;

import arquitetura.gui.Imagem;

public class ToolBar {

	JToolBar toolBar = new JToolBar();

	JButton buttonHome = new JButton(Imagem.getHome());
	JButton buttonNovoFrame = new JButton(Imagem.getNovoFrame());
	JButton buttonExcluiRegistro = new JButton(Imagem.getExcluiRegistro());
	JButton buttonSalvar = new JButton(Imagem.getSalva());
	JButton buttonImprimiUnicoRegistro = new JButton(Imagem.getImprimiRegistro());
	JButton buttonPesquisaRegistro = new JButton(Imagem.getpesquisarRegistro());
	JButton buttonImprimiTodosRegistros = new JButton(Imagem.getImprimiRelatorio());
	JButton buttonAjuda = new JButton(Imagem.getAjudar());
	JButton buttonFechar = new JButton(Imagem.getFechar());
	JButton buttonSair = new JButton(Imagem.getSair());

	public ToolBar() {

		toolBar.setPreferredSize(new Dimension(700, 40));
		toolBar.setMinimumSize(new Dimension(700, 40));
		toolBar.setSize(new Dimension(700, 40));
		toolBar.setMaximumSize(new Dimension(700, 40));
		toolBar.setFloatable(false);
		toolBar.setOpaque(false);
		toolBar.setBorder(BorderFactory.createEmptyBorder());

		buttonHome.setToolTipText("Home");
		toolBar.add(buttonHome);

		buttonNovoFrame.setToolTipText("Novo");
		toolBar.add(buttonNovoFrame);

		buttonExcluiRegistro.setToolTipText("Excluir");
		toolBar.add(buttonExcluiRegistro);

		buttonSalvar.setToolTipText("Salvar");
		toolBar.add(buttonSalvar);

		buttonPesquisaRegistro.setToolTipText("Pesquisar");
		toolBar.add(buttonPesquisaRegistro);

		buttonImprimiUnicoRegistro.setToolTipText("Imprimir");
		toolBar.add(buttonImprimiUnicoRegistro);

		buttonImprimiTodosRegistros.setToolTipText("Relatório");
		toolBar.add(buttonImprimiTodosRegistros);

		buttonAjuda.setToolTipText("Ajuda");
		toolBar.add(buttonAjuda);

		buttonFechar.setToolTipText("Fechar");
		toolBar.add(buttonFechar);

		buttonSair.setToolTipText("Sair");
		toolBar.add(buttonSair);
	}

	public JButton getAjudaBTN() {
		return this.buttonAjuda;
	}

	public JButton getExcluirBTN() {
		return buttonExcluiRegistro;
	}

	public JButton getFecharBTN() {
		return buttonFechar;
	}

	public JButton getHomeBTN() {
		return buttonHome;
	}

	public JButton getRelatorioBTN() {
		return this.buttonImprimiTodosRegistros;
	}

	public JButton getImprimirBTN() {
		return this.buttonImprimiUnicoRegistro;
	}

	public JButton getNovoBTN() {
		return this.buttonNovoFrame;
	}

	public JButton getPesquisarBTN() {
		return this.buttonPesquisaRegistro;
	}

	public JButton getSairBTN() {
		return buttonSair;
	}

	public JButton getSalvarBTN() {
		return this.buttonSalvar;
	}

	public JToolBar getToolBar() {
		return toolBar;
	}
}
