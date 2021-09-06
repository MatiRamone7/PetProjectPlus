package com.utn.services;

import com.utn.models.forms.FormularioMascotaPerdida;

public interface IFormService {
    /*
        Form Mascota Perdida
    */
    public Iterable<FormularioMascotaPerdida> GetFormsMascotaPerdida();

    public FormularioMascotaPerdida GetFormMascotaPerdidaById(Integer id);

    public FormularioMascotaPerdida CreateFormMascotaPerdida(FormularioMascotaPerdida form);

    public FormularioMascotaPerdida UpdateFormMascotaPerdida(FormularioMascotaPerdida form, Integer id);

    public void DeleteFormMascotaPerdida(Integer id);

    /*
        Form FormularioMascotaPerdida Encontrada
    */

    /*
        Form Intencion Adopcion
    */

    /*
        Form Dar Adopcion
    */
}
