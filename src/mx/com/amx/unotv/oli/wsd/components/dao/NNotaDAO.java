/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.components.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import mx.com.amx.unotv.oli.wsd.components.dao.exception.NNotaDAOException;
import mx.com.amx.unotv.oli.wsd.components.model.NNota;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class NNotaDAO {
	private static Logger logger = Logger.getLogger(NNotaDAO.class);
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public List<NNota> lastNotesNotInINotaMagazine(int limit) throws NNotaDAOException{
		logger.debug(" --- lastNotesNotInINotaMagazine  [ NNotaDAO ]  --- ");
		logger.debug(" ---  limit : "+limit+"  --- ");
		
		List<NNota> lista = null;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT * FROM oli_mx_n_nota ");
		query.append(" WHERE FC_ID_CONTENIDO NOT IN (SELECT FC_ID_CONTENIDO FROM oli_mx_i_nota_magazine) ");
		query.append(" ORDER BY FD_FECHA_PUBLICACION DESC ");
		query.append(" LIMIT "+limit+" ");
	
		
		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<NNota>(NNota.class));

		} catch (Exception e) {
			logger.error(" ¡ Error lastNotesNotInINotaMagazine  [ NNotaDAO ] ! ", e);
			logger.error(" query : "+ query);
			throw new NNotaDAOException(e.getMessage());
		}
		
		return lista ;
	}
	
	// LastNotesFindByIdCategoriaLimit
	
	public List<NNota> lastNotesFindByIdCategoriaLimit(String idCategoria , int limit) throws NNotaDAOException{
		logger.debug(" --- lastNotesFindByIdCategoriaLimit  [ NNotaDAO ]  --- ");
		logger.debug(" ---  limit : "+limit+"  --- ");
		logger.debug(" ---  idCategoria : "+idCategoria+"  --- ");
		
		List<NNota> lista = null;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT * FROM oli_mx_n_nota");
		query.append(" WHERE FC_ID_CATEGORIA = '"+idCategoria+"' ");
		query.append(" ORDER BY FD_FECHA_PUBLICACION DESC ");
		query.append(" LIMIT "+limit+" ");
	
		
		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<NNota>(NNota.class));

		} catch (Exception e) {
			logger.error(" ¡ Error lastNotesFindByIdCategoriaLimit  [ NNotaDAO ] ! ", e);
			logger.error(" query : "+ query);
			throw new NNotaDAOException(e.getMessage());
		}
		
		return lista ;
	}

}
