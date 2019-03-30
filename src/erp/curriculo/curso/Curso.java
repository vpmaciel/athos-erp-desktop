package erp.curriculo.curso;

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
public class Curso implements Serializable {
	@Id
	private Long id;
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, optional = true)
	private Funcionario funcionario;
	@Column(length = 50)
	private String instituicao;
	@Column(length = 50)
	private String curso;
	@Column(length = 4)
	private String anoInicio;
	@Column(length = 4)
	private String anoConclusao;
	@Column(length = 50)
	private String situacao;
	@Column(length = 50)
	private String modalidade;
	@Column(length = 50)
	private String nivel;
	
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
	public String getAnoInicio() {
		return anoInicio;
	}
	public void setAnoInicio(String anoInicio) {
		this.anoInicio = anoInicio;
	}
	public String getAnoConclusao() {
		return anoConclusao;
	}
	public void setAnoConclusao(String anoConclusao) {
		this.anoConclusao = anoConclusao;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
}
