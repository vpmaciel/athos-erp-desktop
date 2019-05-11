package erp.banco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

import erp.usuario.Usuario;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
@Table(indexes = { @Index(name = "INDEX_NOME", columnList = "nome", unique = true),
		@Index(name = "INDEX_CODIGO", columnList = "codigo", unique = true) })
public class Banco implements Serializable {

	@Column(length = 10, nullable = true)
	private String codigo;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50, nullable = false)
	private String nome;
	private Usuario usuarioOperacao;

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
		this.codigo = codigo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuarioOperacao() {
		return usuarioOperacao;
	}

	public void setUsuarioOperacao(Usuario usuarioOperacao) {
		this.usuarioOperacao = usuarioOperacao;
	}

	@Override
	public String toString() {
		return this.nome;
	}
}
