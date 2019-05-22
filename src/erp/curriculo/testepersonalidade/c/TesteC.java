package erp.curriculo.testepersonalidade.c;

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
public class TesteC implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	private Funcionario funcionario;
	private Integer totalOpcaoD;
	private Integer totalOpcaoI;
	private Integer totalOpcaoS;
	private Integer totalOpcaoC;

	public TesteC() {
		this.totalOpcaoD = 0;
		this.totalOpcaoI = 0;
		this.totalOpcaoS = 0;
		this.totalOpcaoC = 0;
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

	public Integer getTotalOpcaoI() {
		return totalOpcaoI;
	}

	public void setTotalOpcaoI() {
		if (this.totalOpcaoI == null) {
			this.totalOpcaoI = 1;
		} else {
			this.totalOpcaoI++;
		}
	}

	public Integer getTotalOpcaoS() {
		return totalOpcaoS;
	}

	public void setTotalOpcaoS() {
		if (this.totalOpcaoS == null) {
			this.totalOpcaoS = 1;
		} else {
			this.totalOpcaoS++;
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

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
