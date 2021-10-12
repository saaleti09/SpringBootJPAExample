package com.aaleti.springbootjpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplexUserRepository extends JpaRepository<ComplexUser, UserKey> {

}
