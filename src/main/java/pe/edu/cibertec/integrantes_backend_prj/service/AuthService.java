package pe.edu.cibertec.integrantes_backend_prj.service;

import pe.edu.cibertec.integrantes_backend_prj.dto.LoginRequestDTO;

import java.io.IOException;
import java.util.ArrayList;

public interface AuthService {

    //Firma de los métodos
    String[] checkAlumno(LoginRequestDTO loginRequestDTO) throws IOException;

    ArrayList<String> listarAlumnos() throws IOException;

}
