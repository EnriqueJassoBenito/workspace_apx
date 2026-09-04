package com.bbva.sitd;

import com.bbva.elara.domain.transaction.RequestHeaderParamsName;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.sitd.dto.catalogo.response.EntretenimientoListOutDTO;
import com.bbva.sitd.lib.r001.SITDR001;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Consultas paginadas del catálogo de entretenimiento
 *
 */
public class SITDT00201MXTransaction extends AbstractSITDT00201MXTransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(SITDT00201MXTransaction.class);

	/**
	 * The execute method...
	 */
	@Override
	public void execute() {
		SITDR001 sitdR001 = this.getServiceLibrary(SITDR001.class);
                
                //No mas de 9 librerias en una transaction
                //Transaccion solo puede hacer una operacion
		LOGGER.info("Inicia la transacción para consultas paginadas de tipos de contenido");
				
		LOGGER.info("Leer header AAP {} ", this.getRequestHeader().getHeaderParameter(RequestHeaderParamsName.AAP));
		 LOGGER.info("Leer header GENTUSER {} ", this.getRequestHeader().getHeaderParameter(RequestHeaderParamsName.AGENTUSER));
		LOGGER.info("Leer header USERCODE {} ", this.getRequestHeader().getHeaderParameter(RequestHeaderParamsName.USERCODE));
		
		LOGGER.info("Leer header {} ", this.getTipocontenido().toString());
		
		EntretenimientoListOutDTO tipoEtretenimiento;
		
		tipoEtretenimiento= sitdR001.executeListEntretenimiento(this.getTipocontenido(),this.getPaginationin());
		
		if(tipoEtretenimiento.getTipoContenido().isEmpty()) {
			this.setEntretenimientodata(tipoEtretenimiento);
			this.setSeverity(Severity.WARN);
			return;
		}
	
			this.setEntretenimientodata(tipoEtretenimiento);
			this.setSeverity(Severity.OK);
		
	}

}
