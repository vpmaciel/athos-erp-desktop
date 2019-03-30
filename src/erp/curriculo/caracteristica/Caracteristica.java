package erp.curriculo.caracteristica;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;

import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
public class Caracteristica implements Serializable {
	@Id
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, optional = true)
	private Funcionario funcionario;
	@Column(length = 3)
	private String simpatico;
	@Column(length = 3)
	private String cuidadoso;
	@Column(length = 3)
	private String preocupado;
	@Column(length = 3)
	private String inquieto;
	@Column(length = 3)
	private String estavel;
	@Column(length = 3)
	private String despretensioso;
	@Column(length = 3)
	private String bem_humorado;
	@Column(length = 3)
	private String incerto;
	@Column(length = 3)
	private String exigente;
	@Column(length = 3)
	private String interessado;
	@Column(length = 3)
	private String dependente;
	@Column(length = 3)
	private String pacifico;
	@Column(length = 3)
	private String articulado;
	@Column(length = 3)
	private String previsivel;
	@Column(length = 3)
	private String seguro;
	@Column(length = 3)
	private String dedicado;
	@Column(length = 3)
	private String persuasivo;
	@Column(length = 3)
	private String encantador;
	@Column(length = 3)
	private String teimoso;
	@Column(length = 3)
	private String competitivo;
	@Column(length = 3)
	private String maleavel;
	@Column(length = 3)
	private String obediente;
	@Column(length = 3)
	private String introspectivo;
	@Column(length = 3)
	private String perfeccionista;
	@Column(length = 3)
	private String precavido;
	@Column(length = 3)
	private String pratico;
	@Column(length = 3)
	private String impulsivo;
	@Column(length = 3)
	private String semLimites;
	@Column(length = 3)
	private String indiferente;
	@Column(length = 3)
	private String agil;
	@Column(length = 3)
	private String sociavel;
	@Column(length = 3)
	private String carismatico;
	@Column(length = 3)
	private String passivo;
	@Column(length = 3)
	private String ousado;
	@Column(length = 3)
	private String independente;
	@Column(length = 3)
	private String cauteloso;
	@Column(length = 3)
	private String convincente;
	@Column(length = 3)
	private String alegre;
	@Column(length = 3)
	private String destemido;
	@Column(length = 3)
	private String menteAberta;
	@Column(length = 3)
	private String inspirador;
	@Column(length = 3)
	private String firme;
	@Column(length = 3)
	private String preciso;
	@Column(length = 3)
	private String desprendido;
	@Column(length = 3)
	private String obstinado;
	@Column(length = 3)
	private String calmo;
	@Column(length = 3)
	private String leal;
	@Column(length = 3)
	private String amavel;
	@Column(length = 3)
	private String contido;
	@Column(length = 3)
	private String empolgado;
	@Column(length = 3)
	private String compreensivo;
	@Column(length = 3)
	private String extrovertido;
	@Column(length = 3)
	private String prevenido;
	@Column(length = 3)
	private String versatil;
	@Column(length = 3)
	private String energico;
	@Column(length = 3)
	private String persistente;
	@Column(length = 3)
	private String desligado;
	@Column(length = 3)
	private String divertido;
	@Column(length = 3)
	private String objetivo;
	@Column(length = 3)
	private String assumeRiscosCalculados;
	@Column(length = 3)
	private String disciplinado;
	@Column(length = 3)
	private String meticuloso;
	@Column(length = 3)
	private String ponderado;
	@Column(length = 3)
	private String observador;
	@Column(length = 3)
	private String ansioso;
	@Column(length = 3)
	private String analitico;
	@Column(length = 3)
	private String animado;
	@Column(length = 3)
	private String discreto;
	@Column(length = 3)
	private String original;
	@Column(length = 3)
	private String conciliador;
	@Column(length = 3)
	private String liberal;
	@Column(length = 3)
	private String sarcastico;
	@Column(length = 3)
	private String pessimista;
	@Column(length = 3)
	private String rebelde;
	@Column(length = 3)
	private String diplomatico;
	@Column(length = 3)
	private String direto;
	@Column(length = 3)
	private String atencioso;
	@Column(length = 3)
	private String dominador;
	@Column(length = 3)
	private String receoso;
	@Column(length = 3)
	private String respeitoso;
	@Column(length = 3)
	private String descrente;
	@Column(length = 3)
	private String agitado;
	@Column(length = 3)
	private String influente;
	@Column(length = 3)
	private String disponivel;
	@Column(length = 3)
	private String expansivo;
	@Column(length = 3)
	private String convencional;
	@Column(length = 3)
	private String paciente;
	@Column(length = 3)
	private String aventureiro;
	@Column(length = 3)
	private String decidido;
	@Column(length = 3)
	private String realista;
	@Column(length = 3)
	private String expressivo;
	@Column(length = 3)
	private String determinado;
	@Column(length = 3)
	private String fechado;
	@Column(length = 3)
	private String autoconfiante;
	@Column(length = 3)
	private String sensato;
	@Column(length = 3)
	private String adequado;
	@Column(length = 3)
	private String espontaneo;
	@Column(length = 3)
	private String ativo;
	@Column(length = 3)
	private String desconfiado;
	@Column(length = 3)
	private String livre;
	@Column(length = 3)
	private String justo;
	@Column(length = 3)
	private String desencanado;
	@Column(length = 3)
	private String logico;
	@Column(length = 3)
	private String apatico;
	@Column(length = 3)
	private String reservado;
	@Column(length = 3)
	private String humilde;
	@Column(length = 3)
	private String egocentrico;
	@Column(length = 3)
	private String sistematico;
	@Column(length = 3)
	private String gostaDeSeArriscar;
	@Column(length = 3)
	private String sereno;
	@Column(length = 3)
	private String cortes;
	@Column(length = 3)
	private String serio;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getSimpatico() {
		return simpatico;
	}

	public void setSimpatico(String simpatico) {
		this.simpatico = simpatico;
	}

	public String getCuidadoso() {
		return cuidadoso;
	}

	public void setCuidadoso(String cuidadoso) {
		this.cuidadoso = cuidadoso;
	}

	public String getPreocupado() {
		return preocupado;
	}

	public void setPreocupado(String preocupado) {
		this.preocupado = preocupado;
	}

	public String getInquieto() {
		return inquieto;
	}

	public void setInquieto(String inquieto) {
		this.inquieto = inquieto;
	}

	public String getEstavel() {
		return estavel;
	}

	public void setEstavel(String estavel) {
		this.estavel = estavel;
	}

	public String getDespretensioso() {
		return despretensioso;
	}

	public void setDespretensioso(String despretensioso) {
		this.despretensioso = despretensioso;
	}

	public String getBem_humorado() {
		return bem_humorado;
	}

	public void setBem_humorado(String bem_humorado) {
		this.bem_humorado = bem_humorado;
	}

	public String getIncerto() {
		return incerto;
	}

	public void setIncerto(String incerto) {
		this.incerto = incerto;
	}

	public String getExigente() {
		return exigente;
	}

	public void setExigente(String exigente) {
		this.exigente = exigente;
	}

	public String getInteressado() {
		return interessado;
	}

	public void setInteressado(String interessado) {
		this.interessado = interessado;
	}

	public String getDependente() {
		return dependente;
	}

	public void setDependente(String dependente) {
		this.dependente = dependente;
	}

	public String getPacifico() {
		return pacifico;
	}

	public void setPacifico(String pacifico) {
		this.pacifico = pacifico;
	}

	public String getArticulado() {
		return articulado;
	}

	public void setArticulado(String articulado) {
		this.articulado = articulado;
	}

	public String getPrevisivel() {
		return previsivel;
	}

	public void setPrevisivel(String previsivel) {
		this.previsivel = previsivel;
	}

	public String getSeguro() {
		return seguro;
	}

	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	public String getDedicado() {
		return dedicado;
	}

	public void setDedicado(String dedicado) {
		this.dedicado = dedicado;
	}

	public String getPersuasivo() {
		return persuasivo;
	}

	public void setPersuasivo(String persuasivo) {
		this.persuasivo = persuasivo;
	}

	public String getEncantador() {
		return encantador;
	}

	public void setEncantador(String encantador) {
		this.encantador = encantador;
	}

	public String getTeimoso() {
		return teimoso;
	}

	public void setTeimoso(String teimoso) {
		this.teimoso = teimoso;
	}

	public String getCompetitivo() {
		return competitivo;
	}

	public void setCompetitivo(String competitivo) {
		this.competitivo = competitivo;
	}

	public String getMaleavel() {
		return maleavel;
	}

	public void setMaleavel(String maleavel) {
		this.maleavel = maleavel;
	}

	public String getObediente() {
		return obediente;
	}

	public void setObediente(String obediente) {
		this.obediente = obediente;
	}

	public String getIntrospectivo() {
		return introspectivo;
	}

	public void setIntrospectivo(String introspectivo) {
		this.introspectivo = introspectivo;
	}

	public String getPerfeccionista() {
		return perfeccionista;
	}

	public void setPerfeccionista(String perfeccionista) {
		this.perfeccionista = perfeccionista;
	}

	public String getPrecavido() {
		return precavido;
	}

	public void setPrecavido(String precavido) {
		this.precavido = precavido;
	}

	public String getPratico() {
		return pratico;
	}

	public void setPratico(String pratico) {
		this.pratico = pratico;
	}

	public String getImpulsivo() {
		return impulsivo;
	}

	public void setImpulsivo(String impulsivo) {
		this.impulsivo = impulsivo;
	}

	public String getSemLimites() {
		return semLimites;
	}

	public void setSemLimites(String semLimites) {
		this.semLimites = semLimites;
	}

	public String getIndiferente() {
		return indiferente;
	}

	public void setIndiferente(String indiferente) {
		this.indiferente = indiferente;
	}

	public String getAgil() {
		return agil;
	}

	public void setAgil(String agil) {
		this.agil = agil;
	}

	public String getSociavel() {
		return sociavel;
	}

	public void setSociavel(String sociavel) {
		this.sociavel = sociavel;
	}

	public String getCarismatico() {
		return carismatico;
	}

	public void setCarismatico(String carismatico) {
		this.carismatico = carismatico;
	}

	public String getPassivo() {
		return passivo;
	}

	public void setPassivo(String passivo) {
		this.passivo = passivo;
	}

	public String getOusado() {
		return ousado;
	}

	public void setOusado(String ousado) {
		this.ousado = ousado;
	}

	public String getIndependente() {
		return independente;
	}

	public void setIndependente(String independente) {
		this.independente = independente;
	}

	public String getCauteloso() {
		return cauteloso;
	}

	public void setCauteloso(String cauteloso) {
		this.cauteloso = cauteloso;
	}

	public String getConvincente() {
		return convincente;
	}

	public void setConvincente(String convincente) {
		this.convincente = convincente;
	}

	public String getAlegre() {
		return alegre;
	}

	public void setAlegre(String alegre) {
		this.alegre = alegre;
	}

	public String getDestemido() {
		return destemido;
	}

	public void setDestemido(String destemido) {
		this.destemido = destemido;
	}

	public String getMenteAberta() {
		return menteAberta;
	}

	public void setMenteAberta(String menteAberta) {
		this.menteAberta = menteAberta;
	}

	public String getInspirador() {
		return inspirador;
	}

	public void setInspirador(String inspirador) {
		this.inspirador = inspirador;
	}

	public String getFirme() {
		return firme;
	}

	public void setFirme(String firme) {
		this.firme = firme;
	}

	public String getPreciso() {
		return preciso;
	}

	public void setPreciso(String preciso) {
		this.preciso = preciso;
	}

	public String getDesprendido() {
		return desprendido;
	}

	public void setDesprendido(String desprendido) {
		this.desprendido = desprendido;
	}

	public String getObstinado() {
		return obstinado;
	}

	public void setObstinado(String obstinado) {
		this.obstinado = obstinado;
	}

	public String getCalmo() {
		return calmo;
	}

	public void setCalmo(String calmo) {
		this.calmo = calmo;
	}

	public String getLeal() {
		return leal;
	}

	public void setLeal(String leal) {
		this.leal = leal;
	}

	public String getAmavel() {
		return amavel;
	}

	public void setAmavel(String amavel) {
		this.amavel = amavel;
	}

	public String getContido() {
		return contido;
	}

	public void setContido(String contido) {
		this.contido = contido;
	}

	public String getEmpolgado() {
		return empolgado;
	}

	public void setEmpolgado(String empolgado) {
		this.empolgado = empolgado;
	}

	public String getCompreensivo() {
		return compreensivo;
	}

	public void setCompreensivo(String compreensivo) {
		this.compreensivo = compreensivo;
	}

	public String getExtrovertido() {
		return extrovertido;
	}

	public void setExtrovertido(String extrovertido) {
		this.extrovertido = extrovertido;
	}

	public String getPrevenido() {
		return prevenido;
	}

	public void setPrevenido(String prevenido) {
		this.prevenido = prevenido;
	}

	public String getVersatil() {
		return versatil;
	}

	public void setVersatil(String versatil) {
		this.versatil = versatil;
	}

	public String getEnergico() {
		return energico;
	}

	public void setEnergico(String energico) {
		this.energico = energico;
	}

	public String getPersistente() {
		return persistente;
	}

	public void setPersistente(String persistente) {
		this.persistente = persistente;
	}

	public String getDesligado() {
		return desligado;
	}

	public void setDesligado(String desligado) {
		this.desligado = desligado;
	}

	public String getDivertido() {
		return divertido;
	}

	public void setDivertido(String divertido) {
		this.divertido = divertido;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getAssumeRiscosCalculados() {
		return assumeRiscosCalculados;
	}

	public void setAssumeRiscosCalculados(String assumeRiscosCalculados) {
		this.assumeRiscosCalculados = assumeRiscosCalculados;
	}

	public String getDisciplinado() {
		return disciplinado;
	}

	public void setDisciplinado(String disciplinado) {
		this.disciplinado = disciplinado;
	}

	public String getMeticuloso() {
		return meticuloso;
	}

	public void setMeticuloso(String meticuloso) {
		this.meticuloso = meticuloso;
	}

	public String getPonderado() {
		return ponderado;
	}

	public void setPonderado(String ponderado) {
		this.ponderado = ponderado;
	}

	public String getObservador() {
		return observador;
	}

	public void setObservador(String observador) {
		this.observador = observador;
	}

	public String getAnsioso() {
		return ansioso;
	}

	public void setAnsioso(String ansioso) {
		this.ansioso = ansioso;
	}

	public String getAnalitico() {
		return analitico;
	}

	public void setAnalitico(String analitico) {
		this.analitico = analitico;
	}

	public String getAnimado() {
		return animado;
	}

	public void setAnimado(String animado) {
		this.animado = animado;
	}

	public String getDiscreto() {
		return discreto;
	}

	public void setDiscreto(String discreto) {
		this.discreto = discreto;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getConciliador() {
		return conciliador;
	}

	public void setConciliador(String conciliador) {
		this.conciliador = conciliador;
	}

	public String getLiberal() {
		return liberal;
	}

	public void setLiberal(String liberal) {
		this.liberal = liberal;
	}

	public String getSarcastico() {
		return sarcastico;
	}

	public void setSarcastico(String sarcastico) {
		this.sarcastico = sarcastico;
	}

	public String getPessimista() {
		return pessimista;
	}

	public void setPessimista(String pessimista) {
		this.pessimista = pessimista;
	}

	public String getRebelde() {
		return rebelde;
	}

	public void setRebelde(String rebelde) {
		this.rebelde = rebelde;
	}

	public String getDiplomatico() {
		return diplomatico;
	}

	public void setDiplomatico(String diplomatico) {
		this.diplomatico = diplomatico;
	}

	public String getDireto() {
		return direto;
	}

	public void setDireto(String direto) {
		this.direto = direto;
	}

	public String getAtencioso() {
		return atencioso;
	}

	public void setAtencioso(String atencioso) {
		this.atencioso = atencioso;
	}

	public String getDominador() {
		return dominador;
	}

	public void setDominador(String dominador) {
		this.dominador = dominador;
	}

	public String getReceoso() {
		return receoso;
	}

	public void setReceoso(String receoso) {
		this.receoso = receoso;
	}

	public String getRespeitoso() {
		return respeitoso;
	}

	public void setRespeitoso(String respeitoso) {
		this.respeitoso = respeitoso;
	}

	public String getDescrente() {
		return descrente;
	}

	public void setDescrente(String descrente) {
		this.descrente = descrente;
	}

	public String getAgitado() {
		return agitado;
	}

	public void setAgitado(String agitado) {
		this.agitado = agitado;
	}

	public String getInfluente() {
		return influente;
	}

	public void setInfluente(String influente) {
		this.influente = influente;
	}

	public String getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}

	public String getExpansivo() {
		return expansivo;
	}

	public void setExpansivo(String expansivo) {
		this.expansivo = expansivo;
	}

	public String getConvencional() {
		return convencional;
	}

	public void setConvencional(String convencional) {
		this.convencional = convencional;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getAventureiro() {
		return aventureiro;
	}

	public void setAventureiro(String aventureiro) {
		this.aventureiro = aventureiro;
	}

	public String getDecidido() {
		return decidido;
	}

	public void setDecidido(String decidido) {
		this.decidido = decidido;
	}

	public String getRealista() {
		return realista;
	}

	public void setRealista(String realista) {
		this.realista = realista;
	}

	public String getExpressivo() {
		return expressivo;
	}

	public void setExpressivo(String expressivo) {
		this.expressivo = expressivo;
	}

	public String getDeterminado() {
		return determinado;
	}

	public void setDeterminado(String determinado) {
		this.determinado = determinado;
	}

	public String getFechado() {
		return fechado;
	}

	public void setFechado(String fechado) {
		this.fechado = fechado;
	}

	public String getAutoconfiante() {
		return autoconfiante;
	}

	public void setAutoconfiante(String autoconfiante) {
		this.autoconfiante = autoconfiante;
	}

	public String getSensato() {
		return sensato;
	}

	public void setSensato(String sensato) {
		this.sensato = sensato;
	}

	public String getAdequado() {
		return adequado;
	}

	public void setAdequado(String adequado) {
		this.adequado = adequado;
	}

	public String getEspontaneo() {
		return espontaneo;
	}

	public void setEspontaneo(String espontaneo) {
		this.espontaneo = espontaneo;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getDesconfiado() {
		return desconfiado;
	}

	public void setDesconfiado(String desconfiado) {
		this.desconfiado = desconfiado;
	}

	public String getLivre() {
		return livre;
	}

	public void setLivre(String livre) {
		this.livre = livre;
	}

	public String getJusto() {
		return justo;
	}

	public void setJusto(String justo) {
		this.justo = justo;
	}

	public String getDesencanado() {
		return desencanado;
	}

	public void setDesencanado(String desencanado) {
		this.desencanado = desencanado;
	}

	public String getLogico() {
		return logico;
	}

	public void setLogico(String logico) {
		this.logico = logico;
	}

	public String getApatico() {
		return apatico;
	}

	public void setApatico(String apatico) {
		this.apatico = apatico;
	}

	public String getReservado() {
		return reservado;
	}

	public void setReservado(String reservado) {
		this.reservado = reservado;
	}

	public String getHumilde() {
		return humilde;
	}

	public void setHumilde(String humilde) {
		this.humilde = humilde;
	}

	public String getEgocentrico() {
		return egocentrico;
	}

	public void setEgocentrico(String egocentrico) {
		this.egocentrico = egocentrico;
	}

	public String getSistematico() {
		return sistematico;
	}

	public void setSistematico(String sistematico) {
		this.sistematico = sistematico;
	}

	public String getGostaDeSeArriscar() {
		return gostaDeSeArriscar;
	}

	public void setGostaDeSeArriscar(String gostaDeSeArriscar) {
		this.gostaDeSeArriscar = gostaDeSeArriscar;
	}

	public String getSereno() {
		return sereno;
	}

	public void setSereno(String sereno) {
		this.sereno = sereno;
	}

	public String getCortes() {
		return cortes;
	}

	public void setCortes(String cortes) {
		this.cortes = cortes;
	}

	public String getSerio() {
		return serio;
	}

	public void setSerio(String serio) {
		this.serio = serio;
	}
}
