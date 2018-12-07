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
import erp.main.MainCT;

final class ContatoCT {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (contato == null || contato.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				ContatoFAC.deletarRegistro(contato);
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
				getContatoFC().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getContatoFC().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getContatoFC().setVisible(false);
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
				MainCT.mostrarFrame(MainCT.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Contato> contatos = new LinkedList<>();

			if (contato.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (contatos.add(ContatoFAC.getRegistro(contato))) {
					ContatoREL contatoREL = new ContatoREL(contatos);
					contatoREL.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Contato> contatos = new LinkedList<>();

			try {
				contatos = new LinkedList<>(ContatoFAC.pesquisarRegistro(contato));
			} catch (Exception e) {
				System.out.println(e);
			}
			ContatoREL contatoREL = new ContatoREL(contatos);
			contatoREL.retornarRelatorio(true);
		}
	}

	public class MostraEmpresaFC extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainCT.mostrarFrame(MainCT.getEmpresaFC());
			} else {
				MainCT.getEmpresaFC().reiniciarGUI();
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			contato = new Contato();
			getContatoFC().limparGUI();
			getContatoPC().getNomeGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			contato = new Contato();
			atualizarObjeto();
			getContatoPP().pesquisarRegistroContato(contato);
			MainCT.mostrarFrame(MainCT.getAgendaContatoFP());
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
				String nome = getContatoPC().getNomeGUI().getText();
				if (nome == null || nome.length() == 0) {
					getContatoPC().getNomeGUI().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					ContatoFAC.salvarRegistro(contato);
					contato = new Contato();
					MainCT.getAgendaContatoFC().limparGUI();
					getContatoPC().getNomeGUI().requestFocus();
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
		getContatoPC().getNomeGUI().setText(contato.getNome());
		getContatoPC().getSexoGUI().setSelectedItem(contato.getSexo());
		getContatoPC().getEmailGUI().setText(contato.getEmail());
		getContatoPC().getFaxGUI().setText(contato.getFax());
		getContatoPC().getFone1GUI().setText(contato.getFone1());
		getContatoPC().getFone2GUI().setText(contato.getFone2());
		getContatoPC().getEmpresaGUI().setSelectedItem(contato.getEmpresa());
		getContatoPC().getBairroGUI().setText(contato.getBairro());
		getContatoPC().getCepGUI().setText(contato.getCep());
		getContatoPC().getCidadeGUI().setText(contato.getCidade());
		getContatoPC().getComplementoGUI().setText(contato.getComplemento());
		getContatoPC().getEstadoGUI().setText(contato.getEstado());
		getContatoPC().getLogradouroGUI().setText(contato.getLogradouro());
		getContatoPC().getPaisGUI().setText(contato.getPais());
		getContatoPC().getCnpjGUI().setText(contato.getCnpj());
		getContatoPC().getCpfGUI().setText(contato.getCpf());
	}

	public void atualizarObjeto() {
		contato.setNome(getContatoPC().getNomeGUI().getText());
		contato.setSexo((String) getContatoPC().getSexoGUI().getSelectedItem());
		contato.setEmail(getContatoPC().getEmailGUI().getText());
		contato.setFax(getContatoPC().getFaxGUI().getText());
		contato.setFone1(getContatoPC().getFone1GUI().getText());
		contato.setFone2(getContatoPC().getFone2GUI().getText());
		contato.setEmpresa((Empresa) getContatoPC().getEmpresaGUI().getSelectedItem());
		contato.setBairro(getContatoPC().getBairroGUI().getText());
		contato.setCep(getContatoPC().getCepGUI().getText());
		contato.setCidade(getContatoPC().getCidadeGUI().getText());
		contato.setComplemento(getContatoPC().getComplementoGUI().getText());
		contato.setEstado(getContatoPC().getEstadoGUI().getText());
		contato.setLogradouro(getContatoPC().getLogradouroGUI().getText());
		contato.setPais(getContatoPC().getPaisGUI().getText());
		contato.setCnpj(getContatoPC().getCnpjGUI().getText());
		contato.setCpfNumero(getContatoPC().getCpfGUI().getText());
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public ContatoFC getContatoFC() {
		return MainCT.getAgendaContatoFC();
	}

	public ContatoPC getContatoPC() {
		return MainCT.getAgendaContatoFC().getPanelCadastroContato();
	}

	public ContatoFP getContatoFP() {
		return MainCT.getAgendaContatoFP();
	}

	public ContatoPP getContatoPP() {
		return MainCT.getAgendaContatoFP().getContatoPP();
	}
}
