package erp.curriculo.certificado;

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

final class CertificadoCont {

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getCertificadoPc().getLabelFuncionario()) {
				MainCont.mostrarFrame(MainCont.getFuncionarioFc());
			}
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
			if (certificado == null || certificado.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				CertificadoFac.deletarRegistro(certificado);
				getCertificadoFc().limparGui();
				certificado = new Certificado();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getCertificadoFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getCertificadoFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getCertificadoFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			certificado = new Certificado();
			getCertificadoPc().getGuiFuncionario().requestFocus();
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

			List<Certificado> certificados = new LinkedList<>();

			try {
				certificados = new LinkedList<>(CertificadoFac.pesquisarRegistro(new Certificado()));
			} catch (Exception e) {
				System.out.println(e);
			}

			CertificadoRel certificadoRel = new CertificadoRel(certificados);
			certificadoRel.retornarRelatorio(true);

		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Certificado> certificados = new LinkedList<>();

			if (certificado.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (certificados.add(CertificadoFac.getRegistro(certificado))) {
				CertificadoRel certificadoRel = new CertificadoRel(certificados);
				certificadoRel.retornarRelatorio(true);
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			certificado = new Certificado();
			getCertificadoFc().limparGui();
			getCertificadoPc().getGuiFuncionario().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getCertificadoPp().pesquisarRegistroCaracteristica(certificado);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getCertificadoFp());
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
				if ((getCertificadoPc().getGuiFuncionario().getSelectedItem()) == null) {
					getCertificadoPc().getGuiFuncionario().requestFocus();
					Msg.avisoCampoObrigatorio("FUNCIONÁRIO");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					CertificadoFac.salvarRegistro(certificado);
					certificado = new Certificado();
					getCertificadoFc().limparGui();
					getCertificadoPc().getGuiFuncionario().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private Certificado certificado;

	public void atualizarGui() {
		if (certificado == null) {
			return;
		}
		getCertificadoPc().getGuiFuncionario().setSelectedItem(certificado.getFuncionario());
		getCertificadoPc().getGuiAnoConclusao().setText(certificado.getAnoConclusao());
		getCertificadoPc().getGuiCurso().setText(certificado.getCurso());
		getCertificadoPc().getGuiInstituicao().setText(certificado.getInstituicao());
		getCertificadoPc().getGuiCargaHoraria().setText(String.valueOf(certificado.getCargaHoraria()));
	}

	public void atualizarObjeto() {
		certificado.setFuncionario((Funcionario) getCertificadoPc().getGuiFuncionario().getSelectedItem());
		certificado.setAnoConclusao(getCertificadoPc().getGuiAnoConclusao().getText());
		if (!getCertificadoPc().getGuiCargaHoraria().getText().equals("")) {
			try {
				certificado.setCargaHoraria(Double.parseDouble(getCertificadoPc().getGuiCargaHoraria().getText()));
			} catch (NumberFormatException e) {
				certificado.setCargaHoraria(0.0);
			}
		}
		certificado.setCurso(getCertificadoPc().getGuiCurso().getText());
		certificado.setInstituicao(getCertificadoPc().getGuiInstituicao().getText());
	}

	public Certificado getCertificado() {
		return certificado;
	}

	public void setCertificado(Certificado Certificado) {
		this.certificado = Certificado;
	}

	public CertificadoFc getCertificadoFc() {
		return MainCont.getCurriculoCertificadoFc();
	}

	public CertificadoPc getCertificadoPc() {
		return MainCont.getCurriculoCertificadoFc().getCertificadoPc();
	}

	public CertificadoFp getCertificadoFp() {
		return MainCont.getCurriculoCertificadoFp();
	}

	public CertificadoPp getCertificadoPp() {
		return MainCont.getCurriculoCertificadoFp().getCertificadoPp();
	}
}
