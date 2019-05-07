package erp.curriculo.idioma;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;

import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
public class Idioma implements Serializable {
	@ManyToOne(cascade = CascadeType.ALL)
	private Funcionario funcionario;
	@Id
	private Long id;
	@Column(length = 50)
	private String idioma;
	@Column(length = 50)
	private String nivelConhecimento;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Long getId() {
		return id;
	}

	public String getIdioma() {
		return idioma;
	}

	public String getNivelConhecimento() {
		return nivelConhecimento;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public void setNivelConhecimento(String nivelConhecimento) {
		this.nivelConhecimento = nivelConhecimento;
	}
}
