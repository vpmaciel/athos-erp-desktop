package erp.contador;

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
import arquitetura.validacao.Mascara;
import erp.main.MainCont;

final class ContadorCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (contador == null || contador.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != 0) {
				return;
			}
			try {
				ContadorFac.deletarRegistro(contador);
				getContadorFc().limparGui();
				contador = new Contador();
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
				MainCont.getContadorFc().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getContadorFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getContadorFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			contador = new Contador();
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
			List<Contador> contadors = new LinkedList<>();

			if (contador.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (contadors.add(ContadorFac.getRegistro(contador))) {
					ContadorRel contadorRel = new ContadorRel(contadors);
					contadorRel.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Contador> contadors = new LinkedList<>();

			try {
				contadors = new LinkedList<>(ContadorFac.pesquisarRegistro(contador));
			} catch (Exception e) {
				System.out.println(e);
			}
			ContadorRel contadorRel = new ContadorRel(contadors);
			contadorRel.retornarRelatorio(true);
		}
	}

	public class MostraFrameContador extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainCont.mostrarFrame(MainCont.getContadorFc());
			} else {
				MainCont.getContadorFc().reiniciarGui();
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			contador = new Contador();
			getContadorFc().limparGui();
			getContadorPc().getNomeGui().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			contador = new Contador();
			atualizarObjeto();
			MainCont.getContadorFp().getContadorPp().pesquisarRegistroContador(contador);

			MainCont.mostrarFrame(MainCont.getContadorFp());
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
				String nome = getContadorPc().getNomeGui().getText();
				if (nome == null || nome.length() == 0) {
					getContadorPc().getNomeGui().requestFocus();
					Msg.avisoCampoObrigatorio("Contador");
					return;
				}

				Contador contadorPesquisa = new Contador();
				contadorPesquisa.setCrc(getContadorPc().getCrcGui().getText());
				Contador contadorPesquisaRetornado = ContadorFac.consultarRegistro(contadorPesquisa);

				if (contador.getId() == null && contadorPesquisa.getCrc() != null
						&& contadorPesquisaRetornado.getCrc() != null) {
					if (contadorPesquisa.getCrc().equals(contadorPesquisaRetornado.getCrc())) {
						Msg.avisoCampoDuplicado("CRC", contadorPesquisa.getCrc());
						getContadorPc().getCrcGui().requestFocus();
						return;
					}
				}

				if (contador.getId() != null && contadorPesquisa.getCrc() != null
						&& contadorPesquisaRetornado.getCrc() != null) {
					if (!contador.getCrc().equals(contadorPesquisa.getCrc())) {
						if (contadorPesquisa.getCrc().equals(contadorPesquisaRetornado.getCrc())) {
							Msg.avisoCampoDuplicado("CRC", contadorPesquisa.getCrc());
							getContadorPc().getCrcGui().requestFocus();
						}
						return;
					}
				}

				contadorPesquisa = new Contador();
				contadorPesquisa.setCpf(getContadorPc().getCpfGui().getText());
				contadorPesquisaRetornado = ContadorFac.consultarRegistro(contadorPesquisa);

				if (contador.getId() == null && contadorPesquisa.getCpf() != null
						&& contadorPesquisaRetornado.getCpf() != null) {
					if (contadorPesquisa.getCpf().equals(contadorPesquisaRetornado.getCpf())) {
						Msg.avisoCampoDuplicado("CPF", contadorPesquisa.getCpf());
						getContadorPc().getCpfGui().requestFocus();
						return;
					}
				}

				if (contador.getId() != null && contadorPesquisa.getCpf() != null
						&& contadorPesquisaRetornado.getCpf() != null) {
					if (!contador.getCpf().equals(contadorPesquisa.getCpf())) {
						if (contadorPesquisa.getCpf().equals(contadorPesquisaRetornado.getCpf())) {
							Msg.avisoCampoDuplicado("CPF", contadorPesquisa.getCpf());
							getContadorPc().getCpfGui().requestFocus();
						}
						return;
					}
				}

				contadorPesquisa = new Contador();
				contadorPesquisa.setCnpj(getContadorPc().getCnpjGui().getText());
				contadorPesquisaRetornado = ContadorFac.consultarRegistro(contadorPesquisa);

				if (contador.getId() == null && contadorPesquisa.getCnpj() != null
						&& contadorPesquisaRetornado.getCnpj() != null) {
					if (contadorPesquisa.getCnpj().equals(contadorPesquisaRetornado.getCnpj())) {
						Msg.avisoCampoDuplicado("CNPJ", contadorPesquisa.getCnpj());
						getContadorPc().getCnpjGui().requestFocus();
						return;
					}
				}

				if (contador.getId() != null && contadorPesquisa.getCnpj() != null
						&& contadorPesquisaRetornado.getCnpj() != null) {
					if (!contador.getCnpj().equals(contadorPesquisa.getCnpj())) {
						if (contadorPesquisa.getCnpj().equals(contadorPesquisaRetornado.getCnpj())) {
							Msg.avisoCampoDuplicado("CNPJ", contadorPesquisa.getCnpj());
							getContadorPc().getCnpjGui().requestFocus();
						}
						return;
					}
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					ContadorFac.salvarRegistro(contador);
					contador = new Contador();
					getContadorFc().limparGui();
					getContadorPc().getNomeGui().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroInserirRegistro();
			}
		}
	}

	private Contador contador;

	public void atualizarGui() {
		if (contador == null) {
			return;
		}
		getContadorPc().getCnpjGui().setText(contador.getCnpj());
		getContadorPc().getNomeGui().setText(contador.getNome());
		getContadorPc().getCpfGui().setText(contador.getCpf());
		getContadorPc().getCrcGui().setText(contador.getCrc());
		getContadorPc().getEmailGui().setText(contador.getEmail());
		getContadorPc().getFaxGui().setText(contador.getFax());
		getContadorPc().getFone1Gui().setText(contador.getFone1());
		getContadorPc().getFone2Gui().setText(contador.getFone2());
		getContadorPc().getSiteGui().setText(contador.getSite());
	}

	public void atualizarObjeto() {
		contador.setCnpj(getContadorPc().getCnpjGui().getText());
		contador.setCpf(getContadorPc().getCpfGui().getText());
		contador.setCrc(getContadorPc().getCrcGui().getText());
		contador.setNome(getContadorPc().getNomeGui().getText());
		contador.setEmail(getContadorPc().getEmailGui().getText());
		contador.setFax(getContadorPc().getFaxGui().getText());
		contador.setFone1(getContadorPc().getFone1Gui().getText());
		contador.setFone2(getContadorPc().getFone2Gui().getText());
		contador.setSite(getContadorPc().getSiteGui().getText());
		
		if (contador.getCnpj().equals(Mascara.getCnpjVazio())) {
			contador.setCnpj(null);
		}

		if (contador.getCpf().equals(Mascara.getCpfVazio())) {
			contador.setCpf(null);
		}
		
		if (getContadorPc().getCrcGui().getText().length() == 0) {
			contador.setCrc(null);
		}
	}

	public Contador getContador() {
		return contador;
	}

	public void setContador(Contador contador) {
		this.contador = contador;
	}

	public ContadorFc getContadorFc() {
		return MainCont.getContadorFc();
	}

	public ContadorPc getContadorPc() {
		return MainCont.getContadorFc().getContadorPc();
	}

	public ContadorFp getContadorFp() {
		return MainCont.getContadorFp();
	}

	public ContadorPp getContadorPp() {
		return MainCont.getContadorFp().getContadorPp();
	}
}
