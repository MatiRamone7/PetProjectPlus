package com.utn.repositories.RepositroriesPublication;

import com.utn.models.IntencionAdoptar.FormAdopt;

public interface IFormRepositorieAdopt {
    public Iterable<FormAdopt> GetForms();

    public FormAdopt GetFormsById(Integer id);

    public FormAdopt CreateForms (FormAdopt publication);

    //public FormularioAdoptar UpdateForms (FormularioAdoptar publication, Integer id); TODO: ¿Es necesario actualizar un formulario de adopcion?

    public void DeleteForms (Integer id);
}
