package erp.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import arquitetura.validacao.Mascara;
import erp.banco.Banco;
import erp.empresa.Empresa;
import erp.main.MainCont;

final class ClienteCont {

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getClientePc().getLabelEmpresa()) {
				MainCont.mostrarFrame(MainCont.getEmpresaFc());
			} else if (event.getSource() == getClientePc().getLabelBanco()) {
				MainCont.mostrarFrame(MainCont.getBancoFc());
			}
			MainCont.getEmpresaFc().reiniciarGui();
		}
	}

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (cliente == null || cliente.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				ClienteFac.deletarRegistro(cliente);
				getClienteFc().limparGui();
				cliente = new Cliente();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getClienteFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getClienteFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getClienteFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			cliente = new Cliente();
			getClientePc().getNomeGui().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainCont.mostrarFrame(MainCont.getMainFc());
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Cliente> clientes = new LinkedList<>();

			try {
				clientes = new LinkedList<>(ClienteFac.pesquisarRegistro(new Cliente()));
			} catch (Exception e) {
				System.out.println(e);
			}
			ClienteRel clienteRel = new ClienteRel(clientes);
			clienteRel.retornarRelatorio(true);
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Cliente> clientes = new LinkedList<>();

			if (cliente.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (clientes.add(ClienteFac.getRegistro(cliente))) {
				ClienteRel clienteRel = new ClienteRel(clientes);
				clienteRel.retornarRelatorio(true);
			}

		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			cliente = new Cliente();
			getClienteFc().limparGui();
			getClientePc().getNomeGui().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getClientePp().pesquisarRegistroCliente(cliente);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getClienteFp());
			}
		}
	}

	public class SaidaSistema implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (Msg.confirmarSairDoSistema() == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

	public class Salva implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {

				int mensagem = Msg.confirmarSalvarRegistro();
				if (mensagem != JOptionPane.YES_OPTION) {
					return;
				}

				if ((getClientePc().getNomeGui().getText()) == null
						|| getClientePc().getNomeGui().getText().length() == 0) {
					getClientePc().getNomeGui().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					ClienteFac.salvar(cliente);
					cliente = new Cliente();
					getClienteFc().limparGui();
					getClientePc().getNomeGui().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private Cliente cliente;

	public void atualizarGui() {
		if (cliente == null) {
			return;
		}
		getClientePc().getNomeGui().setText(cliente.getNome());
		getClientePc().getDataCadastroGui().setText(cliente.getDataCadastro());
		getClientePc().getSexoGui().setSelectedItem(cliente.getSexo());
		getClientePc().getEstadoCivilGui().setSelectedItem(cliente.getEstadoCivil());
		getClientePc().getEmailGui().setText(cliente.getEmail());
		getClientePc().getFaxGui().setText(cliente.getFax());
		getClientePc().getFone1Gui().setText(cliente.getFone1());
		getClientePc().getFone2Gui().setText(cliente.getFone2());
		getClientePc().getCargoGui().setText(cliente.getCargo());
		getClientePc().getSalarioGui().setText(cliente.getSalario());
		getClientePc().getBairroGui().setText(cliente.getBairro());
		getClientePc().getCepGui().setText(cliente.getCep());
		getClientePc().getCidadeGui().setText(cliente.getCidade());
		getClientePc().getComplementoGui().setText(cliente.getComplemento());
		getClientePc().getEstadoGui().setText(cliente.getEstado());
		getClientePc().getLogradouroGui().setText(cliente.getLogradouro());
		getClientePc().getPaisGui().setText(cliente.getPais());
		getClientePc().getCnpjGui().setText(cliente.getCnpj());
		getClientePc().getCpfGui().setText(cliente.getCpf());
		getClientePc().getRGNumeroGui().setText(cliente.getRgNumero());
		getClientePc().getRGOrgaoEmisssorGui().setText(cliente.getRgOrgaoEmissor());
		getClientePc().getDataNascimentoGui().setText(cliente.getDataNascimento());
		getClientePc().getIdadeGui().setText(cliente.getIdade());
		getClientePc().getEmpresaGui().setSelectedItem(cliente.getEmpresa());
		getClientePc().getStatusGui().setSelectedItem(cliente.getStatus());
		getClientePc().getDeficienciaGui().setSelectedItem(cliente.getDeficiencia());
		getClientePc().getEscolaridadeGui().setSelectedItem(cliente.getEscolaridade());
		getClientePc().getNacionalidadeGui().setSelectedItem(cliente.getNacionalidade());
		getClientePc().getCorGui().setSelectedItem(cliente.getCor());
		getClientePc().getBancoGui().setSelectedItem(cliente.getBanco());
		getClientePc().getNumeroAgenciaBancariaGui().setText(cliente.getNumeroAgenciaBancaria());
		getClientePc().getNumeroContaBancariaGui().setText(cliente.getNumeroContaBancaria());
		getClientePc().getClasseEconomicaGui().setSelectedItem(cliente.getClasseEconomica());
		getClientePc().getReferencia1Gui().setText(cliente.getNomeReferencia1());
		getClientePc().getNomeReferencia2Gui().setText(cliente.getNomeReferencia2());
		getClientePc().getNomeReferencia3Gui().setText(cliente.getNomeReferencia3());
		getClientePc().getRelRef1Gui().setSelectedItem(cliente.getRelacionamentoReferencia1());
		getClientePc().getRelRef2Gui().setSelectedItem(cliente.getRelacionamentoReferencia2());
		getClientePc().getRelRef3Gui().setSelectedItem(cliente.getRelacionamentoReferencia3());
		getClientePc().getFoneReferencia1Gui().setText(cliente.getFoneReferencia1());
		getClientePc().getFoneReferencia2Gui().setText(cliente.getFoneReferencia2());
		getClientePc().getFoneReferencia3Gui().setText(cliente.getFoneReferencia3());
	}

	public void atualizarObjeto() {
		cliente.setNome(getClientePc().getNomeGui().getText());
		cliente.setDataCadastro(getClientePc().getDataCadastroGui().getText());
		cliente.setSexo((String) getClientePc().getSexoGui().getSelectedItem());
		cliente.setEstadoCivil((String) getClientePc().getEstadoCivilGui().getSelectedItem());
		cliente.setEmail(getClientePc().getEmailGui().getText());
		cliente.setFax(getClientePc().getFaxGui().getText());
		cliente.setFone1(getClientePc().getFone1Gui().getText());
		cliente.setFone2(getClientePc().getFone2Gui().getText());
		cliente.setCargo(getClientePc().getCargoGui().getText());
		cliente.setClasseEconomica((String) getClientePc().getClasseEconomicaGui().getSelectedItem());
		cliente.setEmpresa((Empresa) getClientePc().getEmpresaGui().getSelectedItem());
		cliente.setSalario(getClientePc().getSalarioGui().getText());
		cliente.setBairro(getClientePc().getBairroGui().getText());
		cliente.setCep(getClientePc().getCepGui().getText());
		cliente.setCidade(getClientePc().getCidadeGui().getText());
		cliente.setComplemento(getClientePc().getComplementoGui().getText());
		cliente.setEstado(getClientePc().getEstadoGui().getText());
		cliente.setLogradouro(getClientePc().getLogradouroGui().getText());
		cliente.setPais(getClientePc().getPaisGui().getText());
		cliente.setCnpj(getClientePc().getCnpjGui().getText());
		cliente.setCpf(getClientePc().getCpfGui().getText());
		cliente.setRgNumero(getClientePc().getRGNumeroGui().getText());
		cliente.setRgOrgaoEmissor(getClientePc().getRGOrgaoEmisssorGui().getText());
		cliente.setDataNascimento(getClientePc().getDataNascimentoGui().getText());
		cliente.setIdade(getClientePc().getIdadeGui().getText());
		cliente.setStatus((String) getClientePc().getStatusGui().getSelectedItem());
		cliente.setDeficiencia((String) getClientePc().getDeficienciaGui().getSelectedItem());
		cliente.setEscolaridade((String) getClientePc().getEscolaridadeGui().getSelectedItem());
		cliente.setNacionalidade((String) getClientePc().getNacionalidadeGui().getSelectedItem());
		cliente.setCor((String) getClientePc().getCorGui().getSelectedItem());
		cliente.setBanco((Banco) getClientePc().getBancoGui().getSelectedItem());
		cliente.setNumeroAgenciaBancaria(getClientePc().getNumeroAgenciaBancariaGui().getText());
		cliente.setNumeroContaBancaria(getClientePc().getNumeroContaBancariaGui().getText());
		cliente.setClasseEconomica((String) getClientePc().getClasseEconomicaGui().getSelectedItem());
		cliente.setNomeReferencia1(getClientePc().getReferencia1Gui().getText());
		cliente.setNomeReferencia2(getClientePc().getNomeReferencia2Gui().getText());
		cliente.setNomeReferencia3(getClientePc().getNomeReferencia3Gui().getText());
		cliente.setRelacionamentoReferencia1((String) getClientePc().getRelRef1Gui().getSelectedItem());
		cliente.setRelacionamentoReferencia2((String) getClientePc().getRelRef2Gui().getSelectedItem());
		cliente.setRelacionamentoReferencia3((String) getClientePc().getRelRef3Gui().getSelectedItem());
		cliente.setFoneReferencia1(getClientePc().getFoneReferencia1Gui().getText());
		cliente.setFoneReferencia2(getClientePc().getFoneReferencia2Gui().getText());
		cliente.setFoneReferencia3(getClientePc().getFoneReferencia3Gui().getText());

		if (cliente.getCnpj().equals(Mascara.getCnpjVazio())) {
			cliente.setCnpj(null);
		}

		if (cliente.getCpf().equals(Mascara.getCpfVazio())) {
			cliente.setCpf(null);
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteFc getClienteFc() {
		return MainCont.getClienteFc();
	}

	public ClientePc getClientePc() {
		return MainCont.getClienteFc().getClientePc();
	}

	public ClienteFp getClienteFp() {
		return MainCont.getClienteFp();
	}

	public ClientePp getClientePp() {
		return MainCont.getClienteFp().getClientePp();
	}
}
