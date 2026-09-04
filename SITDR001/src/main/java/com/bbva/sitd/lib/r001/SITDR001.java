package com.bbva.sitd.lib.r001;

import com.bbva.sitd.dto.catalogo.EntretenimientoDTO;
import com.bbva.sitd.dto.catalogo.pagination.PaginationInDTO;
import com.bbva.sitd.dto.catalogo.response.EntretenimientoListOutDTO;

/**
 * The  interface SITDR001 class...
 */
public interface SITDR001 {

	/**
	 * The execute method...
	 */
	void execute(EntretenimientoDTO entretenimiento);
	EntretenimientoListOutDTO executeListEntretenimiento(EntretenimientoDTO entretenimiento, PaginationInDTO paginationInDto);
	

}
