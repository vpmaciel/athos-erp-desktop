package erp.curriculo.certificado;

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
public class Certificado implements Serializable {

	@Column(length = 4)
	private String anoConclusao;
	private double cargaHoraria;
	@Column(length = 50)
	private String curso;
	@ManyToOne(cascade = CascadeType.ALL)
	private Funcionario funcionario;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private String instituicao;

	public String getAnoConclusao() {
		return anoConclusao;
	}

	public double getCargaHoraria() {
		return cargaHoraria;
	}

	public String getCurso() {
		return curso;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Long getId() {
		return id;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setAnoConclusao(String anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
}
