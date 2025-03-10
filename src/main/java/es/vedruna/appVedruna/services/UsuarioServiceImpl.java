package es.vedruna.appVedruna.services;

import es.vedruna.appVedruna.model.Usuario;
import es.vedruna.appVedruna.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Crear un nuevo usuario
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Obtener todos los usuarios
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioByUserId(String userId) {
        // Cambiamos findById por findByUserId que es el nuevo método
        return usuarioRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con userId: " + userId));
    }
}
