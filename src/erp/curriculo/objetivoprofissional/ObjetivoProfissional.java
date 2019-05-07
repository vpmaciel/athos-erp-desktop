package erp.curriculo.objetivoprofissional;

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
public class ObjetivoProfissional implements Serializable {

	@Column(length = 50)
	private String areaInteresse;
	@Column(length = 50)
	private String cargo;
	@Column(length = 50)
	private String contrato;
	@ManyToOne(cascade = CascadeType.ALL)
	private Funcionario funcionario;
	@Id
	private Long id;
	@Column(length = 50)
	private String nivelHierarquico;
	@Column(length = 50)
	private String pretensaoSalarial;

	public String getAreaInteresse() {
		return areaInteresse;
	}

	public String getCargo() {
		return cargo;
	}

	public String getContrato() {
		return contrato;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Long getId() {
		return id;
	}

	public String getNivelHierarquico() {
		return nivelHierarquico;
	}

	public String getPretensaoSalarial() {
		return pretensaoSalarial;
	}

	public void setAreaInteresse(String areaInteresse) {
		this.areaInteresse = areaInteresse;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNivelHierarquico(String nivelHierarquico) {
		this.nivelHierarquico = nivelHierarquico;
	}

	public void setPretensaoSalarial(String pretensaoSalarial) {
		this.pretensaoSalarial = pretensaoSalarial;
	}

}
