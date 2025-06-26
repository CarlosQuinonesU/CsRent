package csrent.service.space;

import csrent.model.space.Space;
import csrent.repository.space.SpaceJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceService {
    @Autowired
    SpaceJpaRepository repository;

    public List<Space> getAll(){return repository.findAll();}
    public Space add (Space space){

        return repository.save(space);
    }
    public Space update (Space space){
        Optional <Space> existingSpace= repository.findById(space.getId());
        if (existingSpace.isPresent()) {
            Space spaceDB=existingSpace.get();
            spaceDB.setName(space.getName());
            spaceDB.setCapacity(space.getCapacity());
            spaceDB.setType(space.getType());
           return repository.save(space);
        }
        return new Space();
    }
    public Space edit (Space space){
        Optional <Space> existingSpace= repository.findById(space.getId());
        if (existingSpace.isPresent()) {
            Space spaceDB= existingSpace.get();
            if (space.getName() != null) {
                spaceDB.setName(space.getName());
            }
            if (space.getCapacity() != null) {
                spaceDB.setCapacity(space.getCapacity());
            }
            if (space.getType() != null) {
                spaceDB.setType(space.getType());
            }
            return repository.save(spaceDB);
        }
        return space;
    }
    public Space delete (Integer id){
        Optional <Space> existingSpace= repository.findById(id);
        if (existingSpace.isPresent()){
            Space spaceDB=existingSpace.get();
            repository.delete(spaceDB);
            return spaceDB;
        }
        return new Space();
    }
    public boolean existsById(Integer id){
        return repository.existsById(id);
    }
    public boolean existsByName(String name){
        return repository.existsByName(name);
    }
    public Space search (Integer id){
        Optional<Space> space= repository.findById(id);
        if (space.isPresent()){
            Space spaceDB= space.get();
            return spaceDB;
        }
        return new Space();
    }

}
