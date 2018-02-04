package south.girl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import south.girl.properties.GirlProperties;

/**
 * Created by zhang_w on 2018/2/3.
 */
@RestController
public class CupSizeController {

    @Value("${cupSize}")
    private String cupSize;

    @Autowired
    private GirlProperties properties;

    @RequestMapping(value = "/cup",method = RequestMethod.GET)
    public String cup(){
        return cupSize;
    }


    @RequestMapping(value = "/girlProperties",method = RequestMethod.GET)
    public String getGirl(){
        return String.format("%S_%S",properties.getCupSize(),properties.getAge());
    }
}
