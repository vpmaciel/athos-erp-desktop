package erp.curriculo.caracteristica;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;

import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
public class Caracteristica implements Serializable {
	@Column(length = 3)
	private String adequado;
	@Column(length = 3)
	private String agil;
	@Column(length = 3)
	private String agitado;
	@Column(length = 3)
	private String alegre;
	@Column(length = 3)
	private String amavel;
	@Column(length = 3)
	private String analitico;
	@Column(length = 3)
	private String animado;
	@Column(length = 3)
	private String ansioso;
	@Column(length = 3)
	private String apatico;
	@Column(length = 3)
	private String articulado;
	@Column(length = 3)
	private String assumeRiscosCalculados;
	@Column(length = 3)
	private String atencioso;
	@Column(length = 3)
	private String ativo;
	@Column(length = 3)
	private String autoconfiante;
	@Column(length = 3)
	private String aventureiro;
	@Column(length = 3)
	private String bemHumorado;
	@Column(length = 3)
	private String calmo;
	@Column(length = 3)
	private String carismatico;
	@Column(length = 3)
	private String cauteloso;
	@Column(length = 3)
	private String competitivo;
	@Column(length = 3)
	private String compreensivo;
	@Column(length = 3)
	private String conciliador;
	@Column(length = 3)
	private String contido;
	@Column(length = 3)
	private String convencional;
	@Column(length = 3)
	private String convincente;
	@Column(length = 3)
	private String cortes;
	@Column(length = 3)
	private String cuidadoso;
	@Column(length = 3)
	private String decidido;
	@Column(length = 3)
	private String dedicado;
	@Column(length = 3)
	private String dependente;
	@Column(length = 3)
	private String desconfiado;
	@Column(length = 3)
	private String descrente;
	@Column(length = 3)
	private String desencanado;
	@Column(length = 3)
	private String desligado;
	@Column(length = 3)
	private String desprendido;
	@Column(length = 3)
	private String despretensioso;
	@Column(length = 3)
	private String destemido;
	@Column(length = 3)
	private String determinado;
	@Column(length = 3)
	private String diplomatico;
	@Column(length = 3)
	private String direto;
	@Column(length = 3)
	private String disciplinado;
	@Column(length = 3)
	private String discreto;
	@Column(length = 3)
	private String disponivel;
	@Column(length = 3)
	private String divertido;
	@Column(length = 3)
	private String dominador;
	@Column(length = 3)
	private String egocentrico;
	@Column(length = 3)
	private String empolgado;
	@Column(length = 3)
	private String encantador;
	@Column(length = 3)
	private String energico;
	@Column(length = 3)
	private String espontaneo;
	@Column(length = 3)
	private String estavel;
	@Column(length = 3)
	private String exigente;
	@Column(length = 3)
	private String expansivo;
	@Column(length = 3)
	private String expressivo;
	@Column(length = 3)
	private String extrovertido;
	@Column(length = 3)
	private String fechado;
	@Column(length = 3)
	private String firme;
	@ManyToOne(cascade = CascadeType.ALL)
	private Funcionario funcionario;
	@Column(length = 3)
	private String gostaDeSeArriscar;
	@Column(length = 3)
	private String humilde;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 3)
	private String impulsivo;
	@Column(length = 3)
	private String incerto;
	@Column(length = 3)
	private String independente;
	@Column(length = 3)
	private String indiferente;
	@Column(length = 3)
	private String influente;
	@Column(length = 3)
	private String inquieto;
	@Column(length = 3)
	private String inspirador;
	@Column(length = 3)
	private String interessado;
	@Column(length = 3)
	private String introspectivo;
	@Column(length = 3)
	private String justo;
	@Column(length = 3)
	private String leal;
	@Column(length = 3)
	private String liberal;
	@Column(length = 3)
	private String livre;
	@Column(length = 3)
	private String logico;
	@Column(length = 3)
	private String maleavel;
	@Column(length = 3)
	private String menteAberta;
	@Column(length = 3)
	private String meticuloso;
	@Column(length = 3)
	private String obediente;
	@Column(length = 3)
	private String objetivo;
	@Column(length = 3)
	private String observador;
	@Column(length = 3)
	private String obstinado;
	@Column(length = 3)
	private String original;
	@Column(length = 3)
	private String ousado;
	@Column(length = 3)
	private String paciente;
	@Column(length = 3)
	private String pacifico;
	@Column(length = 3)
	private String passivo;
	@Column(length = 3)
	private String perfeccionista;
	@Column(length = 3)
	private String persistente;
	@Column(length = 3)
	private String persuasivo;
	@Column(length = 3)
	private String pessimista;
	@Column(length = 3)
	private String ponderado;
	@Column(length = 3)
	private String pratico;
	@Column(length = 3)
	private String precavido;
	@Column(length = 3)
	private String preciso;
	@Column(length = 3)
	private String preocupado;
	@Column(length = 3)
	private String prevenido;
	@Column(length = 3)
	private String previsivel;
	@Column(length = 3)
	private String realista;
	@Column(length = 3)
	private String rebelde;
	@Column(length = 3)
	private String receoso;
	@Column(length = 3)
	private String reservado;
	@Column(length = 3)
	private String respeitoso;
	@Column(length = 3)
	private String sarcastico;
	@Column(length = 3)
	private String seguro;
	@Column(length = 3)
	private String semLimites;
	@Column(length = 3)
	private String sensato;
	@Column(length = 3)
	private String sereno;
	@Column(length = 3)
	private String serio;
	@Column(length = 3)
	private String simpatico;
	@Column(length = 3)
	private String sistematico;
	@Column(length = 3)
	private String sociavel;
	@Column(length = 3)
	private String teimoso;
	@Column(length = 3)
	private String versatil;

	public String getAdequado() {
		return adequado;
	}

	public String getAgil() {
		return agil;
	}

	public String getAgitado() {
		return agitado;
	}

	public String getAlegre() {
		return alegre;
	}

	public String getAmavel() {
		return amavel;
	}

	public String getAnalitico() {
		return analitico;
	}

	public String getAnimado() {
		return animado;
	}

	public String getAnsioso() {
		return ansioso;
	}

	public String getApatico() {
		return apatico;
	}

	public String getArticulado() {
		return articulado;
	}

	public String getAssumeRiscosCalculados() {
		return assumeRiscosCalculados;
	}

	public String getAtencioso() {
		return atencioso;
	}

	public String getAtivo() {
		return ativo;
	}

	public String getAutoConfiante() {
		return autoconfiante;
	}

	public String getAventureiro() {
		return aventureiro;
	}

	public String getBemHumorado() {
		return bemHumorado;
	}

	public String getCalmo() {
		return calmo;
	}

	public String getCarismatico() {
		return carismatico;
	}

	public String getCauteloso() {
		return cauteloso;
	}

	public String getCompetitivo() {
		return competitivo;
	}

	public String getCompreensivo() {
		return compreensivo;
	}

	public String getConciliador() {
		return conciliador;
	}

	public String getContido() {
		return contido;
	}

	public String getConvencional() {
		return convencional;
	}

	public String getConvincente() {
		return convincente;
	}

	public String getCortes() {
		return cortes;
	}

	public String getCuidadoso() {
		return cuidadoso;
	}

	public String getDecidido() {
		return decidido;
	}

	public String getDedicado() {
		return dedicado;
	}

	public String getDependente() {
		return dependente;
	}

	public String getDesconfiado() {
		return desconfiado;
	}

	public String getDescrente() {
		return descrente;
	}

	public String getDesencanado() {
		return desencanado;
	}

	public String getDesligado() {
		return desligado;
	}

	public String getDesprendido() {
		return desprendido;
	}

	public String getDespretensioso() {
		return despretensioso;
	}

	public String getDestemido() {
		return destemido;
	}

	public String getDeterminado() {
		return determinado;
	}

	public String getDiplomatico() {
		return diplomatico;
	}

	public String getDireto() {
		return direto;
	}

	public String getDisciplinado() {
		return disciplinado;
	}

	public String getDiscreto() {
		return discreto;
	}

	public String getDisponivel() {
		return disponivel;
	}

	public String getDivertido() {
		return divertido;
	}

	public String getDominador() {
		return dominador;
	}

	public String getEgocentrico() {
		return egocentrico;
	}

	public String getEmpolgado() {
		return empolgado;
	}

	public String getEncantador() {
		return encantador;
	}

	public String getEnergico() {
		return energico;
	}

	public String getEspontaneo() {
		return espontaneo;
	}

	public String getEstavel() {
		return estavel;
	}

	public String getExigente() {
		return exigente;
	}

	public String getExpansivo() {
		return expansivo;
	}

	public String getExpressivo() {
		return expressivo;
	}

	public String getExtrovertido() {
		return extrovertido;
	}

	public String getFechado() {
		return fechado;
	}

	public String getFirme() {
		return firme;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public String getGostaDeSeArriscar() {
		return gostaDeSeArriscar;
	}

	public String getHumilde() {
		return humilde;
	}

	public Long getId() {
		return id;
	}

	public String getImpulsivo() {
		return impulsivo;
	}

	public String getIncerto() {
		return incerto;
	}

	public String getIndependente() {
		return independente;
	}

	public String getIndiferente() {
		return indiferente;
	}

	public String getInfluente() {
		return influente;
	}

	public String getInquieto() {
		return inquieto;
	}

	public String getInspirador() {
		return inspirador;
	}

	public String getInteressado() {
		return interessado;
	}

	public String getIntrospectivo() {
		return introspectivo;
	}

	public String getJusto() {
		return justo;
	}

	public String getLeal() {
		return leal;
	}

	public String getLiberal() {
		return liberal;
	}

	public String getLivre() {
		return livre;
	}

	public String getLogico() {
		return logico;
	}

	public String getMaleavel() {
		return maleavel;
	}

	public String getMenteAberta() {
		return menteAberta;
	}

	public String getMeticuloso() {
		return meticuloso;
	}

	public String getObediente() {
		return obediente;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public String getObservador() {
		return observador;
	}

	public String getObstinado() {
		return obstinado;
	}

	public String getOriginal() {
		return original;
	}

	public String getOusado() {
		return ousado;
	}

	public String getPaciente() {
		return paciente;
	}

	public String getPacifico() {
		return pacifico;
	}

	public String getPassivo() {
		return passivo;
	}

	public String getPerfeccionista() {
		return perfeccionista;
	}

	public String getPersistente() {
		return persistente;
	}

	public String getPersuasivo() {
		return persuasivo;
	}

	public String getPessimista() {
		return pessimista;
	}

	public String getPonderado() {
		return ponderado;
	}

	public String getPratico() {
		return pratico;
	}

	public String getPrecavido() {
		return precavido;
	}

	public String getPreciso() {
		return preciso;
	}

	public String getPreocupado() {
		return preocupado;
	}

	public String getPrevenido() {
		return prevenido;
	}

	public String getPrevisivel() {
		return previsivel;
	}

	public String getRealista() {
		return realista;
	}

	public String getRebelde() {
		return rebelde;
	}

	public String getReceoso() {
		return receoso;
	}

	public String getReservado() {
		return reservado;
	}

	public String getRespeitoso() {
		return respeitoso;
	}

	public String getSarcastico() {
		return sarcastico;
	}

	public String getSeguro() {
		return seguro;
	}

	public String getSemLimites() {
		return semLimites;
	}

	public String getSensato() {
		return sensato;
	}

	public String getSereno() {
		return sereno;
	}

	public String getSerio() {
		return serio;
	}

	public String getSimpatico() {
		return simpatico;
	}

	public String getSistematico() {
		return sistematico;
	}

	public String getSociavel() {
		return sociavel;
	}

	public String getTeimoso() {
		return teimoso;
	}

	public String getVersatil() {
		return versatil;
	}

	public void setAdequado(String adequado) {
		this.adequado = adequado;
	}

	public void setAgil(String agil) {
		this.agil = agil;
	}

	public void setAgitado(String agitado) {
		this.agitado = agitado;
	}

	public void setAlegre(String alegre) {
		this.alegre = alegre;
	}

	public void setAmavel(String amavel) {
		this.amavel = amavel;
	}

	public void setAnalitico(String analitico) {
		this.analitico = analitico;
	}

	public void setAnimado(String animado) {
		this.animado = animado;
	}

	public void setAnsioso(String ansioso) {
		this.ansioso = ansioso;
	}

	public void setApatico(String apatico) {
		this.apatico = apatico;
	}

	public void setArticulado(String articulado) {
		this.articulado = articulado;
	}

	public void setAssumeRiscosCalculados(String assumeRiscosCalculados) {
		this.assumeRiscosCalculados = assumeRiscosCalculados;
	}

	public void setAtencioso(String atencioso) {
		this.atencioso = atencioso;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public void setAutoconfiante(String autoconfiante) {
		this.autoconfiante = autoconfiante;
	}

	public void setAventureiro(String aventureiro) {
		this.aventureiro = aventureiro;
	}

	public void setBemHumorado(String bemHumorado) {
		this.bemHumorado = bemHumorado;
	}

	public void setCalmo(String calmo) {
		this.calmo = calmo;
	}

	public void setCarismatico(String carismatico) {
		this.carismatico = carismatico;
	}

	public void setCauteloso(String cauteloso) {
		this.cauteloso = cauteloso;
	}

	public void setCompetitivo(String competitivo) {
		this.competitivo = competitivo;
	}

	public void setCompreensivo(String compreensivo) {
		this.compreensivo = compreensivo;
	}

	public void setConciliador(String conciliador) {
		this.conciliador = conciliador;
	}

	public void setContido(String contido) {
		this.contido = contido;
	}

	public void setConvencional(String convencional) {
		this.convencional = convencional;
	}

	public void setConvincente(String convincente) {
		this.convincente = convincente;
	}

	public void setCortes(String cortes) {
		this.cortes = cortes;
	}

	public void setCuidadoso(String cuidadoso) {
		this.cuidadoso = cuidadoso;
	}

	public void setDecidido(String decidido) {
		this.decidido = decidido;
	}

	public void setDedicado(String dedicado) {
		this.dedicado = dedicado;
	}

	public void setDependente(String dependente) {
		this.dependente = dependente;
	}

	public void setDesconfiado(String desconfiado) {
		this.desconfiado = desconfiado;
	}

	public void setDescrente(String descrente) {
		this.descrente = descrente;
	}

	public void setDesencanado(String desencanado) {
		this.desencanado = desencanado;
	}

	public void setDesligado(String desligado) {
		this.desligado = desligado;
	}

	public void setDesprendido(String desprendido) {
		this.desprendido = desprendido;
	}

	public void setDespretensioso(String despretensioso) {
		this.despretensioso = despretensioso;
	}

	public void setDestemido(String destemido) {
		this.destemido = destemido;
	}

	public void setDeterminado(String determinado) {
		this.determinado = determinado;
	}

	public void setDiplomatico(String diplomatico) {
		this.diplomatico = diplomatico;
	}

	public void setDireto(String direto) {
		this.direto = direto;
	}

	public void setDisciplinado(String disciplinado) {
		this.disciplinado = disciplinado;
	}

	public void setDiscreto(String discreto) {
		this.discreto = discreto;
	}

	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}

	public void setDivertido(String divertido) {
		this.divertido = divertido;
	}

	public void setDominador(String dominador) {
		this.dominador = dominador;
	}

	public void setEgocentrico(String egocentrico) {
		this.egocentrico = egocentrico;
	}

	public void setEmpolgado(String empolgado) {
		this.empolgado = empolgado;
	}

	public void setEncantador(String encantador) {
		this.encantador = encantador;
	}

	public void setEnergico(String energico) {
		this.energico = energico;
	}

	public void setEspontaneo(String espontaneo) {
		this.espontaneo = espontaneo;
	}

	public void setEstavel(String estavel) {
		this.estavel = estavel;
	}

	public void setExigente(String exigente) {
		this.exigente = exigente;
	}

	public void setExpansivo(String expansivo) {
		this.expansivo = expansivo;
	}

	public void setExpressivo(String expressivo) {
		this.expressivo = expressivo;
	}

	public void setExtrovertido(String extrovertido) {
		this.extrovertido = extrovertido;
	}

	public void setFechado(String fechado) {
		this.fechado = fechado;
	}

	public void setFirme(String firme) {
		this.firme = firme;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setGostaDeSeArriscar(String gostaDeSeArriscar) {
		this.gostaDeSeArriscar = gostaDeSeArriscar;
	}

	public void setHumilde(String humilde) {
		this.humilde = humilde;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setImpulsivo(String impulsivo) {
		this.impulsivo = impulsivo;
	}

	public void setIncerto(String incerto) {
		this.incerto = incerto;
	}

	public void setIndependente(String independente) {
		this.independente = independente;
	}

	public void setIndiferente(String indiferente) {
		this.indiferente = indiferente;
	}

	public void setInfluente(String influente) {
		this.influente = influente;
	}

	public void setInquieto(String inquieto) {
		this.inquieto = inquieto;
	}

	public void setInspirador(String inspirador) {
		this.inspirador = inspirador;
	}

	public void setInteressado(String interessado) {
		this.interessado = interessado;
	}

	public void setIntrospectivo(String introspectivo) {
		this.introspectivo = introspectivo;
	}

	public void setJusto(String justo) {
		this.justo = justo;
	}

	public void setLeal(String leal) {
		this.leal = leal;
	}

	public void setLiberal(String liberal) {
		this.liberal = liberal;
	}

	public void setLivre(String livre) {
		this.livre = livre;
	}

	public void setLogico(String logico) {
		this.logico = logico;
	}

	public void setMaleavel(String maleavel) {
		this.maleavel = maleavel;
	}

	public void setMenteAberta(String menteAberta) {
		this.menteAberta = menteAberta;
	}

	public void setMeticuloso(String meticuloso) {
		this.meticuloso = meticuloso;
	}

	public void setObediente(String obediente) {
		this.obediente = obediente;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public void setObservador(String observador) {
		this.observador = observador;
	}

	public void setObstinado(String obstinado) {
		this.obstinado = obstinado;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public void setOusado(String ousado) {
		this.ousado = ousado;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public void setPacifico(String pacifico) {
		this.pacifico = pacifico;
	}

	public void setPassivo(String passivo) {
		this.passivo = passivo;
	}

	public void setPerfeccionista(String perfeccionista) {
		this.perfeccionista = perfeccionista;
	}

	public void setPersistente(String persistente) {
		this.persistente = persistente;
	}

	public void setPersuasivo(String persuasivo) {
		this.persuasivo = persuasivo;
	}

	public void setPessimista(String pessimista) {
		this.pessimista = pessimista;
	}

	public void setPonderado(String ponderado) {
		this.ponderado = ponderado;
	}

	public void setPratico(String pratico) {
		this.pratico = pratico;
	}

	public void setPrecavido(String precavido) {
		this.precavido = precavido;
	}

	public void setPreciso(String preciso) {
		this.preciso = preciso;
	}

	public void setPreocupado(String preocupado) {
		this.preocupado = preocupado;
	}

	public void setPrevenido(String prevenido) {
		this.prevenido = prevenido;
	}

	public void setPrevisivel(String previsivel) {
		this.previsivel = previsivel;
	}

	public void setRealista(String realista) {
		this.realista = realista;
	}

	public void setRebelde(String rebelde) {
		this.rebelde = rebelde;
	}

	public void setReceoso(String receoso) {
		this.receoso = receoso;
	}

	public void setReservado(String reservado) {
		this.reservado = reservado;
	}

	public void setRespeitoso(String respeitoso) {
		this.respeitoso = respeitoso;
	}

	public void setSarcastico(String sarcastico) {
		this.sarcastico = sarcastico;
	}

	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	public void setSemLimites(String semLimites) {
		this.semLimites = semLimites;
	}

	public void setSensato(String sensato) {
		this.sensato = sensato;
	}

	public void setSereno(String sereno) {
		this.sereno = sereno;
	}

	public void setSerio(String serio) {
		this.serio = serio;
	}

	public void setSimpatico(String simpatico) {
		this.simpatico = simpatico;
	}

	public void setSistematico(String sistematico) {
		this.sistematico = sistematico;
	}

	public void setSociavel(String sociavel) {
		this.sociavel = sociavel;
	}

	public void setTeimoso(String teimoso) {
		this.teimoso = teimoso;
	}

	public void setVersatil(String versatil) {
		this.versatil = versatil;
	}
}
