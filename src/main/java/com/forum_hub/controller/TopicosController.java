package com.forum_hub.controller;

import com.forum_hub.domain.Topico;
import com.forum_hub.domain.dto.AtualizacaoTopicoRequest;
import com.forum_hub.domain.dto.CadastroTopicoRequest;
import com.forum_hub.domain.dto.DetalhesTopicoResponse;
import com.forum_hub.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroTopicoRequest request, UriComponentsBuilder uriComponentsBuilder) {
        var topico = service.cadastrarTopico(new Topico(request));

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesTopicoResponse(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DetalhesTopicoResponse>> listar(@PageableDefault(sort = {"dataCriacao"}) Pageable paginacao){
        var page = service.listarTopicos(paginacao).map(DetalhesTopicoResponse::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = service.detalharTopico(id);

        return ResponseEntity.ok(new DetalhesTopicoResponse(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoTopicoRequest request) {
        var topico = service.atualizarTopico(new Topico(request));

        return ResponseEntity.ok(new DetalhesTopicoResponse(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluirTopico(id);

        return ResponseEntity.noContent().build();
    }
}