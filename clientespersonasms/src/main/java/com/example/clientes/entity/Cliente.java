package com.example.clientes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
public class Cliente extends Persona {

    @Column(unique = true)
    private String clienteId;
    private String contrasena;
    private Boolean estado;

    public Cliente(String nombre, String genero, Integer edad, String identificacion,
                   String direccion, String telefono, String clienteId, String contrasena, Boolean estado) {
        this.setNombre(nombre);
        this.setGenero(genero);
        this.setEdad(edad);
        this.setIdentificacion(identificacion);
        this.setDireccion(direccion);
        this.setTelefono(telefono);
        this.clienteId = clienteId;
        this.contrasena = contrasena;
        this.estado = estado;
    }
}
