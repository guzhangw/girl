package south.girl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import south.girl.dao.GirlRepository;
import south.girl.entity.GirlEntity;
import south.girl.exception.GirlException;

/**
 * Created by zhang_w on 2018/2/4.
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        GirlEntity girlEntity = new GirlEntity();
        girlEntity.setCupSize("F");
        girlEntity.setAge(18);
        girlRepository.save(girlEntity);

        GirlEntity girlEntity1 = new GirlEntity();
        girlEntity1.setCupSize("BBBB");
        girlEntity1.setAge(20);
        girlRepository.save(girlEntity);
    }



    public void getAge(Integer id) throws Exception{
        GirlEntity girlEntity = girlRepository.findOne(id);
        Integer age = girlEntity.getAge();

        if(age<10){
            //你还在上小学吧
            throw new GirlException(101,"你还在上小学吧");
        }else if(age>10&&age<16){
            //你还在上初中吧
            throw new GirlException(102,"你还在上初中吧");
        }

    }



}
