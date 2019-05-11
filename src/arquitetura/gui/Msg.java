package arquitetura.gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import erp.main.MainCont;
import erp.main.MainFc;
import erp.main.SobrePc;

public final class Msg {

	private static Object[] botoesSimNao = new Object[] { "Sim", "Nao" };

	public static final void ajuda() {
		JOptionPane.showMessageDialog(MainFc.getFrameMain(), new SobrePc(), "Sobre o Sistema",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static final void avisoCampoDiferente(JLabel label1, JLabel label2) {
		JOptionPane.showMessageDialog(null, label1.getText() + " e " + label2.getText() + " são diferentes !",
				"Informação", JOptionPane.INFORMATION_MESSAGE);
	}

	public static final void avisoCampoDuplicado(String campo, String valor) {
		JOptionPane.showMessageDialog(null, campo + " : " + valor + "\nJá está cadastrado em outro registro !",
				"Informação", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static final void avisoCampoDuplicado(String campo) {
		JOptionPane.showMessageDialog(null, campo + " : " + "\nJá está cadastrado em outro registro !",
				"Informação", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static final void avisoCampoDuplicado() {
		JOptionPane.showMessageDialog(null, "Já está cadastrado em outro registro !",
				"Informação", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	

	public static final void avisoCampoInvalido(Object campo) {
		JOptionPane.showMessageDialog(null, campo.toString().toUpperCase() + " inválido !", "Informação",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static final void avisoCampoObrigatorio(Object campo) {
		JOptionPane.showMessageDialog(null, "Voce precisa preencher o campo " + campo.toString().toUpperCase(),
				"Informação", JOptionPane.INFORMATION_MESSAGE);
	}

	public static final void avisoCartaoCreditoInvalido() {
		JOptionPane.showMessageDialog(null, "Cartão de Crédito inválido !", "Informação",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void avisoContactarEmpresa() {
		JOptionPane.showMessageDialog(null, "Entre em contato com o desenvolvedor do sistema !", "Informação",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static final void avisoFecharSistema() {
		JOptionPane.showMessageDialog(MainCont.getLoginFc().getLoginPc(), "O sistema será fechado !", "Erro",
				JOptionPane.ERROR_MESSAGE);
	}

	public static final void avisoImprimiRegistroNaoCadastrado() {
		JOptionPane.showMessageDialog(null, "Registro não cadastrado no sistema !", "Informação",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static final void avisoPesquisaRegistro() {
		JOptionPane.showMessageDialog(null, "PesquisaRegistrondo Registro !", "Informação",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void avisoRegistroEncontrado(Long totalPesquisaRegistro) {
		if (totalPesquisaRegistro > 0) {
			JOptionPane.showMessageDialog(null, "Registros encontrados: " + totalPesquisaRegistro, "Informação",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Registro não encontrado !", "Informação", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static final void avisoUsuarioInvalido() {
		JOptionPane.showMessageDialog(null, "Usuário inválido !", "Informação", JOptionPane.ERROR_MESSAGE);
	}

	public static final void avisoUsuarioNaoExcluiRegistro() {
		JOptionPane.showMessageDialog(null, "Voce não pode excluir este usuário !", "Informação",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static final void avisoUsuarioNaoLogado() {
		JOptionPane.showMessageDialog(null, "Usuário não está Logado !", "Informação", JOptionPane.INFORMATION_MESSAGE);
	}

	public static final int confirmarExcluiRegistro() {
		return JOptionPane.showOptionDialog(null, "Excluir o registro ?", "Informação", JOptionPane.INFORMATION_MESSAGE,
				JOptionPane.YES_NO_OPTION, null, botoesSimNao, botoesSimNao[JOptionPane.INFORMATION_MESSAGE]);
	}

	public static final int confirmarFecharJanela() {
		return JOptionPane.showOptionDialog(null, "Deseja fechar a janela ?", "Informação",
				JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, null, botoesSimNao,
				botoesSimNao[JOptionPane.INFORMATION_MESSAGE]);
	}

	public static final int confirmarSairDoSistema() {
		return JOptionPane.showOptionDialog(null, "Sair do Sistema ?", "Informação", JOptionPane.INFORMATION_MESSAGE,
				JOptionPane.YES_NO_OPTION, null, botoesSimNao, botoesSimNao[JOptionPane.YES_NO_OPTION]);
	}

	public static final int confirmarSalvarRegistro() {
		return JOptionPane.showOptionDialog(null, "Salvar o registro ?", "Informação", JOptionPane.INFORMATION_MESSAGE,
				JOptionPane.YES_NO_OPTION, null, botoesSimNao, botoesSimNao[JOptionPane.INFORMATION_MESSAGE]);
	}

	public static void erroCampoInvalido() {
		JOptionPane.showMessageDialog(null, "Digitou tecla não permitida para este campo !", "Erro",
				JOptionPane.ERROR_MESSAGE);
	}

	public static final void erroCampoNumerico() {
		JOptionPane.showMessageDialog(null, "Voce deve digitar um número !", "Informação", JOptionPane.ERROR_MESSAGE);
	}

	public static final void erroConectarDataBase() {
		JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados !", "Erro",
				JOptionPane.ERROR_MESSAGE);
	}

	public static final void erroConsultarRegistro() {
		JOptionPane.showMessageDialog(null, "Não foi possível realizar a Consulta", "Erro", JOptionPane.ERROR_MESSAGE);
	}

	public static final void erroCriarPasta() {
		JOptionPane.showMessageDialog(null, "Não foi possível criar pasta !", "Erro", JOptionPane.ERROR_MESSAGE);
	}

	public static final void erroDesconectarDataBase() {
		JOptionPane.showMessageDialog(null, "Não foi possível desconectar ao banco de dados !", "Erro",
				JOptionPane.ERROR_MESSAGE);
	}

	public static final void erroExcluiRegistro() {
		JOptionPane.showMessageDialog(null, "Não foi possível excluir o Registro", "Erro", JOptionPane.ERROR_MESSAGE);
	}

	public static final void erroGeral() {
		JOptionPane.showMessageDialog(null, "Foi encontrado um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
	}

	public static final void erroInserirRegistro() {
		JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro !", "Erro", JOptionPane.ERROR_MESSAGE);
	}

	public static final void erroLookAndFeel() {
		JOptionPane.showMessageDialog(null, "Não foi possível utilizar Look and Feel !", "Erro",
				JOptionPane.ERROR_MESSAGE);
	}

	public static final void erroPesquisarRegistro() {
		JOptionPane.showMessageDialog(null, "Não foi possível pesquisar registro !", "Erro", JOptionPane.ERROR_MESSAGE);
	}

	public static final void erroTeclaNaoPermitida() {
		JOptionPane.showMessageDialog(null, "Voce digitou uma tecla não permitida para este campo !", "Informação",
				JOptionPane.ERROR_MESSAGE);
	}

	public static final void erroValorInteiro() {
		JOptionPane.showMessageDialog(null, "Digite um número de -2147483648 até 2147483647", "Erro",
				JOptionPane.ERROR_MESSAGE);
	}

	public static final void erroValorInteiroSemSinal() {
		JOptionPane.showMessageDialog(null, "Digite um número de 0 até 2147483647", "Erro", JOptionPane.ERROR_MESSAGE);
	}

	public static final void erroValorInvalido() {
		JOptionPane.showMessageDialog(null, "Valor inválido !", "Erro", JOptionPane.ERROR_MESSAGE);
	}

	public static final void sucessoAtualizarRegistro() {
		JOptionPane.showMessageDialog(null, "Registro atualizado com sucesso !", "Informação",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static final void sucessoConectarDataBase() {
		JOptionPane.showMessageDialog(null, "Conexão efetuada com sucesso !", "Informação",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static final void sucessoConsultarRegistro() {
		JOptionPane.showMessageDialog(null, "Consulta realizada com sucesso !", "Informação",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static final void sucessoDesconectarDataBase() {
		JOptionPane.showMessageDialog(null, "Desconexão efetuada com sucesso !", "Informação",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static final void sucessoExcluiRegistro() {
		JOptionPane.showMessageDialog(null, "Registro excluído com sucesso !", "Informação",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static final void sucessoInserirRegistro() {
		JOptionPane.showMessageDialog(null, "Registro inserido com sucesso !", "Informação",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static final void sucessoSalvarRegistro() {
		JOptionPane.showMessageDialog(null, "Registro salvo com sucesso !", "Informação",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
