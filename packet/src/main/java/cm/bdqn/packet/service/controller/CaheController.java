package cm.bdqn.packet.service.controller;

import cm.bdqn.packet.domain.BookQry;
import cm.bdqn.packet.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class CaheController {
    @Autowired
    private AbstractService abstractService;
    @RequestMapping("/cahe")
    @ResponseBody
    public Object object(){
        System.out.println(abstractService.queryBookCacheable(1+""));
        System.out.println(abstractService.queryBookCacheable_2("2"));;
        abstractService.queryBookCacheableUseMyKeyGenerator("3");
        abstractService.queryBookCacheableByBookQry(new BookQry("4","name_1"));
        return abstractService.queryBookCacheable(1+"");
    }
}
