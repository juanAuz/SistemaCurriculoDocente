package modelo.experiencia;

import java.time.LocalDate;

public abstract class Experiencia {
	private String institucion;
	private LocalDate fechaDesde;
	private LocalDate fechaHasta;
	
	public Experiencia(String institucion, LocalDate fechaDesde, LocalDate fechaHasta) {
		super();
		this.institucion = institucion;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public LocalDate getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(LocalDate fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public LocalDate getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(LocalDate fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	
	public boolean estaVigente() {
	    return fechaHasta == null;
	}

	public int getDuracionAnios() {
	    return fechaHasta.getYear() - fechaDesde.getYear();
	}

	
	
	
}
