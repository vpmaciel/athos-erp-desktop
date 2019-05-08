package erp.curriculo.testepersonalidade.b;

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

final class TesteBCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (testeB == null || testeB.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				TesteBFac.deletarRegistro(testeB);
				getTesteBFc().limparGui();
				testeB = new TesteB();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getTesteBFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getTesteBFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getTesteBFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			testeB = new TesteB();
			getTesteBPc().getGuiAdequado().requestFocus();
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
			List<TesteB> testeBs = new LinkedList<>();

			if (testeB.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (testeBs.add(TesteBFac.getRegistro(testeB))) {
				TesteBRel testeBRel = new TesteBRel(testeBs);
				testeBRel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getTesteBPc().getLabelFuncionario()) {
				MainCont.mostrarFrame(MainCont.getFuncionarioFc());
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			testeB = new TesteB();
			getTesteBFc().limparGui();
			getTesteBPc().getGuiAdequado().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getTesteBPp().pesquisarRegistroTesteB(testeB);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getTesteBFp());
				getTesteBFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<TesteB> testeBs = new LinkedList<>();

			try {
				testeBs = new LinkedList<>(TesteBFac.pesquisarRegistro(new TesteB()));
			} catch (Exception e) {
				System.out.println(e);
			}

			TesteBRel testeBRel = new TesteBRel(testeBs);
			testeBRel.retornarRelatorio(true);

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
				if ((getTesteBPc().getGuiFuncionario().getSelectedItem()) == null) {
					getTesteBPc().getGuiFuncionario().requestFocus();
					Msg.avisoCampoObrigatorio("FUNCIONÁRIO");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					TesteBFac.salvarRegistro(testeB);
					testeB = new TesteB();
					getTesteBFc().limparGui();
					getTesteBPc().getGuiAdequado().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private TesteB testeB;

	public void atualizarGui() {
		if (testeB == null) {
			return;
		}
		getTesteBPc().getGuiFuncionario().setSelectedItem(testeB.getFuncionario());
		getTesteBPc().getGuiAdequado().setSelectedItem(testeB.getAdequado());
		getTesteBPc().getGuiAgil().setSelectedItem(testeB.getAgil());
		getTesteBPc().getGuiAgitado().setSelectedItem(testeB.getAgitado());
		getTesteBPc().getGuiAlegre().setSelectedItem(testeB.getAlegre());
		getTesteBPc().getGuiAmavel().setSelectedItem(testeB.getAmavel());
		getTesteBPc().getGuiAnalitico().setSelectedItem(testeB.getAnalitico());
		getTesteBPc().getGuiAnimado().setSelectedItem(testeB.getAnimado());
		getTesteBPc().getGuiAnsioso().setSelectedItem(testeB.getAnsioso());
		getTesteBPc().getGuiApatico().setSelectedItem(testeB.getApatico());
		getTesteBPc().getGuiArticulado().setSelectedItem(testeB.getArticulado());
		getTesteBPc().getGuiAssumeRiscosCalculados()
				.setSelectedItem(testeB.getAssumeRiscosCalculados());
		getTesteBPc().getGuiAtencioso().setSelectedItem(testeB.getAtencioso());
		getTesteBPc().getGuiAtivo().setSelectedItem(testeB.getAtivo());
		getTesteBPc().getGuiAutoConfiante().setSelectedItem(testeB.getAutoConfiante());
		getTesteBPc().getGuiAventureiro().setSelectedItem(testeB.getAventureiro());
		getTesteBPc().getGuiBemHumorado().setSelectedItem(testeB.getBemHumorado());
		getTesteBPc().getGuiCalmo().setSelectedItem(testeB.getCalmo());
		getTesteBPc().getGuiCarismatico().setSelectedItem(testeB.getCarismatico());
		getTesteBPc().getGuiCauteloso().setSelectedItem(testeB.getCauteloso());
		getTesteBPc().getGuiCompetitivo().setSelectedItem(testeB.getCompetitivo());
		getTesteBPc().getGuiCompreensivo().setSelectedItem(testeB.getCompreensivo());
		getTesteBPc().getGuiConciliador().setSelectedItem(testeB.getConciliador());
		getTesteBPc().getGuiContido().setSelectedItem(testeB.getContido());
		getTesteBPc().getGuiConvencional().setSelectedItem(testeB.getConvencional());
		getTesteBPc().getGuiConvincente().setSelectedItem(testeB.getConvincente());
		getTesteBPc().getGuiCortes().setSelectedItem(testeB.getCortes());
		getTesteBPc().getGuiCuidadoso().setSelectedItem(testeB.getCuidadoso());
		getTesteBPc().getGuiDecidido().setSelectedItem(testeB.getDecidido());
		getTesteBPc().getGuiDedicado().setSelectedItem(testeB.getDedicado());
		getTesteBPc().getGuiDependente().setSelectedItem(testeB.getDependente());
		getTesteBPc().getGuiDesconfiado().setSelectedItem(testeB.getDesconfiado());
		getTesteBPc().getGuiDescrente().setSelectedItem(testeB.getDescrente());
		getTesteBPc().getGuiDesencanado().setSelectedItem(testeB.getDesencanado());
		getTesteBPc().getGuiDesligado().setSelectedItem(testeB.getDesligado());
		getTesteBPc().getGuiDespretensioso().setSelectedItem(testeB.getDespretensioso());
		getTesteBPc().getGuiDesprendido().setSelectedItem(testeB.getDesprendido());
		getTesteBPc().getGuiDestemido().setSelectedItem(testeB.getDestemido());
		getTesteBPc().getGuiDeterminado().setSelectedItem(testeB.getDeterminado());
		getTesteBPc().getGuiDiplomatico().setSelectedItem(testeB.getDiplomatico());
		getTesteBPc().getGuiDireto().setSelectedItem(testeB.getDireto());
		getTesteBPc().getGuiDisciplinado().setSelectedItem(testeB.getDisciplinado());
		getTesteBPc().getGuiDiscreto().setSelectedItem(testeB.getDiscreto());
		getTesteBPc().getGuiDisponivel().setSelectedItem(testeB.getDisponivel());
		getTesteBPc().getGuiDivertido().setSelectedItem(testeB.getDivertido());
		getTesteBPc().getGuiDominador().setSelectedItem(testeB.getDominador());
		getTesteBPc().getGuiEgocentrico().setSelectedItem(testeB.getEgocentrico());
		getTesteBPc().getGuiEmpolgado().setSelectedItem(testeB.getEmpolgado());
		getTesteBPc().getGuiEncantador().setSelectedItem(testeB.getEncantador());
		getTesteBPc().getGuiEnergico().setSelectedItem(testeB.getEnergico());
		getTesteBPc().getGuiEspontaneo().setSelectedItem(testeB.getEspontaneo());
		getTesteBPc().getGuiEstavel().setSelectedItem(testeB.getEstavel());
		getTesteBPc().getGuiExigente().setSelectedItem(testeB.getExigente());
		getTesteBPc().getGuiExpansivo().setSelectedItem(testeB.getExpansivo());
		getTesteBPc().getGuiExpressivo().setSelectedItem(testeB.getExpressivo());
		getTesteBPc().getGuiExtrovertido().setSelectedItem(testeB.getExtrovertido());
		getTesteBPc().getGuiFechado().setSelectedItem(testeB.getFechado());
		getTesteBPc().getGuiFirme().setSelectedItem(testeB.getFirme());
		getTesteBPc().getGuiFuncionario().setSelectedItem(testeB.getFuncionario());
		getTesteBPc().getGuiGostaDeSeArriscar().setSelectedItem(testeB.getGostaDeSeArriscar());
		getTesteBPc().getGuiHumilde().setSelectedItem(testeB.getHumilde());
		getTesteBPc().getGuiImpulsivo().setSelectedItem(testeB.getImpulsivo());
		getTesteBPc().getGuiIncerto().setSelectedItem(testeB.getIncerto());
		getTesteBPc().getGuiIndependente().setSelectedItem(testeB.getIndependente());
		getTesteBPc().getGuiIndiferente().setSelectedItem(testeB.getIndiferente());
		getTesteBPc().getGuiInfluente().setSelectedItem(testeB.getInfluente());
		getTesteBPc().getGuiInquieto().setSelectedItem(testeB.getInquieto());
		getTesteBPc().getGuiInspirador().setSelectedItem(testeB.getInspirador());
		getTesteBPc().getGuiInteressado().setSelectedItem(testeB.getInteressado());
		getTesteBPc().getGuiIntrospectivo().setSelectedItem(testeB.getIntrospectivo());
		getTesteBPc().getGuiJusto().setSelectedItem(testeB.getJusto());
		getTesteBPc().getGuiLeal().setSelectedItem(testeB.getLeal());
		getTesteBPc().getGuiLiberal().setSelectedItem(testeB.getLiberal());
		getTesteBPc().getGuiLivre().setSelectedItem(testeB.getLivre());
		getTesteBPc().getGuiLogico().setSelectedItem(testeB.getLogico());
		getTesteBPc().getGuiMaleavel().setSelectedItem(testeB.getMaleavel());
		getTesteBPc().getGuiMenteAberta().setSelectedItem(testeB.getMenteAberta());
		getTesteBPc().getGuiMeticuloso().setSelectedItem(testeB.getMeticuloso());
		getTesteBPc().getGuiObediente().setSelectedItem(testeB.getObediente());
		getTesteBPc().getGuiObjetivo().setSelectedItem(testeB.getObjetivo());
		getTesteBPc().getGuiObservador().setSelectedItem(testeB.getObservador());
		getTesteBPc().getGuiObstinado().setSelectedItem(testeB.getObstinado());
		getTesteBPc().getGuiOriginal().setSelectedItem(testeB.getOriginal());
		getTesteBPc().getGuiOusado().setSelectedItem(testeB.getOusado());
		getTesteBPc().getGuiPaciente().setSelectedItem(testeB.getPaciente());
		getTesteBPc().getGuiPacifico().setSelectedItem(testeB.getPacifico());
		getTesteBPc().getGuiPassivo().setSelectedItem(testeB.getPassivo());
		getTesteBPc().getGuiPerfeccionista().setSelectedItem(testeB.getPerfeccionista());
		getTesteBPc().getGuiPersistente().setSelectedItem(testeB.getPersistente());
		getTesteBPc().getGuiPersuasivo().setSelectedItem(testeB.getPersuasivo());
		getTesteBPc().getGuiPessimista().setSelectedItem(testeB.getPessimista());
		getTesteBPc().getGuiPonderado().setSelectedItem(testeB.getPonderado());
		getTesteBPc().getGuiPratico().setSelectedItem(testeB.getPratico());
		getTesteBPc().getGuiPrecavido().setSelectedItem(testeB.getPrecavido());
		getTesteBPc().getGuiPreciso().setSelectedItem(testeB.getPreciso());
		getTesteBPc().getGuiPreocupado().setSelectedItem(testeB.getPreocupado());
		getTesteBPc().getGuiPrevenido().setSelectedItem(testeB.getPrevenido());
		getTesteBPc().getGuiPrevisivel().setSelectedItem(testeB.getPrevisivel());
		getTesteBPc().getGuiRealista().setSelectedItem(testeB.getRealista());
		getTesteBPc().getGuiRebelde().setSelectedItem(testeB.getRebelde());
		getTesteBPc().getGuiReceoso().setSelectedItem(testeB.getReceoso());
		getTesteBPc().getGuiReservado().setSelectedItem(testeB.getReservado());
		getTesteBPc().getGuiRespeitoso().setSelectedItem(testeB.getRespeitoso());
		getTesteBPc().getGuiSarcastico().setSelectedItem(testeB.getSarcastico());
		getTesteBPc().getGuiSeguro().setSelectedItem(testeB.getSeguro());
		getTesteBPc().getGuiSemLimites().setSelectedItem(testeB.getSemLimites());
		getTesteBPc().getGuiSensato().setSelectedItem(testeB.getSensato());
		getTesteBPc().getGuiSereno().setSelectedItem(testeB.getSereno());
		getTesteBPc().getGuiSerio().setSelectedItem(testeB.getSerio());
		getTesteBPc().getGuiSimpatico().setSelectedItem(testeB.getSimpatico());
		getTesteBPc().getGuiSistematico().setSelectedItem(testeB.getSistematico());
		getTesteBPc().getGuiSociavel().setSelectedItem(testeB.getSociavel());
		getTesteBPc().getGuiTeimoso().setSelectedItem(testeB.getTeimoso());
		getTesteBPc().getGuiVersatil().setSelectedItem(testeB.getVersatil());
	}

	public void atualizarObjeto() {
		testeB.setFuncionario((Funcionario) getTesteBPc().getGuiFuncionario().getSelectedItem());
		testeB.setAdequado((String) getTesteBPc().getGuiAdequado().getSelectedItem());
		testeB.setAgil((String) getTesteBPc().getGuiAgil().getSelectedItem());
		testeB.setAgitado((String) getTesteBPc().getGuiAgitado().getSelectedItem());
		testeB.setAlegre((String) getTesteBPc().getGuiAlegre().getSelectedItem());
		testeB.setAmavel((String) getTesteBPc().getGuiAmavel().getSelectedItem());
		testeB.setAnalitico((String) getTesteBPc().getGuiAnalitico().getSelectedItem());
		testeB.setAnimado((String) getTesteBPc().getGuiAnimado().getSelectedItem());
		testeB.setAnsioso((String) getTesteBPc().getGuiAnsioso().getSelectedItem());
		testeB.setApatico((String) getTesteBPc().getGuiApatico().getSelectedItem());
		testeB.setArticulado((String) getTesteBPc().getGuiArticulado().getSelectedItem());
		testeB.setAssumeRiscosCalculados(
				(String) getTesteBPc().getGuiAssumeRiscosCalculados().getSelectedItem());
		testeB.setAtencioso((String) getTesteBPc().getGuiAtencioso().getSelectedItem());
		testeB.setAtivo((String) getTesteBPc().getGuiAtivo().getSelectedItem());
		testeB.setAutoconfiante((String) getTesteBPc().getGuiAutoConfiante().getSelectedItem());
		testeB.setAventureiro((String) getTesteBPc().getGuiAventureiro().getSelectedItem());
		testeB.setBemHumorado((String) getTesteBPc().getGuiBemHumorado().getSelectedItem());
		testeB.setCalmo((String) getTesteBPc().getGuiCalmo().getSelectedItem());
		testeB.setCarismatico((String) getTesteBPc().getGuiCarismatico().getSelectedItem());
		testeB.setCauteloso((String) getTesteBPc().getGuiCauteloso().getSelectedItem());
		testeB.setCompetitivo((String) getTesteBPc().getGuiCompetitivo().getSelectedItem());
		testeB.setCompreensivo((String) getTesteBPc().getGuiCompreensivo().getSelectedItem());
		testeB.setConciliador((String) getTesteBPc().getGuiConciliador().getSelectedItem());
		testeB.setContido((String) getTesteBPc().getGuiContido().getSelectedItem());
		testeB.setConvencional((String) getTesteBPc().getGuiConvencional().getSelectedItem());
		testeB.setConvincente((String) getTesteBPc().getGuiConvincente().getSelectedItem());
		testeB.setCortes((String) getTesteBPc().getGuiCortes().getSelectedItem());
		testeB.setCuidadoso((String) getTesteBPc().getGuiCuidadoso().getSelectedItem());
		testeB.setDecidido((String) getTesteBPc().getGuiDecidido().getSelectedItem());
		testeB.setDedicado((String) getTesteBPc().getGuiDedicado().getSelectedItem());
		testeB.setDependente((String) getTesteBPc().getGuiDependente().getSelectedItem());
		testeB.setDesconfiado((String) getTesteBPc().getGuiDesconfiado().getSelectedItem());
		testeB.setDescrente((String) getTesteBPc().getGuiDescrente().getSelectedItem());
		testeB.setDesencanado((String) getTesteBPc().getGuiDesencanado().getSelectedItem());
		testeB.setDesligado((String) getTesteBPc().getGuiDesligado().getSelectedItem());
		testeB.setDespretensioso((String) getTesteBPc().getGuiDespretensioso().getSelectedItem());
		testeB.setDesprendido((String) getTesteBPc().getGuiDesprendido().getSelectedItem());
		testeB.setDestemido((String) getTesteBPc().getGuiDestemido().getSelectedItem());
		testeB.setDeterminado((String) getTesteBPc().getGuiDeterminado().getSelectedItem());
		testeB.setDiplomatico((String) getTesteBPc().getGuiDiplomatico().getSelectedItem());
		testeB.setDireto((String) getTesteBPc().getGuiDireto().getSelectedItem());
		testeB.setDisciplinado((String) getTesteBPc().getGuiDisciplinado().getSelectedItem());
		testeB.setDiscreto((String) getTesteBPc().getGuiDiscreto().getSelectedItem());
		testeB.setDisponivel((String) getTesteBPc().getGuiDisponivel().getSelectedItem());
		testeB.setDivertido((String) getTesteBPc().getGuiDivertido().getSelectedItem());
		testeB.setDominador((String) getTesteBPc().getGuiDominador().getSelectedItem());
		testeB.setEgocentrico((String) getTesteBPc().getGuiEgocentrico().getSelectedItem());
		testeB.setEmpolgado((String) getTesteBPc().getGuiEmpolgado().getSelectedItem());
		testeB.setEncantador((String) getTesteBPc().getGuiEncantador().getSelectedItem());
		testeB.setEnergico((String) getTesteBPc().getGuiEnergico().getSelectedItem());
		testeB.setEspontaneo((String) getTesteBPc().getGuiEspontaneo().getSelectedItem());
		testeB.setEstavel((String) getTesteBPc().getGuiEstavel().getSelectedItem());
		testeB.setExigente((String) getTesteBPc().getGuiExigente().getSelectedItem());
		testeB.setExpansivo((String) getTesteBPc().getGuiExpansivo().getSelectedItem());
		testeB.setExpressivo((String) getTesteBPc().getGuiExpressivo().getSelectedItem());
		testeB.setExtrovertido((String) getTesteBPc().getGuiExtrovertido().getSelectedItem());
		testeB.setFechado((String) getTesteBPc().getGuiFechado().getSelectedItem());
		testeB.setFirme((String) getTesteBPc().getGuiFirme().getSelectedItem());
		testeB.setFuncionario((Funcionario) getTesteBPc().getGuiFuncionario().getSelectedItem());
		testeB.setGostaDeSeArriscar((String) getTesteBPc().getGuiGostaDeSeArriscar().getSelectedItem());
		testeB.setHumilde((String) getTesteBPc().getGuiHumilde().getSelectedItem());
		testeB.setImpulsivo((String) getTesteBPc().getGuiImpulsivo().getSelectedItem());
		testeB.setIncerto((String) getTesteBPc().getGuiIncerto().getSelectedItem());
		testeB.setIndependente((String) getTesteBPc().getGuiIndependente().getSelectedItem());
		testeB.setIndiferente((String) getTesteBPc().getGuiIndiferente().getSelectedItem());
		testeB.setInfluente((String) getTesteBPc().getGuiInfluente().getSelectedItem());
		testeB.setInquieto((String) getTesteBPc().getGuiInquieto().getSelectedItem());
		testeB.setInspirador((String) getTesteBPc().getGuiInspirador().getSelectedItem());
		testeB.setInteressado((String) getTesteBPc().getGuiInteressado().getSelectedItem());
		testeB.setIntrospectivo((String) getTesteBPc().getGuiIntrospectivo().getSelectedItem());
		testeB.setJusto((String) getTesteBPc().getGuiJusto().getSelectedItem());
		testeB.setLeal((String) getTesteBPc().getGuiLeal().getSelectedItem());
		testeB.setLiberal((String) getTesteBPc().getGuiLiberal().getSelectedItem());
		testeB.setLivre((String) getTesteBPc().getGuiLivre().getSelectedItem());
		testeB.setLogico((String) getTesteBPc().getGuiLogico().getSelectedItem());
		testeB.setMaleavel((String) getTesteBPc().getGuiMaleavel().getSelectedItem());
		testeB.setMenteAberta((String) getTesteBPc().getGuiMenteAberta().getSelectedItem());
		testeB.setMeticuloso((String) getTesteBPc().getGuiMeticuloso().getSelectedItem());
		testeB.setObediente((String) getTesteBPc().getGuiObediente().getSelectedItem());
		testeB.setObjetivo((String) getTesteBPc().getGuiObjetivo().getSelectedItem());
		testeB.setObservador((String) getTesteBPc().getGuiObservador().getSelectedItem());
		testeB.setObstinado((String) getTesteBPc().getGuiObstinado().getSelectedItem());
		testeB.setOriginal((String) getTesteBPc().getGuiOriginal().getSelectedItem());
		testeB.setOusado((String) getTesteBPc().getGuiOusado().getSelectedItem());
		testeB.setPaciente((String) getTesteBPc().getGuiPaciente().getSelectedItem());
		testeB.setPacifico((String) getTesteBPc().getGuiPacifico().getSelectedItem());
		testeB.setPassivo((String) getTesteBPc().getGuiPassivo().getSelectedItem());
		testeB.setPerfeccionista((String) getTesteBPc().getGuiPerfeccionista().getSelectedItem());
		testeB.setPersistente((String) getTesteBPc().getGuiPersistente().getSelectedItem());
		testeB.setPersuasivo((String) getTesteBPc().getGuiPersuasivo().getSelectedItem());
		testeB.setPessimista((String) getTesteBPc().getGuiPessimista().getSelectedItem());
		testeB.setPonderado((String) getTesteBPc().getGuiPonderado().getSelectedItem());
		testeB.setPratico((String) getTesteBPc().getGuiPratico().getSelectedItem());
		testeB.setPrecavido((String) getTesteBPc().getGuiPrecavido().getSelectedItem());
		testeB.setPreciso((String) getTesteBPc().getGuiPreciso().getSelectedItem());
		testeB.setPreocupado((String) getTesteBPc().getGuiPreocupado().getSelectedItem());
		testeB.setPrevenido((String) getTesteBPc().getGuiPrevenido().getSelectedItem());
		testeB.setPrevisivel((String) getTesteBPc().getGuiPrevisivel().getSelectedItem());
		testeB.setRealista((String) getTesteBPc().getGuiRealista().getSelectedItem());
		testeB.setRebelde((String) getTesteBPc().getGuiRebelde().getSelectedItem());
		testeB.setReceoso((String) getTesteBPc().getGuiReceoso().getSelectedItem());
		testeB.setReservado((String) getTesteBPc().getGuiReservado().getSelectedItem());
		testeB.setRespeitoso((String) getTesteBPc().getGuiRespeitoso().getSelectedItem());
		testeB.setSarcastico((String) getTesteBPc().getGuiSarcastico().getSelectedItem());
		testeB.setSeguro((String) getTesteBPc().getGuiSeguro().getSelectedItem());
		testeB.setSemLimites((String) getTesteBPc().getGuiSemLimites().getSelectedItem());
		testeB.setSensato((String) getTesteBPc().getGuiSensato().getSelectedItem());
		testeB.setSereno((String) getTesteBPc().getGuiSereno().getSelectedItem());
		testeB.setSerio((String) getTesteBPc().getGuiSerio().getSelectedItem());
		testeB.setSimpatico((String) getTesteBPc().getGuiSimpatico().getSelectedItem());
		testeB.setSistematico((String) getTesteBPc().getGuiSistematico().getSelectedItem());
		testeB.setSociavel((String) getTesteBPc().getGuiSociavel().getSelectedItem());
		testeB.setTeimoso((String) getTesteBPc().getGuiTeimoso().getSelectedItem());
		testeB.setVersatil((String) getTesteBPc().getGuiVersatil().getSelectedItem());
	}

	public TesteB getTesteB() {
		return testeB;
	}

	public TesteBFc getTesteBFc() {
		return MainCont.getCurriculoTesteBFc();
	}

	public TesteBFp getTesteBFp() {
		return MainCont.getCurriculoTesteBFp();
	}

	public TesteBPc getTesteBPc() {
		return MainCont.getCurriculoTesteBFc().getTesteBPc();
	}

	public TesteBPp getTesteBPp() {
		return MainCont.getCurriculoTesteBFp().getCertificadoPp();
	}

	public void setTesteB(TesteB TesteB) {
		this.testeB = TesteB;
	}
}
