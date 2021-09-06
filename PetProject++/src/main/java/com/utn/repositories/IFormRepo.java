package com.utn.repositories;


import com.utn.models.forms.FormularioDarEnAdopcion;
import com.utn.models.forms.FormularioIntencionAdopcion;
import com.utn.models.forms.FormularioMascotaEncontrada;
import com.utn.models.forms.FormularioMascotaPerdida;

public interface IFormRepo {

    /*
        Form Mascota Perdida
    */

    public Iterable<FormularioMascotaPerdida> GetFormsMascotaPerdida();

    public FormularioMascotaPerdida GetFormMascotaPerdidaById(Integer id);

    public FormularioMascotaPerdida CreateFormMascotaPerdida(FormularioMascotaPerdida form);

    public FormularioMascotaPerdida UpdateFormMascotaPerdida(FormularioMascotaPerdida form, Integer id);

    public void DeleteFormMascotaPerdida(Integer id);


    /*
        Form Mascota Encontrada
    */

    public Iterable<FormularioMascotaEncontrada> GetFormsMascotaEncontrada();

    public FormularioMascotaEncontrada GetFormMascotaEncontradaById(Integer id);

    public FormularioMascotaEncontrada CreateFormMascotaEncontrada(FormularioMascotaEncontrada form);

    public FormularioMascotaEncontrada UpdateFormMascotaEncontrada(FormularioMascotaEncontrada form, Integer id);

    public void DeleteFormMascotaEncontrada(Integer id);


    /*
        Form Intencion Adopcion
    */

    public Iterable<FormularioIntencionAdopcion> GetFormsIntencionAdopcion();

    public FormularioIntencionAdopcion GetFormIntencionAdopcionById(Integer id);

    public FormularioIntencionAdopcion CreateFormIntencionAdopcion(FormularioIntencionAdopcion form);

    public FormularioIntencionAdopcion UpdateFormIntencionAdopcion(FormularioIntencionAdopcion form, Integer id);

    public void DeleteFormIntencionAdopcion(Integer id);

    /*
        Form Dar Adopcion
    */
    public Iterable<FormularioDarEnAdopcion> GetFormsDarEnAdopcion();

    public FormularioDarEnAdopcion GetFormDarEnAdopcionById(Integer id);

    public FormularioDarEnAdopcion CreateFormDarEnAdopcion(FormularioDarEnAdopcion form);

    public FormularioDarEnAdopcion UpdateFormDarEnAdopcion(FormularioDarEnAdopcion form, Integer id);

    public void DeleteFormDarEnAdopcion(Integer id);
}
