package erp.cliente;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import erp.banco.Banco;
import erp.empresa.Empresa;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "cpfNumero", "cnpj" }) })
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length = 9)
	private String mesReferenciaCadastro;
	@Column(length = 4)
	private String anoReferenciaCadastro;
	@Column(length = 19)
	private String cnpj;
	@Column(length = 10)
	private String dataCadastro;
	@Column(length = 50)
	private String cargo;
	@Column(length = 50)
	private String classeEconomica;
	@Column(length = 14)
	private String cpfNumero;
	@Column(length = 50)
	private String email;
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, optional = true)
	private Empresa empresa;
	@Column(length = 14)
	private String estadoCivil;
	@Column(length = 20)
	private String fax;
	@Column(length = 20)
	private String fone1;
	@Column(length = 20)
	private String fone2;
	@Column(length = 50, nullable = false)
	private String nome;
	@Column(length = 15)
	private String rgNumero;
	@Column(length = 20)
	private String rgOrgaoEmissor;
	@Column(length = 10)
	private String salario;
	@Column(length = 9)
	private String sexo;
	@Column(length = 50)
	private String pais;
	@Column(length = 50)
	private String estado;
	@Column(length = 50)
	private String cidade;
	@Column(length = 50)
	private String bairro;
	@Column(length = 7)
	private String status;
	@Column(length = 20)
	private String complemento;
	@Column(length = 10)
	private String cep;
	@Column(length = 22)
	private String deficiencia;
	@Column(length = 24)
	private String escolaridade;
	@Column(length = 31)
	private String nacionalidade;
	@Column(length = 11)
	private String cor;
	@Column(length = 10)
	private String dataNascimento;
	@Column(length = 3)
	private String idade;
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, optional = true)
	private Banco banco;
	@Column(length = 20)
	private String numeroAgenciaBancaria;
	@Column(length = 20)
	private String numeroContaBancaria;
	@Column(length = 50)
	private String nomeReferencia1;
	@Column(length = 50)
	private String nomeReferencia2;
	@Column(length = 50)
	private String nomeReferencia3;
	@Column(length = 20)
	private String foneReferencia1;
	@Column(length = 20)
	private String foneReferencia2;
	@Column(length = 20)
	private String foneReferencia3;
	@Column(length = 50)
	private String logradouro;
	@Column(length = 18)
	private String relacionamentoReferencia1;
	@Column(length = 18)
	private String relacionamentoReferencia2;
	@Column(length = 18)
	private String relacionamentoReferencia3;

	public Cliente() {

	}

	public String getAnoReferenciaCadastro() {
		return anoReferenciaCadastro;
	}

	public String getBairro() {
		return this.bairro;
	}

	public Banco getBanco() {
		return banco;
	}

	public String getCargo() {
		return this.cargo;
	}

	public String getCep() {
		return this.cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public String getClasseEconomica() {
		return this.classeEconomica;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public String getCor() {
		return cor;
	}

	public String getCpf() {
		return this.cpfNumero;
	}

	public String getDataCadastro() {
		return this.dataCadastro;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getDeficiencia() {
		return deficiencia;
	}

	public String getEmail() {
		return this.email;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public String getEstado() {
		return this.estado;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
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

	public String getFoneReferencia1() {
		return foneReferencia1;
	}

	public String getFoneReferencia2() {
		return foneReferencia2;
	}

	public String getFoneReferencia3() {
		return foneReferencia3;
	}

	public Long getId() {
		return this.id;
	}

	public String getIdade() {
		return idade;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public String getMesReferenciaCadastro() {
		return mesReferenciaCadastro;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public String getNome() {
		return this.nome;
	}

	public String getNomeReferencia1() {
		return nomeReferencia1;
	}

	public String getNomeReferencia2() {
		return nomeReferencia2;
	}

	public String getNomeReferencia3() {
		return nomeReferencia3;
	}

	public String getNumeroAgenciaBancaria() {
		return numeroAgenciaBancaria;
	}

	public String getNumeroContaBancaria() {
		return numeroContaBancaria;
	}

	public String getPais() {
		return this.pais;
	}

	public String getRelacionamentoReferencia1() {
		return relacionamentoReferencia1;
	}

	public String getRelacionamentoReferencia2() {
		return relacionamentoReferencia2;
	}

	public String getRelacionamentoReferencia3() {
		return relacionamentoReferencia3;
	}

	public String getRgNumero() {
		return this.rgNumero;
	}

	public String getRgOrgaoEmissor() {
		return this.rgOrgaoEmissor;
	}

	public String getSalario() {
		return this.salario;
	}

	public String getSexo() {
		return this.sexo;
	}

	public String getStatus() {
		return status;
	}

	public void setAnoReferenciaCadastro(String anoReferenciaCadastro) {
		this.anoReferenciaCadastro = anoReferenciaCadastro.replaceAll("\\s+", " ").trim();
	}

	public void setBairro(String bairro) {
		this.bairro = bairro.replaceAll("\\s+", " ").trim();
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo.replaceAll("\\s+", " ").trim();
	}

	public void setCep(String cep) {
		this.cep = cep.replaceAll("\\s+", " ").trim();
	}

	public void setCidade(String cidade) {
		this.cidade = cidade.replaceAll("\\s+", " ").trim();
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica.replaceAll("\\s+", " ").trim();
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj.replaceAll("\\s+", " ").trim();
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento.replaceAll("\\s+", " ").trim();
	}

	public void setCor(String cor) {
		this.cor = cor.replaceAll("\\s+", " ").trim();
	}

	public void setCpf(String cpfNumero) {
		this.cpfNumero = cpfNumero.replaceAll("\\s+", " ").trim();
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro.replaceAll("\\s+", " ").trim();
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento.replaceAll("\\s+", " ").trim();
	}

	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia.replaceAll("\\s+", " ").trim();
	}

	public void setEmail(String email) {
		this.email = email.replaceAll("\\s+", " ").trim();
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade.replaceAll("\\s+", " ").trim();
	}

	public void setEstado(String estado) {
		this.estado = estado.replaceAll("\\s+", " ").trim();
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil.replaceAll("\\s+", " ").trim();
	}

	public void setFax(String fax) {
		this.fax = fax.replaceAll("\\s+", " ").trim();
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1.replaceAll("\\s+", " ").trim();
	}

	public void setFone2(String fone2) {
		this.fone2 = fone2.replaceAll("\\s+", " ").trim();
	}

	public void setFoneReferencia1(String foneReferencia1) {
		this.foneReferencia1 = foneReferencia1.replaceAll("\\s+", " ").trim();
	}

	public void setFoneReferencia2(String foneReferencia2) {
		this.foneReferencia2 = foneReferencia2.replaceAll("\\s+", " ").trim();
	}

	public void setFoneReferencia3(String foneReferencia3) {
		this.foneReferencia3 = foneReferencia3.replaceAll("\\s+", " ").trim();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIdade(String idade) {
		this.idade = idade.replaceAll("\\s+", " ").trim();
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro.replaceAll("\\s+", " ").trim();
	}

	public void setMesReferenciaCadastro(String mesReferenciaCadastro) {
		this.mesReferenciaCadastro = mesReferenciaCadastro.replaceAll("\\s+", " ").trim();
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade.replaceAll("\\s+", " ").trim();
	}

	public void setNome(String nome) {
		this.nome = nome.replaceAll("\\s+", " ").trim();
	}

	public void setNomeReferencia1(String nomeReferencia1) {
		this.nomeReferencia1 = nomeReferencia1.replaceAll("\\s+", " ").trim();
	}

	public void setNomeReferencia2(String nomeReferencia2) {
		this.nomeReferencia2 = nomeReferencia2.replaceAll("\\s+", " ").trim();
	}

	public void setNomeReferencia3(String nomeReferencia3) {
		this.nomeReferencia3 = nomeReferencia3.replaceAll("\\s+", " ").trim();
	}

	public void setNumeroAgenciaBancaria(String numeroAgenciaBancaria) {
		this.numeroAgenciaBancaria = numeroAgenciaBancaria.replaceAll("\\s+", " ").trim();
	}

	public void setNumeroContaBancaria(String numeroContaBancaria) {
		this.numeroContaBancaria = numeroContaBancaria.replaceAll("\\s+", " ").trim();
	}

	public void setPais(String pais) {
		this.pais = pais.replaceAll("\\s+", " ").trim();
	}

	public void setRelacionamentoReferencia1(String relacionamentoReferencia1) {
		this.relacionamentoReferencia1 = relacionamentoReferencia1.replaceAll("\\s+", " ").trim();
	}

	public void setRelacionamentoReferencia2(String relacionamentoReferencia2) {
		this.relacionamentoReferencia2 = relacionamentoReferencia2.replaceAll("\\s+", " ").trim();
	}

	public void setRelacionamentoReferencia3(String relacionamentoReferencia3) {
		this.relacionamentoReferencia3 = relacionamentoReferencia3.replaceAll("\\s+", " ").trim();
	}

	public void setRgNumero(String rgNumero) {
		this.rgNumero = rgNumero.replaceAll("\\s+", " ").trim();
	}

	public void setRgOrgaoEmissor(String rgOrgaoEmissor) {
		this.rgOrgaoEmissor = rgOrgaoEmissor.replaceAll("\\s+", " ").trim();
	}

	public void setSalario(String salario) {
		this.salario = salario.replaceAll("\\s+", " ").trim();
	}

	public void setSexo(String sexo) {
		this.sexo = sexo.replaceAll("\\s+", " ").trim();
	}

	public void setStatus(String status) {
		this.status = status.replaceAll("\\s+", " ").trim();
	}

	@Override
	public String toString() {
		return this.nome;
	}
}
