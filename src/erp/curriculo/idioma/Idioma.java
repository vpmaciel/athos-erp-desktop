package erp.curriculo.idioma;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;

import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
public class Idioma implements Serializable {
	@Id
	private Long id;
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, optional = true)
	private Funcionario funcionario;
	@Column(length = 50)
	private String idioma;
	@Column(length = 50)
	private String nivelConhecimento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getNivelConhecimento() {
		return nivelConhecimento;
	}
	public void setNivelConhecimento(String nivelConhecimento) {
		this.nivelConhecimento = nivelConhecimento;
	}
}
