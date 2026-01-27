package modelo.experiencia;

import java.time.LocalDate;


public class ExperienciaDocente extends Experiencia {
	private String catedra;
	public ExperienciaDocente(String institucion, LocalDate fechaDesde, LocalDate fechaHasta, String catedra) {
		super(institucion, fechaDesde, fechaHasta);
		this.catedra = catedra;
		
	}
	public String getCatedra() {
		return catedra;
	}
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}

	

	
	
}
