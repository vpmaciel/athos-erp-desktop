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
			getClientePc().getGuiNome().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainCont.mostrarFrame(MainCont.getMainFc());
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

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getClientePc().getLabelEmpresa()) {
				MainCont.mostrarFrame(MainCont.getEmpresaFc());
			} else if (event.getSource() == getClientePc().getLabelBanco()) {
				MainCont.mostrarFrame(MainCont.getBancoFc());
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			cliente = new Cliente();
			getClienteFc().limparGui();
			getClientePc().getGuiNome().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getClientePp().pesquisarRegistro(cliente);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getClienteFp());
				getClienteFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getClientePp().pesquisarRegistro(new Cliente());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getClienteFp());
				getClienteFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
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

				if ((getClientePc().getGuiNome().getText()) == null
						|| getClientePc().getGuiNome().getText().length() == 0) {
					getClientePc().getGuiNome().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					ClienteFac.salvarRegistro(cliente);
					cliente = new Cliente();
					getClienteFc().limparGui();
					getClientePc().getGuiNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Throwable throwable = e.getCause().getCause();
				String mensagem = throwable.toString();
				if (mensagem.contains("ConstraintViolationException")) {
					if (mensagem.contains("INDEX_CLIENTE_CPF")) {
						Msg.avisoCampoDuplicado("CPF");
						getClientePc().getGuiCpf().requestFocus();
					} else if (mensagem.contains("INDEX_CLIENTE_CNPJ")) {
						Msg.avisoCampoDuplicado("CNPJ");
						getClientePc().getGuiCnpj().requestFocus();
					} else {
						Msg.avisoCampoDuplicado();
					}
				}
				e.printStackTrace();
				Msg.erroSalvarRegistro();
			}
		}
	}

	private Cliente cliente;

	public void atualizarGui() {
		if (cliente == null) {
			return;
		}
		getClientePc().getGuiNome().setText(cliente.getNome());
		getClientePc().getGuiNumeroAgenciaBancaria().setText(cliente.getNumeroAgenciaBancaria());
		getClientePc().getGuiDataCadastro().setText(cliente.getDataCadastro());
		getClientePc().getGuiSexo().setSelectedItem(cliente.getSexo());
		getClientePc().getGuiEstadoCivil().setSelectedItem(cliente.getEstadoCivil());
		getClientePc().getGuiEmail().setText(cliente.getEmail());
		getClientePc().getGuiFax().setText(cliente.getFax());
		getClientePc().getGuiFone1().setText(cliente.getFone1());
		getClientePc().getGuiFone2().setText(cliente.getFone2());
		getClientePc().getGuiCargo().setText(cliente.getCargo());
		getClientePc().getGuiSalario().setText(cliente.getSalario());
		getClientePc().getGuiBairro().setText(cliente.getBairro());
		getClientePc().getGuiCep().setText(cliente.getCep());
		getClientePc().getGuiCidade().setText(cliente.getCidade());
		getClientePc().getGuiComplemento().setText(cliente.getComplemento());
		getClientePc().getGuiEstado().setText(cliente.getEstado());
		getClientePc().getGuiLogradouro().setText(cliente.getLogradouro());
		getClientePc().getGuiPais().setText(cliente.getPais());
		getClientePc().getGuiCnpj().setText(cliente.getCnpj());
		getClientePc().getGuiCpf().setText(cliente.getCpf());
		getClientePc().getGuiRGNumero().setText(cliente.getRgNumero());
		getClientePc().getGuiRGOrgaoEmisssor().setText(cliente.getRgOrgaoEmissor());
		getClientePc().getGuiDataNascimento().setText(cliente.getDataNascimento());
		getClientePc().getGuiIdade().setText(cliente.getIdade());
		getClientePc().getGuiEmpresa().setSelectedItem(cliente.getEmpresa());
		getClientePc().getGuiStatus().setSelectedItem(cliente.getStatus());
		getClientePc().getGuiDeficiencia().setSelectedItem(cliente.getDeficiencia());
		getClientePc().getGuiEscolaridade().setSelectedItem(cliente.getEscolaridade());
		getClientePc().getGuiNacionalidade().setSelectedItem(cliente.getNacionalidade());
		getClientePc().getGuiCor().setSelectedItem(cliente.getCor());
		getClientePc().getGuiBanco().setSelectedItem(cliente.getBanco());
		getClientePc().getGuiNumeroContaBancaria().setText(cliente.getNumeroContaBancaria());
		getClientePc().getGuiClasseEconomica().setSelectedItem(cliente.getClasseEconomica());
		getClientePc().getGuiReferencia1().setText(cliente.getNomeReferencia1());
		getClientePc().getNomeGuiReferencia2().setText(cliente.getNomeReferencia2());
		getClientePc().getGuiNomeReferencia3().setText(cliente.getNomeReferencia3());
		getClientePc().getGuiRelRef1().setSelectedItem(cliente.getRelacionamentoReferencia1());
		getClientePc().getGuiRelRef2().setSelectedItem(cliente.getRelacionamentoReferencia2());
		getClientePc().getGuiRelRef3().setSelectedItem(cliente.getRelacionamentoReferencia3());
		getClientePc().getGuiFoneReferencia1().setText(cliente.getFoneReferencia1());
		getClientePc().getGuiFoneReferencia2().setText(cliente.getFoneReferencia2());
		getClientePc().getGuiFoneReferencia3().setText(cliente.getFoneReferencia3());
	}

	public void atualizarObjeto() {
		cliente.setNome(getClientePc().getGuiNome().getText());
		cliente.setNumeroAgenciaBancaria(getClientePc().getGuiNumeroAgenciaBancaria().getText());
		cliente.setDataCadastro(getClientePc().getGuiDataCadastro().getText());
		cliente.setSexo((String) getClientePc().getGuiSexo().getSelectedItem());
		cliente.setEstadoCivil((String) getClientePc().getGuiEstadoCivil().getSelectedItem());
		cliente.setEmail(getClientePc().getGuiEmail().getText());
		cliente.setFax(getClientePc().getGuiFax().getText());
		cliente.setFone1(getClientePc().getGuiFone1().getText());
		cliente.setFone2(getClientePc().getGuiFone2().getText());
		cliente.setCargo(getClientePc().getGuiCargo().getText());
		cliente.setClasseEconomica((String) getClientePc().getGuiClasseEconomica().getSelectedItem());
		cliente.setEmpresa((Empresa) getClientePc().getGuiEmpresa().getSelectedItem());
		cliente.setSalario(getClientePc().getGuiSalario().getText());
		cliente.setBairro(getClientePc().getGuiBairro().getText());
		cliente.setCep(getClientePc().getGuiCep().getText());
		cliente.setCidade(getClientePc().getGuiCidade().getText());
		cliente.setComplemento(getClientePc().getGuiComplemento().getText());
		cliente.setEstado(getClientePc().getGuiEstado().getText());
		cliente.setLogradouro(getClientePc().getGuiLogradouro().getText());
		cliente.setPais(getClientePc().getGuiPais().getText());
		cliente.setCnpj(getClientePc().getGuiCnpj().getText());
		cliente.setCpf(getClientePc().getGuiCpf().getText());
		cliente.setRgNumero(getClientePc().getGuiRGNumero().getText());
		cliente.setRgOrgaoEmissor(getClientePc().getGuiRGOrgaoEmisssor().getText());
		cliente.setDataNascimento(getClientePc().getGuiDataNascimento().getText());
		cliente.setIdade(getClientePc().getGuiIdade().getText());
		cliente.setStatus((String) getClientePc().getGuiStatus().getSelectedItem());
		cliente.setDeficiencia((String) getClientePc().getGuiDeficiencia().getSelectedItem());
		cliente.setEscolaridade((String) getClientePc().getGuiEscolaridade().getSelectedItem());
		cliente.setNacionalidade((String) getClientePc().getGuiNacionalidade().getSelectedItem());
		cliente.setCor((String) getClientePc().getGuiCor().getSelectedItem());
		cliente.setBanco((Banco) getClientePc().getGuiBanco().getSelectedItem());
		cliente.setNumeroContaBancaria(getClientePc().getGuiNumeroContaBancaria().getText());
		cliente.setClasseEconomica((String) getClientePc().getGuiClasseEconomica().getSelectedItem());
		cliente.setNomeReferencia1(getClientePc().getGuiReferencia1().getText());
		cliente.setNomeReferencia2(getClientePc().getNomeGuiReferencia2().getText());
		cliente.setNomeReferencia3(getClientePc().getGuiNomeReferencia3().getText());
		cliente.setRelacionamentoReferencia1((String) getClientePc().getGuiRelRef1().getSelectedItem());
		cliente.setRelacionamentoReferencia2((String) getClientePc().getGuiRelRef2().getSelectedItem());
		cliente.setRelacionamentoReferencia3((String) getClientePc().getGuiRelRef3().getSelectedItem());
		cliente.setFoneReferencia1(getClientePc().getGuiFoneReferencia1().getText());
		cliente.setFoneReferencia2(getClientePc().getGuiFoneReferencia2().getText());
		cliente.setFoneReferencia3(getClientePc().getGuiFoneReferencia3().getText());

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

	public ClienteFc getClienteFc() {
		return MainCont.getClienteFc();
	}

	public ClienteFp getClienteFp() {
		return MainCont.getClienteFp();
	}

	public ClientePc getClientePc() {
		return MainCont.getClienteFc().getClientePc();
	}

	public ClientePp getClientePp() {
		return MainCont.getClienteFp().getClientePp();
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
