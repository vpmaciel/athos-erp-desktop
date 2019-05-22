package erp.curriculo.testepersonalidade.b;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;

import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
public class TesteB implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	private Funcionario funcionario;
	private Integer totalOpcaoA;
	private Integer totalOpcaoB;
	private Integer totalOpcaoC;
	private Integer totalOpcaoD;

	public TesteB() {
		this.totalOpcaoA = 0;
		this.totalOpcaoB = 0;
		this.totalOpcaoC = 0;
		this.totalOpcaoD = 0;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Integer getTotalOpcaoA() {
		return totalOpcaoA;
	}

	public void setTotalOpcaoA() {
		if (this.totalOpcaoA == null) {
			this.totalOpcaoA = 1;
		} else {
			this.totalOpcaoA++;
		}
	}

	public Integer getTotalOpcaoB() {
		return totalOpcaoB;
	}

	public void setTotalOpcaoB() {
		if (this.totalOpcaoB == null) {
			this.totalOpcaoB = 1;
		} else {
			this.totalOpcaoB++;
		}
	}

	public Integer getTotalOpcaoC() {
		return totalOpcaoC;
	}

	public void setTotalOpcaoC() {
		if (this.totalOpcaoC == null) {
			this.totalOpcaoC = 1;
		} else {
			this.totalOpcaoC++;
		}
	}

	public Integer getTotalOpcaoD() {
		return totalOpcaoD;
	}

	public void setTotalOpcaoD() {
		if (this.totalOpcaoD == null) {
			this.totalOpcaoD = 1;
		} else {
			this.totalOpcaoD++;
		}
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
