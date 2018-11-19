package erp.agenda.compromisso;

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

final class CompromissoGerenteEventos {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (compromisso == null || compromisso.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				CompromissoDaoFacade.deletarRegistro(compromisso);
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
				getFrameCadastroCompromisso().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroCompromisso().reiniciarBox();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroCompromisso().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			compromisso = new Compromisso();
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
			List<Compromisso> compromissos = new LinkedList<>();

			if (compromisso.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (compromissos.add(CompromissoDaoFacade.getRegistro(compromisso))) {
					CompromissoRelatorio compromissoRelatorio = new CompromissoRelatorio(compromissos);
					compromissoRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Compromisso> compromissos = new LinkedList<>();

			try {
				compromissos = new LinkedList<>(CompromissoDaoFacade.pesquisarRegistro(compromisso));
			} catch (Exception e) {
				System.out.println(e);
			}
			@SuppressWarnings("unused")
			CompromissoRelatorio compromissoRelatorio = new CompromissoRelatorio(compromissos);
			compromissoRelatorio.retornarRelatorio(true);
		}
	}

	public class MostraFrameCompromisso extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroEmpresa());
			} else {
				getFrameCadastroCompromisso().reiniciarBox();
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			compromisso = new Compromisso();
			getFrameCadastroCompromisso().limparGui();
			getPanelCadastroCompromisso().getTextFieldNome().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			compromisso = new Compromisso();
			atualizarObjeto();
			getPanelPesquisaCompromisso().pesquisarRegistroCompromisso(compromisso);
			MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFramePesquisaCompromisso());
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
				String nome = getPanelCadastroCompromisso().getTextFieldNome().getText();
				if (nome == null || nome.length() == 0) {
					getPanelCadastroCompromisso().getTextFieldNome().requestFocus();
					Msg.avisoCampoObrigatorio("Nome");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					CompromissoDaoFacade.salvarRegistro(compromisso);
					compromisso = new Compromisso();
					MainGerenteEventos.getFrameCadastroCompromisso().limparGui();
					getPanelCadastroCompromisso().getTextFieldNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroInserirRegistro();
			}
		}
	}

	private Compromisso compromisso;	

	public void atualizarGui() {
		if (compromisso == null) {
			return;
		}
		getPanelCadastroCompromisso().getTextFieldNome().setText(compromisso.getNome());
		getPanelCadastroCompromisso().getTextFieldSexo().setSelectedItem(compromisso.getSexo());
		getPanelCadastroCompromisso().getTextFieldEmail().setText(compromisso.getEmail());
		getPanelCadastroCompromisso().getTextFieldFax().setText(compromisso.getFax());
		getPanelCadastroCompromisso().getTextFieldFone1().setText(compromisso.getFone1());
		getPanelCadastroCompromisso().getTextFieldFone2().setText(compromisso.getFone2());
		getPanelCadastroCompromisso().getBoxEmpresa().setSelectedItem(compromisso.getEmpresa());
		getPanelCadastroCompromisso().getTextFieldBairro().setText(compromisso.getBairro());
		getPanelCadastroCompromisso().getTextFieldCep().setText(compromisso.getCep());
		getPanelCadastroCompromisso().getTextFieldCidade().setText(compromisso.getCidade());
		getPanelCadastroCompromisso().getTextFieldComplemento().setText(compromisso.getComplemento());
		getPanelCadastroCompromisso().getTextFieldEstado().setText(compromisso.getEstado());
		getPanelCadastroCompromisso().getTextFieldLogradouro().setText(compromisso.getLogradouro());
		getPanelCadastroCompromisso().getTextFieldPais().setText(compromisso.getPais());
		getPanelCadastroCompromisso().getTextFieldCNPJ().setText(compromisso.getCnpj());
		getPanelCadastroCompromisso().getTextFieldCPF().setText(compromisso.getCpfNumero());
	}

	public void atualizarObjeto() {
		compromisso.setNome(getPanelCadastroCompromisso().getTextFieldNome().getText());
		compromisso.setSexo((String) getPanelCadastroCompromisso().getTextFieldSexo().getSelectedItem());
		compromisso.setEmail(getPanelCadastroCompromisso().getTextFieldEmail().getText());
		compromisso.setFax(getPanelCadastroCompromisso().getTextFieldFax().getText());
		compromisso.setFone1(getPanelCadastroCompromisso().getTextFieldFone1().getText());
		compromisso.setFone2(getPanelCadastroCompromisso().getTextFieldFone2().getText());
		compromisso.setEmpresa((Empresa) getPanelCadastroCompromisso().getBoxEmpresa().getSelectedItem());
		compromisso.setBairro(getPanelCadastroCompromisso().getTextFieldBairro().getText());
		compromisso.setCep(getPanelCadastroCompromisso().getTextFieldCep().getText());
		compromisso.setCidade(getPanelCadastroCompromisso().getTextFieldCidade().getText());
		compromisso.setComplemento(getPanelCadastroCompromisso().getTextFieldComplemento().getText());
		compromisso.setEstado(getPanelCadastroCompromisso().getTextFieldEstado().getText());
		compromisso.setLogradouro(getPanelCadastroCompromisso().getTextFieldLogradouro().getText());
		compromisso.setPais(getPanelCadastroCompromisso().getTextFieldPais().getText());
		compromisso.setCnpj(getPanelCadastroCompromisso().getTextFieldCNPJ().getText());
		compromisso.setCpfNumero(getPanelCadastroCompromisso().getTextFieldCPF().getText());
	}

	public Compromisso getCompromisso() {
		return compromisso;
	}

	public void setCompromisso(Compromisso compromisso) {
		this.compromisso = compromisso;
	}

	public FrameCadastroCompromisso getFrameCadastroCompromisso() {
		return MainGerenteEventos.getFrameCadastroCompromisso();
	}
	
	public PanelCadastroCompromisso getPanelCadastroCompromisso() {
		return MainGerenteEventos.getFrameCadastroCompromisso().getPanelCadastroCompromisso();
	}
	
	public FramePesquisaCompromisso getFramePesquisaCompromisso() {
		return MainGerenteEventos.getFramePesquisaCompromisso();
	}

	public PanelPesquisaCompromisso getPanelPesquisaCompromisso() {
		return MainGerenteEventos.getFramePesquisaCompromisso().getPanelPesquisaCompromisso();
	}
}
