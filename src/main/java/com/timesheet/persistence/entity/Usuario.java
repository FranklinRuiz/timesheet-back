package com.timesheet.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.timesheet.utils.Auditoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario extends Auditoria<String> {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String usuario;
    @JsonIgnore
    private String password;
    private String area;
    private boolean estado;
    private String nombre;
    private String correo;

    @ManyToMany
    @JoinTable(
            name="usuario_roles",
            joinColumns = {@JoinColumn(name = "id_usuario",referencedColumnName = "id_usuario")},
            inverseJoinColumns = {@JoinColumn(name = "id_rol",referencedColumnName = "id_rol")}
    )
    private Set<Authority> authorities;
}
