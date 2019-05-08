package erp.curriculo.testepersonalidade.c;

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

final class TesteCCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (testeC == null || testeC.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				TesteCFac.deletarRegistro(testeC);
				getTesteCFc().limparGui();
				testeC = new TesteC();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getTesteCFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getTesteCFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getTesteCFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			testeC = new TesteC();
			getTesteCPc().getGuiAdequado().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainCont.mostrarFrame(MainCont.getMainFc());
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<TesteC> testeCs = new LinkedList<>();

			if (testeC.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (testeCs.add(TesteCFac.getRegistro(testeC))) {
				TesteCRel testeCRel = new TesteCRel(testeCs);
				testeCRel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getTesteCPc().getLabelFuncionario()) {
				MainCont.mostrarFrame(MainCont.getFuncionarioFc());
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			testeC = new TesteC();
			getTesteCFc().limparGui();
			getTesteCPc().getGuiAdequado().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getTesteCPp().pesquisarRegistroTesteC(testeC);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getTesteCFp());
				getTesteCFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<TesteC> testeCs = new LinkedList<>();

			try {
				testeCs = new LinkedList<>(TesteCFac.pesquisarRegistro(new TesteC()));
			} catch (Exception e) {
				System.out.println(e);
			}

			TesteCRel testeCRel = new TesteCRel(testeCs);
			testeCRel.retornarRelatorio(true);

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
				if ((getTesteCPc().getGuiFuncionario().getSelectedItem()) == null) {
					getTesteCPc().getGuiFuncionario().requestFocus();
					Msg.avisoCampoObrigatorio("FUNCIONÁRIO");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					TesteCFac.salvarRegistro(testeC);
					testeC = new TesteC();
					getTesteCFc().limparGui();
					getTesteCPc().getGuiAdequado().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private TesteC testeC;

	public void atualizarGui() {
		if (testeC == null) {
			return;
		}
		getTesteCPc().getGuiFuncionario().setSelectedItem(testeC.getFuncionario());
		getTesteCPc().getGuiAdequado().setSelectedItem(testeC.getAdequado());
		getTesteCPc().getGuiAgil().setSelectedItem(testeC.getAgil());
		getTesteCPc().getGuiAgitado().setSelectedItem(testeC.getAgitado());
		getTesteCPc().getGuiAlegre().setSelectedItem(testeC.getAlegre());
		getTesteCPc().getGuiAmavel().setSelectedItem(testeC.getAmavel());
		getTesteCPc().getGuiAnalitico().setSelectedItem(testeC.getAnalitico());
		getTesteCPc().getGuiAnimado().setSelectedItem(testeC.getAnimado());
		getTesteCPc().getGuiAnsioso().setSelectedItem(testeC.getAnsioso());
		getTesteCPc().getGuiApatico().setSelectedItem(testeC.getApatico());
		getTesteCPc().getGuiArticulado().setSelectedItem(testeC.getArticulado());
		getTesteCPc().getGuiAssumeRiscosCalculados()
				.setSelectedItem(testeC.getAssumeRiscosCalculados());
		getTesteCPc().getGuiAtencioso().setSelectedItem(testeC.getAtencioso());
		getTesteCPc().getGuiAtivo().setSelectedItem(testeC.getAtivo());
		getTesteCPc().getGuiAutoConfiante().setSelectedItem(testeC.getAutoConfiante());
		getTesteCPc().getGuiAventureiro().setSelectedItem(testeC.getAventureiro());
		getTesteCPc().getGuiBemHumorado().setSelectedItem(testeC.getBemHumorado());
		getTesteCPc().getGuiCalmo().setSelectedItem(testeC.getCalmo());
		getTesteCPc().getGuiCarismatico().setSelectedItem(testeC.getCarismatico());
		getTesteCPc().getGuiCauteloso().setSelectedItem(testeC.getCauteloso());
		getTesteCPc().getGuiCompetitivo().setSelectedItem(testeC.getCompetitivo());
		getTesteCPc().getGuiCompreensivo().setSelectedItem(testeC.getCompreensivo());
		getTesteCPc().getGuiConciliador().setSelectedItem(testeC.getConciliador());
		getTesteCPc().getGuiContido().setSelectedItem(testeC.getContido());
		getTesteCPc().getGuiConvencional().setSelectedItem(testeC.getConvencional());
		getTesteCPc().getGuiConvincente().setSelectedItem(testeC.getConvincente());
		getTesteCPc().getGuiCortes().setSelectedItem(testeC.getCortes());
		getTesteCPc().getGuiCuidadoso().setSelectedItem(testeC.getCuidadoso());
		getTesteCPc().getGuiDecidido().setSelectedItem(testeC.getDecidido());
		getTesteCPc().getGuiDedicado().setSelectedItem(testeC.getDedicado());
		getTesteCPc().getGuiDependente().setSelectedItem(testeC.getDependente());
		getTesteCPc().getGuiDesconfiado().setSelectedItem(testeC.getDesconfiado());
		getTesteCPc().getGuiDescrente().setSelectedItem(testeC.getDescrente());
		getTesteCPc().getGuiDesencanado().setSelectedItem(testeC.getDesencanado());
		getTesteCPc().getGuiDesligado().setSelectedItem(testeC.getDesligado());
		getTesteCPc().getGuiDespretensioso().setSelectedItem(testeC.getDespretensioso());
		getTesteCPc().getGuiDesprendido().setSelectedItem(testeC.getDesprendido());
		getTesteCPc().getGuiDestemido().setSelectedItem(testeC.getDestemido());
		getTesteCPc().getGuiDeterminado().setSelectedItem(testeC.getDeterminado());
		getTesteCPc().getGuiDiplomatico().setSelectedItem(testeC.getDiplomatico());
		getTesteCPc().getGuiDireto().setSelectedItem(testeC.getDireto());
		getTesteCPc().getGuiDisciplinado().setSelectedItem(testeC.getDisciplinado());
		getTesteCPc().getGuiDiscreto().setSelectedItem(testeC.getDiscreto());
		getTesteCPc().getGuiDisponivel().setSelectedItem(testeC.getDisponivel());
		getTesteCPc().getGuiDivertido().setSelectedItem(testeC.getDivertido());
		getTesteCPc().getGuiDominador().setSelectedItem(testeC.getDominador());
		getTesteCPc().getGuiEgocentrico().setSelectedItem(testeC.getEgocentrico());
		getTesteCPc().getGuiEmpolgado().setSelectedItem(testeC.getEmpolgado());
		getTesteCPc().getGuiEncantador().setSelectedItem(testeC.getEncantador());
		getTesteCPc().getGuiEnergico().setSelectedItem(testeC.getEnergico());
		getTesteCPc().getGuiEspontaneo().setSelectedItem(testeC.getEspontaneo());
		getTesteCPc().getGuiEstavel().setSelectedItem(testeC.getEstavel());
		getTesteCPc().getGuiExigente().setSelectedItem(testeC.getExigente());
		getTesteCPc().getGuiExpansivo().setSelectedItem(testeC.getExpansivo());
		getTesteCPc().getGuiExpressivo().setSelectedItem(testeC.getExpressivo());
		getTesteCPc().getGuiExtrovertido().setSelectedItem(testeC.getExtrovertido());
		getTesteCPc().getGuiFechado().setSelectedItem(testeC.getFechado());
		getTesteCPc().getGuiFirme().setSelectedItem(testeC.getFirme());
		getTesteCPc().getGuiFuncionario().setSelectedItem(testeC.getFuncionario());
		getTesteCPc().getGuiGostaDeSeArriscar().setSelectedItem(testeC.getGostaDeSeArriscar());
		getTesteCPc().getGuiHumilde().setSelectedItem(testeC.getHumilde());
		getTesteCPc().getGuiImpulsivo().setSelectedItem(testeC.getImpulsivo());
		getTesteCPc().getGuiIncerto().setSelectedItem(testeC.getIncerto());
		getTesteCPc().getGuiIndependente().setSelectedItem(testeC.getIndependente());
		getTesteCPc().getGuiIndiferente().setSelectedItem(testeC.getIndiferente());
		getTesteCPc().getGuiInfluente().setSelectedItem(testeC.getInfluente());
		getTesteCPc().getGuiInquieto().setSelectedItem(testeC.getInquieto());
		getTesteCPc().getGuiInspirador().setSelectedItem(testeC.getInspirador());
		getTesteCPc().getGuiInteressado().setSelectedItem(testeC.getInteressado());
		getTesteCPc().getGuiIntrospectivo().setSelectedItem(testeC.getIntrospectivo());
		getTesteCPc().getGuiJusto().setSelectedItem(testeC.getJusto());
		getTesteCPc().getGuiLeal().setSelectedItem(testeC.getLeal());
		getTesteCPc().getGuiLiberal().setSelectedItem(testeC.getLiberal());
		getTesteCPc().getGuiLivre().setSelectedItem(testeC.getLivre());
		getTesteCPc().getGuiLogico().setSelectedItem(testeC.getLogico());
		getTesteCPc().getGuiMaleavel().setSelectedItem(testeC.getMaleavel());
		getTesteCPc().getGuiMenteAberta().setSelectedItem(testeC.getMenteAberta());
		getTesteCPc().getGuiMeticuloso().setSelectedItem(testeC.getMeticuloso());
		getTesteCPc().getGuiObediente().setSelectedItem(testeC.getObediente());
		getTesteCPc().getGuiObjetivo().setSelectedItem(testeC.getObjetivo());
		getTesteCPc().getGuiObservador().setSelectedItem(testeC.getObservador());
		getTesteCPc().getGuiObstinado().setSelectedItem(testeC.getObstinado());
		getTesteCPc().getGuiOriginal().setSelectedItem(testeC.getOriginal());
		getTesteCPc().getGuiOusado().setSelectedItem(testeC.getOusado());
		getTesteCPc().getGuiPaciente().setSelectedItem(testeC.getPaciente());
		getTesteCPc().getGuiPacifico().setSelectedItem(testeC.getPacifico());
		getTesteCPc().getGuiPassivo().setSelectedItem(testeC.getPassivo());
		getTesteCPc().getGuiPerfeccionista().setSelectedItem(testeC.getPerfeccionista());
		getTesteCPc().getGuiPersistente().setSelectedItem(testeC.getPersistente());
		getTesteCPc().getGuiPersuasivo().setSelectedItem(testeC.getPersuasivo());
		getTesteCPc().getGuiPessimista().setSelectedItem(testeC.getPessimista());
		getTesteCPc().getGuiPonderado().setSelectedItem(testeC.getPonderado());
		getTesteCPc().getGuiPratico().setSelectedItem(testeC.getPratico());
		getTesteCPc().getGuiPrecavido().setSelectedItem(testeC.getPrecavido());
		getTesteCPc().getGuiPreciso().setSelectedItem(testeC.getPreciso());
		getTesteCPc().getGuiPreocupado().setSelectedItem(testeC.getPreocupado());
		getTesteCPc().getGuiPrevenido().setSelectedItem(testeC.getPrevenido());
		getTesteCPc().getGuiPrevisivel().setSelectedItem(testeC.getPrevisivel());
		getTesteCPc().getGuiRealista().setSelectedItem(testeC.getRealista());
		getTesteCPc().getGuiRebelde().setSelectedItem(testeC.getRebelde());
		getTesteCPc().getGuiReceoso().setSelectedItem(testeC.getReceoso());
		getTesteCPc().getGuiReservado().setSelectedItem(testeC.getReservado());
		getTesteCPc().getGuiRespeitoso().setSelectedItem(testeC.getRespeitoso());
		getTesteCPc().getGuiSarcastico().setSelectedItem(testeC.getSarcastico());
		getTesteCPc().getGuiSeguro().setSelectedItem(testeC.getSeguro());
		getTesteCPc().getGuiSemLimites().setSelectedItem(testeC.getSemLimites());
		getTesteCPc().getGuiSensato().setSelectedItem(testeC.getSensato());
		getTesteCPc().getGuiSereno().setSelectedItem(testeC.getSereno());
		getTesteCPc().getGuiSerio().setSelectedItem(testeC.getSerio());
		getTesteCPc().getGuiSimpatico().setSelectedItem(testeC.getSimpatico());
		getTesteCPc().getGuiSistematico().setSelectedItem(testeC.getSistematico());
		getTesteCPc().getGuiSociavel().setSelectedItem(testeC.getSociavel());
		getTesteCPc().getGuiTeimoso().setSelectedItem(testeC.getTeimoso());
		getTesteCPc().getGuiVersatil().setSelectedItem(testeC.getVersatil());
	}

	public void atualizarObjeto() {
		testeC.setFuncionario((Funcionario) getTesteCPc().getGuiFuncionario().getSelectedItem());
		testeC.setAdequado((String) getTesteCPc().getGuiAdequado().getSelectedItem());
		testeC.setAgil((String) getTesteCPc().getGuiAgil().getSelectedItem());
		testeC.setAgitado((String) getTesteCPc().getGuiAgitado().getSelectedItem());
		testeC.setAlegre((String) getTesteCPc().getGuiAlegre().getSelectedItem());
		testeC.setAmavel((String) getTesteCPc().getGuiAmavel().getSelectedItem());
		testeC.setAnalitico((String) getTesteCPc().getGuiAnalitico().getSelectedItem());
		testeC.setAnimado((String) getTesteCPc().getGuiAnimado().getSelectedItem());
		testeC.setAnsioso((String) getTesteCPc().getGuiAnsioso().getSelectedItem());
		testeC.setApatico((String) getTesteCPc().getGuiApatico().getSelectedItem());
		testeC.setArticulado((String) getTesteCPc().getGuiArticulado().getSelectedItem());
		testeC.setAssumeRiscosCalculados(
				(String) getTesteCPc().getGuiAssumeRiscosCalculados().getSelectedItem());
		testeC.setAtencioso((String) getTesteCPc().getGuiAtencioso().getSelectedItem());
		testeC.setAtivo((String) getTesteCPc().getGuiAtivo().getSelectedItem());
		testeC.setAutoconfiante((String) getTesteCPc().getGuiAutoConfiante().getSelectedItem());
		testeC.setAventureiro((String) getTesteCPc().getGuiAventureiro().getSelectedItem());
		testeC.setBemHumorado((String) getTesteCPc().getGuiBemHumorado().getSelectedItem());
		testeC.setCalmo((String) getTesteCPc().getGuiCalmo().getSelectedItem());
		testeC.setCarismatico((String) getTesteCPc().getGuiCarismatico().getSelectedItem());
		testeC.setCauteloso((String) getTesteCPc().getGuiCauteloso().getSelectedItem());
		testeC.setCompetitivo((String) getTesteCPc().getGuiCompetitivo().getSelectedItem());
		testeC.setCompreensivo((String) getTesteCPc().getGuiCompreensivo().getSelectedItem());
		testeC.setConciliador((String) getTesteCPc().getGuiConciliador().getSelectedItem());
		testeC.setContido((String) getTesteCPc().getGuiContido().getSelectedItem());
		testeC.setConvencional((String) getTesteCPc().getGuiConvencional().getSelectedItem());
		testeC.setConvincente((String) getTesteCPc().getGuiConvincente().getSelectedItem());
		testeC.setCortes((String) getTesteCPc().getGuiCortes().getSelectedItem());
		testeC.setCuidadoso((String) getTesteCPc().getGuiCuidadoso().getSelectedItem());
		testeC.setDecidido((String) getTesteCPc().getGuiDecidido().getSelectedItem());
		testeC.setDedicado((String) getTesteCPc().getGuiDedicado().getSelectedItem());
		testeC.setDependente((String) getTesteCPc().getGuiDependente().getSelectedItem());
		testeC.setDesconfiado((String) getTesteCPc().getGuiDesconfiado().getSelectedItem());
		testeC.setDescrente((String) getTesteCPc().getGuiDescrente().getSelectedItem());
		testeC.setDesencanado((String) getTesteCPc().getGuiDesencanado().getSelectedItem());
		testeC.setDesligado((String) getTesteCPc().getGuiDesligado().getSelectedItem());
		testeC.setDespretensioso((String) getTesteCPc().getGuiDespretensioso().getSelectedItem());
		testeC.setDesprendido((String) getTesteCPc().getGuiDesprendido().getSelectedItem());
		testeC.setDestemido((String) getTesteCPc().getGuiDestemido().getSelectedItem());
		testeC.setDeterminado((String) getTesteCPc().getGuiDeterminado().getSelectedItem());
		testeC.setDiplomatico((String) getTesteCPc().getGuiDiplomatico().getSelectedItem());
		testeC.setDireto((String) getTesteCPc().getGuiDireto().getSelectedItem());
		testeC.setDisciplinado((String) getTesteCPc().getGuiDisciplinado().getSelectedItem());
		testeC.setDiscreto((String) getTesteCPc().getGuiDiscreto().getSelectedItem());
		testeC.setDisponivel((String) getTesteCPc().getGuiDisponivel().getSelectedItem());
		testeC.setDivertido((String) getTesteCPc().getGuiDivertido().getSelectedItem());
		testeC.setDominador((String) getTesteCPc().getGuiDominador().getSelectedItem());
		testeC.setEgocentrico((String) getTesteCPc().getGuiEgocentrico().getSelectedItem());
		testeC.setEmpolgado((String) getTesteCPc().getGuiEmpolgado().getSelectedItem());
		testeC.setEncantador((String) getTesteCPc().getGuiEncantador().getSelectedItem());
		testeC.setEnergico((String) getTesteCPc().getGuiEnergico().getSelectedItem());
		testeC.setEspontaneo((String) getTesteCPc().getGuiEspontaneo().getSelectedItem());
		testeC.setEstavel((String) getTesteCPc().getGuiEstavel().getSelectedItem());
		testeC.setExigente((String) getTesteCPc().getGuiExigente().getSelectedItem());
		testeC.setExpansivo((String) getTesteCPc().getGuiExpansivo().getSelectedItem());
		testeC.setExpressivo((String) getTesteCPc().getGuiExpressivo().getSelectedItem());
		testeC.setExtrovertido((String) getTesteCPc().getGuiExtrovertido().getSelectedItem());
		testeC.setFechado((String) getTesteCPc().getGuiFechado().getSelectedItem());
		testeC.setFirme((String) getTesteCPc().getGuiFirme().getSelectedItem());
		testeC.setFuncionario((Funcionario) getTesteCPc().getGuiFuncionario().getSelectedItem());
		testeC.setGostaDeSeArriscar((String) getTesteCPc().getGuiGostaDeSeArriscar().getSelectedItem());
		testeC.setHumilde((String) getTesteCPc().getGuiHumilde().getSelectedItem());
		testeC.setImpulsivo((String) getTesteCPc().getGuiImpulsivo().getSelectedItem());
		testeC.setIncerto((String) getTesteCPc().getGuiIncerto().getSelectedItem());
		testeC.setIndependente((String) getTesteCPc().getGuiIndependente().getSelectedItem());
		testeC.setIndiferente((String) getTesteCPc().getGuiIndiferente().getSelectedItem());
		testeC.setInfluente((String) getTesteCPc().getGuiInfluente().getSelectedItem());
		testeC.setInquieto((String) getTesteCPc().getGuiInquieto().getSelectedItem());
		testeC.setInspirador((String) getTesteCPc().getGuiInspirador().getSelectedItem());
		testeC.setInteressado((String) getTesteCPc().getGuiInteressado().getSelectedItem());
		testeC.setIntrospectivo((String) getTesteCPc().getGuiIntrospectivo().getSelectedItem());
		testeC.setJusto((String) getTesteCPc().getGuiJusto().getSelectedItem());
		testeC.setLeal((String) getTesteCPc().getGuiLeal().getSelectedItem());
		testeC.setLiberal((String) getTesteCPc().getGuiLiberal().getSelectedItem());
		testeC.setLivre((String) getTesteCPc().getGuiLivre().getSelectedItem());
		testeC.setLogico((String) getTesteCPc().getGuiLogico().getSelectedItem());
		testeC.setMaleavel((String) getTesteCPc().getGuiMaleavel().getSelectedItem());
		testeC.setMenteAberta((String) getTesteCPc().getGuiMenteAberta().getSelectedItem());
		testeC.setMeticuloso((String) getTesteCPc().getGuiMeticuloso().getSelectedItem());
		testeC.setObediente((String) getTesteCPc().getGuiObediente().getSelectedItem());
		testeC.setObjetivo((String) getTesteCPc().getGuiObjetivo().getSelectedItem());
		testeC.setObservador((String) getTesteCPc().getGuiObservador().getSelectedItem());
		testeC.setObstinado((String) getTesteCPc().getGuiObstinado().getSelectedItem());
		testeC.setOriginal((String) getTesteCPc().getGuiOriginal().getSelectedItem());
		testeC.setOusado((String) getTesteCPc().getGuiOusado().getSelectedItem());
		testeC.setPaciente((String) getTesteCPc().getGuiPaciente().getSelectedItem());
		testeC.setPacifico((String) getTesteCPc().getGuiPacifico().getSelectedItem());
		testeC.setPassivo((String) getTesteCPc().getGuiPassivo().getSelectedItem());
		testeC.setPerfeccionista((String) getTesteCPc().getGuiPerfeccionista().getSelectedItem());
		testeC.setPersistente((String) getTesteCPc().getGuiPersistente().getSelectedItem());
		testeC.setPersuasivo((String) getTesteCPc().getGuiPersuasivo().getSelectedItem());
		testeC.setPessimista((String) getTesteCPc().getGuiPessimista().getSelectedItem());
		testeC.setPonderado((String) getTesteCPc().getGuiPonderado().getSelectedItem());
		testeC.setPratico((String) getTesteCPc().getGuiPratico().getSelectedItem());
		testeC.setPrecavido((String) getTesteCPc().getGuiPrecavido().getSelectedItem());
		testeC.setPreciso((String) getTesteCPc().getGuiPreciso().getSelectedItem());
		testeC.setPreocupado((String) getTesteCPc().getGuiPreocupado().getSelectedItem());
		testeC.setPrevenido((String) getTesteCPc().getGuiPrevenido().getSelectedItem());
		testeC.setPrevisivel((String) getTesteCPc().getGuiPrevisivel().getSelectedItem());
		testeC.setRealista((String) getTesteCPc().getGuiRealista().getSelectedItem());
		testeC.setRebelde((String) getTesteCPc().getGuiRebelde().getSelectedItem());
		testeC.setReceoso((String) getTesteCPc().getGuiReceoso().getSelectedItem());
		testeC.setReservado((String) getTesteCPc().getGuiReservado().getSelectedItem());
		testeC.setRespeitoso((String) getTesteCPc().getGuiRespeitoso().getSelectedItem());
		testeC.setSarcastico((String) getTesteCPc().getGuiSarcastico().getSelectedItem());
		testeC.setSeguro((String) getTesteCPc().getGuiSeguro().getSelectedItem());
		testeC.setSemLimites((String) getTesteCPc().getGuiSemLimites().getSelectedItem());
		testeC.setSensato((String) getTesteCPc().getGuiSensato().getSelectedItem());
		testeC.setSereno((String) getTesteCPc().getGuiSereno().getSelectedItem());
		testeC.setSerio((String) getTesteCPc().getGuiSerio().getSelectedItem());
		testeC.setSimpatico((String) getTesteCPc().getGuiSimpatico().getSelectedItem());
		testeC.setSistematico((String) getTesteCPc().getGuiSistematico().getSelectedItem());
		testeC.setSociavel((String) getTesteCPc().getGuiSociavel().getSelectedItem());
		testeC.setTeimoso((String) getTesteCPc().getGuiTeimoso().getSelectedItem());
		testeC.setVersatil((String) getTesteCPc().getGuiVersatil().getSelectedItem());
	}

	public TesteC getTesteC() {
		return testeC;
	}

	public TesteCFc getTesteCFc() {
		return MainCont.getCurriculoTesteCFc();
	}

	public TesteCFp getTesteCFp() {
		return MainCont.getCurriculoTesteCFp();
	}

	public TesteCPc getTesteCPc() {
		return MainCont.getCurriculoTesteCFc().getTesteCPc();
	}

	public TesteCPp getTesteCPp() {
		return MainCont.getCurriculoTesteCFp().getCertificadoPp();
	}

	public void setTesteC(TesteC TesteC) {
		this.testeC = TesteC;
	}
}
