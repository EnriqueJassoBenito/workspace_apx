package com.bbva.sitd;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.sitd.dto.catalogo.EntretenimientoDTO;
import com.bbva.sitd.dto.catalogo.pagination.PaginationInDTO;
import com.bbva.sitd.dto.catalogo.response.EntretenimientoListOutDTO;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractSITDT00201MXTransaction extends AbstractTransaction {

	public AbstractSITDT00201MXTransaction(){
	}


	/**
	 * Return value for input parameter tipoContenido
	 */
	protected EntretenimientoDTO getTipocontenido(){
		return (EntretenimientoDTO)this.getParameter("tipoContenido");
	}

	/**
	 * Return value for input parameter paginationIn
	 */
	protected PaginationInDTO getPaginationin(){
		return (PaginationInDTO)this.getParameter("paginationIn");
	}

	/**
	 * Set value for EntretenimientoListOutDTO output parameter entretenimientoData
	 */
	protected void setEntretenimientodata(final EntretenimientoListOutDTO field){
		this.addParameter("entretenimientoData", field);
	}
}
