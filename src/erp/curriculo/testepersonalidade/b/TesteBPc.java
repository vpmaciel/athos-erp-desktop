package erp.curriculo.testepersonalidade.b;

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
import arquitetura.gui.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import erp.funcionario.Funcionario;
import erp.funcionario.FuncionarioComp;
import erp.funcionario.FuncionarioFac;
import erp.main.MainCont;

@SuppressWarnings("serial")
public final class TesteBPc extends JPanel implements Gui {

	private JComboBox<String> boxAdequado;
	private JComboBox<String> boxAgil;
	private JComboBox<String> boxAgitado;
	private JComboBox<String> boxAlegre;
	private JComboBox<String> boxAmavel;
	private JComboBox<String> boxAnalitico;
	private JComboBox<String> boxAnimado;
	private JComboBox<String> boxAnsioso;
	private JComboBox<String> boxApatico;
	private JComboBox<String> boxArticulado;
	private JComboBox<String> boxAssumeRiscosCalculados;
	private JComboBox<String> boxAtencioso;
	private JComboBox<String> boxAtivo;
	private JComboBox<String> boxAutoconfiante;
	private JComboBox<String> boxAventureiro;
	private JComboBox<String> boxBemHumorado;
	private JComboBox<String> boxCalmo;
	private JComboBox<String> boxCarismatico;
	private JComboBox<String> boxCauteloso;
	private JComboBox<String> boxCompetitivo;
	private JComboBox<String> boxCompreensivo;
	private JComboBox<String> boxConciliador;
	private JComboBox<String> boxContido;
	private JComboBox<String> boxConvencional;
	private JComboBox<String> boxConvincente;
	private JComboBox<String> boxCortes;
	private JComboBox<String> boxCuidadoso;
	private JComboBox<String> boxDecidido;
	private JComboBox<String> boxDedicado;
	private JComboBox<String> boxDependente;
	private JComboBox<String> boxDesconfiado;
	private JComboBox<String> boxDescrente;
	private JComboBox<String> boxDesencanado;
	private JComboBox<String> boxDesligado;
	private JComboBox<String> boxDesprendido;
	private JComboBox<String> boxDespretensioso;
	private JComboBox<String> boxDestemido;
	private JComboBox<String> boxDeterminado;
	private JComboBox<String> boxDiplomatico;
	private JComboBox<String> boxDireto;
	private JComboBox<String> boxDisciplinado;
	private JComboBox<String> boxDiscreto;
	private JComboBox<String> boxDisponivel;
	private JComboBox<String> boxDivertido;
	private JComboBox<String> boxDominador;
	private JComboBox<String> boxEgocentrico;
	private JComboBox<String> boxEmpolgado;
	private JComboBox<String> boxEncantador;
	private JComboBox<String> boxEnergico;
	private JComboBox<String> boxEspontaneo;
	private JComboBox<String> boxEstavel;
	private JComboBox<String> boxExigente;
	private JComboBox<String> boxExpansivo;
	private JComboBox<String> boxExpressivo;
	private JComboBox<String> boxExtrovertido;
	private JComboBox<String> boxFechado;
	private JComboBox<String> boxFirme;
	private JComboBox<Funcionario> boxFuncionario;
	private JComboBox<String> boxGostaDeSeArriscar;
	private JComboBox<String> boxHumilde;
	private JComboBox<String> boxImpulsivo;
	private JComboBox<String> boxIncerto;
	private JComboBox<String> boxIndependente;
	private JComboBox<String> boxIndiferente;
	private JComboBox<String> boxInfluente;
	private JComboBox<String> boxInquieto;
	private JComboBox<String> boxInspirador;
	private JComboBox<String> boxInteressado;
	private JComboBox<String> boxIntrospectivo;
	private JComboBox<String> boxJusto;
	private JComboBox<String> boxLeal;
	private JComboBox<String> boxLiberal;
	private JComboBox<String> boxLivre;
	private JComboBox<String> boxLogico;
	private JComboBox<String> boxMaleavel;
	private JComboBox<String> boxMenteAberta;
	private JComboBox<String> boxMeticuloso;
	private JComboBox<String> boxObediente;
	private JComboBox<String> boxObjetivo;
	private JComboBox<String> boxObservador;
	private JComboBox<String> boxObstinado;
	private JComboBox<String> boxOriginal;
	private JComboBox<String> boxOusado;
	private JComboBox<String> boxPaciente;
	private JComboBox<String> boxPacifico;
	private JComboBox<String> boxPassivo;
	private JComboBox<String> boxPerfeccionista;
	private JComboBox<String> boxPersistente;
	private JComboBox<String> boxPersuasivo;
	private JComboBox<String> boxPessimista;
	private JComboBox<String> boxPonderado;
	private JComboBox<String> boxPratico;
	private JComboBox<String> boxPrecavido;
	private JComboBox<String> boxPreciso;
	private JComboBox<String> boxPreocupado;
	private JComboBox<String> boxPrevenido;
	private JComboBox<String> boxPrevisivel;
	private JComboBox<String> boxRealista;
	private JComboBox<String> boxRebelde;
	private JComboBox<String> boxReceoso;
	private JComboBox<String> boxReservado;
	private JComboBox<String> boxRespeitoso;
	private JComboBox<String> boxSarcastico;
	private JComboBox<String> boxSeguro;
	private JComboBox<String> boxSemLimites;
	private JComboBox<String> boxSensato;
	private JComboBox<String> boxSereno;
	private JComboBox<String> boxSerio;
	private JComboBox<String> boxSimpatico;
	private JComboBox<String> boxSistematico;
	private JComboBox<String> boxSociavel;
	private JComboBox<String> boxTeimoso;
	private JComboBox<String> boxVersatil;
	private ConfiguracaoGui configuracaoGui;
	private JLabel labelFuncionario;
	private ToolBar toolBar;

