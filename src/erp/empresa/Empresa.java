package erp.empresa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
@Table(indexes = { @Index(name = "INDEX_EMPRESA_CNPJ", columnList = "cnpj", unique = true) })

public class Empresa implements Serializable {

	@Column(length = 10)
	private String capitalSocial;
	@Column(length = 19)
	private String cnpj;
	@Column(length = 10)
	private String dataFundacao;
	@Column(length = 50)
	private String email;
	@Column(length = 50)
	private String enderecoBairro;
	@Column(length = 10)
	private String enderecoCep;
	@Column(length = 50)
	private String enderecoCidade;
	@Column(length = 50)
	private String enderecoComplemento;
	@Column(length = 50)
	private String enderecoEstado;
	@Column(length = 50)
	private String enderecoLogradouro;
	private Double faturamentoMensal;
	@Column(length = 20)
	private String fax;
	@Column(length = 20)
	private String fone1;
	@Column(length = 20)
	private String fone2;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 20)
	private String inscricaoEstadual;
	@Column(length = 20)
	private String inscricaoMunicipal;
	@Column(length = 50)
	private String nomeFantasia;
	@Column(length = 6)
	private String numeroFuncionarios;
	@Column(length = 50)
	private String enderecoPais;
	@Column(length = 50)
	private String ramoAtividade;
	@Column(length = 50)
	private String razaoSocial;
	@Column(length = 6)
	private String tipoEmpresa;

	public String getCapitalSocial() {
		return this.capitalSocial;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public String getDataFundacao() {
		return this.dataFundacao;
	}

	public String getEmail() {
		return this.email;
	}

	public String getEnderecoBairro() {
		return this.enderecoBairro;
	}

	public String getEnderecoCep() {
		return this.enderecoCep;
	}

	public String getEnderecoCidade() {
		return this.enderecoCidade;
	}

	public String getEnderecoComplemento() {
		return this.enderecoComplemento;
	}

	public String getEnderecoEstado() {
		return this.enderecoEstado;
	}

	public String getEnderecoLogradouro() {
		return this.enderecoLogradouro;
	}

	public Double getFaturamentoMensal() {
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

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public String getNumeroFuncionarios() {
		return this.numeroFuncionarios;
	}

	public String getEnderecoPais() {
		return this.enderecoPais;
	}

	public String getRamoAtividade() {
		return this.ramoAtividade;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public String getTipoEmpresa() {
		return this.tipoEmpresa;
	}

	public void setCapitalSocial(String capitalSocial) {
		this.capitalSocial = capitalSocial;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setDataFundacao(String dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}

	public void setEnderecoCep(String enderecoCep) {
		this.enderecoCep = enderecoCep;
	}

	public void setEnderecoCidade(String enderecoCidade) {
		this.enderecoCidade = enderecoCidade;
	}

	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
	}

	public void setEnderecoEstado(String enderecoEstado) {
		this.enderecoEstado = enderecoEstado;
	}

	public void setEnderecoLogradouro(String enderecoLogradouro) {
		this.enderecoLogradouro = enderecoLogradouro;
	}

	public void setFaturamentoMensal(Double faturamentoMensal) {
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

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public void setNumeroFuncionarios(String numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public void setEnderecoPais(String enderecoPais) {
		this.enderecoPais = enderecoPais;
	}

	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public void setRazaoSocial(String enderecoEstadoCivil) {
		this.razaoSocial = enderecoEstadoCivil;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	@Override
	public String toString() {
		return this.nomeFantasia;
	}
}
