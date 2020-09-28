package com.bookmyshow.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmyshow.restapi.model.BookRequest;

@Repository
public interface BookMyShowRepository extends JpaRepository<BookRequest, Integer> {

}
