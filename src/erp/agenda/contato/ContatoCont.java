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
import erp.main.MainCont;

final class ContatoCont {
	
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
				ContatoFac.deletarRegistro(contato);
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
				getContatoFc().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getContatoFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getContatoFc().setVisible(false);
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
				MainCont.mostrarFrame(MainCont.getMainFc());
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
				if (contatos.add(ContatoFac.getRegistro(contato))) {
					ContatoRel contatoRel = new ContatoRel(contatos);
					contatoRel.retornarRelatorio(true);
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
				contatos = new LinkedList<>(ContatoFac.pesquisarRegistro(contato));
			} catch (Exception e) {
				System.out.println(e);
			}
			ContatoRel contatoRel = new ContatoRel(contatos);
			contatoRel.retornarRelatorio(true);
		}
	}

	public class MostraFc extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getContatoPc().getLabelEmpresa()) {
				MainCont.mostrarFrame(MainCont.getEmpresaFc());
			} else {
				MainCont.getEmpresaFc().reiniciarGui();
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			contato = new Contato();
			getContatoFc().limparGui();
			getContatoPc().getNomeGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			contato = new Contato();
			atualizarObjeto();
			getContatoPp().pesquisarRegistroContato(contato);
			MainCont.mostrarFrame(MainCont.getAgendaContatoFp());
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
				String nome = getContatoPc().getNomeGUI().getText();
				if (nome == null || nome.length() == 0) {
					getContatoPc().getNomeGUI().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					ContatoFac.salvarRegistro(contato);
					contato = new Contato();
					MainCont.getAgendaContatoFc().limparGui();
					getContatoPc().getNomeGUI().requestFocus();
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
		getContatoPc().getNomeGUI().setText(contato.getNome());
		getContatoPc().getSexoGUI().setSelectedItem(contato.getSexo());
		getContatoPc().getEmailGUI().setText(contato.getEmail());
		getContatoPc().getFaxGUI().setText(contato.getFax());
		getContatoPc().getFone1GUI().setText(contato.getFone1());
		getContatoPc().getFone2GUI().setText(contato.getFone2());
		getContatoPc().getEmpresaGUI().setSelectedItem(contato.getEmpresa());
		getContatoPc().getBairroGUI().setText(contato.getBairro());
		getContatoPc().getCepGUI().setText(contato.getCep());
		getContatoPc().getCidadeGUI().setText(contato.getCidade());
		getContatoPc().getComplementoGUI().setText(contato.getComplemento());
		getContatoPc().getEstadoGUI().setText(contato.getEstado());
		getContatoPc().getLogradouroGUI().setText(contato.getLogradouro());
		getContatoPc().getPaisGUI().setText(contato.getPais());
		getContatoPc().getCnpjGUI().setText(contato.getCnpj());
		getContatoPc().getCpfGUI().setText(contato.getCpf());
	}

	public void atualizarObjeto() {
		contato.setNome(getContatoPc().getNomeGUI().getText());
		contato.setSexo((String) getContatoPc().getSexoGUI().getSelectedItem());
		contato.setEmail(getContatoPc().getEmailGUI().getText());
		contato.setFax(getContatoPc().getFaxGUI().getText());
		contato.setFone1(getContatoPc().getFone1GUI().getText());
		contato.setFone2(getContatoPc().getFone2GUI().getText());
		contato.setEmpresa((Empresa) getContatoPc().getEmpresaGUI().getSelectedItem());
		contato.setBairro(getContatoPc().getBairroGUI().getText());
		contato.setCep(getContatoPc().getCepGUI().getText());
		contato.setCidade(getContatoPc().getCidadeGUI().getText());
		contato.setComplemento(getContatoPc().getComplementoGUI().getText());
		contato.setEstado(getContatoPc().getEstadoGUI().getText());
		contato.setLogradouro(getContatoPc().getLogradouroGUI().getText());
		contato.setPais(getContatoPc().getPaisGUI().getText());
		contato.setCnpj(getContatoPc().getCnpjGUI().getText());
		contato.setCpfNumero(getContatoPc().getCpfGUI().getText());
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public ContatoFc getContatoFc() {
		return MainCont.getAgendaContatoFc();
	}

	public ContatoPc getContatoPc() {
		return MainCont.getAgendaContatoFc().getContatoPc();
	}

	public ContatoFp getContatoFp() {
		return MainCont.getAgendaContatoFp();
	}

	public ContatoPp getContatoPp() {
		return MainCont.getAgendaContatoFp().getContatoPp();
	}
}
