package pe.edu.cibertec.integrantes_backend_prj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.integrantes_backend_prj.dto.LoginRequestDTO;
import pe.edu.cibertec.integrantes_backend_prj.dto.LoginResponseDTO;
import pe.edu.cibertec.integrantes_backend_prj.service.AuthService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@RestController//Permite hacer el llamado como un servicio
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    //Login
    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequest) {
        try{
            //Enviamos el request para retornar datos y almacenarlos
            String[] datosAlumno = authService.checkAlumno(loginRequest);
            System.out.println("Resultado:" + Arrays.toString(datosAlumno));
            //
            if (datosAlumno == null) {
                return new LoginResponseDTO("01", "ERROR: Alumno no encontrado", "");
            }
            //
            return new LoginResponseDTO("00", "Alumno Encontrado", datosAlumno[2]);
        }catch (IOException e) {
            return new LoginResponseDTO("99", "ERROR: Ocurrió un problema =>" + e.getMessage(), "");
        }
    }

    @GetMapping("/integrantes")
    public ArrayList<String> getIntegrantes() {
        try{
            ArrayList<String> datosAlumno = authService.listarAlumnos();

            if (datosAlumno == null) {
                return null;
            }
            return datosAlumno;
        }catch (IOException e) {
            return null;
        }
    }

}
