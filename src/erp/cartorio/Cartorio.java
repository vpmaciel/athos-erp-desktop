package erp.cartorio;

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
@Table(indexes = { @Index(name = "INDEX_CARTORIO_CNPJ", columnList = "cnpj", unique = true) })

public class Cartorio implements Serializable {

	@Column(length = 19)
	private String cnpj;
	@Column(length = 50)
	private String comarca;
	@Column(length = 50)
	private String distrito;
	@Column(length = 50)
	private String email;
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
	@Column(length = 50)
	private String enderecoLogradouro;
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
	private String municipio;
	@Column(length = 50, nullable = false)
	private String nomeFantasia;
	@Column(length = 50)
	private String enderecoPais;
	@Column(length = 50)
	private String razaoSocial;
	@Column(length = 50)
	private String site;
	@Column(length = 50)
	private String substituto;
	@Column(length = 50)
	private String titular;

	public String getCnpj() {
		return this.cnpj;
	}

	public String getComarca() {
		return this.comarca;
	}

	public String getDistrito() {
		return this.distrito;
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

	public String getMunicipio() {
		return this.municipio;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public String getEnderecoPais() {
		return this.enderecoPais;
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

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setComarca(String comarca) {
		this.comarca = comarca;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
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

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public void setEnderecoPais(String enderecoPais) {
		this.enderecoPais = enderecoPais;
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
