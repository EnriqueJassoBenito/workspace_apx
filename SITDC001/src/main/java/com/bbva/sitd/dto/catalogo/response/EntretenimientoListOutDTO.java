package com.bbva.sitd.dto.catalogo.response;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.bbva.sitd.dto.catalogo.EntretenimientoDTO;
import com.bbva.sitd.dto.catalogo.pagination.PaginationOutDTO;

public class EntretenimientoListOutDTO implements Serializable {
	private static final long serialVersionUID = -3947681498438212093L;
	
	private List<EntretenimientoDTO> tipoContenido;
    private PaginationOutDTO paginationOut;
	public List<EntretenimientoDTO> getTipoContenido() {
		return tipoContenido;
	}
	public void setTipoContenido(List<EntretenimientoDTO> tipoContenido) {
		this.tipoContenido = tipoContenido;
	}
	public PaginationOutDTO getPaginationOut() {
		return paginationOut;
	}
	public void setPaginationOut(PaginationOutDTO paginationOut) {
		this.paginationOut = paginationOut;
	}
	@Override
	public int hashCode() {
		return Objects.hash(paginationOut, tipoContenido);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntretenimientoListOutDTO other = (EntretenimientoListOutDTO) obj;
		return Objects.equals(paginationOut, other.paginationOut) && Objects.equals(tipoContenido, other.tipoContenido);
	}

    
}
