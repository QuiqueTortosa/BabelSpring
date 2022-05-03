package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Titular;
import model.TitularPk;

public interface TitularDao extends JpaRepository<Titular, TitularPk>{

}
