package com.forum_hub.factory;

import com.forum_hub.domain.Topico;
import com.forum_hub.domain.dto.CadastroTopicoRequest;

import java.time.LocalDateTime;

public class CadastroTopicoRequestFactory {

    public static CadastroTopicoRequest criaCadastroTopicoRequestCompleto() {
        return new CadastroTopicoRequest(
                "Titulo do post",
                "Mensagem sobre o topico...",
                "Autor do Topico",
                "Curso do topico"
        );
    }

    public static CadastroTopicoRequest criaCadastroTopicoRequestInvalido() {
        return new CadastroTopicoRequest(
                "",
                "Mensagem sobre o topico...",
                "Autor do Topico",
                "Curso do topico"
        );
    }
}