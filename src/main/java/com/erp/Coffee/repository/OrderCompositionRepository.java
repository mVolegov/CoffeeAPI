package com.erp.Coffee.repository;

import com.erp.Coffee.model.OrderComposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCompositionRepository extends JpaRepository<OrderComposition, Long> {
}
