package erp.curriculo.caracteristica;

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
import erp.funcionario.Funcionario;
import erp.main.MainCont;

final class CaracteristicaCont {

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {

		}
	}

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (caracteristica == null || caracteristica.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				CaracteristicaFac.deletarRegistro(caracteristica);
				getCaracteristicaFc().limparGui();
				caracteristica = new Caracteristica();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getCaracteristicaFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getCaracteristicaFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getCaracteristicaFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			caracteristica = new Caracteristica();
			getCaracteristicaPc().getAdequadoGui().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainCont.mostrarFrame(MainCont.getMainFc());
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Caracteristica> Caracteristicas = new LinkedList<>();

			try {
				Caracteristicas = new LinkedList<>(CaracteristicaFac.pesquisarRegistro(new Caracteristica()));
			} catch (Exception e) {
				System.out.println(e);
			}
			CaracteristicaRel CaracteristicaRel = new CaracteristicaRel(Caracteristicas);
			CaracteristicaRel.retornarRelatorio(true);
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Caracteristica> Caracteristicas = new LinkedList<>();

			if (caracteristica.getFuncionario() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (Caracteristicas.add(CaracteristicaFac.getRegistro(caracteristica))) {
				CaracteristicaRel CaracteristicaRel = new CaracteristicaRel(Caracteristicas);
				CaracteristicaRel.retornarRelatorio(true);
			}

		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			caracteristica = new Caracteristica();
			getCaracteristicaFc().limparGui();
			getCaracteristicaPc().getAdequadoGui().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getCaracteristicaPp().pesquisarRegistroCaracteristica(caracteristica);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getCaracteristicaFp());
			}
		}
	}

	public class SaidaSistema implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (Msg.confirmarSairDoSistema() == JOptionPane.YES_OPTION) {
				System.exit(0);
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
				if ((getCaracteristicaPc().getFuncionarioGui().getSelectedItem()) == null) {
					getCaracteristicaPc().getFuncionarioGui().requestFocus();
					Msg.avisoCampoObrigatorio("FUNCIONÁRIO");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					CaracteristicaFac.salvarRegistro(caracteristica);
					caracteristica = new Caracteristica();
					getCaracteristicaFc().limparGui();
					getCaracteristicaPc().getAdequadoGui().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private Caracteristica caracteristica;

	public void atualizarGui() {
		if (caracteristica == null) {
			return;
		}
		getCaracteristicaPc().getFuncionarioGui().setSelectedItem(caracteristica.getFuncionario());
		getCaracteristicaPc().getAdequadoGui().setSelectedItem(caracteristica.getAdequado());
		getCaracteristicaPc().getAgilGui().setSelectedItem(caracteristica.getAgil());
		getCaracteristicaPc().getAgitadoGui().setSelectedItem(caracteristica.getAgitado());
		getCaracteristicaPc().getAlegreGui().setSelectedItem(caracteristica.getAlegre());
		getCaracteristicaPc().getAmavelGui().setSelectedItem(caracteristica.getAmavel());
		getCaracteristicaPc().getAnaliticoGui().setSelectedItem(caracteristica.getAnalitico());
		getCaracteristicaPc().getAnimadoGui().setSelectedItem(caracteristica.getAnimado());
		getCaracteristicaPc().getAnsiosoGui().setSelectedItem(caracteristica.getAnsioso());
		getCaracteristicaPc().getApaticoGui().setSelectedItem(caracteristica.getApatico());
		getCaracteristicaPc().getArticuladoGui().setSelectedItem(caracteristica.getArticulado());
		getCaracteristicaPc().getAssumeRiscosCalculadosGui()
				.setSelectedItem(caracteristica.getAssumeRiscosCalculados());
		getCaracteristicaPc().getAtenciosoGui().setSelectedItem(caracteristica.getAtencioso());
		getCaracteristicaPc().getAtivoGui().setSelectedItem(caracteristica.getAtivo());
		getCaracteristicaPc().getAutoConfianteGui().setSelectedItem(caracteristica.getAutoConfiante());
		getCaracteristicaPc().getAventureiroGui().setSelectedItem(caracteristica.getAventureiro());
	}

	public void atualizarObjeto() {
		caracteristica.setFuncionario((Funcionario) getCaracteristicaPc().getFuncionarioGui().getSelectedItem());
		caracteristica.setAdequado((String) getCaracteristicaPc().getAdequadoGui().getSelectedItem());
		caracteristica.setAgil((String) getCaracteristicaPc().getAgilGui().getSelectedItem());
		caracteristica.setAgitado((String) getCaracteristicaPc().getAgitadoGui().getSelectedItem());
		caracteristica.setAlegre((String) getCaracteristicaPc().getAlegreGui().getSelectedItem());
		caracteristica.setAmavel((String) getCaracteristicaPc().getAmavelGui().getSelectedItem());
		caracteristica.setAnalitico((String) getCaracteristicaPc().getAnaliticoGui().getSelectedItem());
		caracteristica.setAnimado((String) getCaracteristicaPc().getAnimadoGui().getSelectedItem());
		caracteristica.setAnsioso((String) getCaracteristicaPc().getAnsiosoGui().getSelectedItem());
		caracteristica.setApatico((String) getCaracteristicaPc().getApaticoGui().getSelectedItem());
		caracteristica.setArticulado((String) getCaracteristicaPc().getArticuladoGui().getSelectedItem());
		caracteristica.setAssumeRiscosCalculados(
				(String) getCaracteristicaPc().getAssumeRiscosCalculadosGui().getSelectedItem());
		caracteristica.setAtencioso((String) getCaracteristicaPc().getAtenciosoGui().getSelectedItem());
		caracteristica.setAtivo((String) getCaracteristicaPc().getAtivoGui().getSelectedItem());
		caracteristica.setAutoconfiante((String) getCaracteristicaPc().getAutoConfianteGui().getSelectedItem());
		caracteristica.setAventureiro((String) getCaracteristicaPc().getAventureiroGui().getSelectedItem());
	}

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Caracteristica Caracteristica) {
		this.caracteristica = Caracteristica;
	}

	public CaracteristicaFc getCaracteristicaFc() {
		return MainCont.getCurriculoCaracteristicaFc();
	}

	public CaracteristicaPc getCaracteristicaPc() {
		return MainCont.getCurriculoCaracteristicaFc().getCaracteristicaPc();
	}

	public CaracteristicaFp getCaracteristicaFp() {
		return MainCont.getCurriculoCaracteristicaFp();
	}

	public CaracteristicaPp getCaracteristicaPp() {
		return MainCont.getCurriculoCaracteristicaFp().getCertificadoPp();
	}
}
