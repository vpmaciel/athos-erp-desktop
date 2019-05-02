package erp.curriculo.caracteristica;

import java.awt.Cursor;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import erp.funcionario.Funcionario;
import erp.funcionario.FuncionarioComp;
import erp.funcionario.FuncionarioFac;
import erp.main.MainCont;

@SuppressWarnings("serial")
public final class CaracteristicaPc extends JPanel implements Gui {

	private ToolBar toolBar;
	private ConfiguracaoGui configuracaoGui;
	private JLabel labelFuncionario;
	private JComboBox<Funcionario> boxFuncionario;
	private JLabel labelSimpatico;
	private JComboBox<String> boxSimpatico;
	private JLabel labelCuidadoso;
	private JComboBox<String> boxCuidadoso;
	private JLabel labelPreocupado;
	private JComboBox<String> boxPreocupado;
	private JLabel labelInquieto;
	private JComboBox<String> boxInquieto;
	private JLabel labelEstavel;
	private JComboBox<String> boxEstavel;
	private JLabel labelDespretensioso;
	private JComboBox<String> boxDespretensioso;
	private JLabel labelBemHumorado;
	private JComboBox<String> boxBemHumorado;
	private JLabel labelIncerto;
	private JComboBox<String> boxIncerto;
	private JLabel labelExigente;
	private JComboBox<String> boxExigente;
	private JLabel labelInteressado;
	private JComboBox<String> boxInteressado;
	private JLabel labelDependente;
	private JComboBox<String> boxDependente;
	private JLabel labelPacifico;
	private JComboBox<String> boxPacifico;
	private JLabel labelArticulado;
	private JComboBox<String> boxArticulado;
	private JLabel labelPrevisivel;
	private JComboBox<String> boxPrevisivel;
	private JLabel labelSeguro;
	private JComboBox<String> boxSeguro;
	private JLabel labelDedicado;
	private JComboBox<String> boxDedicado;
	private JLabel labelPersuasivo;
	private JComboBox<String> boxPersuasivo;
	private JLabel labelEncantador;
	private JComboBox<String> boxEncantador;
	private JLabel labelTeimoso;
	private JComboBox<String> boxTeimoso;
	private JLabel labelCompetitivo;
	private JComboBox<String> boxCompetitivo;
	private JLabel labelMaleavel;
	private JComboBox<String> boxMaleavel;
	private JLabel labelObediente;
	private JComboBox<String> boxObediente;
	private JLabel labelIntrospectivo;
	private JComboBox<String> boxIntrospectivo;
	private JLabel labelPerfeccionista;
	private JComboBox<String> boxPerfeccionista;
	private JLabel labelPrecavido;
	private JComboBox<String> boxPrecavido;
	private JLabel labelPratico;
	private JComboBox<String> boxPratico;
	private JLabel labelImpulsivo;
	private JComboBox<String> boxImpulsivo;
	private JLabel labelSemLimites;
	private JComboBox<String> boxSemLimites;
	private JLabel labelIndiferente;
	private JComboBox<String> boxIndiferente;
	private JLabel labelAgil;
	private JComboBox<String> boxAgil;
	private JLabel labelSociavel;
	private JComboBox<String> boxSociavel;
	private JLabel labelCarismatico;
	private JComboBox<String> boxCarismatico;
	private JLabel labelPassivo;
	private JComboBox<String> boxPassivo;
	private JLabel labelOusado;
	private JComboBox<String> boxOusado;
	private JLabel labelIndependente;
	private JComboBox<String> boxIndependente;
	private JLabel labelCauteloso;
	private JComboBox<String> boxCauteloso;
	private JLabel labelConvincente;
	private JComboBox<String> boxConvincente;
	private JLabel labelAlegre;
	private JComboBox<String> boxAlegre;
	private JLabel labelDestemido;
	private JComboBox<String> boxDestemido;
	private JLabel labelMenteAberta;
	private JComboBox<String> boxMenteAberta;
	private JLabel labelInspirador;
	private JComboBox<String> boxInspirador;
	private JLabel labelFirme;
	private JComboBox<String> boxFirme;
	private JLabel labelPreciso;
	private JComboBox<String> boxPreciso;
	private JLabel labelDesprendido;
	private JComboBox<String> boxDesprendido;
	private JLabel labelObstinado;
	private JComboBox<String> boxObstinado;
	private JLabel labelCalmo;
	private JComboBox<String> boxCalmo;
	private JLabel labelLeal;
	private JComboBox<String> boxLeal;
	private JLabel labelAmavel;
	private JComboBox<String> boxAmavel;
	private JLabel labelContido;
	private JComboBox<String> boxContido;
	private JLabel labelEmpolgado;
	private JComboBox<String> boxEmpolgado;
	private JLabel labelCompreensivo;
	private JComboBox<String> boxCompreensivo;
	private JLabel labelExtrovertido;
	private JComboBox<String> boxExtrovertido;
	private JLabel labelPrevenido;
	private JComboBox<String> boxPrevenido;
	private JLabel labelVersatil;
	private JComboBox<String> boxVersatil;
	private JLabel labelEnergico;
	private JComboBox<String> boxEnergico;
	private JLabel labelPersistente;
	private JComboBox<String> boxPersistente;
	private JLabel labelDesligado;
	private JComboBox<String> boxDesligado;
	private JLabel labelDivertido;
	private JComboBox<String> boxDivertido;
	private JLabel labelObjetivo;
	private JComboBox<String> boxObjetivo;
	private JLabel labelAssumeRiscosCalculados;
	private JComboBox<String> boxAssumeRiscosCalculados;
	private JLabel labelDisciplinado;
	private JComboBox<String> boxDisciplinado;
	private JLabel labelMeticuloso;
	private JComboBox<String> boxMeticuloso;
	private JLabel labelPonderado;
	private JComboBox<String> boxPonderado;
	private JLabel labelObservador;
	private JComboBox<String> boxObservador;
	private JLabel labelAnsioso;
	private JComboBox<String> boxAnsioso;
	private JLabel labelAnalitico;
	private JComboBox<String> boxAnalitico;
	private JLabel labelAnimado;
	private JComboBox<String> boxAnimado;
	private JLabel labelDiscreto;
	private JComboBox<String> boxDiscreto;
	private JLabel labelOriginal;
	private JComboBox<String> boxOriginal;
	private JLabel labelConciliador;
	private JComboBox<String> boxConciliador;
	private JLabel labelLiberal;
	private JComboBox<String> boxLiberal;
	private JLabel labelSarcastico;
	private JComboBox<String> boxSarcastico;
	private JLabel labelPessimista;
	private JComboBox<String> boxPessimista;
	private JLabel labelRebelde;
	private JComboBox<String> boxRebelde;
	private JLabel labelDiplomatico;
	private JComboBox<String> boxDiplomatico;
	private JLabel labelDireto;
	private JComboBox<String> boxDireto;
	private JLabel labelAtencioso;
	private JComboBox<String> boxAtencioso;
	private JLabel labelDominador;
	private JComboBox<String> boxDominador;
	private JLabel labelReceoso;
	private JComboBox<String> boxReceoso;
	private JLabel labelRespeitoso;
	private JComboBox<String> boxRespeitoso;
	private JLabel labelDescrente;
	private JComboBox<String> boxDescrente;
	private JLabel labelAgitado;
	private JComboBox<String> boxAgitado;
	private JLabel labelInfluente;
	private JComboBox<String> boxInfluente;
	private JLabel labelDisponivel;
	private JComboBox<String> boxDisponivel;
	private JLabel labelExpansivo;
	private JComboBox<String> boxExpansivo;
	private JLabel labelConvencional;
	private JComboBox<String> boxConvencional;
	private JLabel labelPaciente;
	private JComboBox<String> boxPaciente;
	private JLabel labelAventureiro;
	private JComboBox<String> boxAventureiro;
	private JLabel labelDecidido;
	private JComboBox<String> boxDecidido;
	private JLabel labelRealista;
	private JComboBox<String> boxRealista;
	private JLabel labelExpressivo;
	private JComboBox<String> boxExpressivo;
	private JLabel labelDeterminado;
	private JComboBox<String> boxDeterminado;
	private JLabel labelFechado;
	private JComboBox<String> boxFechado;
	private JLabel labelAutoconfiante;
	private JComboBox<String> boxAutoconfiante;
	private JLabel labelSensato;
	private JComboBox<String> boxSensato;
	private JLabel labelAdequado;
	private JComboBox<String> boxAdequado;
	private JLabel labelEspontaneo;
	private JComboBox<String> boxEspontaneo;
	private JLabel labelAtivo;
	private JComboBox<String> boxAtivo;
	private JLabel labelDesconfiado;
	private JComboBox<String> boxDesconfiado;
	private JLabel labelLivre;
	private JComboBox<String> boxLivre;
	private JLabel labelJusto;
	private JComboBox<String> boxJusto;
	private JLabel labelDesencanado;
	private JComboBox<String> boxDesencanado;
	private JLabel labelLogico;
	private JComboBox<String> boxLogico;
	private JLabel labelApatico;
	private JComboBox<String> boxApatico;
	private JLabel labelReservado;
	private JComboBox<String> boxReservado;
	private JLabel labelHumilde;
	private JComboBox<String> boxHumilde;
	private JLabel labelEgocentrico;
	private JComboBox<String> boxEgocentrico;
	private JLabel labelSistematico;
	private JComboBox<String> boxSistematico;
	private JLabel labelGostaDeSeArriscar;
	private JComboBox<String> boxGostaDeSeArriscar;
	private JLabel labelSereno;
	private JComboBox<String> boxSereno;
	private JLabel labelCortes;
	private JComboBox<String> boxCortes;
	private JLabel labelSerio;
	private JComboBox<String> boxSerio;

