package cn.hnkjzyxy;

import cn.hnkjzyxy.dao.UserDao;
import cn.hnkjzyxy.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Mybatisplus03DmlApplicationTests {
    @Autowired
    private UserDao userDao;
    @Test
    void testInsert() {
        User user = new User();
        user.setId(null);
        user.setName("王俊凯");
        user.setPassword(null);
        user.setEmail("wjk@qq.com");
        user.setBirthday("2004-02-18");
        userDao.insert(user);
    }
    @Test
    void testDeleteBatchIds(){
        List<User> list = new ArrayList<>();
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        u1.setId(8);
        u2.setId(9);
        u3.setId(19);
        list.add(u1);
        list.add(u2);
        list.add(u3);
        // 根据多个id删除,传递参数为list集合
        System.out.println(userDao.deleteBatchIds(list));
    }
    @Test
    void testDelete(){
        User u = new User();
        u.setId(2);
        System.out.println(userDao.deleteById(2));
    }
    @Test
    void testUpdate(){
        // 乐观锁 version
        User u1 = userDao.selectById(3);
        User u2 = userDao.selectById(3);
        // 乐观锁在同一时间内,只有第一个下单付款成功的才能够抢到,也就是修改成功
        u1.setName("木木1");
        u2.setName("何玉明1");
        System.out.println(userDao.updateById(u1));
        System.out.println(userDao.updateById(u2));
    }
    @Test
    void testSelect(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.lambda().between(User::getId,4,6);
        System.out.println(userDao.selectList(qw));
    }
    @Test
    void testSelectOne(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        System.out.println(userDao.selectById(3));
    }
    @Test
    void testEquals(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.lambda().eq(User::getName,"木木1");
        System.out.println(userDao.selectOne(qw));
    }
    @Test
    void testBetween(){
        QueryWrapper<User> lqw = new QueryWrapper<>();
        lqw.between("id",1,4);
        System.out.println(userDao.selectList(lqw));
    }

}
