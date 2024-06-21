package com.example.unesso.services;

import com.example.unesso.model.Usuario;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de user en el sistema.
 */
public interface UsuarioService {
    Usuario findByCorreo(String correo);
    void saveUsuario(Usuario usuario);
}
