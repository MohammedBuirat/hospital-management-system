package com.buirat.assignment1.repository;
import com.buirat.assignment1.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BillRepository extends JpaRepository<Bill, Integer> {
}