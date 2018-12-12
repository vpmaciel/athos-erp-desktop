package erp.empresa;

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

final class EmpresaCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (empresa == null || empresa.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				EmpresaFac.deletarRegistro(empresa);
				getEmpresaFc().limparGUI();
				empresa = new Empresa();
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
				getEmpresaFc().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getEmpresaFc().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getEmpresaFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			empresa = new Empresa();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				MainCont.mostrarFrame(MainCont.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Empresa> empresas = new LinkedList<>();

			if (empresa.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (empresas.add(EmpresaFac.getRegistro(empresa))) {
					EmpresaRel empresaRel = new EmpresaRel(empresas);
					empresaRel.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Empresa> empresas = new LinkedList<>();

			try {
				empresas = new LinkedList<>(EmpresaFac.pesquisarRegistro(empresa));
			} catch (Exception e) {
				System.out.println(e);
			}
			EmpresaRel empresaRel = new EmpresaRel(empresas);
			empresaRel.retornarRelatorio(true);
		}
	}

	public class MostraFrameEmpresa extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainCont.mostrarFrame(getEmpresaFc());
			} else {
				getEmpresaFc().reiniciarGUI();
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			empresa = new Empresa();
			getEmpresaFc().limparGUI();
			getEmpresaPc().getNomeFantasiaGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			empresa = new Empresa();
			atualizarObjeto();
			getEmpresaPp().pesquisarRegistroEmpresa(empresa);
			MainCont.mostrarFrame(getEmpresaFp());
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
				String nomeFantasia = getEmpresaPc().getNomeFantasiaGUI().getText();
				if (nomeFantasia == null || nomeFantasia.length() == 0) {
					getEmpresaPc().getNomeFantasiaGUI().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					EmpresaFac.salvarRegistro(empresa);
					empresa = new Empresa();
					getEmpresaFc().limparGUI();
					getEmpresaPc().getNomeFantasiaGUI().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private Empresa empresa;

	public void atualizarGui() {
		if (empresa == null) {
			return;
		}
		getEmpresaPc().getNomeFantasiaGUI().setText(empresa.getNomeFantasia());
		getEmpresaPc().getNumeroFuncionariosGUI().setText(empresa.getNumeroFuncionarios());
		getEmpresaPc().getRamoAtividadeGUI().setText(empresa.getRamoAtividade());
		getEmpresaPc().getNomeFantasiaGUI().setText(empresa.getNomeFantasia());
		getEmpresaPc().getRazaoSocialGUI().setText(empresa.getRazaoSocial());
		getEmpresaPc().getEmailGUI().setText(empresa.getEmail());
		getEmpresaPc().getFaxGUI().setText(empresa.getFax());
		getEmpresaPc().getFone1GUI().setText(empresa.getFone1());
		getEmpresaPc().getFone2GUI().setText(empresa.getFone2());
		getEmpresaPc().getInscricaoEstadualGUI().setText(empresa.getInscricaoEstadual());
		getEmpresaPc().getInscricaoMunicipalGUI().setText(empresa.getInscricaoMunicipal());
		getEmpresaPc().getCapitalSocialGUI().setText(empresa.getCapitalSocial());
		getEmpresaPc().getDataFundacaoGUI().setText(empresa.getDataFundacao());
		getEmpresaPc().getBairroGUI().setText(empresa.getBairro());
		getEmpresaPc().getCepGUI().setText(empresa.getCep());
		getEmpresaPc().getCidadeGUI().setText(empresa.getCidade());
		getEmpresaPc().getComplementoGUI().setText(empresa.getComplemento());
		getEmpresaPc().getEstadoGUI().setText(empresa.getEstado());
		getEmpresaPc().getLogradouroGUI().setText(empresa.getLogradouro());
		getEmpresaPc().getPaisGUI().setText(empresa.getPais());
		getEmpresaPc().getCnpjGUI().setText(empresa.getCnpj());
		getEmpresaPc().getEmpresaGUI().setSelectedItem(empresa.getTipoEmpresa());
		getEmpresaPc().getFaturamentoMensalGUI().setText(empresa.getFaturamentoMensal());
	}

	public void atualizarObjeto() {
		empresa.setNomeFantasia(getEmpresaPc().getNomeFantasiaGUI().getText());
		empresa.setNumeroFuncionarios(getEmpresaPc().getNumeroFuncionariosGUI().getText());
		empresa.setRamoAtividade(getEmpresaPc().getRamoAtividadeGUI().getText());
		empresa.setNomeFantasia(getEmpresaPc().getNomeFantasiaGUI().getText());
		empresa.setRazaoSocial(getEmpresaPc().getRazaoSocialGUI().getText());
		empresa.setEmail(getEmpresaPc().getEmailGUI().getText());
		empresa.setFax(getEmpresaPc().getFaxGUI().getText());
		empresa.setFone1(getEmpresaPc().getFone1GUI().getText());
		empresa.setFone2(getEmpresaPc().getFone2GUI().getText());
		empresa.setInscricaoEstadual(getEmpresaPc().getInscricaoEstadualGUI().getText());
		empresa.setInscricaoMunicipal(getEmpresaPc().getInscricaoMunicipalGUI().getText());
		empresa.setCapitalSocial(getEmpresaPc().getCapitalSocialGUI().getText());
		empresa.setDataFundacao(getEmpresaPc().getDataFundacaoGUI().getText());
		empresa.setBairro(getEmpresaPc().getBairroGUI().getText());
		empresa.setCep(getEmpresaPc().getCepGUI().getText());
		empresa.setCidade(getEmpresaPc().getCidadeGUI().getText());
		empresa.setComplemento(getEmpresaPc().getComplementoGUI().getText());
		empresa.setEstado(getEmpresaPc().getEstadoGUI().getText());
		empresa.setLogradouro(getEmpresaPc().getLogradouroGUI().getText());
		empresa.setPais(getEmpresaPc().getPaisGUI().getText());
		empresa.setCnpj(getEmpresaPc().getCnpjGUI().getText());
		empresa.setTipoEmpresa((String) getEmpresaPc().getEmpresaGUI().getSelectedItem());
		empresa.setFaturamentoMensal(getEmpresaPc().getFaturamentoMensalGUI().getText());
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public EmpresaFc getEmpresaFc() {
		return MainCont.getEmpresaFc();
	}

	public EmpresaPc getEmpresaPc() {
		return MainCont.getEmpresaFc().getEmpresaPc();
	}

	public EmpresaFp getEmpresaFp() {
		return MainCont.getEmpresaFp();
	}

	public EmpresaPp getEmpresaPp() {
		return MainCont.getEmpresaFp().getEmpresaPp();
	}
}
