package erp.banco;

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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
public class Banco implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length = 10)
	private String codigo;
	@Column(length = 50, nullable = false)
	private String nome;

	public String getCodigo() {
		return this.codigo;
	}

	public Long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo.replaceAll("\\s+", " ").trim();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome.replaceAll("\\s+", " ").trim();
	}

	@Override
	public String toString() {
		return this.nome;
	}
}