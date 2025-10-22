package com.polimet.museo.dto;

import lombok.Data;

@Data
public class VotoRequest {
    private Integer idUsuario;
    private Integer puntaje;
    private String comentario;
}
