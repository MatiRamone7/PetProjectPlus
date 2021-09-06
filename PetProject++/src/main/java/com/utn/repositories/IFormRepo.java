package com.utn.repositories;


import com.utn.models.forms.FormularioMascotaPerdida;

public interface IFormRepo {

    /*
        Form Mascota Perdida
    */

    public Iterable<FormularioMascotaPerdida> GetFormsMascotaPerdida();

    public FormularioMascotaPerdida GetFormMascotaPerdidaById(Integer id);

    public FormularioMascotaPerdida CreateFormMascotaPerdida(FormularioMascotaPerdida pet);

    public FormularioMascotaPerdida UpdateFormMascotaPerdida(FormularioMascotaPerdida pet, Integer id);

    public void DeleteFormMascotaPerdida(Integer id);

    /*
        Form Mascota Encontrada
    */

    /*
        Form Intencion Adopcion
    */

    /*
        Form Dar Adopcion
    */
}
