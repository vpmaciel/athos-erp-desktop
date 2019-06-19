package erp.funcionario;

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

import erp.centrocusto.CentroCusto;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
@Table(indexes = { @Index(name = "INDEX_FUNCIONARIO_CPF", columnList = "cpf", unique = true),
		@Index(name = "INDEX_FUNCIONARIO_CNPJ", columnList = "cnpj", unique = true) })

public class Funcionario implements Serializable {

	@Column(length = 50)
	private String enderecoBairro;
	@Column(length = 50)
	private String cargo;
	@Column(length = 50)
	private String categoria;
	@ManyToOne(cascade = CascadeType.ALL)
	private CentroCusto centroCusto;
	@Column(length = 10)
	private String enderecoCep;
	@Column(length = 50)
	private String enderecoCidade;
	@Column(length = 3)
	private String cnhCategoria;
	@Column(length = 19, nullable = true)
	private String cnpj;
	@Column(length = 20)
	private String enderecoComplemento;
	@Column(length = 50)
	private String conjuge;
	@Column(length = 14, nullable = true)
	private String cpf;
	@Column(length = 19)
	private String ctpsNumero;
	@Column(length = 22)
	private String deficiencia;
	@Column(length = 50)
	private String departamento;
	@Column(length = 50)
	private String email;
	@Column(length = 50)
	private String empresa;
	@Column(length = 24)
	private String escolaridade;
	@Column(length = 50)
	private String enderecoEstado;
	@Column(length = 14)
	private String enderecoEstadoCivil;
	@Column(length = 20)
	private String fax;
	@Column(length = 2)
	private String filhos;
	@Column(length = 20)
	private String fone1;
	@Column(length = 20)
	private String fone2;
	@Column(length = 50)
	private String gerente;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private String enderecoLogradouro;
	@Column(length = 20)
	private String matricula;
	@Column(length = 34)
	private String nacionalidade;
	@Column(length = 50, nullable = false)
	private String nome;
	@Column(length = 50)
	private String pais;
	@Column(length = 20)
	private String pis;
	@Column(length = 15)
	private String rgNumero;
	@Column(length = 20)
	private String rgOrgaoEmissor;
	@Column(length = 10)
	private String salario;
	@Column(length = 9)
	private String sexo;
	@Column(length = 50)
	private String turno;

	public String getEnderecoBairro() {
		return this.enderecoBairro;
	}

	public String getCargo() {
		return this.cargo;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public CentroCusto getCentroCusto() {
		return this.centroCusto;
	}

	public String getEnderecoCep() {
		return this.enderecoCep;
	}

	public String getEnderecoCidade() {
		return this.enderecoCidade;
	}

	public String getCnhCategoria() {
		return this.cnhCategoria;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public String getEnderecoComplemento() {
		return this.enderecoComplemento;
	}

	public String getConjuge() {
		return this.conjuge;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getCtpsNumero() {
		return this.ctpsNumero;
	}

	public String getDeficiencia() {
		return deficiencia;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public String getEmail() {
		return this.email;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public String getEnderecoEstado() {
		return this.enderecoEstado;
	}

	public String getEnderecoEstadoCivil() {
		return this.enderecoEstadoCivil;
	}

	public String getFax() {
		return this.fax;
	}

	public String getFilhos() {
		return this.filhos;
	}

	public String getFone1() {
		return this.fone1;
	}

	public String getFone2() {
		return this.fone2;
	}

	public String getGerente() {
		return this.gerente;
	}

	public Long getId() {
		return this.id;
	}

	public String getEnderecoLogradouro() {
		return this.enderecoLogradouro;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public String getNome() {
		return this.nome;
	}

	public String getPais() {
		return this.pais;
	}

	public String getPis() {
		return this.pis;
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

	public String getTurno() {
		return this.turno;
	}

	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setCentroDeCusto(CentroCusto centroDeCusto) {
		this.centroCusto = centroDeCusto;
	}

	public void setEnderecoCep(String enderecoCep) {
		this.enderecoCep = enderecoCep;
	}

	public void setEnderecoCidade(String enderecoCidade) {
		this.enderecoCidade = enderecoCidade;
	}

	public void setCnhCategoria(String cnhCategoria) {
		this.cnhCategoria = cnhCategoria;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
	}

	public void setConjuge(String conjuge) {
		this.conjuge = conjuge;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setCtpsNumero(String ctpsNumero) {
		this.ctpsNumero = ctpsNumero;
	}

	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public void setEnderecoEstado(String enderecoEstado) {
		this.enderecoEstado = enderecoEstado;
	}

	public void setEnderecoEstadoCivil(String enderecoEstadoCivil) {
		this.enderecoEstadoCivil = enderecoEstadoCivil;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setFilhos(String filhos) {
		this.filhos = filhos;
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEnderecoLogradouro(String enderecoLogradouro) {
		this.enderecoLogradouro = enderecoLogradouro;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setPis(String pis) {
		this.pis = pis;
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

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.id;
	}
}
