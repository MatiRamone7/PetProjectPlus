package com.utn.repositories.RepositroriesPublication;

import com.utn.models.DarEnAdopcion.FormGiveAdoption;

public interface IFormRepositorieGiveAdoption {
    public Iterable<FormGiveAdoption> GetForms();

    public FormGiveAdoption GetFormsById(Integer id);

    public FormGiveAdoption CreateForms (FormGiveAdoption publication);

    //public FormularioDarEnAdopcion UpdateForms (FormularioDarEnAdopcion publication, Integer id);

    public void DeleteForms (Integer id);
}
