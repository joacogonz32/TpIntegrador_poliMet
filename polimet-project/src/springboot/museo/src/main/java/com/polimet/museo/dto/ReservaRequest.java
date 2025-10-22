package com.polimet.museo.dto;

import lombok.Data;

@Data
public class ReservaRequest {
    private Integer idUsuario;
    private String fecha;
    private String hora;
    private Integer cantidadPersonas;
}
