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
import erp.banco.Banco;
import erp.empresa.Empresa;
import erp.main.MainCT;

final class ClienteCT {

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getClientePC().getLabelEmpresa()) {
				MainCT.mostrarFrame(MainCT.getEmpresaFC());
			} else if (event.getSource() == getClientePC().getLabelBanco()) {
				MainCT.mostrarFrame(MainCT.getBancoFC());
			}
			MainCT.getEmpresaFC().reiniciarGUI();
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
				ClienteFAC.deletarRegistro(cliente);
				getClienteFC().limparGUI();
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
			getClienteFC().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getClienteFC().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getClienteFC().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			cliente = new Cliente();
			getClientePC().getNomeGUI().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainCT.mostrarFrame(MainCT.getFrameMain());
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Cliente> clientes = new LinkedList<>();

			try {
				clientes = new LinkedList<>(ClienteFAC.pesquisarRegistro(new Cliente()));
			} catch (Exception e) {
				System.out.println(e);
			}
			ClienteREL clienteREL = new ClienteREL(clientes);
			clienteREL.retornarRelatorio(true);
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
			if (clientes.add(ClienteFAC.getRegistro(cliente))) {
				ClienteREL clienteREL = new ClienteREL(clientes);
				clienteREL.retornarRelatorio(true);
			}

		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			cliente = new Cliente();
			getClienteFC().limparGUI();
			getClientePC().getNomeGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getClientePP().pesquisarRegistroCliente(cliente);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCT.mostrarFrame(getClienteFP());
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

				if ((getClientePC().getNomeGUI().getText()) == null
						|| getClientePC().getNomeGUI().getText().length() == 0) {
					getClientePC().getNomeGUI().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					ClienteFAC.salvar(cliente);
					cliente = new Cliente();
					getClienteFC().limparGUI();
					getClientePC().getNomeGUI().requestFocus();
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
		getClientePC().getNomeGUI().setText(cliente.getNome());
		getClientePC().getDataCadastroGUI().setText(cliente.getDataCadastro());
		getClientePC().getSexoGUI().setSelectedItem(cliente.getSexo());
		getClientePC().getEstadoCivilGUI().setSelectedItem(cliente.getEstadoCivil());
		getClientePC().getEmailGUI().setText(cliente.getEmail());
		getClientePC().getFaxGUI().setText(cliente.getFax());
		getClientePC().getFone1GUI().setText(cliente.getFone1());
		getClientePC().getFone2GUI().setText(cliente.getFone2());
		getClientePC().getCargoGUI().setText(cliente.getCargo());
		getClientePC().getSalarioGUI().setText(cliente.getSalario());
		getClientePC().getBairroGUI().setText(cliente.getBairro());
		getClientePC().getCepGUI().setText(cliente.getCep());
		getClientePC().getCidadeGUI().setText(cliente.getCidade());
		getClientePC().getComplementoGUI().setText(cliente.getComplemento());
		getClientePC().getEstadoGUI().setText(cliente.getEstado());
		getClientePC().getLogradouroGUI().setText(cliente.getLogradouro());
		getClientePC().getPaisGUI().setText(cliente.getPais());
		getClientePC().getCnpjGUI().setText(cliente.getCnpj());
		getClientePC().getCpfGUI().setText(cliente.getCpf());
		getClientePC().getRGNumeroGUI().setText(cliente.getRgNumero());
		getClientePC().getRGOrgaoEmisssorGUI().setText(cliente.getRgOrgaoEmissor());
		getClientePC().getDataNascimentoGUI().setText(cliente.getDataNascimento());
		getClientePC().getIdadeGUI().setText(cliente.getIdade());
		getClientePC().getEmpresaGUI().setSelectedItem(cliente.getEmpresa());
		getClientePC().getStatusGUI().setSelectedItem(cliente.getStatus());
		getClientePC().getDeficienciaGUI().setSelectedItem(cliente.getDeficiencia());
		getClientePC().getEscolaridadeGUI().setSelectedItem(cliente.getEscolaridade());
		getClientePC().getNacionalidadeGUI().setSelectedItem(cliente.getNacionalidade());
		getClientePC().getCorGUI().setSelectedItem(cliente.getCor());
		getClientePC().getBancoGUI().setSelectedItem(cliente.getBanco());
		getClientePC().getNumeroAgenciaBancariaGUI().setText(cliente.getNumeroAgenciaBancaria());
		getClientePC().getNumeroContaBancariaGUI().setText(cliente.getNumeroContaBancaria());
		getClientePC().getClasseEconomicaGUI().setSelectedItem(cliente.getClasseEconomica());
		getClientePC().getReferencia1GUI().setText(cliente.getNomeReferencia1());
		getClientePC().getNomeReferencia2GUI().setText(cliente.getNomeReferencia2());
		getClientePC().getNomeReferencia3GUI().setText(cliente.getNomeReferencia3());
		getClientePC().getRelRef1GUI().setSelectedItem(cliente.getRelacionamentoReferencia1());
		getClientePC().getRelRef2GUI().setSelectedItem(cliente.getRelacionamentoReferencia2());
		getClientePC().getRelRef3GUI().setSelectedItem(cliente.getRelacionamentoReferencia3());
		getClientePC().getFoneReferencia1GUI().setText(cliente.getFoneReferencia1());
		getClientePC().getFoneReferencia2GUI().setText(cliente.getFoneReferencia2());
		getClientePC().getFoneReferencia3GUI().setText(cliente.getFoneReferencia3());
	}

	public void atualizarObjeto() {
		cliente.setNome(getClientePC().getNomeGUI().getText());
		cliente.setDataCadastro(getClientePC().getDataCadastroGUI().getText());
		cliente.setSexo((String) getClientePC().getSexoGUI().getSelectedItem());
		cliente.setEstadoCivil((String) getClientePC().getEstadoCivilGUI().getSelectedItem());
		cliente.setEmail(getClientePC().getEmailGUI().getText());
		cliente.setFax(getClientePC().getFaxGUI().getText());
		cliente.setFone1(getClientePC().getFone1GUI().getText());
		cliente.setFone2(getClientePC().getFone2GUI().getText());
		cliente.setCargo(getClientePC().getCargoGUI().getText());
		cliente.setClasseEconomica((String) getClientePC().getClasseEconomicaGUI().getSelectedItem());
		cliente.setEmpresa((Empresa) getClientePC().getEmpresaGUI().getSelectedItem());
		cliente.setSalario(getClientePC().getSalarioGUI().getText());
		cliente.setBairro(getClientePC().getBairroGUI().getText());
		cliente.setCep(getClientePC().getCepGUI().getText());
		cliente.setCidade(getClientePC().getCidadeGUI().getText());
		cliente.setComplemento(getClientePC().getComplementoGUI().getText());
		cliente.setEstado(getClientePC().getEstadoGUI().getText());
		cliente.setLogradouro(getClientePC().getLogradouroGUI().getText());
		cliente.setPais(getClientePC().getPaisGUI().getText());
		cliente.setCnpj(getClientePC().getCnpjGUI().getText());
		cliente.setCpf(getClientePC().getCpfGUI().getText());
		cliente.setRgNumero(getClientePC().getRGNumeroGUI().getText());
		cliente.setRgOrgaoEmissor(getClientePC().getRGOrgaoEmisssorGUI().getText());
		cliente.setDataNascimento(getClientePC().getDataNascimentoGUI().getText());
		cliente.setIdade(getClientePC().getIdadeGUI().getText());
		cliente.setStatus((String) getClientePC().getStatusGUI().getSelectedItem());
		cliente.setDeficiencia((String) getClientePC().getDeficienciaGUI().getSelectedItem());
		cliente.setEscolaridade((String) getClientePC().getEscolaridadeGUI().getSelectedItem());
		cliente.setNacionalidade((String) getClientePC().getNacionalidadeGUI().getSelectedItem());
		cliente.setCor((String) getClientePC().getCorGUI().getSelectedItem());
		cliente.setBanco((Banco) getClientePC().getBancoGUI().getSelectedItem());
		cliente.setNumeroAgenciaBancaria(getClientePC().getNumeroAgenciaBancariaGUI().getText());
		cliente.setNumeroContaBancaria(getClientePC().getNumeroContaBancariaGUI().getText());
		cliente.setClasseEconomica((String) getClientePC().getClasseEconomicaGUI().getSelectedItem());
		cliente.setNomeReferencia1(getClientePC().getReferencia1GUI().getText());
		cliente.setNomeReferencia2(getClientePC().getNomeReferencia2GUI().getText());
		cliente.setNomeReferencia3(getClientePC().getNomeReferencia3GUI().getText());
		cliente.setRelacionamentoReferencia1((String) getClientePC().getRelRef1GUI().getSelectedItem());
		cliente.setRelacionamentoReferencia2((String) getClientePC().getRelRef2GUI().getSelectedItem());
		cliente.setRelacionamentoReferencia3((String) getClientePC().getRelRef3GUI().getSelectedItem());
		cliente.setFoneReferencia1(getClientePC().getFoneReferencia1GUI().getText());
		cliente.setFoneReferencia2(getClientePC().getFoneReferencia2GUI().getText());
		cliente.setFoneReferencia3(getClientePC().getFoneReferencia3GUI().getText());
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteFC getClienteFC() {
		return MainCT.getClienteFC();
	}

	public ClientePC getClientePC() {
		return MainCT.getClienteFC().getClientePC();
	}

	public ClienteFP getClienteFP() {
		return MainCT.getClienteFP();
	}

	public ClientePP getClientePP() {
		return MainCT.getClienteFP().getClientePP();
	}
}
