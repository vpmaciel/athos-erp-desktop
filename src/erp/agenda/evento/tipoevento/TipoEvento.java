package erp.agenda.evento.tipoevento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import erp.agenda.evento.Evento;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
public class TipoEvento implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 50)
	private String nome;

	public Long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return this.nome;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Evento)) {
			return false;
		}
		if (((TipoEvento) object).getId() == this.id) {
			return true;
		}
		return false;
	}
}
