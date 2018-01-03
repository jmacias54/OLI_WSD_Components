/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.components.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import mx.com.amx.unotv.oli.wsd.components.dao.exception.INotaMagazineDAOExcepion;
import mx.com.amx.unotv.oli.wsd.components.model.INotaMagazine;




/**
 * @author Jesus A. Macias Benitez
 *
 */
public class INotaMagazineDAO {
	private static Logger logger = Logger.getLogger(INotaMagazineDAO.class);
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public List<INotaMagazine> findByIdMagazine(String idMagazine) throws INotaMagazineDAOExcepion{
		logger.debug(" --- findByIdMagazine  [ INotaMagazineDAO ]  --- ");
		logger.debug(" ---  IdMagazine : "+idMagazine+"  --- ");
		
		List<INotaMagazine> lista = null;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT * FROM oli_mx_i_nota_magazine");
		query.append(" WHERE FC_ID_MAGAZINE = '"+idMagazine+"'");
		query.append(" ORDER BY FI_ORDEN ASC ");
		
		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<INotaMagazine>(INotaMagazine.class));

		} catch (Exception e) {
			logger.error(" ¡ Error findByIdMagazine  [ INotaMagazineDAO ] ! ", e);
			logger.error(" query : "+ query);
			throw new INotaMagazineDAOExcepion(e.getMessage());
		}
		
		
		return lista ;
	}


}
