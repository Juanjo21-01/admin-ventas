package com.proyecto.ventas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyecto.ventas.models.comentariosModel;

public interface  comentariosRepository extends MongoRepository<comentariosModel, String> 
{
    
}
