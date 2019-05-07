package erp.agenda.recado;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
public class Recado implements Serializable {
	@Column(length = 10)
	private String data;
	@Column(length = 50)
	private String destinatario;
	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 500)
	private String recado;
	@Column(length = 50)
	private String remetente;

	public String getData() {
		return data;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public Long getId() {
		return id;
	}

	public String getRecado() {
		return recado;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRecado(String recado) {
		this.recado = recado;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	@Override
	public String toString() {
		return this.data;
	}
}