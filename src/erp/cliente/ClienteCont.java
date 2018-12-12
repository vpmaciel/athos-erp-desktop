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
			getClientePc().getNomeGUI().requestFocus();
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
			getClientePc().getNomeGUI().requestFocus();
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

				if ((getClientePc().getNomeGUI().getText()) == null
						|| getClientePc().getNomeGUI().getText().length() == 0) {
					getClientePc().getNomeGUI().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					ClienteFac.salvar(cliente);
					cliente = new Cliente();
					getClienteFc().limparGui();
					getClientePc().getNomeGUI().requestFocus();
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
		getClientePc().getNomeGUI().setText(cliente.getNome());
		getClientePc().getDataCadastroGUI().setText(cliente.getDataCadastro());
		getClientePc().getSexoGUI().setSelectedItem(cliente.getSexo());
		getClientePc().getEstadoCivilGUI().setSelectedItem(cliente.getEstadoCivil());
		getClientePc().getEmailGUI().setText(cliente.getEmail());
		getClientePc().getFaxGUI().setText(cliente.getFax());
		getClientePc().getFone1GUI().setText(cliente.getFone1());
		getClientePc().getFone2GUI().setText(cliente.getFone2());
		getClientePc().getCargoGUI().setText(cliente.getCargo());
		getClientePc().getSalarioGUI().setText(cliente.getSalario());
		getClientePc().getBairroGUI().setText(cliente.getBairro());
		getClientePc().getCepGUI().setText(cliente.getCep());
		getClientePc().getCidadeGUI().setText(cliente.getCidade());
		getClientePc().getComplementoGUI().setText(cliente.getComplemento());
		getClientePc().getEstadoGUI().setText(cliente.getEstado());
		getClientePc().getLogradouroGUI().setText(cliente.getLogradouro());
		getClientePc().getPaisGUI().setText(cliente.getPais());
		getClientePc().getCnpjGUI().setText(cliente.getCnpj());
		getClientePc().getCpfGUI().setText(cliente.getCpf());
		getClientePc().getRGNumeroGUI().setText(cliente.getRgNumero());
		getClientePc().getRGOrgaoEmisssorGUI().setText(cliente.getRgOrgaoEmissor());
		getClientePc().getDataNascimentoGUI().setText(cliente.getDataNascimento());
		getClientePc().getIdadeGUI().setText(cliente.getIdade());
		getClientePc().getEmpresaGUI().setSelectedItem(cliente.getEmpresa());
		getClientePc().getStatusGUI().setSelectedItem(cliente.getStatus());
		getClientePc().getDeficienciaGUI().setSelectedItem(cliente.getDeficiencia());
		getClientePc().getEscolaridadeGUI().setSelectedItem(cliente.getEscolaridade());
		getClientePc().getNacionalidadeGUI().setSelectedItem(cliente.getNacionalidade());
		getClientePc().getCorGUI().setSelectedItem(cliente.getCor());
		getClientePc().getBancoGUI().setSelectedItem(cliente.getBanco());
		getClientePc().getNumeroAgenciaBancariaGUI().setText(cliente.getNumeroAgenciaBancaria());
		getClientePc().getNumeroContaBancariaGUI().setText(cliente.getNumeroContaBancaria());
		getClientePc().getClasseEconomicaGUI().setSelectedItem(cliente.getClasseEconomica());
		getClientePc().getReferencia1GUI().setText(cliente.getNomeReferencia1());
		getClientePc().getNomeReferencia2GUI().setText(cliente.getNomeReferencia2());
		getClientePc().getNomeReferencia3GUI().setText(cliente.getNomeReferencia3());
		getClientePc().getRelRef1GUI().setSelectedItem(cliente.getRelacionamentoReferencia1());
		getClientePc().getRelRef2GUI().setSelectedItem(cliente.getRelacionamentoReferencia2());
		getClientePc().getRelRef3GUI().setSelectedItem(cliente.getRelacionamentoReferencia3());
		getClientePc().getFoneReferencia1GUI().setText(cliente.getFoneReferencia1());
		getClientePc().getFoneReferencia2GUI().setText(cliente.getFoneReferencia2());
		getClientePc().getFoneReferencia3GUI().setText(cliente.getFoneReferencia3());
	}

	public void atualizarObjeto() {
		cliente.setNome(getClientePc().getNomeGUI().getText());
		cliente.setDataCadastro(getClientePc().getDataCadastroGUI().getText());
		cliente.setSexo((String) getClientePc().getSexoGUI().getSelectedItem());
		cliente.setEstadoCivil((String) getClientePc().getEstadoCivilGUI().getSelectedItem());
		cliente.setEmail(getClientePc().getEmailGUI().getText());
		cliente.setFax(getClientePc().getFaxGUI().getText());
		cliente.setFone1(getClientePc().getFone1GUI().getText());
		cliente.setFone2(getClientePc().getFone2GUI().getText());
		cliente.setCargo(getClientePc().getCargoGUI().getText());
		cliente.setClasseEconomica((String) getClientePc().getClasseEconomicaGUI().getSelectedItem());
		cliente.setEmpresa((Empresa) getClientePc().getEmpresaGUI().getSelectedItem());
		cliente.setSalario(getClientePc().getSalarioGUI().getText());
		cliente.setBairro(getClientePc().getBairroGUI().getText());
		cliente.setCep(getClientePc().getCepGUI().getText());
		cliente.setCidade(getClientePc().getCidadeGUI().getText());
		cliente.setComplemento(getClientePc().getComplementoGUI().getText());
		cliente.setEstado(getClientePc().getEstadoGUI().getText());
		cliente.setLogradouro(getClientePc().getLogradouroGUI().getText());
		cliente.setPais(getClientePc().getPaisGUI().getText());
		cliente.setCnpj(getClientePc().getCnpjGUI().getText());
		cliente.setCpf(getClientePc().getCpfGUI().getText());
		cliente.setRgNumero(getClientePc().getRGNumeroGUI().getText());
		cliente.setRgOrgaoEmissor(getClientePc().getRGOrgaoEmisssorGUI().getText());
		cliente.setDataNascimento(getClientePc().getDataNascimentoGUI().getText());
		cliente.setIdade(getClientePc().getIdadeGUI().getText());
		cliente.setStatus((String) getClientePc().getStatusGUI().getSelectedItem());
		cliente.setDeficiencia((String) getClientePc().getDeficienciaGUI().getSelectedItem());
		cliente.setEscolaridade((String) getClientePc().getEscolaridadeGUI().getSelectedItem());
		cliente.setNacionalidade((String) getClientePc().getNacionalidadeGUI().getSelectedItem());
		cliente.setCor((String) getClientePc().getCorGUI().getSelectedItem());
		cliente.setBanco((Banco) getClientePc().getBancoGUI().getSelectedItem());
		cliente.setNumeroAgenciaBancaria(getClientePc().getNumeroAgenciaBancariaGUI().getText());
		cliente.setNumeroContaBancaria(getClientePc().getNumeroContaBancariaGUI().getText());
		cliente.setClasseEconomica((String) getClientePc().getClasseEconomicaGUI().getSelectedItem());
		cliente.setNomeReferencia1(getClientePc().getReferencia1GUI().getText());
		cliente.setNomeReferencia2(getClientePc().getNomeReferencia2GUI().getText());
		cliente.setNomeReferencia3(getClientePc().getNomeReferencia3GUI().getText());
		cliente.setRelacionamentoReferencia1((String) getClientePc().getRelRef1GUI().getSelectedItem());
		cliente.setRelacionamentoReferencia2((String) getClientePc().getRelRef2GUI().getSelectedItem());
		cliente.setRelacionamentoReferencia3((String) getClientePc().getRelRef3GUI().getSelectedItem());
		cliente.setFoneReferencia1(getClientePc().getFoneReferencia1GUI().getText());
		cliente.setFoneReferencia2(getClientePc().getFoneReferencia2GUI().getText());
		cliente.setFoneReferencia3(getClientePc().getFoneReferencia3GUI().getText());
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
