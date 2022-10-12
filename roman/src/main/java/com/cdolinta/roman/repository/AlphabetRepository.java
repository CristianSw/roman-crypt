package com.cdolinta.roman.repository;

import com.cdolinta.roman.model.Alphabet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlphabetRepository extends JpaRepository<Alphabet, Long> {
}
