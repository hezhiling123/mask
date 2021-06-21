package cn.hezhiling.mask.productService.aop;

import cn.hezhiling.mask.productService.dbutils.DBContextHolder;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {
    /*从库的切点,没有标注Master注解，并且方法名为select和get开头的方法，走从库*/
    @Pointcut("!@annotation(cn.hezhiling.mask.productService.annotation.Master) " +
            "&& (execution(* cn.hezhiling.mask.productService.service.impl..*.select*(..)) " +
            "|| execution(* cn.hezhiling.mask.productService.service.impl..*.get*(..))" +
            "|| execution(* cn.hezhiling.mask.productService.service.impl..*.find*(..))" +
            "|| execution(* cn.hezhiling.mask.productService.service.impl..*.query*(..)))"+
            "|| execution(* cn.hezhiling.mask.productService.service.impl..*.list*(..)))")
    public void slavePointcut() {

    }

    /*主库的切点,或者标注了Master注解或者方法名为insert、update等开头的方法，走主库*/
    @Pointcut("@annotation(cn.hezhiling.mask.productService.annotation.Master) " +
            "|| execution(* cn.hezhiling.mask.productService.service.impl..*.insert*(..)) " +
            "|| execution(* cn.hezhiling.mask.productService.service.impl..*.add*(..)) " +
            "|| execution(* cn.hezhiling.mask.productService.service.impl..*.update*(..)) " +
            "|| execution(* cn.hezhiling.mask.productService.service.impl..*.edit*(..)) " +
            "|| execution(* cn.hezhiling.mask.productService.service.impl..*.delete*(..)) " +
            "|| execution(* cn.hezhiling.mask.productService.service.impl..*.remove*(..))")
    public void masterPointcut() {
    }

    @Before("slavePointcut()")
    public void slave() {
        DBContextHolder.master();
    }

    @Before("masterPointcut()")
    public void master() {
        DBContextHolder.master();
    }

    @After("slavePointcut()")
    public void completeSlave(){
        DBContextHolder.remove();
    }

    @After("masterPointcut()")
    public void completeMaster(){
        DBContextHolder.remove();
    }
}
