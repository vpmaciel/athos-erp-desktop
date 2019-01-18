package erp.agenda.recado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainCont;

final class RecadoCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (recado == null || recado.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				RecadoFac.deletarRegistro(recado);
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
				getRecadoFc().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getRecadoFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getRecadoFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			recado = new Recado();
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

			List<Recado> recados = new LinkedList<>();

			try {
				recados = new LinkedList<>(RecadoFac.pesquisarRegistro(new Recado()));
			} catch (Exception e) {
				System.out.println(e);
			}

			RecadoRel recadoRel = new RecadoRel(recados);
			recadoRel.retornarRelatorio(true);

		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Recado> recados = new LinkedList<>();

			if (recado.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (recados.add(RecadoFac.getRegistro(recado))) {
				RecadoRel recadoRel = new RecadoRel(recados);
				recadoRel.retornarRelatorio(true);
			}

		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			recado = new Recado();
			getRecadoFc().limparGui();
			getRecadoPc().getDataGui().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			recado = new Recado();
			atualizarObjeto();
			getRecadoPp().pesquisarRegistroRecado(recado);
			MainCont.mostrarFrame(MainCont.getAgendaRecadoFp());
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
				String data = getRecadoPc().getDataGui().getText();
				if (data == null || data.length() == 0) {
					getRecadoPc().getDataGui().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					RecadoFac.salvarRegistro(recado);
					recado = new Recado();
					MainCont.getAgendaRecadoFc().limparGui();
					getRecadoPc().getDataGui().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroInserirRegistro();
			}
		}
	}

	private Recado recado;

	public void atualizarGui() {
		if (recado == null) {
			return;
		}
		getRecadoPc().getRemetenteGui().setText(recado.getRemetente());
		getRecadoPc().getDataGui().setText(recado.getData());
		getRecadoPc().getRecadoGui().setText(recado.getRecado());
		getRecadoPc().getDestinatarioGui().setText(recado.getDestinatario());
	}

	public void atualizarObjeto() {
		recado.setRemetente(getRecadoPc().getRemetenteGui().getText());
		recado.setData(getRecadoPc().getDataGui().getText());
		recado.setRecado(getRecadoPc().getRecadoGui().getText());
		recado.setDestinatario(getRecadoPc().getDestinatarioGui().getText());
	}

	public Recado getRecado() {
		return recado;
	}

	public void setRecado(Recado recado) {
		this.recado = recado;
	}

	public RecadoFc getRecadoFc() {
		return MainCont.getAgendaRecadoFc();
	}

	public RecadoPc getRecadoPc() {
		return MainCont.getAgendaRecadoFc().getRecadoPc();
	}

	public RecadoFp getRecadoFp() {
		return MainCont.getAgendaRecadoFp();
	}

	public RecadoPp getRecadoPp() {
		return MainCont.getAgendaRecadoFp().getRecadoPp();
	}
}
