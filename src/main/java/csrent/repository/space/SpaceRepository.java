package csrent.repository.space;

import csrent.model.space.Space;
import csrent.repository.genericCRUD.CRUDMemory;
import org.springframework.stereotype.Repository;

@Repository
public class SpaceRepository extends CRUDMemory<Space> {

    public SpaceRepository(){
        data.add(new Space(1, "Grabación IN",122,"Cabina de grabación"));
        data.add(new Space(2, "TV Group",100,"Estudio de televisión"));
        data.add(new Space(3, "Ballet Vero",50,"Salón de ballet"));
        data.add(new Space(4, "Música Quiñones",50,"Estudio de música"));
    }

    // Se realiza con .isEmpty, porque solo de esta manera funciona, con !=null no
    @Override
    public Space edit(Space space) {

        for (Space element: data){
            if (element.getId().intValue()==space.getId().intValue()){
                if (!space.getName().isEmpty()){
                    element.setName(space.getName());
                }
                if (space.getCapacity()!=0) {//Igual que aquí, si lo hago con !=null, se actualiza a 0 siempre
                    element.setCapacity(space.getCapacity());
                }
                if (!space.getType().isEmpty()){
                    element.setType(space.getType());
                }
                return element;
            }
        }
        return new Space();
    }
}
