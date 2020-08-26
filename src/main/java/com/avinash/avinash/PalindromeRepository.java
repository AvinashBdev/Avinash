package com.avinash.avinash;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalindromeRepository extends CrudRepository<PalindromeDB, String> {
}
