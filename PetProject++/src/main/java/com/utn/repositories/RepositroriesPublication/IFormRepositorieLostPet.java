package com.utn.repositories.RepositroriesPublication;

import com.utn.models.MascotaPerdida.FormLostPet;

public interface IFormRepositorieLostPet {
    public Iterable<FormLostPet> GetForms();

    public FormLostPet GetFormsById (Integer id);

    public FormLostPet CreateForms (FormLostPet publication);

    //public FormularioMascotaPerdida UpdateForms (FormularioMascotaPerdida publication, Integer id);

    public void DeleteForms (Integer id);
}
