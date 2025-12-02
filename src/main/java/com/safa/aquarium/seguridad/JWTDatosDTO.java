package com.safa.aquarium.seguridad;
import com.safa.aquarium.modelos.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JWTDatosDTO {
    private String mailUsuario;
    private Rol rol;
    private String fechaCreacion;
    private String fechaExpiracion;

}
