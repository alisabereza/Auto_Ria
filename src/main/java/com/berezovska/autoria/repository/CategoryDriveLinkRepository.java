package com.berezovska.autoria.repository;

import com.berezovska.autoria.model.Drive;
import com.berezovska.autoria.model.linking.CategoryDriveLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryDriveLinkRepository extends JpaRepository<CategoryDriveLink, Integer> {
    Optional<Drive> findAllById (int DriveId);
}
