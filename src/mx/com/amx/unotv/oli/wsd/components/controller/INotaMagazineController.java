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
import mx.com.amx.unotv.oli.wsd.components.dao.INotaMagazineDAO;
import mx.com.amx.unotv.oli.wsd.components.response.INotaMagazineResponse;

/**
 * @author Jesus A. Macias Benitez
 *
 */
@Controller
@RequestMapping("iNotaMagazine")
public class INotaMagazineController {
	private static Logger logger = Logger.getLogger(INotaMagazineController.class);

	
	@Autowired
	INotaMagazineDAO iNotaMagazineDAO;
	
	@RequestMapping(value = "/findByIdMagazine/{idMagazine}", method = RequestMethod.POST)
	@ResponseBody
	public INotaMagazineResponse findByIdMagazine(@PathVariable String idMagazine) throws ControllerException {
		logger.debug(" --- findByIdMagazine  [ INotaMagazineController ]  --- ");
		logger.debug(" ---  IdMagazine : "+idMagazine+"  --- ");
		
		
		INotaMagazineResponse response = null;
		
		try {
			response = new INotaMagazineResponse();
			response.setLista(iNotaMagazineDAO.findByIdMagazine(idMagazine));
			return response;
			
		}catch (Exception e) {
			logger.error(" ¡ Error findByIdMagazine  [ INotaMagazineController ] ! ", e);
			throw new ControllerException(e.getMessage());
		}
		
	}
	
	
}
