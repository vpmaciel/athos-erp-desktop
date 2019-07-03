package erp.cliente;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

import erp.banco.Banco;
import erp.empresa.Empresa;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
@Table(indexes = { @Index(name = "INDEX_CLIENTE_CPF", columnList = "cpf", unique = true),
		@Index(name = "INDEX_CLIENTE_CNPJ", columnList = "cnpj", unique = true) })

public class Cliente implements Serializable {

	@Column(length = 4)
	private String anoReferenciaCadastro;
	@ManyToOne(cascade = CascadeType.ALL)
	private Banco banco;
	@Column(length = 50)
	private String cargo;
	@Column(length = 50)
	private String classeEconomica;
	@Column(length = 19)
	private String cnpj;
	@Column(length = 14)
	private String cpf;
	@Column(length = 10)
	private String dataCadastro;
	@Column(length = 10)
	private String dataNascimento;
	@Column(length = 22)
	private String deficiencia;
	@Column(length = 50)
	private String email;
	@ManyToOne(cascade = CascadeType.ALL)
	private Empresa empresa;
	@Column(length = 50)
	private String enderecoBairro;
	@Column(length = 10)
	private String enderecoCep;
	@Column(length = 50)
	private String enderecoCidade;
	@Column(length = 20)
	private String enderecoComplemento;
	@Column(length = 50)
	private String enderecoEstado;
	@Column(length = 14)
	private String enderecoEstadoCivil;
	@Column(length = 50)
	private String enderecoLogradouro;
	@Column(length = 24)
	private String escolaridade;
	@Column(length = 20)
	private String fax;
	@Column(length = 20)
	private String fone1;
	@Column(length = 20)
	private String fone2;
	@Column(length = 20)
	private String foneReferencia1;
	@Column(length = 20)
	private String foneReferencia2;
	@Column(length = 20)
	private String foneReferencia3;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 3)
	private String idade;
	@Column(length = 9)
	private String mesReferenciaCadastro;
	@Column(length = 31)
	private String nacionalidade;
	@Column(length = 50, nullable = false)
	private String nome;
	@Column(length = 50)
	private String nomeReferencia1;
	@Column(length = 50)
	private String nomeReferencia2;
	@Column(length = 50)
	private String nomeReferencia3;
	@Column(length = 20)
	private String numeroAgenciaBancaria;
	@Column(length = 20)
	private String numeroContaBancaria;
	@Column(length = 50)
	private String pais;
	@Column(length = 18)
	private String relacionamentoReferencia1;
	@Column(length = 18)
	private String relacionamentoReferencia2;
	@Column(length = 18)
	private String relacionamentoReferencia3;
	@Column(length = 15)
	private String rgNumero;
	@Column(length = 20)
	private String rgOrgaoEmissor;
	@Column(length = 10)
	private String salario;
	@Column(length = 9)
	private String sexo;
	@Column(length = 7)
	private String status;

	public Cliente() {

	}

	public String getAnoReferenciaCadastro() {
		return anoReferenciaCadastro;
	}

	public Banco getBanco() {
		return banco;
	}

	public String getCargo() {
		return this.cargo;
	}

	public String getClasseEconomica() {
		return this.classeEconomica;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public String getCpf() {
		return this.cpf;
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

	public String getEnderecoEstadoCivil() {
		return this.enderecoEstadoCivil;
	}

	public String getEnderecoLogradouro() {
		return this.enderecoLogradouro;
	}

	public String getEscolaridade() {
		return escolaridade;
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
		this.anoReferenciaCadastro = anoReferenciaCadastro;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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

	public void setEnderecoEstadoCivil(String enderecoEstadoCivil) {
		this.enderecoEstadoCivil = enderecoEstadoCivil;
	}

	public void setEnderecoLogradouro(String enderecoLogradouro) {
		this.enderecoLogradouro = enderecoLogradouro;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
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

	public void setFoneReferencia1(String foneReferencia1) {
		this.foneReferencia1 = foneReferencia1;
	}

	public void setFoneReferencia2(String foneReferencia2) {
		this.foneReferencia2 = foneReferencia2;
	}

	public void setFoneReferencia3(String foneReferencia3) {
		this.foneReferencia3 = foneReferencia3;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public void setMesReferenciaCadastro(String mesReferenciaCadastro) {
		this.mesReferenciaCadastro = mesReferenciaCadastro;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNomeReferencia1(String nomeReferencia1) {
		this.nomeReferencia1 = nomeReferencia1;
	}

	public void setNomeReferencia2(String nomeReferencia2) {
		this.nomeReferencia2 = nomeReferencia2;
	}

	public void setNomeReferencia3(String nomeReferencia3) {
		this.nomeReferencia3 = nomeReferencia3;
	}

	public void setNumeroAgenciaBancaria(String numeroAgenciaBancaria) {
		this.numeroAgenciaBancaria = numeroAgenciaBancaria;
	}

	public void setNumeroContaBancaria(String numeroContaBancaria) {
		this.numeroContaBancaria = numeroContaBancaria;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setRelacionamentoReferencia1(String relacionamentoReferencia1) {
		this.relacionamentoReferencia1 = relacionamentoReferencia1;
	}

	public void setRelacionamentoReferencia2(String relacionamentoReferencia2) {
		this.relacionamentoReferencia2 = relacionamentoReferencia2;
	}

	public void setRelacionamentoReferencia3(String relacionamentoReferencia3) {
		this.relacionamentoReferencia3 = relacionamentoReferencia3;
	}

	public void setRgNumero(String rgNumero) {
		this.rgNumero = rgNumero;
	}

	public void setRgOrgaoEmissor(String rgOrgaoEmissor) {
		this.rgOrgaoEmissor = rgOrgaoEmissor;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return this.nome;
	}
}
