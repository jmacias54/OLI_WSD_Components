/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.components.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import mx.com.amx.unotv.oli.wsd.components.controller.exception.ControllerException;
import mx.com.amx.unotv.oli.wsd.components.dao.NNotaDAO;
import mx.com.amx.unotv.oli.wsd.components.response.NNotaResponse;

/**
 * @author Jesus A. Macias Benitez
 *
 */

@Controller
@RequestMapping("nNota")
public class NNotaController {
	private static Logger logger = Logger.getLogger(NNotaController.class);

	@Autowired
	NNotaDAO nNotaDAO;

	
	
	@RequestMapping(value = "/lastNotesNotInINotaMagazine/{limit}", method = RequestMethod.POST)
	@ResponseBody
	public NNotaResponse lastNotesNotInINotaMagazine(@PathVariable int limit) throws ControllerException {
		logger.debug(" --- lastNotesNotInINotaMagazine  [ NNotaController ]  --- ");
		logger.debug(" ---  limit : "+limit+"  --- ");
		
		
		NNotaResponse response = null;
		
		try {
			
			response = new NNotaResponse();
			response.setLista(nNotaDAO.lastNotesNotInINotaMagazine(limit));
			return response;

		} catch (Exception e) {
			logger.error(" ¡ Error lastNotesNotInINotaMagazine  [ NNotaController ] ! ", e);
			throw new ControllerException(e.getMessage());
		}
	}
	
	
	@RequestMapping(value = "/lastNotesFindByIdCategoriaLimit/{idCategoria}/{limit}", method = RequestMethod.POST)
	@ResponseBody
	public NNotaResponse lastNotesFindByIdCategoriaLimit(@PathVariable String idCategoria , @PathVariable int limit) throws ControllerException {
		logger.debug(" --- lastNotesFindByIdCategoriaLimit  [ NNotaController ]  --- ");
		logger.debug(" ---  idCategoria : "+idCategoria+"  --- ");
		logger.debug(" ---  limit : "+limit+"  --- ");
		
		
		NNotaResponse response = null;
		
		try {
			
			response = new NNotaResponse();
			response.setLista(nNotaDAO.lastNotesFindByIdCategoriaLimit(idCategoria,limit));
			return response;

		} catch (Exception e) {
			logger.error(" ¡ Error lastNotesFindByIdCategoriaLimit  [ NNotaController ] ! ", e);
			throw new ControllerException(e.getMessage());
		}
	}
}
