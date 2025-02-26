package es.vedruna.appVedruna.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        try {
            if (destinatario == null || destinatario.trim().isEmpty()) {
                throw new IllegalArgumentException("El destinatario del correo no puede estar vacío.");
            }

            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(destinatario); 
            email.setSubject(asunto);
            email.setText(mensaje);

            mailSender.send(email);
            System.out.println("Correo enviado exitosamente a " + destinatario);

        } catch (Exception e) {
            System.err.println("Error enviando el correo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}