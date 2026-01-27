package modelo.experiencia;

import java.time.LocalDate;

public class ExperienciaNoDocente extends Experiencia {
	private String funcion; 
	
	public ExperienciaNoDocente(String institucion, LocalDate fechaDesde, LocalDate fechaHasta, String funcion) {
		super(institucion, fechaDesde, fechaHasta);
		this.funcion = funcion;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}


	
}
