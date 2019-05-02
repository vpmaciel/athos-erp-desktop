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
import erp.main.MainFc;

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

			try {
				contadors = new LinkedList<>(ContadorFac.pesquisarRegistro(new Contador()));
			} catch (Exception e) {
				System.out.println(e);
			}

			ContadorRel contadorRel = new ContadorRel(contadors);
			contadorRel.retornarRelatorio(true);

		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Contador> contadors = new LinkedList<>();

			if (contador.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (contadors.add(ContadorFac.getRegistro(contador))) {
				ContadorRel contadorRel = new ContadorRel(contadors);
				contadorRel.retornarRelatorio(true);
			}
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
			getContadorPc().getGuiNome().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getContadorPp().pesquisarRegistroContador(contador);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainFc.mostrarFrame(getContadorFp());
			}
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
				String nome = getContadorPc().getGuiNome().getText();
				if (nome == null || nome.length() == 0) {
					getContadorPc().getGuiNome().requestFocus();
					Msg.avisoCampoObrigatorio("Contador");
					return;
				}

				Contador contadorPesquisa = new Contador();
				contadorPesquisa.setCrc(getContadorPc().getGuiCrc().getText());
				Contador contadorPesquisaRetornado = ContadorFac.consultarRegistro(contadorPesquisa);

				if (contador.getId() == null && contadorPesquisa.getCrc() != null
						&& contadorPesquisaRetornado.getCrc() != null) {
					if (contadorPesquisa.getCrc().equals(contadorPesquisaRetornado.getCrc())) {
						Msg.avisoCampoDuplicado("CRC", contadorPesquisa.getCrc());
						getContadorPc().getGuiCrc().requestFocus();
						return;
					}
				}

				if (contador.getId() != null && contadorPesquisa.getCrc() != null
						&& contadorPesquisaRetornado.getCrc() != null) {
					if (!contador.getCrc().equals(contadorPesquisa.getCrc())) {
						if (contadorPesquisa.getCrc().equals(contadorPesquisaRetornado.getCrc())) {
							Msg.avisoCampoDuplicado("CRC", contadorPesquisa.getCrc());
							getContadorPc().getGuiCrc().requestFocus();
						}
						return;
					}
				}

				contadorPesquisa = new Contador();
				contadorPesquisa.setCpf(getContadorPc().getGuiCpf().getText());
				contadorPesquisaRetornado = ContadorFac.consultarRegistro(contadorPesquisa);

				if (contador.getId() == null && contadorPesquisa.getCpf() != null
						&& contadorPesquisaRetornado.getCpf() != null) {
					if (contadorPesquisa.getCpf().equals(contadorPesquisaRetornado.getCpf())) {
						Msg.avisoCampoDuplicado("CPF", contadorPesquisa.getCpf());
						getContadorPc().getGuiCpf().requestFocus();
						return;
					}
				}

				if (contador.getId() != null && contadorPesquisa.getCpf() != null
						&& contadorPesquisaRetornado.getCpf() != null) {
					if (!contador.getCpf().equals(contadorPesquisa.getCpf())) {
						if (contadorPesquisa.getCpf().equals(contadorPesquisaRetornado.getCpf())) {
							Msg.avisoCampoDuplicado("CPF", contadorPesquisa.getCpf());
							getContadorPc().getGuiCpf().requestFocus();
						}
						return;
					}
				}

				contadorPesquisa = new Contador();
				contadorPesquisa.setCnpj(getContadorPc().getGuiCnpj().getText());
				contadorPesquisaRetornado = ContadorFac.consultarRegistro(contadorPesquisa);

				if (contador.getId() == null && contadorPesquisa.getCnpj() != null
						&& contadorPesquisaRetornado.getCnpj() != null) {
					if (contadorPesquisa.getCnpj().equals(contadorPesquisaRetornado.getCnpj())) {
						Msg.avisoCampoDuplicado("CNPJ", contadorPesquisa.getCnpj());
						getContadorPc().getGuiCnpj().requestFocus();
						return;
					}
				}

				if (contador.getId() != null && contadorPesquisa.getCnpj() != null
						&& contadorPesquisaRetornado.getCnpj() != null) {
					if (!contador.getCnpj().equals(contadorPesquisa.getCnpj())) {
						if (contadorPesquisa.getCnpj().equals(contadorPesquisaRetornado.getCnpj())) {
							Msg.avisoCampoDuplicado("CNPJ", contadorPesquisa.getCnpj());
							getContadorPc().getGuiCnpj().requestFocus();
						}
						return;
					}
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					ContadorFac.salvarRegistro(contador);
					contador = new Contador();
					getContadorFc().limparGui();
					getContadorPc().getGuiNome().requestFocus();
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
		getContadorPc().getGuiCnpj().setText(contador.getCnpj());
		getContadorPc().getGuiNome().setText(contador.getNome());
		getContadorPc().getGuiCpf().setText(contador.getCpf());
		getContadorPc().getGuiCrc().setText(contador.getCrc());
		getContadorPc().getGuiEmail().setText(contador.getEmail());
		getContadorPc().getGuiFax().setText(contador.getFax());
		getContadorPc().getGuiFone1().setText(contador.getFone1());
		getContadorPc().getGuiFone2().setText(contador.getFone2());
		getContadorPc().getGuiSite().setText(contador.getSite());
	}

	public void atualizarObjeto() {
		contador.setCnpj(getContadorPc().getGuiCnpj().getText());
		contador.setCpf(getContadorPc().getGuiCpf().getText());
		contador.setCrc(getContadorPc().getGuiCrc().getText());
		contador.setNome(getContadorPc().getGuiNome().getText());
		contador.setEmail(getContadorPc().getGuiEmail().getText());
		contador.setFax(getContadorPc().getGuiFax().getText());
		contador.setFone1(getContadorPc().getGuiFone1().getText());
		contador.setFone2(getContadorPc().getGuiFone2().getText());
		contador.setSite(getContadorPc().getGuiSite().getText());
		
		if (contador.getCnpj().equals(Mascara.getCnpjVazio())) {
			contador.setCnpj(null);
		}

		if (contador.getCpf().equals(Mascara.getCpfVazio())) {
			contador.setCpf(null);
		}
		
		if (getContadorPc().getGuiCrc().getText().length() == 0) {
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
