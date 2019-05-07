package erp.agenda.evento;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;

import erp.agenda.evento.tipoevento.TipoEvento;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
public class Evento implements Serializable {
	@Column(length = 10)
	private String data;
	@Column(length = 50)
	private String descricao;
	@Column(length = 5)
	private String horaInicio;
	@Column(length = 5)
	private String horaTermino;
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(cascade = CascadeType.ALL)
	private TipoEvento tipoEvento;

	public String getData() {
		return data;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public String getHoraTermino() {
		return horaTermino;
	}

	public Long getId() {
		return id;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public void setHoraTermino(String horaTermino) {
		this.horaTermino = horaTermino;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	@Override
	public String toString() {
		return this.descricao;
	}
}
