package com.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.client.model.Entry;

public interface EntryRepo extends JpaRepository<Entry,String> {

}
