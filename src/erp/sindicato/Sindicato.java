package erp.sindicato;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "cnpj" }) })
public class Sindicato implements Serializable {

	@Column(length = 50)
	private String bairro;
	@Column(length = 50)
	private String capitalSocial;
	@Column(length = 10)
	private String cep;
	@Column(length = 50)
	private String cidade;
	@Column(length = 19)
	private String cnpj;
	@Column(length = 20)
	private String complemento;
	@Column(length = 10)
	private String dataFundacao;
	@Column(length = 10)
	private String email;
	@Column(length = 50)
	private String estado;
	@Column(length = 10)
	private String faturamentoMensal;
	@Column(length = 20)
	private String fax;
	@Column(length = 20)
	private String fone1;
	@Column(length = 20)
	private String fone2;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private String inscricaoEstadual;
	@Column(length = 50)
	private String inscricaoMunicipal;
	@Column(length = 50)
	private String logradouro;
	@Column(length = 50)
	private String nomeFantasia;
	@Column(length = 10)
	private String numeroFuncionarios;
	@Column(length = 50)
	private String pais;
	@Column(length = 50)
	private String ramoAtividade;
	@Column(length = 30)
	private String razaoSocial;
	@Column(length = 6)
	private String tipoSindicato;

	public String getBairro() {
		return this.bairro;
	}

	public String getCapitalSocial() {
		return this.capitalSocial;
	}

	public String getCep() {
		return this.cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public String getDataFundacao() {
		return this.dataFundacao;
	}

	public String getEmail() {
		return this.email;
	}

	public String getEstado() {
		return this.estado;
	}

	public String getFaturamentoMensal() {
		return this.faturamentoMensal;
	}

	public String getFax() {
		return this.fax;
	}

	public String getFone1() {
		return this.fone1;
	}

	public String getFone2() {
		return this.fone2;
	}

	public Long getId() {
		return this.id;
	}

	public String getInscricaoEstadual() {
		return this.inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return this.inscricaoMunicipal;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public String getNumeroFuncionarios() {
		return this.numeroFuncionarios;
	}

	public String getPais() {
		return this.pais;
	}

	public String getRamoAtividade() {
		return this.ramoAtividade;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public String getTipoSindicato() {
		return this.tipoSindicato;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCapitalSocial(String capitalSocial) {
		this.capitalSocial = capitalSocial;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setDataFundacao(String dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setFaturamentoMensal(String faturamentoMensal) {
		this.faturamentoMensal = faturamentoMensal;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public void setNumeroFuncionarios(String numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public void setRazaoSocial(String estadoCivil) {
		this.razaoSocial = estadoCivil;
	}

	public void setTipoSindicato(String tipoSindicato) {
		this.tipoSindicato = tipoSindicato;
	}

	@Override
	public String toString() {
		return this.nomeFantasia;
	}
}
