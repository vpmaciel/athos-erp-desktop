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

			try {
				contatos = new LinkedList<>(ContatoFac.pesquisarRegistro(new Contato()));
			} catch (Exception e) {
				System.out.println(e);
			}

			ContatoRel contatoRel = new ContatoRel(contatos);
			contatoRel.retornarRelatorio(true);

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

			getContatoPc().getEmpresaGui().removeAllItems();
			getContatoPc().getEmpresaGui().addItem(new Empresa());

			for (Empresa e : empresaList) {
				getContatoPc().getEmpresaGui().addItem(e);
			}

			contato = new Contato();
			getContatoFc().limparGui();
			getContatoPc().getNomeGui().requestFocus();
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
				String nome = getContatoPc().getNomeGui().getText();
				if (nome == null || nome.length() == 0) {
					getContatoPc().getNomeGui().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}
				
				Contato contatoPesquisa = new Contato();
				contatoPesquisa.setCnpj(getContatoPc().getCnpjGui().getText());
				Contato contatoPesquisaRetornado = ContatoFac.consultarRegistro(contatoPesquisa);

				if (contato.getId() == null && contatoPesquisa.getCnpj() != null
						&& contatoPesquisaRetornado.getCnpj() != null) {
					if (contatoPesquisa.getCnpj().equals(contatoPesquisaRetornado.getCnpj())) {
						Msg.avisoCampoDuplicado("CNPJ", contatoPesquisa.getCnpj());
						getContatoPc().getCnpjGui().requestFocus();
						return;
					}
				}

				if (contato.getId() != null && contatoPesquisa.getCnpj() != null
						&& contatoPesquisaRetornado.getCnpj() != null) {
					if (!contato.getCnpj().equals(contatoPesquisa.getCnpj())) {
						if (contatoPesquisa.getCnpj().equals(contatoPesquisaRetornado.getCnpj())) {
							Msg.avisoCampoDuplicado("CNPJ", contatoPesquisa.getCnpj());
							getContatoPc().getCnpjGui().requestFocus();
						}
						return;
					}
				}
				
				contatoPesquisa = new Contato();
				contatoPesquisa.setCpf(getContatoPc().getCpfGui().getText());
				contatoPesquisaRetornado = ContatoFac.consultarRegistro(contatoPesquisa);

				if (contato.getId() == null && contatoPesquisa.getCpf() != null
						&& contatoPesquisaRetornado.getCpf() != null) {
					if (contatoPesquisa.getCpf().equals(contatoPesquisaRetornado.getCpf())) {
						Msg.avisoCampoDuplicado("CPF", contatoPesquisa.getCpf());
						getContatoPc().getCpfGui().requestFocus();
						return;
					}
				}

				if (contato.getId() != null && contatoPesquisa.getCpf() != null
						&& contatoPesquisaRetornado.getCpf() != null) {
					if (!contato.getCpf().equals(contatoPesquisa.getCpf())) {
						if (contatoPesquisa.getCpf().equals(contatoPesquisaRetornado.getCpf())) {
							Msg.avisoCampoDuplicado("CPF", contatoPesquisa.getCpf());
							getContatoPc().getCpfGui().requestFocus();
						}
						return;
					}
				}
			
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					ContatoFac.salvarRegistro(contato);
					contato = new Contato();
					MainCont.getAgendaContatoFc().limparGui();
					getContatoPc().getNomeGui().requestFocus();
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
		getContatoPc().getNomeGui().setText(contato.getNome());
		getContatoPc().getSexoGui().setSelectedItem(contato.getSexo());
		getContatoPc().getEmailGui().setText(contato.getEmail());
		getContatoPc().getFaxGui().setText(contato.getFax());
		getContatoPc().getFone1Gui().setText(contato.getFone1());
		getContatoPc().getFone2Gui().setText(contato.getFone2());
		getContatoPc().getEmpresaGui().setSelectedItem(contato.getEmpresa());
		getContatoPc().getBairroGui().setText(contato.getBairro());
		getContatoPc().getCepGui().setText(contato.getCep());
		getContatoPc().getCidadeGui().setText(contato.getCidade());
		getContatoPc().getComplementoGui().setText(contato.getComplemento());
		getContatoPc().getEstadoGui().setText(contato.getEstado());
		getContatoPc().getLogradouroGui().setText(contato.getLogradouro());
		getContatoPc().getPaisGui().setText(contato.getPais());
		getContatoPc().getCnpjGui().setText(contato.getCnpj());
		getContatoPc().getCpfGui().setText(contato.getCpf());
	}

	public void atualizarObjeto() {
		contato.setNome(getContatoPc().getNomeGui().getText());
		contato.setSexo((String) getContatoPc().getSexoGui().getSelectedItem());
		contato.setEmail(getContatoPc().getEmailGui().getText());
		contato.setFax(getContatoPc().getFaxGui().getText());
		contato.setFone1(getContatoPc().getFone1Gui().getText());
		contato.setFone2(getContatoPc().getFone2Gui().getText());
		contato.setEmpresa((Empresa) getContatoPc().getEmpresaGui().getSelectedItem());
		contato.setBairro(getContatoPc().getBairroGui().getText());
		contato.setCep(getContatoPc().getCepGui().getText());
		contato.setCidade(getContatoPc().getCidadeGui().getText());
		contato.setComplemento(getContatoPc().getComplementoGui().getText());
		contato.setEstado(getContatoPc().getEstadoGui().getText());
		contato.setLogradouro(getContatoPc().getLogradouroGui().getText());
		contato.setPais(getContatoPc().getPaisGui().getText());
		contato.setCnpj(getContatoPc().getCnpjGui().getText());
		contato.setCpf(getContatoPc().getCpfGui().getText());

		if (getContatoPc().getCnpjGui().getText().equals(Mascara.getCnpjVazio())) {
			contato.setCnpj(null);
		}

		if (getContatoPc().getCpfGui().getText().equals(Mascara.getCpfVazio())) {
			contato.setCpf(null);
		}
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
