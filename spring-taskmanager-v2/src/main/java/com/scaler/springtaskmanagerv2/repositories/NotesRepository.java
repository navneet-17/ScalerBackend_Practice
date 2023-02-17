package com.scaler.springtaskmanagerv2.repositories;
import com.scaler.springtaskmanagerv2.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<NoteEntity,Integer>{
}
