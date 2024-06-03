package com.example.unesso.services;

import com.example.unesso.model.Usuario;

/**
 * Description: Interfaz de operaciones relacionadas con la gestión de usuario en el sistema.
 */
public interface IUsuarioService {
	Usuario buscarPorCorreo(String correo);
}
