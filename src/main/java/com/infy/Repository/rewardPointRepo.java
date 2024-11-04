package com.infy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.Entity.RewardPoint;

@Repository
public interface rewardPointRepo extends JpaRepository<RewardPoint, Integer> {

		List<RewardPoint> findByCustId(Integer id);
}
