package south.girl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import south.girl.dao.GirlRepository;
import south.girl.entity.GirlEntity;
import south.girl.entity.Result;
import south.girl.service.GirlService;
import south.girl.utils.ResultUtils;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by zhang_w on 2018/2/3.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<GirlEntity> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 查询根据年龄查女孩
     * @return
     */
    @GetMapping(value = "/girlsByge/{age}")
    public List<GirlEntity> girlList(@PathVariable(value = "age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 添加一个女孩
     * @param girlEntity
     * @return
     */
    @GetMapping(value = "/addGirl")
    public Result<GirlEntity> addGirl(@Valid GirlEntity girlEntity, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtils.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtils.success(girlRepository.save(girlEntity));
    }

    @GetMapping(value = "/girl/getAge/{id}")
    public void getAge(@PathVariable(value = "id") Integer id) throws Exception{
        girlService.getAge(id);
    }


}
