package cn.montaro.aria2.annotation;

import java.lang.annotation.*;

/**
 * Description:
 *
 * @author ZhangJiaYu
 * @date 2021/12/22
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aria2Method {
    /**
     * 调用的方法名称
     * 如 aria2.addUri aria2.listMethods
     * @return
     */
    String value();
}
