package erp.curriculo.testepersonalidade.c;

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
@Table(indexes = { @Index(name = "INDEX_TESTE_C_FUNCIONARIO", columnList = "funcionario_id", unique = true) })
public class TesteC implements Serializable {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "funcionario_id", referencedColumnName = "id")
	private Funcionario funcionario;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer totalOpcaoC;
	private Integer totalOpcaoD;
	private Integer totalOpcaoI;
	private Integer totalOpcaoS;

	public TesteC() {
		this.totalOpcaoD = 0;
		this.totalOpcaoI = 0;
		this.totalOpcaoS = 0;
		this.totalOpcaoC = 0;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Long getId() {
		return id;
	}

	public Integer getTotalOpcaoC() {
		return totalOpcaoC;
	}

	public Integer getTotalOpcaoD() {
		return totalOpcaoD;
	}

	public Integer getTotalOpcaoI() {
		return totalOpcaoI;
	}

	public Integer getTotalOpcaoS() {
		return totalOpcaoS;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setTotalOpcaoI() {
		if (this.totalOpcaoI == null) {
			this.totalOpcaoI = 1;
		} else {
			this.totalOpcaoI++;
		}
	}

	public void setTotalOpcaoS() {
		if (this.totalOpcaoS == null) {
			this.totalOpcaoS = 1;
		} else {
			this.totalOpcaoS++;
		}
	}
}
