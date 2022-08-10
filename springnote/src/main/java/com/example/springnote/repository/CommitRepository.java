package com.example.springnote.repository;

import com.example.springnote.model.Commit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitRepository extends JpaRepository<Commit, Long> {
}
