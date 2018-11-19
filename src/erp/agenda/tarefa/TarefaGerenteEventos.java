package erp.agenda.tarefa;

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
import erp.main.MainGerenteEventos;
import erp.main.PanelSobre;

final class TarefaGerenteEventos {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (tarefa == null || tarefa.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				TarefaDaoFacade.deletarRegistro(tarefa);
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
				getFrameCadastroTarefa().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroTarefa().reiniciarBox();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroTarefa().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			tarefa = new Tarefa();
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
			List<Tarefa> tarefas = new LinkedList<>();

			if (tarefa.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (tarefas.add(TarefaDaoFacade.getRegistro(tarefa))) {
					TarefaRelatorio tarefaRelatorio = new TarefaRelatorio(tarefas);
					tarefaRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Tarefa> tarefas = new LinkedList<>();

			try {
				tarefas = new LinkedList<>(TarefaDaoFacade.pesquisarRegistro(tarefa));
			} catch (Exception e) {
				System.out.println(e);
			}
			TarefaRelatorio tarefaRelatorio = new TarefaRelatorio(tarefas);
			tarefaRelatorio.retornarRelatorio(true);
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

	public class NovoFrameTarefa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			tarefa = new Tarefa();
			getFrameCadastroTarefa().limparGui();
			getPanelCadastroTarefa().getTextFieldNome().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			tarefa = new Tarefa();
			atualizarObjeto();
			getPanelPesquisaTarefa().pesquisarRegistroTarefa(tarefa);
			MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFramePesquisaTarefa());
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
				String nome = getPanelCadastroTarefa().getTextFieldNome().getText();
				if (nome == null || nome.length() == 0) {
					getPanelCadastroTarefa().getTextFieldNome().requestFocus();
					Msg.avisoCampoObrigatorio("Nome");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					TarefaDaoFacade.salvarRegistro(tarefa);
					tarefa = new Tarefa();
					getFrameCadastroTarefa().limparGui();
					getPanelCadastroTarefa().getTextFieldNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroInserirRegistro();
			}
		}
	}

	private  Tarefa tarefa;


	public void atualizarGui() {
		if (tarefa == null) {
			return;
		}
		getPanelCadastroTarefa().getTextFieldNome().setText(tarefa.getNome());
		getPanelCadastroTarefa().getTextFieldSexo().setSelectedItem(tarefa.getSexo());
		getPanelCadastroTarefa().getTextFieldEmail().setText(tarefa.getEmail());
		getPanelCadastroTarefa().getTextFieldFax().setText(tarefa.getFax());
		getPanelCadastroTarefa().getTextFieldFone1().setText(tarefa.getFone1());
		getPanelCadastroTarefa().getTextFieldFone2().setText(tarefa.getFone2());
		getPanelCadastroTarefa().getBoxEmpresa().setSelectedItem(tarefa.getEmpresa());
		getPanelCadastroTarefa().getTextFieldBairro().setText(tarefa.getBairro());
		getPanelCadastroTarefa().getTextFieldCep().setText(tarefa.getCep());
		getPanelCadastroTarefa().getTextFieldCidade().setText(tarefa.getCidade());
		getPanelCadastroTarefa().getTextFieldComplemento().setText(tarefa.getComplemento());
		getPanelCadastroTarefa().getTextFieldEstado().setText(tarefa.getEstado());
		getPanelCadastroTarefa().getTextFieldLogradouro().setText(tarefa.getLogradouro());
		getPanelCadastroTarefa().getTextFieldPais().setText(tarefa.getPais());
		getPanelCadastroTarefa().getTextFieldCNPJ().setText(tarefa.getCnpj());
		getPanelCadastroTarefa().getTextFieldCPF().setText(tarefa.getCpfNumero());
	}

	public void atualizarObjeto() {
		tarefa.setNome(getPanelCadastroTarefa().getTextFieldNome().getText());
		tarefa.setSexo((String) getPanelCadastroTarefa().getTextFieldSexo().getSelectedItem());
		tarefa.setEmail(getPanelCadastroTarefa().getTextFieldEmail().getText());
		tarefa.setFax(getPanelCadastroTarefa().getTextFieldFax().getText());
		tarefa.setFone1(getPanelCadastroTarefa().getTextFieldFone1().getText());
		tarefa.setFone2(getPanelCadastroTarefa().getTextFieldFone2().getText());
		tarefa.setEmpresa((Empresa) getPanelCadastroTarefa().getBoxEmpresa().getSelectedItem());
		tarefa.setBairro(getPanelCadastroTarefa().getTextFieldBairro().getText());
		tarefa.setCep(getPanelCadastroTarefa().getTextFieldCep().getText());
		tarefa.setCidade(getPanelCadastroTarefa().getTextFieldCidade().getText());
		tarefa.setComplemento(getPanelCadastroTarefa().getTextFieldComplemento().getText());
		tarefa.setEstado(getPanelCadastroTarefa().getTextFieldEstado().getText());
		tarefa.setLogradouro(getPanelCadastroTarefa().getTextFieldLogradouro().getText());
		tarefa.setPais(getPanelCadastroTarefa().getTextFieldPais().getText());
		tarefa.setCnpj(getPanelCadastroTarefa().getTextFieldCNPJ().getText());
		tarefa.setCpfNumero(getPanelCadastroTarefa().getTextFieldCPF().getText());
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public FrameCadastroTarefa getFrameCadastroTarefa() {
		return MainGerenteEventos.getFrameCadastroTarefa();
	}
	
	public PanelCadastroTarefa getPanelCadastroTarefa() {
		return MainGerenteEventos.getFrameCadastroTarefa().getPanelCadastroTarefa();
	}
	
	public FramePesquisaTarefa getFramePesquisaTarefa() {
		return MainGerenteEventos.getFramePesquisaTarefa();
	}

	public PanelPesquisaTarefa getPanelPesquisaTarefa() {
		return MainGerenteEventos.getFramePesquisaTarefa().getPanelPesquisaTarefa();
	}}
