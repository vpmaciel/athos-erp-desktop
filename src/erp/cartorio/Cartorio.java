package erp.cartorio;

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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "nomeFantasia", "razaoSocial", "cnpj" }) })
public class Cartorio implements Serializable {

	@Column(length = 50)
	private String bairro;
	@Column(length = 10)
	private String cep;
	@Column(length = 50)
	private String cidade;
	@Column(length = 19)
	private String cnpj;
	@Column(length = 50)
	private String comarca;
	@Column(length = 20)
	private String complemento;
	@Column(length = 50)
	private String distrito;
	@Column(length = 50)
	private String email;
	@Column(length = 50)
	private String estado;
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
	private String logradouro;
	@Column(length = 50)
	private String municipio;
	@Column(length = 50, nullable = false)
	private String nomeFantasia;
	@Column(length = 50)
	private String pais;
	@Column(length = 50)
	private String razaoSocial;
	@Column(length = 50)
	private String site;
	@Column(length = 50)
	private String substituto;
	@Column(length = 50)
	private String titular;

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

	public String getComarca() {
		return this.comarca;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public String getDistrito() {
		return this.distrito;
	}

	public String getEmail() {
		return this.email;
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

	public String getMunicipio() {
		return this.municipio;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public String getPais() {
		return this.pais;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public String getSite() {
		return this.site;
	}

	public String getSubstituto() {
		return this.substituto;
	}

	public String getTitular() {
		return this.titular;
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

	public void setComarca(String comarca) {
		this.comarca = comarca;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public void setSubstituto(String substituto) {
		this.substituto = substituto;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	@Override
	public String toString() {
		return this.nomeFantasia;
	}
}
