package erp.aop.gui.registro;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;

import erp.aop.gui.Imagem;

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

		buttonHome.setToolTipText("Janela Principal");
		toolBar.add(buttonHome);

		buttonNovoFrame.setToolTipText("Novo Registro");
		toolBar.add(buttonNovoFrame);

		buttonExcluiRegistro.setToolTipText("Excluir Registro");
		toolBar.add(buttonExcluiRegistro);

		buttonSalvar.setToolTipText("Salvar Registro");
		toolBar.add(buttonSalvar);

		buttonPesquisaRegistro.setToolTipText("Pesquisar Registro");
		toolBar.add(buttonPesquisaRegistro);

		buttonImprimiUnicoRegistro.setToolTipText("Imprimir Registro");
		toolBar.add(buttonImprimiUnicoRegistro);

		buttonImprimiTodosRegistros.setToolTipText("Imprimir Relatório");
		toolBar.add(buttonImprimiTodosRegistros);

		buttonAjuda.setToolTipText("Ajuda");
		toolBar.add(buttonAjuda);

		buttonFechar.setToolTipText("Fechar Janela");
		toolBar.add(buttonFechar);

		buttonSair.setToolTipText("Sair do Sistema");
		toolBar.add(buttonSair);
	}

	public JButton getButtonAjuda() {
		return this.buttonAjuda;
	}

	public JButton getButtonExcluiRegistro() {
		return buttonExcluiRegistro;
	}

	public JButton getButtonFechar() {
		return buttonFechar;
	}

	public JButton getButtonHome() {
		return buttonHome;
	}

	public JButton getButtonImprimiTodosRegistros() {
		return this.buttonImprimiTodosRegistros;
	}

	public JButton getButtonImprimiUnicoRegistro() {
		return this.buttonImprimiUnicoRegistro;
	}

	public JButton getButtonNovoFrame() {
		return this.buttonNovoFrame;
	}

	public JButton getButtonPesquisaRegistro() {
		return this.buttonPesquisaRegistro;
	}

	public JButton getButtonSair() {
		return buttonSair;
	}

	public JButton getButtonSalvar() {
		return this.buttonSalvar;
	}

	public JToolBar getToolBar() {
		return toolBar;
	}
}

