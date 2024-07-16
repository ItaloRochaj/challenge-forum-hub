package com.forum_hub.factory;

import com.forum_hub.domain.Topico;

import java.time.LocalDateTime;
import java.time.Month;

public class TopicoFactory {

    public static Topico criaTopicoCompleto() {
        return new Topico(
                1L,
                "Titulo do post",
                "Mensagem sobre o topico...",
                LocalDateTime.of(2024, Month.JULY, 2, 10, 30),
                (short) 1,
                "Autor do Topico",
                "Curso do topico"
        );
    }

    public static Topico criaTopicoInvalido() {
        return new Topico(
                1L,
                "",
                "Mensagem sobre o topico...",
                LocalDateTime.of(2024, Month.JULY, 2, 10, 30),
                (short) 1,
                "Autor do Topico",
                "Curso do topico"
        );
    }
}