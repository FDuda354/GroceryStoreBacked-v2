package com.example.demo.repository;

import com.example.demo.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);

    @Query(value = "SELECT * FROM users AS u " +
            "INNER JOIN baskets b on b.id = u.basket_id " +
            "INNER JOIN orders o on b.id = o.basket_id " +
            "INNER JOIN products_db pd on o.product_id = pd.id " +
            "WHERE pd.name = :productName", nativeQuery = true)
    List<AppUser> findAllUsersByProducts(@Param("productName") String productName);

    boolean existsByUsername(String username);
}
