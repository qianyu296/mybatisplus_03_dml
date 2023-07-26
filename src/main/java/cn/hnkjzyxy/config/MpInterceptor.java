package cn.hnkjzyxy.config;


import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MpInterceptor {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mpi = new MybatisPlusInterceptor();
        // 添加version的拦截器,也就是乐观锁
        mpi.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return mpi;
    }
}
