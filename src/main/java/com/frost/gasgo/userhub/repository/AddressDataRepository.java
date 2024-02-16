package com.frost.gasgo.userhub.repository;

import com.frost.gasgo.userhub.entity.AddressData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressDataRepository extends JpaRepository<AddressData,Long> {
}
