package erp.curriculo.idioma;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;

import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
public class Idioma implements Serializable {
	@Column(length = 50)
	private String conhecimento;
	@ManyToOne(cascade = CascadeType.ALL)
	private Funcionario funcionario;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private String nivelConhecimento;

	public String getConhecimento() {
		return conhecimento;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Long getId() {
		return id;
	}

	public String getNivelConhecimento() {
		return nivelConhecimento;
	}

	public void setConhecimento(String conhecimento) {
		this.conhecimento = conhecimento;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNivelConhecimento(String nivelConhecimento) {
		this.nivelConhecimento = nivelConhecimento;
	}
}