	public JLabel getLabelFuncionario() {
		return labelFuncionario;
	}
	
	public JComboBox<Funcionario> getGuiFuncionario() {
		return boxFuncionario;
	}

	public JComboBox<String> getGuiSimpatico() {
		return boxSimpatico;
	}

	public JComboBox<String> getGuiCuidadoso() {
		return boxCuidadoso;
	}

	public JComboBox<String> getGuiPreocupado() {
		return boxPreocupado;
	}

	public JComboBox<String> getGuiInquieto() {
		return boxInquieto;
	}

	public JComboBox<String> getGuiEstavel() {
		return boxEstavel;
	}

	public JComboBox<String> getGuiDespretensioso() {
		return boxDespretensioso;
	}

	public JComboBox<String> getGuiBemHumorado() {
		return boxBemHumorado;
	}

	public JComboBox<String> getGuiIncerto() {
		return boxIncerto;
	}

	public JComboBox<String> getGuiExigente() {
		return boxExigente;
	}

	public JComboBox<String> getGuiInteressado() {
		return boxInteressado;
	}

	public JComboBox<String> getGuiDependente() {
		return boxDependente;
	}

	public JComboBox<String> getGuiPacifico() {
		return boxPacifico;
	}

	public JComboBox<String> getGuiArticulado() {
		return boxArticulado;
	}

	public JComboBox<String> getGuiPrevisivel() {
		return boxPrevisivel;
	}

	public JComboBox<String> getGuiSeguro() {
		return boxSeguro;
	}

	public JComboBox<String> getGuiDedicado() {
		return boxDedicado;
	}

	public JComboBox<String> getGuiPersuasivo() {
		return boxPersuasivo;
	}

	public JComboBox<String> getGuiEncantador() {
		return boxEncantador;
	}

	public JComboBox<String> getGuiTeimoso() {
		return boxTeimoso;
	}

	public JComboBox<String> getGuiCompetitivo() {
		return boxCompetitivo;
	}

	public JComboBox<String> getGuiMaleavel() {
		return boxMaleavel;
	}

	public JComboBox<String> getGuiObediente() {
		return boxObediente;
	}

	public JComboBox<String> getGuiIntrospectivo() {
		return boxIntrospectivo;
	}

	public JComboBox<String> getGuiPerfeccionista() {
		return boxPerfeccionista;
	}

	public JComboBox<String> getGuiPrecavido() {
		return boxPrecavido;
	}

	public JComboBox<String> getGuiPratico() {
		return boxPratico;
	}

	public JComboBox<String> getGuiImpulsivo() {
		return boxImpulsivo;
	}

	public JComboBox<String> getGuiSemLimites() {
		return boxSemLimites;
	}

	public JComboBox<String> getGuiIndiferente() {
		return boxIndiferente;
	}

	public JComboBox<String> getGuiAgil() {
		return boxAgil;
	}

	public JComboBox<String> getGuiSociavel() {
		return boxSociavel;
	}

	public JComboBox<String> getGuiCarismatico() {
		return boxCarismatico;
	}

	public JComboBox<String> getGuiPassivo() {
		return boxPassivo;
	}

	public JComboBox<String> getGuiOusado() {
		return boxOusado;
	}

	public JComboBox<String> getGuiIndependente() {
		return boxIndependente;
	}

	public JComboBox<String> getGuiCauteloso() {
		return boxCauteloso;
	}

	public JComboBox<String> getGuiConvincente() {
		return boxConvincente;
	}

	public JComboBox<String> getGuiAlegre() {
		return boxAlegre;
	}

	public JComboBox<String> getGuiDestemido() {
		return boxDestemido;
	}

	public JComboBox<String> getGuiMenteAberta() {
		return boxMenteAberta;
	}

	public JComboBox<String> getGuiInspirador() {
		return boxInspirador;
	}

	public JComboBox<String> getGuiFirme() {
		return boxFirme;
	}

