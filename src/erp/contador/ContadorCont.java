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
			getContadorPc().getNomeGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			contador = new Contador();
			atualizarObjeto();
			MainCont.getContadorFp().getContadorPp()
					.pesquisarRegistroContador(contador);

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
				String nome = getContadorPc().getNomeGUI().getText();
				if (nome == null || nome.length() == 0) {
					getContadorPc().getNomeGUI().requestFocus();
					Msg.avisoCampoObrigatorio("Contador");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					ContadorFac.salvarRegistro(contador);
					contador = new Contador();
					getContadorFc().limparGui();
					getContadorPc().getNomeGUI().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroInserirRegistro();
			}
		}
	}

	private Contador contador;

	ContadorCont() {
	}

	public void atualizarGui() {
		if (contador == null) {
			return;
		}
		getContadorPc().getCnpjGUI().setText(contador.getCnpj());
		getContadorPc().getNomeGUI().setText(contador.getNome());
		getContadorPc().getCpfGUI().setText(contador.getCpf());
		getContadorPc().getCrcGUI().setText(contador.getCrc());
		getContadorPc().getEmailGUI().setText(contador.getEmail());
		getContadorPc().getFaxGUI().setText(contador.getFax());
		getContadorPc().getFone1GUI().setText(contador.getFone1());
		getContadorPc().getFone2GUI().setText(contador.getFone2());
		getContadorPc().getSiteGUI().setText(contador.getSite());
	}

	public void atualizarObjeto() {
		contador.setCnpj(getContadorPc().getCnpjGUI().getText());
		contador.setCpf(getContadorPc().getCpfGUI().getText());
		contador.setCrc(getContadorPc().getCrcGUI().getText());
		contador.setNome(getContadorPc().getNomeGUI().getText());
		contador.setEmail(getContadorPc().getEmailGUI().getText());
		contador.setFax(getContadorPc().getFaxGUI().getText());
		contador.setFone1(getContadorPc().getFone1GUI().getText());
		contador.setFone2(getContadorPc().getFone2GUI().getText());
		contador.setSite(getContadorPc().getSiteGUI().getText());
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
