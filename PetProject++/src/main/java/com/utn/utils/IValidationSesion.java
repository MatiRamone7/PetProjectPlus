package com.utn.utils;

public interface IValidationSesion {
    String eliminarEspaciosConsecutivos(String sValue);

    SesionResponse validarLongitud(String pass);

    SesionResponse validarConListaNegra(String password);

    SesionResponse validarUsuarioYPassDistintos(String usuario, String pass );

    SesionResponse validarComplejidadContraseña(String pass);

    SesionResponse validarUsuarioyPass(String usuario, String pass);
}