	public JComboBox<String> getGuiPreciso() {
		return boxPreciso;
	}

	public JComboBox<String> getGuiDesprendido() {
		return boxDesprendido;
	}

	public JComboBox<String> getGuiObstinado() {
		return boxObstinado;
	}

	public JComboBox<String> getGuiCalmo() {
		return boxCalmo;
	}

	public JComboBox<String> getGuiLeal() {
		return boxLeal;
	}

	public JComboBox<String> getGuiAmavel() {
		return boxAmavel;
	}

	public JComboBox<String> getGuiContido() {
		return boxContido;
	}

	public JComboBox<String> getGuiEmpolgado() {
		return boxEmpolgado;
	}

	public JComboBox<String> getGuiCompreensivo() {
		return boxCompreensivo;
	}

	public JComboBox<String> getGuiExtrovertido() {
		return boxExtrovertido;
	}

	public JComboBox<String> getGuiPrevenido() {
		return boxPrevenido;
	}

	public JComboBox<String> getGuiVersatil() {
		return boxVersatil;
	}

	public JComboBox<String> getGuiEnergico() {
		return boxEnergico;
	}

	public JComboBox<String> getGuiPersistente() {
		return boxPersistente;
	}

	public JComboBox<String> getGuiDesligado() {
		return boxDesligado;
	}

	public JComboBox<String> getGuiDivertido() {
		return boxDivertido;
	}

	public JComboBox<String> getGuiObjetivo() {
		return boxObjetivo;
	}

	public JComboBox<String> getGuiAssumeRiscosCalculados() {
		return boxAssumeRiscosCalculados;
	}

	public JComboBox<String> getGuiDisciplinado() {
		return boxDisciplinado;
	}

	public JComboBox<String> getGuiMeticuloso() {
		return boxMeticuloso;
	}

	public JComboBox<String> getGuiPonderado() {
		return boxPonderado;
	}

	public JComboBox<String> getGuiObservador() {
		return boxObservador;
	}

	public JComboBox<String> getGuiAnsioso() {
		return boxAnsioso;
	}

	public JComboBox<String> getGuiAnalitico() {
		return boxAnalitico;
	}

	public JComboBox<String> getGuiAnimado() {
		return boxAnimado;
	}

	public JComboBox<String> getGuiDiscreto() {
		return boxDiscreto;
	}

	public JComboBox<String> getGuiOriginal() {
		return boxOriginal;
	}

	public JComboBox<String> getGuiConciliador() {
		return boxConciliador;
	}

	public JComboBox<String> getGuiLiberal() {
		return boxLiberal;
	}

	public JComboBox<String> getGuiSarcastico() {
		return boxSarcastico;
	}

	public JComboBox<String> getGuiPessimista() {
		return boxPessimista;
	}

	public JComboBox<String> getGuiRebelde() {
		return boxRebelde;
	}

	public JComboBox<String> getGuiDiplomatico() {
		return boxDiplomatico;
	}

	public JComboBox<String> getGuiDireto() {
		return boxDireto;
	}

	public JComboBox<String> getGuiAtencioso() {
		return boxAtencioso;
	}

	public JComboBox<String> getGuiDominador() {
		return boxDominador;
	}

	public JComboBox<String> getGuiReceoso() {
		return boxReceoso;
	}

	public JComboBox<String> getGuiRespeitoso() {
		return boxRespeitoso;
	}

	public JComboBox<String> getGuiDescrente() {
		return boxDescrente;
	}

	public JComboBox<String> getGuiAgitado() {
		return boxAgitado;
	}

	public JComboBox<String> getGuiInfluente() {
		return boxInfluente;
	}

	public JComboBox<String> getGuiDisponivel() {
		return boxDisponivel;
	}

	public JComboBox<String> getGuiExpansivo() {
		return boxExpansivo;
	}

	public JComboBox<String> getGuiConvencional() {
		return boxConvencional;
	}

	public JComboBox<String> getGuiPaciente() {
		return boxPaciente;
	}

	public JComboBox<String> getGuiAventureiro() {
		return boxAventureiro;
	}

	public JComboBox<String> getGuiDecidido() {
		return boxDecidido;
	}

	public JComboBox<String> getGuiRealista() {
		return boxRealista;
	}

	public JComboBox<String> getGuiExpressivo() {
		return boxExpressivo;
	}

	public JComboBox<String> getGuiDeterminado() {
		return boxDeterminado;
	}

	public JComboBox<String> getGuiFechado() {
		return boxFechado;
	}

	public JComboBox<String> getGuiAutoConfiante() {
		return boxAutoconfiante;
	}

	public JComboBox<String> getGuiSensato() {
		return boxSensato;
	}

	public JComboBox<String> getGuiAdequado() {
		return boxAdequado;
	}

	public JComboBox<String> getGuiEspontaneo() {
		return boxEspontaneo;
	}

	public JComboBox<String> getGuiAtivo() {
		return boxAtivo;
	}

	public JComboBox<String> getGuiDesconfiado() {
		return boxDesconfiado;
	}

	public JComboBox<String> getGuiLivre() {
		return boxLivre;
	}

	public JComboBox<String> getGuiJusto() {
		return boxJusto;
	}

	public JComboBox<String> getGuiDesencanado() {
		return boxDesencanado;
	}

	public JComboBox<String> getGuiLogico() {
		return boxLogico;
	}

	public JComboBox<String> getGuiApatico() {
		return boxApatico;
	}

	public JComboBox<String> getGuiReservado() {
		return boxReservado;
	}

	public JComboBox<String> getGuiHumilde() {
		return boxHumilde;
	}

	public JComboBox<String> getGuiEgocentrico() {
		return boxEgocentrico;
	}

	public JComboBox<String> getGuiSistematico() {
		return boxSistematico;
	}

	public JComboBox<String> getGuiGostaDeSeArriscar() {
		return boxGostaDeSeArriscar;
	}

	public JComboBox<String> getGuiSereno() {
		return boxSereno;
	}

	public JComboBox<String> getGuiCortes() {
		return boxCortes;
	}

	public JComboBox<String> getGuiSerio() {
		return boxSerio;
	}

	public CaracteristicaPc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public JComboBox<String> getBancoGui() {
		return boxSimpatico;
	}

