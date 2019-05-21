package erp.veiculo.modelo;

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
@Table(indexes = { @Index(name = "INDEX_VEICULO_MODELO_MODELO", columnList = "modelo", unique = true)})
public class VeiculoModelo implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 50, nullable = false)
	private String modelo;

	public Long getId() {
		return id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
		;
	}

	@Override
	public String toString() {
		return modelo;
	}
}
