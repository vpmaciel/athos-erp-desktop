package erp.contador;

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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "crc", "cpf", "cnpj" }) })
public class Contador implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length = 19)
	private String cnpj;
	@Column(length = 14)
	private String cpf;
	@Column(length = 20)
	private String crc;
	@Column(length = 50)
	private String email;
	@Column(length = 50, nullable = false)
	private String nome;
	@Column(length = 20)
	private String fax;
	@Column(length = 20)
	private String fone1;
	@Column(length = 20)
	private String fone2;
	@Column(length = 50)
	private String site;

	public String getCnpj() {
		return this.cnpj;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getCrc() {
		return this.crc;
	}

	public String getEmail() {
		return this.email;
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

	public String getNome() {
		return this.nome;
	}

	public String getSite() {
		return this.site;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setCrc(String crc) {
		this.crc = crc;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return this.nome;
	}
}
