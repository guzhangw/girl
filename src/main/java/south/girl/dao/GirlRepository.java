package south.girl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import south.girl.entity.GirlEntity;

import java.util.List;

/**
 * Created by zhang_w on 2018/2/3.
 */
public interface GirlRepository extends JpaRepository<GirlEntity,Integer> {
    List<GirlEntity> findByAge(Integer age);
}
