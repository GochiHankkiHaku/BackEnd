package com.groom.groom.repository;

import com.groom.groom.domain.Market;
import com.groom.groom.domain.Matching;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, Integer> {
}
