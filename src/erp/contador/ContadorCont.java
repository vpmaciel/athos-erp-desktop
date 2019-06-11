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
				e.printStackTrace();
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
				e.printStackTrace();
			}
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
			totalPesquisaRegistro = getContadorPp().pesquisarRegistro(contador);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getContadorFp());
				getContadorFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getContadorPp().pesquisarRegistro(new Contador());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getContadorFp());
				getContadorFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
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
				e.printStackTrace();
			}

			ContadorRel contadorRel = new ContadorRel(contadors);
			contadorRel.retornarRelatorio(true);

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
				String nome = getContadorPc().getGuiNome().getText();
				if (nome == null || nome.length() == 0) {
					getContadorPc().getGuiNome().requestFocus();
					Msg.avisoCampoObrigatorio("Contador");
					return;
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
				Throwable throwable = e.getCause().getCause();
				String mensagem = throwable.toString();
				if (mensagem.contains("ConstraintViolationException")) {
					if (mensagem.contains("INDEX_CONTADOR_CRC")) {
						Msg.avisoCampoDuplicado("CRC");
						getContadorPc().getGuiCrc().requestFocus();
					} else if (mensagem.contains("INDEX_CONTADOR_CPF")) {
						Msg.avisoCampoDuplicado("CPF");
						getContadorPc().getGuiCpf().requestFocus();
					} else if (mensagem.contains("INDEX_CONTADOR_CNPJ")) {
						Msg.avisoCampoDuplicado("CNPJ");
						getContadorPc().getGuiCnpj().requestFocus();
					} else {
						Msg.avisoCampoDuplicado();
					}
				}
				e.printStackTrace();
				Msg.erroSalvarRegistro();
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

	public ContadorFc getContadorFc() {
		return MainCont.getContadorFc();
	}

	public ContadorFp getContadorFp() {
		return MainCont.getContadorFp();
	}

	public ContadorPc getContadorPc() {
		return MainCont.getContadorFc().getContadorPc();
	}

	public ContadorPp getContadorPp() {
		return MainCont.getContadorFp().getContadorPp();
	}

	public void setContador(Contador contador) {
		this.contador = contador;
	}
}
