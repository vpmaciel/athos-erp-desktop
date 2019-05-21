package erp.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
@Table(indexes = { @Index(name = "INDEX_USUARIO_NOME", columnList = "nome", unique = true) })

public class Usuario implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 15)
	private String nome;
	@Column(length = 15)
	private String senha;

	public Long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return this.nome;
	}
}
