package erp.curriculo.curso;

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
public class Curso implements Serializable {

	@Column(length = 4)
	private String anoConclusao;
	@Column(length = 4)
	private String anoInicio;
	@ManyToOne(cascade = CascadeType.ALL)
	private Funcionario funcionario;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private String instituicao;
	@Column(length = 50)
	private String modalidade;
	@Column(length = 50)
	private String nivel;
	@Column(length = 50)
	private String nome;
	@Column(length = 50)
	private String situacao;

	public String getAnoConclusao() {
		return anoConclusao;
	}

	public String getAnoInicio() {
		return anoInicio;
	}

	public String getCurso() {
		return nome;
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

	public String getModalidade() {
		return modalidade;
	}

	public String getNivel() {
		return nivel;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setAnoConclusao(String anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	public void setAnoInicio(String anoInicio) {
		this.anoInicio = anoInicio;
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

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}
