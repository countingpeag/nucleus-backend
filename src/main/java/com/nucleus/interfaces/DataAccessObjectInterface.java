package com.nucleus.interfaces;

import java.util.List;

public interface DataAccessObjectInterface<ModelObject> {
	
	//Metodo para almacenar en DB 
	public boolean create(ModelObject obj);
	
	//Metodo para borrar de DB
	public boolean delete(ModelObject obj);
	
	//Metodo para actualizar en DB
	public boolean update(ModelObject obj);
	
	//Metodo para leer un solo registro de DB
	public ModelObject read(ModelObject obj);
	
	//Metodo para leer un conjunto de registros de DB
	public List<ModelObject> readAll();
	
}
