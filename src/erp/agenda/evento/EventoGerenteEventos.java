package erp.agenda.evento;

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
import erp.main.MainGerenteEventos;

final class EventoGerenteEventos {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (evento == null || evento.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				EventoDaoFacade.deletarRegistro(evento);
				getFrameCadastroEvento().limparGui();
				evento = new Evento();
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
				getFrameCadastroEvento().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroEvento().reiniciarBox();
			atualizarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroEvento().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			evento = new Evento();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiTodosRegistros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Evento> eventos = new LinkedList<>();

			if (evento.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (eventos.add(EventoDaoFacade.getRegistro(evento))) {
					EventoRelatorio eventoRelatorio = new EventoRelatorio(eventos);
					eventoRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Evento> eventos = new LinkedList<>();

			try {
				eventos = new LinkedList<>(EventoDaoFacade.pesquisarRegistro(evento));
			} catch (Exception e) {
				System.out.println(e);
			}
			EventoRelatorio eventoRelatorio = new EventoRelatorio(eventos);
			eventoRelatorio.retornarRelatorio(true);
		}
	}

	public class MostraFrameEmpresa extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroEmpresa());
			} else {
				MainGerenteEventos.getFrameCadastroEmpresa().reiniciarBox();
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			evento = new Evento();
			getFrameCadastroEvento().limparGui();
			getPanelCadastroEvento().getTextFieldNome().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			evento = new Evento();
			atualizarObjeto();
			getPanelPesquisaEvento().pesquisarRegistroAgenda(evento);

			MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFramePesquisaAgendaEvento());
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
				String nome = getPanelCadastroEvento().getTextFieldNome().getText();
				if (nome == null || nome.length() == 0) {
					getPanelCadastroEvento().getTextFieldNome().requestFocus();
					Msg.avisoCampoObrigatorio("Nome");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					EventoDaoFacade.salvarRegistro(evento);
					evento = new Evento();
					getFrameCadastroEvento().limparGui();
					getPanelCadastroEvento().getTextFieldNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroInserirRegistro();
			}
		}
	}

	private Evento evento;

	public void atualizarGui() {
		if (evento == null) {
			return;
		}
		getPanelCadastroEvento().getTextFieldNome().setText(evento.getNome());
		getPanelCadastroEvento().getTextFieldSexo().setSelectedItem(evento.getSexo());
		getPanelCadastroEvento().getTextFieldEmail().setText(evento.getEmail());
		getPanelCadastroEvento().getTextFieldFax().setText(evento.getFax());
		getPanelCadastroEvento().getTextFieldFone1().setText(evento.getFone1());
		getPanelCadastroEvento().getTextFieldFone2().setText(evento.getFone2());
		getPanelCadastroEvento().getBoxEmpresa().setSelectedItem(evento.getEmpresa());
		getPanelCadastroEvento().getTextFieldBairro().setText(evento.getBairro());
		getPanelCadastroEvento().getTextFieldCep().setText(evento.getCep());
		getPanelCadastroEvento().getTextFieldCidade().setText(evento.getCidade());
		getPanelCadastroEvento().getTextFieldComplemento().setText(evento.getComplemento());
		getPanelCadastroEvento().getTextFieldEstado().setText(evento.getEstado());
		getPanelCadastroEvento().getTextFieldLogradouro().setText(evento.getLogradouro());
		getPanelCadastroEvento().getTextFieldPais().setText(evento.getPais());
		getPanelCadastroEvento().getTextFieldCNPJ().setText(evento.getCnpj());
		getPanelCadastroEvento().getTextFieldCPF().setText(evento.getCpfNumero());
	}

	public void atualizarObjeto() {
		evento.setNome(getPanelCadastroEvento().getTextFieldNome().getText());
		evento.setSexo((String) getPanelCadastroEvento().getTextFieldSexo().getSelectedItem());
		evento.setEmail(getPanelCadastroEvento().getTextFieldEmail().getText());
		evento.setFax(getPanelCadastroEvento().getTextFieldFax().getText());
		evento.setFone1(getPanelCadastroEvento().getTextFieldFone1().getText());
		evento.setFone2(getPanelCadastroEvento().getTextFieldFone2().getText());
		evento.setEmpresa((Empresa) getPanelCadastroEvento().getBoxEmpresa().getSelectedItem());
		evento.setBairro(getPanelCadastroEvento().getTextFieldBairro().getText());
		evento.setCep(getPanelCadastroEvento().getTextFieldCep().getText());
		evento.setCidade(getPanelCadastroEvento().getTextFieldCidade().getText());
		evento.setComplemento(getPanelCadastroEvento().getTextFieldComplemento().getText());
		evento.setEstado(getPanelCadastroEvento().getTextFieldEstado().getText());
		evento.setLogradouro(getPanelCadastroEvento().getTextFieldLogradouro().getText());
		evento.setPais(getPanelCadastroEvento().getTextFieldPais().getText());
		evento.setCnpj(getPanelCadastroEvento().getTextFieldCNPJ().getText());
		evento.setCpfNumero(getPanelCadastroEvento().getTextFieldCPF().getText());
	}

	public Evento getEvento() {
		return evento;
	}

	public void setAgenda(Evento evento) {
		this.evento = evento;
	}

	public FrameCadastroEvento getFrameCadastroEvento() {
		return MainGerenteEventos.getFrameCadastroAgendaEvento();
	}

	public PanelCadastroEvento getPanelCadastroEvento() {
		return MainGerenteEventos.getFrameCadastroAgendaEvento().getPanelCadastroEvento();
	}

	public FramePesquisaEvento getFramePesquisaEvento() {
		return MainGerenteEventos.getFramePesquisaAgendaEvento();
	}

	public PanelPesquisaEvento getPanelPesquisaEvento() {
		return MainGerenteEventos.getFramePesquisaAgendaEvento().getPanelPesquisaEvento();
	}
}
