package com.safa.aquarium.seguridad;


import com.safa.aquarium.modelos.Rol;
import com.safa.aquarium.modelos.Usuario;
import com.safa.aquarium.servicios.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class JWTService {


    @Value("${application.security.jwt.secret-key}")
    private String secretKey;


    @Autowired
    private UsuarioService usuarioService;



    /**
     * Método para generar token de acceso a través de los datos
     * de un usuario
     *
     * @param usuario
     * @return
     */
    public String generateToken(Usuario usuario) {
        JWTDatosDTO datos = JWTDatosDTO.builder()
                .mailUsuario(usuario.getMail())
                .rol(usuario.getRol())
                .fechaCreacion(LocalDateTime.now().toString())
                .fechaExpiracion(LocalDateTime.now().plusHours(2).toString())
                .build();

        return Jwts
                .builder()
                .claim("datos",datos)
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Claims extractDatosToken(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    public JWTDatosDTO extractTokenData(String token) {
        Claims claims = extractDatosToken(token);
        Map<String, Object> mapa = (Map<String, Object>) claims.get("datos");
        return JWTDatosDTO.builder()
                .mailUsuario((String) mapa.get("mailUsuario"))
                .fechaCreacion((String) mapa.get("fechaCreacion"))
                .fechaExpiracion((String) mapa.get("fechaExpiracion"))
                .rol(Rol.valueOf((String) mapa.get("rol")))
                .build();
    }


    public Usuario extraerUsuarioToken(String token) {
        String tokenSinCabecera = token.substring(7);
        JWTDatosDTO tokenDataDTO = extractTokenData(tokenSinCabecera);
        return (Usuario) usuarioService.loadUserByUsername(tokenDataDTO.getMailUsuario());
    }


    /**
     * Método que me dice si el token a expirado
     *
     * @param token
     * @return
     */
    public boolean isExpired(String token) {
        return LocalDateTime.parse(extractTokenData(token).getFechaExpiracion()).isBefore(LocalDateTime.now());
    }




    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }



}
