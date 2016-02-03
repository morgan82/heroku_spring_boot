package com.globallogic.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.orders.domain.Order;

/**
 * Spring Data JPA repository for the Guest entity.
 * @author facundo.ferro
 */
public interface OrderRepository extends JpaRepository<Order,String> {

	/*
	 * Al heredar de JPARepository obtenemos métodos para hacer CRUD.
	 * Ejemplos: findAll(),save()
	 * Estos métodos no hace falta ponerlos en el Servicio, dado que la implementación es propia de JPARepository.
	 */
//    void findById(String id);
	
    							/********** SELECT *************/
	@Query("select o from Order o where o.userId = :idusuario")
	Order obtenerOrdenPorUserId(@Param("idusuario") String id);
	
	@Query(value = "select * from Orders o where o.user_id = :idusuario", nativeQuery = true)	// USANDO SQL (nativeQuery = true)
	Order obtenerOrdenPorUserIdQueryNativa(@Param("idusuario") String id);
	
	
	
								/********** UPDATE *************/
	@Modifying
	@Query("update Order o set o.userId = :iduser where o.id = :idorder ")
	void updateUserIdByOrderId(@Param("iduser") String idusuario,@Param("idorder") String idorden);
	
	@Modifying
	@Query(value = "update Orders set user_id = ?1 where id = ?2", nativeQuery = true)    // USANDO SQL (nativeQuery = true)
	void updateUserIdByOrderIdNative(String idusuario, String idorden);
	
	
	
								/********** DELETE *************/
	@Modifying
    @Transactional
    @Query("delete from Order o where o.userId = ?1")
    void deleteOrderByUserId(String iduser);
	
	
	
	
}
