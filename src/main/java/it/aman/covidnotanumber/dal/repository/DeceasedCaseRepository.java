package it.aman.covidnotanumber.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.aman.covidnotanumber.dal.entity.Deceased;

@Repository
public interface DeceasedCaseRepository extends JpaRepository<Deceased, Integer> {
}
