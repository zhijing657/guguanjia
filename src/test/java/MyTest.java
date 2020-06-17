import cn.zhijing.config.SpringMybatis;
import cn.zhijing.entity.User;
import cn.zhijing.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatis.class)
public class MyTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testMapper(){
        List<User> all = userMapper.findAll();
        System.out.println(all);
    }
}