	public TesteBPc() {
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

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public JComboBox<String> getGuiAdequado() {
		return boxAdequado;
	}

	public JComboBox<String> getGuiAgil() {
		return boxAgil;
	}

	public JComboBox<String> getGuiAgitado() {
		return boxAgitado;
	}

	public JComboBox<String> getGuiAlegre() {
		return boxAlegre;
	}

	public JComboBox<String> getGuiAmavel() {
		return boxAmavel;
	}

	public JComboBox<String> getGuiAnalitico() {
		return boxAnalitico;
	}

	public JComboBox<String> getGuiAnimado() {
		return boxAnimado;
	}

	public JComboBox<String> getGuiAnsioso() {
		return boxAnsioso;
	}

	public JComboBox<String> getGuiApatico() {
		return boxApatico;
	}

	public JComboBox<String> getGuiArticulado() {
		return boxArticulado;
	}

	public JComboBox<String> getGuiAssumeRiscosCalculados() {
		return boxAssumeRiscosCalculados;
	}

	public JComboBox<String> getGuiAtencioso() {
		return boxAtencioso;
	}

	public JComboBox<String> getGuiAtivo() {
		return boxAtivo;
	}

	public JComboBox<String> getGuiAutoConfiante() {
		return boxAutoconfiante;
	}

	public JComboBox<String> getGuiAventureiro() {
		return boxAventureiro;
	}

	public JComboBox<String> getGuiBemHumorado() {
		return boxBemHumorado;
	}

	public JComboBox<String> getGuiCalmo() {
		return boxCalmo;
	}

	public JComboBox<String> getGuiCarismatico() {
		return boxCarismatico;
	}

	public JComboBox<String> getGuiCauteloso() {
		return boxCauteloso;
	}

	public JComboBox<String> getGuiCompetitivo() {
		return boxCompetitivo;
	}

	public JComboBox<String> getGuiCompreensivo() {
		return boxCompreensivo;
	}

	public JComboBox<String> getGuiConciliador() {
		return boxConciliador;
	}

	public JComboBox<String> getGuiContido() {
		return boxContido;
	}

	public JComboBox<String> getGuiConvencional() {
		return boxConvencional;
	}

	public JComboBox<String> getGuiConvincente() {
		return boxConvincente;
	}

	public JComboBox<String> getGuiCortes() {
		return boxCortes;
	}

	public JComboBox<String> getGuiCuidadoso() {
		return boxCuidadoso;
	}

	public JComboBox<String> getGuiDecidido() {
		return boxDecidido;
	}

	public JComboBox<String> getGuiDedicado() {
		return boxDedicado;
	}

	public JComboBox<String> getGuiDependente() {
		return boxDependente;
	}

	public JComboBox<String> getGuiDesconfiado() {
		return boxDesconfiado;
	}

	public JComboBox<String> getGuiDescrente() {
		return boxDescrente;
	}

	public JComboBox<String> getGuiDesencanado() {
		return boxDesencanado;
	}

	public JComboBox<String> getGuiDesligado() {
		return boxDesligado;
	}

	public JComboBox<String> getGuiDesprendido() {
		return boxDesprendido;
	}

	public JComboBox<String> getGuiDespretensioso() {
		return boxDespretensioso;
	}

	public JComboBox<String> getGuiDestemido() {
		return boxDestemido;
	}

	public JComboBox<String> getGuiDeterminado() {
		return boxDeterminado;
	}

	public JComboBox<String> getGuiDiplomatico() {
		return boxDiplomatico;
	}

	public JComboBox<String> getGuiDireto() {
		return boxDireto;
	}

	public JComboBox<String> getGuiDisciplinado() {
		return boxDisciplinado;
	}

	public JComboBox<String> getGuiDiscreto() {
		return boxDiscreto;
	}

	public JComboBox<String> getGuiDisponivel() {
		return boxDisponivel;
	}

	public JComboBox<String> getGuiDivertido() {
		return boxDivertido;
	}

	public JComboBox<String> getGuiDominador() {
		return boxDominador;
	}

	public JComboBox<String> getGuiEgocentrico() {
		return boxEgocentrico;
	}

	public JComboBox<String> getGuiEmpolgado() {
		return boxEmpolgado;
	}

	public JComboBox<String> getGuiEncantador() {
		return boxEncantador;
	}

	public JComboBox<String> getGuiEnergico() {
		return boxEnergico;
	}

	public JComboBox<String> getGuiEspontaneo() {
		return boxEspontaneo;
	}

	public JComboBox<String> getGuiEstavel() {
		return boxEstavel;
	}

	public JComboBox<String> getGuiExigente() {
		return boxExigente;
	}

	public JComboBox<String> getGuiExpansivo() {
		return boxExpansivo;
	}

	public JComboBox<String> getGuiExpressivo() {
		return boxExpressivo;
	}

	public JComboBox<String> getGuiExtrovertido() {
		return boxExtrovertido;
	}

	public JComboBox<String> getGuiFechado() {
		return boxFechado;
	}

	public JComboBox<String> getGuiFirme() {
		return boxFirme;
	}

	public JComboBox<Funcionario> getGuiFuncionario() {
		return boxFuncionario;
	}

	public JComboBox<String> getGuiGostaDeSeArriscar() {
		return boxGostaDeSeArriscar;
	}

	public JComboBox<String> getGuiHumilde() {
		return boxHumilde;
	}

	public JComboBox<String> getGuiImpulsivo() {
		return boxImpulsivo;
	}

	public JComboBox<String> getGuiIncerto() {
		return boxIncerto;
	}

	public JComboBox<String> getGuiIndependente() {
		return boxIndependente;
	}

	public JComboBox<String> getGuiIndiferente() {
		return boxIndiferente;
	}

	public JComboBox<String> getGuiInfluente() {
		return boxInfluente;
	}

	public JComboBox<String> getGuiInquieto() {
		return boxInquieto;
	}

	public JComboBox<String> getGuiInspirador() {
		return boxInspirador;
	}

	public JComboBox<String> getGuiInteressado() {
		return boxInteressado;
	}

	public JComboBox<String> getGuiIntrospectivo() {
		return boxIntrospectivo;
	}

	public JComboBox<String> getGuiJusto() {
		return boxJusto;
	}

	public JComboBox<String> getGuiLeal() {
		return boxLeal;
	}

	public JComboBox<String> getGuiLiberal() {
		return boxLiberal;
	}

	public JComboBox<String> getGuiLivre() {
		return boxLivre;
	}

	public JComboBox<String> getGuiLogico() {
		return boxLogico;
	}

	public JComboBox<String> getGuiMaleavel() {
		return boxMaleavel;
	}

	public JComboBox<String> getGuiMenteAberta() {
		return boxMenteAberta;
	}

	public JComboBox<String> getGuiMeticuloso() {
		return boxMeticuloso;
	}

	public JComboBox<String> getGuiObediente() {
		return boxObediente;
	}

	public JComboBox<String> getGuiObjetivo() {
		return boxObjetivo;
	}

	public JComboBox<String> getGuiObservador() {
		return boxObservador;
	}

	public JComboBox<String> getGuiObstinado() {
		return boxObstinado;
	}

	public JComboBox<String> getGuiOriginal() {
		return boxOriginal;
	}

	public JComboBox<String> getGuiOusado() {
		return boxOusado;
	}

	public JComboBox<String> getGuiPaciente() {
		return boxPaciente;
	}

	public JComboBox<String> getGuiPacifico() {
		return boxPacifico;
	}

	public JComboBox<String> getGuiPassivo() {
		return boxPassivo;
	}

	public JComboBox<String> getGuiPerfeccionista() {
		return boxPerfeccionista;
	}

	public JComboBox<String> getGuiPersistente() {
		return boxPersistente;
	}

	public JComboBox<String> getGuiPersuasivo() {
		return boxPersuasivo;
	}

	public JComboBox<String> getGuiPessimista() {
		return boxPessimista;
	}

	public JComboBox<String> getGuiPonderado() {
		return boxPonderado;
	}

	public JComboBox<String> getGuiPratico() {
		return boxPratico;
	}

	public JComboBox<String> getGuiPrecavido() {
		return boxPrecavido;
	}

	public JComboBox<String> getGuiPreciso() {
		return boxPreciso;
	}

	public JComboBox<String> getGuiPreocupado() {
		return boxPreocupado;
	}

	public JComboBox<String> getGuiPrevenido() {
		return boxPrevenido;
	}

	public JComboBox<String> getGuiPrevisivel() {
		return boxPrevisivel;
	}

	public JComboBox<String> getGuiRealista() {
		return boxRealista;
	}

	public JComboBox<String> getGuiRebelde() {
		return boxRebelde;
	}

	public JComboBox<String> getGuiReceoso() {
		return boxReceoso;
	}

	public JComboBox<String> getGuiReservado() {
		return boxReservado;
	}

	public JComboBox<String> getGuiRespeitoso() {
		return boxRespeitoso;
	}

	public JComboBox<String> getGuiSarcastico() {
		return boxSarcastico;
	}

	public JComboBox<String> getGuiSeguro() {
		return boxSeguro;
	}

	public JComboBox<String> getGuiSemLimites() {
		return boxSemLimites;
	}

	public JComboBox<String> getGuiSensato() {
		return boxSensato;
	}

	public JComboBox<String> getGuiSereno() {
		return boxSereno;
	}

	public JComboBox<String> getGuiSerio() {
		return boxSerio;
	}

	public JComboBox<String> getGuiSimpatico() {
		return boxSimpatico;
	}

	public JComboBox<String> getGuiSistematico() {
		return boxSistematico;
	}

	public JComboBox<String> getGuiSociavel() {
		return boxSociavel;
	}

	public JComboBox<String> getGuiTeimoso() {
		return boxTeimoso;
	}

	public JComboBox<String> getGuiVersatil() {
		return boxVersatil;
	}

	public JLabel getLabelFuncionario() {
		return labelFuncionario;
	}

	public ToolBar getTB() {
		return toolBar;
	}

	@Override
	public void iniciarControlador() {

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

		add(new JLabel("ADEQUADO"));

		boxAdequado = new JComboBox<String>();
		boxAdequado.addItem("");
		boxAdequado.addItem("SIM");
		boxAdequado.addItem("NÃO");
		add(boxAdequado);

		add(new JLabel("ÁGIL"));

		boxAgil = new JComboBox<String>();
		boxAgil.addItem("");
		boxAgil.addItem("SIM");
		boxAgil.addItem("NÃO");
		add(boxAgil);

		add(new JLabel("AGITADO"));

		boxAgitado = new JComboBox<String>();
		boxAgitado.addItem("");
		boxAgitado.addItem("SIM");
		boxAgitado.addItem("NÃO");
		add(boxAgitado);

		add(new JLabel("ALEGRE"));

		boxAlegre = new JComboBox<String>();
		boxAlegre.addItem("");
		boxAlegre.addItem("SIM");
		boxAlegre.addItem("NÃO");
		add(boxAlegre);

		add(new JLabel("AMÁVEL"));

		boxAmavel = new JComboBox<String>();
		boxAmavel.addItem("");
		boxAmavel.addItem("SIM");
		boxAmavel.addItem("NÃO");
		add(boxAmavel);

		add(new JLabel("ANALÍTICO"));

		boxAnalitico = new JComboBox<String>();
		boxAnalitico.addItem("");
		boxAnalitico.addItem("SIM");
		boxAnalitico.addItem("NÃO");
		add(boxAnalitico);

		add(new JLabel("ANIMADO"));

		boxAnimado = new JComboBox<String>();
		boxAnimado.addItem("");
		boxAnimado.addItem("SIM");
		boxAnimado.addItem("NÃO");
		add(boxAnimado);

		add(new JLabel("ANSIOSO"));

		boxAnsioso = new JComboBox<String>();
		boxAnsioso.addItem("");
		boxAnsioso.addItem("SIM");
		boxAnsioso.addItem("NÃO");
		add(boxAnsioso);

		add(new JLabel("APÁTICO"));

		boxApatico = new JComboBox<String>();
		boxApatico.addItem("");
		boxApatico.addItem("SIM");
		boxApatico.addItem("NÃO");
		add(boxApatico);

		add(new JLabel("ARTICULADO"));

		boxArticulado = new JComboBox<String>();
		boxArticulado.addItem("");
		boxArticulado.addItem("SIM");
		boxArticulado.addItem("NÃO");
		add(boxArticulado);

		add(new JLabel("ASSUME RISCOS CALCULADOS"));

		boxAssumeRiscosCalculados = new JComboBox<String>();
		boxAssumeRiscosCalculados.addItem("");
		boxAssumeRiscosCalculados.addItem("SIM");
		boxAssumeRiscosCalculados.addItem("NÃO");
		add(boxAssumeRiscosCalculados);

		add(new JLabel("ATENCIOSO"));

		boxAtencioso = new JComboBox<String>();
		boxAtencioso.addItem("");
		boxAtencioso.addItem("SIM");
		boxAtencioso.addItem("NÃO");
		add(boxAtencioso);

		add(new JLabel("ATIVO"));

		boxAtivo = new JComboBox<String>();
		boxAtivo.addItem("");
		boxAtivo.addItem("SIM");
		boxAtivo.addItem("NÃO");
		add(boxAtivo);

		add(new JLabel("AUTO CONFIANTE"));

		boxAutoconfiante = new JComboBox<String>();
		boxAutoconfiante.addItem("");
		boxAutoconfiante.addItem("SIM");
		boxAutoconfiante.addItem("NÃO");
		add(boxAutoconfiante);

		add(new JLabel("AVENTUREIRO"));

		boxAventureiro = new JComboBox<String>();
		boxAventureiro.addItem("");
		boxAventureiro.addItem("SIM");
		boxAventureiro.addItem("NÃO");
		add(boxAventureiro);

		add(new JLabel("BEM HUMORADO"));

		boxBemHumorado = new JComboBox<String>();
		boxBemHumorado.addItem("");
		boxBemHumorado.addItem("SIM");
		boxBemHumorado.addItem("NÃO");
		add(boxBemHumorado);

		add(new JLabel("CALMO"));

		boxCalmo = new JComboBox<String>();
		boxCalmo.addItem("");
		boxCalmo.addItem("SIM");
		boxCalmo.addItem("NÃO");
		add(boxCalmo);

		add(new JLabel("CARISMÁTICO"));

		boxCarismatico = new JComboBox<String>();
		boxCarismatico.addItem("");
		boxCarismatico.addItem("SIM");
		boxCarismatico.addItem("NÃO");
		add(boxCarismatico);

		add(new JLabel("CAUTELOSO"));

		boxCauteloso = new JComboBox<String>();
		boxCauteloso.addItem("");
		boxCauteloso.addItem("SIM");
		boxCauteloso.addItem("NÃO");
		add(boxCauteloso);

		add(new JLabel("COMPETITIVO"));

		boxCompetitivo = new JComboBox<String>();
		boxCompetitivo.addItem("");
		boxCompetitivo.addItem("SIM");
		boxCompetitivo.addItem("NÃO");
		add(boxCompetitivo);

		add(new JLabel("COMPREENSIVO"));

		boxCompreensivo = new JComboBox<String>();
		boxCompreensivo.addItem("");
		boxCompreensivo.addItem("SIM");
		boxCompreensivo.addItem("NÃO");
		add(boxCompreensivo);

		add(new JLabel("CONCILIADOR"));

		boxConciliador = new JComboBox<String>();
		boxConciliador.addItem("");
		boxConciliador.addItem("SIM");
		boxConciliador.addItem("NÃO");
		add(boxConciliador);

		add(new JLabel("CONTIDO"));

		boxContido = new JComboBox<String>();
		boxContido.addItem("");
		boxContido.addItem("SIM");
		boxContido.addItem("NÃO");
		add(boxContido);

		add(new JLabel("CONVENCIONAL"));

		boxConvencional = new JComboBox<String>();
		boxConvencional.addItem("");
		boxConvencional.addItem("SIM");
		boxConvencional.addItem("NÃO");
		add(boxConvencional);

		add(new JLabel("CONVINCENTE"));

		boxConvincente = new JComboBox<String>();
		boxConvincente.addItem("");
		boxConvincente.addItem("SIM");
		boxConvincente.addItem("NÃO");
		add(boxConvincente);

		add(new JLabel("CORTÊS"));

		boxCortes = new JComboBox<String>();
		boxCortes.addItem("");
		boxCortes.addItem("SIM");
		boxCortes.addItem("NÃO");
		add(boxCortes);

		add(new JLabel("CUIDADOSO"));

		boxCuidadoso = new JComboBox<String>();
		boxCuidadoso.addItem("");
		boxCuidadoso.addItem("SIM");
		boxCuidadoso.addItem("NÃO");
		add(boxCuidadoso);

		add(new JLabel("DECIDIDO"));

		boxDecidido = new JComboBox<String>();
		boxDecidido.addItem("");
		boxDecidido.addItem("SIM");
		boxDecidido.addItem("NÃO");
		add(boxDecidido);

		add(new JLabel("DEDICADO"));

		boxDedicado = new JComboBox<String>();
		boxDedicado.addItem("");
		boxDedicado.addItem("SIM");
		boxDedicado.addItem("NÃO");
		add(boxDedicado);

		add(new JLabel("DEPENDENTE"));

		boxDependente = new JComboBox<String>();
		boxDependente.addItem("");
		boxDependente.addItem("SIM");
		boxDependente.addItem("NÃO");
		add(boxDependente);

		add(new JLabel("DESCONFIADO"));

		boxDesconfiado = new JComboBox<String>();
		boxDesconfiado.addItem("");
		boxDesconfiado.addItem("SIM");
		boxDesconfiado.addItem("NÃO");
		add(boxDesconfiado);

		add(new JLabel("DESCRENTE"));

		boxDescrente = new JComboBox<String>();
		boxDescrente.addItem("");
		boxDescrente.addItem("SIM");
		boxDescrente.addItem("NÃO");
		add(boxDescrente);

		add(new JLabel("DESENCANADO"));

		boxDesencanado = new JComboBox<String>();
		boxDesencanado.addItem("");
		boxDesencanado.addItem("SIM");
		boxDesencanado.addItem("NÃO");
		add(boxDesencanado);

		add(new JLabel("DESLIGADO"));

		boxDesligado = new JComboBox<String>();
		boxDesligado.addItem("");
		boxDesligado.addItem("SIM");
		boxDesligado.addItem("NÃO");
		add(boxDesligado);

		add(new JLabel("DESPRENDIDO"));

		boxDesprendido = new JComboBox<String>();
		boxDesprendido.addItem("");
		boxDesprendido.addItem("SIM");
		boxDesprendido.addItem("NÃO");
		add(boxDesprendido);

		add(new JLabel("DESPRETENSIOSO"));

		boxDespretensioso = new JComboBox<String>();
		boxDespretensioso.addItem("");
		boxDespretensioso.addItem("SIM");
		boxDespretensioso.addItem("NÃO");
		add(boxDespretensioso);

		add(new JLabel("DESTEMIDO"));

		boxDestemido = new JComboBox<String>();
		boxDestemido.addItem("");
		boxDestemido.addItem("SIM");
		boxDestemido.addItem("NÃO");
		add(boxDestemido);

		add(new JLabel("DETERMINADO"));

		boxDeterminado = new JComboBox<String>();
		boxDeterminado.addItem("");
		boxDeterminado.addItem("SIM");
		boxDeterminado.addItem("NÃO");
		add(boxDeterminado);

		add(new JLabel("DIPLOMÁTICO"));

		boxDiplomatico = new JComboBox<String>();
		boxDiplomatico.addItem("");
		boxDiplomatico.addItem("SIM");
		boxDiplomatico.addItem("NÃO");
		add(boxDiplomatico);

		add(new JLabel("DIRETO"));

		boxDireto = new JComboBox<String>();
		boxDireto.addItem("");
		boxDireto.addItem("SIM");
		boxDireto.addItem("NÃO");
		add(boxDireto);

		add(new JLabel("DISCIPLINADO"));

		boxDisciplinado = new JComboBox<String>();
		boxDisciplinado.addItem("");
		boxDisciplinado.addItem("SIM");
		boxDisciplinado.addItem("NÃO");
		add(boxDisciplinado);

		add(new JLabel("DISCRETO"));

		boxDiscreto = new JComboBox<String>();
		boxDiscreto.addItem("");
		boxDiscreto.addItem("SIM");
		boxDiscreto.addItem("NÃO");
		add(boxDiscreto);

		add(new JLabel("DISPONÍVEL"));

		boxDisponivel = new JComboBox<String>();
		boxDisponivel.addItem("");
		boxDisponivel.addItem("SIM");
		boxDisponivel.addItem("NÃO");
		add(boxDisponivel);

		add(new JLabel("DIVERTIDO"));

		boxDivertido = new JComboBox<String>();
		boxDivertido.addItem("");
		boxDivertido.addItem("SIM");
		boxDivertido.addItem("NÃO");
		add(boxDivertido);

		add(new JLabel("DOMINADOR"));

		boxDominador = new JComboBox<String>();
		boxDominador.addItem("");
		boxDominador.addItem("SIM");
		boxDominador.addItem("NÃO");
		add(boxDominador);

		add(new JLabel("EGOCÊNTRICO"));

		boxEgocentrico = new JComboBox<String>();
		boxEgocentrico.addItem("");
		boxEgocentrico.addItem("SIM");
		boxEgocentrico.addItem("NÃO");
		add(boxEgocentrico);

		add(new JLabel("EMPOLGADO"));

		boxEmpolgado = new JComboBox<String>();
		boxEmpolgado.addItem("");
		boxEmpolgado.addItem("SIM");
		boxEmpolgado.addItem("NÃO");
		add(boxEmpolgado);

		add(new JLabel("ENCANTADOR"));

		boxEncantador = new JComboBox<String>();
		boxEncantador.addItem("");
		boxEncantador.addItem("SIM");
		boxEncantador.addItem("NÃO");
		add(boxEncantador);

		add(new JLabel("ENÉRGICO"));

		boxEnergico = new JComboBox<String>();
		boxEnergico.addItem("");
		boxEnergico.addItem("SIM");
		boxEnergico.addItem("NÃO");
		add(boxEnergico);

		add(new JLabel("ESPONTÂNEO"));

		boxEspontaneo = new JComboBox<String>();
		boxEspontaneo.addItem("");
		boxEspontaneo.addItem("SIM");
		boxEspontaneo.addItem("NÃO");
		add(boxEspontaneo);

		add(new JLabel("ESTÁVEL"));

		boxEstavel = new JComboBox<String>();
		boxEstavel.addItem("");
		boxEstavel.addItem("SIM");
		boxEstavel.addItem("NÃO");
		add(boxEstavel);

		add(new JLabel("EXIGENTE"));

		boxExigente = new JComboBox<String>();
		boxExigente.addItem("");
		boxExigente.addItem("SIM");
		boxExigente.addItem("NÃO");
		add(boxExigente);

		add(new JLabel("EXPANSIVO"));

		boxExpansivo = new JComboBox<String>();
		boxExpansivo.addItem("");
		boxExpansivo.addItem("SIM");
		boxExpansivo.addItem("NÃO");
		add(boxExpansivo);

		add(new JLabel("EXPRESSIVO"));

		boxExpressivo = new JComboBox<String>();
		boxExpressivo.addItem("");
		boxExpressivo.addItem("SIM");
		boxExpressivo.addItem("NÃO");
		add(boxExpressivo);

		add(new JLabel("EXTROVERTIDO"));

		boxExtrovertido = new JComboBox<String>();
		boxExtrovertido.addItem("");
		boxExtrovertido.addItem("SIM");
		boxExtrovertido.addItem("NÃO");
		add(boxExtrovertido);

		add(new JLabel("FECHADO"));

		boxFechado = new JComboBox<String>();
		boxFechado.addItem("");
		boxFechado.addItem("SIM");
		boxFechado.addItem("NÃO");
		add(boxFechado);

		add(new JLabel("FIRME"));

		boxFirme = new JComboBox<String>();
		boxFirme.addItem("");
		boxFirme.addItem("SIM");
		boxFirme.addItem("NÃO");
		add(boxFirme);

		add(new JLabel("GOSTA DE SE ARRRISCAR"));

		boxGostaDeSeArriscar = new JComboBox<String>();
		boxGostaDeSeArriscar.addItem("");
		boxGostaDeSeArriscar.addItem("SIM");
		boxGostaDeSeArriscar.addItem("NÃO");
		add(boxGostaDeSeArriscar);

		add(new JLabel("HUMILDE"));

		boxHumilde = new JComboBox<String>();
		boxHumilde.addItem("");
		boxHumilde.addItem("SIM");
		boxHumilde.addItem("NÃO");
		add(boxHumilde);

		add(new JLabel("IMPULSIVO"));

		boxImpulsivo = new JComboBox<String>();
		boxImpulsivo.addItem("");
		boxImpulsivo.addItem("SIM");
		boxImpulsivo.addItem("NÃO");
		add(boxImpulsivo);

		add(new JLabel("INCERTO"));

		boxIncerto = new JComboBox<String>();
		boxIncerto.addItem("");
		boxIncerto.addItem("SIM");
		boxIncerto.addItem("NÃO");
		add(boxIncerto);

		add(new JLabel("INDEPENDENTE"));

		boxIndependente = new JComboBox<String>();
		boxIndependente.addItem("");
		boxIndependente.addItem("SIM");
		boxIndependente.addItem("NÃO");
		add(boxIndependente);

		add(new JLabel("INDIFERENTE"));

		boxIndiferente = new JComboBox<String>();
		boxIndiferente.addItem("");
		boxIndiferente.addItem("SIM");
		boxIndiferente.addItem("NÃO");
		add(boxIndiferente);

		add(new JLabel("INFLUENTE"));

		boxInfluente = new JComboBox<String>();
		boxInfluente.addItem("");
		boxInfluente.addItem("SIM");
		boxInfluente.addItem("NÃO");
		add(boxInfluente);

		add(new JLabel("INQUIETO"));

		boxInquieto = new JComboBox<String>();
		boxInquieto.addItem("");
		boxInquieto.addItem("SIM");
		boxInquieto.addItem("NÃO");
		add(boxInquieto);

		add(new JLabel("INSPIRADOR"));

		boxInspirador = new JComboBox<String>();
		boxInspirador.addItem("");
		boxInspirador.addItem("SIM");
		boxInspirador.addItem("NÃO");
		add(boxInspirador);

		add(new JLabel("INTERESSADO"));

		boxInteressado = new JComboBox<String>();
		boxInteressado.addItem("");
		boxInteressado.addItem("SIM");
		boxInteressado.addItem("NÃO");
		add(boxInteressado);

		add(new JLabel("INTROSPECTIVO"));

		boxIntrospectivo = new JComboBox<String>();
		boxIntrospectivo.addItem("");
		boxIntrospectivo.addItem("SIM");
		boxIntrospectivo.addItem("NÃO");
		add(boxIntrospectivo);

		add(new JLabel("JUSTO"));

		boxJusto = new JComboBox<String>();
		boxJusto.addItem("");
		boxJusto.addItem("SIM");
		boxJusto.addItem("NÃO");
		add(boxJusto);

		add(new JLabel("LEAL"));

		boxLeal = new JComboBox<String>();
		boxLeal.addItem("");
		boxLeal.addItem("SIM");
		boxLeal.addItem("NÃO");
		add(boxLeal);

		add(new JLabel("LIBERAL"));

		boxLiberal = new JComboBox<String>();
		boxLiberal.addItem("");
		boxLiberal.addItem("SIM");
		boxLiberal.addItem("NÃO");
		add(boxLiberal);

		add(new JLabel("LIVRE"));

		boxLivre = new JComboBox<String>();
		boxLivre.addItem("");
		boxLivre.addItem("SIM");
		boxLivre.addItem("NÃO");
		add(boxLivre);

		add(new JLabel("LÓGICO"));

		boxLogico = new JComboBox<String>();
		boxLogico.addItem("");
		boxLogico.addItem("SIM");
		boxLogico.addItem("NÃO");
		add(boxLogico);

		add(new JLabel("MALEÁVEL"));

		boxMaleavel = new JComboBox<String>();
		boxMaleavel.addItem("");
		boxMaleavel.addItem("SIM");
		boxMaleavel.addItem("NÃO");
		add(boxMaleavel);

		add(new JLabel("MENTE ABERTA"));

		boxMenteAberta = new JComboBox<String>();
		boxMenteAberta.addItem("");
		boxMenteAberta.addItem("SIM");
		boxMenteAberta.addItem("NÃO");
		add(boxMenteAberta);

		add(new JLabel("METICULOSO"));

		boxMeticuloso = new JComboBox<String>();
		boxMeticuloso.addItem("");
		boxMeticuloso.addItem("SIM");
		boxMeticuloso.addItem("NÃO");
		add(boxMeticuloso);

		add(new JLabel("OBEDIENTE"));

		boxObediente = new JComboBox<String>();
		boxObediente.addItem("");
		boxObediente.addItem("SIM");
		boxObediente.addItem("NÃO");
		add(boxObediente);

		add(new JLabel("OBJETIVO"));

		boxObjetivo = new JComboBox<String>();
		boxObjetivo.addItem("");
		boxObjetivo.addItem("SIM");
		boxObjetivo.addItem("NÃO");
		add(boxObjetivo);

		add(new JLabel("OBSERVADOR"));

		boxObservador = new JComboBox<String>();
		boxObservador.addItem("");
		boxObservador.addItem("SIM");
		boxObservador.addItem("NÃO");
		add(boxObservador);

		add(new JLabel("OBSTINADO"));

		boxObstinado = new JComboBox<String>();
		boxObstinado.addItem("");
		boxObstinado.addItem("SIM");
		boxObstinado.addItem("NÃO");
		add(boxObstinado);

		add(new JLabel("ORIGINAL"));

		boxOriginal = new JComboBox<String>();
		boxOriginal.addItem("");
		boxOriginal.addItem("SIM");
		boxOriginal.addItem("NÃO");
		add(boxOriginal);

		add(new JLabel("OUSADO"));

		boxOusado = new JComboBox<String>();
		boxOusado.addItem("");
		boxOusado.addItem("SIM");
		boxOusado.addItem("NÃO");
		add(boxOusado);

		add(new JLabel("PACIENTE"));

		boxPaciente = new JComboBox<String>();
		boxPaciente.addItem("");
		boxPaciente.addItem("SIM");
		boxPaciente.addItem("NÃO");
		add(boxPaciente);

		add(new JLabel("PACÍFICO"));

		boxPacifico = new JComboBox<String>();
		boxPacifico.addItem("");
		boxPacifico.addItem("SIM");
		boxPacifico.addItem("NÃO");
		add(boxPacifico);

		add(new JLabel("PASSIVO"));

		boxPassivo = new JComboBox<String>();
		boxPassivo.addItem("");
		boxPassivo.addItem("SIM");
		boxPassivo.addItem("NÃO");
		add(boxPassivo);

		add(new JLabel("PERFECCIONISTA"));

		boxPerfeccionista = new JComboBox<String>();
		boxPerfeccionista.addItem("");
		boxPerfeccionista.addItem("SIM");
		boxPerfeccionista.addItem("NÃO");
		add(boxPerfeccionista);

		add(new JLabel("PERSISTENTE"));

		boxPersistente = new JComboBox<String>();
		boxPersistente.addItem("");
		boxPersistente.addItem("SIM");
		boxPersistente.addItem("NÃO");
		add(boxPersistente);

		add(new JLabel("PERSUASIVO"));

		boxPersuasivo = new JComboBox<String>();
		boxPersuasivo.addItem("");
		boxPersuasivo.addItem("SIM");
		boxPersuasivo.addItem("NÃO");
		add(boxPersuasivo);

		add(new JLabel("PERSUASIVO"));

		boxPessimista = new JComboBox<String>();
		boxPessimista.addItem("");
		boxPessimista.addItem("SIM");
		boxPessimista.addItem("NÃO");
		add(boxPessimista);

		add(new JLabel("PONDERADO"));

		boxPonderado = new JComboBox<String>();
		boxPonderado.addItem("");
		boxPonderado.addItem("SIM");
		boxPonderado.addItem("NÃO");
		add(boxPonderado);

		add(new JLabel("PRÁTICO"));

		boxPratico = new JComboBox<String>();
		boxPratico.addItem("");
		boxPratico.addItem("SIM");
		boxPratico.addItem("NÃO");
		add(boxPratico);

		add(new JLabel("PRECAVIDO"));

		boxPrecavido = new JComboBox<String>();
		boxPrecavido.addItem("");
		boxPrecavido.addItem("SIM");
		boxPrecavido.addItem("NÃO");
		add(boxPrecavido);

		add(new JLabel("PRECISO"));

		boxPreciso = new JComboBox<String>();
		boxPreciso.addItem("");
		boxPreciso.addItem("SIM");
		boxPreciso.addItem("NÃO");
		add(boxPreciso);

		add(new JLabel("PREOCUPADO"));

		boxPreocupado = new JComboBox<String>();
		boxPreocupado.addItem("");
		boxPreocupado.addItem("SIM");
		boxPreocupado.addItem("NÃO");
		add(boxPreocupado);

		add(new JLabel("PREVENIDO"));

		boxPrevenido = new JComboBox<String>();
		boxPrevenido.addItem("");
		boxPrevenido.addItem("SIM");
		boxPrevenido.addItem("NÃO");
		add(boxPrevenido);

		add(new JLabel("PREVISÍVEL"));

		boxPrevisivel = new JComboBox<String>();
		boxPrevisivel.addItem("");
		boxPrevisivel.addItem("SIM");
		boxPrevisivel.addItem("NÃO");
		add(boxPrevisivel);

		add(new JLabel("REALISTA"));

		boxRealista = new JComboBox<String>();
		boxRealista.addItem("");
		boxRealista.addItem("SIM");
		boxRealista.addItem("NÃO");
		add(boxRealista);

		add(new JLabel("REBELDE"));

		boxRebelde = new JComboBox<String>();
		boxRebelde.addItem("");
		boxRebelde.addItem("SIM");
		boxRebelde.addItem("NÃO");
		add(boxRebelde);

		add(new JLabel("RECEOSO"));

		boxReceoso = new JComboBox<String>();
		boxReceoso.addItem("");
		boxReceoso.addItem("SIM");
		boxReceoso.addItem("NÃO");
		add(boxReceoso);

		add(new JLabel("RESERVADO"));

		boxReservado = new JComboBox<String>();
		boxReservado.addItem("");
		boxReservado.addItem("SIM");
		boxReservado.addItem("NÃO");
		add(boxReservado);

		add(new JLabel("RESPEITOSO"));

		boxRespeitoso = new JComboBox<String>();
		boxRespeitoso.addItem("");
		boxRespeitoso.addItem("SIM");
		boxRespeitoso.addItem("NÃO");
		add(boxRespeitoso);

		add(new JLabel("SARCÁSTICO"));

		boxSarcastico = new JComboBox<String>();
		boxSarcastico.addItem("");
		boxSarcastico.addItem("SIM");
		boxSarcastico.addItem("NÃO");
		add(boxSarcastico);

		add(new JLabel("SEGURO"));

		boxSeguro = new JComboBox<String>();
		boxSeguro.addItem("");
		boxSeguro.addItem("SIM");
		boxSeguro.addItem("NÃO");
		add(boxSeguro);

		add(new JLabel("SEM LIMITES"));

		boxSemLimites = new JComboBox<String>();
		boxSemLimites.addItem("");
		boxSemLimites.addItem("SIM");
		boxSemLimites.addItem("NÃO");
		add(boxSemLimites);

		add(new JLabel("SENSATO"));

		boxSensato = new JComboBox<String>();
		boxSensato.addItem("");
		boxSensato.addItem("SIM");
		boxSensato.addItem("NÃO");
		add(boxSensato);

		add(new JLabel("SERENO"));

		boxSereno = new JComboBox<String>();
		boxSereno.addItem("");
		boxSereno.addItem("SIM");
		boxSereno.addItem("NÃO");
		add(boxSereno);

		add(new JLabel("SÉRIO"));

		boxSerio = new JComboBox<String>();
		boxSerio.addItem("");
		boxSerio.addItem("SIM");
		boxSerio.addItem("NÃO");
		add(boxSerio);

		add(new JLabel("SIMPÁTICO"));

		boxSimpatico = new JComboBox<String>();
		boxSimpatico.addItem("");
		boxSimpatico.addItem("SIM");
		boxSimpatico.addItem("NÃO");
		add(boxSimpatico);

		add(new JLabel("SISTEMÁTICO"));

		boxSistematico = new JComboBox<String>();
		boxSistematico.addItem("");
		boxSistematico.addItem("SIM");
		boxSistematico.addItem("NÃO");
		add(boxSistematico);

		add(new JLabel("SOCIÁVEL"));

		boxSociavel = new JComboBox<String>();
		boxSociavel.addItem("");
		boxSociavel.addItem("SIM");
		boxSociavel.addItem("NÃO");
		add(boxSociavel);

		add(new JLabel("TEIMOSO"));

		boxTeimoso = new JComboBox<String>();
		boxTeimoso.addItem("");
		boxTeimoso.addItem("SIM");
		boxTeimoso.addItem("NÃO");
		add(boxTeimoso);

		add(new JLabel("VERSÁTIL"));

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
		if (!MainCont.getCurriculoTesteBFc().isShowing()
				&& MainCont.getCurriculoTesteBFc().getTesteBCont().getTesteB() != null) {
			funcionario = MainCont.getCurriculoTesteBFc().getTesteBCont().getTesteB()
					.getFuncionario();
			boxFuncionario.setSelectedItem(funcionario);
		}
	}
}
