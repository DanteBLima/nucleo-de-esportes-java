package com.dante.nucleo_de_esportes_java.services;


import com.dante.nucleo_de_esportes_java.dto.TurmaRequestDto;
import com.dante.nucleo_de_esportes_java.dto.TurmaResponseDto;
import com.dante.nucleo_de_esportes_java.model.Local;
import com.dante.nucleo_de_esportes_java.model.Modalidade;
import com.dante.nucleo_de_esportes_java.model.Turma;
import com.dante.nucleo_de_esportes_java.repository.LocalRepository;
import com.dante.nucleo_de_esportes_java.repository.ModalidadeRepository;
import com.dante.nucleo_de_esportes_java.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private ModalidadeRepository modalidadeRepository;

    @Autowired
    private LocalRepository localRepository;

    public TurmaResponseDto registerTurma(TurmaRequestDto data) {

        if (data.limite_inscritos() > 30) {
            throw new IllegalArgumentException("Limite de inscritos não pode ser maior que 30");
        }

        Modalidade modalidade = modalidadeRepository.findById(data.modalidadeId()).orElseThrow(() -> new RuntimeException("Modalidade nao encontrada"));
        Local local = localRepository.findById(data.localId()).orElseThrow(() -> new RuntimeException("Local nao encontrado"));

        Turma newTurma = new Turma();

        newTurma.setLocal(local);
        newTurma.setModalidade(modalidade);
        newTurma.setDia_semana(data.dia_semana());
        newTurma.setLimite_inscritos(data.limite_inscritos());
        newTurma.setHorario_fim(data.horario_final());
        newTurma.setHorario_inicio(data.horario_inicio());


        Turma createdTurma = turmaRepository.save(newTurma);

        return new TurmaResponseDto(createdTurma.getId(),
                createdTurma.getHorario_inicio(),
                createdTurma.getHorario_fim(),
                createdTurma.getDia_semana(),
                createdTurma.getModalidade(),
                createdTurma.getLocal(),
                createdTurma.getLimite_inscritos());
    }
}