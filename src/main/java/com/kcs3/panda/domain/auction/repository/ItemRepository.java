package com.kcs3.panda.domain.auction.repository;

import com.kcs3.panda.domain.auction.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
