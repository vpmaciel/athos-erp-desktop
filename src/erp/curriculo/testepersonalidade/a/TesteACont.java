package erp.curriculo.testepersonalidade.a;

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

final class TesteACont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (testeA == null || testeA.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				TesteAFac.deletarRegistro(testeA);
				getTesteAFc().limparGui();
				testeA = new TesteA();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getTesteAFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getTesteAFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getTesteAFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			testeA = new TesteA();
			getTesteAPc().getGuiAdequado().requestFocus();
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
			List<TesteA> testeAs = new LinkedList<>();

			if (testeA.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (testeAs.add(TesteAFac.getRegistro(testeA))) {
				TesteARel testeARel = new TesteARel(testeAs);
				testeARel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getTesteAPc().getLabelFuncionario()) {
				MainCont.mostrarFrame(MainCont.getFuncionarioFc());
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			testeA = new TesteA();
			getTesteAFc().limparGui();
			getTesteAPc().getGuiAdequado().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getTesteAPp().pesquisarRegistroTesteA(testeA);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getTesteAFp());
				getTesteAFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<TesteA> testeAs = new LinkedList<>();

			try {
				testeAs = new LinkedList<>(TesteAFac.pesquisarRegistro(new TesteA()));
			} catch (Exception e) {
				System.out.println(e);
			}

			TesteARel testeARel = new TesteARel(testeAs);
			testeARel.retornarRelatorio(true);

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
				if ((getTesteAPc().getGuiFuncionario().getSelectedItem()) == null) {
					getTesteAPc().getGuiFuncionario().requestFocus();
					Msg.avisoCampoObrigatorio("FUNCIONÁRIO");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					TesteAFac.salvarRegistro(testeA);
					testeA = new TesteA();
					getTesteAFc().limparGui();
					getTesteAPc().getGuiAdequado().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private TesteA testeA;

	public void atualizarGui() {
		if (testeA == null) {
			return;
		}
		getTesteAPc().getGuiFuncionario().setSelectedItem(testeA.getFuncionario());
		getTesteAPc().getGuiAdequado().setSelectedItem(testeA.getAdequado());
		getTesteAPc().getGuiAgil().setSelectedItem(testeA.getAgil());
		getTesteAPc().getGuiAgitado().setSelectedItem(testeA.getAgitado());
		getTesteAPc().getGuiAlegre().setSelectedItem(testeA.getAlegre());
		getTesteAPc().getGuiAmavel().setSelectedItem(testeA.getAmavel());
		getTesteAPc().getGuiAnalitico().setSelectedItem(testeA.getAnalitico());
		getTesteAPc().getGuiAnimado().setSelectedItem(testeA.getAnimado());
		getTesteAPc().getGuiAnsioso().setSelectedItem(testeA.getAnsioso());
		getTesteAPc().getGuiApatico().setSelectedItem(testeA.getApatico());
		getTesteAPc().getGuiArticulado().setSelectedItem(testeA.getArticulado());
		getTesteAPc().getGuiAssumeRiscosCalculados()
				.setSelectedItem(testeA.getAssumeRiscosCalculados());
		getTesteAPc().getGuiAtencioso().setSelectedItem(testeA.getAtencioso());
		getTesteAPc().getGuiAtivo().setSelectedItem(testeA.getAtivo());
		getTesteAPc().getGuiAutoConfiante().setSelectedItem(testeA.getAutoConfiante());
		getTesteAPc().getGuiAventureiro().setSelectedItem(testeA.getAventureiro());
		getTesteAPc().getGuiBemHumorado().setSelectedItem(testeA.getBemHumorado());
		getTesteAPc().getGuiCalmo().setSelectedItem(testeA.getCalmo());
		getTesteAPc().getGuiCarismatico().setSelectedItem(testeA.getCarismatico());
		getTesteAPc().getGuiCauteloso().setSelectedItem(testeA.getCauteloso());
		getTesteAPc().getGuiCompetitivo().setSelectedItem(testeA.getCompetitivo());
		getTesteAPc().getGuiCompreensivo().setSelectedItem(testeA.getCompreensivo());
		getTesteAPc().getGuiConciliador().setSelectedItem(testeA.getConciliador());
		getTesteAPc().getGuiContido().setSelectedItem(testeA.getContido());
		getTesteAPc().getGuiConvencional().setSelectedItem(testeA.getConvencional());
		getTesteAPc().getGuiConvincente().setSelectedItem(testeA.getConvincente());
		getTesteAPc().getGuiCortes().setSelectedItem(testeA.getCortes());
		getTesteAPc().getGuiCuidadoso().setSelectedItem(testeA.getCuidadoso());
		getTesteAPc().getGuiDecidido().setSelectedItem(testeA.getDecidido());
		getTesteAPc().getGuiDedicado().setSelectedItem(testeA.getDedicado());
		getTesteAPc().getGuiDependente().setSelectedItem(testeA.getDependente());
		getTesteAPc().getGuiDesconfiado().setSelectedItem(testeA.getDesconfiado());
		getTesteAPc().getGuiDescrente().setSelectedItem(testeA.getDescrente());
		getTesteAPc().getGuiDesencanado().setSelectedItem(testeA.getDesencanado());
		getTesteAPc().getGuiDesligado().setSelectedItem(testeA.getDesligado());
		getTesteAPc().getGuiDespretensioso().setSelectedItem(testeA.getDespretensioso());
		getTesteAPc().getGuiDesprendido().setSelectedItem(testeA.getDesprendido());
		getTesteAPc().getGuiDestemido().setSelectedItem(testeA.getDestemido());
		getTesteAPc().getGuiDeterminado().setSelectedItem(testeA.getDeterminado());
		getTesteAPc().getGuiDiplomatico().setSelectedItem(testeA.getDiplomatico());
		getTesteAPc().getGuiDireto().setSelectedItem(testeA.getDireto());
		getTesteAPc().getGuiDisciplinado().setSelectedItem(testeA.getDisciplinado());
		getTesteAPc().getGuiDiscreto().setSelectedItem(testeA.getDiscreto());
		getTesteAPc().getGuiDisponivel().setSelectedItem(testeA.getDisponivel());
		getTesteAPc().getGuiDivertido().setSelectedItem(testeA.getDivertido());
		getTesteAPc().getGuiDominador().setSelectedItem(testeA.getDominador());
		getTesteAPc().getGuiEgocentrico().setSelectedItem(testeA.getEgocentrico());
		getTesteAPc().getGuiEmpolgado().setSelectedItem(testeA.getEmpolgado());
		getTesteAPc().getGuiEncantador().setSelectedItem(testeA.getEncantador());
		getTesteAPc().getGuiEnergico().setSelectedItem(testeA.getEnergico());
		getTesteAPc().getGuiEspontaneo().setSelectedItem(testeA.getEspontaneo());
		getTesteAPc().getGuiEstavel().setSelectedItem(testeA.getEstavel());
		getTesteAPc().getGuiExigente().setSelectedItem(testeA.getExigente());
		getTesteAPc().getGuiExpansivo().setSelectedItem(testeA.getExpansivo());
		getTesteAPc().getGuiExpressivo().setSelectedItem(testeA.getExpressivo());
		getTesteAPc().getGuiExtrovertido().setSelectedItem(testeA.getExtrovertido());
		getTesteAPc().getGuiFechado().setSelectedItem(testeA.getFechado());
		getTesteAPc().getGuiFirme().setSelectedItem(testeA.getFirme());
		getTesteAPc().getGuiFuncionario().setSelectedItem(testeA.getFuncionario());
		getTesteAPc().getGuiGostaDeSeArriscar().setSelectedItem(testeA.getGostaDeSeArriscar());
		getTesteAPc().getGuiHumilde().setSelectedItem(testeA.getHumilde());
		getTesteAPc().getGuiImpulsivo().setSelectedItem(testeA.getImpulsivo());
		getTesteAPc().getGuiIncerto().setSelectedItem(testeA.getIncerto());
		getTesteAPc().getGuiIndependente().setSelectedItem(testeA.getIndependente());
		getTesteAPc().getGuiIndiferente().setSelectedItem(testeA.getIndiferente());
		getTesteAPc().getGuiInfluente().setSelectedItem(testeA.getInfluente());
		getTesteAPc().getGuiInquieto().setSelectedItem(testeA.getInquieto());
		getTesteAPc().getGuiInspirador().setSelectedItem(testeA.getInspirador());
		getTesteAPc().getGuiInteressado().setSelectedItem(testeA.getInteressado());
		getTesteAPc().getGuiIntrospectivo().setSelectedItem(testeA.getIntrospectivo());
		getTesteAPc().getGuiJusto().setSelectedItem(testeA.getJusto());
		getTesteAPc().getGuiLeal().setSelectedItem(testeA.getLeal());
		getTesteAPc().getGuiLiberal().setSelectedItem(testeA.getLiberal());
		getTesteAPc().getGuiLivre().setSelectedItem(testeA.getLivre());
		getTesteAPc().getGuiLogico().setSelectedItem(testeA.getLogico());
		getTesteAPc().getGuiMaleavel().setSelectedItem(testeA.getMaleavel());
		getTesteAPc().getGuiMenteAberta().setSelectedItem(testeA.getMenteAberta());
		getTesteAPc().getGuiMeticuloso().setSelectedItem(testeA.getMeticuloso());
		getTesteAPc().getGuiObediente().setSelectedItem(testeA.getObediente());
		getTesteAPc().getGuiObjetivo().setSelectedItem(testeA.getObjetivo());
		getTesteAPc().getGuiObservador().setSelectedItem(testeA.getObservador());
		getTesteAPc().getGuiObstinado().setSelectedItem(testeA.getObstinado());
		getTesteAPc().getGuiOriginal().setSelectedItem(testeA.getOriginal());
		getTesteAPc().getGuiOusado().setSelectedItem(testeA.getOusado());
		getTesteAPc().getGuiPaciente().setSelectedItem(testeA.getPaciente());
		getTesteAPc().getGuiPacifico().setSelectedItem(testeA.getPacifico());
		getTesteAPc().getGuiPassivo().setSelectedItem(testeA.getPassivo());
		getTesteAPc().getGuiPerfeccionista().setSelectedItem(testeA.getPerfeccionista());
		getTesteAPc().getGuiPersistente().setSelectedItem(testeA.getPersistente());
		getTesteAPc().getGuiPersuasivo().setSelectedItem(testeA.getPersuasivo());
		getTesteAPc().getGuiPessimista().setSelectedItem(testeA.getPessimista());
		getTesteAPc().getGuiPonderado().setSelectedItem(testeA.getPonderado());
		getTesteAPc().getGuiPratico().setSelectedItem(testeA.getPratico());
		getTesteAPc().getGuiPrecavido().setSelectedItem(testeA.getPrecavido());
		getTesteAPc().getGuiPreciso().setSelectedItem(testeA.getPreciso());
		getTesteAPc().getGuiPreocupado().setSelectedItem(testeA.getPreocupado());
		getTesteAPc().getGuiPrevenido().setSelectedItem(testeA.getPrevenido());
		getTesteAPc().getGuiPrevisivel().setSelectedItem(testeA.getPrevisivel());
		getTesteAPc().getGuiRealista().setSelectedItem(testeA.getRealista());
		getTesteAPc().getGuiRebelde().setSelectedItem(testeA.getRebelde());
		getTesteAPc().getGuiReceoso().setSelectedItem(testeA.getReceoso());
		getTesteAPc().getGuiReservado().setSelectedItem(testeA.getReservado());
		getTesteAPc().getGuiRespeitoso().setSelectedItem(testeA.getRespeitoso());
		getTesteAPc().getGuiSarcastico().setSelectedItem(testeA.getSarcastico());
		getTesteAPc().getGuiSeguro().setSelectedItem(testeA.getSeguro());
		getTesteAPc().getGuiSemLimites().setSelectedItem(testeA.getSemLimites());
		getTesteAPc().getGuiSensato().setSelectedItem(testeA.getSensato());
		getTesteAPc().getGuiSereno().setSelectedItem(testeA.getSereno());
		getTesteAPc().getGuiSerio().setSelectedItem(testeA.getSerio());
		getTesteAPc().getGuiSimpatico().setSelectedItem(testeA.getSimpatico());
		getTesteAPc().getGuiSistematico().setSelectedItem(testeA.getSistematico());
		getTesteAPc().getGuiSociavel().setSelectedItem(testeA.getSociavel());
		getTesteAPc().getGuiTeimoso().setSelectedItem(testeA.getTeimoso());
		getTesteAPc().getGuiVersatil().setSelectedItem(testeA.getVersatil());
	}

	public void atualizarObjeto() {
		testeA.setFuncionario((Funcionario) getTesteAPc().getGuiFuncionario().getSelectedItem());
		testeA.setAdequado((String) getTesteAPc().getGuiAdequado().getSelectedItem());
		testeA.setAgil((String) getTesteAPc().getGuiAgil().getSelectedItem());
		testeA.setAgitado((String) getTesteAPc().getGuiAgitado().getSelectedItem());
		testeA.setAlegre((String) getTesteAPc().getGuiAlegre().getSelectedItem());
		testeA.setAmavel((String) getTesteAPc().getGuiAmavel().getSelectedItem());
		testeA.setAnalitico((String) getTesteAPc().getGuiAnalitico().getSelectedItem());
		testeA.setAnimado((String) getTesteAPc().getGuiAnimado().getSelectedItem());
		testeA.setAnsioso((String) getTesteAPc().getGuiAnsioso().getSelectedItem());
		testeA.setApatico((String) getTesteAPc().getGuiApatico().getSelectedItem());
		testeA.setArticulado((String) getTesteAPc().getGuiArticulado().getSelectedItem());
		testeA.setAssumeRiscosCalculados(
				(String) getTesteAPc().getGuiAssumeRiscosCalculados().getSelectedItem());
		testeA.setAtencioso((String) getTesteAPc().getGuiAtencioso().getSelectedItem());
		testeA.setAtivo((String) getTesteAPc().getGuiAtivo().getSelectedItem());
		testeA.setAutoconfiante((String) getTesteAPc().getGuiAutoConfiante().getSelectedItem());
		testeA.setAventureiro((String) getTesteAPc().getGuiAventureiro().getSelectedItem());
		testeA.setBemHumorado((String) getTesteAPc().getGuiBemHumorado().getSelectedItem());
		testeA.setCalmo((String) getTesteAPc().getGuiCalmo().getSelectedItem());
		testeA.setCarismatico((String) getTesteAPc().getGuiCarismatico().getSelectedItem());
		testeA.setCauteloso((String) getTesteAPc().getGuiCauteloso().getSelectedItem());
		testeA.setCompetitivo((String) getTesteAPc().getGuiCompetitivo().getSelectedItem());
		testeA.setCompreensivo((String) getTesteAPc().getGuiCompreensivo().getSelectedItem());
		testeA.setConciliador((String) getTesteAPc().getGuiConciliador().getSelectedItem());
		testeA.setContido((String) getTesteAPc().getGuiContido().getSelectedItem());
		testeA.setConvencional((String) getTesteAPc().getGuiConvencional().getSelectedItem());
		testeA.setConvincente((String) getTesteAPc().getGuiConvincente().getSelectedItem());
		testeA.setCortes((String) getTesteAPc().getGuiCortes().getSelectedItem());
		testeA.setCuidadoso((String) getTesteAPc().getGuiCuidadoso().getSelectedItem());
		testeA.setDecidido((String) getTesteAPc().getGuiDecidido().getSelectedItem());
		testeA.setDedicado((String) getTesteAPc().getGuiDedicado().getSelectedItem());
		testeA.setDependente((String) getTesteAPc().getGuiDependente().getSelectedItem());
		testeA.setDesconfiado((String) getTesteAPc().getGuiDesconfiado().getSelectedItem());
		testeA.setDescrente((String) getTesteAPc().getGuiDescrente().getSelectedItem());
		testeA.setDesencanado((String) getTesteAPc().getGuiDesencanado().getSelectedItem());
		testeA.setDesligado((String) getTesteAPc().getGuiDesligado().getSelectedItem());
		testeA.setDespretensioso((String) getTesteAPc().getGuiDespretensioso().getSelectedItem());
		testeA.setDesprendido((String) getTesteAPc().getGuiDesprendido().getSelectedItem());
		testeA.setDestemido((String) getTesteAPc().getGuiDestemido().getSelectedItem());
		testeA.setDeterminado((String) getTesteAPc().getGuiDeterminado().getSelectedItem());
		testeA.setDiplomatico((String) getTesteAPc().getGuiDiplomatico().getSelectedItem());
		testeA.setDireto((String) getTesteAPc().getGuiDireto().getSelectedItem());
		testeA.setDisciplinado((String) getTesteAPc().getGuiDisciplinado().getSelectedItem());
		testeA.setDiscreto((String) getTesteAPc().getGuiDiscreto().getSelectedItem());
		testeA.setDisponivel((String) getTesteAPc().getGuiDisponivel().getSelectedItem());
		testeA.setDivertido((String) getTesteAPc().getGuiDivertido().getSelectedItem());
		testeA.setDominador((String) getTesteAPc().getGuiDominador().getSelectedItem());
		testeA.setEgocentrico((String) getTesteAPc().getGuiEgocentrico().getSelectedItem());
		testeA.setEmpolgado((String) getTesteAPc().getGuiEmpolgado().getSelectedItem());
		testeA.setEncantador((String) getTesteAPc().getGuiEncantador().getSelectedItem());
		testeA.setEnergico((String) getTesteAPc().getGuiEnergico().getSelectedItem());
		testeA.setEspontaneo((String) getTesteAPc().getGuiEspontaneo().getSelectedItem());
		testeA.setEstavel((String) getTesteAPc().getGuiEstavel().getSelectedItem());
		testeA.setExigente((String) getTesteAPc().getGuiExigente().getSelectedItem());
		testeA.setExpansivo((String) getTesteAPc().getGuiExpansivo().getSelectedItem());
		testeA.setExpressivo((String) getTesteAPc().getGuiExpressivo().getSelectedItem());
		testeA.setExtrovertido((String) getTesteAPc().getGuiExtrovertido().getSelectedItem());
		testeA.setFechado((String) getTesteAPc().getGuiFechado().getSelectedItem());
		testeA.setFirme((String) getTesteAPc().getGuiFirme().getSelectedItem());
		testeA.setFuncionario((Funcionario) getTesteAPc().getGuiFuncionario().getSelectedItem());
		testeA.setGostaDeSeArriscar((String) getTesteAPc().getGuiGostaDeSeArriscar().getSelectedItem());
		testeA.setHumilde((String) getTesteAPc().getGuiHumilde().getSelectedItem());
		testeA.setImpulsivo((String) getTesteAPc().getGuiImpulsivo().getSelectedItem());
		testeA.setIncerto((String) getTesteAPc().getGuiIncerto().getSelectedItem());
		testeA.setIndependente((String) getTesteAPc().getGuiIndependente().getSelectedItem());
		testeA.setIndiferente((String) getTesteAPc().getGuiIndiferente().getSelectedItem());
		testeA.setInfluente((String) getTesteAPc().getGuiInfluente().getSelectedItem());
		testeA.setInquieto((String) getTesteAPc().getGuiInquieto().getSelectedItem());
		testeA.setInspirador((String) getTesteAPc().getGuiInspirador().getSelectedItem());
		testeA.setInteressado((String) getTesteAPc().getGuiInteressado().getSelectedItem());
		testeA.setIntrospectivo((String) getTesteAPc().getGuiIntrospectivo().getSelectedItem());
		testeA.setJusto((String) getTesteAPc().getGuiJusto().getSelectedItem());
		testeA.setLeal((String) getTesteAPc().getGuiLeal().getSelectedItem());
		testeA.setLiberal((String) getTesteAPc().getGuiLiberal().getSelectedItem());
		testeA.setLivre((String) getTesteAPc().getGuiLivre().getSelectedItem());
		testeA.setLogico((String) getTesteAPc().getGuiLogico().getSelectedItem());
		testeA.setMaleavel((String) getTesteAPc().getGuiMaleavel().getSelectedItem());
		testeA.setMenteAberta((String) getTesteAPc().getGuiMenteAberta().getSelectedItem());
		testeA.setMeticuloso((String) getTesteAPc().getGuiMeticuloso().getSelectedItem());
		testeA.setObediente((String) getTesteAPc().getGuiObediente().getSelectedItem());
		testeA.setObjetivo((String) getTesteAPc().getGuiObjetivo().getSelectedItem());
		testeA.setObservador((String) getTesteAPc().getGuiObservador().getSelectedItem());
		testeA.setObstinado((String) getTesteAPc().getGuiObstinado().getSelectedItem());
		testeA.setOriginal((String) getTesteAPc().getGuiOriginal().getSelectedItem());
		testeA.setOusado((String) getTesteAPc().getGuiOusado().getSelectedItem());
		testeA.setPaciente((String) getTesteAPc().getGuiPaciente().getSelectedItem());
		testeA.setPacifico((String) getTesteAPc().getGuiPacifico().getSelectedItem());
		testeA.setPassivo((String) getTesteAPc().getGuiPassivo().getSelectedItem());
		testeA.setPerfeccionista((String) getTesteAPc().getGuiPerfeccionista().getSelectedItem());
		testeA.setPersistente((String) getTesteAPc().getGuiPersistente().getSelectedItem());
		testeA.setPersuasivo((String) getTesteAPc().getGuiPersuasivo().getSelectedItem());
		testeA.setPessimista((String) getTesteAPc().getGuiPessimista().getSelectedItem());
		testeA.setPonderado((String) getTesteAPc().getGuiPonderado().getSelectedItem());
		testeA.setPratico((String) getTesteAPc().getGuiPratico().getSelectedItem());
		testeA.setPrecavido((String) getTesteAPc().getGuiPrecavido().getSelectedItem());
		testeA.setPreciso((String) getTesteAPc().getGuiPreciso().getSelectedItem());
		testeA.setPreocupado((String) getTesteAPc().getGuiPreocupado().getSelectedItem());
		testeA.setPrevenido((String) getTesteAPc().getGuiPrevenido().getSelectedItem());
		testeA.setPrevisivel((String) getTesteAPc().getGuiPrevisivel().getSelectedItem());
		testeA.setRealista((String) getTesteAPc().getGuiRealista().getSelectedItem());
		testeA.setRebelde((String) getTesteAPc().getGuiRebelde().getSelectedItem());
		testeA.setReceoso((String) getTesteAPc().getGuiReceoso().getSelectedItem());
		testeA.setReservado((String) getTesteAPc().getGuiReservado().getSelectedItem());
		testeA.setRespeitoso((String) getTesteAPc().getGuiRespeitoso().getSelectedItem());
		testeA.setSarcastico((String) getTesteAPc().getGuiSarcastico().getSelectedItem());
		testeA.setSeguro((String) getTesteAPc().getGuiSeguro().getSelectedItem());
		testeA.setSemLimites((String) getTesteAPc().getGuiSemLimites().getSelectedItem());
		testeA.setSensato((String) getTesteAPc().getGuiSensato().getSelectedItem());
		testeA.setSereno((String) getTesteAPc().getGuiSereno().getSelectedItem());
		testeA.setSerio((String) getTesteAPc().getGuiSerio().getSelectedItem());
		testeA.setSimpatico((String) getTesteAPc().getGuiSimpatico().getSelectedItem());
		testeA.setSistematico((String) getTesteAPc().getGuiSistematico().getSelectedItem());
		testeA.setSociavel((String) getTesteAPc().getGuiSociavel().getSelectedItem());
		testeA.setTeimoso((String) getTesteAPc().getGuiTeimoso().getSelectedItem());
		testeA.setVersatil((String) getTesteAPc().getGuiVersatil().getSelectedItem());
	}

	public TesteA getTesteA() {
		return testeA;
	}

	public TesteAFc getTesteAFc() {
		return MainCont.getCurriculoTesteAFc();
	}

	public TesteAFp getTesteAFp() {
		return MainCont.getCurriculoTesteAFp();
	}

	public TesteAPc getTesteAPc() {
		return MainCont.getCurriculoTesteAFc().getTesteAPc();
	}

	public TesteAPp getTesteAPp() {
		return MainCont.getCurriculoTesteAFp().getCertificadoPp();
	}

	public void setTesteA(TesteA TesteA) {
		this.testeA = TesteA;
	}
}
