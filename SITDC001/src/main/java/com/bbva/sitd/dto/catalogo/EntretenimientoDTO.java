package com.bbva.sitd.dto.catalogo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The ExampleDTO class...
 */
public class EntretenimientoDTO implements Serializable  {
	private static final long serialVersionUID = 2931699728946643245L;
	private String id;
	private String titulo;
	private String tipo;
	private String genero;
	private Integer anioEstreno;
	private String director;
	private Integer duracionMin;
	private String paisOrigen;
	private String clasificacion;
	private String idiomaOriginal;
	private String plataforma;
	private BigDecimal calificacion;
	private String disponible;
	private Date fechaRegistro;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Integer getAnioEstreno() {
		return anioEstreno;
	}
	public void setAnioEstreno(Integer anioEstreno) {
		this.anioEstreno = anioEstreno;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Integer getDuracionMin() {
		return duracionMin;
	}
	public void setDuracionMin(Integer duracionMin) {
		this.duracionMin = duracionMin;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getIdiomaOriginal() {
		return idiomaOriginal;
	}
	public void setIdiomaOriginal(String idiomaOriginal) {
		this.idiomaOriginal = idiomaOriginal;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public BigDecimal getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(BigDecimal calificacion) {
		this.calificacion = calificacion;
	}
	public String getDisponible() {
		return disponible;
	}
	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	@Override
	public int hashCode() {
		return Objects.hash(anioEstreno, calificacion, clasificacion, director, disponible, duracionMin, fechaRegistro,
				genero, id, idiomaOriginal, paisOrigen, plataforma, tipo, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntretenimientoDTO other = (EntretenimientoDTO) obj;
		return Objects.equals(anioEstreno, other.anioEstreno) && Objects.equals(calificacion, other.calificacion)
				&& Objects.equals(clasificacion, other.clasificacion) && Objects.equals(director, other.director)
				&& Objects.equals(disponible, other.disponible) && Objects.equals(duracionMin, other.duracionMin)
				&& Objects.equals(fechaRegistro, other.fechaRegistro) && Objects.equals(genero, other.genero)
				&& Objects.equals(id, other.id) && Objects.equals(idiomaOriginal, other.idiomaOriginal)
				&& Objects.equals(paisOrigen, other.paisOrigen) && Objects.equals(plataforma, other.plataforma)
				&& Objects.equals(tipo, other.tipo) && Objects.equals(titulo, other.titulo);
	}
	@Override
	public String toString() {
		return "EntretenimientoDTO [id=" + id + ", titulo=" + titulo + ", tipo=" + tipo + ", genero=" + genero
				+ ", anioEstreno=" + anioEstreno + ", director=" + director + ", duracionMin=" + duracionMin
				+ ", paisOrigen=" + paisOrigen + ", clasificacion=" + clasificacion + ", idiomaOriginal="
				+ idiomaOriginal + ", plataforma=" + plataforma + ", calificacion=" + calificacion + ", disponible="
				+ disponible + ", fechaRegistro=" + fechaRegistro + "]";
	}
	

	

}
