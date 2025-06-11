package geomedicos.modelo.service;

import java.util.List;

public interface IntGenericoService<E,ID> {
	
	List<E> findAll();
	E findById(ID claveId);
	E insertOne(E entity);
	int updateOne(E entity);
	int deleteOne(ID claveId);

}
