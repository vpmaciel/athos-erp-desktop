package erp.curriculo.testepersonalidade.a;

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
public class TesteA implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	private Funcionario funcionario;
	private Integer totalOpcaoA;
	private Integer totalOpcaoC;
	private Integer totalOpcaoO;
	private Integer totalOpcaoI;

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

	public Integer getTotalOpcaoO() {
		return totalOpcaoO;
	}

	public void setTotalOpcaoO() {
		if (this.totalOpcaoO == null) {
			this.totalOpcaoO = 1;
		} else {
			this.totalOpcaoO++;
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

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
