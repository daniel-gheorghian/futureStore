package com.mind.training.futureStore.cart.repository;

import com.mind.training.futureStore.cart.entity.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * more at https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
 * more at https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 */
public interface CartRepository extends CrudRepository<Cart, Long>
{
    Optional<Cart> findById( Long id );

    List<Cart> findByStatus( String status );

    List<Cart> findByAccountCodeAndStoreLikeOrderByStoreAsc( String accountCode, String store );
}