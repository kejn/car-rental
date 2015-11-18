package pl.wroc.edu.jpa.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.wroc.edu.model.entity.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity, BigDecimal> {
}