	public ToolBar getTB() {
		return toolBar;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		
		final Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

		toolBar = new ToolBar();
		add(toolBar.getToolBar());

		labelFuncionario = new JLabel("FUNCIONÁRIO");
		labelFuncionario.setCursor(cursor);
		add(labelFuncionario);

		boxFuncionario = new JComboBox<Funcionario>();
		List<Funcionario> funcionarios = (List<Funcionario>) FuncionarioFac.getRegistro();
		Collections.sort(funcionarios, new FuncionarioComp().new Nome());
		for (Funcionario funcionario : funcionarios) {
			boxFuncionario.addItem(funcionario);
		}
		
		add(boxFuncionario);

		labelAdequado = new JLabel("ADEQUADO");
		add(labelAdequado);

		boxAdequado = new JComboBox<String>();
		boxAdequado.addItem("");
		boxAdequado.addItem("SIM");
		boxAdequado.addItem("NÃO");
		add(boxAdequado);

		labelAgil = new JLabel("ÁGIL");
		add(labelAgil);

		boxAgil = new JComboBox<String>();
		boxAgil.addItem("");
		boxAgil.addItem("SIM");
		boxAgil.addItem("NÃO");
		add(boxAgil);

		labelAgitado = new JLabel("AGITADO");
		add(labelAgitado);

		boxAgitado = new JComboBox<String>();
		boxAgitado.addItem("");
		boxAgitado.addItem("SIM");
		boxAgitado.addItem("NÃO");
		add(boxAgitado);

		labelAlegre = new JLabel("ALEGRE");
		add(labelAlegre);

		boxAlegre = new JComboBox<String>();
		boxAlegre.addItem("");
		boxAlegre.addItem("SIM");
		boxAlegre.addItem("NÃO");
		add(boxAlegre);

		labelAmavel = new JLabel("AMÁVEL");
		add(labelAmavel);

		boxAmavel = new JComboBox<String>();
		boxAmavel.addItem("");
		boxAmavel.addItem("SIM");
		boxAmavel.addItem("NÃO");
		add(boxAmavel);

		labelAnalitico = new JLabel("ANALÍTICO");
		add(labelAnalitico);

		boxAnalitico = new JComboBox<String>();
		boxAnalitico.addItem("");
		boxAnalitico.addItem("SIM");
		boxAnalitico.addItem("NÃO");
		add(boxAnalitico);

		labelAnimado = new JLabel("ANIMADO");
		add(labelAnimado);

		boxAnimado = new JComboBox<String>();
		boxAnimado.addItem("");
		boxAnimado.addItem("SIM");
		boxAnimado.addItem("NÃO");
		add(boxAnimado);

		labelAnsioso = new JLabel("ANSIOSO");
		add(labelAnsioso);

		boxAnsioso = new JComboBox<String>();
		boxAnsioso.addItem("");
		boxAnsioso.addItem("SIM");
		boxAnsioso.addItem("NÃO");
		add(boxAnsioso);

		labelApatico = new JLabel("APÁTICO");
		add(labelApatico);

		boxApatico = new JComboBox<String>();
		boxApatico.addItem("");
		boxApatico.addItem("SIM");
		boxApatico.addItem("NÃO");
		add(boxApatico);

		labelArticulado = new JLabel("ARTICULADO");
		add(labelArticulado);

		boxArticulado = new JComboBox<String>();
		boxArticulado.addItem("");
		boxArticulado.addItem("SIM");
		boxArticulado.addItem("NÃO");
		add(boxArticulado);

		labelAssumeRiscosCalculados = new JLabel("ASSUME RISCOS CALCULADOS");
		add(labelAssumeRiscosCalculados);

		boxAssumeRiscosCalculados = new JComboBox<String>();
		boxAssumeRiscosCalculados.addItem("");
		boxAssumeRiscosCalculados.addItem("SIM");
		boxAssumeRiscosCalculados.addItem("NÃO");
		add(boxAssumeRiscosCalculados);

		labelAtencioso = new JLabel("ATENCIOSO");
		add(labelAtencioso);

		boxAtencioso = new JComboBox<String>();
		boxAtencioso.addItem("");
		boxAtencioso.addItem("SIM");
		boxAtencioso.addItem("NÃO");
		add(boxAtencioso);

		labelAtivo = new JLabel("ATIVO");
		add(labelAtivo);

		boxAtivo = new JComboBox<String>();
		boxAtivo.addItem("");
		boxAtivo.addItem("SIM");
		boxAtivo.addItem("NÃO");
		add(boxAtivo);

		labelAutoconfiante = new JLabel("AUTO CONFIANTE");
		add(labelAutoconfiante);

		boxAutoconfiante = new JComboBox<String>();
		boxAutoconfiante.addItem("");
		boxAutoconfiante.addItem("SIM");
		boxAutoconfiante.addItem("NÃO");
		add(boxAutoconfiante);

		labelAventureiro = new JLabel("AVENTUREIRO");
		add(labelAventureiro);

		boxAventureiro = new JComboBox<String>();
		boxAventureiro.addItem("");
		boxAventureiro.addItem("SIM");
		boxAventureiro.addItem("NÃO");
		add(boxAventureiro);

		labelBemHumorado = new JLabel("BEM HUMORADO");
		add(labelBemHumorado);

		boxBemHumorado = new JComboBox<String>();
		boxBemHumorado.addItem("");
		boxBemHumorado.addItem("SIM");
		boxBemHumorado.addItem("NÃO");
		add(boxBemHumorado);

		labelCalmo = new JLabel("CALMO");
		add(labelCalmo);

		boxCalmo = new JComboBox<String>();
		boxCalmo.addItem("");
		boxCalmo.addItem("SIM");
		boxCalmo.addItem("NÃO");
		add(boxCalmo);

		labelCarismatico = new JLabel("CARISMÁTICO");
		add(labelCarismatico);

		boxCarismatico = new JComboBox<String>();
		boxCarismatico.addItem("");
		boxCarismatico.addItem("SIM");
		boxCarismatico.addItem("NÃO");
		add(boxCarismatico);

		labelCauteloso = new JLabel("CAUTELOSO");
		add(labelCauteloso);

		boxCauteloso = new JComboBox<String>();
		boxCauteloso.addItem("");
		boxCauteloso.addItem("SIM");
		boxCauteloso.addItem("NÃO");
		add(boxCauteloso);

		labelCompetitivo = new JLabel("COMPETITIVO");
		add(labelCompetitivo);

		boxCompetitivo = new JComboBox<String>();
		boxCompetitivo.addItem("");
		boxCompetitivo.addItem("SIM");
		boxCompetitivo.addItem("NÃO");
		add(boxCompetitivo);

		labelCompreensivo = new JLabel("COMPREENSIVO");
		add(labelCompreensivo);

		boxCompreensivo = new JComboBox<String>();
		boxCompreensivo.addItem("");
		boxCompreensivo.addItem("SIM");
		boxCompreensivo.addItem("NÃO");
		add(boxCompreensivo);

		labelConciliador = new JLabel("CONCILIADOR");
		add(labelConciliador);

		boxConciliador = new JComboBox<String>();
		boxConciliador.addItem("");
		boxConciliador.addItem("SIM");
		boxConciliador.addItem("NÃO");
		add(boxConciliador);

		labelContido = new JLabel("CONTIDO");
		add(labelContido);

		boxContido = new JComboBox<String>();
		boxContido.addItem("");
		boxContido.addItem("SIM");
		boxContido.addItem("NÃO");
		add(boxContido);

		labelConvencional = new JLabel("CONVENCIONAL");
		add(labelConvencional);

		boxConvencional = new JComboBox<String>();
		boxConvencional.addItem("");
		boxConvencional.addItem("SIM");
		boxConvencional.addItem("NÃO");
		add(boxConvencional);

		labelConvincente = new JLabel("CONVINCENTE");
		add(labelConvincente);

		boxConvincente = new JComboBox<String>();
		boxConvincente.addItem("");
		boxConvincente.addItem("SIM");
		boxConvincente.addItem("NÃO");
		add(boxConvincente);

		labelCortes = new JLabel("CORTÊS");
		add(labelCortes);

		boxCortes = new JComboBox<String>();
		boxCortes.addItem("");
		boxCortes.addItem("SIM");
		boxCortes.addItem("NÃO");
		add(boxCortes);

		labelCuidadoso = new JLabel("CUIDADOSO");
		add(labelCuidadoso);

		boxCuidadoso = new JComboBox<String>();
		boxCuidadoso.addItem("");
		boxCuidadoso.addItem("SIM");
		boxCuidadoso.addItem("NÃO");
		add(boxCuidadoso);

		labelDecidido = new JLabel("DECIDIDO");
		add(labelDecidido);

		boxDecidido = new JComboBox<String>();
		boxDecidido.addItem("");
		boxDecidido.addItem("SIM");
		boxDecidido.addItem("NÃO");
		add(boxDecidido);

		labelDedicado = new JLabel("DEDICADO");
		add(labelDedicado);

		boxDedicado = new JComboBox<String>();
		boxDedicado.addItem("");
		boxDedicado.addItem("SIM");
		boxDedicado.addItem("NÃO");
		add(boxDedicado);

		labelDependente = new JLabel("DEPENDENTE");
		add(labelDependente);

		boxDependente = new JComboBox<String>();
		boxDependente.addItem("");
		boxDependente.addItem("SIM");
		boxDependente.addItem("NÃO");
		add(boxDependente);

		labelDesconfiado = new JLabel("DESCONFIADO");
		add(labelDesconfiado);

		boxDesconfiado = new JComboBox<String>();
		boxDesconfiado.addItem("");
		boxDesconfiado.addItem("SIM");
		boxDesconfiado.addItem("NÃO");
		add(boxDesconfiado);

		labelDescrente = new JLabel("DESCRENTE");
		add(labelDescrente);

		boxDescrente = new JComboBox<String>();
		boxDescrente.addItem("");
		boxDescrente.addItem("SIM");
		boxDescrente.addItem("NÃO");
		add(boxDescrente);

		labelDesencanado = new JLabel("DESENCANADO");
		add(labelDesencanado);

		boxDesencanado = new JComboBox<String>();
		boxDesencanado.addItem("");
		boxDesencanado.addItem("SIM");
		boxDesencanado.addItem("NÃO");
		add(boxDesencanado);

		labelDesligado = new JLabel("DESLIGADO");
		add(labelDesligado);

		boxDesligado = new JComboBox<String>();
		boxDesligado.addItem("");
		boxDesligado.addItem("SIM");
		boxDesligado.addItem("NÃO");
		add(boxDesligado);

		labelDesprendido = new JLabel("DESPRENDIDO");
		add(labelDesprendido);

		boxDesprendido = new JComboBox<String>();
		boxDesprendido.addItem("");
		boxDesprendido.addItem("SIM");
		boxDesprendido.addItem("NÃO");
		add(boxDesprendido);

		labelDespretensioso = new JLabel("DESPRETENSIOSO");
		add(labelDespretensioso);

		boxDespretensioso = new JComboBox<String>();
		boxDespretensioso.addItem("");
		boxDespretensioso.addItem("SIM");
		boxDespretensioso.addItem("NÃO");
		add(boxDespretensioso);

		labelDestemido = new JLabel("DESTEMIDO");
		add(labelDestemido);

		boxDestemido = new JComboBox<String>();
		boxDestemido.addItem("");
		boxDestemido.addItem("SIM");
		boxDestemido.addItem("NÃO");
		add(boxDestemido);

		labelDeterminado = new JLabel("DETERMINADO");
		add(labelDeterminado);

		boxDeterminado = new JComboBox<String>();
		boxDeterminado.addItem("");
		boxDeterminado.addItem("SIM");
		boxDeterminado.addItem("NÃO");
		add(boxDeterminado);

		labelDiplomatico = new JLabel("DIPLOMÁTICO");
		add(labelDiplomatico);

		boxDiplomatico = new JComboBox<String>();
		boxDiplomatico.addItem("");
		boxDiplomatico.addItem("SIM");
		boxDiplomatico.addItem("NÃO");
		add(boxDiplomatico);

		labelDireto = new JLabel("DIRETO");
		add(labelDireto);

		boxDireto = new JComboBox<String>();
		boxDireto.addItem("");
		boxDireto.addItem("SIM");
		boxDireto.addItem("NÃO");
		add(boxDireto);

		labelDisciplinado = new JLabel("DISCIPLINADO");
		add(labelDisciplinado);

		boxDisciplinado = new JComboBox<String>();
		boxDisciplinado.addItem("");
		boxDisciplinado.addItem("SIM");
		boxDisciplinado.addItem("NÃO");
		add(boxDisciplinado);

		labelDiscreto = new JLabel("DISCRETO");
		add(labelDiscreto);

		boxDiscreto = new JComboBox<String>();
		boxDiscreto.addItem("");
		boxDiscreto.addItem("SIM");
		boxDiscreto.addItem("NÃO");
		add(boxDiscreto);

		labelDisponivel = new JLabel("DISPONÍVEL");
		add(labelDisponivel);

		boxDisponivel = new JComboBox<String>();
		boxDisponivel.addItem("");
		boxDisponivel.addItem("SIM");
		boxDisponivel.addItem("NÃO");
		add(boxDisponivel);

		labelDivertido = new JLabel("DIVERTIDO");
		add(labelDivertido);

		boxDivertido = new JComboBox<String>();
		boxDivertido.addItem("");
		boxDivertido.addItem("SIM");
		boxDivertido.addItem("NÃO");
		add(boxDivertido);

		labelDominador = new JLabel("DOMINADOR");
		add(labelDominador);

		boxDominador = new JComboBox<String>();
		boxDominador.addItem("");
		boxDominador.addItem("SIM");
		boxDominador.addItem("NÃO");
		add(boxDominador);

		labelEgocentrico = new JLabel("EGOCÊNTRICO");
		add(labelEgocentrico);

		boxEgocentrico = new JComboBox<String>();
		boxEgocentrico.addItem("");
		boxEgocentrico.addItem("SIM");
		boxEgocentrico.addItem("NÃO");
		add(boxEgocentrico);

		labelEmpolgado = new JLabel("EMPOLGADO");
		add(labelEmpolgado);

		boxEmpolgado = new JComboBox<String>();
		boxEmpolgado.addItem("");
		boxEmpolgado.addItem("SIM");
		boxEmpolgado.addItem("NÃO");
		add(boxEmpolgado);

		labelEncantador = new JLabel("ENCANTADOR");
		add(labelEncantador);

		boxEncantador = new JComboBox<String>();
		boxEncantador.addItem("");
		boxEncantador.addItem("SIM");
		boxEncantador.addItem("NÃO");
		add(boxEncantador);

		labelEnergico = new JLabel("ENÉRGICO");
		add(labelEnergico);

		boxEnergico = new JComboBox<String>();
		boxEnergico.addItem("");
		boxEnergico.addItem("SIM");
		boxEnergico.addItem("NÃO");
		add(boxEnergico);

		labelEspontaneo = new JLabel("ESPONTÂNEO");
		add(labelEspontaneo);

		boxEspontaneo = new JComboBox<String>();
		boxEspontaneo.addItem("");
		boxEspontaneo.addItem("SIM");
		boxEspontaneo.addItem("NÃO");
		add(boxEspontaneo);

		labelEstavel = new JLabel("ESTÁVEL");
		add(labelEstavel);

		boxEstavel = new JComboBox<String>();
		boxEstavel.addItem("");
		boxEstavel.addItem("SIM");
		boxEstavel.addItem("NÃO");
		add(boxEstavel);

		labelExigente = new JLabel("EXIGENTE");
		add(labelExigente);

		boxExigente = new JComboBox<String>();
		boxExigente.addItem("");
		boxExigente.addItem("SIM");
		boxExigente.addItem("NÃO");
		add(boxExigente);

		labelExpansivo = new JLabel("EXPANSIVO");
		add(labelExpansivo);

		boxExpansivo = new JComboBox<String>();
		boxExpansivo.addItem("");
		boxExpansivo.addItem("SIM");
		boxExpansivo.addItem("NÃO");
		add(boxExpansivo);

		labelExpressivo = new JLabel("EXPRESSIVO");
		add(labelExpressivo);

		boxExpressivo = new JComboBox<String>();
		boxExpressivo.addItem("");
		boxExpressivo.addItem("SIM");
		boxExpressivo.addItem("NÃO");
		add(boxExpressivo);

		labelExtrovertido = new JLabel("EXTROVERTIDO");
		add(labelExtrovertido);

		boxExtrovertido = new JComboBox<String>();
		boxExtrovertido.addItem("");
		boxExtrovertido.addItem("SIM");
		boxExtrovertido.addItem("NÃO");
		add(boxExtrovertido);

		labelFechado = new JLabel("FECHADO");
		add(labelFechado);

		boxFechado = new JComboBox<String>();
		boxFechado.addItem("");
		boxFechado.addItem("SIM");
		boxFechado.addItem("NÃO");
		add(boxFechado);

		labelFirme = new JLabel("FIRME");
		add(labelFirme);

		boxFirme = new JComboBox<String>();
		boxFirme.addItem("");
		boxFirme.addItem("SIM");
		boxFirme.addItem("NÃO");
		add(boxFirme);

		labelGostaDeSeArriscar = new JLabel("GOSTA DE SE ARRRISCAR");
		add(labelGostaDeSeArriscar);

		boxGostaDeSeArriscar = new JComboBox<String>();
		boxGostaDeSeArriscar.addItem("");
		boxGostaDeSeArriscar.addItem("SIM");
		boxGostaDeSeArriscar.addItem("NÃO");
		add(boxGostaDeSeArriscar);

		labelHumilde = new JLabel("HUMILDE");
		add(labelHumilde);

		boxHumilde = new JComboBox<String>();
		boxHumilde.addItem("");
		boxHumilde.addItem("SIM");
		boxHumilde.addItem("NÃO");
		add(boxHumilde);

		labelImpulsivo = new JLabel("IMPULSIVO");
		add(labelImpulsivo);

		boxImpulsivo = new JComboBox<String>();
		boxImpulsivo.addItem("");
		boxImpulsivo.addItem("SIM");
		boxImpulsivo.addItem("NÃO");
		add(boxImpulsivo);

		labelIncerto = new JLabel("INCERTO");
		add(labelIncerto);

		boxIncerto = new JComboBox<String>();
		boxIncerto.addItem("");
		boxIncerto.addItem("SIM");
		boxIncerto.addItem("NÃO");
		add(boxIncerto);

		labelIndependente = new JLabel("INDEPENDENTE");
		add(labelIndependente);

		boxIndependente = new JComboBox<String>();
		boxIndependente.addItem("");
		boxIndependente.addItem("SIM");
		boxIndependente.addItem("NÃO");
		add(boxIndependente);

		labelIndiferente = new JLabel("INDIFERENTE");
		add(labelIndiferente);

		boxIndiferente = new JComboBox<String>();
		boxIndiferente.addItem("");
		boxIndiferente.addItem("SIM");
		boxIndiferente.addItem("NÃO");
		add(boxIndiferente);

		labelInfluente = new JLabel("INFLUENTE");
		add(labelInfluente);

		boxInfluente = new JComboBox<String>();
		boxInfluente.addItem("");
		boxInfluente.addItem("SIM");
		boxInfluente.addItem("NÃO");
		add(boxInfluente);

		labelInquieto = new JLabel("INQUIETO");
		add(labelInquieto);

		boxInquieto = new JComboBox<String>();
		boxInquieto.addItem("");
		boxInquieto.addItem("SIM");
		boxInquieto.addItem("NÃO");
		add(boxInquieto);

		labelInspirador = new JLabel("INSPIRADOR");
		add(labelInspirador);

		boxInspirador = new JComboBox<String>();
		boxInspirador.addItem("");
		boxInspirador.addItem("SIM");
		boxInspirador.addItem("NÃO");
		add(boxInspirador);

		labelInteressado = new JLabel("INTERESSADO");
		add(labelInteressado);

		boxInteressado = new JComboBox<String>();
		boxInteressado.addItem("");
		boxInteressado.addItem("SIM");
		boxInteressado.addItem("NÃO");
		add(boxInteressado);

		labelIntrospectivo = new JLabel("INTROSPECTIVO");
		add(labelIntrospectivo);

		boxIntrospectivo = new JComboBox<String>();
		boxIntrospectivo.addItem("");
		boxIntrospectivo.addItem("SIM");
		boxIntrospectivo.addItem("NÃO");
		add(boxIntrospectivo);

		labelJusto = new JLabel("JUSTO");
		add(labelJusto);

		boxJusto = new JComboBox<String>();
		boxJusto.addItem("");
		boxJusto.addItem("SIM");
		boxJusto.addItem("NÃO");
		add(boxJusto);

		labelLeal = new JLabel("LEAL");
		add(labelLeal);

		boxLeal = new JComboBox<String>();
		boxLeal.addItem("");
		boxLeal.addItem("SIM");
		boxLeal.addItem("NÃO");
		add(boxLeal);

		labelLiberal = new JLabel("LEAL");
		add(labelLiberal);

		boxLiberal = new JComboBox<String>();
		boxLiberal.addItem("");
		boxLiberal.addItem("SIM");
		boxLiberal.addItem("NÃO");
		add(boxLiberal);

		labelLivre = new JLabel("LIVRE");
		add(labelLivre);

		boxLivre = new JComboBox<String>();
		boxLivre.addItem("");
		boxLivre.addItem("SIM");
		boxLivre.addItem("NÃO");
		add(boxLivre);

		labelLogico = new JLabel("LÓGICO");
		add(labelLogico);

		boxLogico = new JComboBox<String>();
		boxLogico.addItem("");
		boxLogico.addItem("SIM");
		boxLogico.addItem("NÃO");
		add(boxLogico);

		labelMaleavel = new JLabel("MALEÁVEL");
		add(labelMaleavel);

		boxMaleavel = new JComboBox<String>();
		boxMaleavel.addItem("");
		boxMaleavel.addItem("SIM");
		boxMaleavel.addItem("NÃO");
		add(boxMaleavel);

		labelMenteAberta = new JLabel("MENTE ABERTA");
		add(labelMenteAberta);

		boxMenteAberta = new JComboBox<String>();
		boxMenteAberta.addItem("");
		boxMenteAberta.addItem("SIM");
		boxMenteAberta.addItem("NÃO");
		add(boxMenteAberta);

		labelMeticuloso = new JLabel("METICULOSO");
		add(labelMeticuloso);

		boxMeticuloso = new JComboBox<String>();
		boxMeticuloso.addItem("");
		boxMeticuloso.addItem("SIM");
		boxMeticuloso.addItem("NÃO");
		add(boxMeticuloso);

		labelObediente = new JLabel("OBEDIENTE");
		add(labelObediente);

		boxObediente = new JComboBox<String>();
		boxObediente.addItem("");
		boxObediente.addItem("SIM");
		boxObediente.addItem("NÃO");
		add(boxObediente);

		labelObjetivo = new JLabel("OBJETIVO");
		add(labelObjetivo);

		boxObjetivo = new JComboBox<String>();
		boxObjetivo.addItem("");
		boxObjetivo.addItem("SIM");
		boxObjetivo.addItem("NÃO");
		add(boxObjetivo);

		labelObservador = new JLabel("OBSERVADOR");
		add(labelObservador);

		boxObservador = new JComboBox<String>();
		boxObservador.addItem("");
		boxObservador.addItem("SIM");
		boxObservador.addItem("NÃO");
		add(boxObservador);

		labelObstinado = new JLabel("OBSTINADO");
		add(labelObstinado);

		boxObstinado = new JComboBox<String>();
		boxObstinado.addItem("");
		boxObstinado.addItem("SIM");
		boxObstinado.addItem("NÃO");
		add(boxObstinado);

		labelOriginal = new JLabel("ORIGINAL");
		add(labelOriginal);

		boxOriginal = new JComboBox<String>();
		boxOriginal.addItem("");
		boxOriginal.addItem("SIM");
		boxOriginal.addItem("NÃO");
		add(boxOriginal);

		labelOusado = new JLabel("OUSADO");
		add(labelOusado);

		boxOusado = new JComboBox<String>();
		boxOusado.addItem("");
		boxOusado.addItem("SIM");
		boxOusado.addItem("NÃO");
		add(boxOusado);

		labelPaciente = new JLabel("PACIENTE");
		add(labelPaciente);

		boxPaciente = new JComboBox<String>();
		boxPaciente.addItem("");
		boxPaciente.addItem("SIM");
		boxPaciente.addItem("NÃO");
		add(boxPaciente);

		labelPacifico = new JLabel("PACÍFICO");
		add(labelPacifico);

		boxPacifico = new JComboBox<String>();
		boxPacifico.addItem("");
		boxPacifico.addItem("SIM");
		boxPacifico.addItem("NÃO");
		add(boxPacifico);

		labelPassivo = new JLabel("PASSIVO");
		add(labelPassivo);

		boxPassivo = new JComboBox<String>();
		boxPassivo.addItem("");
		boxPassivo.addItem("SIM");
		boxPassivo.addItem("NÃO");
		add(boxPassivo);

		labelPerfeccionista = new JLabel("PERFECCIONISTA");
		add(labelPerfeccionista);

		boxPerfeccionista = new JComboBox<String>();
		boxPerfeccionista.addItem("");
		boxPerfeccionista.addItem("SIM");
		boxPerfeccionista.addItem("NÃO");
		add(boxPerfeccionista);

		labelPersistente = new JLabel("PERSISTENTE");
		add(labelPersistente);

		boxPersistente = new JComboBox<String>();
		boxPersistente.addItem("");
		boxPersistente.addItem("SIM");
		boxPersistente.addItem("NÃO");
		add(boxPersistente);

		labelPersuasivo = new JLabel("PERSUASIVO");
		add(labelPersuasivo);

		boxPersuasivo = new JComboBox<String>();
		boxPersuasivo.addItem("");
		boxPersuasivo.addItem("SIM");
		boxPersuasivo.addItem("NÃO");
		add(boxPersuasivo);

		labelPessimista = new JLabel("PESSIMISTA");
		add(labelPessimista);

		boxPessimista = new JComboBox<String>();
		boxPessimista.addItem("");
		boxPessimista.addItem("SIM");
		boxPessimista.addItem("NÃO");
		add(boxPessimista);

		labelPonderado = new JLabel("PONDERADO");
		add(labelPonderado);

		boxPonderado = new JComboBox<String>();
		boxPonderado.addItem("");
		boxPonderado.addItem("SIM");
		boxPonderado.addItem("NÃO");
		add(boxPonderado);

		labelPratico = new JLabel("PRÁTICO");
		add(labelPratico);

		boxPratico = new JComboBox<String>();
		boxPratico.addItem("");
		boxPratico.addItem("SIM");
		boxPratico.addItem("NÃO");
		add(boxPratico);

		labelPrecavido = new JLabel("PRECAVIDO");
		add(labelPrecavido);

		boxPrecavido = new JComboBox<String>();
		boxPrecavido.addItem("");
		boxPrecavido.addItem("SIM");
		boxPrecavido.addItem("NÃO");
		add(boxPrecavido);

		labelPreciso = new JLabel("PRECISO");
		add(labelPreciso);

		boxPreciso = new JComboBox<String>();
		boxPreciso.addItem("");
		boxPreciso.addItem("SIM");
		boxPreciso.addItem("NÃO");
		add(boxPreciso);

		labelPreocupado = new JLabel("PREOCUPADO");
		add(labelPreocupado);

		boxPreocupado = new JComboBox<String>();
		boxPreocupado.addItem("");
		boxPreocupado.addItem("SIM");
		boxPreocupado.addItem("NÃO");
		add(boxPreocupado);

		labelPrevenido = new JLabel("PREVENIDO");
		add(labelPrevenido);

		boxPrevenido = new JComboBox<String>();
		boxPrevenido.addItem("");
		boxPrevenido.addItem("SIM");
		boxPrevenido.addItem("NÃO");
		add(boxPrevenido);

		labelPrevisivel = new JLabel("PREVISÍVEL");
		add(labelPrevisivel);

		boxPrevisivel = new JComboBox<String>();
		boxPrevisivel.addItem("");
		boxPrevisivel.addItem("SIM");
		boxPrevisivel.addItem("NÃO");
		add(boxPrevisivel);

		labelRealista = new JLabel("REALISTA");
		add(labelRealista);

		boxRealista = new JComboBox<String>();
		boxRealista.addItem("");
		boxRealista.addItem("SIM");
		boxRealista.addItem("NÃO");
		add(boxRealista);

		labelRebelde = new JLabel("REBELDE");
		add(labelRebelde);

		boxRebelde = new JComboBox<String>();
		boxRebelde.addItem("");
		boxRebelde.addItem("SIM");
		boxRebelde.addItem("NÃO");
		add(boxRebelde);

		labelReceoso = new JLabel("RECEOSO");
		add(labelReceoso);

		boxReceoso = new JComboBox<String>();
		boxReceoso.addItem("");
		boxReceoso.addItem("SIM");
		boxReceoso.addItem("NÃO");
		add(boxReceoso);

		labelReservado = new JLabel("RESERVADO");
		add(labelReservado);

		boxReservado = new JComboBox<String>();
		boxReservado.addItem("");
		boxReservado.addItem("SIM");
		boxReservado.addItem("NÃO");
		add(boxReservado);

		labelRespeitoso = new JLabel("RESPEITOSO");
		add(labelRespeitoso);

		boxRespeitoso = new JComboBox<String>();
		boxRespeitoso.addItem("");
		boxRespeitoso.addItem("SIM");
		boxRespeitoso.addItem("NÃO");
		add(boxRespeitoso);

		labelSarcastico = new JLabel("SARCÁSTICO");
		add(labelSarcastico);

		boxSarcastico = new JComboBox<String>();
		boxSarcastico.addItem("");
		boxSarcastico.addItem("SIM");
		boxSarcastico.addItem("NÃO");
		add(boxSarcastico);

		labelSeguro = new JLabel("SEGURO");
		add(labelSeguro);

		boxSeguro = new JComboBox<String>();
		boxSeguro.addItem("");
		boxSeguro.addItem("SIM");
		boxSeguro.addItem("NÃO");
		add(boxSeguro);

		labelSemLimites = new JLabel("SEM LIMITES");
		add(labelSemLimites);

		boxSemLimites = new JComboBox<String>();
		boxSemLimites.addItem("");
		boxSemLimites.addItem("SIM");
		boxSemLimites.addItem("NÃO");
		add(boxSemLimites);

		labelSensato = new JLabel("SENSATO");
		add(labelSensato);

		boxSensato = new JComboBox<String>();
		boxSensato.addItem("");
		boxSensato.addItem("SIM");
		boxSensato.addItem("NÃO");
		add(boxSensato);

		labelSereno = new JLabel("SERENO");
		add(labelSereno);

		boxSereno = new JComboBox<String>();
		boxSereno.addItem("");
		boxSereno.addItem("SIM");
		boxSereno.addItem("NÃO");
		add(boxSereno);

		labelSerio = new JLabel("SÉRIO");
		add(labelSerio);

		boxSerio = new JComboBox<String>();
		boxSerio.addItem("");
		boxSerio.addItem("SIM");
		boxSerio.addItem("NÃO");
		add(boxSerio);

		labelSimpatico = new JLabel("SIMPÁTICO");
		add(labelSimpatico);

		boxSimpatico = new JComboBox<String>();
		boxSimpatico.addItem("");
		boxSimpatico.addItem("SIM");
		boxSimpatico.addItem("NÃO");
		add(boxSimpatico);

		labelSistematico = new JLabel("SISTEMÁTICO");
		add(labelSistematico);

		boxSistematico = new JComboBox<String>();
		boxSistematico.addItem("");
		boxSistematico.addItem("SIM");
		boxSistematico.addItem("NÃO");
		add(boxSistematico);

		labelSociavel = new JLabel("SOCIÁVEL");
		add(labelSociavel);

		boxSociavel = new JComboBox<String>();
		boxSociavel.addItem("");
		boxSociavel.addItem("SIM");
		boxSociavel.addItem("NÃO");
		add(boxSociavel);

		labelTeimoso = new JLabel("TEIMOSO");
		add(labelTeimoso);

		boxTeimoso = new JComboBox<String>();
		boxTeimoso.addItem("");
		boxTeimoso.addItem("SIM");
		boxTeimoso.addItem("NÃO");
		add(boxTeimoso);

		labelVersatil = new JLabel("VERSÁTIL");
		add(labelVersatil);

		boxVersatil = new JComboBox<String>();
		boxVersatil.addItem("");
		boxVersatil.addItem("SIM");
		boxVersatil.addItem("NÃO");
		add(boxVersatil);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 227, 1, // rows, cols
				5, 5, // initX, initY
				5, 5); // xPad, yPad
		setOpaque(true); // content panes must be opaque
	}

	@Override
	public void iniciarGuiControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarControlador() {

	}

	@Override
	public void iniciarLayout() {
		setBorder(BorderFactory.createTitledBorder("CARACTERÍSTICAS"));
		setLayout(new SpringLayout());
	}

	@Override
	public void iniciarTabela() {

	}

	@Override
	public void limparGui() {
		configuracaoGui.limparGui();
	}

	@Override
	public void reiniciarGui() {
		Funcionario funcionario = null;
		List<Funcionario> funcionarios = (List<Funcionario>) FuncionarioFac.getRegistro();
		Collections.sort(funcionarios, new FuncionarioComp().new Nome());
		boxFuncionario.removeAllItems();
		for (Funcionario b : funcionarios) {
			boxFuncionario.addItem(b);
		}
		if (!MainCont.getCurriculoCaracteristicaFc().isShowing()
				&& MainCont.getCurriculoCaracteristicaFc().getCaracteristicaCont().getCaracteristica() != null) {
			funcionario = MainCont.getCurriculoCaracteristicaFc().getCaracteristicaCont().getCaracteristica()
					.getFuncionario();
			boxFuncionario.setSelectedItem(funcionario);
		}
	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}
}
