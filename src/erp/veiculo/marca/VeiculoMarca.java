package erp.veiculo.marca;

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
@Table(indexes = { @Index(name = "INDEX_VEICULO_MARCA_MARCA", columnList = "marca", unique = true) })
public class VeiculoMarca implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50, nullable = false)
	private String marca;

	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return marca;
	}
}
