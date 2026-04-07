package com.anuj.service;

import com.anuj.entity.Hospital;
import com.anuj.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    @Override
    public Hospital saveHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital getHospitalById(Integer id) {
        return hospitalRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteHospital(Integer id) {
        hospitalRepository.deleteById(id);
    }
}