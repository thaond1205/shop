package com.shoponline.reposiitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoponline.entities.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{

}
