package com.utn.services;

import com.utn.models.Ong;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IOngService {
    public Ong Create (Ong ong) throws IOException;

}
