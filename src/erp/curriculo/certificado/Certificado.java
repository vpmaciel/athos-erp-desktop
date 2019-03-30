package erp.curriculo.certificado;

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
public class Certificado implements Serializable{
	@Id
	private Long id;
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, optional = true)
	private Funcionario funcionario;
	@Column(length = 50)
	private String instituicao;
	@Column(length = 50)
	private String curso;
	private float cargaHoraria;
	@Column(length = 4)
	private String anoConclusao;
	
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
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public float getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(float cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public String getAnoConclusao() {
		return anoConclusao;
	}
	public void setAnoConclusao(String anoConclusao) {
		this.anoConclusao = anoConclusao;
	}
}
