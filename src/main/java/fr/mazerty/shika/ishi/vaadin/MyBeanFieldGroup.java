package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import javaslang.control.Try;

public class MyBeanFieldGroup<T> extends BeanFieldGroup<T> {

    public MyBeanFieldGroup(Class<T> beanType) {
        super(beanType);
        setBuffered(false);

        Try.of(beanType::newInstance)
                .andThen(this::setItemDataSource);
    }

    public T getBean() {
        return getItemDataSource().getBean();
    }

}
