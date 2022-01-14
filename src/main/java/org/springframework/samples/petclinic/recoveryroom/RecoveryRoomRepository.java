package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer> {
    List<RecoveryRoom> findAll();
    
    
    @Query("SELECT DISTINCT rt FROM RecoveryRoomType rt")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    
    
    
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
    
    @Query("SELECT DISTINCT rt FROM RecoveryRoomType rt WHERE rt.name LIKE :name")
    RecoveryRoomType getRecoveryRoomType(@Param("name") String name);
    
    @Query("SELECT DISTINCT r FROM RecoveryRoom r WHERE r.size > :size")
    List<RecoveryRoom> findBySizeMoreThan(@Param("size") double size);
}
