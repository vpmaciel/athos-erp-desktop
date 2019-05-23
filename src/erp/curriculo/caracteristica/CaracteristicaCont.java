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
			getCaracteristicaPc().getGuiAdequado().requestFocus();
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
			List<Caracteristica> caracteristicas = new LinkedList<>();

			if (caracteristica.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (caracteristicas.add(CaracteristicaFac.getRegistro(caracteristica))) {
				CaracteristicaRel caracteristicaRel = new CaracteristicaRel(caracteristicas);
				caracteristicaRel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getCaracteristicaPc().getLabelFuncionario()) {
				MainCont.mostrarFrame(MainCont.getFuncionarioFc());
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			caracteristica = new Caracteristica();
			getCaracteristicaFc().limparGui();
			getCaracteristicaPc().getGuiAdequado().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getCaracteristicaPp().pesquisarRegistro(caracteristica);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getCaracteristicaFp());
				getCaracteristicaFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getCaracteristicaPp().pesquisarRegistro(new Caracteristica());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getCaracteristicaFp());
				getCaracteristicaFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Caracteristica> caracteristicas = new LinkedList<>();

			try {
				caracteristicas = new LinkedList<>(CaracteristicaFac.pesquisarRegistro(new Caracteristica()));
			} catch (Exception e) {
				System.out.println(e);
			}

			CaracteristicaRel caracteristicaRel = new CaracteristicaRel(caracteristicas);
			caracteristicaRel.retornarRelatorio(true);

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
				if ((getCaracteristicaPc().getGuiFuncionario().getSelectedItem()) == null) {
					getCaracteristicaPc().getGuiFuncionario().requestFocus();
					Msg.avisoCampoObrigatorio("FUNCIONÁRIO");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					CaracteristicaFac.salvarRegistro(caracteristica);
					caracteristica = new Caracteristica();
					getCaracteristicaFc().limparGui();
					getCaracteristicaPc().getGuiAdequado().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroSalvarRegistro();
			}
		}
	}

	private Caracteristica caracteristica;

	public void atualizarGui() {
		if (caracteristica == null) {
			return;
		}
		getCaracteristicaPc().getGuiFuncionario().setSelectedItem(caracteristica.getFuncionario());
		getCaracteristicaPc().getGuiAdequado().setSelectedItem(caracteristica.getAdequado());
		getCaracteristicaPc().getGuiAgil().setSelectedItem(caracteristica.getAgil());
		getCaracteristicaPc().getGuiAgitado().setSelectedItem(caracteristica.getAgitado());
		getCaracteristicaPc().getGuiAlegre().setSelectedItem(caracteristica.getAlegre());
		getCaracteristicaPc().getGuiAmavel().setSelectedItem(caracteristica.getAmavel());
		getCaracteristicaPc().getGuiAnalitico().setSelectedItem(caracteristica.getAnalitico());
		getCaracteristicaPc().getGuiAnimado().setSelectedItem(caracteristica.getAnimado());
		getCaracteristicaPc().getGuiAnsioso().setSelectedItem(caracteristica.getAnsioso());
		getCaracteristicaPc().getGuiApatico().setSelectedItem(caracteristica.getApatico());
		getCaracteristicaPc().getGuiArticulado().setSelectedItem(caracteristica.getArticulado());
		getCaracteristicaPc().getGuiAssumeRiscosCalculados()
				.setSelectedItem(caracteristica.getAssumeRiscosCalculados());
		getCaracteristicaPc().getGuiAtencioso().setSelectedItem(caracteristica.getAtencioso());
		getCaracteristicaPc().getGuiAtivo().setSelectedItem(caracteristica.getAtivo());
		getCaracteristicaPc().getGuiAutoConfiante().setSelectedItem(caracteristica.getAutoConfiante());
		getCaracteristicaPc().getGuiAventureiro().setSelectedItem(caracteristica.getAventureiro());
		getCaracteristicaPc().getGuiBemHumorado().setSelectedItem(caracteristica.getBemHumorado());
		getCaracteristicaPc().getGuiCalmo().setSelectedItem(caracteristica.getCalmo());
		getCaracteristicaPc().getGuiCarismatico().setSelectedItem(caracteristica.getCarismatico());
		getCaracteristicaPc().getGuiCauteloso().setSelectedItem(caracteristica.getCauteloso());
		getCaracteristicaPc().getGuiCompetitivo().setSelectedItem(caracteristica.getCompetitivo());
		getCaracteristicaPc().getGuiCompreensivo().setSelectedItem(caracteristica.getCompreensivo());
		getCaracteristicaPc().getGuiConciliador().setSelectedItem(caracteristica.getConciliador());
		getCaracteristicaPc().getGuiContido().setSelectedItem(caracteristica.getContido());
		getCaracteristicaPc().getGuiConvencional().setSelectedItem(caracteristica.getConvencional());
		getCaracteristicaPc().getGuiConvincente().setSelectedItem(caracteristica.getConvincente());
		getCaracteristicaPc().getGuiCortes().setSelectedItem(caracteristica.getCortes());
		getCaracteristicaPc().getGuiCuidadoso().setSelectedItem(caracteristica.getCuidadoso());
		getCaracteristicaPc().getGuiDecidido().setSelectedItem(caracteristica.getDecidido());
		getCaracteristicaPc().getGuiDedicado().setSelectedItem(caracteristica.getDedicado());
		getCaracteristicaPc().getGuiDependente().setSelectedItem(caracteristica.getDependente());
		getCaracteristicaPc().getGuiDesconfiado().setSelectedItem(caracteristica.getDesconfiado());
		getCaracteristicaPc().getGuiDescrente().setSelectedItem(caracteristica.getDescrente());
		getCaracteristicaPc().getGuiDesencanado().setSelectedItem(caracteristica.getDesencanado());
		getCaracteristicaPc().getGuiDesligado().setSelectedItem(caracteristica.getDesligado());
		getCaracteristicaPc().getGuiDespretensioso().setSelectedItem(caracteristica.getDespretensioso());
		getCaracteristicaPc().getGuiDesprendido().setSelectedItem(caracteristica.getDesprendido());
		getCaracteristicaPc().getGuiDestemido().setSelectedItem(caracteristica.getDestemido());
		getCaracteristicaPc().getGuiDeterminado().setSelectedItem(caracteristica.getDeterminado());
		getCaracteristicaPc().getGuiDiplomatico().setSelectedItem(caracteristica.getDiplomatico());
		getCaracteristicaPc().getGuiDireto().setSelectedItem(caracteristica.getDireto());
		getCaracteristicaPc().getGuiDisciplinado().setSelectedItem(caracteristica.getDisciplinado());
		getCaracteristicaPc().getGuiDiscreto().setSelectedItem(caracteristica.getDiscreto());
		getCaracteristicaPc().getGuiDisponivel().setSelectedItem(caracteristica.getDisponivel());
		getCaracteristicaPc().getGuiDivertido().setSelectedItem(caracteristica.getDivertido());
		getCaracteristicaPc().getGuiDominador().setSelectedItem(caracteristica.getDominador());
		getCaracteristicaPc().getGuiEgocentrico().setSelectedItem(caracteristica.getEgocentrico());
		getCaracteristicaPc().getGuiEmpolgado().setSelectedItem(caracteristica.getEmpolgado());
		getCaracteristicaPc().getGuiEncantador().setSelectedItem(caracteristica.getEncantador());
		getCaracteristicaPc().getGuiEnergico().setSelectedItem(caracteristica.getEnergico());
		getCaracteristicaPc().getGuiEspontaneo().setSelectedItem(caracteristica.getEspontaneo());
		getCaracteristicaPc().getGuiEstavel().setSelectedItem(caracteristica.getEstavel());
		getCaracteristicaPc().getGuiExigente().setSelectedItem(caracteristica.getExigente());
		getCaracteristicaPc().getGuiExpansivo().setSelectedItem(caracteristica.getExpansivo());
		getCaracteristicaPc().getGuiExpressivo().setSelectedItem(caracteristica.getExpressivo());
		getCaracteristicaPc().getGuiExtrovertido().setSelectedItem(caracteristica.getExtrovertido());
		getCaracteristicaPc().getGuiFechado().setSelectedItem(caracteristica.getFechado());
		getCaracteristicaPc().getGuiFirme().setSelectedItem(caracteristica.getFirme());
		getCaracteristicaPc().getGuiFuncionario().setSelectedItem(caracteristica.getFuncionario());
		getCaracteristicaPc().getGuiGostaDeSeArriscar().setSelectedItem(caracteristica.getGostaDeSeArriscar());
		getCaracteristicaPc().getGuiHumilde().setSelectedItem(caracteristica.getHumilde());
		getCaracteristicaPc().getGuiImpulsivo().setSelectedItem(caracteristica.getImpulsivo());
		getCaracteristicaPc().getGuiIncerto().setSelectedItem(caracteristica.getIncerto());
		getCaracteristicaPc().getGuiIndependente().setSelectedItem(caracteristica.getIndependente());
		getCaracteristicaPc().getGuiIndiferente().setSelectedItem(caracteristica.getIndiferente());
		getCaracteristicaPc().getGuiInfluente().setSelectedItem(caracteristica.getInfluente());
		getCaracteristicaPc().getGuiInquieto().setSelectedItem(caracteristica.getInquieto());
		getCaracteristicaPc().getGuiInspirador().setSelectedItem(caracteristica.getInspirador());
		getCaracteristicaPc().getGuiInteressado().setSelectedItem(caracteristica.getInteressado());
		getCaracteristicaPc().getGuiIntrospectivo().setSelectedItem(caracteristica.getIntrospectivo());
		getCaracteristicaPc().getGuiJusto().setSelectedItem(caracteristica.getJusto());
		getCaracteristicaPc().getGuiLeal().setSelectedItem(caracteristica.getLeal());
		getCaracteristicaPc().getGuiLiberal().setSelectedItem(caracteristica.getLiberal());
		getCaracteristicaPc().getGuiLivre().setSelectedItem(caracteristica.getLivre());
		getCaracteristicaPc().getGuiLogico().setSelectedItem(caracteristica.getLogico());
		getCaracteristicaPc().getGuiMaleavel().setSelectedItem(caracteristica.getMaleavel());
		getCaracteristicaPc().getGuiMenteAberta().setSelectedItem(caracteristica.getMenteAberta());
		getCaracteristicaPc().getGuiMeticuloso().setSelectedItem(caracteristica.getMeticuloso());
		getCaracteristicaPc().getGuiObediente().setSelectedItem(caracteristica.getObediente());
		getCaracteristicaPc().getGuiObjetivo().setSelectedItem(caracteristica.getObjetivo());
		getCaracteristicaPc().getGuiObservador().setSelectedItem(caracteristica.getObservador());
		getCaracteristicaPc().getGuiObstinado().setSelectedItem(caracteristica.getObstinado());
		getCaracteristicaPc().getGuiOriginal().setSelectedItem(caracteristica.getOriginal());
		getCaracteristicaPc().getGuiOusado().setSelectedItem(caracteristica.getOusado());
		getCaracteristicaPc().getGuiPaciente().setSelectedItem(caracteristica.getPaciente());
		getCaracteristicaPc().getGuiPacifico().setSelectedItem(caracteristica.getPacifico());
		getCaracteristicaPc().getGuiPassivo().setSelectedItem(caracteristica.getPassivo());
		getCaracteristicaPc().getGuiPerfeccionista().setSelectedItem(caracteristica.getPerfeccionista());
		getCaracteristicaPc().getGuiPersistente().setSelectedItem(caracteristica.getPersistente());
		getCaracteristicaPc().getGuiPersuasivo().setSelectedItem(caracteristica.getPersuasivo());
		getCaracteristicaPc().getGuiPessimista().setSelectedItem(caracteristica.getPessimista());
		getCaracteristicaPc().getGuiPonderado().setSelectedItem(caracteristica.getPonderado());
		getCaracteristicaPc().getGuiPratico().setSelectedItem(caracteristica.getPratico());
		getCaracteristicaPc().getGuiPrecavido().setSelectedItem(caracteristica.getPrecavido());
		getCaracteristicaPc().getGuiPreciso().setSelectedItem(caracteristica.getPreciso());
		getCaracteristicaPc().getGuiPreocupado().setSelectedItem(caracteristica.getPreocupado());
		getCaracteristicaPc().getGuiPrevenido().setSelectedItem(caracteristica.getPrevenido());
		getCaracteristicaPc().getGuiPrevisivel().setSelectedItem(caracteristica.getPrevisivel());
		getCaracteristicaPc().getGuiRealista().setSelectedItem(caracteristica.getRealista());
		getCaracteristicaPc().getGuiRebelde().setSelectedItem(caracteristica.getRebelde());
		getCaracteristicaPc().getGuiReceoso().setSelectedItem(caracteristica.getReceoso());
		getCaracteristicaPc().getGuiReservado().setSelectedItem(caracteristica.getReservado());
		getCaracteristicaPc().getGuiRespeitoso().setSelectedItem(caracteristica.getRespeitoso());
		getCaracteristicaPc().getGuiSarcastico().setSelectedItem(caracteristica.getSarcastico());
		getCaracteristicaPc().getGuiSeguro().setSelectedItem(caracteristica.getSeguro());
		getCaracteristicaPc().getGuiSemLimites().setSelectedItem(caracteristica.getSemLimites());
		getCaracteristicaPc().getGuiSensato().setSelectedItem(caracteristica.getSensato());
		getCaracteristicaPc().getGuiSereno().setSelectedItem(caracteristica.getSereno());
		getCaracteristicaPc().getGuiSerio().setSelectedItem(caracteristica.getSerio());
		getCaracteristicaPc().getGuiSimpatico().setSelectedItem(caracteristica.getSimpatico());
		getCaracteristicaPc().getGuiSistematico().setSelectedItem(caracteristica.getSistematico());
		getCaracteristicaPc().getGuiSociavel().setSelectedItem(caracteristica.getSociavel());
		getCaracteristicaPc().getGuiTeimoso().setSelectedItem(caracteristica.getTeimoso());
		getCaracteristicaPc().getGuiVersatil().setSelectedItem(caracteristica.getVersatil());
	}

	public void atualizarObjeto() {
		caracteristica.setFuncionario((Funcionario) getCaracteristicaPc().getGuiFuncionario().getSelectedItem());
		caracteristica.setAdequado((String) getCaracteristicaPc().getGuiAdequado().getSelectedItem());
		caracteristica.setAgil((String) getCaracteristicaPc().getGuiAgil().getSelectedItem());
		caracteristica.setAgitado((String) getCaracteristicaPc().getGuiAgitado().getSelectedItem());
		caracteristica.setAlegre((String) getCaracteristicaPc().getGuiAlegre().getSelectedItem());
		caracteristica.setAmavel((String) getCaracteristicaPc().getGuiAmavel().getSelectedItem());
		caracteristica.setAnalitico((String) getCaracteristicaPc().getGuiAnalitico().getSelectedItem());
		caracteristica.setAnimado((String) getCaracteristicaPc().getGuiAnimado().getSelectedItem());
		caracteristica.setAnsioso((String) getCaracteristicaPc().getGuiAnsioso().getSelectedItem());
		caracteristica.setApatico((String) getCaracteristicaPc().getGuiApatico().getSelectedItem());
		caracteristica.setArticulado((String) getCaracteristicaPc().getGuiArticulado().getSelectedItem());
		caracteristica.setAssumeRiscosCalculados(
				(String) getCaracteristicaPc().getGuiAssumeRiscosCalculados().getSelectedItem());
		caracteristica.setAtencioso((String) getCaracteristicaPc().getGuiAtencioso().getSelectedItem());
		caracteristica.setAtivo((String) getCaracteristicaPc().getGuiAtivo().getSelectedItem());
		caracteristica.setAutoconfiante((String) getCaracteristicaPc().getGuiAutoConfiante().getSelectedItem());
		caracteristica.setAventureiro((String) getCaracteristicaPc().getGuiAventureiro().getSelectedItem());
		caracteristica.setBemHumorado((String) getCaracteristicaPc().getGuiBemHumorado().getSelectedItem());
		caracteristica.setCalmo((String) getCaracteristicaPc().getGuiCalmo().getSelectedItem());
		caracteristica.setCarismatico((String) getCaracteristicaPc().getGuiCarismatico().getSelectedItem());
		caracteristica.setCauteloso((String) getCaracteristicaPc().getGuiCauteloso().getSelectedItem());
		caracteristica.setCompetitivo((String) getCaracteristicaPc().getGuiCompetitivo().getSelectedItem());
		caracteristica.setCompreensivo((String) getCaracteristicaPc().getGuiCompreensivo().getSelectedItem());
		caracteristica.setConciliador((String) getCaracteristicaPc().getGuiConciliador().getSelectedItem());
		caracteristica.setContido((String) getCaracteristicaPc().getGuiContido().getSelectedItem());
		caracteristica.setConvencional((String) getCaracteristicaPc().getGuiConvencional().getSelectedItem());
		caracteristica.setConvincente((String) getCaracteristicaPc().getGuiConvincente().getSelectedItem());
		caracteristica.setCortes((String) getCaracteristicaPc().getGuiCortes().getSelectedItem());
		caracteristica.setCuidadoso((String) getCaracteristicaPc().getGuiCuidadoso().getSelectedItem());
		caracteristica.setDecidido((String) getCaracteristicaPc().getGuiDecidido().getSelectedItem());
		caracteristica.setDedicado((String) getCaracteristicaPc().getGuiDedicado().getSelectedItem());
		caracteristica.setDependente((String) getCaracteristicaPc().getGuiDependente().getSelectedItem());
		caracteristica.setDesconfiado((String) getCaracteristicaPc().getGuiDesconfiado().getSelectedItem());
		caracteristica.setDescrente((String) getCaracteristicaPc().getGuiDescrente().getSelectedItem());
		caracteristica.setDesencanado((String) getCaracteristicaPc().getGuiDesencanado().getSelectedItem());
		caracteristica.setDesligado((String) getCaracteristicaPc().getGuiDesligado().getSelectedItem());
		caracteristica.setDespretensioso((String) getCaracteristicaPc().getGuiDespretensioso().getSelectedItem());
		caracteristica.setDesprendido((String) getCaracteristicaPc().getGuiDesprendido().getSelectedItem());
		caracteristica.setDestemido((String) getCaracteristicaPc().getGuiDestemido().getSelectedItem());
		caracteristica.setDeterminado((String) getCaracteristicaPc().getGuiDeterminado().getSelectedItem());
		caracteristica.setDiplomatico((String) getCaracteristicaPc().getGuiDiplomatico().getSelectedItem());
		caracteristica.setDireto((String) getCaracteristicaPc().getGuiDireto().getSelectedItem());
		caracteristica.setDisciplinado((String) getCaracteristicaPc().getGuiDisciplinado().getSelectedItem());
		caracteristica.setDiscreto((String) getCaracteristicaPc().getGuiDiscreto().getSelectedItem());
		caracteristica.setDisponivel((String) getCaracteristicaPc().getGuiDisponivel().getSelectedItem());
		caracteristica.setDivertido((String) getCaracteristicaPc().getGuiDivertido().getSelectedItem());
		caracteristica.setDominador((String) getCaracteristicaPc().getGuiDominador().getSelectedItem());
		caracteristica.setEgocentrico((String) getCaracteristicaPc().getGuiEgocentrico().getSelectedItem());
		caracteristica.setEmpolgado((String) getCaracteristicaPc().getGuiEmpolgado().getSelectedItem());
		caracteristica.setEncantador((String) getCaracteristicaPc().getGuiEncantador().getSelectedItem());
		caracteristica.setEnergico((String) getCaracteristicaPc().getGuiEnergico().getSelectedItem());
		caracteristica.setEspontaneo((String) getCaracteristicaPc().getGuiEspontaneo().getSelectedItem());
		caracteristica.setEstavel((String) getCaracteristicaPc().getGuiEstavel().getSelectedItem());
		caracteristica.setExigente((String) getCaracteristicaPc().getGuiExigente().getSelectedItem());
		caracteristica.setExpansivo((String) getCaracteristicaPc().getGuiExpansivo().getSelectedItem());
		caracteristica.setExpressivo((String) getCaracteristicaPc().getGuiExpressivo().getSelectedItem());
		caracteristica.setExtrovertido((String) getCaracteristicaPc().getGuiExtrovertido().getSelectedItem());
		caracteristica.setFechado((String) getCaracteristicaPc().getGuiFechado().getSelectedItem());
		caracteristica.setFirme((String) getCaracteristicaPc().getGuiFirme().getSelectedItem());
		caracteristica.setFuncionario((Funcionario) getCaracteristicaPc().getGuiFuncionario().getSelectedItem());
		caracteristica.setGostaDeSeArriscar((String) getCaracteristicaPc().getGuiGostaDeSeArriscar().getSelectedItem());
		caracteristica.setHumilde((String) getCaracteristicaPc().getGuiHumilde().getSelectedItem());
		caracteristica.setImpulsivo((String) getCaracteristicaPc().getGuiImpulsivo().getSelectedItem());
		caracteristica.setIncerto((String) getCaracteristicaPc().getGuiIncerto().getSelectedItem());
		caracteristica.setIndependente((String) getCaracteristicaPc().getGuiIndependente().getSelectedItem());
		caracteristica.setIndiferente((String) getCaracteristicaPc().getGuiIndiferente().getSelectedItem());
		caracteristica.setInfluente((String) getCaracteristicaPc().getGuiInfluente().getSelectedItem());
		caracteristica.setInquieto((String) getCaracteristicaPc().getGuiInquieto().getSelectedItem());
		caracteristica.setInspirador((String) getCaracteristicaPc().getGuiInspirador().getSelectedItem());
		caracteristica.setInteressado((String) getCaracteristicaPc().getGuiInteressado().getSelectedItem());
		caracteristica.setIntrospectivo((String) getCaracteristicaPc().getGuiIntrospectivo().getSelectedItem());
		caracteristica.setJusto((String) getCaracteristicaPc().getGuiJusto().getSelectedItem());
		caracteristica.setLeal((String) getCaracteristicaPc().getGuiLeal().getSelectedItem());
		caracteristica.setLiberal((String) getCaracteristicaPc().getGuiLiberal().getSelectedItem());
		caracteristica.setLivre((String) getCaracteristicaPc().getGuiLivre().getSelectedItem());
		caracteristica.setLogico((String) getCaracteristicaPc().getGuiLogico().getSelectedItem());
		caracteristica.setMaleavel((String) getCaracteristicaPc().getGuiMaleavel().getSelectedItem());
		caracteristica.setMenteAberta((String) getCaracteristicaPc().getGuiMenteAberta().getSelectedItem());
		caracteristica.setMeticuloso((String) getCaracteristicaPc().getGuiMeticuloso().getSelectedItem());
		caracteristica.setObediente((String) getCaracteristicaPc().getGuiObediente().getSelectedItem());
		caracteristica.setObjetivo((String) getCaracteristicaPc().getGuiObjetivo().getSelectedItem());
		caracteristica.setObservador((String) getCaracteristicaPc().getGuiObservador().getSelectedItem());
		caracteristica.setObstinado((String) getCaracteristicaPc().getGuiObstinado().getSelectedItem());
		caracteristica.setOriginal((String) getCaracteristicaPc().getGuiOriginal().getSelectedItem());
		caracteristica.setOusado((String) getCaracteristicaPc().getGuiOusado().getSelectedItem());
		caracteristica.setPaciente((String) getCaracteristicaPc().getGuiPaciente().getSelectedItem());
		caracteristica.setPacifico((String) getCaracteristicaPc().getGuiPacifico().getSelectedItem());
		caracteristica.setPassivo((String) getCaracteristicaPc().getGuiPassivo().getSelectedItem());
		caracteristica.setPerfeccionista((String) getCaracteristicaPc().getGuiPerfeccionista().getSelectedItem());
		caracteristica.setPersistente((String) getCaracteristicaPc().getGuiPersistente().getSelectedItem());
		caracteristica.setPersuasivo((String) getCaracteristicaPc().getGuiPersuasivo().getSelectedItem());
		caracteristica.setPessimista((String) getCaracteristicaPc().getGuiPessimista().getSelectedItem());
		caracteristica.setPonderado((String) getCaracteristicaPc().getGuiPonderado().getSelectedItem());
		caracteristica.setPratico((String) getCaracteristicaPc().getGuiPratico().getSelectedItem());
		caracteristica.setPrecavido((String) getCaracteristicaPc().getGuiPrecavido().getSelectedItem());
		caracteristica.setPreciso((String) getCaracteristicaPc().getGuiPreciso().getSelectedItem());
		caracteristica.setPreocupado((String) getCaracteristicaPc().getGuiPreocupado().getSelectedItem());
		caracteristica.setPrevenido((String) getCaracteristicaPc().getGuiPrevenido().getSelectedItem());
		caracteristica.setPrevisivel((String) getCaracteristicaPc().getGuiPrevisivel().getSelectedItem());
		caracteristica.setRealista((String) getCaracteristicaPc().getGuiRealista().getSelectedItem());
		caracteristica.setRebelde((String) getCaracteristicaPc().getGuiRebelde().getSelectedItem());
		caracteristica.setReceoso((String) getCaracteristicaPc().getGuiReceoso().getSelectedItem());
		caracteristica.setReservado((String) getCaracteristicaPc().getGuiReservado().getSelectedItem());
		caracteristica.setRespeitoso((String) getCaracteristicaPc().getGuiRespeitoso().getSelectedItem());
		caracteristica.setSarcastico((String) getCaracteristicaPc().getGuiSarcastico().getSelectedItem());
		caracteristica.setSeguro((String) getCaracteristicaPc().getGuiSeguro().getSelectedItem());
		caracteristica.setSemLimites((String) getCaracteristicaPc().getGuiSemLimites().getSelectedItem());
		caracteristica.setSensato((String) getCaracteristicaPc().getGuiSensato().getSelectedItem());
		caracteristica.setSereno((String) getCaracteristicaPc().getGuiSereno().getSelectedItem());
		caracteristica.setSerio((String) getCaracteristicaPc().getGuiSerio().getSelectedItem());
		caracteristica.setSimpatico((String) getCaracteristicaPc().getGuiSimpatico().getSelectedItem());
		caracteristica.setSistematico((String) getCaracteristicaPc().getGuiSistematico().getSelectedItem());
		caracteristica.setSociavel((String) getCaracteristicaPc().getGuiSociavel().getSelectedItem());
		caracteristica.setTeimoso((String) getCaracteristicaPc().getGuiTeimoso().getSelectedItem());
		caracteristica.setVersatil((String) getCaracteristicaPc().getGuiVersatil().getSelectedItem());
	}

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

	public CaracteristicaFc getCaracteristicaFc() {
		return MainCont.getCurriculoCaracteristicaFc();
	}

	public CaracteristicaFp getCaracteristicaFp() {
		return MainCont.getCurriculoCaracteristicaFp();
	}

	public CaracteristicaPc getCaracteristicaPc() {
		return MainCont.getCurriculoCaracteristicaFc().getCaracteristicaPc();
	}

	public CaracteristicaPp getCaracteristicaPp() {
		return MainCont.getCurriculoCaracteristicaFp().getCertificadoPp();
	}

	public void setCaracteristica(Caracteristica Caracteristica) {
		this.caracteristica = Caracteristica;
	}
}
