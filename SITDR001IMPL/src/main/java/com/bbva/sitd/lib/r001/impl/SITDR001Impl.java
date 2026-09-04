package com.bbva.sitd.lib.r001.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.sitd.dto.catalogo.EntretenimientoDTO;
import com.bbva.sitd.dto.catalogo.pagination.PaginationInDTO;
import com.bbva.sitd.dto.catalogo.pagination.PaginationOutDTO;
import com.bbva.sitd.dto.catalogo.pagination.ReferencesDTO;
import com.bbva.sitd.dto.catalogo.response.EntretenimientoListOutDTO;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The SITDR001Impl class...
 */
public class SITDR001Impl extends SITDR001Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(SITDR001Impl.class);
	private static final String INSERT_ENTRETENIMIENTO="insert_entretenimiento";
	private static final String SELECT_CONTENIDO = "select_contenido";
	private static final String SELECT_CONTENIDO_COUNT = "select_contenido_count";


	@Override
	public void execute(EntretenimientoDTO entretenimiento) {
		// TODO Auto-generated method stub

		LOGGER.info("@@ Que llego de la trx: {}",entretenimiento.toString());
		
		Map<String,Object> arg = new HashMap<>();
		
		arg.put("inTITULO", entretenimiento.getTitulo());
		arg.put("inTIPO", entretenimiento.getTipo());
		arg.put("inGENERO", entretenimiento.getGenero());
		arg.put("inANIO_ESTRENO", entretenimiento.getAnioEstreno());
		arg.put("inDIRECTOR", entretenimiento.getDirector());
		arg.put("inDURACION_MIN", entretenimiento.getDuracionMin());
		arg.put("inPAIS_ORIGEN", entretenimiento.getPaisOrigen());
		arg.put("inCLASIFICACION", entretenimiento.getClasificacion());
		arg.put("inIDIOMA_ORIGINAL", entretenimiento.getIdiomaOriginal());
		arg.put("inPLATAFORMA", entretenimiento.getPlataforma());
		arg.put("inCALIFICACION", entretenimiento.getCalificacion());
		arg.put("inDISPONIBLE", entretenimiento.getDisponible());
		arg.put("inFECHA_REGISTRO", entretenimiento.getFechaRegistro());
				
	   //this.addAdvice("SITD00000201");
		
		try {
			
			int response = this.jdbcUtils.update(INSERT_ENTRETENIMIENTO, arg);
			if(response == 1) {
				this.addAdvice("SITD00000200");
			}
			LOGGER.info("@@@@@ response {}",response);
			
		}catch(com.bbva.apx.exception.db.DuplicateKeyException E) {
			 this.addAdvice("SITD00000409");
			LOGGER.info("@@@@@ DuplicateKeyException");
			
		}
		
		
	}


	@Override
	public EntretenimientoListOutDTO executeListEntretenimiento(EntretenimientoDTO entretenimiento,	PaginationInDTO paginationInDto) {
		
        Map<String,Object> arg = new HashMap<>();
		
		arg.put("inTITULO", entretenimiento.getTitulo());
		arg.put("inTIPO", entretenimiento.getTipo());
		arg.put("inGENERO", entretenimiento.getGenero());
		arg.put("inANIO_ESTRENO", entretenimiento.getAnioEstreno());
		arg.put("inDIRECTOR", entretenimiento.getDirector());
		arg.put("inDURACION_MIN", entretenimiento.getDuracionMin());
		arg.put("inPAIS_ORIGEN", entretenimiento.getPaisOrigen());
		arg.put("inCLASIFICACION", entretenimiento.getClasificacion());
		arg.put("inIDIOMA_ORIGINAL", entretenimiento.getIdiomaOriginal());
		arg.put("inPLATAFORMA", entretenimiento.getPlataforma());
		arg.put("inCALIFICACION", entretenimiento.getCalificacion());
		arg.put("inDISPONIBLE", entretenimiento.getDisponible());
		arg.put("inFECHA_REGISTRO", entretenimiento.getFechaRegistro());
		
		
		EntretenimientoListOutDTO responseListoutDTO = new EntretenimientoListOutDTO();
		long initialRow = (paginationInDto.getPaginationKey()==1L?paginationInDto.getPaginationKey():paginationInDto.getPageSize()*(paginationInDto.getPaginationKey()-1L)+1L);
       
		LOGGER.info("@@@@@ Donde inicia la consulta {} ",initialRow); 
		
		List<Map<String, Object>> result = this.jdbcUtils.pagingQueryForList(SELECT_CONTENIDO, (int)initialRow, (int)paginationInDto.getPageSize(), arg);
		
		LOGGER.info("@@@@@ Resultado de la consulta {} ",result.toString());
		
		 List<EntretenimientoDTO> listTipoContenido = new ArrayList<>();
		for(Map<String, Object> row: result) {
			LOGGER.info("@@@@@ Registro ::: {} ",row.toString());
			EntretenimientoDTO entretenimientoDTO = new EntretenimientoDTO();
			entretenimientoDTO.setId(row.get("ID_CONTENIDO").toString());
			entretenimientoDTO.setTitulo(row.get("TITULO").toString());
			entretenimientoDTO.setTipo(row.get("TIPO").toString());
			entretenimientoDTO.setGenero(row.get("GENERO").toString());
			entretenimientoDTO.setAnioEstreno(null);
			entretenimientoDTO.setDirector(row.get("DIRECTOR").toString());
			entretenimientoDTO.setDuracionMin(null);
			entretenimientoDTO.setPaisOrigen(row.get("PAIS_ORIGEN").toString());
			entretenimientoDTO.setClasificacion(row.get("CLASIFICACION").toString());
			entretenimientoDTO.setIdiomaOriginal(row.get("IDIOMA_ORIGINAL").toString());
			entretenimientoDTO.setPlataforma(row.get("PLATAFORMA").toString());
			entretenimientoDTO.setCalificacion(null);
			entretenimientoDTO.setDisponible(row.get("DISPONIBLE").toString());
			//entretenimientoDTO.setFechaRegistro();
			
			listTipoContenido.add(entretenimiento);
		}
		
                //SITDR001(libreria orquestadora0)--> AMAZR001 --->AMAZR002--->
		
		int totalREgistros = this.jdbcUtils.queryForInt(SELECT_CONTENIDO_COUNT, arg);
		
		LOGGER.info("@@@@@ Cuantos registros son {} ",totalREgistros);
		
		
		//Seteando respuesta
		responseListoutDTO.setTipoContenido(listTipoContenido);
		
		//armar la paginación
		PaginationOutDTO paginationOut = new PaginationOutDTO();
		paginationOut.setPage(1L);
		paginationOut.setPageSize(10L);
		paginationOut.setTotalElements(10L);
		paginationOut.setTotalPages(10L);
		
		ReferencesDTO referencesDTO = new ReferencesDTO();
		referencesDTO.setLastPage("100");
		referencesDTO.setNextPage("2");
		referencesDTO.setPreviousPage("1");
		paginationOut.setReferences(referencesDTO);
		
		responseListoutDTO.setPaginationOut(paginationOut);
	 
		return responseListoutDTO;
	}
}
