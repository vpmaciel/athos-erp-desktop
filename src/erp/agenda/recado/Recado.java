package erp.agenda.recado;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;

import erp.empresa.Empresa;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
public class Recado implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 19)
	private String cnpj;
	@Column(length = 14)
	private String cpfNumero;
	@Column(length = 15)
	private String email;
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Empresa empresa;
	@Column(length = 16)
	private String fax;
	@Column(length = 16)
	private String fone1;
	@Column(length = 16)
	private String fone2;
	@Column(length = 50)
	private String nome;
	@Column(length = 15)
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
	@Column(length = 50)
	private String logradouro;
	@Column(length = 50)
	private String complemento;
	@Column(length = 15)
	private String cep;

	public String getBairro() {
		return this.bairro;
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

	public String getCpfNumero() {
		return this.cpfNumero;
	}

	public String getEmail() {
		return this.email;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public String getEstado() {
		return this.estado;
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

	public String getLogradouro() {
		return this.logradouro;
	}

	public String getNome() {
		return this.nome;
	}

	public String getPais() {
		return this.pais;
	}

	public String getSalario() {
		return this.salario;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public void setCpfNumero(String cpfNumero) {
		this.cpfNumero = cpfNumero;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return this.nome;
	}
}
