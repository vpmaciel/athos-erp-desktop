package erp.agenda.agenda;

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
import erp.empresa.Empresa;
import erp.main.FrameMain;
import erp.main.MainGerenteEventos;
import erp.main.PanelSobre;

final class AgendaGerenteEventos {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (agenda == null || agenda.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				AgendaDaoFacade.deletarRegistro(agenda);
				getFrameCadastroAgenda().limparGui();
				agenda = new Agenda();
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
				getFrameCadastroAgenda().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroAgenda().reiniciarBox();
			atualizarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroAgenda().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			agenda = new Agenda();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				FrameMain.mostrarFrame(FrameMain.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiTodosRegistros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Agenda> agendas = new LinkedList<>();

			if (agenda.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (agendas.add(AgendaDaoFacade.getRegistro(agenda))) {
					AgendaRelatorio agendaRelatorio = new AgendaRelatorio(agendas);
					agendaRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Agenda> agendas = new LinkedList<>();

			try {
				agendas = new LinkedList<>(AgendaDaoFacade.pesquisarRegistro(agenda));
			} catch (Exception e) {
				System.out.println(e);
			}
			AgendaRelatorio agendaRelatorio = new AgendaRelatorio(agendas);
			agendaRelatorio.retornarRelatorio(true);
		}
	}

	public class MostraFrameEmpresa extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				FrameMain.mostrarFrame(MainGerenteEventos.getFrameCadastroEmpresa());
			} else {
				MainGerenteEventos.getFrameCadastroEmpresa().reiniciarBox();
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			agenda = new Agenda();
			MainGerenteEventos.getFrameCadastroAgenda().limparGui();
			getPanelCadastroAgenda().getTextFieldNome().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			agenda = new Agenda();
			atualizarObjeto();
			getPanelPesquisaAgenda().pesquisarRegistroAgenda(agenda);
			FrameMain.mostrarFrame(MainGerenteEventos.getFramePesquisaAgenda());
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
				String nome = getPanelCadastroAgenda().getTextFieldNome().getText();
				if (nome == null || nome.length() == 0) {
					getPanelCadastroAgenda().getTextFieldNome().requestFocus();
					Msg.avisoCampoObrigatorio("Nome");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					AgendaDaoFacade.salvarRegistro(agenda);
					agenda = new Agenda();
					MainGerenteEventos.getFrameCadastroAgenda().limparGui();
					getPanelCadastroAgenda().getTextFieldNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroInserirRegistro();
			}
		}
	}

	private static Agenda agenda;

	public void atualizarGui() {
		if (agenda == null) {
			return;
		}
		getPanelCadastroAgenda().getTextFieldNome().setText(agenda.getNome());
		getPanelCadastroAgenda().getTextFieldSexo().setSelectedItem(agenda.getSexo());
		getPanelCadastroAgenda().getTextFieldEmail().setText(agenda.getEmail());
		getPanelCadastroAgenda().getTextFieldFax().setText(agenda.getFax());
		getPanelCadastroAgenda().getTextFieldFone1().setText(agenda.getFone1());
		getPanelCadastroAgenda().getTextFieldFone2().setText(agenda.getFone2());
		getPanelCadastroAgenda().getBoxEmpresa().setSelectedItem(agenda.getEmpresa());
		getPanelCadastroAgenda().getTextFieldBairro().setText(agenda.getBairro());
		getPanelCadastroAgenda().getTextFieldCep().setText(agenda.getCep());
		getPanelCadastroAgenda().getTextFieldCidade().setText(agenda.getCidade());
		getPanelCadastroAgenda().getTextFieldComplemento().setText(agenda.getComplemento());
		getPanelCadastroAgenda().getTextFieldEstado().setText(agenda.getEstado());
		getPanelCadastroAgenda().getTextFieldLogradouro().setText(agenda.getLogradouro());
		getPanelCadastroAgenda().getTextFieldPais().setText(agenda.getPais());
		getPanelCadastroAgenda().getTextFieldCNPJ().setText(agenda.getCnpj());
		getPanelCadastroAgenda().getTextFieldCPF().setText(agenda.getCpfNumero());
	}

	public void atualizarObjeto() {
		agenda.setNome(getPanelCadastroAgenda().getTextFieldNome().getText());
		agenda.setSexo((String) getPanelCadastroAgenda().getTextFieldSexo().getSelectedItem());
		agenda.setEmail(getPanelCadastroAgenda().getTextFieldEmail().getText());
		agenda.setFax(getPanelCadastroAgenda().getTextFieldFax().getText());
		agenda.setFone1(getPanelCadastroAgenda().getTextFieldFone1().getText());
		agenda.setFone2(getPanelCadastroAgenda().getTextFieldFone2().getText());
		agenda.setEmpresa((Empresa) getPanelCadastroAgenda().getBoxEmpresa().getSelectedItem());
		agenda.setBairro(getPanelCadastroAgenda().getTextFieldBairro().getText());
		agenda.setCep(getPanelCadastroAgenda().getTextFieldCep().getText());
		agenda.setCidade(getPanelCadastroAgenda().getTextFieldCidade().getText());
		agenda.setComplemento(getPanelCadastroAgenda().getTextFieldComplemento().getText());
		agenda.setEstado(getPanelCadastroAgenda().getTextFieldEstado().getText());
		agenda.setLogradouro(getPanelCadastroAgenda().getTextFieldLogradouro().getText());
		agenda.setPais(getPanelCadastroAgenda().getTextFieldPais().getText());
		agenda.setCnpj(getPanelCadastroAgenda().getTextFieldCNPJ().getText());
		agenda.setCpfNumero(getPanelCadastroAgenda().getTextFieldCPF().getText());
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		AgendaGerenteEventos.agenda = agenda;
	}
	
	public FrameCadastroAgenda getFrameCadastroAgenda() {
		return MainGerenteEventos.getFrameCadastroAgenda();
	}
	
	public PanelCadastroAgenda getPanelCadastroAgenda() {
		return MainGerenteEventos.getFrameCadastroAgenda().getPanelCadastroAgenda();
	}
	
	public FramePesquisaAgenda getFramePesquisaAgenda() {
		return MainGerenteEventos.getFramePesquisaAgenda();
	}

	public PanelPesquisaAgenda getPanelPesquisaAgenda() {
		return MainGerenteEventos.getFramePesquisaAgenda().getPanelPesquisaAgenda();
	}
}
