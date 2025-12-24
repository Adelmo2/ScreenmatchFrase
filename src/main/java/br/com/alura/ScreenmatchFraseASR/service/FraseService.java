package br.com.alura.ScreenmatchFraseASR.service;

import br.com.alura.ScreenmatchFraseASR.dto.FraseDTO;
import br.com.alura.ScreenmatchFraseASR.model.Frase;
import br.com.alura.ScreenmatchFraseASR.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraseService {

    @Autowired
    private FraseRepository repositorio;

    public Long atualId = 0L;

    public Long ultimoId = 0L;

    public FraseDTO obterFrase() {

        List<Frase> frase2 = repositorio.findTop1ByOrderByIdDesc();
        frase2.forEach(s -> ultimoId = s.getId());

        while (atualId <= (ultimoId + 1)) {
            atualId += 1L;
            if (atualId == (ultimoId + 1)) atualId = 1L;

            System.out.println("Sequencia do ID: " + atualId + " Ultimo ID: = " + ultimoId);

            Frase frase = repositorio.obterFrase(atualId);
            if (frase.getId() == atualId) {
                return new FraseDTO(frase.getTitulo(), frase.getFrase(), frase.getPersonagem(), frase.getPoster());
            }
        }
        return null;
    }
}
