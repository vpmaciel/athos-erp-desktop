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

import erp.aop.gui.Msg;
import erp.banco.Banco;
import erp.empresa.Empresa;
import erp.main.MainGerenteEventos;

final class ClienteGerenteEventos {

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getPanelCadastroCliente().getLabelEmpresa()) {
				MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroEmpresa());
			} else if (event.getSource() == getPanelCadastroCliente().getLabelBanco()) {
				MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroBanco());
			}
			MainGerenteEventos.getFrameCadastroEmpresa().reiniciarBox();
		}
	}

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

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
				ClienteDaoFacade.deletarRegistro(cliente);
				getFrameCadastroCliente().limparGui();
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
			getFrameCadastroCliente().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroCliente().reiniciarBox();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroCliente().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			cliente = new Cliente();
			getPanelCadastroCliente().getTextFieldNome().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameMain());
		}
	}

	public class ImprimiTodosRegistros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Cliente> clientes = new LinkedList<>();

			try {
				clientes = new LinkedList<>(ClienteDaoFacade.pesquisarRegistro(new Cliente()));
			} catch (Exception e) {
				System.out.println(e);
			}
			ClienteRelatorio clienteRelatorio = new ClienteRelatorio(clientes);
			clienteRelatorio.retornarRelatorio(true);
		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Cliente> clientes = new LinkedList<>();

			if (cliente.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (clientes.add(ClienteDaoFacade.getRegistro(cliente))) {
				ClienteRelatorio clienteRelatorio = new ClienteRelatorio(clientes);
				clienteRelatorio.retornarRelatorio(true);
			}

		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			cliente = new Cliente();
			getFrameCadastroCliente().limparGui();
			getPanelCadastroCliente().getTextFieldNome().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getPanelPesquisaCliente().pesquisarRegistroCliente(cliente);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainGerenteEventos.mostrarFrame(getFramePesquisaCliente());
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

				if ((getPanelCadastroCliente().getTextFieldNome().getText()) == null || 
						getPanelCadastroCliente().getTextFieldNome().getText().length() == 0) {
					getPanelCadastroCliente().getTextFieldNome().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					ClienteDaoFacade.salvar(cliente);
					cliente = new Cliente();
					getFrameCadastroCliente().limparGui();
					getPanelCadastroCliente().getTextFieldNome().requestFocus();
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
		getPanelCadastroCliente().getTextFieldNome().setText(cliente.getNome());
		getPanelCadastroCliente().getTextFieldDataCadastro().setText(cliente.getDataCadastro());
		getPanelCadastroCliente().getBoxSexo().setSelectedItem(cliente.getSexo());
		getPanelCadastroCliente().getBoxEstadoCivil().setSelectedItem(cliente.getEstadoCivil());
		getPanelCadastroCliente().getTextFieldEmail().setText(cliente.getEmail());
		getPanelCadastroCliente().getTextFieldFax().setText(cliente.getFax());
		getPanelCadastroCliente().getTextFieldFone1().setText(cliente.getFone1());
		getPanelCadastroCliente().getTextFieldFone2().setText(cliente.getFone2());
		getPanelCadastroCliente().getTextFieldCargo().setText(cliente.getCargo());
		getPanelCadastroCliente().getBoxEmpresa().setSelectedItem(cliente.getEmpresa());
		getPanelCadastroCliente().getTextFieldSalario().setText(cliente.getSalario());
		getPanelCadastroCliente().getTextFieldBairro().setText(cliente.getBairro());
		getPanelCadastroCliente().getTextFieldCep().setText(cliente.getCep());
		getPanelCadastroCliente().getTextFieldCidade().setText(cliente.getCidade());
		getPanelCadastroCliente().getTextFieldComplemento().setText(cliente.getComplemento());
		getPanelCadastroCliente().getTextFieldEstado().setText(cliente.getEstado());
		getPanelCadastroCliente().getTextFieldLogradouro().setText(cliente.getLogradouro());
		getPanelCadastroCliente().getTextFieldPais().setText(cliente.getPais());
		getPanelCadastroCliente().getTextFieldCNPJ().setText(cliente.getCnpj());
		getPanelCadastroCliente().getTextFieldCPF().setText(cliente.getCpfNumero());
		getPanelCadastroCliente().getTextFieldRGNumero().setText(cliente.getRgNumero());
		getPanelCadastroCliente().getTextFieldRGOrgaoEmisssor().setText(cliente.getRgOrgaoEmissor());
		getPanelCadastroCliente().getTextFieldDataNascimento().setText(cliente.getDataNascimento());
		getPanelCadastroCliente().getTextFieldIdade().setText(cliente.getIdade());
		getPanelCadastroCliente().getBoxEmpresa().setSelectedItem(cliente.getEmpresa());
		getPanelCadastroCliente().getBoxStatus().setSelectedItem(cliente.getStatus());
		getPanelCadastroCliente().getBoxDeficiencia().setSelectedItem(cliente.getDeficiencia());
		getPanelCadastroCliente().getBoxEscolaridade().setSelectedItem(cliente.getEscolaridade());
		getPanelCadastroCliente().getBoxNacionalidade().setSelectedItem(cliente.getNacionalidade());
		getPanelCadastroCliente().getBoxCor().setSelectedItem(cliente.getCor());
		getPanelCadastroCliente().getBoxBanco().setSelectedItem(cliente.getBanco());
		getPanelCadastroCliente().getTextFieldNumeroAgenciaBancaria().setText(cliente.getNumeroAgenciaBancaria());
		getPanelCadastroCliente().getTextFieldNumeroContaBancaria().setText(cliente.getNumeroContaBancaria());
		getPanelCadastroCliente().getBoxClasseEconomica().setSelectedItem(cliente.getClasseEconomica());
		getPanelCadastroCliente().getTextFieldNomeReferencia1().setText(cliente.getNomeReferencia1());
		getPanelCadastroCliente().getTextFieldNomeReferencia2().setText(cliente.getNomeReferencia2());
		getPanelCadastroCliente().getTextFieldNomeReferencia3().setText(cliente.getNomeReferencia3());
		getPanelCadastroCliente().getBoxRelacionamentoReferencia1().setSelectedItem(cliente.getRelacionamentoReferencia1());
		getPanelCadastroCliente().getBoxRelacionamentoReferencia2().setSelectedItem(cliente.getRelacionamentoReferencia2());
		getPanelCadastroCliente().getBoxRelacionamentoReferencia3().setSelectedItem(cliente.getRelacionamentoReferencia3());
		getPanelCadastroCliente().getTextFieldFoneReferencia1().setText(cliente.getFoneReferencia1());
		getPanelCadastroCliente().getTextFieldFoneReferencia2().setText(cliente.getFoneReferencia2());
		getPanelCadastroCliente().getTextFieldFoneReferencia3().setText(cliente.getFoneReferencia3());
	}

	public void atualizarObjeto() {
		cliente.setNome(getPanelCadastroCliente().getTextFieldNome().getText());
		cliente.setDataCadastro(getPanelCadastroCliente().getTextFieldDataCadastro().getText());
		cliente.setSexo((String) getPanelCadastroCliente().getBoxSexo().getSelectedItem());
		cliente.setEstadoCivil((String) getPanelCadastroCliente().getBoxEstadoCivil().getSelectedItem());
		cliente.setEmail(getPanelCadastroCliente().getTextFieldEmail().getText());
		cliente.setFax(getPanelCadastroCliente().getTextFieldFax().getText());
		cliente.setFone1(getPanelCadastroCliente().getTextFieldFone1().getText());
		cliente.setFone2(getPanelCadastroCliente().getTextFieldFone2().getText());
		cliente.setCargo(getPanelCadastroCliente().getTextFieldCargo().getText());
		cliente.setClasseEconomica((String) getPanelCadastroCliente().getBoxClasseEconomica().getSelectedItem());
		cliente.setEmpresa((Empresa) getPanelCadastroCliente().getBoxEmpresa().getSelectedItem());
		cliente.setSalario(getPanelCadastroCliente().getTextFieldSalario().getText());
		cliente.setBairro(getPanelCadastroCliente().getTextFieldBairro().getText());
		cliente.setCep(getPanelCadastroCliente().getTextFieldCep().getText());
		cliente.setCidade(getPanelCadastroCliente().getTextFieldCidade().getText());
		cliente.setComplemento(getPanelCadastroCliente().getTextFieldComplemento().getText());
		cliente.setEstado(getPanelCadastroCliente().getTextFieldEstado().getText());
		cliente.setLogradouro(getPanelCadastroCliente().getTextFieldLogradouro().getText());
		cliente.setPais(getPanelCadastroCliente().getTextFieldPais().getText());
		cliente.setCnpj(getPanelCadastroCliente().getTextFieldCNPJ().getText());
		cliente.setCpfNumero(getPanelCadastroCliente().getTextFieldCPF().getText());
		cliente.setRgNumero(getPanelCadastroCliente().getTextFieldRGNumero().getText());
		cliente.setRgOrgaoEmissor(getPanelCadastroCliente().getTextFieldRGOrgaoEmisssor().getText());
		cliente.setDataNascimento(getPanelCadastroCliente().getTextFieldDataNascimento().getText());
		cliente.setIdade(getPanelCadastroCliente().getTextFieldIdade().getText());
		cliente.setStatus((String) getPanelCadastroCliente().getBoxStatus().getSelectedItem());
		cliente.setDeficiencia((String) getPanelCadastroCliente().getBoxDeficiencia().getSelectedItem());
		cliente.setEscolaridade((String) getPanelCadastroCliente().getBoxEscolaridade().getSelectedItem());
		cliente.setNacionalidade((String) getPanelCadastroCliente().getBoxNacionalidade().getSelectedItem());
		cliente.setCor((String) getPanelCadastroCliente().getBoxCor().getSelectedItem());
		cliente.setBanco((Banco) getPanelCadastroCliente().getBoxBanco().getSelectedItem());
		cliente.setNumeroAgenciaBancaria(getPanelCadastroCliente().getTextFieldNumeroAgenciaBancaria().getText());
		cliente.setNumeroContaBancaria(getPanelCadastroCliente().getTextFieldNumeroContaBancaria().getText());
		cliente.setClasseEconomica((String) getPanelCadastroCliente().getBoxClasseEconomica().getSelectedItem());
		cliente.setNomeReferencia1(getPanelCadastroCliente().getTextFieldNomeReferencia1().getText());
		cliente.setNomeReferencia2(getPanelCadastroCliente().getTextFieldNomeReferencia2().getText());
		cliente.setNomeReferencia3(getPanelCadastroCliente().getTextFieldNomeReferencia3().getText());
		cliente.setRelacionamentoReferencia1((String) getPanelCadastroCliente().getBoxRelacionamentoReferencia1().getSelectedItem());
		cliente.setRelacionamentoReferencia2((String) getPanelCadastroCliente().getBoxRelacionamentoReferencia2().getSelectedItem());
		cliente.setRelacionamentoReferencia3((String) getPanelCadastroCliente().getBoxRelacionamentoReferencia3().getSelectedItem());
		cliente.setFoneReferencia1(getPanelCadastroCliente().getTextFieldFoneReferencia1().getText());
		cliente.setFoneReferencia2(getPanelCadastroCliente().getTextFieldFoneReferencia2().getText());
		cliente.setFoneReferencia3(getPanelCadastroCliente().getTextFieldFoneReferencia3().getText());
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public FrameCadastroCliente getFrameCadastroCliente() {
		return MainGerenteEventos.getFrameCadastroCliente();
	}
	
	public PanelCadastroCliente getPanelCadastroCliente() {
		return MainGerenteEventos.getFrameCadastroCliente().getPanelCadastroCliente();
	}
	
	public FramePesquisaCliente getFramePesquisaCliente() {
		return MainGerenteEventos.getFramePesquisaCliente();
	}

	public PanelPesquisaCliente getPanelPesquisaCliente() {
		return MainGerenteEventos.getFramePesquisaCliente().getPanelPesquisaCliente();
	}
}
