package com.lego.care4you.repository;


import com.lego.care4you.domain.RegistryCarSold;
import com.lego.care4you.repository.bootstrap.GenericRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Alan.
 */
@Deprecated
public interface RegistryCarSoldRepository extends GenericRepository<RegistryCarSold> {

    @Query("{ 'seller.id' : ?0 }")
    RegistryCarSold findRegistriesBySeller(String id);

}
