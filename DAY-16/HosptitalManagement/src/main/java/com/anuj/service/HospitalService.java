package com.anuj.service;

import com.anuj.entity.Hospital;
import java.util.List;

public interface HospitalService {
    Hospital saveHospital(Hospital hospital);
    List<Hospital> getAllHospitals();
    Hospital getHospitalById(Integer id);
    void deleteHospital(Integer id);
}