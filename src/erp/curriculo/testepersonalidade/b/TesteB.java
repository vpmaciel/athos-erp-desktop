package erp.curriculo.testepersonalidade.b;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
@Table(indexes = { @Index(name = "INDEX_TESTE_B_FUNCIONARIO", columnList = "funcionario_id", unique = true) })
public class TesteB implements Serializable {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "funcionario_id", referencedColumnName = "id")
	private Funcionario funcionario;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Long getId() {
		return id;
	}

	public Integer getTotalOpcaoA() {
		return totalOpcaoA;
	}

	public Integer getTotalOpcaoB() {
		return totalOpcaoB;
	}

	public Integer getTotalOpcaoC() {
		return totalOpcaoC;
	}

	public Integer getTotalOpcaoD() {
		return totalOpcaoD;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTotalOpcaoA() {
		if (this.totalOpcaoA == null) {
			this.totalOpcaoA = 1;
		} else {
			this.totalOpcaoA++;
		}
	}

	public void setTotalOpcaoB() {
		if (this.totalOpcaoB == null) {
			this.totalOpcaoB = 1;
		} else {
			this.totalOpcaoB++;
		}
	}

	public void setTotalOpcaoC() {
		if (this.totalOpcaoC == null) {
			this.totalOpcaoC = 1;
		} else {
			this.totalOpcaoC++;
		}
	}

	public void setTotalOpcaoD() {
		if (this.totalOpcaoD == null) {
			this.totalOpcaoD = 1;
		} else {
			this.totalOpcaoD++;
		}
	}
}
