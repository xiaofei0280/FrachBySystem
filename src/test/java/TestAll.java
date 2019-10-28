import com.qf.dao.GoodsDao;
import com.qf.pojo.Goods;
import com.qf.pojo.User;
import com.qf.service.GoodsService;
import com.qf.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestAll {

    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsDao goodsDao;

    @Test
    public void  testlogin(){

        User user = userService.selectUserByName("小李");
        System.out.println(user);

    }


    @Test
    public void testGoodsList(){

        List<Goods> goods = goodsService.selectGoodsAll();
        for (Goods good : goods) {
            System.out.println(good);
        }
    }

    @Test
    public void testGoodsById(){
        Goods goods = goodsDao.findGoodsByid(5);
        System.out.println(goods);

    }
}
