package br.com.alura.ScreenmatchFraseASR.repository;

import br.com.alura.ScreenmatchFraseASR.model.Frase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FraseRepository extends JpaRepository<Frase, Long> {
    @Query("SELECT f FROM Frase f WHERE f.id = :id")
    Frase obterFrase(Long id);

    List<Frase> findTop1ByOrderByIdDesc();

}
