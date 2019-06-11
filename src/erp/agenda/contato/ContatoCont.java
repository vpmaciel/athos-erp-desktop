package erp.agenda.contato;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import arquitetura.validacao.Mascara;
import erp.empresa.Empresa;
import erp.empresa.EmpresaComp;
import erp.empresa.EmpresaFac;
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
				e.printStackTrace();
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
				e.printStackTrace();
			}
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Contato> contatos = new LinkedList<>();

			if (contato.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (contatos.add(ContatoFac.getRegistro(contato))) {
				ContatoRel contatoRel = new ContatoRel(contatos);
				contatoRel.retornarRelatorio(true);
			}

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
			List<Empresa> empresaList = (List<Empresa>) EmpresaFac.getRegistro();
			Collections.sort(empresaList, new EmpresaComp().new NomeFantasia());

			getContatoPc().getGuiEmpresa().removeAllItems();
			getContatoPc().getGuiEmpresa().addItem(new Empresa());

			for (Empresa e : empresaList) {
				getContatoPc().getGuiEmpresa().addItem(e);
			}

			contato = new Contato();
			getContatoFc().limparGui();
			getContatoPc().getGuiNome().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getContatoPp().pesquisarRegistro(contato);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getContatoFp());
				getContatoFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getContatoPp().pesquisarRegistro(new Contato());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getContatoFp());
				getContatoFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Contato> contatos = new LinkedList<>();

			try {
				contatos = new LinkedList<>(ContatoFac.pesquisarRegistro(new Contato()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			ContatoRel contatoRel = new ContatoRel(contatos);
			contatoRel.retornarRelatorio(true);

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
				e.printStackTrace();
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
				String nome = getContatoPc().getGuiNome().getText();
				if (nome == null || nome.length() == 0) {
					getContatoPc().getGuiNome().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					ContatoFac.salvarRegistro(contato);
					contato = new Contato();
					MainCont.getAgendaContatoFc().limparGui();
					getContatoPc().getGuiNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Throwable throwable = e.getCause().getCause();
				String mensagem = throwable.toString();
				if (mensagem.contains("ConstraintViolationException")) {
					if (mensagem.contains("INDEX_CONTATO_CPF")) {
						Msg.avisoCampoDuplicado("CPF");
						getContatoPc().getGuiCpf().requestFocus();
					} else if (mensagem.contains("INDEX_CONTATO_CNPJ")) {
						Msg.avisoCampoDuplicado("CNPJ");
						getContatoPc().getGuiCnpj().requestFocus();
					} else {
						Msg.avisoCampoDuplicado();
					}
				}
				e.printStackTrace();
				Msg.erroSalvarRegistro();
			}
		}
	}

	private Contato contato;

	public void atualizarGui() {
		if (contato == null) {
			return;
		}
		getContatoPc().getGuiNome().setText(contato.getNome());
		getContatoPc().getGuiSexo().setSelectedItem(contato.getSexo());
		getContatoPc().getGuiEmail().setText(contato.getEmail());
		getContatoPc().getGuiFax().setText(contato.getFax());
		getContatoPc().getGuiFone1().setText(contato.getFone1());
		getContatoPc().getGuiFone2().setText(contato.getFone2());
		getContatoPc().getGuiEmpresa().setSelectedItem(contato.getEmpresa());
		getContatoPc().getGuiBairro().setText(contato.getBairro());
		getContatoPc().getGuiCep().setText(contato.getCep());
		getContatoPc().getGuiCidade().setText(contato.getCidade());
		getContatoPc().getGuiComplemento().setText(contato.getComplemento());
		getContatoPc().getGuiEstado().setText(contato.getEstado());
		getContatoPc().getGuiLogradouro().setText(contato.getLogradouro());
		getContatoPc().getGuiPais().setText(contato.getPais());
		getContatoPc().getGuiCnpj().setText(contato.getCnpj());
		getContatoPc().getGuiCpf().setText(contato.getCpf());
	}

	public void atualizarObjeto() {
		contato.setNome(getContatoPc().getGuiNome().getText());
		contato.setSexo((String) getContatoPc().getGuiSexo().getSelectedItem());
		contato.setEmail(getContatoPc().getGuiEmail().getText());
		contato.setFax(getContatoPc().getGuiFax().getText());
		contato.setFone1(getContatoPc().getGuiFone1().getText());
		contato.setFone2(getContatoPc().getGuiFone2().getText());
		contato.setEmpresa((Empresa) getContatoPc().getGuiEmpresa().getSelectedItem());
		contato.setBairro(getContatoPc().getGuiBairro().getText());
		contato.setCep(getContatoPc().getGuiCep().getText());
		contato.setCidade(getContatoPc().getGuiCidade().getText());
		contato.setComplemento(getContatoPc().getGuiComplemento().getText());
		contato.setEstado(getContatoPc().getGuiEstado().getText());
		contato.setLogradouro(getContatoPc().getGuiLogradouro().getText());
		contato.setPais(getContatoPc().getGuiPais().getText());
		contato.setCnpj(getContatoPc().getGuiCnpj().getText());
		contato.setCpf(getContatoPc().getGuiCpf().getText());

		if (getContatoPc().getGuiCnpj().getText().equals(Mascara.getCnpjVazio())) {
			contato.setCnpj(null);
		}

		if (getContatoPc().getGuiCpf().getText().equals(Mascara.getCpfVazio())) {
			contato.setCpf(null);
		}
	}

	public Contato getContato() {
		return contato;
	}

	public ContatoFc getContatoFc() {
		return MainCont.getAgendaContatoFc();
	}

	public ContatoFp getContatoFp() {
		return MainCont.getAgendaContatoFp();
	}

	public ContatoPc getContatoPc() {
		return MainCont.getAgendaContatoFc().getContatoPc();
	}

	public ContatoPp getContatoPp() {
		return MainCont.getAgendaContatoFp().getContatoPp();
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
}
