package com.traning.bugtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traning.bugtracker.entity.Bug;

@Repository
public interface BugRepository extends JpaRepository<Bug, Long>{

}
