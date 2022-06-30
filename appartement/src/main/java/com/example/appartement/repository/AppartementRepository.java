/**
 * 
 */
package com.example.appartement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.appartement.model.Appartement;

/**
 * @author User
 *
 */
@Repository
public interface AppartementRepository extends MongoRepository<Appartement, String> {

}
