package erp.agenda.contato;

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
import erp.empresa.Empresa;
import erp.main.MainControlador;

final class ContatoControlador {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (contato == null || contato.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				ContatoDaoFacade.deletarRegistro(contato);
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				getFrameCadastroContato().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroContato().reiniciarBox();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroContato().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			contato = new Contato();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				MainControlador.mostrarFrame(MainControlador.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiTodosRegistros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Contato> contatos = new LinkedList<>();

			if (contato.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (contatos.add(ContatoDaoFacade.getRegistro(contato))) {
					ContatoRelatorio contatoRelatorio = new ContatoRelatorio(contatos);
					contatoRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Contato> contatos = new LinkedList<>();

			try {
				contatos = new LinkedList<>(ContatoDaoFacade.pesquisarRegistro(contato));
			} catch (Exception e) {
				System.out.println(e);
			}
			ContatoRelatorio contatoRelatorio = new ContatoRelatorio(contatos);
			contatoRelatorio.retornarRelatorio(true);
		}
	}

	public class MostraFrameContato extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainControlador.mostrarFrame(MainControlador.getFrameCadastroEmpresa());
			} else {
				MainControlador.getFrameCadastroEmpresa().reiniciarBox();
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			contato = new Contato();
			getFrameCadastroContato().limparGui();
			getPanelCadastroContato().getTextFieldNome().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			contato = new Contato();
			atualizarObjeto();
			getPanelPesquisaContato().pesquisarRegistroContato(contato);
			MainControlador.mostrarFrame(MainControlador.getFramePesquisaAgendaContato());
		}
	}

	public class SaidaSistema implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				int mensagem = Msg.confirmarSairDoSistema();
				if (mensagem == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println(e);
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
				String nome = getPanelCadastroContato().getTextFieldNome().getText();
				if (nome == null || nome.length() == 0) {
					getPanelCadastroContato().getTextFieldNome().requestFocus();
					Msg.avisoCampoObrigatorio("Nome");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					ContatoDaoFacade.salvarRegistro(contato);
					contato = new Contato();
					MainControlador.getFrameCadastroAgendaContato().limparGui();
					getPanelCadastroContato().getTextFieldNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroInserirRegistro();
			}
		}
	}

	private Contato contato;

	public void atualizarGui() {
		if (contato == null) {
			return;
		}
		getPanelCadastroContato().getTextFieldNome().setText(contato.getNome());
		getPanelCadastroContato().getTextFieldSexo().setSelectedItem(contato.getSexo());
		getPanelCadastroContato().getTextFieldEmail().setText(contato.getEmail());
		getPanelCadastroContato().getTextFieldFax().setText(contato.getFax());
		getPanelCadastroContato().getTextFieldFone1().setText(contato.getFone1());
		getPanelCadastroContato().getTextFieldFone2().setText(contato.getFone2());
		getPanelCadastroContato().getBoxEmpresa().setSelectedItem(contato.getEmpresa());
		getPanelCadastroContato().getTextFieldBairro().setText(contato.getBairro());
		getPanelCadastroContato().getTextFieldCep().setText(contato.getCep());
		getPanelCadastroContato().getTextFieldCidade().setText(contato.getCidade());
		getPanelCadastroContato().getTextFieldComplemento().setText(contato.getComplemento());
		getPanelCadastroContato().getTextFieldEstado().setText(contato.getEstado());
		getPanelCadastroContato().getTextFieldLogradouro().setText(contato.getLogradouro());
		getPanelCadastroContato().getTextFieldPais().setText(contato.getPais());
		getPanelCadastroContato().getTextFieldCNPJ().setText(contato.getCnpj());
		getPanelCadastroContato().getTextFieldCPF().setText(contato.getCpfNumero());
	}

	public void atualizarObjeto() {
		contato.setNome(getPanelCadastroContato().getTextFieldNome().getText());
		contato.setSexo((String) getPanelCadastroContato().getTextFieldSexo().getSelectedItem());
		contato.setEmail(getPanelCadastroContato().getTextFieldEmail().getText());
		contato.setFax(getPanelCadastroContato().getTextFieldFax().getText());
		contato.setFone1(getPanelCadastroContato().getTextFieldFone1().getText());
		contato.setFone2(getPanelCadastroContato().getTextFieldFone2().getText());
		contato.setEmpresa((Empresa) getPanelCadastroContato().getBoxEmpresa().getSelectedItem());
		contato.setBairro(getPanelCadastroContato().getTextFieldBairro().getText());
		contato.setCep(getPanelCadastroContato().getTextFieldCep().getText());
		contato.setCidade(getPanelCadastroContato().getTextFieldCidade().getText());
		contato.setComplemento(getPanelCadastroContato().getTextFieldComplemento().getText());
		contato.setEstado(getPanelCadastroContato().getTextFieldEstado().getText());
		contato.setLogradouro(getPanelCadastroContato().getTextFieldLogradouro().getText());
		contato.setPais(getPanelCadastroContato().getTextFieldPais().getText());
		contato.setCnpj(getPanelCadastroContato().getTextFieldCNPJ().getText());
		contato.setCpfNumero(getPanelCadastroContato().getTextFieldCPF().getText());
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public FCContato getFrameCadastroContato() {
		return MainControlador.getFrameCadastroAgendaContato();
	}

	public PCContato getPanelCadastroContato() {
		return MainControlador.getFrameCadastroAgendaContato().getPanelCadastroContato();
	}

	public FPContato getFramePesquisaContato() {
		return MainControlador.getFramePesquisaAgendaContato();
	}

	public PPContato getPanelPesquisaContato() {
		return MainControlador.getFramePesquisaAgendaContato().getPanelPesquisaContato();
	}
}
