package com.utn.transithomes;

import java.util.List;

public class HogarDeTransito {
    private AdapterRefugios adapter = AdapterApiRestHogaresDeTransito.getInstancia();

    public List<Hogar> hogaresTransito(){
        return adapter.obtenerHogaresTransito();
    }
}
